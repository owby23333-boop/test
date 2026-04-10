package com.dangdang.reader.cloud;

/* JADX INFO: loaded from: classes10.dex */
public class Status {
    public static final int CLOUD_NO = -1;
    public static final int CLOUD_YES = 1;
    public static final int COLUMN_DELETE = 3;
    public static final int COLUMN_NEW = 1;
    public static final int COLUMN_UPDATE = 2;

    public static boolean isCloudSync(int i) {
        return i == 1;
    }

    public static boolean isDelete(int i) {
        return i == 3;
    }

    public static boolean isNew(int i) {
        return i == 1;
    }

    public static boolean isUpdate(int i) {
        return i == 2;
    }
}
