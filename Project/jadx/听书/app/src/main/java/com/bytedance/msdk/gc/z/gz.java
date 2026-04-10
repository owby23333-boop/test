package com.bytedance.msdk.gc.z;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends SQLiteOpenHelper {
    private static String a() {
        return "ALTER TABLE adevent_applog ADD COLUMN encrypt INTEGER default 0";
    }

    private static String dl() {
        return "ALTER TABLE adevent ADD COLUMN encrypt INTEGER default 0";
    }

    private static String g() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    private static String z() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0, encrypt INTEGER default 0)";
    }

    public gz(Context context, String str, int i) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.z(context), str, (SQLiteDatabase.CursorFactory) null, i);
        com.bytedance.msdk.z.gc.dl.z("DBHelper", "DatabaseHelper ........");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            z(sQLiteDatabase);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void z(SQLiteDatabase sQLiteDatabase) {
        com.bytedance.msdk.z.gc.dl.z("DBHelper", "initDB........");
        try {
            sQLiteDatabase.execSQL(z());
        } catch (Throwable th) {
            wp.z(th);
        }
        try {
            sQLiteDatabase.execSQL(g());
        } catch (Throwable th2) {
            wp.z(th2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            com.bytedance.msdk.z.gc.dl.z("DBHelper", "onUpgrade....数据库版本升级.....");
            if (i == 1 || i == 2) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_freqctl';");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'show_pacing';");
            } else if (i != 3) {
                return;
            }
            sQLiteDatabase.execSQL(g());
            z(sQLiteDatabase, i, i2);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void z(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL(dl());
        } catch (Throwable th) {
            wp.z(th);
        }
        try {
            sQLiteDatabase.execSQL(a());
        } catch (Throwable th2) {
            wp.z(th2);
        }
    }
}
