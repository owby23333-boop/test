package com.dangdang.reader.format.part;

/* JADX INFO: loaded from: classes10.dex */
public class PartBuyInfo {
    private int chapterId;
    private int chapterPrice;
    private String chapterTitle;
    private int isSupportFullBuy;
    private int mainBalance;
    private String mediaId;
    private long mediaWordCnt;
    private String saleId;
    private String saleName;
    private int salePrice;
    private int subBalance;
    private int wordCnt;

    public int getChapterId() {
        return this.chapterId;
    }

    public int getChapterPrice() {
        return this.chapterPrice;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public int getIsSupportFullBuy() {
        return this.isSupportFullBuy;
    }

    public int getMainBalance() {
        return this.mainBalance;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public long getMediaWordCnt() {
        return this.mediaWordCnt;
    }

    public String getSaleId() {
        return this.saleId;
    }

    public String getSaleName() {
        return this.saleName;
    }

    public int getSalePrice() {
        return this.salePrice;
    }

    public int getSubBalance() {
        return this.subBalance;
    }

    public int getWordCnt() {
        return this.wordCnt;
    }

    public void setChapterId(int i) {
        this.chapterId = i;
    }

    public void setChapterPrice(int i) {
        this.chapterPrice = i;
    }

    public void setChapterTitle(String str) {
        this.chapterTitle = str;
    }

    public void setIsSupportFullBuy(int i) {
        this.isSupportFullBuy = i;
    }

    public void setMainBalance(int i) {
        this.mainBalance = i;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setMediaWordCnt(long j) {
        this.mediaWordCnt = j;
    }

    public void setSaleId(String str) {
        this.saleId = str;
    }

    public void setSaleName(String str) {
        this.saleName = str;
    }

    public void setSalePrice(int i) {
        this.salePrice = i;
    }

    public void setSubBalance(int i) {
        this.subBalance = i;
    }

    public void setWordCnt(int i) {
        this.wordCnt = i;
    }

    public String toString() {
        return "BuyInfo{chapterId='" + this.chapterId + "', chapterPrice=" + this.chapterPrice + ", chapterTitle='" + this.chapterTitle + "', mediaId='" + this.mediaId + "', wordCnt=" + this.wordCnt + ", mainBalance=" + this.mainBalance + ", subBalance=" + this.subBalance + ", saleId='" + this.saleId + "', saleName='" + this.saleName + "', salePrice=" + this.salePrice + ", isSupportFullBuy=" + this.isSupportFullBuy + ", mediaWordCnt=" + this.mediaWordCnt + '}';
    }
}
