package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public class CSJDownloadService extends Service {
    private static final String g = "CSJDownloadService";
    protected p z;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        dl.z(this);
        p pVarUf = dl.uf();
        this.z = pVarUf;
        pVarUf.z(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.ss.android.socialbase.downloader.m.z.g(g, "onBind downloadServiceHandler != null:" + (this.z != null));
        p pVar = this.z;
        if (pVar != null) {
            return pVar.z(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.m.z.z()) {
            com.ss.android.socialbase.downloader.m.z.g(g, "DownloadService onStartCommand");
        }
        this.z.dl();
        ExecutorService executorServiceKb = dl.kb();
        if (executorServiceKb != null) {
            executorServiceKb.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.CSJDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CSJDownloadService.this.z != null) {
                        CSJDownloadService.this.z.z(intent, i, i2);
                    }
                }
            });
        }
        return dl.fo() ? 2 : 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.m.z.z()) {
            com.ss.android.socialbase.downloader.m.z.g(g, "Service onDestroy");
        }
        p pVar = this.z;
        if (pVar != null) {
            pVar.a();
            this.z = null;
        }
        super.onDestroy();
    }
}
