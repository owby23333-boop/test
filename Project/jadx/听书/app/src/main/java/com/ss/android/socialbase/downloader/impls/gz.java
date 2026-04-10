package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;

/* JADX INFO: loaded from: classes4.dex */
public class gz extends com.ss.android.socialbase.downloader.downloader.z {
    private static final String gc = "gz";

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) CSJDownloadService.class));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) CSJDownloadService.class));
        this.g = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z, com.ss.android.socialbase.downloader.downloader.p
    public void dl() {
        if (com.ss.android.socialbase.downloader.pf.z.z(262144)) {
            this.g = true;
            this.f2063a = false;
            if (com.ss.android.socialbase.downloader.m.z.z()) {
                com.ss.android.socialbase.downloader.m.z.g(gc, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z, com.ss.android.socialbase.downloader.downloader.p
    public void z(Intent intent, int i, int i2) {
        if (com.ss.android.socialbase.downloader.m.z.z()) {
            com.ss.android.socialbase.downloader.m.z.g(gc, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.pf.z.z(262144)) {
            this.g = true;
        }
        gc();
    }
}
