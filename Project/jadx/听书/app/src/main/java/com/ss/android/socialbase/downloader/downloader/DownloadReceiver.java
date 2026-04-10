package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.media3.exoplayer.ExoPlayer;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String z = "DownloadReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (com.ss.android.socialbase.downloader.m.z.z()) {
                com.ss.android.socialbase.downloader.m.z.z(z, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            z(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            g(context, action);
        }
    }

    private void z(final Context context, final String str) {
        if (dl.mc()) {
            dl.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        if (com.ss.android.socialbase.downloader.i.z.dl().g("enable_target_34") > 0) {
                            com.ss.android.socialbase.downloader.wp.z.z().z(intent);
                        } else {
                            context.startService(intent);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }

    private void g(final Context context, final String str) {
        dl.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.ss.android.socialbase.downloader.i.z.dl().g("enable_target_34") > 0) {
                        com.ss.android.socialbase.downloader.wp.z.z().z(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
        });
    }
}
