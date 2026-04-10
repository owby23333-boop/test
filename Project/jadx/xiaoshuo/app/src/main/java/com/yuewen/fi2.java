package com.yuewen;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes12.dex */
public class fi2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f11137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f11138b;

    public static boolean a(Context context, String str) {
        try {
            if (f11137a == null) {
                f11137a = context.getClass().getMethod("checkSelfPermission", String.class);
            }
            try {
                return ((Integer) f11137a.invoke(context, str)).intValue() == 0;
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                return false;
            }
        } catch (NoSuchMethodException unused2) {
            return true;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean c(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT < 29;
    }

    public static void e(String str) {
    }
}
