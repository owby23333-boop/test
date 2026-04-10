package com.bytedance.sdk.openadsdk.core.tb;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static boolean z(long j, long j2) {
        return (j & j2) == j2;
    }

    public static boolean z(long j) {
        return z(j, z.USE_ALOG.z());
    }

    public static boolean g(long j) {
        return z(j, z.USE_PITAYA.z());
    }
}
