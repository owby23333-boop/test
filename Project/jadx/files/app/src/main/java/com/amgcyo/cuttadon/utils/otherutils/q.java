package com.amgcyo.cuttadon.utils.otherutils;

/* JADX INFO: compiled from: FastClickUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class q {
    private static long a;

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = jCurrentTimeMillis - a < 500;
        a = jCurrentTimeMillis;
        return z2;
    }
}
