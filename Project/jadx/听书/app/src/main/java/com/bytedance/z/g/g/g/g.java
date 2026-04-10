package com.bytedance.z.g.g.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.z.g.gz.uy;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z<com.bytedance.z.g.g.z.z> {
    public g() {
        super("duplicatelog");
    }

    public boolean z(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            try {
                Cursor cursorQuery = sQLiteDatabase.query(this.g, null, "path=?", new String[]{str}, null, null, null);
                count = cursorQuery.getCount();
                try {
                    cursorQuery.close();
                } catch (Exception e) {
                    e = e;
                    uy.g(e);
                }
            } catch (Exception e2) {
                e = e2;
                count = 0;
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.z.g.g.g.z
    public void insert(SQLiteDatabase sQLiteDatabase, com.bytedance.z.g.g.z.z zVar) {
        if (zVar == null || z(sQLiteDatabase, zVar.z)) {
            return;
        }
        super.insert(sQLiteDatabase, zVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.g + " where _id in (select _id from " + this.g + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            uy.g(e);
        }
    }

    @Override // com.bytedance.z.g.g.g.z
    protected HashMap<String, String> z() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.z.g.g.g.z
    public ContentValues z(com.bytedance.z.g.g.z.z zVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", zVar.z);
        contentValues.put("insert_time", Long.valueOf(zVar.g));
        return contentValues;
    }
}
