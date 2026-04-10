package com.yuewen;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.yuewen.gm;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class kw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f13734a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", com.xiaomi.ad.y.j, gm.a.f11596b, "d", "e", gm.a.f11595a};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f13734a;
            sb.append(strArr[i / 16]);
            sb.append(strArr[i % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    public static String b(File file) throws Throwable {
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
            }
            String strA = a(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return strA;
        } catch (Exception unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static String c(String str) {
        String str2 = null;
        try {
            String str3 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str3.getBytes("UTF-8")));
            } catch (Exception unused) {
                str2 = str3;
                return str2;
            }
        } catch (Exception unused2) {
        }
    }

    public static String d(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(Base64.decode(str, 0)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] e(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < str.length() - 1; i += 2) {
            char cCharAt = str.charAt(i);
            char cCharAt2 = str.charAt(i + 1);
            char lowerCase = Character.toLowerCase(cCharAt);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            int i2 = ((lowerCase <= '9' ? lowerCase - '0' : (lowerCase - 'a') + 10) << 4) + (lowerCase2 <= '9' ? lowerCase2 - '0' : (lowerCase2 - 'a') + 10);
            if (i2 > 127) {
                i2 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i / 2] = (byte) i2;
        }
        return bArr;
    }
}
