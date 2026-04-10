package com.xiaomi.ad;

import com.xiaomi.ad.mediation.MMAdSdk;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7279a = "https://test.ad.xiaomi.com/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7280b = "https://api.ad.xiaomi.com/";

    public static String a(String str) {
        StringBuilder sb;
        String str2;
        if (MMAdSdk.getAdConfig().isStaging) {
            sb = new StringBuilder();
            str2 = f7279a;
        } else {
            sb = new StringBuilder();
            str2 = f7280b;
        }
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }
}
