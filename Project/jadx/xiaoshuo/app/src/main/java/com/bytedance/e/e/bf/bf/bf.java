package com.bytedance.e.e.bf.bf;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.e.e.v.m;
import com.xiaomi.onetrack.api.g;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class bf extends e<com.bytedance.e.e.bf.e.e> {
    public bf() {
        super("duplicatelog");
    }

    public boolean e(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor cursorQuery = sQLiteDatabase.query(this.bf, null, "path=?", new String[]{str}, null, null, null);
            count = cursorQuery.getCount();
            try {
                cursorQuery.close();
            } catch (Exception e) {
                e = e;
                m.bf(e);
            }
        } catch (Exception e2) {
            e = e2;
            count = 0;
        }
        return count > 0;
    }

    @Override // com.bytedance.e.e.bf.bf.e
    public void insert(SQLiteDatabase sQLiteDatabase, com.bytedance.e.e.bf.e.e eVar) {
        if (eVar == null || e(sQLiteDatabase, eVar.e)) {
            return;
        }
        super.insert(sQLiteDatabase, eVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.bf + " where _id in (select _id from " + this.bf + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            m.bf(e);
        }
    }

    @Override // com.bytedance.e.e.bf.bf.e
    public HashMap<String, String> e() {
        HashMap<String, String> map = new HashMap<>();
        map.put(g.F, "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    @Override // com.bytedance.e.e.bf.bf.e
    public ContentValues e(com.bytedance.e.e.bf.e.e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(g.F, eVar.e);
        contentValues.put("insert_time", Long.valueOf(eVar.bf));
        return contentValues;
    }
}
