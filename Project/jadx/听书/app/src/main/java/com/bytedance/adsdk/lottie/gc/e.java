package com.bytedance.adsdk.lottie.gc;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private int g;
    private float z;

    public void z(float f) {
        float f2 = this.z + f;
        this.z = f2;
        int i = this.g + 1;
        this.g = i;
        if (i == Integer.MAX_VALUE) {
            this.z = f2 / 2.0f;
            this.g = i / 2;
        }
    }
}
