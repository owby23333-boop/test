package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static SimpleDateFormat asC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String Y(long j2) {
        return j2 <= 0 ? "unknown" : asC.format(new Date(j2));
    }
}
