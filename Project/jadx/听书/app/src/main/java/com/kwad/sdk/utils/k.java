package com.kwad.sdk.utils;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static void r(String str, int i) {
        com.kwad.sdk.core.d.c.d("audioVideoLog", str + "_type_" + i + "_time_" + System.currentTimeMillis());
    }

    public static void aq(String str, String str2) {
        com.kwad.sdk.core.d.c.d("callbackLog", str + str2);
    }

    public static void b(String str, String str2, String str3, String str4) {
        aq(str, str2 + "_" + str3 + "_" + str4);
    }
}
