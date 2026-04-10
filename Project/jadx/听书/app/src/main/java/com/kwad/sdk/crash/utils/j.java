package com.kwad.sdk.crash.utils;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    public static String aP(long j) {
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        return (j2 < 10 ? "0" + j2 : String.valueOf(j2)) + ":" + (j3 < 10 ? "0" + j3 : String.valueOf(j3));
    }
}
