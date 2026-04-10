package com.amgcyo.cuttadon.utils.otherutils;

import java.util.ArrayList;

/* JADX INFO: compiled from: Single.java */
/* JADX INFO: loaded from: classes.dex */
public class o0 {
    private static o0 a;
    private static ArrayList b;

    private o0() {
    }

    public static o0 b() {
        if (a == null) {
            a = new o0();
            b = new ArrayList();
        }
        return a;
    }

    public ArrayList a() {
        return b;
    }
}
