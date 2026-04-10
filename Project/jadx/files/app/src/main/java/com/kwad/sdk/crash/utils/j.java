package com.kwad.sdk.crash.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static String Z(long j2) {
        String strValueOf;
        String strValueOf2;
        long j3 = j2 / 60000;
        long j4 = (j2 - (60000 * j3)) / 1000;
        if (j3 < 10) {
            strValueOf = "0" + j3;
        } else {
            strValueOf = String.valueOf(j3);
        }
        if (j4 < 10) {
            strValueOf2 = "0" + j4;
        } else {
            strValueOf2 = String.valueOf(j4);
        }
        return strValueOf + ":" + strValueOf2;
    }
}
