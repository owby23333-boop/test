package com.bytedance.sdk.component.p.e.e.e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.p.e.zk;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class tg extends SQLiteOpenHelper {
    final Context e;

    public tg(Context context) {
        super(context, "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.e = context;
    }

    private void bf(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListD = d(sQLiteDatabase);
        if (arrayListD == null || arrayListD.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListD.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> d(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        com.bytedance.sdk.component.p.e.d.d.e("DatabaseHelper", "initDB........");
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.e.bf(zk.ga().d().bf()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.tg.d(zk.ga().d().e()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.p.d(zk.ga().d().tg()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.vn.e(zk.ga().d().ga()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.vn.vn.bf());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            e(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            com.bytedance.sdk.component.p.e.d.d.e("DatabaseHelper", "onUpgrade....Database version upgrade.....old:" + i + ",new:" + i2);
            if (i > i2) {
                bf(sQLiteDatabase);
                e(sQLiteDatabase);
                com.bytedance.sdk.component.p.e.d.d.e("DatabaseHelper", "onUpgrade...Reverse installation Database reset - create table.....");
            } else {
                e(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }
}
