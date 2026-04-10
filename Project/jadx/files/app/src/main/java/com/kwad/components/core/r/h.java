package com.kwad.components.core.r;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static String a(long j2, boolean z2) {
        double d2;
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j2 <= 1) {
            return j2 + "B";
        }
        double d3 = j2;
        int iLog = (int) (Math.log(d3) / Math.log(1024.0d));
        if (j2 > 1024) {
            double dPow = Math.pow(1024.0d, iLog);
            Double.isNaN(d3);
            d2 = d3 / dPow;
        } else {
            Double.isNaN(d3);
            d2 = d3 / 1024.0d;
        }
        return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(d2), strArr[iLog]);
    }
}
