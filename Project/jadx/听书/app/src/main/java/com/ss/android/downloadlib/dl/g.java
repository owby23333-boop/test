package com.ss.android.downloadlib.dl;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.socialbase.downloader.a.v;

/* JADX INFO: loaded from: classes4.dex */
public class g implements v {
    @Override // com.ss.android.socialbase.downloader.a.v
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws com.ss.android.socialbase.downloader.gc.z {
        PackageInfo packageInfoZ = com.ss.android.socialbase.appdownloader.dl.z(wp.getContext(), dlVar, dlVar.kb(), dlVar.gz());
        if (packageInfoZ != null) {
            dlVar.gz(packageInfoZ.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.v
    public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return dlVar != null && com.ss.android.downloadlib.e.gc.g() && dlVar.ct() == null;
    }
}
