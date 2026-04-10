package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.z;

/* JADX INFO: compiled from: UMInternalUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2315a = z.b().b(z.r);
    private static final String b = "um_common_strength";
    private static final String c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f2315a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f2315a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(c, str).commit();
    }
}
