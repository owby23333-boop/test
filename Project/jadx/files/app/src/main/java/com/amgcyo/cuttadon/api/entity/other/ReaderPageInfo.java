package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ReaderPageInfo implements Serializable {
    private String chapterName;
    private int cur;
    private int interval_count;
    private int size;
    private int style;
    private int totalPageSize;

    public ReaderPageInfo(int i2, int i3, int i4, int i5, int i6, String str) {
        this.cur = i2;
        this.size = i3;
        this.totalPageSize = i4;
        this.interval_count = i5;
        this.style = i6;
        this.chapterName = str;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public int getCur() {
        return this.cur;
    }

    public int getInterval_count() {
        return this.interval_count;
    }

    public int getSize() {
        return this.size;
    }

    public int getStyle() {
        return this.style;
    }

    public int getTotalPageSize() {
        return this.totalPageSize;
    }

    public void setChapterName(String str) {
        this.chapterName = str;
    }

    public void setCur(int i2) {
        this.cur = i2;
    }

    public void setInterval_count(int i2) {
        this.interval_count = i2;
    }

    public void setSize(int i2) {
        this.size = i2;
    }

    public void setStyle(int i2) {
        this.style = i2;
    }

    public void setTotalPageSize(int i2) {
        this.totalPageSize = i2;
    }

    public ReaderPageInfo(int i2, int i3) {
        this.interval_count = i2;
        this.style = i3;
    }

    public ReaderPageInfo() {
    }
}
