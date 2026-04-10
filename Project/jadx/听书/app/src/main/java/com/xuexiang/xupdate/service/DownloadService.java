package com.xuexiang.xupdate.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.xuexiang.xupdate.R;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate._XUpdate;
import com.xuexiang.xupdate.entity.DownloadEntity;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.logs.UpdateLog;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;
import com.xuexiang.xupdate.utils.ApkInstallUtils;
import com.xuexiang.xupdate.utils.FileUtils;
import com.xuexiang.xupdate.utils.UpdateUtils;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadService extends Service {
    private static final String CHANNEL_ID = "xupdate_channel_id";
    private static final CharSequence CHANNEL_NAME = "xupdate_channel_name";
    private static final int DOWNLOAD_NOTIFY_ID = 1000;
    private static boolean sIsRunning;
    private NotificationCompat.Builder mBuilder;
    private NotificationManagerCompat mNotificationManager;

    public static void bindService(ServiceConnection serviceConnection) {
        Intent intent = new Intent(XUpdate.getContext(), (Class<?>) DownloadService.class);
        XUpdate.getContext().startService(intent);
        XUpdate.getContext().bindService(intent, serviceConnection, 1);
        sIsRunning = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop(String str) {
        NotificationCompat.Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setContentTitle(UpdateUtils.getAppName(this)).setContentText(str);
            Notification notificationBuild = this.mBuilder.build();
            notificationBuild.flags = 16;
            this.mNotificationManager.notify(1000, notificationBuild);
        }
        close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        sIsRunning = false;
        stopSelf();
    }

    public static boolean isRunning() {
        return sIsRunning;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mNotificationManager = NotificationManagerCompat.from(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        sIsRunning = true;
        return new DownloadBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        sIsRunning = false;
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mNotificationManager = null;
        this.mBuilder = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpNotification(DownloadEntity downloadEntity) {
        if (downloadEntity.isShowNotification()) {
            initNotification();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNotification() {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 4);
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        this.mNotificationManager.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder notificationBuilder = getNotificationBuilder();
        this.mBuilder = notificationBuilder;
        this.mNotificationManager.notify(1000, notificationBuilder.build());
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        return new NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(getString(R.string.xupdate_start_download)).setContentText(getString(R.string.xupdate_connecting_service)).setSmallIcon(R.drawable.xupdate_icon_app_update).setLargeIcon(UpdateUtils.drawable2Bitmap(UpdateUtils.getAppIcon(this))).setOngoing(true).setAutoCancel(true).setWhen(System.currentTimeMillis());
    }

    public class DownloadBinder extends Binder {
        private FileDownloadCallBack mFileDownloadCallBack;
        private UpdateEntity mUpdateEntity;

        public DownloadBinder() {
        }

        public void start(UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener) {
            this.mUpdateEntity = updateEntity;
            DownloadService downloadService = DownloadService.this;
            FileDownloadCallBack fileDownloadCallBack = DownloadService.this.new FileDownloadCallBack(updateEntity, onFileDownloadListener);
            this.mFileDownloadCallBack = fileDownloadCallBack;
            downloadService.startDownload(updateEntity, fileDownloadCallBack);
        }

        public void stop(String str) {
            FileDownloadCallBack fileDownloadCallBack = this.mFileDownloadCallBack;
            if (fileDownloadCallBack != null) {
                fileDownloadCallBack.onCancel();
                this.mFileDownloadCallBack = null;
            }
            if (this.mUpdateEntity.getIUpdateHttpService() != null) {
                this.mUpdateEntity.getIUpdateHttpService().cancelDownload(this.mUpdateEntity.getDownloadUrl());
            } else {
                UpdateLog.e("cancelDownload failed, mUpdateEntity.getIUpdateHttpService() is null!");
            }
            DownloadService.this.stop(str);
        }

        public void showNotification() {
            if (DownloadService.this.mBuilder == null && DownloadService.isRunning()) {
                DownloadService.this.initNotification();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(UpdateEntity updateEntity, FileDownloadCallBack fileDownloadCallBack) {
        String downloadUrl = updateEntity.getDownloadUrl();
        if (TextUtils.isEmpty(downloadUrl)) {
            stop(getString(R.string.xupdate_tip_download_url_error));
            return;
        }
        String apkNameByDownloadUrl = UpdateUtils.getApkNameByDownloadUrl(downloadUrl);
        File fileByPath = FileUtils.getFileByPath(updateEntity.getApkCacheDir());
        if (fileByPath == null) {
            fileByPath = UpdateUtils.getDefaultDiskCacheDir();
        }
        try {
            if (!FileUtils.isFileExists(fileByPath)) {
                fileByPath.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = fileByPath + File.separator + updateEntity.getVersionName();
        UpdateLog.d("开始下载更新文件, 下载地址:" + downloadUrl + ", 保存路径:" + str + ", 文件名:" + apkNameByDownloadUrl);
        if (updateEntity.getIUpdateHttpService() != null) {
            updateEntity.getIUpdateHttpService().download(downloadUrl, str, apkNameByDownloadUrl, fileDownloadCallBack);
        } else {
            UpdateLog.e("startDownload failed, updateEntity.getIUpdateHttpService() is null!");
        }
    }

    private class FileDownloadCallBack implements IUpdateHttpService.DownloadCallback {
        private final DownloadEntity mDownloadEntity;
        private final boolean mIsAutoInstall;
        private boolean mIsCancel;
        private OnFileDownloadListener mOnFileDownloadListener;
        private int mOldRate = 0;
        private final Handler mMainHandler = new Handler(Looper.getMainLooper());

        FileDownloadCallBack(UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener) {
            this.mDownloadEntity = updateEntity.getDownLoadEntity();
            this.mIsAutoInstall = updateEntity.isAutoInstall();
            this.mOnFileDownloadListener = onFileDownloadListener;
        }

        @Override // com.xuexiang.xupdate.proxy.IUpdateHttpService.DownloadCallback
        public void onStart() {
            if (this.mIsCancel) {
                return;
            }
            DownloadService.this.mNotificationManager.cancel(1000);
            DownloadService.this.mBuilder = null;
            DownloadService.this.setUpNotification(this.mDownloadEntity);
            dispatchOnStart();
        }

        private void dispatchOnStart() {
            if (UpdateUtils.isMainThread()) {
                OnFileDownloadListener onFileDownloadListener = this.mOnFileDownloadListener;
                if (onFileDownloadListener != null) {
                    onFileDownloadListener.onStart();
                    return;
                }
                return;
            }
            this.mMainHandler.post(new Runnable() { // from class: com.xuexiang.xupdate.service.DownloadService.FileDownloadCallBack.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FileDownloadCallBack.this.mOnFileDownloadListener != null) {
                        FileDownloadCallBack.this.mOnFileDownloadListener.onStart();
                    }
                }
            });
        }

        @Override // com.xuexiang.xupdate.proxy.IUpdateHttpService.DownloadCallback
        public void onProgress(float f, long j) {
            if (this.mIsCancel) {
                return;
            }
            int iRound = Math.round(100.0f * f);
            if (canRefreshProgress(iRound)) {
                dispatchOnProgress(f, j);
                if (DownloadService.this.mBuilder != null) {
                    DownloadService.this.mBuilder.setContentTitle(DownloadService.this.getString(R.string.xupdate_lab_downloading) + UpdateUtils.getAppName(DownloadService.this)).setContentText(iRound + "%").setProgress(100, iRound, false).setWhen(System.currentTimeMillis());
                    Notification notificationBuild = DownloadService.this.mBuilder.build();
                    notificationBuild.flags = 24;
                    DownloadService.this.mNotificationManager.notify(1000, notificationBuild);
                }
                this.mOldRate = iRound;
            }
        }

        private boolean canRefreshProgress(int i) {
            return DownloadService.this.mBuilder != null ? Math.abs(i - this.mOldRate) >= 4 : Math.abs(i - this.mOldRate) >= 1;
        }

        private void dispatchOnProgress(final float f, final long j) {
            if (UpdateUtils.isMainThread()) {
                OnFileDownloadListener onFileDownloadListener = this.mOnFileDownloadListener;
                if (onFileDownloadListener != null) {
                    onFileDownloadListener.onProgress(f, j);
                    return;
                }
                return;
            }
            this.mMainHandler.post(new Runnable() { // from class: com.xuexiang.xupdate.service.DownloadService.FileDownloadCallBack.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FileDownloadCallBack.this.mOnFileDownloadListener != null) {
                        FileDownloadCallBack.this.mOnFileDownloadListener.onProgress(f, j);
                    }
                }
            });
        }

        @Override // com.xuexiang.xupdate.proxy.IUpdateHttpService.DownloadCallback
        public void onSuccess(final File file) {
            if (UpdateUtils.isMainThread()) {
                handleOnSuccess(file);
            } else {
                this.mMainHandler.post(new Runnable() { // from class: com.xuexiang.xupdate.service.DownloadService.FileDownloadCallBack.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FileDownloadCallBack.this.handleOnSuccess(file);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleOnSuccess(File file) {
            if (this.mIsCancel) {
                return;
            }
            OnFileDownloadListener onFileDownloadListener = this.mOnFileDownloadListener;
            if (onFileDownloadListener != null && !onFileDownloadListener.onCompleted(file)) {
                DownloadService.this.close();
                return;
            }
            UpdateLog.d("更新文件下载完成, 文件路径:" + file.getAbsolutePath());
            try {
                if (UpdateUtils.isAppOnForeground(DownloadService.this)) {
                    DownloadService.this.mNotificationManager.cancel(1000);
                    if (!this.mIsAutoInstall) {
                        DownloadService.this.showDownloadCompleteNotification(file);
                    } else {
                        _XUpdate.startInstallApk(DownloadService.this, file, this.mDownloadEntity);
                    }
                } else {
                    DownloadService.this.showDownloadCompleteNotification(file);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            DownloadService.this.close();
        }

        @Override // com.xuexiang.xupdate.proxy.IUpdateHttpService.DownloadCallback
        public void onError(Throwable th) {
            if (this.mIsCancel) {
                return;
            }
            _XUpdate.onUpdateError(4000, th != null ? th.getMessage() : "unknown error!");
            dispatchOnError(th);
            try {
                DownloadService.this.mNotificationManager.cancel(1000);
                DownloadService.this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void dispatchOnError(final Throwable th) {
            if (UpdateUtils.isMainThread()) {
                OnFileDownloadListener onFileDownloadListener = this.mOnFileDownloadListener;
                if (onFileDownloadListener != null) {
                    onFileDownloadListener.onError(th);
                    return;
                }
                return;
            }
            this.mMainHandler.post(new Runnable() { // from class: com.xuexiang.xupdate.service.DownloadService.FileDownloadCallBack.4
                @Override // java.lang.Runnable
                public void run() {
                    if (FileDownloadCallBack.this.mOnFileDownloadListener != null) {
                        FileDownloadCallBack.this.mOnFileDownloadListener.onError(th);
                    }
                }
            });
        }

        void onCancel() {
            this.mOnFileDownloadListener = null;
            this.mIsCancel = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownloadCompleteNotification(File file) {
        PendingIntent activity = PendingIntent.getActivity(this, 0, ApkInstallUtils.getInstallAppIntent(file), 201326592);
        if (this.mBuilder == null) {
            this.mBuilder = getNotificationBuilder();
        }
        this.mBuilder.setContentIntent(activity).setContentTitle(UpdateUtils.getAppName(this)).setContentText(getString(R.string.xupdate_download_complete)).setProgress(0, 0, false).setDefaults(-1);
        Notification notificationBuild = this.mBuilder.build();
        notificationBuild.flags = 16;
        this.mNotificationManager.notify(1000, notificationBuild);
    }
}
