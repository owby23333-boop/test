package org.minidns.util;

/* JADX INFO: compiled from: Hex.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static StringBuilder a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02X ", Byte.valueOf(b)));
        }
        return sb;
    }
}
