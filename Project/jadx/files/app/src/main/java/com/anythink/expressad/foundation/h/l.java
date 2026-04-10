package com.anythink.expressad.foundation.h;

import com.umeng.analytics.pro.cb;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    protected static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10670c = "SameFileMD5";

    static {
        b = null;
        try {
            b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            System.err.println(l.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e2.printStackTrace();
        }
    }

    private static String a(String str) {
        return a(new File(str));
    }

    public static String a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    b.update(fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
                    byte[] bArrDigest = b.digest();
                    String strA = a(bArrDigest, bArrDigest.length);
                    fileInputStream.close();
                    return strA;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    o.b(f10670c, "FILE EXCEPTION", e);
                    if (fileInputStream2 == null) {
                        return "";
                    }
                    fileInputStream2.close();
                    return "";
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static String a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    private static String a(byte[] bArr, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + 0;
        for (int i4 = 0; i4 < i3; i4++) {
            a(bArr[i4], stringBuffer);
        }
        return stringBuffer.toString();
    }

    private static void a(byte b2, StringBuffer stringBuffer) {
        char[] cArr = a;
        char c2 = cArr[(b2 & 240) >> 4];
        char c3 = cArr[b2 & cb.f19604m];
        stringBuffer.append(c2);
        stringBuffer.append(c3);
    }
}
