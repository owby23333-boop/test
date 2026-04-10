package com.xiaomi.accountsdk.hasheddeviceidlib;

import com.google.common.base.Ascii;
import com.xiaomi.accountsdk.utils.AccountLogger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceIDCoder {
    private static final String TAG = "AccountCoder";

    public static String getDataMd5Digest(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                return getHexString(messageDigest.digest());
            } catch (Exception e) {
                AccountLogger.log(TAG, "getDataMd5Digest", e);
            }
        }
        return null;
    }

    public static String getHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] & 240) >> 4;
            sb.append((char) ((i2 < 0 || i2 > 9) ? (i2 + 97) - 10 : i2 + 48));
            int i3 = bArr[i] & Ascii.SI;
            sb.append((char) ((i3 < 0 || i3 > 9) ? (i3 + 97) - 10 : i3 + 48));
        }
        return sb.toString();
    }

    public static String getMd5DigestUpperCase(String str) {
        String dataMd5Digest;
        if (str == null || (dataMd5Digest = getDataMd5Digest(str.getBytes())) == null) {
            return null;
        }
        return dataMd5Digest.toUpperCase();
    }
}
