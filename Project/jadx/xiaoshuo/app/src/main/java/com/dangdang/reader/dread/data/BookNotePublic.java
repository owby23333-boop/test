package com.dangdang.reader.dread.data;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class BookNotePublic implements Serializable {
    public static int TYPE_LINE = 0;
    public static int TYPE_NOTE = 1;
    public int chapterIndex;
    public int endIndex;
    public String id;
    public int startIndex;
    public int type = TYPE_NOTE;

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public String getId() {
        return this.id;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getType() {
        return this.type;
    }

    public void setChapterIndex(int i) {
        this.chapterIndex = i;
    }

    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
