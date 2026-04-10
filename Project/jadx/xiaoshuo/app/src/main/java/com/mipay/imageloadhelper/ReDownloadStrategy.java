package com.mipay.imageloadhelper;

import android.util.Log;
import com.mipay.imageloadhelper.DownloadManager;

/* JADX INFO: loaded from: classes17.dex */
public class ReDownloadStrategy implements IDownloadErrorStrategy {
    private static final String TAG = "ReDownloadStrategy";
    private int mCurrentTryTime = 0;
    private int mMaxRetryTime;
    private DownloadManager.DownloadTask mTask;

    public ReDownloadStrategy(int i) {
        this.mMaxRetryTime = i;
    }

    @Override // com.mipay.imageloadhelper.IDownloadErrorStrategy
    public boolean handleDownloadError(int i, String str) {
        if (this.mTask == null) {
            Log.d(TAG, "mTask is null");
            return false;
        }
        int i2 = this.mCurrentTryTime;
        if (i2 >= this.mMaxRetryTime) {
            return false;
        }
        this.mCurrentTryTime = i2 + 1;
        Log.d(TAG, "current retry time:" + this.mCurrentTryTime);
        this.mTask.run();
        return true;
    }

    @Override // com.mipay.imageloadhelper.IDownloadErrorStrategy
    public void setDownloadTask(DownloadManager.DownloadTask downloadTask) {
        this.mTask = downloadTask;
    }
}
