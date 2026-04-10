package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static String mb = "b";
    private static volatile b ox;
    private ConcurrentHashMap<Long, Runnable> b;

    public b() {
        this.b = null;
        this.b = new ConcurrentHashMap<>();
    }

    public static b mb() {
        if (ox == null) {
            synchronized (b.class) {
                if (ox == null) {
                    ox = new b();
                }
            }
        }
        return ox;
    }

    public long ox() {
        return x.lz().optLong("quick_app_check_internal", 1200L);
    }

    public void mb(h hVar, boolean z2, int i2, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i2 == 4) {
            if (!z2) {
                mb(id, false, 2);
                hVar.ox(false);
                return;
            } else {
                mb(id, true, 2);
                return;
            }
        }
        if (i2 == 5) {
            if (!z2) {
                mb(id, false, 1);
                hVar.b(false);
                return;
            } else {
                mb(id, true, 1);
                return;
            }
        }
        if (i2 != 7) {
            return;
        }
        Runnable runnableRemove = this.b.remove(Long.valueOf(id));
        if (z2) {
            AdEventHandler.mb().mb(id, 1);
            mb(id, true, 1);
        } else {
            if (runnableRemove != null) {
                com.ss.android.downloadlib.ko.mb().ox().post(runnableRemove);
            }
            mb(id, false, 1);
        }
    }

    private void mb(long j2, boolean z2, int i2) {
        AdEventHandler.mb().mb(j2, z2, i2);
        if (z2) {
            x.gm().mb(null, null, null, null, null, 3);
        }
    }

    public void mb(final h hVar, final int i2, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.ox.h.mb().mb(new com.ss.android.downloadlib.ox.hj() { // from class: com.ss.android.downloadlib.addownload.b.1
            @Override // com.ss.android.downloadlib.ox.hj
            public void mb(boolean z2) {
                b.this.mb(hVar, z2, i2, downloadModel);
            }
        }, ox());
    }

    public static boolean mb(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
