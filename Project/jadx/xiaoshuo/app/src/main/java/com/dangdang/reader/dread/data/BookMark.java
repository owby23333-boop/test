package com.dangdang.reader.dread.data;

import com.dangdang.reader.dread.data.IFootprintData;

/* JADX INFO: loaded from: classes10.dex */
public class BookMark implements IFootprintData, Cloneable {
    public static final String CreateSql = "CREATE TABLE IF NOT EXISTS newmarks('_id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , pid VARCHAR, isbought INT DEFAULT 0,bookpath VARCHAR, chapterindex INT DEFAULT 0, elementindex INT DEFAULT 0, chaptername VARCHAR, marktime INT DEFAULT 0,marktext VARCHAR, expcolumn1 VARCHAR, expcolumn2 VARCHAR, expcolumn3 VARCHAR, expcolumn4 VARCHAR, expcolumn5 VARCHAR, expcolumn6 VARCHAR, modversion VARCHAR);";
    public String bookModVersion;
    public String bookPath = "";
    public int chapterIndex;
    public String chapterName;
    public String cloudStatus;
    public int elementIndex;
    public int id;
    public int isBought;
    public boolean isChapterHead;
    public String markText;
    public long markTime;
    public String modifyTime;
    public String pId;
    public String status;

    public class Column {
        public static final String BookPath = "bookpath";
        public static final String ChapterIndex = "chapterindex";
        public static final String ChapterName = "chaptername";
        public static final String ElementIndex = "elementindex";
        public static final String ExpColumn1 = "expcolumn1";
        public static final String ExpColumn2 = "expcolumn2";
        public static final String ExpColumn3 = "expcolumn3";
        public static final String ExpColumn4 = "expcolumn4";
        public static final String ExpColumn5 = "expcolumn5";
        public static final String ExpColumn6 = "expcolumn6";
        public static final String Id = "_id";
        public static final String IsBought = "isbought";
        public static final String MarkText = "marktext";
        public static final String MarkTime = "marktime";
        public static final String ModVersion = "modversion";
        public static final String Pid = "pid";
        public static final String TableName = "newmarks";

        public Column() {
        }
    }

    public Object clone() {
        return super.clone();
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public long getAddTime() {
        return this.markTime;
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
        return this.markText;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public IFootprintData.CONTENT_TYPE getContentType() {
        return IFootprintData.CONTENT_TYPE.BOOKMARK;
    }

    @Override // com.dangdang.reader.dread.data.IFootprintData
    public int getElementIndex() {
        return this.elementIndex;
    }

    public int getId() {
        return this.id;
    }

    public int getIsBought() {
        return this.isBought;
    }

    public String getMarkText() {
        return this.markText;
    }

    public long getMarkTime() {
        return this.markTime;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public String getStatus() {
        return this.status;
    }

    public String getpId() {
        return this.pId;
    }

    public boolean isChapterHead() {
        return this.isChapterHead;
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

    public void setElementIndex(int i) {
        this.elementIndex = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsBought(int i) {
        this.isBought = i;
    }

    public void setMarkText(String str) {
        this.markText = str;
    }

    public void setMarkTime(long j) {
        this.markTime = j;
    }

    public void setModifyTime(String str) {
        this.modifyTime = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setpId(String str) {
        this.pId = str;
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
