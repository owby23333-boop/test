package com.danikula.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: ProxyCacheUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    static void a(byte[] bArr, long j2, int i2) {
        k.a(bArr, "Buffer must be not null!");
        k.a(j2 >= 0, "Data offset must be positive!");
        k.a(i2 >= 0 && i2 <= bArr.length, "Length must be in range [0..buffer.length]");
    }

    static String b(String str) {
        try {
            return URLDecoder.decode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error decoding url", e2);
        }
    }

    static String c(String str) {
        try {
            return URLEncoder.encode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error encoding url", e2);
        }
    }

    static String d(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                j.b("Error closing resource");
            }
        }
    }

    public static String a(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }
}
