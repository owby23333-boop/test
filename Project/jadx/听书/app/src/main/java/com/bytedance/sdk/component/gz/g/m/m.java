package com.bytedance.sdk.component.gz.g.m;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements gc {
    private Context g;
    private com.bytedance.sdk.component.gz.z.gc z;

    public static String a() {
        return "ALTER TABLE trackurl ADD COLUMN encrypt INTEGER default 0";
    }

    public static String dl() {
        return "ALTER TABLE trackurl ADD COLUMN extra TEXT";
    }

    public static String g() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0,retry INTEGER default 0,extra TEXT ,encrypt INTEGER default 0)";
    }

    public m(com.bytedance.sdk.component.gz.z.gc gcVar) {
        this.g = gcVar.getContext();
        this.z = gcVar;
    }

    @Override // com.bytedance.sdk.component.gz.g.m.gc
    public List<a> z() {
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        Cursor cursorQuery = com.bytedance.sdk.component.gz.g.z.z.g.query(this.g, "trackurl", null, null, null, null, null, null, this.z);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                    boolean z = cursorQuery.getInt(cursorQuery.getColumnIndex("replaceholder")) > 0;
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                    if (i2 > 0) {
                        string3 = com.bytedance.sdk.component.utils.z.dl(string3);
                    }
                    try {
                        jSONObject = new JSONObject(string3);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    linkedList.add(new a(string, string2, z, i, jSONObject, i2));
                } catch (Throwable unused2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                            cursorQuery = null;
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                    if (cursorQuery != null) {
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.gz.g.m.gc
    public void insert(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.g());
        contentValues.put("url", aVar.dl());
        contentValues.put("replaceholder", Integer.valueOf(aVar.a() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(aVar.gc()));
        contentValues.put("extra", com.bytedance.sdk.component.utils.z.g(aVar.z().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.gz.g.z.z.g.insert(this.g, "trackurl", contentValues, this.z);
    }

    @Override // com.bytedance.sdk.component.gz.g.m.gc
    public void update(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.g());
        contentValues.put("url", aVar.dl());
        contentValues.put("replaceholder", Integer.valueOf(aVar.a() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(aVar.gc()));
        contentValues.put("extra", com.bytedance.sdk.component.utils.z.g(aVar.z().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.gz.g.z.z.g.update(this.g, "trackurl", contentValues, "id=?", new String[]{aVar.g()}, this.z);
    }

    @Override // com.bytedance.sdk.component.gz.g.m.gc
    public void delete(a aVar) {
        com.bytedance.sdk.component.gz.g.z.z.g.delete(this.g, "trackurl", "id=?", new String[]{aVar.g()}, this.z);
    }
}
