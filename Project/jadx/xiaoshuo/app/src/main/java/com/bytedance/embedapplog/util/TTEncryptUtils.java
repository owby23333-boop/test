package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.tx;

/* JADX INFO: loaded from: classes.dex */
public class TTEncryptUtils {
    static {
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            tx.bf(e);
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static native byte[] ttEncrypt(byte[] bArr, int i);
}
