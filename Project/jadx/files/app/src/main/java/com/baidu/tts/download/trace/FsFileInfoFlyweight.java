package com.baidu.tts.download.trace;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.database.DbManager;
import com.baidu.tts.download.engine.EngineDownloadHandler;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class FsFileInfoFlyweight {
    public static final int DB_FILE_DOWNLOAD_FAILURE = 8;
    public static final int DB_FILE_DOWNLOAD_ING = 6;
    public static final int DB_FILE_DOWNLOAD_NOT_EXIST = 9;
    public static final int DB_FILE_DOWNLOAD_SUCCESS = 7;
    public static final int FILE_LENGTH_WRONG = 2;
    public static final int FILE_MD5_WRONG = 3;
    public static final int FILE_NOT_EXIST = 1;
    public static final int FILE_NOW_ISDOWNLOADING = 5;
    public static final int FILE_NOW_QUEUE_FOR_DOWNLOAD = 4;
    public static final int FILE_UNCHECK = 0;
    private static final String TAG = "FsFileInfoFlyweight";
    private String mAbsPath;
    private EngineDownloadHandler mEngineDownloadHandler;
    private String mFileId;
    private long mLength;
    private String mMd5;
    private volatile int mFileState = 0;
    private volatile int mDbState = 9;
    private CopyOnWriteArraySet<String> mModelObservers = new CopyOnWriteArraySet<>();

    public FsFileInfoFlyweight(String str) {
        this.mAbsPath = str;
    }

    private void stopDownloadWork() {
        if (this.mEngineDownloadHandler != null) {
            LoggerProxy.d(TAG, "unregisterObserver stop");
            this.mEngineDownloadHandler.stop();
            this.mEngineDownloadHandler = null;
            if (this.mFileState == 4 || this.mFileState == 5) {
                this.mFileState = 8;
                this.mDbState = 8;
                DownloadTrace.getInstance().getDbManager().replaceFsFileState(this.mAbsPath, this.mDbState);
            }
        }
    }

    public int checkDb(DbManager dbManager) {
        String mapValue = DataTool.getMapValue(dbManager.selectFsFileState(this.mAbsPath), KeyEnum.STATE.getFullName());
        if (StringTool.isEmpty(mapValue)) {
            this.mDbState = 9;
        } else {
            this.mDbState = Integer.parseInt(mapValue);
        }
        return this.mDbState;
    }

    public int checkFile(ModelFileFlyweight modelFileFlyweight) {
        File file = new File(this.mAbsPath);
        if (file.exists()) {
            this.mLength = file.length();
            if (this.mLength == Long.parseLong(modelFileFlyweight.getLength())) {
                this.mMd5 = MD5.getInstance().getBigFileMd5(file);
                if (modelFileFlyweight.getMd5().equalsIgnoreCase(this.mMd5)) {
                    this.mFileState = 7;
                } else {
                    this.mFileState = 3;
                }
            } else {
                this.mFileState = 2;
            }
        } else {
            this.mFileState = 1;
        }
        return this.mFileState;
    }

    public boolean deleteFile() {
        return new File(this.mAbsPath).delete();
    }

    public String getAbsPath() {
        return this.mAbsPath;
    }

    public int getDbState() {
        return this.mDbState;
    }

    public EngineDownloadHandler getEngineDownloadHandler() {
        return this.mEngineDownloadHandler;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public int getFileState() {
        return this.mFileState;
    }

    public long getLength() {
        return this.mLength;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public boolean isFileInvalid() {
        if (this.mFileState != 7 && this.mFileState != 4 && this.mFileState != 5) {
            if (this.mLength >= Long.parseLong(TracePool.getInstance().getModelFileMemory(this.mFileId).getLength())) {
                return true;
            }
        }
        return false;
    }

    public boolean isNeedDownload(DbManager dbManager) {
        ModelFileFlyweight modelFileMemory = TracePool.getInstance().getModelFileMemory(this.mFileId);
        if (this.mFileState == 0) {
            checkFile(modelFileMemory);
            checkDb(dbManager);
        } else if (this.mFileState == 8 || this.mFileState == 7) {
            checkFile(modelFileMemory);
        }
        if (this.mFileState == 7 && this.mDbState != 7) {
            this.mDbState = 7;
            dbManager.replaceFsFileState(this.mAbsPath, this.mDbState);
        }
        LoggerProxy.d(TAG, "fileId=" + this.mFileId + "--filestate=" + this.mFileState + "--dbstate=" + this.mDbState);
        return (this.mFileState == 4 || this.mFileState == 5 || this.mFileState == 7) ? false : true;
    }

    public void onDownloadFailure(TtsError ttsError) {
        LoggerProxy.d(TAG, "onDownloadFailure");
        this.mFileState = 8;
        this.mDbState = 8;
        DownloadTrace downloadTrace = DownloadTrace.getInstance();
        downloadTrace.getDbManager().replaceFsFileState(this.mAbsPath, this.mDbState);
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.mModelObservers;
        if (copyOnWriteArraySet != null) {
            for (String str : copyOnWriteArraySet) {
                downloadTrace.getModelMemory(str).onFileDownloadFailure(this, ttsError);
                this.mModelObservers.remove(str);
            }
        }
    }

    public void onDownloadProgress(long j2, long j3) {
        DownloadTrace downloadTrace = DownloadTrace.getInstance();
        this.mLength = j2;
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.mModelObservers;
        if (copyOnWriteArraySet != null) {
            Iterator<String> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                downloadTrace.getModelMemory(it.next()).onFileDownloadProgress(this);
            }
        }
    }

    public void onDownloadSuccess() {
        LoggerProxy.d(TAG, "onDownloadSuccess");
        this.mFileState = 7;
        this.mDbState = 7;
        DownloadTrace downloadTrace = DownloadTrace.getInstance();
        downloadTrace.getDbManager().replaceFsFileState(this.mAbsPath, this.mDbState);
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.mModelObservers;
        if (copyOnWriteArraySet != null) {
            for (String str : copyOnWriteArraySet) {
                downloadTrace.getModelMemory(str).onFileDownloadSuccess(this);
                this.mModelObservers.remove(str);
            }
        }
    }

    public void onDownloadWorkStart() {
        this.mFileState = 5;
        this.mDbState = 6;
        DownloadTrace.getInstance().getDbManager().replaceFsFileState(this.mAbsPath, this.mDbState);
    }

    public void queueForDownload() {
        LoggerProxy.d(TAG, "queueForDownload fileId=" + this.mFileId + "--filestate=" + this.mFileState);
        this.mFileState = 4;
    }

    public void registerObserver(String str) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = this.mModelObservers;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.add(str);
        }
    }

    public void setDbState(int i2) {
        this.mDbState = i2;
    }

    public void setEngineDownloadHandler(EngineDownloadHandler engineDownloadHandler) {
        this.mEngineDownloadHandler = engineDownloadHandler;
    }

    public void setFileId(String str) {
        this.mFileId = str;
    }

    public void setFileState(int i2) {
        this.mFileState = i2;
    }

    public void unregisterObserver(String str) {
        boolean zIsSetEmpty = DataTool.isSetEmpty(this.mModelObservers);
        LoggerProxy.d(TAG, "unregisterObserver 1isEmpty=" + zIsSetEmpty);
        if (zIsSetEmpty) {
            return;
        }
        this.mModelObservers.remove(str);
        boolean zIsSetEmpty2 = DataTool.isSetEmpty(this.mModelObservers);
        LoggerProxy.d(TAG, "unregisterObserver 2isEmpty=" + zIsSetEmpty2);
        if (zIsSetEmpty2) {
            stopDownloadWork();
        }
    }
}
