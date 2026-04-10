package com.baidu.tts.download.engine;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.download.trace.FsFileInfoFlyweight;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadRecord {
    private FsFileInfoFlyweight mFsFileInfoMemory;

    public void downloadWorkStart() {
        this.mFsFileInfoMemory.onDownloadWorkStart();
    }

    public String getAbsPath() {
        FsFileInfoFlyweight fsFileInfoFlyweight = this.mFsFileInfoMemory;
        if (fsFileInfoFlyweight != null) {
            return fsFileInfoFlyweight.getAbsPath();
        }
        return null;
    }

    public String getFileId() {
        FsFileInfoFlyweight fsFileInfoFlyweight = this.mFsFileInfoMemory;
        if (fsFileInfoFlyweight != null) {
            return fsFileInfoFlyweight.getFileId();
        }
        return null;
    }

    public FsFileInfoFlyweight getFsFileInfoMemory() {
        return this.mFsFileInfoMemory;
    }

    public void queueForDownload() {
        this.mFsFileInfoMemory.queueForDownload();
    }

    public void setFsFileInfoMemory(FsFileInfoFlyweight fsFileInfoFlyweight) {
        this.mFsFileInfoMemory = fsFileInfoFlyweight;
    }

    public void updateFailure(TtsError ttsError) {
        this.mFsFileInfoMemory.onDownloadFailure(ttsError);
    }

    public void updateProgress(long j2, long j3) {
        this.mFsFileInfoMemory.onDownloadProgress(j2, j3);
    }

    public void updateSuccess() {
        this.mFsFileInfoMemory.onDownloadSuccess();
    }
}
