package com.xiaomi.push;

import java.util.Random;

/* JADX INFO: loaded from: classes8.dex */
public class hr {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final char[] f510a = "&quot;".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f8052b = "&apos;".toCharArray();
    private static final char[] c = "&amp;".toCharArray();
    private static final char[] d = "&lt;".toCharArray();
    private static final char[] e = "&gt;".toCharArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Random f8051a = new Random();
    private static char[] f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (((double) length) * 1.3d));
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 <= '>') {
                if (c2 == '<') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(d);
                } else if (c2 == '>') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(e);
                } else if (c2 == '&') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    int i3 = i + 5;
                    if (length <= i3 || charArray[i + 1] != '#' || !Character.isDigit(charArray[i + 2]) || !Character.isDigit(charArray[i + 3]) || !Character.isDigit(charArray[i + 4]) || charArray[i3] != ';') {
                        i2 = i + 1;
                        sb.append(c);
                    }
                } else if (c2 == '\"') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(f510a);
                } else if (c2 == '\'') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(f8052b);
                }
            }
            i++;
        }
        if (i2 == 0) {
            return str;
        }
        if (i > i2) {
            sb.append(charArray, i2, i - i2);
        }
        return sb.toString();
    }

    public static final String b(String str) {
        return a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", com.alipay.sdk.m.w.a.p);
    }

    public static final String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(str2, 0);
        if (iIndexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, iIndexOf);
        sb.append(charArray2);
        int i = iIndexOf + length;
        while (true) {
            int iIndexOf2 = str.indexOf(str2, i);
            if (iIndexOf2 > 0) {
                sb.append(charArray, i, iIndexOf2 - i);
                sb.append(charArray2);
                i = iIndexOf2 + length;
            } else {
                sb.append(charArray, i, charArray.length - i);
                return sb.toString();
            }
        }
    }

    public static String a(byte[] bArr) {
        return String.valueOf(bl.a(bArr));
    }

    public static String a(int i) {
        if (i < 1) {
            return null;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = f[f8051a.nextInt(71)];
        }
        return new String(cArr);
    }
}
