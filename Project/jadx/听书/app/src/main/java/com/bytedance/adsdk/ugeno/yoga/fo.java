package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public static long z(float f, float f2) {
        return ((long) Float.floatToRawIntBits(f2)) | (((long) Float.floatToRawIntBits(f)) << 32);
    }

    public static long z(int i, int i2) {
        return z(i, i2);
    }
}
