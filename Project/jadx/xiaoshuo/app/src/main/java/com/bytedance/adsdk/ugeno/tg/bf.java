package com.bytedance.adsdk.ugeno.tg;

/* JADX INFO: loaded from: classes.dex */
public final class bf {
    public static float e(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return f;
        }
    }

    public static int e(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static long e(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return j;
        }
    }
}
