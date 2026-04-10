package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes4.dex */
public class SqlDownloadCacheService extends Service {
    private static final String z = "SqlDownloadCacheService";

    public static void z(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.g(z, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        dl.z(getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        q qVarM;
        wp wpVarIo = dl.io();
        if (wpVarIo instanceof com.ss.android.socialbase.downloader.impls.a) {
            qVarM = ((com.ss.android.socialbase.downloader.impls.a) wpVarIo).m();
        } else {
            qVarM = wpVarIo instanceof q ? (q) wpVarIo : null;
        }
        if (qVarM instanceof IBinder) {
            return (IBinder) qVarM;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (dl.fo()) {
            return 2;
        }
        return iOnStartCommand;
    }
}
