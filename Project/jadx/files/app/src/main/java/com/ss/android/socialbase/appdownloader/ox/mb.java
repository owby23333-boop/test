package com.ss.android.socialbase.appdownloader.ox;

import android.os.Build;
import android.text.TextUtils;
import com.umeng.message.proguard.ad;

/* JADX INFO: loaded from: classes3.dex */
public class mb {
    public static final String mb;

    static {
        StringBuilder sb = new StringBuilder();
        boolean z2 = !TextUtils.isEmpty(Build.VERSION.RELEASE);
        boolean z3 = !TextUtils.isEmpty(Build.ID);
        boolean z4 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        sb.append("AppDownloader");
        if (z2) {
            sb.append("/");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append(" (Linux; U; Android");
        if (z2) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        if (z4 || z3) {
            sb.append(";");
            if (z4) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (z3) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(ad.f20406s);
        mb = sb.toString();
    }
}
