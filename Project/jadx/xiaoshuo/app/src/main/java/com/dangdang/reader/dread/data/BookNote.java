package com.dangdang.reader.dread.data;

import com.dangdang.reader.dread.data.IFootprintData;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class BookNote implements IFootprintData, Cloneable, Serializable {
    public static final String CreateNoteSql = "CREATE TABLE IF NOT EXISTS notetable(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, bookid VARCHAR, bookpath VARCHAR, chaptername VARCHAR, chapterindex INT DEFAULT 0,sourcetext VARCHAR, startindex INT DEFAULT 0, endindex INT DEFAULT 0, notetext VARCHAR, notetime LONG DEFAULT 0,isbought INT DEFAULT 0,expcolumn1 VARCHAR, expcolumn2 VARCHAR, expcolumn3 VARCHAR, expcolumn4 VARCHAR, expcolumn5 VARCHAR, expcolumn6 VARCHAR, modversion VARCHAR);";
    public static int PUBLIC_DEFAULT_STATE = 1;
    public static int PUBLIC_STATE_FALSE = 2;
    public static int PUBLIC_STATE_TRUE = 1;
    public String bookId;
    public String bookModVersion;
    public String bookPath;
    public int chapterIndex;
    public String chapterName;
    public String cloudStatus;
    public int id;
    public int isBought;
    public boolean isChapterHead;
    public String modifyTime;
    public int noteEnd;
    public int noteStart;
    public String noteText;
    public long noteTime;
    public String sourceText;
    public String status;
    public int drawLineColor = 0;
    public int isPublic = PUBLIC_DEFAULT_STATE;
    public int paraIndex = -1;

    public class NoteColumn {
        public static final String BookId = "bookid";
        public static final String BookPath = "bookpath";
        public static final String ChapterIndex = "chapterindex";
        public static final String ChapterName = "chaptername";
        public static final String ExpColumn1 = "expcolumn1";
        public static final String ExpColumn2 = "expcolumn2";
        public static final String ExpColumn3 = "expcolumn3";
        public static final String ExpColumn4 = "expcolumn4";
        public static final String ExpColumn5 = "expcolumn5";
        public static final String ExpColumn6 = "expcolumn6";
        public static final String Id = "_id";
        public static final String IsBought = "isbought";
        public static final String ModVersion = "modversion";
        public static final String NoteEnd = "endindex";
        public static final String NoteStart = "startindex";
        public static final String NoteText = "notetext";
        public static final String NoteTime = "notetime";
        public static final String SourceText = "sourcetext";
        public static final String TableName = "notetable";

        public NoteColumn() {
        }
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BookNote bookNote = (BookNote) obj;
        return this.id == bookNote.id && this.chapterIndex == bookNote.chapterIndex && this.noteStart == bookNote.noteStart && this.noteEnd == bookNote.noteEnd;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public long getAddTime() {
        return this.noteTime;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getBookModVersion() {
        return this.bookModVersion;
    }

    public String getBookPath() {
        return this.bookPath;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public int getChapterIndex() {
        return this.chapterIndex;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public String getChapterName() {
        return this.chapterName;
    }

    public String getCloudStatus() {
        return this.cloudStatus;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public String getContent() {
        String str = this.noteText;
        return (str == null || str.length() == 0) ? this.sourceText : this.noteText;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public IFootprintData.CONTENT_TYPE getContentType() {
        String str = this.noteText;
        return (str == null || str.length() == 0) ? IFootprintData.CONTENT_TYPE.UNDERLINE : IFootprintData.CONTENT_TYPE.NOTE;
    }

    public int getDrawLineColor() {
        return this.drawLineColor;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public int getElementIndex() {
        return this.noteStart;
    }

    public int getId() {
        return this.id;
    }

    public int getIsBought() {
        return this.isBought;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public int getNoteEnd() {
        return this.noteEnd;
    }

    public int getNoteStart() {
        return this.noteStart;
    }

    public String getNoteText() {
        return this.noteText;
    }

    public long getNoteTime() {
        return this.noteTime;
    }

    public String getSourceText() {
        return this.sourceText;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (this.id * 3) + (this.chapterIndex * 5) + (this.noteStart * 7) + (this.noteEnd * 11);
    }

    public boolean isChapterHead() {
        return this.isChapterHead;
    }

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setBookModVersion(String str) {
        this.bookModVersion = str;
    }

    public void setBookPath(String str) {
        this.bookPath = str;
    }

    public void setChapterHead(boolean z) {
        this.isChapterHead = z;
    }

    public void setChapterIndex(int i) {
        this.chapterIndex = i;
    }

    public void setChapterName(String str) {
        this.chapterName = str;
    }

    public void setCloudStatus(String str) {
        this.cloudStatus = str;
    }

    public void setDrawLineColor(int i) {
        this.drawLineColor = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsBought(int i) {
        this.isBought = i;
    }

    public void setModifyTime(String str) {
        this.modifyTime = str;
    }

    public void setNoteEnd(int i) {
        this.noteEnd = i;
    }

    public void setNoteStart(int i) {
        this.noteStart = i;
    }

    public void setNoteText(String str) {
        this.noteText = str;
    }

    public void setNoteTime(long j) {
        this.noteTime = j;
    }

    public void setSourceText(String str) {
        this.sourceText = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(IFootprintData iFootprintData) {
        long addTime = iFootprintData.getAddTime() - getAddTime();
        if (addTime > 0) {
            return 1;
        }
        return addTime < 0 ? -1 : 0;
    }
}
