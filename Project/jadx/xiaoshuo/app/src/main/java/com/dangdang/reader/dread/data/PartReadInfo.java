package com.dangdang.reader.dread.data;

/* JADX INFO: loaded from: classes10.dex */
public class PartReadInfo extends ReadInfo {
    private String bookAuthor;
    private String bookCategories;
    private String bookCover;
    private String bookDesc;
    private int indexOrder;
    private boolean isAutoBuy;
    private boolean isBoughtChapter;
    private boolean isFollow;
    private boolean isFull;
    private boolean isShelf;
    private boolean isSupportFull;
    private boolean isTimeFree;
    private String saleId;
    private int targetChapterId;

    public String getBookAuthor() {
        return this.bookAuthor;
    }

    public String getBookCategories() {
        return this.bookCategories;
    }

    @Override // com.dangdang.reader.dread.data.ReadInfo
    public String getBookDesc() {
        return this.bookDesc;
    }

    public int getIndexOrder() {
        return this.indexOrder;
    }

    public String getSaleId() {
        return this.saleId;
    }

    public int getTargetChapterId() {
        return this.targetChapterId;
    }

    public boolean isAutoBuy() {
        return this.isAutoBuy;
    }

    public boolean isBoughtChapter() {
        return this.isBoughtChapter;
    }

    public boolean isFollow() {
        return this.isFollow;
    }

    public boolean isFull() {
        return this.isFull;
    }

    public boolean isShelf() {
        return this.isShelf;
    }

    public boolean isSupportFull() {
        return this.isSupportFull;
    }

    public boolean isTimeFree() {
        return this.isTimeFree;
    }

    public void setBookAuthor(String str) {
        this.bookAuthor = str;
    }

    public void setBookCategories(String str) {
        this.bookCategories = str;
    }

    @Override // com.dangdang.reader.dread.data.ReadInfo
    public void setBookDesc(String str) {
        this.bookDesc = str;
    }

    public void setIndexOrder(int i) {
        this.indexOrder = i;
    }

    public void setIsAutoBuy(boolean z) {
        this.isAutoBuy = z;
    }

    public void setIsBoughtChapter(boolean z) {
        this.isBoughtChapter = z;
    }

    public void setIsFollow(boolean z) {
        this.isFollow = z;
    }

    public void setIsFull(boolean z) {
        this.isFull = z;
    }

    public void setIsShelf(boolean z) {
        this.isShelf = z;
    }

    public void setIsSupportFull(boolean z) {
        this.isSupportFull = z;
    }

    public void setIsTimeFree(boolean z) {
        this.isTimeFree = z;
    }

    public void setSaleId(String str) {
        this.saleId = str;
    }

    public void setTargetChapterId(int i) {
        this.targetChapterId = i;
    }
}
