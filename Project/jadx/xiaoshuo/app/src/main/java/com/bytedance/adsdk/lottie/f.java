package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class f<K, V> {
    f<K, V>.bf bf;

    public final class bf implements Set<K> {
        public bf() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return f.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return f.e(f.this.bf(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.e(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iE = f.this.e() - 1; iE >= 0; iE--) {
                Object objE = f.this.e(iE, 0);
                iHashCode += objE == null ? 0 : objE.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.e() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new e(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = f.this.e(obj);
            if (iE < 0) {
                return false;
            }
            f.this.e(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return f.bf(f.this.bf(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return f.d(f.this.bf(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.e();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return f.this.bf(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.e(tArr, 0);
        }
    }

    public final class e<T> implements Iterator<T> {
        int bf;
        int d;
        final int e;
        boolean tg = false;

        public e(int i) {
            this.e = i;
            this.bf = f.this.e();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d < this.bf;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) f.this.e(this.d, this.e);
            this.d++;
            this.tg = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.tg) {
                throw new IllegalStateException();
            }
            int i = this.d - 1;
            this.d = i;
            this.bf--;
            this.tg = false;
            f.this.e(i);
        }
    }

    public static <K, V> boolean bf(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean d(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <K, V> boolean e(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Map<K, V> bf();

    public abstract void d();

    public abstract int e();

    public abstract int e(Object obj);

    public abstract Object e(int i, int i2);

    public abstract void e(int i);

    public Set<K> tg() {
        if (this.bf == null) {
            this.bf = new bf();
        }
        return this.bf;
    }

    public <T> T[] e(T[] tArr, int i) {
        int iE = e();
        if (tArr.length < iE) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iE));
        }
        for (int i2 = 0; i2 < iE; i2++) {
            tArr[i2] = e(i2, i);
        }
        if (tArr.length > iE) {
            tArr[iE] = null;
        }
        return tArr;
    }

    public Object[] bf(int i) {
        int iE = e();
        Object[] objArr = new Object[iE];
        for (int i2 = 0; i2 < iE; i2++) {
            objArr[i2] = e(i2, i);
        }
        return objArr;
    }

    public static <T> boolean e(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
