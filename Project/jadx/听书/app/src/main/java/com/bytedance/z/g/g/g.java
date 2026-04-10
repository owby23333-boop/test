package com.bytedance.z.g.g;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class g extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public g(Context context) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.z(context), "npth_log.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        new com.bytedance.z.g.g.g.g().z(sQLiteDatabase);
    }
}
