package com.kwad.library.solder.lib;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static String zJ() {
        return "";
    }

    public static void e(String str, String str2) {
        Log.e("Sodler", D(str, str2));
    }

    public static void e(String str, Throwable th) {
        Log.e("Sodler", D(str, ""), th);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e("Sodler", D(str, str2), th);
    }

    private static String D(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + zJ();
    }
}
