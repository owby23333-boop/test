package com.bytedance.msdk.gz;

/* JADX INFO: loaded from: classes2.dex */
public class pf {
    private static boolean z = true;

    public static byte[] z(byte[] bArr, int i) {
        com.bytedance.sdk.component.a.gc gcVar = (com.bytedance.sdk.component.a.gc) com.bytedance.sdk.openadsdk.ats.dl.z("embed_applog");
        return gcVar != null ? gcVar.encrypt(bArr, i) : new byte[0];
    }

    public static boolean z() {
        com.bytedance.msdk.z.gc.dl.g("TMe", "applogSOLoadSuccess = " + z);
        return z;
    }

    static {
        try {
            com.bytedance.sdk.openadsdk.hh.m.z("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError unused) {
            z = false;
        }
    }
}
