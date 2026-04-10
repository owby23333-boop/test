package org.minidns.util;

/* JADX INFO: compiled from: Base32.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static String a(byte[] bArr) {
        double length = bArr.length % 5;
        Double.isNaN(length);
        int i2 = ((int) (8.0d - (length * 1.6d))) % 8;
        byte[] bArr2 = new byte[bArr.length + i2];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < bArr.length; i3 += 5) {
            long j2 = (((long) (bArr2[i3] & 255)) << 32) + (((long) (bArr2[i3 + 1] & 255)) << 24) + ((long) ((bArr2[i3 + 2] & 255) << 16)) + ((long) ((bArr2[i3 + 3] & 255) << 8)) + ((long) (bArr2[i3 + 4] & 255));
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j2 >> 35) & 31)));
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j2 >> 30) & 31)));
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j2 >> 25) & 31)));
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j2 >> 20) & 31)));
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j2 >> 15) & 31)));
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j2 >> 10) & 31)));
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j2 >> 5) & 31)));
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) (j2 & 31)));
        }
        return sb.substring(0, sb.length() - i2) + "======".substring(0, i2);
    }
}
