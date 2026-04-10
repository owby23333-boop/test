package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.NotificationConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.ThreadWithHandler;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.umeng.message.entity.UMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNotificationService extends Service {
    private static boolean sBugfixNotifyTooFast;
    private static volatile long sLastImportantNotifyTimestamp;
    private static volatile long sLastNotifyTimestamp;
    private ThreadWithHandler mNotifyThreadHandler;
    private final SparseArray<Notification> pendingImportantNotify = new SparseArray<>(2);
    private static final String TAG = DownloadNotificationService.class.getSimpleName();
    private static int sForegroundId = -1;
    private static int sIndependentProcessForegroundId = -1;
    private static boolean sAllowStartForeground = true;
    private static boolean sBugFixNonOngoing = false;
    private static final long NOTIFY_TIME_WINDOW = 900;
    private static long sNotifyTimeWindow = NOTIFY_TIME_WINDOW;

    private void createNotifyHandlerThread() {
        if (this.mNotifyThreadHandler == null) {
            this.mNotifyThreadHandler = new ThreadWithHandler("DownloaderNotifyThread");
            this.mNotifyThreadHandler.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCancel(NotificationManager notificationManager, int i2) {
        boolean z2;
        AbsNotificationItem absNotificationItemValueAt;
        int id;
        if (sForegroundId != i2 && sIndependentProcessForegroundId != i2) {
            try {
                notificationManager.cancel(i2);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z3 = true;
        if (sForegroundId == i2) {
            sForegroundId = 0;
            z2 = false;
        } else {
            sIndependentProcessForegroundId = 0;
            z2 = true;
        }
        try {
            IDownloadProxy downloadHandler = DownloadProcessDispatcher.getInstance().getDownloadHandler(i2);
            if (!downloadHandler.isServiceForeground()) {
                sAllowStartForeground = false;
                Logger.w(TAG, "try to stopForeground when is not Foreground, id = " + i2 + ", isIndependentProcess = " + z2);
            }
            Logger.i(TAG, "doCancel, ========== stopForeground id = " + i2 + ", isIndependentProcess = " + z2);
            downloadHandler.stopForeground(false, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i2);
        } catch (Throwable unused2) {
        }
        if (sAllowStartForeground) {
            try {
                SparseArray<AbsNotificationItem> allNotificationItems = DownloadNotificationManager.getInstance().getAllNotificationItems();
                if (allNotificationItems != null) {
                    for (int size = allNotificationItems.size() - 1; size >= 0; size--) {
                        absNotificationItemValueAt = allNotificationItems.valueAt(size);
                        if (absNotificationItemValueAt != null && (id = absNotificationItemValueAt.getId()) != i2 && id != sForegroundId && id != sIndependentProcessForegroundId && absNotificationItemValueAt.isOngoing()) {
                            if ((DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(absNotificationItemValueAt.getId()) == 1 && !DownloadUtils.isDownloaderProcess()) == z2) {
                                break;
                            }
                        }
                    }
                    absNotificationItemValueAt = null;
                } else {
                    absNotificationItemValueAt = null;
                }
                if (absNotificationItemValueAt != null) {
                    int id2 = absNotificationItemValueAt.getId();
                    try {
                        notificationManager.cancel(id2);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (Downloader.getInstance(this).getStatus(id2) != 1) {
                        z3 = false;
                    }
                    Logger.i(TAG, "doCancel, updateNotification id = " + id2);
                    absNotificationItemValueAt.updateNotification(null, z3);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doImportantNotify(final NotificationManager notificationManager, final int i2, Notification notification) {
        synchronized (this.pendingImportantNotify) {
            int iIndexOfKey = this.pendingImportantNotify.indexOfKey(i2);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.pendingImportantNotify.size()) {
                this.pendingImportantNotify.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = sNotifyTimeWindow - (System.currentTimeMillis() - sLastNotifyTimestamp);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            sLastImportantNotifyTimestamp = jCurrentTimeMillis2;
            sLastNotifyTimestamp = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                doNotify(notificationManager, i2, notification);
            } else if (this.mNotifyThreadHandler != null) {
                synchronized (this.pendingImportantNotify) {
                    this.pendingImportantNotify.put(i2, notification);
                }
                this.mNotifyThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.performImportantNotify(notificationManager, i2);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotify(NotificationManager notificationManager, int i2, Notification notification) {
        if (needStartForeground(i2, notification)) {
            try {
                boolean z2 = true;
                boolean z3 = DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(i2) == 1 && !DownloadUtils.isDownloaderProcess();
                if ((z3 || sForegroundId != 0) && (!z3 || sIndependentProcessForegroundId != 0)) {
                    z2 = false;
                }
                if (z2) {
                    IDownloadProxy downloadHandler = DownloadProcessDispatcher.getInstance().getDownloadHandler(i2);
                    if (!downloadHandler.isServiceAlive() || downloadHandler.isServiceForeground()) {
                        Logger.i(TAG, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = " + z3);
                    } else {
                        Logger.i(TAG, "doNotify, startForeground, ======== id = " + i2 + ", isIndependentProcess = " + z3);
                        if (z3) {
                            sIndependentProcessForegroundId = i2;
                        } else {
                            sForegroundId = i2;
                        }
                        downloadHandler.startForeground(i2, notification);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if ((sForegroundId == i2 || sIndependentProcessForegroundId == i2) && sBugFixNonOngoing && (notification.flags & 2) == 0) {
            doCancel(notificationManager, i2);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (sLastNotifyTimestamp < jCurrentTimeMillis) {
                sLastNotifyTimestamp = jCurrentTimeMillis;
            }
            notificationManager.notify(i2, notification);
        } catch (Throwable unused) {
        }
    }

    private void handleIntent(final Intent intent) {
        ThreadWithHandler threadWithHandler;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (threadWithHandler = this.mNotifyThreadHandler) == null) {
            return;
        }
        threadWithHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
                final int intExtra = intent.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_ID, 0);
                if (!action.equals(NotificationConstants.ACTION_NOTIFICATION_NOTIFY)) {
                    if (action.equals(NotificationConstants.ACTION_NOTIFICATION_CANCEL)) {
                        if (intExtra != 0) {
                            DownloadNotificationService.this.doCancel(notificationManager, intExtra);
                            return;
                        }
                        return;
                    }
                    if (!action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        if (DownloadUtils.checkPermission(DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(DownloadConstants.MIME_APK)) {
                                arrayList.add(DownloadConstants.MIME_APK);
                            }
                            arrayList.add(DownloadConstants.MIME_PLG);
                            Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                            if (applicationContext != null) {
                                Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                final Notification notification = (Notification) intent.getParcelableExtra(NotificationConstants.EXTRA_NOTIFICATION);
                int intExtra2 = intent.getIntExtra(NotificationConstants.EXTRA_NOTIFICATION_STATUS, 0);
                if (intExtra == 0 || notification == null || notificationManager == null) {
                    return;
                }
                if (intExtra2 != 4) {
                    if (intExtra2 != -2 && intExtra2 != -3) {
                        if (DownloadNotificationService.sBugfixNotifyTooFast) {
                            DownloadNotificationService.this.doImportantNotify(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (DownloadNotificationService.sBugfixNotifyTooFast) {
                        DownloadNotificationService.this.doImportantNotify(notificationManager, intExtra, notification);
                        return;
                    } else {
                        if (DownloadNotificationService.this.mNotifyThreadHandler != null) {
                            DownloadNotificationService.this.mNotifyThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                                }
                            }, intExtra2 == -2 ? 50L : 200L);
                            return;
                        }
                        return;
                    }
                }
                if (Downloader.getInstance(DownloadComponentManager.getAppContext()).isDownloading(intExtra)) {
                    DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(intExtra);
                    if (!DownloadNotificationService.sBugfixNotifyTooFast) {
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.sLastImportantNotifyTimestamp <= DownloadNotificationService.sNotifyTimeWindow) {
                        return;
                    }
                    DownloadNotificationService.this.doNotify(notificationManager, intExtra, notification);
                    downloadInfo.setLastNotifyProgressTime();
                }
            }
        });
    }

    private boolean needStartForeground(int i2, Notification notification) {
        int i3;
        int i4;
        if (!sAllowStartForeground || (i3 = sForegroundId) == i2 || (i4 = sIndependentProcessForegroundId) == i2) {
            return false;
        }
        if (i3 != 0 && i4 != 0) {
            return false;
        }
        if (sBugFixNonOngoing && (notification.flags & 2) == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performImportantNotify(NotificationManager notificationManager, int i2) {
        Notification notification;
        synchronized (this.pendingImportantNotify) {
            notification = this.pendingImportantNotify.get(i2);
            this.pendingImportantNotify.remove(i2);
        }
        if (notification != null) {
            doNotify(notificationManager, i2, notification);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        createNotifyHandlerThread();
        DownloadComponentManager.setAppContext(this);
        DownloadSetting downloadSettingObtainGlobal = DownloadSetting.obtainGlobal();
        int iOptInt = downloadSettingObtainGlobal.optInt(DownloadSettingKeys.DOWNLOAD_SERVICE_FOREGROUND, 0);
        if ((iOptInt == 1 || iOptInt == 3) && sForegroundId == -1) {
            sForegroundId = 0;
        }
        if ((iOptInt == 2 || iOptInt == 3) && sIndependentProcessForegroundId == -1) {
            sIndependentProcessForegroundId = 0;
        }
        sBugFixNonOngoing = downloadSettingObtainGlobal.optBugFix(DownloadSettingKeys.BugFix.NON_GOING_NOTIFICATION_FOREGROUND, false);
        sBugfixNotifyTooFast = downloadSettingObtainGlobal.optBugFix(DownloadSettingKeys.BugFix.FIX_NOTIFY_TOO_FAST, false);
        sNotifyTimeWindow = downloadSettingObtainGlobal.optLong(DownloadSettingKeys.NOTIFICATION_TIME_WINDOW, NOTIFY_TIME_WINDOW);
        long j2 = sNotifyTimeWindow;
        if (j2 < 0 || j2 > 1200) {
            sNotifyTimeWindow = NOTIFY_TIME_WINDOW;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ThreadWithHandler threadWithHandler = this.mNotifyThreadHandler;
        if (threadWithHandler != null) {
            try {
                threadWithHandler.quit();
            } catch (Throwable unused) {
            }
            this.mNotifyThreadHandler = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        handleIntent(intent);
        return 2;
    }
}
