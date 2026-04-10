package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import com.umeng.message.proguard.ad;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class b extends a<bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_19do.a> {
    public b() {
        super("duplicatelog");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122.a
    public ContentValues a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_19do.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.a);
        contentValues.put("insert_time", Long.valueOf(aVar.b));
        return contentValues;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122.a
    protected HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    public void a(SQLiteDatabase sQLiteDatabase, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_19do.a aVar) {
        if (aVar == null || a(sQLiteDatabase, aVar.a)) {
            return;
        }
        super.a(sQLiteDatabase, aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.a + " where _id in (select _id from " + this.a + " order by insert_time desc limit 1000 offset 500" + ad.f20406s);
        } catch (Exception e2) {
            j.b(e2);
        }
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor cursorQuery = sQLiteDatabase.query(this.a, null, "path=?", new String[]{str}, null, null, null);
            count = cursorQuery.getCount();
            try {
                cursorQuery.close();
            } catch (Exception e2) {
                e = e2;
                j.b(e);
            }
        } catch (Exception e3) {
            e = e3;
            count = 0;
        }
        return count > 0;
    }
}
