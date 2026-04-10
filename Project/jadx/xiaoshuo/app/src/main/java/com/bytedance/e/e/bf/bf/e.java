package com.bytedance.e.e.bf.bf;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.e.e.v.m;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class e<T> {
    protected final String bf;
    protected final String e = "_id";

    public e(String str) {
        this.bf = str;
    }

    public abstract ContentValues e(T t);

    public abstract HashMap<String, String> e();

    public void e(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.bf);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapE = e();
            if (mapE != null) {
                for (String str : mapE.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(mapE.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.bf, null, e(t));
        } catch (Exception e) {
            m.bf(e);
        }
    }
}
