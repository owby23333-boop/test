package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes4.dex */
final class h {
    private ThreadPoolExecutor apu;
    private int apw;
    private SparseArray<DownloadLaunchRunnable> apt = new SparseArray<>();
    private final String apv = "Network";
    private int apx = 0;

    h(int i) {
        this.apu = com.kwad.framework.filedownloader.f.b.r(i, "Network");
        this.apw = i;
    }

    public final synchronized boolean bQ(int i) {
        if (zu() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int iCe = com.kwad.framework.filedownloader.f.e.ce(i);
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.apw), Integer.valueOf(iCe));
        }
        List<Runnable> listShutdownNow = this.apu.shutdownNow();
        this.apu = com.kwad.framework.filedownloader.f.b.r(iCe, "Network");
        if (listShutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(listShutdownNow.size()));
        }
        this.apw = iCe;
        return true;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.ym();
        synchronized (this) {
            this.apt.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.apu.execute(downloadLaunchRunnable);
        int i = this.apx;
        if (i >= 600) {
            zt();
            this.apx = 0;
        } else {
            this.apx = i + 1;
        }
    }

    public final void cancel(int i) {
        zt();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.apt.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean zRemove = this.apu.remove(downloadLaunchRunnable);
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(zRemove));
                }
            }
            this.apt.remove(i);
        }
    }

    private synchronized void zt() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.apt.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = this.apt.keyAt(i);
            DownloadLaunchRunnable downloadLaunchRunnable = this.apt.get(iKeyAt);
            if (downloadLaunchRunnable.isAlive()) {
                sparseArray.put(iKeyAt, downloadLaunchRunnable);
            }
        }
        this.apt = sparseArray;
    }

    public final boolean cd(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.apt.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final int o(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.apt.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable downloadLaunchRunnableValueAt = this.apt.valueAt(i2);
            if (downloadLaunchRunnableValueAt != null && downloadLaunchRunnableValueAt.isAlive() && downloadLaunchRunnableValueAt.getId() != i && str.equals(downloadLaunchRunnableValueAt.yr())) {
                return downloadLaunchRunnableValueAt.getId();
            }
        }
        return 0;
    }

    public final synchronized int zu() {
        zt();
        return this.apt.size();
    }

    public final synchronized List<Integer> zv() {
        ArrayList arrayList;
        zt();
        arrayList = new ArrayList();
        for (int i = 0; i < this.apt.size(); i++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.apt;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i)).getId()));
        }
        return arrayList;
    }
}
