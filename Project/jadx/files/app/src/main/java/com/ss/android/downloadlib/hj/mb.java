package com.ss.android.downloadlib.hj;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.socialbase.appdownloader.b.lz;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class mb implements x {
    /* JADX INFO: Access modifiers changed from: private */
    public void ox(DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.mb mbVar) {
        com.ss.android.downloadad.api.mb.ox oxVarMb = u.mb().mb(downloadInfo);
        boolean zMb = com.ss.android.downloadlib.ox.u.mb(oxVarMb);
        boolean zOx = com.ss.android.downloadlib.ox.u.ox(oxVarMb);
        if (zMb && zOx) {
            com.ss.android.downloadlib.ox.b.mb(oxVarMb, new com.ss.android.downloadlib.guide.install.mb() { // from class: com.ss.android.downloadlib.hj.mb.3
                @Override // com.ss.android.downloadlib.guide.install.mb
                public void mb() {
                    mbVar.mb();
                }
            });
        } else {
            mbVar.mb();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.x
    public void mb(DownloadInfo downloadInfo, final lz lzVar) {
        mb(downloadInfo, new com.ss.android.downloadlib.guide.install.mb() { // from class: com.ss.android.downloadlib.hj.mb.1
            @Override // com.ss.android.downloadlib.guide.install.mb
            public void mb() {
                lzVar.mb();
            }
        });
    }

    public void mb(final DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.mb mbVar) {
        com.ss.android.downloadad.api.mb.ox oxVarMb = u.mb().mb(downloadInfo);
        if (oxVarMb != null && com.ss.android.downloadlib.ox.lz.mb(oxVarMb)) {
            TTDelegateActivity.mb(oxVarMb, new com.ss.android.downloadlib.guide.install.mb() { // from class: com.ss.android.downloadlib.hj.mb.2
                @Override // com.ss.android.downloadlib.guide.install.mb
                public void mb() {
                    mb.this.ox(downloadInfo, mbVar);
                }
            });
        } else {
            ox(downloadInfo, mbVar);
        }
    }
}
