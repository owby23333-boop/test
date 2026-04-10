package com.yuewen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes12.dex */
public class hv1 {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return c(str.getBytes());
    }

    public static String b(byte b2) {
        int i = (b2 & 127) + (b2 < 0 ? 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i < 16 ? "0" : "");
        sb.append(Integer.toHexString(i).toLowerCase());
        return sb.toString();
    }

    public static String c(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr, 0, bArr.length);
                byte[] bArrDigest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : bArrDigest) {
                    stringBuffer.append(b(b2));
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static String d(File file) {
        int i;
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                try {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        while (true) {
                            int i2 = fileInputStream.read(bArr);
                            if (i2 > 0) {
                                messageDigest.update(bArr, 0, i2);
                            } else {
                                try {
                                    break;
                                } catch (IOException e) {
                                }
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        for (byte b2 : messageDigest.digest()) {
                            stringBuffer.append(b(b2));
                        }
                        return stringBuffer.toString();
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return null;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return null;
                }
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        } catch (FileNotFoundException e7) {
            e7.printStackTrace();
            return null;
        }
    }
}
