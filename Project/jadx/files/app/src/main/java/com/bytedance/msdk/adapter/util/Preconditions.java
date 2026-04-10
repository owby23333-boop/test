package com.bytedance.msdk.adapter.util;

import android.os.Looper;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes2.dex */
public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";

    public static final class NoThrow {
        private static volatile boolean a;

        public static boolean checkArgument(boolean z2) {
            return Preconditions.c(z2, a, "Illegal argument", "");
        }

        public static boolean checkArgument(boolean z2, String str) {
            return Preconditions.c(z2, a, str, "");
        }

        public static boolean checkArgument(boolean z2, String str, Object... objArr) {
            return Preconditions.c(z2, a, str, objArr);
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.b(obj, a, "Object can not be null.", "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.b(obj, a, str, "");
        }

        public static boolean checkNotNull(Object obj, String str, Object... objArr) {
            return Preconditions.b(obj, a, str, objArr);
        }

        public static boolean checkState(boolean z2) {
            return Preconditions.d(z2, a, "Illegal state.", "");
        }

        public static boolean checkState(boolean z2, String str) {
            return Preconditions.d(z2, a, str, "");
        }

        public static boolean checkState(boolean z2, String str, Object... objArr) {
            return Preconditions.d(z2, a, str, objArr);
        }

        public static boolean checkUiThread() {
            return Preconditions.b(a, "This method must be called from the UI thread.", "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.b(a, str, "");
        }

        public static boolean checkUiThread(String str, Object... objArr) {
            return Preconditions.b(false, str, objArr);
        }

        public static void setStrictMode(boolean z2) {
            a = z2;
        }
    }

    private Preconditions() {
    }

    private static String a(String str, Object... objArr) {
        String strValueOf = String.valueOf(str);
        try {
            return String.format(strValueOf, objArr);
        } catch (IllegalFormatException e2) {
            Logger.e("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e2.getMessage());
            return strValueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Object obj, boolean z2, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String strA = a(str, objArr);
        if (z2) {
            throw new NullPointerException(strA);
        }
        Logger.e("TTMediationSDK_ADAPTER", strA);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(boolean z2, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String strA = a(str, objArr);
        if (z2) {
            throw new IllegalStateException(strA);
        }
        Logger.e("TTMediationSDK_ADAPTER", strA);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(boolean z2, boolean z3, String str, Object... objArr) {
        if (z2) {
            return true;
        }
        String strA = a(str, objArr);
        if (z3) {
            throw new IllegalArgumentException(strA);
        }
        Logger.e("TTMediationSDK_ADAPTER", strA);
        return false;
    }

    public static void checkArgument(boolean z2) {
        c(z2, true, "Illegal argument.", "");
    }

    public static void checkArgument(boolean z2, String str) {
        c(z2, true, str, "");
    }

    public static void checkArgument(boolean z2, String str, Object... objArr) {
        c(z2, true, str, objArr);
    }

    public static void checkNotNull(Object obj) {
        b(obj, true, "Object can not be null.", "");
    }

    public static void checkNotNull(Object obj, String str) {
        b(obj, true, str, "");
    }

    public static void checkNotNull(Object obj, String str, Object... objArr) {
        b(obj, true, str, objArr);
    }

    public static void checkState(boolean z2) {
        d(z2, true, "Illegal state.", "");
    }

    public static void checkState(boolean z2, String str) {
        d(z2, true, str, "");
    }

    public static void checkState(boolean z2, String str, Object... objArr) {
        d(z2, true, str, objArr);
    }

    public static void checkUiThread() {
        b(true, "This method must be called from the UI thread.", "");
    }

    public static void checkUiThread(String str) {
        b(true, str, "");
    }

    public static void checkUiThread(String str, Object... objArr) {
        b(true, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(boolean z2, boolean z3, String str, Object... objArr) {
        if (z2) {
            return true;
        }
        String strA = a(str, objArr);
        if (z3) {
            throw new IllegalStateException(strA);
        }
        Logger.e("TTMediationSDK_ADAPTER", strA);
        return false;
    }
}
