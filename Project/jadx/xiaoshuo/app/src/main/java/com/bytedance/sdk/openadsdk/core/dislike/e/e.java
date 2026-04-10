package com.bytedance.sdk.openadsdk.core.dislike.e;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    private static d bf = null;
    private static tg d = null;
    private static volatile boolean e = false;

    public static tg bf() {
        return d;
    }

    public static void e(d dVar, tg tgVar) {
        if (e) {
            return;
        }
        e = true;
        bf = dVar;
        d = tgVar;
    }

    public static d e() {
        return bf;
    }
}
