package com.kwad.sdk.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static void W(String str, String str2) {
        com.kwad.sdk.core.d.b.d("callbackLog", str + str2);
    }

    public static void e(String str, String str2, String str3, String str4) {
        W(str, str2 + "_" + str3 + "_" + str4);
    }

    public static void m(String str, int i2) {
        com.kwad.sdk.core.d.b.d("audioVideoLog", str + "_type_" + i2 + "_time_" + System.currentTimeMillis());
    }
}
