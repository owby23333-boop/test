package com.bytedance.adsdk.lottie.vn;

/* JADX INFO: loaded from: classes.dex */
public class vn {
    private int bf;
    private float e;

    public void e(float f) {
        float f2 = this.e + f;
        this.e = f2;
        int i = this.bf + 1;
        this.bf = i;
        if (i == Integer.MAX_VALUE) {
            this.e = f2 / 2.0f;
            this.bf = i / 2;
        }
    }
}
