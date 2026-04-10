package com.baidu.tts.download.engine;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.download.engine.DownloadEngine;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class EngineDownloadHandler {
    private static final String TAG = "EngineDownloadHandler";
    private Future<Void> mDownloadFuture;
    private DownloadEngine.DownloadWork mDownloadWork;

    public Future<Void> getDownloadFuture() {
        return this.mDownloadFuture;
    }

    public DownloadEngine.DownloadWork getDownloadWork() {
        return this.mDownloadWork;
    }

    public void setDownloadFuture(Future<Void> future) {
        this.mDownloadFuture = future;
    }

    public void setDownloadWork(DownloadEngine.DownloadWork downloadWork) {
        this.mDownloadWork = downloadWork;
    }

    public void stop() {
        LoggerProxy.d(TAG, "before stop");
        try {
            LoggerProxy.d(TAG, "stop fileId=" + this.mDownloadWork.getDownloadRecord().getFileId());
        } catch (Exception unused) {
        }
        Future<Void> future = this.mDownloadFuture;
        if (future != null) {
            LoggerProxy.d(TAG, "unDone = " + future.cancel(true));
        }
        DownloadEngine.DownloadWork downloadWork = this.mDownloadWork;
        if (downloadWork != null) {
            downloadWork.stop();
        }
        LoggerProxy.d(TAG, "after stop");
    }
}
