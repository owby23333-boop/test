package com.tramini.plugin.a.k;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
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

    public static int a(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, 2);
        } catch (Error | Exception unused) {
            return 2;
        }
    }
}
