package com.sntech.net.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.sntech.net.utils.if, reason: invalid class name */
/* JADX INFO: compiled from: CryptoUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cif {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final byte[] f92do = C0506if.m107do("x04VOtkJ");

    /* JADX INFO: renamed from: com.sntech.net.utils.if$do, reason: invalid class name */
    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class Cdo {
        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static byte[] m105do(byte[] bArr) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.sntech.net.utils.if$if, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class C0506if {
        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static String m106do(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                for (byte b : messageDigest.digest()) {
                    int i2 = b & 255;
                    if (i2 < 16) {
                        stringBuffer.append("0" + Integer.toHexString(i2));
                    } else {
                        stringBuffer.append(Integer.toHexString(i2));
                    }
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "No";
            }
        }

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static byte[] m107do(String str) {
            if (str == null) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
    }
}
