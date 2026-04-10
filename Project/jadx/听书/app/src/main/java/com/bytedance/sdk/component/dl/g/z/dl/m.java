package com.bytedance.sdk.component.dl.g.z.dl;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static boolean z(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean g(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean dl(String str) {
        return g(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean a(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean gc(String str) {
        return !str.equals("PROPFIND");
    }
}
