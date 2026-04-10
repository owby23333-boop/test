package com.dangdang.reader.dread.data;

/* JADX INFO: loaded from: classes10.dex */
public interface IFootprintData extends Comparable<IFootprintData> {

    public enum CONTENT_TYPE {
        UNDEFINED,
        NOTE,
        BOOKMARK,
        UNDERLINE,
        READEND
    }

    long getAddTime();

    int getChapterIndex();

    String getChapterName();

    String getContent();

    CONTENT_TYPE getContentType();

    int getElementIndex();
}
