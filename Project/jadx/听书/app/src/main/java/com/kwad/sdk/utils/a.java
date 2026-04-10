package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static byte[] getFileMD5Digest(File file) {
        MessageDigest messageDigest;
        byte[] bArr;
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            bArr = new byte[4096];
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("FileMD5Utils", "getting file md5 digest error.", e);
            return null;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
        }
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i != -1) {
                messageDigest.update(bArr, 0, i);
            } else {
                return messageDigest.digest();
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
        }
    }

    public static byte[] gN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileMD5Digest(new File(str));
    }

    public static String getFileMD5(File file) {
        try {
            byte[] fileMD5Digest = getFileMD5Digest(file);
            if (fileMD5Digest != null && fileMD5Digest.length != 0) {
                return al.toHexString(fileMD5Digest, 0, fileMD5Digest.length);
            }
            return null;
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.e("FileMD5Utils", "cannot calculate md5 of file", e);
            return null;
        }
    }
}
