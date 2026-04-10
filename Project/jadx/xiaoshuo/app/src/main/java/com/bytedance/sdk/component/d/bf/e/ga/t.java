package com.bytedance.sdk.component.d.bf.e.ga;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class t {
    private final int[] bf = new int[10];
    private int e;

    public int bf(int i) {
        return this.bf[i];
    }

    public int d() {
        if ((this.e & 2) != 0) {
            return this.bf[1];
        }
        return -1;
    }

    public void e() {
        this.e = 0;
        Arrays.fill(this.bf, 0);
    }

    public int tg(int i) {
        return (this.e & 32) != 0 ? this.bf[5] : i;
    }

    public int bf() {
        return Integer.bitCount(this.e);
    }

    public int d(int i) {
        return (this.e & 16) != 0 ? this.bf[4] : i;
    }

    public int tg() {
        if ((this.e & 128) != 0) {
            return this.bf[7];
        }
        return 65535;
    }

    public t e(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.bf;
            if (i < iArr.length) {
                this.e = (1 << i) | this.e;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public boolean e(int i) {
        return ((1 << i) & this.e) != 0;
    }

    public void e(t tVar) {
        for (int i = 0; i < 10; i++) {
            if (tVar.e(i)) {
                e(i, tVar.bf(i));
            }
        }
    }
}
