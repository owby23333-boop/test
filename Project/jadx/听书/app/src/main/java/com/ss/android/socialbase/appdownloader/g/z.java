package com.ss.android.socialbase.appdownloader.g;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    public static final String z;

    static {
        StringBuilder sb = new StringBuilder("AppDownloader");
        boolean z2 = !TextUtils.isEmpty(Build.VERSION.RELEASE);
        boolean z3 = !TextUtils.isEmpty(Build.ID);
        boolean z4 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        if (z2) {
            sb.append("/").append(Build.VERSION.RELEASE);
        }
        sb.append(" (Linux; U; Android");
        if (z2) {
            sb.append(" ").append(Build.VERSION.RELEASE);
        }
        if (z4 || z3) {
            sb.append(";");
            if (z4) {
                sb.append(" ").append(Build.MODEL);
            }
            if (z3) {
                sb.append(" Build/").append(Build.ID);
            }
        }
        sb.append(")");
        z = sb.toString();
    }
}
