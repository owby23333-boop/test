package com.yuewen.openapi.entity;

/* JADX INFO: loaded from: classes8.dex */
public class ChapterInfo {
    public int aesType;
    public String bookName;
    public int bookPrice;
    public String cbid;
    public String ccid;
    public String chapterName;
    public int chapterOrder;
    public int chapterPrice;
    public int chargeType;
    public String coverUrl;
    public int freeStatus;
    public int isTaked;
    public String nextCcid;
    public String prevCcid;
    public int updateTime;
    public int vipStatus;
    public int wordsCount;

    public int getAesType() {
        return this.aesType;
    }

    public String getBookName() {
        return this.bookName;
    }

    public int getBookPrice() {
        return this.bookPrice;
    }

    public String getCbid() {
        return this.cbid;
    }

    public String getCcid() {
        return this.ccid;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public int getChapterOrder() {
        return this.chapterOrder;
    }

    public int getChapterPrice() {
        return this.chapterPrice;
    }

    public int getChargeType() {
        return this.chargeType;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getFreeStatus() {
        return this.freeStatus;
    }

    public int getIsTaked() {
        return this.isTaked;
    }

    public String getNextCcid() {
        return this.nextCcid;
    }

    public String getPrevCcid() {
        return this.prevCcid;
    }

    public int getUpdateTime() {
        return this.updateTime;
    }

    public int getVipStatus() {
        return this.vipStatus;
    }

    public int getWordsCount() {
        return this.wordsCount;
    }

    public void setAesType(int i) {
        this.aesType = i;
    }

    public void setBookName(String str) {
        this.bookName = str;
    }

    public void setBookPrice(int i) {
        this.bookPrice = i;
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

    public void setChapterOrder(int i) {
        this.chapterOrder = i;
    }

    public void setChapterPrice(int i) {
        this.chapterPrice = i;
    }

    public void setChargeType(int i) {
        this.chargeType = i;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setFreeStatus(int i) {
        this.freeStatus = i;
    }

    public void setIsTaked(int i) {
        this.isTaked = i;
    }

    public void setNextCcid(String str) {
        this.nextCcid = str;
    }

    public void setPrevCcid(String str) {
        this.prevCcid = str;
    }

    public void setUpdateTime(int i) {
        this.updateTime = i;
    }

    public void setVipStatus(int i) {
        this.vipStatus = i;
    }

    public void setWordsCount(int i) {
        this.wordsCount = i;
    }

    public String toString() {
        return "ChapterInfo{cbid='" + this.cbid + "', ccid='" + this.ccid + "', bookName='" + this.bookName + "', chapterName='" + this.chapterName + "', coverUrl='" + this.coverUrl + "', updateTime=" + this.updateTime + ", prevCcid='" + this.prevCcid + "', nextCcid='" + this.nextCcid + "', chapterOrder=" + this.chapterOrder + ", chargeType=" + this.chargeType + ", wordsCount=" + this.wordsCount + ", freeStatus=" + this.freeStatus + ", vipStatus=" + this.vipStatus + ", isTaked=" + this.isTaked + ", chapterPrice=" + this.chapterPrice + ", bookPrice=" + this.bookPrice + ", aesType=" + this.aesType + '}';
    }
}
