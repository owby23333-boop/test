package com.baidu.tts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class StatisticsDbHelper extends SQLiteOpenHelper {
    public StatisticsDbHelper(Context context) {
        this(context, "Statistics.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(StatisticsInfoTable.sqlCreateTable());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL(StatisticsInfoTable.sqlDropTable());
        onCreate(sQLiteDatabase);
    }

    public StatisticsDbHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }
}
