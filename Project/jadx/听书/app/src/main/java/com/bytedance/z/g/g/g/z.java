package com.bytedance.z.g.g.g;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.z.g.gz.uy;
import com.umeng.analytics.pro.ar;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z<T> {
    protected final String g;
    protected final String z = ar.d;

    protected abstract ContentValues z(T t);

    protected abstract HashMap<String, String> z();

    protected z(String str) {
        this.g = str;
    }

    public void z(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.g).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapZ = z();
            if (mapZ != null) {
                for (String str : mapZ.keySet()) {
                    sb.append(str).append(" ").append(mapZ.get(str)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.g, null, z(t));
        } catch (Exception e) {
            uy.g(e);
        }
    }
}
