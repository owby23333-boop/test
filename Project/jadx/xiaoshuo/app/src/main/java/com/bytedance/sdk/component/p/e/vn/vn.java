package com.bytedance.sdk.component.p.e.vn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vn implements ga {
    private Context e;

    public vn(Context context) {
        this.e = context;
    }

    public static String bf() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, retry INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.p.e.vn.ga
    public synchronized void delete(tg tgVar) {
        com.bytedance.sdk.component.p.e.e.e.d.delete(this.e, "trackurl", "id=?", new String[]{tgVar.e()});
    }

    @Override // com.bytedance.sdk.component.p.e.vn.ga
    public synchronized List<tg> e() {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor cursorQuery = com.bytedance.sdk.component.p.e.e.e.d.query(this.e, "trackurl", null, null, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    try {
                        linkedList.add(new tg(cursorQuery.getString(cursorQuery.getColumnIndex("id")), cursorQuery.getString(cursorQuery.getColumnIndex("url")), cursorQuery.getInt(cursorQuery.getColumnIndex("replaceholder")) > 0, cursorQuery.getInt(cursorQuery.getColumnIndex("retry"))));
                    } finally {
                        cursorQuery.close();
                    }
                } catch (Throwable unused) {
                    cursorQuery.close();
                }
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.p.e.vn.ga
    public synchronized void insert(tg tgVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", tgVar.e());
        contentValues.put("url", tgVar.bf());
        contentValues.put("replaceholder", Integer.valueOf(tgVar.d() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(tgVar.tg()));
        com.bytedance.sdk.component.p.e.e.e.d.insert(this.e, "trackurl", contentValues);
    }

    @Override // com.bytedance.sdk.component.p.e.vn.ga
    public synchronized void update(tg tgVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", tgVar.e());
        contentValues.put("url", tgVar.bf());
        contentValues.put("replaceholder", Integer.valueOf(tgVar.d() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(tgVar.tg()));
        com.bytedance.sdk.component.p.e.e.e.d.update(this.e, "trackurl", contentValues, "id=?", new String[]{tgVar.e()});
    }
}
