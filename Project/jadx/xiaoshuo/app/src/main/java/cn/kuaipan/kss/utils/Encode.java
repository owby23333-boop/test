package cn.kuaipan.kss.utils;

import com.google.common.base.Ascii;
import com.xiaomi.ad.y;
import com.yuewen.gm;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class Encode {
    static final String[] HEXDIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", y.j, gm.a.f11596b, "d", "e", gm.a.f11595a};

    public static String MD5Encode(byte[] bArr) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String SHA1Encode(byte[] bArr) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("sha1").digest(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String byteArrayToHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String[] strArr = HEXDIGITS;
            stringBuffer.append(strArr[(bArr[i] >>> 4) & 15]);
            stringBuffer.append(strArr[bArr[i] & Ascii.SI]);
        }
        return stringBuffer.toString();
    }

    public static int byteArrayToInt(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static long byteArrayToLong(byte[] bArr, int i) {
        int i2 = i + 8;
        long j = bArr[i];
        while (true) {
            i++;
            if (i >= i2) {
                return j;
            }
            j = (j << 8) | ((long) (bArr[i] & 255));
        }
    }

    public static short byteArrayToShort(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | (bArr[i] << 8));
    }

    public static String byteToHexString(byte b2) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = HEXDIGITS;
        sb.append(strArr[(b2 >>> 4) & 15]);
        sb.append(strArr[b2 & Ascii.SI]);
        return sb.toString();
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) * 16) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String intToHexString(int i) {
        return byteArrayToHexString(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)});
    }

    public static String longToHexString(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((j >> ((7 - i) * 8)) & 255);
        }
        return byteArrayToHexString(bArr);
    }
}
