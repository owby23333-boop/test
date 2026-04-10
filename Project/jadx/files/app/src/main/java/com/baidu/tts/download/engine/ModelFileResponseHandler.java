package com.baidu.tts.download.engine;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.network.RangeFileAsyncHttpResponseHandler;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ModelFileResponseHandler extends RangeFileAsyncHttpResponseHandler {
    private static final String TAG = "ModelFileResponseHandler";
    private DownloadRecord mDownloadRecord;

    public ModelFileResponseHandler(File file, DownloadRecord downloadRecord) {
        super(file);
        this.mDownloadRecord = downloadRecord;
    }

    @Override // com.baidu.tts.network.FileAsyncHttpResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, Throwable th, File file) {
        String message;
        if (th != null) {
            Throwable cause = th.getCause();
            message = cause == null ? th.getMessage() : cause.getMessage();
        } else {
            message = null;
        }
        LoggerProxy.d(TAG, "onFailure statuscode=" + i2 + "--msg=" + message);
        this.mDownloadRecord.updateFailure(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_REQUEST_ERROR, i2, "download failure", th));
    }

    @Override // com.baidu.tts.network.FileAsyncHttpResponseHandler
    public void onProgress(long j2, long j3) {
        this.mDownloadRecord.updateProgress(j2, j3);
    }

    @Override // com.baidu.tts.network.FileAsyncHttpResponseHandler
    public void onSuccess(int i2, Map<String, List<String>> map, File file) {
        LoggerProxy.d(TAG, "onSuccess");
        this.mDownloadRecord.updateSuccess();
    }
}
