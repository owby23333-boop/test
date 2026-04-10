package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    private ScheduledExecutorService b;
    private ExecutorService mb;
    private ExecutorService ox;

    private static class mb {
        private static hj mb = new hj();
    }

    public static hj mb() {
        return mb.mb;
    }

    public ExecutorService b() {
        if (this.ox == null) {
            synchronized (hj.class) {
                if (this.ox == null) {
                    this.ox = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(ww.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.ox;
    }

    public void h() {
        mb(new Runnable() { // from class: com.ss.android.downloadlib.hj.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (hj.class) {
                    try {
                        for (String str : new String[]{"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", DownloadConstants.SP_ANTI_HIJACK_CONFIG, DownloadConstants.SP_DOWNLOAD_INFO, "sp_appdownloader"}) {
                            SharedPreferences sharedPreferences = x.getContext().getSharedPreferences(str, 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
                        if (!(downloadCache instanceof DefaultDownloadCache)) {
                            return;
                        }
                        SparseArray<DownloadInfo> downloadInfoMap = ((DefaultDownloadCache) downloadCache).getDownloadCache().getDownloadInfoMap();
                        for (int size = downloadInfoMap.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = downloadInfoMap.get(downloadInfoMap.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(x.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public ScheduledExecutorService hj() {
        if (this.b == null) {
            synchronized (hj.class) {
                if (this.b == null) {
                    this.b = new ScheduledThreadPoolExecutor(0, new DefaultThreadFactory(ww.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.b;
    }

    public void ox(Runnable runnable) {
        ox(runnable, false);
    }

    private hj() {
    }

    public void mb(Runnable runnable) {
        mb(runnable, false);
    }

    public void ox(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (!z2 || jb.mb()) {
            b().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public void mb(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !jb.mb()) {
            runnable.run();
        } else {
            ox().execute(runnable);
        }
    }

    public ExecutorService ox() {
        if (this.mb == null) {
            synchronized (hj.class) {
                if (this.mb == null) {
                    this.mb = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(ww.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.mb;
    }

    public void mb(Runnable runnable, long j2) {
        try {
            hj().schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
