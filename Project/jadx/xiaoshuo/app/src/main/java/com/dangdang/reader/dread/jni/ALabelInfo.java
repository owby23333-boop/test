package com.dangdang.reader.dread.jni;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class ALabelInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private String anchor;
    private int endIndex;
    private int pageIndex;
    private int startIndex;

    public String getAnchor() {
        return this.anchor;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public boolean isSame(String str) {
        String str2 = this.anchor;
        return str2 != null && str2.equals(str);
    }

    public void setAnchor(String str) {
        this.anchor = str;
    }

    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    public void setPageIndex(int i) {
        this.pageIndex = i;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }
}
