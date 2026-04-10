package com.baidu.tts.download.engine;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.factory.base.NameThreadFactory;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.life.ASafeLife;
import com.baidu.tts.modelmanager.ModelMediator;
import com.baidu.tts.network.HttpClientUtil;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadEngine extends ASafeLife {
    private static final String TAG = "DownloadEngine";
    private ThreadPoolExecutor mExecutor;
    private ModelMediator mModelMediator;
    private UninitialDownloadState mUninitialState = new UninitialDownloadState(this);
    private InitializedDownloadState mInitializedState = new InitializedDownloadState(this);
    private DownloadingState mDownloadingState = new DownloadingState(this);
    private PauseDownloadState mPauseState = new PauseDownloadState(this);
    private volatile ADownloadState mState = this.mUninitialState;

    public class DownloadWork implements Callable<Void> {
        private HttpClientUtil clientUtil;
        private DownloadRecord mRecord;

        public DownloadWork(DownloadRecord downloadRecord) {
            this.mRecord = downloadRecord;
        }

        public DownloadRecord getDownloadRecord() {
            return this.mRecord;
        }

        public void stop() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            this.mRecord.downloadWorkStart();
            final String fileId = this.mRecord.getFileId();
            LoggerProxy.d(DownloadEngine.TAG, "DownloadWork start fileId=" + fileId);
            if (StringTool.isEmpty(fileId)) {
                this.mRecord.updateFailure(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_REQUEST_ERROR, "fileId is null"));
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(fileId);
                ModelFileBags modelFileBags = DownloadEngine.this.mModelMediator.getServerModelFileInfos(hashSet).get();
                if (modelFileBags != null) {
                    String url = modelFileBags.getUrl(0);
                    if (url != null) {
                        HttpClientUtil httpClientUtil = new HttpClientUtil();
                        httpClientUtil.setURLEncodingEnabled(false);
                        httpClientUtil.setTimeOut(TimeOutEnum.DEFAULT.getMillSecondsInt());
                        ModelFileResponseHandler modelFileResponseHandler = new ModelFileResponseHandler(FileTools.getFile(this.mRecord.getAbsPath()), this.mRecord) { // from class: com.baidu.tts.download.engine.DownloadEngine.DownloadWork.1
                            @Override // com.baidu.tts.download.engine.ModelFileResponseHandler, com.baidu.tts.network.FileAsyncHttpResponseHandler
                            public void onFailure(int i2, Map<String, List<String>> map, Throwable th, File file) {
                                LoggerProxy.d(DownloadEngine.TAG, "1isInterrupted=" + Thread.currentThread().isInterrupted());
                                if (DownloadEngine.this.isNeedToNotify()) {
                                    super.onFailure(i2, map, th, file);
                                }
                            }

                            @Override // com.baidu.tts.download.engine.ModelFileResponseHandler, com.baidu.tts.network.FileAsyncHttpResponseHandler
                            public void onProgress(long j2, long j3) {
                                LoggerProxy.d(DownloadEngine.TAG, "onProgress fileId=" + fileId + "--written=" + j2);
                                if (DownloadEngine.this.isNeedToNotify()) {
                                    super.onProgress(j2, j3);
                                }
                            }

                            @Override // com.baidu.tts.download.engine.ModelFileResponseHandler, com.baidu.tts.network.FileAsyncHttpResponseHandler
                            public void onSuccess(int i2, Map<String, List<String>> map, File file) {
                                LoggerProxy.d(DownloadEngine.TAG, "2isInterrupted=" + Thread.currentThread().isInterrupted() + "--fileId=" + fileId);
                                if (DownloadEngine.this.isNeedToNotify()) {
                                    super.onSuccess(i2, map, file);
                                }
                            }
                        };
                        LoggerProxy.d(DownloadEngine.TAG, "before get fileId=" + fileId);
                        httpClientUtil.get(url, modelFileResponseHandler);
                    } else {
                        this.mRecord.updateFailure(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_REQUEST_ERROR, "url is null"));
                    }
                } else {
                    this.mRecord.updateFailure(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_REQUEST_ERROR, "urlbags is null"));
                }
            }
            LoggerProxy.d(DownloadEngine.TAG, "DownloadWork end");
            return null;
        }
    }

    public DownloadEngine() {
        create();
    }

    public EngineDownloadHandler download(DownloadRecord downloadRecord) {
        return this.mState.download(downloadRecord);
    }

    public DownloadingState getDownloadingState() {
        return this.mDownloadingState;
    }

    public InitializedDownloadState getInitializedState() {
        return this.mInitializedState;
    }

    public ModelMediator getModelMediator() {
        return this.mModelMediator;
    }

    public PauseDownloadState getPauseState() {
        return this.mPauseState;
    }

    public ADownloadState getState() {
        return this.mState;
    }

    public UninitialDownloadState getUninitialState() {
        return this.mUninitialState;
    }

    @Override // com.baidu.tts.life.ASafeLife
    public boolean isPaused() {
        return this.mState == this.mPauseState;
    }

    @Override // com.baidu.tts.life.ASafeLife
    public boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.mState == this.mInitializedState;
    }

    EngineDownloadHandler machineDownload(DownloadRecord downloadRecord) {
        Future<Void> futureSubmit;
        DownloadWork downloadWork = new DownloadWork(downloadRecord);
        downloadRecord.queueForDownload();
        LoggerProxy.d(TAG, "before submit");
        try {
            futureSubmit = this.mExecutor.submit(downloadWork);
        } catch (Exception e2) {
            LoggerProxy.d(TAG, "submit exception");
            downloadRecord.updateFailure(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_FILE_DOWNLOAD_EXCEPTION, e2));
            futureSubmit = null;
        }
        EngineDownloadHandler engineDownloadHandler = new EngineDownloadHandler();
        engineDownloadHandler.setDownloadFuture(futureSubmit);
        engineDownloadHandler.setDownloadWork(downloadWork);
        return engineDownloadHandler;
    }

    void machineNewExecutor() {
        this.mExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5, new NameThreadFactory("bdtts-downloadPoolThread"));
    }

    void machineStop() {
        LoggerProxy.d(TAG, "enter stop");
        ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
        if (threadPoolExecutor != null) {
            if (!threadPoolExecutor.isShutdown()) {
                this.mExecutor.shutdownNow();
            }
            try {
                LoggerProxy.d(TAG, "before awaitTermination");
                LoggerProxy.d(TAG, "after awaitTermination isTermination=" + this.mExecutor.awaitTermination(TimeOutEnum.DEFAULT.getMillSeconds(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException unused) {
            }
            this.mExecutor = null;
        }
        LoggerProxy.d(TAG, "end stop");
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected TtsError safeCreate() {
        return this.mState.create();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeDestroy() {
        this.mState.destroy();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safePause() {
        this.mState.pause();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeResume() {
        this.mState.resume();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeStart() {
        this.mState.start();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeStop() {
        this.mState.stop();
    }

    public void setModelMediator(ModelMediator modelMediator) {
        this.mModelMediator = modelMediator;
    }

    public void setState(ADownloadState aDownloadState) {
        this.mState = aDownloadState;
    }
}
