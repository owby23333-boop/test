package com.bytedance.sdk.component.dl.g.z.gc;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private final int[] g = new int[10];
    private int z;

    void z() {
        this.z = 0;
        Arrays.fill(this.g, 0);
    }

    v z(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.g;
            if (i < iArr.length) {
                this.z = (1 << i) | this.z;
                iArr[i] = i2;
            }
        }
        return this;
    }

    boolean z(int i) {
        return ((1 << i) & this.z) != 0;
    }

    int g(int i) {
        return this.g[i];
    }

    int g() {
        return Integer.bitCount(this.z);
    }

    int dl() {
        if ((this.z & 2) != 0) {
            return this.g[1];
        }
        return -1;
    }

    int dl(int i) {
        return (this.z & 16) != 0 ? this.g[4] : i;
    }

    int a(int i) {
        return (this.z & 32) != 0 ? this.g[5] : i;
    }

    int a() {
        if ((this.z & 128) != 0) {
            return this.g[7];
        }
        return 65535;
    }

    void z(v vVar) {
        for (int i = 0; i < 10; i++) {
            if (vVar.z(i)) {
                z(i, vVar.g(i));
            }
        }
    }
}
