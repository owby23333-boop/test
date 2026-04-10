package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class FattenChapterNum implements Serializable {
    private int chapterNum;
    private String chapterTitle;

    public FattenChapterNum() {
    }

    public int getChapterNum() {
        return this.chapterNum;
    }

    public String getChapterTitle() {
        return this.chapterTitle;
    }

    public void setChapterNum(int i2) {
        this.chapterNum = i2;
    }

    public void setChapterTitle(String str) {
        this.chapterTitle = str;
    }

    public FattenChapterNum(String str, int i2) {
        this.chapterNum = i2;
        this.chapterTitle = str;
    }
}
