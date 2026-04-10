package cn.kuaipan.android.utils;

import android.util.Log;
import com.google.common.base.Ascii;
import com.xiaomi.ad.y;
import com.yuewen.gm;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class Encode {
    static final String[] HEXDIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", y.j, gm.a.f11596b, "d", "e", gm.a.f11595a};
    private static final String LOG_TAG = "Encode";

    public static String MD5Encode(byte[] bArr) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception e) {
            Log.e(LOG_TAG, "MD5Encode failed.", e);
            return null;
        }
    }

    public static String SHA1Encode(byte[] bArr) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("sha1").digest(bArr));
        } catch (Exception e) {
            Log.e(LOG_TAG, "SHA1Encode failed.", e);
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

    public static String SHA1Encode(InputStream inputStream) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i >= 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    return byteArrayToHexString(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "SHA1Encode failed.", e);
            return null;
        }
    }

    public static String SHA1Encode(InputStream inputStream, int i) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            byte[] bArr = new byte[16384];
            int i2 = 0;
            do {
                int i3 = inputStream.read(bArr, 0, Math.min(16384, i - i2));
                if (i3 < 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i3);
                i2 += i3;
            } while (i - i2 > 0);
            return byteArrayToHexString(messageDigest.digest());
        } catch (Exception e) {
            Log.e(LOG_TAG, "SHA1Encode failed.", e);
            return null;
        }
    }

    public static String SHA1Encode(File file) throws Throwable {
        FileInputStream fileInputStream;
        if (!file.exists() || !file.isFile()) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        String strSHA1Encode = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                try {
                    fileInputStream2.close();
                } catch (Throwable unused2) {
                }
                throw th;
            }
            try {
                strSHA1Encode = SHA1Encode(fileInputStream);
            } catch (IOException unused3) {
                Log.e(LOG_TAG, "Failed compute SHA1 for file: " + file);
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
            return strSHA1Encode;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            fileInputStream2.close();
            throw th;
        }
    }

    public static String SHA1Encode(RandomAccessFile randomAccessFile, long j, long j2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            byte[] bArr = new byte[8192];
            long j3 = j2 + j;
            randomAccessFile.seek(j);
            do {
                int i = randomAccessFile.read(bArr, 0, (int) Math.min(8192, j3 - j));
                if (i < 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
                j += (long) i;
            } while (j < j3);
            if (j < j3) {
                Log.w(LOG_TAG, "File size may not enough for sha1.");
                return null;
            }
            return byteArrayToHexString(messageDigest.digest());
        } catch (Exception e) {
            Log.e(LOG_TAG, "SHA1Encode failed.", e);
            return null;
        }
    }
}
