package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class pf<K, V> {
    pf<K, V>.g g;

    protected abstract void dl();

    protected abstract Map<K, V> g();

    protected abstract int z();

    protected abstract int z(Object obj);

    protected abstract Object z(int i, int i2);

    protected abstract void z(int i);

    pf() {
    }

    final class z<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f190a = false;
        int dl;
        int g;
        final int z;

        z(int i) {
            this.z = i;
            this.g = pf.this.z();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.dl < this.g;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) pf.this.z(this.dl, this.z);
            this.dl++;
            this.f190a = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f190a) {
                throw new IllegalStateException();
            }
            int i = this.dl - 1;
            this.dl = i;
            this.g--;
            this.f190a = false;
            pf.this.z(i);
        }
    }

    final class g implements Set<K> {
        g() {
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
            pf.this.dl();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return pf.this.z(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return pf.z(pf.this.g(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return pf.this.z() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new z(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iZ = pf.this.z(obj);
            if (iZ < 0) {
                return false;
            }
            pf.this.z(iZ);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return pf.g(pf.this.g(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return pf.dl(pf.this.g(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return pf.this.z();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return pf.this.g(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) pf.this.z(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return pf.z(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iZ = pf.this.z() - 1; iZ >= 0; iZ--) {
                Object objZ = pf.this.z(iZ, 0);
                iHashCode += objZ == null ? 0 : objZ.hashCode();
            }
            return iHashCode;
        }
    }

    public static <K, V> boolean z(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean g(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean dl(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] g(int i) {
        int iZ = z();
        Object[] objArr = new Object[iZ];
        for (int i2 = 0; i2 < iZ; i2++) {
            objArr[i2] = z(i2, i);
        }
        return objArr;
    }

    public <T> T[] z(T[] tArr, int i) {
        int iZ = z();
        if (tArr.length < iZ) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iZ));
        }
        for (int i2 = 0; i2 < iZ; i2++) {
            tArr[i2] = z(i2, i);
        }
        if (tArr.length > iZ) {
            tArr[iZ] = null;
        }
        return tArr;
    }

    public static <T> boolean z(Set<T> set, Object obj) {
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
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public Set<K> a() {
        if (this.g == null) {
            this.g = new g();
        }
        return this.g;
    }
}
