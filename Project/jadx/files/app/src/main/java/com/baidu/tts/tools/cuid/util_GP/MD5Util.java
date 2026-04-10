package com.baidu.tts.tools.cuid.util_GP;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
final class MD5Util {
    private MD5Util() {
    }

    public static String toHexString(byte[] bArr, String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z2) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String toMd5(byte[] bArr, boolean z2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z2);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
