package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.a.gk;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String z = "DownloadReceiver";
    private Handler g = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (com.ss.android.socialbase.downloader.m.z.z()) {
                com.ss.android.socialbase.downloader.m.z.z(z, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            z(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.ss.android.socialbase.appdownloader.dl.gc gcVarDl = a.kb().dl();
                    if (gcVarDl != null) {
                        gcVarDl.z(context, schemeSpecificPart);
                    }
                    List<com.ss.android.socialbase.downloader.e.dl> listG = com.ss.android.socialbase.downloader.downloader.e.g(context).g("application/vnd.android.package-archive");
                    if (listG != null) {
                        for (final com.ss.android.socialbase.downloader.e.dl dlVar : listG) {
                            if (dlVar != null && dl.z(dlVar, schemeSpecificPart)) {
                                gk gkVarFo = com.ss.android.socialbase.downloader.downloader.e.g(context).fo(dlVar.e());
                                if (gkVarFo != null && com.ss.android.socialbase.downloader.pf.m.m(gkVarFo.z())) {
                                    gkVarFo.z(9, dlVar, schemeSpecificPart, "");
                                }
                                com.ss.android.socialbase.downloader.notification.z zVarGc = com.ss.android.socialbase.downloader.notification.g.z().gc(dlVar.e());
                                if (zVarGc != null) {
                                    zVarGc.z((com.ss.android.socialbase.downloader.gc.z) null, false);
                                }
                                if (com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("install_queue_enable", 0) == 1) {
                                    gz.z().z(dlVar, schemeSpecificPart);
                                }
                                DownloadReceiver.this.g.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (dlVar.gl()) {
                                                        com.ss.android.socialbase.downloader.pf.m.g(dlVar);
                                                    }
                                                } catch (Throwable th) {
                                                    wp.z(th);
                                                }
                                            }
                                        });
                                    }
                                }, 1000L);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    private void z(final Context context, final String str) {
        if (com.ss.android.socialbase.downloader.downloader.dl.mc()) {
            com.ss.android.socialbase.downloader.downloader.dl.z(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        wp.z(th);
                    }
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }
}
