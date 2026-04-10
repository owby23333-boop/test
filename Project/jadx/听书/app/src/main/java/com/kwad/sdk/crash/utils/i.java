package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    private static SimpleDateFormat aRb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String aO(long j) {
        return j <= 0 ? "unknown" : aRb.format(new Date(j));
    }
}
