package com.kwad.sdk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes4.dex */
public final class bf {
    public static String hj(String str) {
        try {
            return al.toHexString(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }

    public static String ac(File file) throws Throwable {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        byte[] bArr;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                bArr = new byte[4096];
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    String hexString = al.toHexString(messageDigest.digest());
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    return hexString;
                }
                th = th2;
                fileInputStream2 = fileInputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return null;
        }
    }
}
