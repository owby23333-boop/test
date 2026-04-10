package com.bytedance.adsdk.ugeno.m;

import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public final class dl {
    public static float z(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            wp.z(e);
            return f;
        }
    }

    public static int z(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            wp.z(e);
            return i;
        }
    }

    public static long z(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            wp.z(e);
            return j;
        }
    }

    public static double z(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            wp.z(e);
            return d;
        }
    }

    public static boolean z(String str, boolean z) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException e) {
            wp.z(e);
            return z;
        }
    }
}
