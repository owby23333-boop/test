package com.xiaomi.passport.encrypt;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes8.dex */
public class Hex {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String get(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i = 0; i < length; i++) {
            char[] cArr = HEX_CHARS;
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & Ascii.SI]);
        }
        return sb.toString();
    }
}
