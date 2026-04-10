package com.dangdang.reader.dread.data;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class ReadTimes implements Serializable {
    public static final String CreateReadTimesSql = "CREATE TABLE IF NOT EXISTS readtimestable(column_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, column_productid VARCHAR, column_starttime VARCHAR, column_endtime VARCHAR, column_userid VARCHAR,column_exp1 VARCHAR, column_exp2 VARCHAR, column_exp3 VARCHAR, column_exp4 VARCHAR, column_exp5 VARCHAR);";
    public static String TYPE_BOOK = "book";
    public static String TYPE_LISTEN = "listen";
    private int authType;
    private int cId;
    private String chapterId;
    private long endTime;
    private String mediaType = TYPE_BOOK;
    private String productId;
    private int readType;
    private long startTime;

    public interface ReadTimesColumn {
        public static final String COLUMN_ENDTIME = "column_endtime";
        public static final String COLUMN_EXP1 = "column_exp1";
        public static final String COLUMN_EXP2 = "column_exp2";
        public static final String COLUMN_EXP3 = "column_exp3";
        public static final String COLUMN_EXP4 = "column_exp4";
        public static final String COLUMN_EXP5 = "column_exp5";
        public static final String COLUMN_ID = "column_id";
        public static final String COLUMN_PRODUCTID = "column_productid";
        public static final String COLUMN_STARTTIME = "column_starttime";
        public static final String COLUMN_USERID = "column_userid";
        public static final String TableName = "readtimestable";
    }

    public int getAuthType() {
        return this.authType;
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getReadType() {
        return this.readType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getcId() {
        return this.cId;
    }

    public void setAuthType(int i) {
        this.authType = i;
    }

    public void setChapterId(String str) {
        this.chapterId = str;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setMediaType(String str) {
        this.mediaType = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setReadType(int i) {
        this.readType = i;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setcId(int i) {
        this.cId = i;
    }
}
