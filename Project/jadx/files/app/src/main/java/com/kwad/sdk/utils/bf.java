package com.kwad.sdk.utils;

import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class bf {
    public static String H(long j2) {
        if (j2 <= 0 || j2 >= 86400000) {
            return "00:00";
        }
        try {
            long j3 = j2 / 1000;
            long j4 = j3 % 60;
            long j5 = (j3 / 60) % 60;
            long j6 = j3 / com.anythink.expressad.d.a.b.P;
            Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
            return j6 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j4)).toString() : formatter.format("%02d:%02d", Long.valueOf(j5), Long.valueOf(j4)).toString();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return "";
        }
    }
}
