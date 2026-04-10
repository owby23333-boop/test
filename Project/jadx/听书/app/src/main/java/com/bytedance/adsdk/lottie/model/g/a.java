package com.bytedance.adsdk.lottie.model.g;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final int[] g;
    private final float[] z;

    public a(float[] fArr, int[] iArr) {
        this.z = fArr;
        this.g = iArr;
    }

    public float[] z() {
        return this.z;
    }

    public int[] g() {
        return this.g;
    }

    public int dl() {
        return this.g.length;
    }

    public void z(a aVar, a aVar2, float f) {
        if (aVar.g.length != aVar2.g.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + aVar.g.length + " vs " + aVar2.g.length + ")");
        }
        for (int i = 0; i < aVar.g.length; i++) {
            this.z[i] = com.bytedance.adsdk.lottie.gc.gz.z(aVar.z[i], aVar2.z[i], f);
            this.g[i] = com.bytedance.adsdk.lottie.gc.dl.z(f, aVar.g[i], aVar2.g[i]);
        }
    }

    public a z(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = z(fArr[i]);
        }
        return new a(fArr, iArr);
    }

    private int z(float f) {
        int iBinarySearch = Arrays.binarySearch(this.z, f);
        if (iBinarySearch >= 0) {
            return this.g[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.g[0];
        }
        int[] iArr = this.g;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.z;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.lottie.gc.dl.z((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}
