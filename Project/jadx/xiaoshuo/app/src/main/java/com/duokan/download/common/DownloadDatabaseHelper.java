package com.duokan.download.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes15.dex */
public class DownloadDatabaseHelper extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3535a = "Downloads.db";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3536b = 1;
    public static final int c = 2;
    public static final int d = 2;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f3537a = "blocks";

        /* JADX INFO: renamed from: com.duokan.download.common.DownloadDatabaseHelper$a$a, reason: collision with other inner class name */
        public static class C0235a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final String f3538a = "block_id";

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final String f3539b = "block_class";
            public static final String c = "block_index";
            public static final String d = "block_offset";
            public static final String e = "block_length";
            public static final String f = "task_id";
            public static final String g = "runtime_info";
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f3540a = "tasks";

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final String f3541a = "task_id";

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final String f3542b = "task_class";
            public static final String c = "task_tag";
            public static final String d = "task_title";
            public static final String e = "source_uri";
            public static final String f = "target_uri";
            public static final String g = "runtime_info";
            public static final String h = "user_value";
            public static final String i = "md5";
        }
    }

    public DownloadDatabaseHelper(Context context) {
        super(context, f3535a, (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            try {
                sQLiteDatabase.execSQL(String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", b.f3540a, "task_id", b.a.f3542b, b.a.d, b.a.c, b.a.e, b.a.f, "runtime_info", b.a.h, "md5"));
                sQLiteDatabase.execSQL(String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER, %s INTEGER, %s INTEGER, %s TEXT, %s INTEGER)", "blocks", a.C0235a.f3538a, a.C0235a.f3539b, a.C0235a.c, a.C0235a.d, a.C0235a.e, "runtime_info", "task_id"));
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT", b.f3540a, "md5"));
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }
}
