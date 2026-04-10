package com.baidu.tts.download;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.DbManager;
import com.baidu.tts.download.engine.DownloadEngine;
import com.baidu.tts.download.engine.DownloadRecord;
import com.baidu.tts.download.trace.DownloadTrace;
import com.baidu.tts.download.trace.FsFileInfoFlyweight;
import com.baidu.tts.download.trace.ModelFileFlyweight;
import com.baidu.tts.download.trace.ModelFlyweight;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.life.ILife;
import com.baidu.tts.modelmanager.ModelMediator;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class Downloader implements ILife {
    private static final String TAG = "Downloader";
    private static volatile Downloader mInstance;
    private ExecutorService mExecutorService;
    private ModelMediator mModelMediator;
    private DownloadTrace mTrace = DownloadTrace.getInstance();
    private DownloadEngine mEngine = new DownloadEngine();

    public class CheckWork implements Callable<CheckResult> {
        private DownloadHandler mDownloadHandler;

        public CheckWork(DownloadHandler downloadHandler) {
            this.mDownloadHandler = downloadHandler;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public CheckResult call() throws Exception {
            CheckResult checkResult = new CheckResult();
            DbManager dbManager = Downloader.this.mModelMediator.getDbManager();
            String modelId = this.mDownloadHandler.getModelId();
            ModelFlyweight modelMemory = Downloader.this.mTrace.getModelMemory(modelId);
            try {
                modelMemory.updateStart(this.mDownloadHandler);
                if (!modelMemory.isDbModelValid(dbManager)) {
                    Conditions conditions = new Conditions();
                    conditions.appendId(modelId);
                    ModelBags modelBags = Downloader.this.mModelMediator.getServerModels(conditions).get();
                    if (modelBags != null && !modelBags.isEmpty()) {
                        modelMemory.insertModelBags(modelBags, dbManager);
                    }
                    modelMemory.updateFinish(this.mDownloadHandler, TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_BAGS_EMPTY, "modelId=" + modelId));
                    return checkResult;
                }
                Set<String> fileIds = modelMemory.getFileIds();
                if (DataTool.isSetEmpty(fileIds)) {
                    modelMemory.updateFinish(this.mDownloadHandler, TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_DB_MODEL_INVALID, "modelId=" + modelId));
                    return checkResult;
                }
                for (String str : fileIds) {
                    ModelFileFlyweight modelFileMemory = Downloader.this.mTrace.getModelFileMemory(str);
                    if (!modelFileMemory.isDbModelFileValid(dbManager)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(str);
                        ModelFileBags modelFileBags = Downloader.this.mModelMediator.getServerModelFileInfos(hashSet).get();
                        if (modelFileBags != null && !modelFileBags.isEmpty()) {
                            modelFileBags.generateAbsPath(Downloader.this.mModelMediator.getContext());
                            modelFileMemory.insertModelFileBags(modelFileBags, dbManager);
                        }
                        modelMemory.updateFinish(this.mDownloadHandler, TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_FILE_BAG_EMPTY, "fileId=" + str));
                        return checkResult;
                    }
                }
                modelMemory.ifNeedGenerateTotalSize();
                Set<String> absPaths = modelMemory.getAbsPaths();
                if (DataTool.isSetEmpty(absPaths)) {
                    modelMemory.updateFinish(this.mDownloadHandler, TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_DB_MODEL_FILE_PATHS_INVALID, "modelId=" + modelId));
                    return checkResult;
                }
                for (String str2 : absPaths) {
                    if (!StringTool.isEmpty(str2)) {
                        FsFileInfoFlyweight fsFileMemory = Downloader.this.mTrace.getFsFileMemory(str2);
                        fsFileMemory.registerObserver(modelId);
                        boolean zIsNeedDownload = fsFileMemory.isNeedDownload(dbManager);
                        String fileId = fsFileMemory.getFileId();
                        LoggerProxy.d(Downloader.TAG, "isNeedDownload=" + zIsNeedDownload + "--fileId=" + fileId);
                        if (zIsNeedDownload) {
                            if (fsFileMemory.isFileInvalid()) {
                                fsFileMemory.deleteFile();
                            }
                            DownloadRecord downloadRecord = new DownloadRecord();
                            downloadRecord.setFsFileInfoMemory(fsFileMemory);
                            if (Thread.currentThread().isInterrupted()) {
                                return null;
                            }
                            LoggerProxy.d(Downloader.TAG, "before download fileId=" + fileId);
                            fsFileMemory.setEngineDownloadHandler(Downloader.this.mEngine.download(downloadRecord));
                            checkResult.setHasDownload(true);
                        } else {
                            checkResult.put(str2, fsFileMemory.getFileState());
                        }
                    }
                }
                if (!checkResult.isHasDownload() && checkResult.isDownloadSuccess()) {
                    this.mDownloadHandler.updateProgress(modelMemory);
                    modelMemory.updateFinish(this.mDownloadHandler, TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_EXISTS, "modelId=" + modelId));
                }
                return checkResult;
            } catch (Exception e2) {
                LoggerProxy.d(Downloader.TAG, "exception=" + e2.toString());
                modelMemory.updateFinish(this.mDownloadHandler, TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MODEL_CHECK_EXCEPTION, "modelId=" + modelId));
                return checkResult;
            }
        }
    }

    private Downloader() {
    }

    private synchronized ExecutorService getAvailableExecutor() {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newSingleThreadExecutor();
        }
        return this.mExecutorService;
    }

    public static Downloader getInstance() {
        if (mInstance == null) {
            synchronized (Downloader.class) {
                if (mInstance == null) {
                    mInstance = new Downloader();
                }
            }
        }
        return mInstance;
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized void destroy() {
    }

    public synchronized DownloadHandler download(DownloadHandler downloadHandler) {
        LoggerProxy.d(TAG, "download handler=" + downloadHandler);
        downloadHandler.setCheckFuture(getAvailableExecutor().submit(new CheckWork(downloadHandler)));
        return downloadHandler;
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized void pause() {
        this.mEngine.pause();
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized void resume() {
        this.mEngine.resume();
    }

    public void setModelMediator(ModelMediator modelMediator) {
        this.mModelMediator = modelMediator;
        this.mTrace.setDbManager(this.mModelMediator.getDbManager());
        this.mEngine.setModelMediator(this.mModelMediator);
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized void start() {
        getAvailableExecutor();
        this.mEngine.start();
    }

    @Override // com.baidu.tts.life.ILife
    public synchronized void stop() {
        LoggerProxy.d(TAG, "enter stop");
        this.mTrace.forceStop();
        if (this.mExecutorService != null) {
            if (!this.mExecutorService.isShutdown()) {
                this.mExecutorService.shutdownNow();
                this.mEngine.stop();
                LoggerProxy.d(TAG, "after engine stop");
            }
            try {
                LoggerProxy.d(TAG, "before awaitTermination");
                LoggerProxy.d(TAG, "after awaitTermination isTermination=" + this.mExecutorService.awaitTermination(TimeOutEnum.DEFAULT.getMillSeconds(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException unused) {
            }
            this.mExecutorService = null;
        }
        LoggerProxy.d(TAG, "end stop");
    }
}
