package com.dangdang.reader.domain;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class GroupType implements Serializable {
    private ExpInfo expInfo;
    private long mCreateTime;
    private int mId;
    private String mName;

    public static class ExpInfo {
        public String virtualSetId;
    }

    public class TypeColumn {
        public static final String CREATE_TIME = "create_time";
        public static final String ExpColumn1 = "expcolumn1";
        public static final String ExpColumn2 = "expcolumn2";
        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String SHELF_TYPE_TABLE = "shelfbook_group";
        public static final String UNDOWN_TYPE_TABLE = "undownbook_type";

        public TypeColumn() {
        }
    }

    public static String createBookTypeTable(String str) {
        return "create table IF NOT EXISTS " + str + " (_id integer primary key autoincrement, name varchar, " + TypeColumn.CREATE_TIME + " long default 0, expcolumn1 varchar, expcolumn2 varchar);";
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public ExpInfo getExpInfo() {
        return this.expInfo;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public void setCreateTime(long j) {
        this.mCreateTime = j;
    }

    public void setExpInfo(ExpInfo expInfo) {
        this.expInfo = expInfo;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setName(String str) {
        this.mName = str;
    }
}
