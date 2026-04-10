package com.xuexiang.xupdate.proxy.impl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IUpdateDownloader;
import com.xuexiang.xupdate.service.DownloadService;
import com.xuexiang.xupdate.service.OnFileDownloadListener;
import com.xuexiang.xupdate.utils.UpdateUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultUpdateDownloader implements IUpdateDownloader {
    private DownloadService.DownloadBinder mDownloadBinder;
    private boolean mIsBound;
    private ServiceConnection mServiceConnection;

    @Override // com.xuexiang.xupdate.proxy.IUpdateDownloader
    public void startDownload(UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener) {
        if (isDownloadUrl(updateEntity)) {
            startDownloadService(updateEntity, onFileDownloadListener);
        } else {
            startOpenHtml(updateEntity, onFileDownloadListener);
        }
    }

    protected boolean isDownloadUrl(UpdateEntity updateEntity) {
        return isApkDownloadUrl(updateEntity) || !isStaticHtmlUrl(updateEntity);
    }

    protected boolean isApkDownloadUrl(UpdateEntity updateEntity) {
        String downloadUrl = updateEntity.getDownloadUrl();
        return !TextUtils.isEmpty(downloadUrl) && downloadUrl.substring(downloadUrl.lastIndexOf("/") + 1).endsWith(".apk");
    }

    protected boolean isStaticHtmlUrl(UpdateEntity updateEntity) {
        String downloadUrl = updateEntity.getDownloadUrl();
        if (TextUtils.isEmpty(downloadUrl)) {
            return false;
        }
        String strSubstring = downloadUrl.substring(downloadUrl.lastIndexOf("/") + 1);
        return strSubstring.contains(".htm") || strSubstring.contains(".shtm");
    }

    protected void startDownloadService(final UpdateEntity updateEntity, final OnFileDownloadListener onFileDownloadListener) {
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.xuexiang.xupdate.proxy.impl.DefaultUpdateDownloader.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                DefaultUpdateDownloader.this.mIsBound = true;
                DefaultUpdateDownloader.this.startDownload((DownloadService.DownloadBinder) iBinder, updateEntity, onFileDownloadListener);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                DefaultUpdateDownloader.this.mIsBound = false;
            }
        };
        this.mServiceConnection = serviceConnection;
        DownloadService.bindService(serviceConnection);
    }

    protected void startOpenHtml(UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener) {
        boolean zStartActivity = UpdateUtils.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(updateEntity.getDownloadUrl())));
        if (onFileDownloadListener != null) {
            if (zStartActivity) {
                if (updateEntity.isForce()) {
                    return;
                }
                onFileDownloadListener.onCompleted(null);
                return;
            }
            onFileDownloadListener.onError(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(DownloadService.DownloadBinder downloadBinder, UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener) {
        this.mDownloadBinder = downloadBinder;
        downloadBinder.start(updateEntity, onFileDownloadListener);
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateDownloader
    public void cancelDownload() {
        DownloadService.DownloadBinder downloadBinder = this.mDownloadBinder;
        if (downloadBinder != null) {
            downloadBinder.stop("取消下载");
        }
        if (!this.mIsBound || this.mServiceConnection == null) {
            return;
        }
        XUpdate.getContext().unbindService(this.mServiceConnection);
        this.mIsBound = false;
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateDownloader
    public void backgroundDownload() {
        DownloadService.DownloadBinder downloadBinder = this.mDownloadBinder;
        if (downloadBinder != null) {
            downloadBinder.showNotification();
        }
    }
}
