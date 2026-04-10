package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static SharedPreferences a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f4a = true;
    private static boolean b = true;

    static void a(Context context) {
        if (context != null) {
            a = context.getSharedPreferences("httpdns_config_enable", 0);
            SharedPreferences sharedPreferences = a;
            if (sharedPreferences != null) {
                f4a = sharedPreferences.getBoolean("key_enable", true);
            }
        }
    }

    public static void a(boolean z2) {
        f4a = z2;
        SharedPreferences sharedPreferences = a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("key_enable", z2);
            editorEdit.apply();
        }
    }

    public static boolean a() {
        return f4a && b;
    }

    public static void b(boolean z2) {
        b = z2;
    }
}
