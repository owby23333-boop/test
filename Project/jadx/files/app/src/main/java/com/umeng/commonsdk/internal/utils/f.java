package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: InfoPreference.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static final String a = "info";
    private static final String b = "ua";

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("ua", str).commit();
        }
    }

    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("info", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("ua", null);
        }
        return null;
    }
}
