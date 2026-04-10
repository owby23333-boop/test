package com.baidu.tts.download.trace;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.database.DbManager;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class ModelFlyweight {
    private static final String TAG = "ModelFlyweight";
    private String mModelId;
    private String mSpeechId;
    private String mTextId;
    private long mTotalBytes = 0;
    private DownloadTrace mDownloadTrace = DownloadTrace.getInstance();
    private CopyOnWriteArraySet<DownloadHandler> mObservers = new CopyOnWriteArraySet<>();

    public ModelFlyweight(String str) {
        this.mModelId = str;
    }

    private void stopBind() {
        this.mDownloadTrace.unregisterFileObserver(this.mTextId, this.mModelId);
        this.mDownloadTrace.unregisterFileObserver(this.mSpeechId, this.mModelId);
    }

    public void clearAndStop() {
        this.mObservers.clear();
        stopBind();
    }

    public void generateTotalSize() {
        TracePool tracePool = TracePool.getInstance();
        String length = tracePool.getModelFileMemory(this.mTextId).getLength();
        String length2 = tracePool.getModelFileMemory(this.mSpeechId).getLength();
        this.mTotalBytes = Long.valueOf(Long.parseLong(length)).longValue() + Long.valueOf(Long.parseLong(length2)).longValue();
    }

    public Set<String> getAbsPaths() {
        HashSet hashSet = new HashSet();
        TracePool tracePool = TracePool.getInstance();
        ModelFileFlyweight modelFileMemory = tracePool.getModelFileMemory(this.mTextId);
        ModelFileFlyweight modelFileMemory2 = tracePool.getModelFileMemory(this.mSpeechId);
        String absPath = modelFileMemory.getAbsPath();
        String absPath2 = modelFileMemory2.getAbsPath();
        hashSet.add(absPath);
        hashSet.add(absPath2);
        return hashSet;
    }

    public long getDownloadBytes() {
        return this.mDownloadTrace.getFileLength(this.mTextId) + this.mDownloadTrace.getFileLength(this.mSpeechId);
    }

    public Set<String> getFileIds() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.mTextId);
        hashSet.add(this.mSpeechId);
        return hashSet;
    }

    public String getModelId() {
        return this.mModelId;
    }

    public String getSpeechId() {
        return this.mSpeechId;
    }

    public String getTextId() {
        return this.mTextId;
    }

    public long getTotalBytes() {
        ifNeedGenerateTotalSize();
        return this.mTotalBytes;
    }

    public void ifNeedGenerateTotalSize() {
        if (this.mTotalBytes == 0) {
            generateTotalSize();
        }
    }

    public void insertModelBags(ModelBags modelBags, DbManager dbManager) {
        dbManager.insertModelBags(modelBags);
        isDbModelValid(dbManager);
    }

    public boolean isDbModelValid(DbManager dbManager) {
        Map<String, String> mapSelectModelInfo = dbManager.selectModelInfo(this.mModelId);
        if (mapSelectModelInfo != null && !mapSelectModelInfo.isEmpty()) {
            this.mTextId = DataTool.getMapValue(mapSelectModelInfo, KeyEnum.TEXT_DATA_ID.getFullName());
            this.mSpeechId = DataTool.getMapValue(mapSelectModelInfo, KeyEnum.SPEECH_DATA_ID.getFullName());
            boolean zIsEmpty = StringTool.isEmpty(this.mTextId);
            boolean zIsEmpty2 = StringTool.isEmpty(this.mSpeechId);
            if (!zIsEmpty && !zIsEmpty2) {
                return true;
            }
            dbManager.deleteModelItem(this.mModelId);
        }
        return false;
    }

    public boolean isModelDownloadSuccess() {
        return this.mDownloadTrace.getFileState(this.mTextId) == 7 && this.mDownloadTrace.getFileState(this.mSpeechId) == 7;
    }

    public void onFileDownloadFailure(FsFileInfoFlyweight fsFileInfoFlyweight, TtsError ttsError) {
        LoggerProxy.d(TAG, "onFileDownloadFailure");
        CopyOnWriteArraySet<DownloadHandler> copyOnWriteArraySet = this.mObservers;
        if (copyOnWriteArraySet != null) {
            Iterator<DownloadHandler> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                updateFinish(it.next(), ttsError);
            }
        }
    }

    public void onFileDownloadProgress(FsFileInfoFlyweight fsFileInfoFlyweight) {
        CopyOnWriteArraySet<DownloadHandler> copyOnWriteArraySet = this.mObservers;
        if (copyOnWriteArraySet != null) {
            Iterator<DownloadHandler> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().updateProgress(this);
            }
        }
    }

    public void onFileDownloadSuccess(FsFileInfoFlyweight fsFileInfoFlyweight) {
        CopyOnWriteArraySet<DownloadHandler> copyOnWriteArraySet;
        boolean zIsModelDownloadSuccess = isModelDownloadSuccess();
        LoggerProxy.d(TAG, "onFileDownloadSuccess isAllFileDownloadSuccess=" + zIsModelDownloadSuccess);
        if (!zIsModelDownloadSuccess || (copyOnWriteArraySet = this.mObservers) == null) {
            return;
        }
        Iterator<DownloadHandler> it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            updateFinish(it.next(), null);
        }
    }

    public void registerListener(DownloadHandler downloadHandler) {
        CopyOnWriteArraySet<DownloadHandler> copyOnWriteArraySet = this.mObservers;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.add(downloadHandler);
        }
    }

    public void unregisterListener(DownloadHandler downloadHandler) {
        boolean zIsSetEmpty = DataTool.isSetEmpty(this.mObservers);
        LoggerProxy.d(TAG, "unregisterListener 1isEmpty=" + zIsSetEmpty);
        if (zIsSetEmpty) {
            return;
        }
        this.mObservers.remove(downloadHandler);
        boolean zIsSetEmpty2 = DataTool.isSetEmpty(this.mObservers);
        LoggerProxy.d(TAG, "unregisterListener 2isEmpty=" + zIsSetEmpty2);
        if (zIsSetEmpty2) {
            stopBind();
            return;
        }
        Iterator<DownloadHandler> it = this.mObservers.iterator();
        while (it.hasNext()) {
            LoggerProxy.d(TAG, "unregisterListener item=" + it.next());
        }
    }

    public void updateFinish(DownloadHandler downloadHandler, TtsError ttsError) {
        downloadHandler.updateFinish(this, ttsError);
        unregisterListener(downloadHandler);
    }

    public void updateStart(DownloadHandler downloadHandler) {
        registerListener(downloadHandler);
        downloadHandler.updateStart(this);
    }
}
