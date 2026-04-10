package com.bytedance.sdk.openadsdk.core.f;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    public static boolean bf(long j) {
        return e(j, e.USE_ALOG.e());
    }

    public static boolean d(long j) {
        return e(j, e.USE_PITAYA.e());
    }

    private static boolean e(long j, long j2) {
        return (j & j2) == j2;
    }

    public static boolean e(long j) {
        return e(j, e.USE_KWS.e());
    }
}
