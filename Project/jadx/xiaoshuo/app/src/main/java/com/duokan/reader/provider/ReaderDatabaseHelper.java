package com.duokan.reader.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes3.dex */
public class ReaderDatabaseHelper extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5206a = "duokan_reader.db";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5207b = 3;

    public ReaderDatabaseHelper(Context context) {
        super(context, f5206a, (SQLiteDatabase.CursorFactory) null, f5207b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
