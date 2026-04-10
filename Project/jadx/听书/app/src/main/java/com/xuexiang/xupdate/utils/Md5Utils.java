package com.xuexiang.xupdate.utils;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public final class Md5Utils {
    private Md5Utils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static String getFileMD5(File file) {
        if (!FileUtils.isFileExists(file)) {
            return "";
        }
        InputStream fileInputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = FileUtils.getFileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        String strBytes2Hex = bytes2Hex(messageDigest.digest());
                        FileUtils.closeIOQuietly(fileInputStream);
                        return strBytes2Hex;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                FileUtils.closeIOQuietly(fileInputStream);
                return "";
            }
        } catch (Throwable th) {
            FileUtils.closeIOQuietly(fileInputStream);
            throw th;
        }
    }

    private static String bytes2Hex(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        char[] cArr2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
