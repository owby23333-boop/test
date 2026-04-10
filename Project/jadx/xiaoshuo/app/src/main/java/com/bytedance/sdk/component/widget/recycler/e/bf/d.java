package com.bytedance.sdk.component.widget.recycler.e.bf;

import com.alipay.sdk.m.p.a;

/* JADX INFO: loaded from: classes.dex */
public class d<E> implements Cloneable {
    private static final Object e = new Object();
    private boolean bf;
    private long[] d;
    private int ga;
    private Object[] tg;

    public d() {
        this(10);
    }

    private void tg() {
        int i = this.ga;
        long[] jArr = this.d;
        Object[] objArr = this.tg;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != e) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.bf = false;
        this.ga = i2;
    }

    public void bf(long j, E e2) {
        int iE = bf.e(this.d, this.ga, j);
        if (iE >= 0) {
            this.tg[iE] = e2;
            return;
        }
        int i = ~iE;
        int i2 = this.ga;
        if (i < i2) {
            Object[] objArr = this.tg;
            if (objArr[i] == e) {
                this.d[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.bf && i2 >= this.d.length) {
            tg();
            i = ~bf.e(this.d, this.ga, j);
        }
        int i3 = this.ga;
        if (i3 >= this.d.length) {
            int iE2 = bf.e(i3 + 1);
            long[] jArr = new long[iE2];
            Object[] objArr2 = new Object[iE2];
            long[] jArr2 = this.d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.tg;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.d = jArr;
            this.tg = objArr2;
        }
        int i4 = this.ga;
        if (i4 - i != 0) {
            long[] jArr3 = this.d;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.tg;
            System.arraycopy(objArr4, i, objArr4, i5, this.ga - i);
        }
        this.d[i] = j;
        this.tg[i] = e2;
        this.ga++;
    }

    public E d(int i) {
        if (this.bf) {
            tg();
        }
        return (E) this.tg[i];
    }

    public void delete(long j) {
        int iE = bf.e(this.d, this.ga, j);
        if (iE >= 0) {
            Object[] objArr = this.tg;
            Object obj = objArr[iE];
            Object obj2 = e;
            if (obj != obj2) {
                objArr[iE] = obj2;
                this.bf = true;
            }
        }
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.d = (long[]) this.d.clone();
            dVar.tg = (Object[]) this.tg.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public String toString() {
        if (bf() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.ga * 28);
        sb.append('{');
        for (int i = 0; i < this.ga; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(bf(i));
            sb.append(a.h);
            E eD = d(i);
            if (eD != this) {
                sb.append(eD);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i) {
        this.bf = false;
        if (i == 0) {
            this.d = bf.bf;
            this.tg = bf.d;
        } else {
            int iE = bf.e(i);
            this.d = new long[iE];
            this.tg = new Object[iE];
        }
        this.ga = 0;
    }

    public void d() {
        int i = this.ga;
        Object[] objArr = this.tg;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.ga = 0;
        this.bf = false;
    }

    public E e(long j) {
        return e(j, null);
    }

    public E e(long j, E e2) {
        E e3;
        int iE = bf.e(this.d, this.ga, j);
        return (iE < 0 || (e3 = (E) this.tg[iE]) == e) ? e2 : e3;
    }

    public void e(int i) {
        Object[] objArr = this.tg;
        Object obj = objArr[i];
        Object obj2 = e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.bf = true;
        }
    }

    public int bf() {
        if (this.bf) {
            tg();
        }
        return this.ga;
    }

    public long bf(int i) {
        if (this.bf) {
            tg();
        }
        return this.d[i];
    }
}
