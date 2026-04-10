package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: AppSpUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static String a = "AndroidDB";

    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences(a, 0).getString(str, str2);
    }

    public static boolean b(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(a, 0).edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }

    public static boolean a(Context context, String str, boolean z2) {
        return context.getSharedPreferences(a, 0).getBoolean(str, z2);
    }

    public static boolean b(Context context, String str, boolean z2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(a, 0).edit();
        editorEdit.putBoolean(str, z2);
        return editorEdit.commit();
    }
}
