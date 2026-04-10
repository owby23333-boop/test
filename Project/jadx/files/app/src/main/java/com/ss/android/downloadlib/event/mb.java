package com.ss.android.downloadlib.event;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.GMAdConstant;

/* JADX INFO: loaded from: classes3.dex */
public class mb extends SQLiteOpenHelper {
    static final String[] mb = {"_id", GMAdConstant.EXTRA_ADID, "req_id", "time"};

    public mb(@Nullable Context context) {
        super(context, "click_event", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS click_event(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_id INTEGER,req_id TEXT,time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS click_event");
        onCreate(sQLiteDatabase);
    }
}
