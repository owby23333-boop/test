package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
final class h {
    private ThreadPoolExecutor aHK;
    private int aHM;
    private SparseArray<DownloadLaunchRunnable> aHJ = new SparseArray<>();
    private final String aHL = "Network";
    private int aHN = 0;

    h(int i2) {
        this.aHK = com.kwai.filedownloader.e.b.n(i2, "Network");
        this.aHM = i2;
    }

    private synchronized void II() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.aHJ.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = this.aHJ.keyAt(i2);
            DownloadLaunchRunnable downloadLaunchRunnable = this.aHJ.get(iKeyAt);
            if (downloadLaunchRunnable.isAlive()) {
                sparseArray.put(iKeyAt, downloadLaunchRunnable);
            }
        }
        this.aHJ = sparseArray;
    }

    public final synchronized int IJ() {
        II();
        return this.aHJ.size();
    }

    public final synchronized List<Integer> IK() {
        ArrayList arrayList;
        II();
        arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.aHJ.size(); i2++) {
            arrayList.add(Integer.valueOf(this.aHJ.get(this.aHJ.keyAt(i2)).getId()));
        }
        return arrayList;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i2;
        downloadLaunchRunnable.HC();
        synchronized (this) {
            this.aHJ.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.aHK.execute(downloadLaunchRunnable);
        int i3 = this.aHN;
        if (i3 >= 600) {
            II();
            i2 = 0;
        } else {
            i2 = i3 + 1;
        }
        this.aHN = i2;
    }

    public final synchronized boolean cQ(int i2) {
        if (IJ() > 0) {
            com.kwai.filedownloader.e.d.h(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int iDe = com.kwai.filedownloader.e.e.de(i2);
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.aHM), Integer.valueOf(iDe));
        }
        List<Runnable> listShutdownNow = this.aHK.shutdownNow();
        this.aHK = com.kwai.filedownloader.e.b.n(iDe, "Network");
        if (listShutdownNow.size() > 0) {
            com.kwai.filedownloader.e.d.h(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(listShutdownNow.size()));
        }
        this.aHM = iDe;
        return true;
    }

    public final void cancel(int i2) {
        II();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.aHJ.get(i2);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean zRemove = this.aHK.remove(downloadLaunchRunnable);
                if (com.kwai.filedownloader.e.d.aHT) {
                    com.kwai.filedownloader.e.d.g(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(zRemove));
                }
            }
            this.aHJ.remove(i2);
        }
    }

    public final boolean dd(int i2) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.aHJ.get(i2);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final int q(String str, int i2) {
        if (str == null) {
            return 0;
        }
        int size = this.aHJ.size();
        for (int i3 = 0; i3 < size; i3++) {
            DownloadLaunchRunnable downloadLaunchRunnableValueAt = this.aHJ.valueAt(i3);
            if (downloadLaunchRunnableValueAt != null && downloadLaunchRunnableValueAt.isAlive() && downloadLaunchRunnableValueAt.getId() != i2 && str.equals(downloadLaunchRunnableValueAt.HH())) {
                return downloadLaunchRunnableValueAt.getId();
            }
        }
        return 0;
    }
}
