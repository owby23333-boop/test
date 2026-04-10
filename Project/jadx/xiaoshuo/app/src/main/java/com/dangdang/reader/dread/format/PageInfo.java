package com.dangdang.reader.dread.format;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class PageInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private int endIndex;
    private int startIndex;

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public boolean hasContain(int i) {
        return i >= this.startIndex && i <= this.endIndex;
    }

    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    public String toString() {
        return "[" + this.startIndex + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.endIndex + "]";
    }
}
