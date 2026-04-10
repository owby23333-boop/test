package com.ss.android.downloadlib.hj;

import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.socialbase.appdownloader.b.lz;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements x {
    @Override // com.ss.android.socialbase.appdownloader.b.x
    public void mb(DownloadInfo downloadInfo, lz lzVar) {
        com.ss.android.downloadad.api.mb.ox oxVarMb;
        if (downloadInfo != null && (oxVarMb = u.mb().mb(downloadInfo)) != null) {
            downloadInfo.setLinkMode(oxVarMb.yr());
        }
        if (lzVar != null) {
            lzVar.mb();
        }
    }
}
