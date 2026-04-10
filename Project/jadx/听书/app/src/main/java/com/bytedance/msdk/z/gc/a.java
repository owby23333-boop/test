package com.bytedance.msdk.z.gc;

import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static void z(Object obj) {
        z(obj, true, "Object can not be null.", "");
    }

    private static boolean z(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String strZ = z(str, objArr);
        if (z) {
            throw new NullPointerException(strZ);
        }
        dl.a("TTMediationSDK_ADAPTER", strZ);
        return false;
    }

    private static String z(String str, Object... objArr) {
        String strValueOf = String.valueOf(str);
        try {
            return String.format(strValueOf, objArr);
        } catch (IllegalFormatException e) {
            dl.a("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e.getMessage());
            return strValueOf;
        }
    }
}
