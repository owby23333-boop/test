package com.anythink.core.common.k;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            context.getSharedPreferences(str, 0).edit().remove(str2).apply();
        } catch (Error | Exception unused) {
        }
    }

    private static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            context.getSharedPreferences(str, 0).edit().clear().apply();
        } catch (Error | Exception unused) {
        }
    }

    public static void a(Context context, String str, String str2, long j2) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putLong(str2, j2);
            editorEdit.apply();
        } catch (Error | Exception unused) {
        }
    }

    public static int b(Context context, String str, String str2, int i2) {
        if (context == null) {
            return i2;
        }
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i2);
        } catch (Error | Exception unused) {
            return i2;
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Error | Exception unused) {
            return str3;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putString(str2, String.valueOf(str3));
            editorEdit.apply();
        } catch (Error | Exception unused) {
        }
    }

    private static boolean b(Context context, String str, String str2, boolean z2) {
        if (context == null) {
            return z2;
        }
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z2);
        } catch (Exception unused) {
            return z2;
        }
    }

    public static void a(Context context, String str, String str2, int i2) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putInt(str2, i2);
            editorEdit.apply();
        } catch (Error | Exception unused) {
        }
    }

    public static Long a(Context context, String str, String str2, Long l2) {
        if (context == null) {
            return 0L;
        }
        try {
            return Long.valueOf(context.getSharedPreferences(str, 0).getLong(str2, l2.longValue()));
        } catch (Error | Exception unused) {
            return l2;
        }
    }

    public static Map<String, ?> a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getAll();
        } catch (Error | Exception unused) {
            return null;
        }
    }

    private static void a(Context context, String str, String str2, boolean z2) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putBoolean(str2, z2);
            editorEdit.apply();
        } catch (Exception unused) {
        }
    }
}
