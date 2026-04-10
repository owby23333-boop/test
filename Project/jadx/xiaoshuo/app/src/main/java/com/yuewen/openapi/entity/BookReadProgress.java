package com.yuewen.openapi.entity;

/* JADX INFO: loaded from: classes8.dex */
public class BookReadProgress {
    public String cbid;
    public String ccid;
    public String chapterName;
    public String createTime;
    public String uploadTime;
    public long wordOffset;

    public String getCbid() {
        return this.cbid;
    }

    public String getCcid() {
        return this.ccid;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getUploadTime() {
        return this.uploadTime;
    }

    public long getWordOffset() {
        return this.wordOffset;
    }

    public void setCbid(String str) {
        this.cbid = str;
    }

    public void setCcid(String str) {
        this.ccid = str;
    }

    public void setChapterName(String str) {
        this.chapterName = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setUploadTime(String str) {
        this.uploadTime = str;
    }

    public void setWordOffset(long j) {
        this.wordOffset = j;
    }

    public String toString() {
        return "BookReadProgress{cbid='" + this.cbid + "', ccid='" + this.ccid + "', chapterName='" + this.chapterName + "', wordOffset=" + this.wordOffset + ", uploadTime='" + this.uploadTime + "', createTime='" + this.createTime + "'}";
    }
}
