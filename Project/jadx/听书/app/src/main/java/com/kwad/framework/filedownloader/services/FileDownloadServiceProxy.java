package com.kwad.framework.filedownloader.services;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.webkit.WebView;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.utils.ay;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
@KsAdSdkDynamicImpl(FileDownloadService.class)
public class FileDownloadServiceProxy extends com.kwad.sdk.m.a {
    private static final String TAG = "filedownloader";
    public Service context;
    private i handler;

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.handler.zq();
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.context = service;
        com.kwad.framework.filedownloader.f.c.aI(service.getApplicationContext());
        try {
            com.kwad.framework.filedownloader.f.f.cf(com.kwad.framework.filedownloader.f.e.zB().apE);
            com.kwad.framework.filedownloader.f.f.ac(com.kwad.framework.filedownloader.f.e.zB().apF);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        g gVar = new g();
        if (com.kwad.framework.filedownloader.f.e.zB().apH) {
            this.handler = new e(new WeakReference(this), gVar);
        } else {
            this.handler = new d(new WeakReference(this), gVar);
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        this.handler.onDestroy();
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        this.handler.zp();
        return 2;
    }

    @KsAdSdkDynamicImpl(FileDownloadService.SharedMainProcessService.class)
    public static class SharedMainProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwad.framework.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            super.onCreate(service);
        }
    }

    @KsAdSdkDynamicImpl(FileDownloadService.SeparateProcessService.class)
    public static class SeparateProcessServiceProxy extends FileDownloadServiceProxy {
        @Override // com.kwad.framework.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(ay.getProcessName(service.getApplicationContext()));
                } catch (Exception unused) {
                }
            }
            super.onCreate(service);
        }
    }

    public static void register() {
        com.kwad.sdk.service.c.a(FileDownloadService.SeparateProcessService.class, SeparateProcessServiceProxy.class);
        com.kwad.sdk.service.c.a(FileDownloadService.SharedMainProcessService.class, SharedMainProcessServiceProxy.class);
    }
}
