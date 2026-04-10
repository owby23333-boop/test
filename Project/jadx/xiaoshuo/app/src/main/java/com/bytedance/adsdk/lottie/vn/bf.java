package com.bytedance.adsdk.lottie.vn;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static float bf(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float e(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int e(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fBf = bf(((i >> 16) & 255) / 255.0f);
        float fBf2 = bf(((i >> 8) & 255) / 255.0f);
        float fBf3 = bf((i & 255) / 255.0f);
        float fBf4 = bf(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fBf5 = fBf2 + ((bf(((i2 >> 8) & 255) / 255.0f) - fBf2) * f);
        float fBf6 = fBf3 + (f * (bf((i2 & 255) / 255.0f) - fBf3));
        return (Math.round(e(fBf + ((fBf4 - fBf) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(e(fBf5) * 255.0f) << 8) | Math.round(e(fBf6) * 255.0f);
    }
}
