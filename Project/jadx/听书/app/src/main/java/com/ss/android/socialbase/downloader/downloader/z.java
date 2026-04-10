package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z implements p {
    private static final String gc = "z";
    protected volatile boolean dl;
    private WeakReference<Service> m;
    protected final SparseArray<List<com.ss.android.socialbase.downloader.e.a>> z = new SparseArray<>();
    protected volatile boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile boolean f2063a = false;
    private Handler e = new Handler(Looper.getMainLooper());
    private Runnable gz = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.z.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.m.z.z()) {
                com.ss.android.socialbase.downloader.m.z.g(z.gc, "tryDownload: 2 try");
            }
            if (z.this.g) {
                return;
            }
            if (com.ss.android.socialbase.downloader.m.z.z()) {
                com.ss.android.socialbase.downloader.m.z.g(z.gc, "tryDownload: 2 error");
            }
            z.this.startService(dl.xl(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void dl() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void dl(com.ss.android.socialbase.downloader.e.a aVar) {
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void z(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void z(ls lsVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void z(WeakReference weakReference) {
        this.m = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public boolean z() {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public boolean g() {
        com.ss.android.socialbase.downloader.m.z.dl(gc, "isServiceForeground = " + this.dl);
        return this.dl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public IBinder z(Intent intent) {
        com.ss.android.socialbase.downloader.m.z.g(gc, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void z(int i, Notification notification) {
        WeakReference<Service> weakReference = this.m;
        if (weakReference != null && weakReference.get() != null) {
            com.ss.android.socialbase.downloader.m.z.dl(gc, "startForeground  id = " + i + ", service = " + this.m.get() + ",  isServiceAlive = " + this.g);
            try {
                this.m.get().startForeground(i, notification);
                this.dl = true;
                return;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                return;
            }
        }
        com.ss.android.socialbase.downloader.m.z.a(gc, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void z(boolean z) {
        WeakReference<Service> weakReference = this.m;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.dl(gc, "stopForeground  service = " + this.m.get() + ",  isServiceAlive = " + this.g);
        try {
            this.dl = false;
            this.m.get().stopForeground(z);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void a() {
        this.g = false;
    }

    public void z(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar == null) {
            return;
        }
        int iP = aVar.p();
        synchronized (this.z) {
            String str = gc;
            com.ss.android.socialbase.downloader.m.z.g(str, "pendDownloadTask pendingTasks.size:" + this.z.size() + " downloadId:" + iP);
            List<com.ss.android.socialbase.downloader.e.a> arrayList = this.z.get(iP);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.z.put(iP, arrayList);
            }
            com.ss.android.socialbase.downloader.m.z.g(str, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(aVar);
            com.ss.android.socialbase.downloader.m.z.g(str, "after pendDownloadTask pendingTasks.size:" + this.z.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void g(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!this.g) {
            if (com.ss.android.socialbase.downloader.m.z.z()) {
                com.ss.android.socialbase.downloader.m.z.g(gc, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.pf.z.z(262144)) {
                z(aVar);
                if (!this.f2063a) {
                    if (com.ss.android.socialbase.downloader.m.z.z()) {
                        com.ss.android.socialbase.downloader.m.z.g(gc, "tryDownload: 1");
                    }
                    startService(dl.xl(), null);
                    this.f2063a = true;
                    return;
                }
                this.e.removeCallbacks(this.gz);
                this.e.postDelayed(this.gz, 10L);
                return;
            }
            z(aVar);
            startService(dl.xl(), null);
            return;
        }
        String str = gc;
        com.ss.android.socialbase.downloader.m.z.g(str, "tryDownload when isServiceAlive");
        gc();
        com.ss.android.socialbase.downloader.impls.z zVarH = dl.h();
        if (zVarH != null) {
            com.ss.android.socialbase.downloader.m.z.g(str, "tryDownload current task: " + aVar.p());
            zVarH.z(aVar);
        }
    }

    protected void gc() {
        SparseArray<List<com.ss.android.socialbase.downloader.e.a>> sparseArrayClone;
        synchronized (this.z) {
            com.ss.android.socialbase.downloader.m.z.g(gc, "resumePendingTask pendingTasks.size:" + this.z.size());
            sparseArrayClone = this.z.clone();
            this.z.clear();
        }
        com.ss.android.socialbase.downloader.impls.z zVarH = dl.h();
        if (zVarH != null) {
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<com.ss.android.socialbase.downloader.e.a> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    for (com.ss.android.socialbase.downloader.e.a aVar : list) {
                        com.ss.android.socialbase.downloader.m.z.g(gc, "resumePendingTask key:" + aVar.p());
                        zVarH.z(aVar);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void z(int i) {
        com.ss.android.socialbase.downloader.m.z.z(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.p
    public void startService() {
        if (this.g) {
            return;
        }
        if (com.ss.android.socialbase.downloader.m.z.z()) {
            com.ss.android.socialbase.downloader.m.z.g(gc, "startService");
        }
        startService(dl.xl(), null);
    }
}
