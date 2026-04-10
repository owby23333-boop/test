package com.ss.android.downloadlib.hj;

import com.ss.android.socialbase.appdownloader.b.lz;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b implements x {
    private static volatile b mb;
    private List<x> ox = new ArrayList();

    private b() {
        this.ox.add(new ox());
        this.ox.add(new mb());
    }

    public static b mb() {
        if (mb == null) {
            synchronized (b.class) {
                if (mb == null) {
                    mb = new b();
                }
            }
        }
        return mb;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.x
    public void mb(DownloadInfo downloadInfo, lz lzVar) {
        if (downloadInfo != null && this.ox.size() != 0) {
            mb(downloadInfo, 0, lzVar);
        } else if (lzVar != null) {
            lzVar.mb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(final DownloadInfo downloadInfo, final int i2, final lz lzVar) {
        if (i2 != this.ox.size() && i2 >= 0) {
            this.ox.get(i2).mb(downloadInfo, new lz() { // from class: com.ss.android.downloadlib.hj.b.1
                @Override // com.ss.android.socialbase.appdownloader.b.lz
                public void mb() {
                    b.this.mb(downloadInfo, i2 + 1, lzVar);
                }
            });
        } else {
            lzVar.mb();
        }
    }
}
