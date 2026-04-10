package com.bytedance.e.e.bf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class bf extends SQLiteOpenHelper {
    public bf(@Nullable Context context) {
        super(context, "npth_log.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        new com.bytedance.e.e.bf.bf.bf().e(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
