package com.bytedance.sdk.component.gz.g.z.z.z;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.gz.g.z.z.g.a;
import com.bytedance.sdk.component.gz.g.z.z.g.e;
import com.bytedance.sdk.component.gz.z.m;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class z extends SQLiteOpenHelper {
    private m g;
    final Context z;

    public z(Context context, m mVar) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.z(context), "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.z = context;
        this.g = mVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            z(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void z(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.m.a(this.g.g()));
        sQLiteDatabase.execSQL(a.g(this.g.z()));
        sQLiteDatabase.execSQL(e.a(this.g.a()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.z.g(this.g.gc()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.m.m.g());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i > i2) {
                g(sQLiteDatabase);
                z(sQLiteDatabase);
            } else {
                z(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListDl = dl(sQLiteDatabase);
        if (arrayListDl == null || arrayListDl.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListDl.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> dl(SQLiteDatabase sQLiteDatabase) {
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
}
