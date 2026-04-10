package com.yuewen;

/* JADX INFO: loaded from: classes5.dex */
public class oo {
    public static double a(double d) {
        return Math.round(d * 10.0d) / 10.0d;
    }

    public static double b(double d) {
        return d >= 2.0d ? Math.min(d + 0.5d, 10.0d) : w51.l;
    }

    public static double c(int i, double d, double d2) {
        return d(i) ? b(d) : a(d2);
    }

    public static boolean d(int i) {
        return i == 10080 || i == 10256;
    }
}
