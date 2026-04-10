package com.bytedance.sdk.component.widget.recycler.z.g;

/* JADX INFO: loaded from: classes2.dex */
public class dl<E> implements Cloneable {
    private static final Object z = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f844a;
    private long[] dl;
    private boolean g;
    private int gc;

    public dl() {
        this(10);
    }

    public dl(int i) {
        this.g = false;
        if (i == 0) {
            this.dl = g.g;
            this.f844a = g.dl;
        } else {
            int iZ = g.z(i);
            this.dl = new long[iZ];
            this.f844a = new Object[iZ];
        }
        this.gc = 0;
    }

    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public dl<E> clone() {
        try {
            dl<E> dlVar = (dl) super.clone();
            dlVar.dl = (long[]) this.dl.clone();
            dlVar.f844a = (Object[]) this.f844a.clone();
            return dlVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E z(long j) {
        return z(j, null);
    }

    public E z(long j, E e) {
        E e2;
        int iZ = g.z(this.dl, this.gc, j);
        return (iZ < 0 || (e2 = (E) this.f844a[iZ]) == z) ? e : e2;
    }

    public void delete(long j) {
        int iZ = g.z(this.dl, this.gc, j);
        if (iZ >= 0) {
            Object[] objArr = this.f844a;
            Object obj = objArr[iZ];
            Object obj2 = z;
            if (obj != obj2) {
                objArr[iZ] = obj2;
                this.g = true;
            }
        }
    }

    public void z(int i) {
        Object[] objArr = this.f844a;
        Object obj = objArr[i];
        Object obj2 = z;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.g = true;
        }
    }

    private void a() {
        int i = this.gc;
        long[] jArr = this.dl;
        Object[] objArr = this.f844a;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != z) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.g = false;
        this.gc = i2;
    }

    public void g(long j, E e) {
        int iZ = g.z(this.dl, this.gc, j);
        if (iZ >= 0) {
            this.f844a[iZ] = e;
            return;
        }
        int i = ~iZ;
        int i2 = this.gc;
        if (i < i2) {
            Object[] objArr = this.f844a;
            if (objArr[i] == z) {
                this.dl[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.g && i2 >= this.dl.length) {
            a();
            i = ~g.z(this.dl, this.gc, j);
        }
        int i3 = this.gc;
        if (i3 >= this.dl.length) {
            int iZ2 = g.z(i3 + 1);
            long[] jArr = new long[iZ2];
            Object[] objArr2 = new Object[iZ2];
            long[] jArr2 = this.dl;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f844a;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.dl = jArr;
            this.f844a = objArr2;
        }
        int i4 = this.gc;
        if (i4 - i != 0) {
            long[] jArr3 = this.dl;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.f844a;
            System.arraycopy(objArr4, i, objArr4, i5, this.gc - i);
        }
        this.dl[i] = j;
        this.f844a[i] = e;
        this.gc++;
    }

    public int g() {
        if (this.g) {
            a();
        }
        return this.gc;
    }

    public long g(int i) {
        if (this.g) {
            a();
        }
        return this.dl[i];
    }

    public E dl(int i) {
        if (this.g) {
            a();
        }
        return (E) this.f844a[i];
    }

    public void dl() {
        int i = this.gc;
        Object[] objArr = this.f844a;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.gc = 0;
        this.g = false;
    }

    public String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.gc * 28);
        sb.append('{');
        for (int i = 0; i < this.gc; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(g(i));
            sb.append('=');
            E eDl = dl(i);
            if (eDl != this) {
                sb.append(eDl);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
