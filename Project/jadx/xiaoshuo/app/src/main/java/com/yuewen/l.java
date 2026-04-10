package com.yuewen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes8.dex */
public class l extends SQLiteOpenHelper {
    public l(Context context) {
        super(context, "ywreportdata", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE reports (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_id STRING NOT NULL, data STRING NOT NULL, created_at INTEGER NOT NULL);");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS time_idx ON reports (created_at);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS reports");
        sQLiteDatabase.execSQL("CREATE TABLE reports (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_id STRING NOT NULL, data STRING NOT NULL, created_at INTEGER NOT NULL);");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS time_idx ON reports (created_at);");
    }
}
