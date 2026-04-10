package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.expressad.exoplayer.i.a;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();

    private void autoRefreshUnsuccessDownloadTask(final Context context, final String str) {
        if (DownloadComponentManager.needAutoRefreshUnSuccessTask()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, a.f9492f);
        }
    }

    private void forceStopAllDownloadTask(Context context, String str) {
        try {
            Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
            intent.setAction(str);
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

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
            if (Logger.debug()) {
                Logger.v(TAG, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            autoRefreshUnsuccessDownloadTask(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            forceStopAllDownloadTask(context, action);
        }
    }
}
