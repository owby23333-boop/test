package io.rx_cache2.internal.cache.memory.apache;

import io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractReferenceMap<K, V> extends AbstractHashedMap<K, V> {
    private ReferenceStrength keyType;
    private boolean purgeValues;
    private transient ReferenceQueue<Object> queue;
    private ReferenceStrength valueType;

    static class ReferenceBaseIterator<K, V> {
        K currentKey;
        V currentValue;
        ReferenceEntry<K, V> entry;
        int expectedModCount;
        int index;
        K nextKey;
        V nextValue;
        final AbstractReferenceMap<K, V> parent;
        ReferenceEntry<K, V> previous;

        public ReferenceBaseIterator(AbstractReferenceMap<K, V> abstractReferenceMap) {
            this.parent = abstractReferenceMap;
            this.index = abstractReferenceMap.size() != 0 ? abstractReferenceMap.data.length : 0;
            this.expectedModCount = abstractReferenceMap.modCount;
        }

        private void checkMod() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean nextNull() {
            return this.nextKey == null || this.nextValue == null;
        }

        protected ReferenceEntry<K, V> currentEntry() {
            checkMod();
            return this.previous;
        }

        public boolean hasNext() {
            checkMod();
            while (nextNull()) {
                ReferenceEntry<K, V> referenceEntry = this.entry;
                int i2 = this.index;
                while (referenceEntry == null && i2 > 0) {
                    i2--;
                    referenceEntry = (ReferenceEntry) this.parent.data[i2];
                }
                this.entry = referenceEntry;
                this.index = i2;
                if (referenceEntry == null) {
                    this.currentKey = null;
                    this.currentValue = null;
                    return false;
                }
                this.nextKey = referenceEntry.getKey();
                this.nextValue = referenceEntry.getValue();
                if (nextNull()) {
                    this.entry = this.entry.next();
                }
            }
            return true;
        }

        protected ReferenceEntry<K, V> nextEntry() {
            checkMod();
            if (nextNull() && !hasNext()) {
                throw new NoSuchElementException();
            }
            ReferenceEntry<K, V> referenceEntry = this.entry;
            this.previous = referenceEntry;
            this.entry = referenceEntry.next();
            this.currentKey = this.nextKey;
            this.currentValue = this.nextValue;
            this.nextKey = null;
            this.nextValue = null;
            return this.previous;
        }

        public void remove() {
            checkMod();
            if (this.previous == null) {
                throw new IllegalStateException();
            }
            this.parent.remove(this.currentKey);
            this.previous = null;
            this.currentKey = null;
            this.currentValue = null;
            this.expectedModCount = this.parent.modCount;
        }
    }

    protected static class ReferenceEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        private final AbstractReferenceMap<K, V> parent;

        public ReferenceEntry(AbstractReferenceMap<K, V> abstractReferenceMap, AbstractHashedMap.HashEntry<K, V> hashEntry, int i2, K k2, V v2) {
            super(hashEntry, i2, null, null);
            this.parent = abstractReferenceMap;
            this.key = toReference(((AbstractReferenceMap) abstractReferenceMap).keyType, k2, i2);
            this.value = toReference(((AbstractReferenceMap) abstractReferenceMap).valueType, v2, i2);
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return key != null && value != null && this.parent.isEqualKey(key, this.key) && this.parent.isEqualValue(value, getValue());
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap.HashEntry, java.util.Map.Entry, io.rx_cache2.internal.cache.memory.apache.KeyValue
        public K getKey() {
            return ((AbstractReferenceMap) this.parent).keyType == ReferenceStrength.HARD ? (K) this.key : (K) ((Reference) this.key).get();
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap.HashEntry, java.util.Map.Entry, io.rx_cache2.internal.cache.memory.apache.KeyValue
        public V getValue() {
            return ((AbstractReferenceMap) this.parent).valueType == ReferenceStrength.HARD ? (V) this.value : (V) ((Reference) this.value).get();
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public int hashCode() {
            return this.parent.hashEntry(getKey(), getValue());
        }

        protected ReferenceEntry<K, V> next() {
            return (ReferenceEntry) this.next;
        }

        boolean purge(Reference<?> reference) {
            boolean z2 = true;
            if (!(((AbstractReferenceMap) this.parent).keyType != ReferenceStrength.HARD && this.key == reference) && (((AbstractReferenceMap) this.parent).valueType == ReferenceStrength.HARD || this.value != reference)) {
                z2 = false;
            }
            if (z2) {
                if (((AbstractReferenceMap) this.parent).keyType != ReferenceStrength.HARD) {
                    ((Reference) this.key).clear();
                }
                if (((AbstractReferenceMap) this.parent).valueType != ReferenceStrength.HARD) {
                    ((Reference) this.value).clear();
                } else if (((AbstractReferenceMap) this.parent).purgeValues) {
                    this.value = null;
                }
            }
            return z2;
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public V setValue(V v2) {
            V value = getValue();
            if (((AbstractReferenceMap) this.parent).valueType != ReferenceStrength.HARD) {
                ((Reference) this.value).clear();
            }
            this.value = toReference(((AbstractReferenceMap) this.parent).valueType, v2, this.hashCode);
            return value;
        }

        protected <T> Object toReference(ReferenceStrength referenceStrength, T t2, int i2) {
            if (referenceStrength == ReferenceStrength.HARD) {
                return t2;
            }
            if (referenceStrength == ReferenceStrength.SOFT) {
                return new SoftRef(i2, t2, ((AbstractReferenceMap) this.parent).queue);
            }
            if (referenceStrength == ReferenceStrength.WEAK) {
                return new WeakRef(i2, t2, ((AbstractReferenceMap) this.parent).queue);
            }
            throw new Error();
        }
    }

    static class ReferenceEntrySet<K, V> extends AbstractHashedMap.EntrySet<K, V> {
        protected ReferenceEntrySet(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Iterator<Map.Entry<K, V>> it = iterator();
            while (it.hasNext()) {
                arrayList.add(new DefaultMapEntry(it.next()));
            }
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static class ReferenceEntrySetIterator<K, V> extends ReferenceBaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        public ReferenceEntrySetIterator(AbstractReferenceMap<K, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    static class ReferenceKeySet<K> extends AbstractHashedMap.KeySet<K> {
        protected ReferenceKeySet(AbstractHashedMap<K, ?> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Iterator<K> it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static class ReferenceKeySetIterator<K> extends ReferenceBaseIterator<K, Object> implements Iterator<K> {
        ReferenceKeySetIterator(AbstractReferenceMap<K, ?> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    static class ReferenceMapIterator<K, V> extends ReferenceBaseIterator<K, V> implements MapIterator<K, V> {
        protected ReferenceMapIterator(AbstractReferenceMap<K, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.MapIterator
        public K getKey() {
            ReferenceEntry<K, V> referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry != null) {
                return referenceEntryCurrentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.MapIterator
        public V getValue() {
            ReferenceEntry<K, V> referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry != null) {
                return referenceEntryCurrentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.MapIterator, java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }

        @Override // io.rx_cache2.internal.cache.memory.apache.MapIterator
        public V setValue(V v2) {
            ReferenceEntry<K, V> referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry != null) {
                return referenceEntryCurrentEntry.setValue(v2);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    public enum ReferenceStrength {
        HARD(0),
        SOFT(1),
        WEAK(2);

        public final int value;

        ReferenceStrength(int i2) {
            this.value = i2;
        }

        public static ReferenceStrength resolve(int i2) {
            if (i2 == 0) {
                return HARD;
            }
            if (i2 == 1) {
                return SOFT;
            }
            if (i2 == 2) {
                return WEAK;
            }
            throw new IllegalArgumentException();
        }
    }

    static class ReferenceValues<V> extends AbstractHashedMap.Values<V> {
        protected ReferenceValues(AbstractHashedMap<?, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList(size());
            Iterator<V> it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return (T[]) arrayList.toArray(tArr);
        }
    }

    static class ReferenceValuesIterator<V> extends ReferenceBaseIterator<Object, V> implements Iterator<V> {
        ReferenceValuesIterator(AbstractReferenceMap<?, V> abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    static class SoftRef<T> extends SoftReference<T> {
        private final int hash;

        public SoftRef(int i2, T t2, ReferenceQueue<? super T> referenceQueue) {
            super(t2, referenceQueue);
            this.hash = i2;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    static class WeakRef<T> extends WeakReference<T> {
        private final int hash;

        public WeakRef(int i2, T t2, ReferenceQueue<? super T> referenceQueue) {
            super(t2, referenceQueue);
            this.hash = i2;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    protected AbstractReferenceMap() {
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Put
    public void clear() {
        super.clear();
        while (this.queue.poll() != null) {
        }
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public boolean containsKey(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry<K, V> entry = getEntry(obj);
        return (entry == null || entry.getValue() == null) ? false : true;
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public boolean containsValue(Object obj) {
        purgeBeforeRead();
        if (obj == null) {
            return false;
        }
        return super.containsValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i2, Object obj, Object obj2) {
        return createEntry((AbstractHashedMap.HashEntry<Object, Object>) hashEntry, i2, obj, obj2);
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        return new ReferenceEntrySetIterator(this);
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected Iterator<K> createKeySetIterator() {
        return new ReferenceKeySetIterator(this);
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected Iterator<V> createValuesIterator() {
        return new ReferenceValuesIterator(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.keyType = ReferenceStrength.resolve(objectInputStream.readInt());
        this.valueType = ReferenceStrength.resolve(objectInputStream.readInt());
        this.purgeValues = objectInputStream.readBoolean();
        this.loadFactor = objectInputStream.readFloat();
        int i2 = objectInputStream.readInt();
        init();
        this.data = new AbstractHashedMap.HashEntry[i2];
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                this.threshold = calculateThreshold(this.data.length, this.loadFactor);
                return;
            }
            put(object, objectInputStream.readObject());
        }
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.keyType.value);
        objectOutputStream.writeInt(this.valueType.value);
        objectOutputStream.writeBoolean(this.purgeValues);
        objectOutputStream.writeFloat(this.loadFactor);
        objectOutputStream.writeInt(this.data.length);
        MapIterator<K, V> mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
        objectOutputStream.writeObject(null);
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new ReferenceEntrySet(this);
        }
        return this.entrySet;
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public V get(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry<K, V> entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected AbstractHashedMap.HashEntry<K, V> getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        return super.getEntry(obj);
    }

    protected int hashEntry(Object obj, Object obj2) {
        return (obj == null ? 0 : obj.hashCode()) ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected void init() {
        this.queue = new ReferenceQueue<>();
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public boolean isEmpty() {
        purgeBeforeRead();
        return super.isEmpty();
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected boolean isEqualKey(Object obj, Object obj2) {
        if (this.keyType != ReferenceStrength.HARD) {
            obj2 = ((Reference) obj2).get();
        }
        return obj == obj2 || obj.equals(obj2);
    }

    protected boolean isKeyType(ReferenceStrength referenceStrength) {
        return this.keyType == referenceStrength;
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new ReferenceKeySet(this);
        }
        return this.keySet;
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, io.rx_cache2.internal.cache.memory.apache.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new ReferenceMapIterator(this);
    }

    protected void purge() {
        Reference<? extends Object> referencePoll = this.queue.poll();
        while (referencePoll != null) {
            purge(referencePoll);
            referencePoll = this.queue.poll();
        }
    }

    protected void purgeBeforeRead() {
        purge();
    }

    protected void purgeBeforeWrite() {
        purge();
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Put
    public V put(K k2, V v2) {
        if (k2 == null) {
            throw new NullPointerException("null keys not allowed");
        }
        if (v2 == null) {
            throw new NullPointerException("null values not allowed");
        }
        purgeBeforeWrite();
        return (V) super.put(k2, v2);
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        purgeBeforeWrite();
        return (V) super.remove(obj);
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public int size() {
        purgeBeforeRead();
        return super.size();
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap, java.util.AbstractMap, java.util.Map, io.rx_cache2.internal.cache.memory.apache.Get
    public Collection<V> values() {
        if (this.values == null) {
            this.values = new ReferenceValues(this);
        }
        return this.values;
    }

    protected AbstractReferenceMap(ReferenceStrength referenceStrength, ReferenceStrength referenceStrength2, int i2, float f2, boolean z2) {
        super(i2, f2);
        this.keyType = referenceStrength;
        this.valueType = referenceStrength2;
        this.purgeValues = z2;
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractHashedMap
    protected ReferenceEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i2, K k2, V v2) {
        return new ReferenceEntry<>(this, hashEntry, i2, k2, v2);
    }

    protected void purge(Reference<?> reference) {
        int iHashIndex = hashIndex(reference.hashCode(), this.data.length);
        AbstractHashedMap.HashEntry<K, V> hashEntry = this.data[iHashIndex];
        AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
        while (true) {
            AbstractHashedMap.HashEntry<K, V> hashEntry3 = hashEntry2;
            hashEntry2 = hashEntry;
            if (hashEntry2 == null) {
                return;
            }
            if (((ReferenceEntry) hashEntry2).purge(reference)) {
                if (hashEntry3 == null) {
                    this.data[iHashIndex] = hashEntry2.next;
                } else {
                    hashEntry3.next = hashEntry2.next;
                }
                this.size--;
                return;
            }
            hashEntry = hashEntry2.next;
        }
    }
}
