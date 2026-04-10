package com.bytedance.sdk.component.widget.recycler.z.g;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gc<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f845a;
    static Object[] dl;
    static int g;
    static Object[] z;
    int[] gc = g.z;
    Object[] m = g.dl;
    int e = 0;

    private static int z(int[] iArr, int i, int i2) {
        try {
            return g.z(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    int z(Object obj, int i) {
        int i2 = this.e;
        if (i2 == 0) {
            return -1;
        }
        int iZ = z(this.gc, i2, i);
        if (iZ < 0 || obj.equals(this.m[iZ << 1])) {
            return iZ;
        }
        int i3 = iZ + 1;
        while (i3 < i2 && this.gc[i3] == i) {
            if (obj.equals(this.m[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iZ - 1; i4 >= 0 && this.gc[i4] == i; i4--) {
            if (obj.equals(this.m[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    int z() {
        int i = this.e;
        if (i == 0) {
            return -1;
        }
        int iZ = z(this.gc, i, 0);
        if (iZ < 0 || this.m[iZ << 1] == null) {
            return iZ;
        }
        int i2 = iZ + 1;
        while (i2 < i && this.gc[i2] == 0) {
            if (this.m[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iZ - 1; i3 >= 0 && this.gc[i3] == 0; i3--) {
            if (this.m[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (z.class) {
                Object[] objArr = dl;
                if (objArr != null) {
                    this.m = objArr;
                    dl = (Object[]) objArr[0];
                    this.gc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f845a--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (z.class) {
                Object[] objArr2 = z;
                if (objArr2 != null) {
                    this.m = objArr2;
                    z = (Object[]) objArr2[0];
                    this.gc = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    g--;
                    return;
                }
            }
        }
        this.gc = new int[i];
        this.m = new Object[i << 1];
    }

    private static void z(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (z.class) {
                if (f845a < 10) {
                    objArr[0] = dl;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    dl = objArr;
                    f845a++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (z.class) {
                if (g < 10) {
                    objArr[0] = z;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    z = objArr;
                    g++;
                }
            }
        }
    }

    public void clear() {
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.gc;
            Object[] objArr = this.m;
            this.gc = g.z;
            this.m = g.dl;
            this.e = 0;
            z(iArr, objArr, i);
        }
        if (this.e > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return z(obj) >= 0;
    }

    public int z(Object obj) {
        return obj == null ? z() : z(obj, obj.hashCode());
    }

    int g(Object obj) {
        int i = this.e * 2;
        Object[] objArr = this.m;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public V get(Object obj) {
        int iZ = z(obj);
        if (iZ >= 0) {
            return (V) this.m[(iZ << 1) + 1];
        }
        return null;
    }

    public K z(int i) {
        return (K) this.m[i << 1];
    }

    public V g(int i) {
        return (V) this.m[(i << 1) + 1];
    }

    public boolean isEmpty() {
        return this.e <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iZ;
        int i2 = this.e;
        if (k == null) {
            iZ = z();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iZ = z(k, iHashCode);
        }
        if (iZ >= 0) {
            int i3 = (iZ << 1) + 1;
            Object[] objArr = this.m;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iZ;
        int[] iArr = this.gc;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.m;
            a(i5);
            if (i2 != this.e) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.gc;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.m, 0, objArr2.length);
            }
            z(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.gc;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.m;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.e - i4) << 1);
        }
        int i7 = this.e;
        if (i2 == i7) {
            int[] iArr4 = this.gc;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.m;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.e = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iZ = z(obj);
        if (iZ >= 0) {
            return dl(iZ);
        }
        return null;
    }

    public V dl(int i) {
        Object[] objArr = this.m;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.e;
        int i4 = 0;
        if (i3 <= 1) {
            z(this.gc, objArr, i3);
            this.gc = g.z;
            this.m = g.dl;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.gc;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.e) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.gc, 0, i);
                    System.arraycopy(objArr, 0, this.m, 0, i2);
                }
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, this.gc, i, i7);
                    System.arraycopy(objArr, i6 << 1, this.m, i2, i7 << 1);
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(iArr, i8, iArr, i, i9);
                    Object[] objArr2 = this.m;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i2, i9 << 1);
                }
                Object[] objArr3 = this.m;
                int i10 = i5 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 != this.e) {
            throw new ConcurrentModificationException();
        }
        this.e = i4;
        return v;
    }

    public int size() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof gc) {
            gc gcVar = (gc) obj;
            if (size() != gcVar.size()) {
                return false;
            }
            for (int i = 0; i < this.e; i++) {
                try {
                    K kZ = z(i);
                    V vG = g(i);
                    Object obj2 = gcVar.get(kZ);
                    if (vG == null) {
                        if (obj2 != null || !gcVar.containsKey(kZ)) {
                            return false;
                        }
                    } else if (!vG.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.e; i2++) {
            try {
                K kZ2 = z(i2);
                V vG2 = g(i2);
                Object obj3 = map.get(kZ2);
                if (vG2 == null) {
                    if (obj3 != null || !map.containsKey(kZ2)) {
                        return false;
                    }
                } else if (!vG2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.gc;
        Object[] objArr = this.m;
        int i = this.e;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kZ = z(i);
            if (kZ != this) {
                sb.append(kZ);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vG = g(i);
            if (vG != this) {
                sb.append(vG);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
