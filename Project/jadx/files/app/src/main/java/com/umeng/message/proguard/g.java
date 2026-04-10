package com.umeng.message.proguard;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: AESStringUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static byte[] a(String str) {
        return a(str, "UTF-8");
    }

    public static byte[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e2) {
            throw a(str2, e2);
        }
    }

    private static IllegalStateException a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            throw a(str, e2);
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, "UTF-8");
    }
}
