package com.arialyy.aria.orm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbsDelegate {
    static final String TAG = "AbsDelegate";

    AbsDelegate() {
    }

    SQLiteDatabase checkDb(SQLiteDatabase sQLiteDatabase) {
        return SqlUtil.checkDb(sQLiteDatabase);
    }

    void closeCursor(Cursor cursor) {
        SqlUtil.closeCursor(cursor);
    }
}
