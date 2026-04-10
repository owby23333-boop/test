package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    private static volatile ox mb;
    private Handler ox = null;

    public static ox mb() {
        if (mb == null) {
            synchronized (ox.class) {
                if (mb == null) {
                    mb = new ox();
                }
            }
        }
        return mb;
    }

    public boolean ox() {
        return x.lz().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void mb(Context context, DownloadInfo downloadInfo) {
        if (ox() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.ox == null) {
                this.ox = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.ox.1
                @Override // java.lang.Runnable
                public void run() {
                    x.b().mb(3, x.getContext(), null, "下载失败，请重试！", null, 0);
                    h hVarMb = com.ss.android.downloadlib.ko.mb().mb(url);
                    if (hVarMb != null) {
                        hVarMb.ko();
                    }
                }
            });
        }
    }
}
