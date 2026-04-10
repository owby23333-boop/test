package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class fo implements com.ss.android.socialbase.downloader.downloader.i {
    @Override // com.ss.android.socialbase.downloader.downloader.i
    public int z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strGc = com.ss.android.socialbase.downloader.pf.m.gc(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strGc)) {
            return 0;
        }
        return strGc.hashCode();
    }
}
