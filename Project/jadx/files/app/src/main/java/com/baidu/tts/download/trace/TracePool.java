package com.baidu.tts.download.trace;

import com.baidu.tts.client.model.DownloadHandler;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TracePool {
    private static volatile TracePool mInstance;
    private ConcurrentHashMap<String, ModelFlyweight> mModelPool = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ModelFileFlyweight> mModelFilePool = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, FsFileInfoFlyweight> mFsFilePool = new ConcurrentHashMap<>();

    private TracePool() {
    }

    public static TracePool getInstance() {
        if (mInstance == null) {
            synchronized (TracePool.class) {
                if (mInstance == null) {
                    mInstance = new TracePool();
                }
            }
        }
        return mInstance;
    }

    public void forceStop() {
        Iterator<ModelFlyweight> it = this.mModelPool.values().iterator();
        while (it.hasNext()) {
            it.next().clearAndStop();
        }
    }

    public long getFileLength(String str) {
        return getFsFileByFileId(str).getLength();
    }

    public int getFileState(String str) {
        return getFsFileByFileId(str).getFileState();
    }

    public FsFileInfoFlyweight getFsFileByFileId(String str) {
        ModelFileFlyweight modelFileMemory = getModelFileMemory(str);
        if (modelFileMemory != null) {
            return getFsFileMemory(modelFileMemory.getAbsPath());
        }
        return null;
    }

    public FsFileInfoFlyweight getFsFileMemory(String str) {
        try {
            FsFileInfoFlyweight fsFileInfoFlyweight = new FsFileInfoFlyweight(str);
            FsFileInfoFlyweight fsFileInfoFlyweightPutIfAbsent = this.mFsFilePool.putIfAbsent(str, fsFileInfoFlyweight);
            return fsFileInfoFlyweightPutIfAbsent == null ? fsFileInfoFlyweight : fsFileInfoFlyweightPutIfAbsent;
        } catch (Exception unused) {
            return null;
        }
    }

    public ModelFileFlyweight getModelFileMemory(String str) {
        try {
            ModelFileFlyweight modelFileFlyweight = new ModelFileFlyweight(str);
            ModelFileFlyweight modelFileFlyweightPutIfAbsent = this.mModelFilePool.putIfAbsent(str, modelFileFlyweight);
            return modelFileFlyweightPutIfAbsent == null ? modelFileFlyweight : modelFileFlyweightPutIfAbsent;
        } catch (Exception unused) {
            return null;
        }
    }

    public ModelFlyweight getModelMemory(String str) {
        try {
            ModelFlyweight modelFlyweight = new ModelFlyweight(str);
            ModelFlyweight modelFlyweightPutIfAbsent = this.mModelPool.putIfAbsent(str, modelFlyweight);
            return modelFlyweightPutIfAbsent == null ? modelFlyweight : modelFlyweightPutIfAbsent;
        } catch (Exception unused) {
            return null;
        }
    }

    public void unregisterDownloadHandler(DownloadHandler downloadHandler) {
        getModelMemory(downloadHandler.getModelId()).unregisterListener(downloadHandler);
    }

    public void unregisterFileObserver(String str, String str2) {
        FsFileInfoFlyweight fsFileByFileId = getFsFileByFileId(str);
        if (fsFileByFileId != null) {
            fsFileByFileId.unregisterObserver(str2);
        }
    }
}
