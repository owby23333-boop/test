package com.bytedance.adsdk.e.bf.tg;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static boolean bf(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static boolean d(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean e(char c) {
        return c == ' ';
    }

    public static boolean tg(char c) {
        return '+' == c || '-' == c || '*' == c || '/' == c || '%' == c || '=' == c || '>' == c || '<' == c || '!' == c || '&' == c || '|' == c || '?' == c || ':' == c;
    }
}
