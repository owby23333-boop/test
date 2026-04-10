package com.bytedance.mapplog.util;

import bykvm_19do.bykvm_19do.bykvm_19do.l0;

/* JADX INFO: loaded from: classes2.dex */
public class TTEncryptUtils {
    private static boolean a = true;

    static {
        try {
            System.loadLibrary("tobEmbedEncryptForM");
            a = true;
        } catch (UnsatisfiedLinkError e2) {
            a = false;
            l0.a(e2);
            for (int i2 = 0; i2 < 20; i2++) {
                l0.c("********** --==-- 注意：GroMore so库【tobEmbedEncryptForM】未打进apk中，请检查打包环节 --==-- **********", null);
            }
        }
    }

    public static boolean a() {
        return a;
    }

    public static byte[] a(byte[] bArr, int i2) {
        try {
            return ttEncrypt(bArr, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static native byte[] ttEncrypt(byte[] bArr, int i2);
}
