package com.dangdang.reader.dread.jni;

import com.dangdang.reader.dread.format.Book;

/* JADX INFO: loaded from: classes10.dex */
public class OutlineItem extends Book.BaseNavPoint {
    public final int level;
    public final int page;
    public final int parentIdx;
    private String path;
    public final String title;

    public OutlineItem(int i, String str, int i2, int i3) {
        this.level = i;
        this.title = str;
        this.page = i2;
        this.parentIdx = i3;
    }

    public int getLevel() {
        return this.level;
    }

    public int getParentIdx() {
        return this.parentIdx;
    }

    public String getPath() {
        return this.path;
    }

    public int getPdfPage() {
        return this.page;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
