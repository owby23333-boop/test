package com.dangdang.reader.dread.data;

import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes10.dex */
public class MarkKey {
    private String bookModVersion;
    private int chapterIndex;
    private int elementIndex;
    private String productId;

    public MarkKey() {
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MarkKey)) {
            return false;
        }
        MarkKey markKey = (MarkKey) obj;
        if (!markKey.productId.equals(this.productId)) {
            return false;
        }
        String str = markKey.bookModVersion;
        return (str == null || str.equals(this.bookModVersion)) && markKey.chapterIndex == this.chapterIndex && markKey.elementIndex == this.elementIndex;
    }

    public String getBookModVersion() {
        return this.bookModVersion;
    }

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public int getElementIndex() {
        return this.elementIndex;
    }

    public String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.productId);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(this.bookModVersion);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(this.chapterIndex);
        stringBuffer.append("[");
        stringBuffer.append(this.elementIndex);
        stringBuffer.append("]");
        return stringBuffer.toString().hashCode();
    }

    public void setBookModVersion(String str) {
        this.bookModVersion = str;
    }

    public void setChapterIndex(int i) {
        this.chapterIndex = i;
    }

    public void setElementIndex(int i) {
        this.elementIndex = i;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public MarkKey(String str, String str2, int i, int i2) {
        this.productId = str;
        this.bookModVersion = str2;
        this.chapterIndex = i;
        this.elementIndex = i2;
    }
}
