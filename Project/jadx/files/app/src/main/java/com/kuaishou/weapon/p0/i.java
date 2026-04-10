package com.kuaishou.weapon.p0;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static byte a(byte b, byte b2) {
        return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b2})).byteValue()));
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(c(c(str), str2));
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            stringBuffer.append((char) b);
        }
        return stringBuffer.toString();
    }

    private static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr[i2] = (byte) i2;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int length = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i3 = ((bytes[length] & 255) + (bArr[i4] & 255) + i3) & 255;
            byte b = bArr[i4];
            bArr[i4] = bArr[i3];
            bArr[i3] = b;
            length = (length + 1) % bytes.length;
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static String b(String str) {
        String str2 = "";
        for (int i2 = 0; i2 < str.length(); i2++) {
            String hexString = Integer.toHexString(str.charAt(i2) & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    private static byte[] b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return c(str.getBytes(), str2);
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = a(bytes[i3], bytes[i3 + 1]);
        }
        return bArr;
    }

    private static byte[] c(byte[] bArr, String str) {
        byte[] bArrA = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) & 255;
            i3 = ((bArrA[i2] & 255) + i3) & 255;
            byte b = bArrA[i2];
            bArrA[i2] = bArrA[i3];
            bArrA[i3] = b;
            int i5 = ((bArrA[i2] & 255) + (bArrA[i3] & 255)) & 255;
            bArr2[i4] = (byte) (bArrA[i5] ^ bArr[i4]);
        }
        return bArr2;
    }
}
