package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class z<E> implements Collection<E>, Set<E> {
    private static Object[] e;
    private static Object[] gc;
    private static int gz;
    private static int m;
    private int[] fo;
    int g;
    private pf<E, E> uy;
    Object[] z;
    private static final int[] dl = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f193a = new Object[0];

    private int z(Object obj, int i) {
        int i2 = this.g;
        if (i2 == 0) {
            return -1;
        }
        int iZ = g.z(this.fo, i2, i);
        if (iZ < 0 || obj.equals(this.z[iZ])) {
            return iZ;
        }
        int i3 = iZ + 1;
        while (i3 < i2 && this.fo[i3] == i) {
            if (obj.equals(this.z[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iZ - 1; i4 >= 0 && this.fo[i4] == i; i4--) {
            if (obj.equals(this.z[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int z() {
        int i = this.g;
        if (i == 0) {
            return -1;
        }
        int iZ = g.z(this.fo, i, 0);
        if (iZ < 0 || this.z[iZ] == null) {
            return iZ;
        }
        int i2 = iZ + 1;
        while (i2 < i && this.fo[i2] == 0) {
            if (this.z[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iZ - 1; i3 >= 0 && this.fo[i3] == 0; i3--) {
            if (this.z[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (z.class) {
                Object[] objArr = e;
                if (objArr != null) {
                    this.z = objArr;
                    e = (Object[]) objArr[0];
                    this.fo = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    gz--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (z.class) {
                Object[] objArr2 = gc;
                if (objArr2 != null) {
                    this.z = objArr2;
                    gc = (Object[]) objArr2[0];
                    this.fo = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    m--;
                    return;
                }
            }
        }
        this.fo = new int[i];
        this.z = new Object[i];
    }

    private static void z(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (z.class) {
                if (gz < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    e = objArr;
                    gz++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (z.class) {
                if (m < 10) {
                    objArr[0] = gc;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    gc = objArr;
                    m++;
                }
            }
        }
    }

    public z() {
        this(0);
    }

    public z(int i) {
        if (i == 0) {
            this.fo = dl;
            this.z = f193a;
        } else {
            a(i);
        }
        this.g = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.g;
        if (i != 0) {
            z(this.fo, this.z, i);
            this.fo = dl;
            this.z = f193a;
            this.g = 0;
        }
    }

    public void z(int i) {
        int[] iArr = this.fo;
        if (iArr.length < i) {
            Object[] objArr = this.z;
            a(i);
            int i2 = this.g;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.fo, 0, i2);
                System.arraycopy(objArr, 0, this.z, 0, this.g);
            }
            z(iArr, objArr, this.g);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return z(obj) >= 0;
    }

    public int z(Object obj) {
        return obj == null ? z() : z(obj, obj.hashCode());
    }

    public E g(int i) {
        return (E) this.z[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.g <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i;
        int iZ;
        if (e2 == null) {
            iZ = z();
            i = 0;
        } else {
            int iHashCode = e2.hashCode();
            i = iHashCode;
            iZ = z(e2, iHashCode);
        }
        if (iZ >= 0) {
            return false;
        }
        int i2 = ~iZ;
        int i3 = this.g;
        int[] iArr = this.fo;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.z;
            a(i4);
            int[] iArr2 = this.fo;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.z, 0, objArr.length);
            }
            z(iArr, objArr, this.g);
        }
        int i5 = this.g;
        if (i2 < i5) {
            int[] iArr3 = this.fo;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.z;
            System.arraycopy(objArr2, i2, objArr2, i6, this.g - i2);
        }
        this.fo[i2] = i;
        this.z[i2] = e2;
        this.g++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iZ = z(obj);
        if (iZ < 0) {
            return false;
        }
        dl(iZ);
        return true;
    }

    public E dl(int i) {
        Object[] objArr = this.z;
        E e2 = (E) objArr[i];
        int i2 = this.g;
        if (i2 <= 1) {
            z(this.fo, objArr, i2);
            this.fo = dl;
            this.z = f193a;
            this.g = 0;
        } else {
            int[] iArr = this.fo;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                a(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.g--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.fo, 0, i);
                    System.arraycopy(objArr, 0, this.z, 0, i);
                }
                int i3 = this.g;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.fo, i, i3 - i);
                    System.arraycopy(objArr, i4, this.z, i, this.g - i);
                }
            } else {
                int i5 = i2 - 1;
                this.g = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.z;
                    System.arraycopy(objArr2, i6, objArr2, i, this.g - i);
                }
                this.z[this.g] = null;
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.g;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.g;
        Object[] objArr = new Object[i];
        System.arraycopy(this.z, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.g) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.g));
        }
        System.arraycopy(this.z, 0, tArr, 0, this.g);
        int length = tArr.length;
        int i = this.g;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
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
            for (int i = 0; i < this.g; i++) {
                try {
                    if (!set.contains(g(i))) {
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
        int[] iArr = this.fo;
        int i = this.g;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.g * 14);
        sb.append('{');
        for (int i = 0; i < this.g; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eG = g(i);
            if (eG != this) {
                sb.append(eG);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private pf<E, E> g() {
        if (this.uy == null) {
            this.uy = new pf<E, E>() { // from class: com.bytedance.adsdk.lottie.z.1
                @Override // com.bytedance.adsdk.lottie.pf
                protected int z() {
                    return z.this.g;
                }

                @Override // com.bytedance.adsdk.lottie.pf
                protected Object z(int i, int i2) {
                    return z.this.z[i];
                }

                @Override // com.bytedance.adsdk.lottie.pf
                protected int z(Object obj) {
                    return z.this.z(obj);
                }

                @Override // com.bytedance.adsdk.lottie.pf
                protected Map<E, E> g() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.lottie.pf
                protected void z(int i) {
                    z.this.dl(i);
                }

                @Override // com.bytedance.adsdk.lottie.pf
                protected void dl() {
                    z.this.clear();
                }
            };
        }
        return this.uy;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return g().a().iterator();
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

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        z(this.g + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
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
        for (int i = this.g - 1; i >= 0; i--) {
            if (!collection.contains(this.z[i])) {
                dl(i);
                z = true;
            }
        }
        return z;
    }
}
