package com.ss.android.socialbase.appdownloader.h;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.widget.RemoteViews;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.h;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* JADX INFO: loaded from: classes3.dex */
public class mb extends AbsNotificationItem {
    private String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18055h;
    private String hj;
    private final Context mb;
    private final Resources ox;

    public mb(Context context, int i2, String str, String str2, String str3, String str4) {
        super(i2, str);
        this.hj = str2;
        this.b = str3;
        this.f18055h = str4;
        this.mb = context.getApplicationContext();
        this.ox = this.mb.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification mb(com.ss.android.socialbase.downloader.exception.BaseException r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 1468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.h.mb.mb(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private androidx.core.app.NotificationCompat.Builder ox() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.hj r0 = com.ss.android.socialbase.appdownloader.hj.x()
            java.lang.String r0 = r0.lz()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.mb
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.mb
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.b.ox(r0)
        L22:
            com.ss.android.socialbase.appdownloader.hj r1 = com.ss.android.socialbase.appdownloader.hj.x()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.b.nk r1 = r1.jb()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.hj r1 = com.ss.android.socialbase.appdownloader.hj.x()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.b.nk r1 = r1.jb()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.mb     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.mb(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.mb     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.mb
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.h.mb.ox():androidx.core.app.NotificationCompat$Builder");
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotification(BaseException baseException, boolean z2) {
        if (this.mb == null) {
            return;
        }
        try {
            this.notification = mb(baseException, z2);
            notify(this.notification);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotificationItem(DownloadInfo downloadInfo) {
        super.updateNotificationItem(downloadInfo);
        this.hj = downloadInfo.getSavePath();
        this.b = downloadInfo.getName();
        this.f18055h = downloadInfo.getExtra();
    }

    private boolean mb(BaseException baseException, DownloadSetting downloadSetting, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && downloadSetting.optInt(DownloadSettingKeys.NOTIFICATION_TEXT_OPT, 0) == 1;
    }

    private RemoteViews mb() {
        RemoteViews remoteViews = new RemoteViews(this.mb.getPackageName(), h.mb());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.b.mb(this.mb)) {
                    remoteViews.setInt(h.u(), "setBackgroundColor", this.mb.getResources().getColor(h.l()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    private int mb(int i2, int i3) {
        if (DownloadSetting.obtain(i3).optInt("notification_opt_2") == 1) {
            return h.df();
        }
        if (i2 == 1 || i2 == 4) {
            return h.gm();
        }
        if (i2 == 2) {
            return h.g();
        }
        if (i2 == 3) {
            return h.df();
        }
        return 0;
    }

    private PendingIntent mb(String str, int i2, int i3) {
        Intent intent = new Intent(this.mb, (Class<?>) DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i3);
        intent.putExtra("extra_click_download_type", i2);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.mb, i3, intent, 201326592);
    }

    private int mb(int i2) {
        if (DownloadSetting.obtain(i2).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 1) {
            return h.ww();
        }
        return h.ko();
    }
}
