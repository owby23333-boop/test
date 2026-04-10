package com.baidu.tts.client.model;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.download.CheckResult;
import com.baidu.tts.download.DownloadParams;
import com.baidu.tts.download.trace.DownloadTrace;
import com.baidu.tts.download.trace.ModelFlyweight;
import com.baidu.tts.modelmanager.ModelMediator;
import java.util.UUID;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadHandler {
    public static final int DOWNLOAD_SUCCESS = 0;
    private static final String TAG = "DownloadHandler";
    private Future<CheckResult> mCheckFuture;
    private DownloadParams mDownloadParams;
    private ModelMediator mModelMediator;
    private TtsError mTtsError;
    private DownloadTrace mDownloadTrace = DownloadTrace.getInstance();
    private volatile boolean isStopped = false;
    private RecordData recordData = null;
    private String uuid = UUID.randomUUID().toString();

    public DownloadHandler(ModelMediator modelMediator) {
        this.mModelMediator = modelMediator;
    }

    private OnDownloadListener getDownloadListener() {
        return this.mDownloadParams.getDownloadListener();
    }

    private void onFinish(String str, int i2) {
        if (Statistics.isStatistics) {
            this.recordData.setEndInfo(this.uuid, str, i2, System.currentTimeMillis() + "");
        }
        OnDownloadListener downloadListener = getDownloadListener();
        if (downloadListener != null) {
            synchronized (this) {
                if (!this.isStopped) {
                    downloadListener.onFinish(str, i2);
                    this.mDownloadParams.setDownloadListener(null);
                }
            }
        }
        synchronized (this) {
            if (Statistics.isStatistics) {
                this.recordData.setEndInfo(this.uuid, str, i2, System.currentTimeMillis() + "");
            }
            if (Statistics.isStatistics) {
                LoggerProxy.d(TAG, " statistics ret=" + new Statistics(this.mModelMediator.getContext()).start());
            }
        }
    }

    private void onProgress(String str, long j2, long j3) {
        OnDownloadListener downloadListener = getDownloadListener();
        if (downloadListener != null) {
            synchronized (this) {
                if (!this.isStopped) {
                    downloadListener.onProgress(str, j2, j3);
                }
            }
        }
    }

    private void onStart(String str) {
        this.recordData = new RecordData(this.mModelMediator);
        synchronized (this) {
            if (Statistics.isStatistics) {
                this.recordData.setStartInfo(this.uuid, str, System.currentTimeMillis() + "");
            }
        }
        OnDownloadListener downloadListener = getDownloadListener();
        if (downloadListener != null) {
            synchronized (this) {
                if (!this.isStopped) {
                    downloadListener.onStart(str);
                }
            }
        }
    }

    public DownloadParams getDownloadParams() {
        return this.mDownloadParams;
    }

    public int getErrorCode() {
        return getErrorCode(this.mTtsError);
    }

    public String getErrorMessage() {
        return getErrorMessage(this.mTtsError);
    }

    public String getModelId() {
        return this.mDownloadParams.getModelId();
    }

    public TtsError getTtsError() {
        return this.mTtsError;
    }

    public void reset(DownloadParams downloadParams) {
        setDownloadParams(downloadParams);
        reset();
    }

    public void setCheckFuture(Future<CheckResult> future) {
        this.mCheckFuture = future;
    }

    public void setDownloadParams(DownloadParams downloadParams) {
        this.mDownloadParams = downloadParams;
    }

    public void setTtsError(TtsError ttsError) {
        this.mTtsError = ttsError;
    }

    public synchronized void stop() {
        LoggerProxy.d(TAG, "stop");
        this.isStopped = true;
        if (this.mCheckFuture != null) {
            this.mCheckFuture.cancel(true);
            this.mCheckFuture = null;
        }
        this.mDownloadTrace.unregisterDownloadHandler(this);
        this.mDownloadParams.setDownloadListener(null);
    }

    public void updateFinish(ModelFlyweight modelFlyweight, TtsError ttsError) {
        updateFinish(modelFlyweight.getModelId(), ttsError);
    }

    public void updateProgress(ModelFlyweight modelFlyweight) {
        onProgress(modelFlyweight.getModelId(), modelFlyweight.getDownloadBytes(), modelFlyweight.getTotalBytes());
    }

    public void updateStart(ModelFlyweight modelFlyweight) {
        onStart(modelFlyweight.getModelId());
    }

    public int getErrorCode(TtsError ttsError) {
        if (ttsError != null) {
            return ttsError.getDetailCode();
        }
        return 0;
    }

    public String getErrorMessage(TtsError ttsError) {
        if (ttsError != null) {
            return ttsError.getDetailMessage();
        }
        return null;
    }

    public void updateFinish(String str, TtsError ttsError) {
        setTtsError(ttsError);
        onFinish(str, getErrorCode());
    }

    public synchronized void reset() {
        LoggerProxy.d(TAG, "reset");
        this.isStopped = false;
    }
}
