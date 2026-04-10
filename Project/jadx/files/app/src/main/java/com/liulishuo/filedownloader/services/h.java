package com.liulishuo.filedownloader.services;

import android.util.SparseArray;
import com.liulishuo.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: FileDownloadThreadPool.java */
/* JADX INFO: loaded from: classes3.dex */
class h {
    private ThreadPoolExecutor b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17297c;
    private SparseArray<DownloadLaunchRunnable> a = new SparseArray<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17298d = 0;

    h(int i2) {
        this.b = com.liulishuo.filedownloader.h0.b.a(i2, "Network");
        this.f17297c = i2;
    }

    public void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.f();
        synchronized (this) {
            this.a.put(downloadLaunchRunnable.b(), downloadLaunchRunnable);
        }
        this.b.execute(downloadLaunchRunnable);
        int i2 = this.f17298d;
        if (i2 < 600) {
            this.f17298d = i2 + 1;
        } else {
            c();
            this.f17298d = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean b(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.util.SparseArray<com.liulishuo.filedownloader.download.DownloadLaunchRunnable> r0 = r1.a     // Catch: java.lang.Throwable -> L16
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L16
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable r2 = (com.liulishuo.filedownloader.download.DownloadLaunchRunnable) r2     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L13
            boolean r2 = r2.d()     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            monitor-exit(r1)
            return r2
        L16:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.services.h.b(int):boolean");
    }

    public synchronized boolean c(int i2) {
        if (a() > 0) {
            com.liulishuo.filedownloader.h0.d.e(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int iA = com.liulishuo.filedownloader.h0.e.a(i2);
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f17297c), Integer.valueOf(iA));
        }
        List<Runnable> listShutdownNow = this.b.shutdownNow();
        this.b = com.liulishuo.filedownloader.h0.b.a(iA, "Network");
        if (listShutdownNow.size() > 0) {
            com.liulishuo.filedownloader.h0.d.e(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(listShutdownNow.size()));
        }
        this.f17297c = iA;
        return true;
    }

    public synchronized List<Integer> b() {
        ArrayList arrayList;
        c();
        arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            arrayList.add(Integer.valueOf(this.a.get(this.a.keyAt(i2)).b()));
        }
        return arrayList;
    }

    public void a(int i2) {
        c();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.a.get(i2);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.e();
                boolean zRemove = this.b.remove(downloadLaunchRunnable);
                if (com.liulishuo.filedownloader.h0.d.a) {
                    com.liulishuo.filedownloader.h0.d.a(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(zRemove));
                }
            }
            this.a.remove(i2);
        }
    }

    private synchronized void c() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = this.a.keyAt(i2);
            DownloadLaunchRunnable downloadLaunchRunnable = this.a.get(iKeyAt);
            if (downloadLaunchRunnable != null && downloadLaunchRunnable.d()) {
                sparseArray.put(iKeyAt, downloadLaunchRunnable);
            }
        }
        this.a = sparseArray;
    }

    public synchronized int a(String str, int i2) {
        if (str == null) {
            return 0;
        }
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            DownloadLaunchRunnable downloadLaunchRunnableValueAt = this.a.valueAt(i3);
            if (downloadLaunchRunnableValueAt != null && downloadLaunchRunnableValueAt.d() && downloadLaunchRunnableValueAt.b() != i2 && str.equals(downloadLaunchRunnableValueAt.c())) {
                return downloadLaunchRunnableValueAt.b();
            }
        }
        return 0;
    }

    public synchronized int a() {
        c();
        return this.a.size();
    }
}
