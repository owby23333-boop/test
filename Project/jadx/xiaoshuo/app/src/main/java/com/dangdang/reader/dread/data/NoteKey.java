package com.dangdang.reader.dread.data;

import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes10.dex */
public class NoteKey {
    private String bookModVersion;
    private int chapterIndex;
    private int endElementIndex;
    private String productId;
    private int startElementIndex;

    public NoteKey() {
    }

    public static NoteKey convert(BookNote bookNote) {
        return new NoteKey(bookNote.getBookId(), bookNote.getBookModVersion(), bookNote.getChapterIndex(), bookNote.getNoteStart(), bookNote.getNoteEnd());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NoteKey)) {
            return false;
        }
        NoteKey noteKey = (NoteKey) obj;
        if (!noteKey.productId.equals(this.productId)) {
            return false;
        }
        String str = noteKey.bookModVersion;
        return (str == null || str.equals(this.bookModVersion)) && noteKey.chapterIndex == this.chapterIndex && noteKey.startElementIndex == this.startElementIndex && noteKey.endElementIndex == this.endElementIndex;
    }

    public String getBookModVersion() {
        return this.bookModVersion;
    }

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public int getEndElementIndex() {
        return this.endElementIndex;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getStartElementIndex() {
        return this.startElementIndex;
    }

    public int hashCode() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.productId);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(this.bookModVersion);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(this.chapterIndex);
        stringBuffer.append("[");
        stringBuffer.append(this.startElementIndex);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        stringBuffer.append(this.endElementIndex);
        stringBuffer.append("]");
        return stringBuffer.toString().hashCode();
    }

    public void setBookModVersion(String str) {
        this.bookModVersion = str;
    }

    public void setChapterIndex(int i) {
        this.chapterIndex = i;
    }

    public void setEndElementIndex(int i) {
        this.endElementIndex = i;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setStartElementIndex(int i) {
        this.startElementIndex = i;
    }

    public NoteKey(String str, String str2, int i, int i2, int i3) {
        this.productId = str;
        this.bookModVersion = str2;
        this.chapterIndex = i;
        this.startElementIndex = i2;
        this.endElementIndex = i3;
    }
}
