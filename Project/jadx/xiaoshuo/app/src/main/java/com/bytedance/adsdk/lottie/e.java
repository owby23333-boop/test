package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class e<E> implements Collection<E>, Set<E> {
    private static Object[] ga;
    private static Object[] p;
    private static int v;
    private static int vn;
    int bf;
    Object[] e;
    private f<E, E> m;
    private int[] zk;
    private static final int[] d = new int[0];
    private static final Object[] tg = new Object[0];

    public e() {
        this(0);
    }

    private int e(Object obj, int i) {
        int i2 = this.bf;
        if (i2 == 0) {
            return -1;
        }
        int iE = bf.e(this.zk, i2, i);
        if (iE < 0 || obj.equals(this.e[iE])) {
            return iE;
        }
        int i3 = iE + 1;
        while (i3 < i2 && this.zk[i3] == i) {
            if (obj.equals(this.e[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iE - 1; i4 >= 0 && this.zk[i4] == i; i4--) {
            if (obj.equals(this.e[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private void tg(int i) {
        if (i == 8) {
            synchronized (e.class) {
                Object[] objArr = p;
                if (objArr != null) {
                    this.e = objArr;
                    p = (Object[]) objArr[0];
                    this.zk = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    v--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (e.class) {
                Object[] objArr2 = ga;
                if (objArr2 != null) {
                    this.e = objArr2;
                    ga = (Object[]) objArr2[0];
                    this.zk = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    vn--;
                    return;
                }
            }
        }
        this.zk = new int[i];
        this.e = new Object[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iE;
        if (e == null) {
            iE = e();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iE = e(e, iHashCode);
        }
        if (iE >= 0) {
            return false;
        }
        int i2 = ~iE;
        int i3 = this.bf;
        int[] iArr = this.zk;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.e;
            tg(i4);
            int[] iArr2 = this.zk;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.e, 0, objArr.length);
            }
            e(iArr, objArr, this.bf);
        }
        int i5 = this.bf;
        if (i2 < i5) {
            int[] iArr3 = this.zk;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, i2, objArr2, i6, this.bf - i2);
        }
        this.zk[i2] = i;
        this.e[i2] = e;
        this.bf++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        e(this.bf + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public E bf(int i) {
        return (E) this.e[i];
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.bf;
        if (i != 0) {
            e(this.zk, this.e, i);
            this.zk = d;
            this.e = tg;
            this.bf = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return e(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public E d(int i) {
        Object[] objArr = this.e;
        E e = (E) objArr[i];
        int i2 = this.bf;
        if (i2 <= 1) {
            e(this.zk, objArr, i2);
            this.zk = d;
            this.e = tg;
            this.bf = 0;
        } else {
            int[] iArr = this.zk;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = i2 - 1;
                this.bf = i3;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, iArr, i, i3 - i);
                    Object[] objArr2 = this.e;
                    System.arraycopy(objArr2, i4, objArr2, i, this.bf - i);
                }
                this.e[this.bf] = null;
            } else {
                tg(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.bf--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.zk, 0, i);
                    System.arraycopy(objArr, 0, this.e, 0, i);
                }
                int i5 = this.bf;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, this.zk, i, i5 - i);
                    System.arraycopy(objArr, i6, this.e, i, this.bf - i);
                }
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.bf; i++) {
                try {
                    if (!set.contains(bf(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.zk;
        int i = this.bf;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.bf <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return bf().tg().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iE = e(obj);
        if (iE < 0) {
            return false;
        }
        d(iE);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.bf - 1; i >= 0; i--) {
            if (!collection.contains(this.e[i])) {
                d(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.bf;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.bf;
        Object[] objArr = new Object[i];
        System.arraycopy(this.e, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.bf * 14);
        sb.append('{');
        for (int i = 0; i < this.bf; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eBf = bf(i);
            if (eBf != this) {
                sb.append(eBf);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public e(int i) {
        if (i == 0) {
            this.zk = d;
            this.e = tg;
        } else {
            tg(i);
        }
        this.bf = 0;
    }

    private f<E, E> bf() {
        if (this.m == null) {
            this.m = new f<E, E>() { // from class: com.bytedance.adsdk.lottie.e.1
                @Override // com.bytedance.adsdk.lottie.f
                public Map<E, E> bf() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.lottie.f
                public void d() {
                    e.this.clear();
                }

                @Override // com.bytedance.adsdk.lottie.f
                public int e() {
                    return e.this.bf;
                }

                @Override // com.bytedance.adsdk.lottie.f
                public Object e(int i, int i2) {
                    return e.this.e[i];
                }

                @Override // com.bytedance.adsdk.lottie.f
                public int e(Object obj) {
                    return e.this.e(obj);
                }

                @Override // com.bytedance.adsdk.lottie.f
                public void e(int i) {
                    e.this.d(i);
                }
            };
        }
        return this.m;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.bf) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.bf));
        }
        System.arraycopy(this.e, 0, tArr, 0, this.bf);
        int length = tArr.length;
        int i = this.bf;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    private int e() {
        int i = this.bf;
        if (i == 0) {
            return -1;
        }
        int iE = bf.e(this.zk, i, 0);
        if (iE < 0 || this.e[iE] == null) {
            return iE;
        }
        int i2 = iE + 1;
        while (i2 < i && this.zk[i2] == 0) {
            if (this.e[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iE - 1; i3 >= 0 && this.zk[i3] == 0; i3--) {
            if (this.e[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private static void e(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (e.class) {
                if (v < 10) {
                    objArr[0] = p;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    p = objArr;
                    v++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (e.class) {
                if (vn < 10) {
                    objArr[0] = ga;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    ga = objArr;
                    vn++;
                }
            }
        }
    }

    public void e(int i) {
        int[] iArr = this.zk;
        if (iArr.length < i) {
            Object[] objArr = this.e;
            tg(i);
            int i2 = this.bf;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.zk, 0, i2);
                System.arraycopy(objArr, 0, this.e, 0, this.bf);
            }
            e(iArr, objArr, this.bf);
        }
    }

    public int e(Object obj) {
        return obj == null ? e() : e(obj, obj.hashCode());
    }
}
