package com.ss.android.socialbase.appdownloader.hj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.b.ko;
import com.ss.android.socialbase.appdownloader.hj;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements IDownloadLaunchHandler {
    private List<Integer> mb;
    private BroadcastReceiver ox;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public List<String> getResumeMimeTypes() {
        return b.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public void onLaunchResume(final List<DownloadInfo> list, final int i2) {
        if (DownloadUtils.isMainThread()) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.hj.ox.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ox.this.mb((List<DownloadInfo>) list, i2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            mb(list, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(List<DownloadInfo> list, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ko koVarJe = hj.x().je();
        if (koVarJe != null) {
            koVarJe.mb(list);
        }
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        boolean zIsWifi = DownloadUtils.isWifi(appContext);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            mb(appContext, it.next(), zIsWifi, i2);
        }
        List<Integer> list2 = this.mb;
        if (list2 == null || list2.isEmpty() || this.ox != null) {
            return;
        }
        this.ox = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.hj.ox.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (DownloadUtils.isWifi(applicationContext)) {
                    Logger.d("LaunchResume", "onReceive : wifi connected !!!");
                    DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.hj.ox.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ox.this.mb != null && !ox.this.mb.isEmpty()) {
                                    Integer[] numArr = new Integer[ox.this.mb.size()];
                                    ox.this.mb.toArray(numArr);
                                    ox.this.mb.clear();
                                    for (Integer num : numArr) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(num.intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            ox.this.mb(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(ox.this.ox);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    ox.this.ox = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            appContext.registerReceiver(this.ox, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.ox = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mb(android.content.Context r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, boolean r23, int r24) {
        /*
            Method dump skipped, instruction units count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.hj.ox.mb(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    private void mb(DownloadInfo downloadInfo, Context context) {
        DownloadSetting downloadSettingObtain = DownloadSetting.obtain(downloadInfo.getId());
        int iOptInt = downloadSettingObtain.optInt("paused_resume_max_count", 0);
        double dOptDouble = downloadSettingObtain.optDouble("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < iOptInt && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < dOptDouble * 3600000.0d) {
            AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
            if (notificationItem == null) {
                notificationItem = new com.ss.android.socialbase.appdownloader.h.mb(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                DownloadNotificationManager.getInstance().addNotification(notificationItem);
            } else {
                notificationItem.updateNotificationItem(downloadInfo);
            }
            notificationItem.setTotalBytes(downloadInfo.getTotalBytes());
            notificationItem.setCurBytes(downloadInfo.getCurBytes());
            notificationItem.refreshStatus(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean mb(DownloadInfo downloadInfo) {
        if (DownloadSetting.obtain(downloadInfo.getId()).optBugFix("uninstall_can_not_resume_for_force_task", false)) {
            return DownloadUtils.isFileDownloaded(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
