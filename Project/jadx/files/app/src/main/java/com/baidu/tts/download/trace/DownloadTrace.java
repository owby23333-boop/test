package com.baidu.tts.download.trace;

import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.database.DbManager;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadTrace {
    private static volatile DownloadTrace mInstance;
    private DbManager mDbManager;
    private TracePool mMemoryPool = TracePool.getInstance();

    private DownloadTrace() {
    }

    public static DownloadTrace getInstance() {
        if (mInstance == null) {
            synchronized (DownloadTrace.class) {
                if (mInstance == null) {
                    mInstance = new DownloadTrace();
                }
            }
        }
        return mInstance;
    }

    public void forceStop() {
        this.mMemoryPool.forceStop();
    }

    public DbManager getDbManager() {
        return this.mDbManager;
    }

    public long getFileLength(String str) {
        return this.mMemoryPool.getFileLength(str);
    }

    public int getFileState(String str) {
        return this.mMemoryPool.getFileState(str);
    }

    public FsFileInfoFlyweight getFsFileMemory(String str) {
        return this.mMemoryPool.getFsFileMemory(str);
    }

    public ModelFileFlyweight getModelFileMemory(String str) {
        return this.mMemoryPool.getModelFileMemory(str);
    }

    public ModelFlyweight getModelMemory(String str) {
        return this.mMemoryPool.getModelMemory(str);
    }

    public void setDbManager(DbManager dbManager) {
        this.mDbManager = dbManager;
    }

    public void unregisterDownloadHandler(DownloadHandler downloadHandler) {
        this.mMemoryPool.unregisterDownloadHandler(downloadHandler);
    }

    public void unregisterFileObserver(String str, String str2) {
        this.mMemoryPool.unregisterFileObserver(str, str2);
    }
}
