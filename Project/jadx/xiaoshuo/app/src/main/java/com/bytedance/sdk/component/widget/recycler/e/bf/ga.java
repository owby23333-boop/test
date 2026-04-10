package com.bytedance.sdk.component.widget.recycler.e.bf;

import com.alipay.sdk.m.p.a;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ga<K, V> {
    static int bf;
    static Object[] d;
    static Object[] e;
    static int tg;
    int[] ga = bf.e;
    Object[] vn = bf.d;
    int p = 0;

    private static int e(int[] iArr, int i, int i2) {
        try {
            return bf.e(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private void tg(int i) {
        if (i == 8) {
            synchronized (e.class) {
                Object[] objArr = d;
                if (objArr != null) {
                    this.vn = objArr;
                    d = (Object[]) objArr[0];
                    this.ga = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    tg--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (e.class) {
                Object[] objArr2 = e;
                if (objArr2 != null) {
                    this.vn = objArr2;
                    e = (Object[]) objArr2[0];
                    this.ga = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    bf--;
                    return;
                }
            }
        }
        this.ga = new int[i];
        this.vn = new Object[i << 1];
    }

    public int bf(Object obj) {
        int i = this.p * 2;
        Object[] objArr = this.vn;
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

    public void clear() {
        int i = this.p;
        if (i > 0) {
            int[] iArr = this.ga;
            Object[] objArr = this.vn;
            this.ga = bf.e;
            this.vn = bf.d;
            this.p = 0;
            e(iArr, objArr, i);
        }
        if (this.p > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return bf(obj) >= 0;
    }

    public V d(int i) {
        Object[] objArr = this.vn;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.p;
        int i4 = 0;
        if (i3 <= 1) {
            e(this.ga, objArr, i3);
            this.ga = bf.e;
            this.vn = bf.d;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.ga;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.vn;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.vn;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                tg(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.p) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.ga, 0, i);
                    System.arraycopy(objArr, 0, this.vn, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.ga, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.vn, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.p) {
            throw new ConcurrentModificationException();
        }
        this.p = i4;
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ga) {
            ga gaVar = (ga) obj;
            if (size() != gaVar.size()) {
                return false;
            }
            for (int i = 0; i < this.p; i++) {
                try {
                    K kE = e(i);
                    V vBf = bf(i);
                    Object obj2 = gaVar.get(kE);
                    if (vBf == null) {
                        if (obj2 != null || !gaVar.containsKey(kE)) {
                            return false;
                        }
                    } else if (!vBf.equals(obj2)) {
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
        for (int i2 = 0; i2 < this.p; i2++) {
            try {
                K kE2 = e(i2);
                V vBf2 = bf(i2);
                Object obj3 = map.get(kE2);
                if (vBf2 == null) {
                    if (obj3 != null || !map.containsKey(kE2)) {
                        return false;
                    }
                } else if (!vBf2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return (V) this.vn[(iE << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.ga;
        Object[] objArr = this.vn;
        int i = this.p;
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

    public boolean isEmpty() {
        return this.p <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iE;
        int i2 = this.p;
        if (k == null) {
            iE = e();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iE = e(k, iHashCode);
        }
        if (iE >= 0) {
            int i3 = (iE << 1) + 1;
            Object[] objArr = this.vn;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iE;
        int[] iArr = this.ga;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.vn;
            tg(i5);
            if (i2 != this.p) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.ga;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.vn, 0, objArr2.length);
            }
            e(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.ga;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.vn;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.p - i4) << 1);
        }
        int i7 = this.p;
        if (i2 == i7) {
            int[] iArr4 = this.ga;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.vn;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.p = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return d(iE);
        }
        return null;
    }

    public int size() {
        return this.p;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.p * 28);
        sb.append('{');
        for (int i = 0; i < this.p; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kE = e(i);
            if (kE != this) {
                sb.append(kE);
            } else {
                sb.append("(this Map)");
            }
            sb.append(a.h);
            V vBf = bf(i);
            if (vBf != this) {
                sb.append(vBf);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public int e(Object obj, int i) {
        int i2 = this.p;
        if (i2 == 0) {
            return -1;
        }
        int iE = e(this.ga, i2, i);
        if (iE < 0 || obj.equals(this.vn[iE << 1])) {
            return iE;
        }
        int i3 = iE + 1;
        while (i3 < i2 && this.ga[i3] == i) {
            if (obj.equals(this.vn[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iE - 1; i4 >= 0 && this.ga[i4] == i; i4--) {
            if (obj.equals(this.vn[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public V bf(int i) {
        return (V) this.vn[(i << 1) + 1];
    }

    int e() {
        int i = this.p;
        if (i == 0) {
            return -1;
        }
        int iE = e(this.ga, i, 0);
        if (iE < 0 || this.vn[iE << 1] == null) {
            return iE;
        }
        int i2 = iE + 1;
        while (i2 < i && this.ga[i2] == 0) {
            if (this.vn[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iE - 1; i3 >= 0 && this.ga[i3] == 0; i3--) {
            if (this.vn[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private static void e(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (e.class) {
                if (tg < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    d = objArr;
                    tg++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (e.class) {
                if (bf < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    e = objArr;
                    bf++;
                }
            }
        }
    }

    public int e(Object obj) {
        return obj == null ? e() : e(obj, obj.hashCode());
    }

    public K e(int i) {
        return (K) this.vn[i << 1];
    }
}
