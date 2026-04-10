package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static final Object dl = new Object();
    private Context g;
    private dl z;

    gz(Context context) {
        try {
            this.g = context == null ? zw.getContext() : context.getApplicationContext();
            if (this.z == null) {
                this.z = new dl();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.g;
        return context == null ? zw.getContext() : context;
    }

    public class dl {
        private SQLiteDatabase g = null;

        public dl() {
        }

        public void z() {
            try {
                SQLiteDatabase sQLiteDatabase = this.g;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    return;
                }
                synchronized (gz.dl) {
                    SQLiteDatabase sQLiteDatabase2 = this.g;
                    if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
                        gz gzVar = gz.this;
                        this.g = gzVar.new z(gzVar.getContext()).getWritableDatabase();
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
                if (m()) {
                    throw th;
                }
            }
        }

        public SQLiteDatabase g() {
            return this.g;
        }

        public void z(String str) throws SQLException {
            try {
                z();
                this.g.execSQL(str);
            } catch (Throwable th) {
                if (m()) {
                    throw th;
                }
            }
        }

        public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                z();
                return this.g.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                g gVar = new g();
                if (m()) {
                    throw th;
                }
                return gVar;
            }
        }

        public int update(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                z();
                return this.g.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                if (m()) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                z();
                return this.g.insert(str, str2, contentValues);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                if (m()) {
                    throw e;
                }
                return -1L;
            }
        }

        public int delete(String str, String str2, String[] strArr) throws Exception {
            try {
                z();
                return this.g.delete(str, str2, strArr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                if (m()) {
                    throw e;
                }
                return 0;
            }
        }

        public void dl() {
            z();
            SQLiteDatabase sQLiteDatabase = this.g;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public void a() {
            z();
            SQLiteDatabase sQLiteDatabase = this.g;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public void gc() {
            z();
            SQLiteDatabase sQLiteDatabase = this.g;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        private boolean m() {
            SQLiteDatabase sQLiteDatabase = this.g;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    private class z extends SQLiteOpenHelper {
        final Context z;

        public z(Context context) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.z(context), "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 13);
            this.z = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                z(sQLiteDatabase, this.z);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.a("DBHelper", th.getMessage());
            }
        }

        private void z(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.openadsdk.core.q.g.dl.get();
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.m.a("adevent"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.a.g("loghighpriority"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.e.a("logstats"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.z.g("logstatsbatch"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.m.m.g());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.z.g.g.dl());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.g.dl());
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.nativeexpress.z.dl.dl());
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS meta_cache (id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT,uuid TEXT,create_time TEXT,meta_data TEXT,save_version TEXT,expire_time TEXT,slot_type TEXT,is_using INTEGER,priority TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sdk_launch (id INTEGER PRIMARY KEY AUTOINCREMENT,dev1 INTEGER,dev2 INTEGER,dev3 INTEGER,dev4 INTEGER,dev5 INTEGER,dev6 INTEGER,dev7 INTEGER,dev8 INTEGER)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                z(sQLiteDatabase);
                z(sQLiteDatabase, gz.this.g);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > i2) {
                try {
                    z(sQLiteDatabase);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.a("DBHelper", th.getMessage());
                    return;
                }
            }
            z(sQLiteDatabase, gz.this.g);
            switch (i) {
                case 1:
                    z(sQLiteDatabase, i, i2);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    z(sQLiteDatabase, i, i2);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.e.a("logstats"));
                    z(sQLiteDatabase, i, i2);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.z.g.g.dl());
                    z(sQLiteDatabase, i, i2);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.z.g("logstatsbatch"));
                    z(sQLiteDatabase, i, i2);
                    break;
                case 6:
                case 8:
                case 9:
                    z(sQLiteDatabase, i, i2);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.g.dl());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    z(sQLiteDatabase, i, i2);
                    break;
                case 10:
                case 11:
                    g(sQLiteDatabase, i, i2);
                    break;
            }
        }

        private void z(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.m.gc("adevent"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.a.dl("loghighpriority"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.e.gc("logstats"));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.z.z.g.z.dl("logstatsbatch"));
            g(sQLiteDatabase, i, i2);
        }

        private void g(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.m.m.dl());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.gz.g.m.m.a());
        }

        private void z(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListG = g(sQLiteDatabase);
            if (arrayListG == null || arrayListG.size() <= 0) {
                return;
            }
            Iterator<String> it = arrayListG.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }

        private ArrayList<String> g(SQLiteDatabase sQLiteDatabase) {
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

    public dl z() {
        return this.z;
    }

    private class g extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private g() {
        }
    }
}
