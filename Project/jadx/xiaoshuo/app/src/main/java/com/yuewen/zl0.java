package com.yuewen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class zl0<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<zl0<K, V>.c> f20808a = new ArrayList();

    public class a implements Set<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: com.yuewen.zl0$a$a, reason: collision with other inner class name */
        public class C0786a implements Iterator<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f20810a = 0;

            /* JADX INFO: renamed from: com.yuewen.zl0$a$a$a, reason: collision with other inner class name */
            public class C0787a extends zl0<K, V>.b {
                public C0787a(int i) {
                    super(i);
                }

                @Override // com.yuewen.zl0.b
                public zl0<K, V>.c a(int i) {
                    if (i > zl0.this.f20808a.size() - 1 || i < 0) {
                        return null;
                    }
                    return (c) zl0.this.f20808a.get(i);
                }
            }

            public C0786a() {
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                C0787a c0787a = new C0787a(this.f20810a);
                this.f20810a++;
                return c0787a;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f20810a <= zl0.this.f20808a.size() - 1;
            }

            @Override // java.util.Iterator
            public void remove() {
            }
        }

        public a() {
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            c cVar = new c();
            cVar.f20814a = entry.getKey();
            cVar.f20815b = entry.getValue();
            zl0.this.f20808a.add(cVar);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            zl0.this.f20808a.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return zl0.this.f20808a == null || zl0.this.f20808a.size() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0786a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            if (zl0.this.f20808a == null) {
                return 0;
            }
            return zl0.this.f20808a.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return null;
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return null;
        }
    }

    public abstract class b implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20812a;

        public b(int i) {
            this.f20812a = i;
        }

        public abstract zl0<K, V>.c a(int i);

        @Override // java.util.Map.Entry
        public K getKey() {
            zl0<K, V>.c cVarA = a(this.f20812a);
            if (cVarA != null) {
                return cVarA.f20814a;
            }
            return null;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            zl0<K, V>.c cVarA = a(this.f20812a);
            if (cVarA != null) {
                return cVarA.f20815b;
            }
            return null;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            zl0<K, V>.c cVarA = a(this.f20812a);
            if (cVarA != null) {
                cVarA.f20815b = v;
            }
            return v;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public K f20814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f20815b;

        public c() {
        }
    }

    public final zl0<K, V>.c b(K k) {
        int iHashCode = k.hashCode();
        for (zl0<K, V>.c cVar : this.f20808a) {
            if (cVar.f20814a.hashCode() == iHashCode) {
                return cVar;
            }
        }
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        this.f20808a.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        int iHashCode = obj.hashCode();
        Iterator<zl0<K, V>.c> it = this.f20808a.iterator();
        while (it.hasNext()) {
            if (it.next().f20814a.hashCode() == iHashCode) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        int iHashCode = obj.hashCode();
        Iterator<zl0<K, V>.c> it = this.f20808a.iterator();
        while (it.hasNext()) {
            if (it.next().f20815b.hashCode() == iHashCode) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new a();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int iHashCode = obj.hashCode();
        for (zl0<K, V>.c cVar : this.f20808a) {
            if (cVar.f20814a.hashCode() == iHashCode) {
                return cVar.f20815b;
            }
        }
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        List<zl0<K, V>.c> list = this.f20808a;
        return list == null || list.size() == 0;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return null;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        zl0<K, V>.c cVarB = b(k);
        if (cVarB == null) {
            cVarB = new c();
            this.f20808a.add(cVarB);
        }
        cVarB.f20814a = k;
        cVarB.f20815b = v;
        return v;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        int iHashCode = obj.hashCode();
        for (zl0<K, V>.c cVar : this.f20808a) {
            if (cVar.f20814a.hashCode() == iHashCode) {
                this.f20808a.remove(cVar);
                return cVar.f20815b;
            }
        }
        return null;
    }

    @Override // java.util.Map
    public int size() {
        List<zl0<K, V>.c> list = this.f20808a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return null;
    }
}
