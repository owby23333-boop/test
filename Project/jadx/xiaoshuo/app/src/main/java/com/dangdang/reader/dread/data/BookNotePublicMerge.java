package com.dangdang.reader.dread.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BookNotePublicMerge implements Serializable {
    private int chapterIndex;
    private List<BookNotePublic> mPublicNoteList = new ArrayList();
    private int maxEndIndex;
    private int minStartIndex;
    private boolean onlyLine;
    private int paraEndIndex;
    private int paraStartIndex;
    private int publicLineCount;
    private int publicNoteCount;

    public void addNote(BookNotePublic bookNotePublic) {
        this.mPublicNoteList.add(bookNotePublic);
        if (bookNotePublic.getType() == 0) {
            this.publicLineCount++;
        } else {
            this.publicNoteCount++;
        }
    }

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public int getMaxEndIndex() {
        return this.maxEndIndex;
    }

    public int getMinStartIndex() {
        return this.minStartIndex;
    }

    public List<BookNotePublic> getNoteList() {
        return this.mPublicNoteList;
    }

    public int getParaEndIndex() {
        return this.paraEndIndex;
    }

    public int getParaStartIndex() {
        return this.paraStartIndex;
    }

    public int getPublicLineCount() {
        return this.publicLineCount;
    }

    public int getPublicNoteCount() {
        return this.publicNoteCount;
    }

    public boolean isOnlyLine() {
        return this.onlyLine;
    }

    public void setChapterIndex(int i) {
        this.chapterIndex = i;
    }

    public void setMaxEndIndex(int i) {
        this.maxEndIndex = i;
    }

    public void setMinStartIndex(int i) {
        this.minStartIndex = i;
    }

    public void setOnlyLine(boolean z) {
        this.onlyLine = z;
    }

    public void setParaEndIndex(int i) {
        this.paraEndIndex = i;
    }

    public void setParaStartIndex(int i) {
        this.paraStartIndex = i;
    }

    public void setPublicLineCount(int i) {
        this.publicLineCount = i;
    }

    public void setPublicNoteCount(int i) {
        this.publicNoteCount = i;
    }
}
