package com.bytedance.adsdk.lottie.d.bf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private final int[] bf;
    private final float[] e;

    public tg(float[] fArr, int[] iArr) {
        this.e = fArr;
        this.bf = iArr;
    }

    public int[] bf() {
        return this.bf;
    }

    public int d() {
        return this.bf.length;
    }

    public float[] e() {
        return this.e;
    }

    public void e(tg tgVar, tg tgVar2, float f) {
        if (tgVar.bf.length == tgVar2.bf.length) {
            for (int i = 0; i < tgVar.bf.length; i++) {
                this.e[i] = com.bytedance.adsdk.lottie.vn.p.e(tgVar.e[i], tgVar2.e[i], f);
                this.bf[i] = com.bytedance.adsdk.lottie.vn.bf.e(f, tgVar.bf[i], tgVar2.bf[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + tgVar.bf.length + " vs " + tgVar2.bf.length + ")");
    }

    public tg e(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = e(fArr[i]);
        }
        return new tg(fArr, iArr);
    }

    private int e(float f) {
        int iBinarySearch = Arrays.binarySearch(this.e, f);
        if (iBinarySearch >= 0) {
            return this.bf[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.bf[0];
        }
        int[] iArr = this.bf;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.e;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.lottie.vn.bf.e((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}
