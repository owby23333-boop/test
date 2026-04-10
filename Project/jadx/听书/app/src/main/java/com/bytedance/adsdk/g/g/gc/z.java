package com.bytedance.adsdk.g.g.gc;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static boolean a(char c) {
        return '+' == c || '-' == c || '*' == c || '/' == c || '%' == c || '=' == c || '>' == c || '<' == c || '!' == c || '&' == c || '|' == c || '?' == c || ':' == c;
    }

    public static boolean dl(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean g(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public static boolean z(char c) {
        return c == ' ';
    }
}
