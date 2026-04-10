package com.bytedance.sdk.component.d.bf.e.d;

/* JADX INFO: loaded from: classes.dex */
public final class vn {
    public static boolean bf(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean d(String str) {
        return bf(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean e(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean ga(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean tg(String str) {
        return str.equals("PROPFIND");
    }
}
