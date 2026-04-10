package com.ss.android.downloadlib.tg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.yuewen.et;
import com.yuewen.qe0;

/* JADX INFO: loaded from: classes4.dex */
public class bf extends SQLiteOpenHelper {
    static final String[] e = {"_id", qe0.b.g, "req_id", et.j};

    public bf(@Nullable Context context) {
        super(context, "click_event", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS click_event(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_id INTEGER,req_id TEXT,time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS click_event");
        onCreate(sQLiteDatabase);
    }
}
