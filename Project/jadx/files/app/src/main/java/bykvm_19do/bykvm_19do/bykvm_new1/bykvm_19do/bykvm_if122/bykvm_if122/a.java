package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_if122.bykvm_if122;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import com.umeng.message.proguard.ad;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {
    protected final String a;

    protected a(String str) {
        this.a = str;
    }

    protected abstract ContentValues a(T t2);

    protected abstract HashMap<String, String> a();

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.a);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapA = a();
            if (mapA != null) {
                for (String str : mapA.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(mapA.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(ad.f20406s);
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t2) {
        if (sQLiteDatabase == null || t2 == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.a, null, a(t2));
        } catch (Exception e2) {
            j.b(e2);
        }
    }
}
