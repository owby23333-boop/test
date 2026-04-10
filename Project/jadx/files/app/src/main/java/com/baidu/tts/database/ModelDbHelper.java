package com.baidu.tts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class ModelDbHelper extends SQLiteOpenHelper {
    public ModelDbHelper(Context context) {
        this(context, "ttsModel.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SpeechModelTable.sqlCreateTable());
        sQLiteDatabase.execSQL(ModelFileTable.sqlCreateTable());
        sQLiteDatabase.execSQL(FsFileInfoTable.sqlCreateTable());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL(SpeechModelTable.sqlDropTable());
        sQLiteDatabase.execSQL(ModelFileTable.sqlDropTable());
        sQLiteDatabase.execSQL(FsFileInfoTable.sqlDropTable());
        onCreate(sQLiteDatabase);
    }

    public ModelDbHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }
}
