package org.minidns.util;

/* JADX INFO: compiled from: Base64.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static String a(byte[] bArr) {
        int length = (3 - (bArr.length % 3)) % 3;
        byte[] bArr2 = new byte[bArr.length + length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2 += 3) {
            int i3 = ((bArr2[i2] & 255) << 16) + ((bArr2[i2 + 1] & 255) << 8) + (bArr2[i2 + 2] & 255);
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i3 >> 18) & 63));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i3 >> 12) & 63));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i3 >> 6) & 63));
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i3 & 63));
        }
        return sb.substring(0, sb.length() - length) + "==".substring(0, length);
    }
}
