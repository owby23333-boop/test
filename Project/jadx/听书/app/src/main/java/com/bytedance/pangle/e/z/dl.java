package com.bytedance.pangle.e.z;

/* JADX INFO: loaded from: classes2.dex */
class dl {
    private int dl;
    private int g;
    private int[] z = new int[32];

    public final void z() {
        this.g = 0;
        this.dl = 0;
    }

    public final int g() {
        int i = this.g;
        if (i == 0) {
            return 0;
        }
        return this.z[i - 1];
    }

    public final void z(int i, int i2) {
        if (this.dl == 0) {
            gc();
        }
        e();
        int i3 = this.g;
        int i4 = i3 - 1;
        int[] iArr = this.z;
        int i5 = iArr[i4];
        int i6 = (i4 - 1) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i4 + 1] = i2;
        iArr[i4 + 2] = i7;
        this.g = i3 + 2;
    }

    public final void dl() {
        int i;
        int[] iArr;
        int i2;
        int i3 = this.g;
        if (i3 == 0 || (i2 = (iArr = this.z)[i3 - 1]) == 0) {
            return;
        }
        int i4 = i2 - 1;
        int i5 = i - 2;
        iArr[i5] = i4;
        iArr[i5 - ((i4 * 2) + 1)] = i4;
        this.g = i3 - 2;
    }

    public final int a() {
        return this.dl;
    }

    public final void gc() {
        e();
        int i = this.g;
        int[] iArr = this.z;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.g = i + 2;
        this.dl++;
    }

    public final void m() {
        int i = this.g;
        if (i != 0) {
            int i2 = i - 1;
            int i3 = this.z[i2] * 2;
            if ((i2 - 1) - i3 != 0) {
                this.g = i - (i3 + 2);
                this.dl--;
            }
        }
    }

    private void e() {
        int[] iArr = this.z;
        int length = iArr.length;
        int i = this.g;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.z = iArr2;
        }
    }
}
