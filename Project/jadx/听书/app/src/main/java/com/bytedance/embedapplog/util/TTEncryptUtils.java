package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.cb;
import com.bytedance.sdk.openadsdk.hh.m;

/* JADX INFO: loaded from: classes2.dex */
public class TTEncryptUtils {
    public static native String clientPackedBase64(byte[] bArr, int i);

    public static native byte[] clientUnpackedBase64(String str);

    public static native String getDA0Result(String str);

    public static native int[] getDI0Result(String[] strArr);

    private static native byte[] ttEncrypt(byte[] bArr, int i);

    static {
        try {
            m.z("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            cb.g(e);
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }
}
