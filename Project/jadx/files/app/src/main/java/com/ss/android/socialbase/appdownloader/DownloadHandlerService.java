package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadHandlerService extends Service {
    private static final String mb = DownloadHandlerService.class.getSimpleName();

    private boolean mb(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.b.hj hjVarOx = hj.x().ox();
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && DownloadSetting.obtain(intExtra).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            mb(downloadInfo, hjVarOx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            mb(this, downloadInfo, hjVarOx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            mb(this, downloadInfo, hjVarOx, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION, 0) == 0) {
                if (!(DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && downloadInfo.getStatus() == -1)) {
                    DownloadNotificationManager.getInstance().hideNotification(intExtra);
                    DownloadNotificationManager.getInstance().cancelNotification(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            ox(downloadInfo, hjVarOx, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            DownloadNotificationManager.getInstance().hideNotification(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(AdBaseConstants.MIME_APK);
                        arrayList.add(DownloadConstants.MIME_PLG);
                        Downloader.getInstance(DownloadComponentManager.getAppContext()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    private void ox(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.b.hj hjVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        startActivity(intent);
        DownloadNotificationManager.getInstance().hideNotification(id);
        downloadInfo.updateDownloadTime();
        if (hjVar != null) {
            hjVar.mb(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (iDownloadNotificationEventListener != null) {
            iDownloadNotificationEventListener.onNotificationEvent(7, downloadInfo, "", "");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        if (Logger.debug()) {
            Logger.d(mb, "onStartCommand");
        }
        mb(intent);
        stopSelf();
        return 2;
    }

    private static void mb(Context context, DownloadInfo downloadInfo) {
        if (DownloadUtils.isWifi(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void mb(Context context, final com.ss.android.socialbase.appdownloader.b.hj hjVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (hjVar == null && downloadNotificationEventListener == null) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                File file;
                PackageInfo packageInfoMb;
                try {
                    file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (file.exists()) {
                    try {
                        String str = (DownloadComponentManager.getAppContext() == null || (packageInfoMb = b.mb(downloadInfo, file)) == null) ? "" : packageInfoMb.packageName;
                        if (hjVar != null) {
                            hjVar.mb(downloadInfo.getId(), 3, str, -3, downloadInfo.getDownloadTime());
                        }
                        if (downloadNotificationEventListener != null) {
                            downloadNotificationEventListener.onNotificationEvent(3, downloadInfo, str, "");
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                    e2.printStackTrace();
                }
            }
        });
    }

    private void mb(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.b.hj hjVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        boolean zOnClickWhenUnSuccess;
        int id = downloadInfo.getId();
        INotificationClickCallback notificationClickCallback = DownloadProcessDispatcher.getInstance().getNotificationClickCallback(id);
        if (notificationClickCallback != null) {
            try {
                zOnClickWhenUnSuccess = notificationClickCallback.onClickWhenUnSuccess(downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                zOnClickWhenUnSuccess = false;
            }
        } else {
            zOnClickWhenUnSuccess = false;
        }
        if (zOnClickWhenUnSuccess) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        startActivity(intent);
        DownloadNotificationManager.getInstance().hideNotification(id);
        downloadInfo.updateDownloadTime();
        if (hjVar != null) {
            hjVar.mb(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (iDownloadNotificationEventListener != null) {
            iDownloadNotificationEventListener.onNotificationEvent(7, downloadInfo, "", "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mb(android.content.Context r2, int r3, boolean r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher r4 = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance()
            com.ss.android.socialbase.downloader.depend.INotificationClickCallback r4 = r4.getNotificationClickCallback(r3)
            if (r4 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.Downloader r1 = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(r2)     // Catch: java.lang.Throwable -> L1c
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r1.getDownloadInfo(r3)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L20
            boolean r4 = r4.onClickWhenSuccess(r1)     // Catch: java.lang.Throwable -> L1c
            goto L21
        L1c:
            r4 = move-exception
            r4.printStackTrace()
        L20:
            r4 = 0
        L21:
            if (r4 == 0) goto L24
            return
        L24:
            r4 = 1
            int r3 = com.ss.android.socialbase.appdownloader.b.mb(r2, r3, r4)
            if (r3 != 0) goto L34
            java.lang.String r3 = "Open Fail!"
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r0)
            r2.show()
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.mb(android.content.Context, int, boolean):void");
    }

    public static void mb(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.b.hj hjVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        AbsNotificationItem notificationItem;
        int id = downloadInfo.getId();
        INotificationClickCallback notificationClickCallback = DownloadProcessDispatcher.getInstance().getNotificationClickCallback(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && notificationClickCallback != null && b.mb(context, downloadInfo) && notificationClickCallback.onClickWhenInstalled(downloadInfo)) {
        }
        boolean z2 = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (DownloadSetting.obtain(id).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                mb(DownloadComponentManager.getAppContext(), id, true);
                mb(context, hjVar, downloadInfo);
                if (DownloadSetting.obtain(id).optInt("notification_click_install_auto_cancel", 1) != 0 || (notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(id)) == null) {
                    z2 = true;
                } else {
                    notificationItem.recordClickInstall();
                    notificationItem.refreshStatus(-3, null, false, true);
                }
                if (z2) {
                    DownloadNotificationManager.getInstance().hideNotification(id);
                }
                break;
            case -2:
                if (DownloadProcessDispatcher.getInstance().canResume(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    b.mb(downloadInfo, true, false);
                }
                if (hjVar != null) {
                    hjVar.mb(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(6, downloadInfo, "", "");
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                mb(context, downloadInfo);
                if (hjVar != null) {
                    hjVar.mb(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(5, downloadInfo, "", "");
                }
                break;
        }
    }
}
