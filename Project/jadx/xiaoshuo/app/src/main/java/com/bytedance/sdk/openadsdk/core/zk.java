package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.yuewen.w51;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class zk {
    private static final Object d = new Object();
    private Context bf;
    private d e;

    public class bf extends AbstractCursor {
        private bf() {
        }

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
            return w51.l;
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
    }

    public zk(Context context) {
        try {
            this.bf = context == null ? lc.getContext() : context.getApplicationContext();
            if (this.e == null) {
                this.e = new d();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.bf;
        return context == null ? lc.getContext() : context;
    }

    public d e() {
        return this.e;
    }

    public class d {
        private SQLiteDatabase bf = null;

        public d() {
        }

        private boolean vn() {
            SQLiteDatabase sQLiteDatabase = this.bf;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public SQLiteDatabase bf() {
            return this.bf;
        }

        public void d() {
            e();
            SQLiteDatabase sQLiteDatabase = this.bf;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public int delete(String str, String str2, String[] strArr) throws Exception {
            try {
                e();
                return this.bf.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (vn()) {
                    throw e;
                }
                return 0;
            }
        }

        public void e() {
            boolean zVn;
            try {
                SQLiteDatabase sQLiteDatabase = this.bf;
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    synchronized (zk.d) {
                        SQLiteDatabase sQLiteDatabase2 = this.bf;
                        if (sQLiteDatabase2 == null || !sQLiteDatabase2.isOpen()) {
                            zk zkVar = zk.this;
                            this.bf = zkVar.new e(zkVar.getContext()).getWritableDatabase();
                        }
                    }
                }
            } finally {
                if (!zVn) {
                }
            }
        }

        public void ga() {
            e();
            SQLiteDatabase sQLiteDatabase = this.bf;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        public long insert(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                e();
                return this.bf.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (vn()) {
                    throw e;
                }
                return -1L;
            }
        }

        public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                e();
                return this.bf.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                bf bfVar = new bf();
                if (vn()) {
                    throw th;
                }
                return bfVar;
            }
        }

        public void tg() {
            e();
            SQLiteDatabase sQLiteDatabase = this.bf;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public int update(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                e();
                return this.bf.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (vn()) {
                    throw e;
                }
                return 0;
            }
        }

        public void e(String str) throws SQLException {
            boolean zVn;
            try {
                e();
                this.bf.execSQL(str);
            } finally {
                if (!zVn) {
                }
            }
        }
    }

    public class e extends SQLiteOpenHelper {
        final Context e;

        public e(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 10);
            this.e = context;
        }

        private ArrayList<String> bf(SQLiteDatabase sQLiteDatabase) {
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

        private void e(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.component.utils.wu.bf("DBHelper", "initDB:" + com.bytedance.sdk.openadsdk.core.k.bf.d.get());
            com.bytedance.sdk.openadsdk.core.k.ga gaVar = com.bytedance.sdk.openadsdk.core.k.ga.e;
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.e.bf(gaVar.bf()));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.tg.d(gaVar.e()));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.p.d(gaVar.tg()));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.vn.e(gaVar.ga()));
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.vn.vn.bf());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.e.bf.e.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.bf.d());
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
            com.bytedance.sdk.component.utils.wu.bf("DBHelper", "initDB  END");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                e(sQLiteDatabase, this.e);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wu.vn("DBHelper", th.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.bytedance.sdk.component.utils.wu.bf("DBHelper", "onDowngrade....数据库版本降级.....old:" + i + ",new:" + i2);
            if (i > i2) {
                e(sQLiteDatabase);
                e(sQLiteDatabase, zk.this.bf);
                com.bytedance.sdk.component.utils.wu.bf("DBHelper", "onDowngrade...逆向安装.数据库重置-创建表.....");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                com.bytedance.sdk.component.utils.wu.bf("DBHelper", "onUpgrade....数据库版本升级.....old:" + i + ",new:" + i2);
                if (i > i2) {
                    e(sQLiteDatabase);
                    e(sQLiteDatabase, zk.this.bf);
                    com.bytedance.sdk.component.utils.wu.bf("DBHelper", "onUpgrade...逆向安装.数据库重置-创建表.....");
                } else {
                    e(sQLiteDatabase, zk.this.bf);
                }
                switch (i) {
                    case 1:
                        e(sQLiteDatabase, i, i2);
                        com.bytedance.sdk.component.utils.wu.bf("DBHelper", "onUpgrade.....执行表创建.....");
                        break;
                    case 2:
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                        e(sQLiteDatabase, i, i2);
                        break;
                    case 3:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.p.d(com.bytedance.sdk.openadsdk.core.k.ga.e.tg()));
                        e(sQLiteDatabase, i, i2);
                        break;
                    case 4:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.e.bf.e.d());
                        e(sQLiteDatabase, i, i2);
                        break;
                    case 5:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.vn.e(com.bytedance.sdk.openadsdk.core.k.ga.e.ga()));
                        e(sQLiteDatabase, i, i2);
                        break;
                    case 6:
                    case 8:
                    case 9:
                        e(sQLiteDatabase, i, i2);
                        break;
                    case 7:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.tools.bf.d());
                        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                        e(sQLiteDatabase, i, i2);
                        break;
                }
                com.bytedance.sdk.component.utils.wu.bf("DBHelper", "over");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wu.vn("DBHelper", th.getMessage());
            }
        }

        private void e(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.e.ga());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.tg.vn());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.p.vn());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.p.e.e.e.e.vn.tg());
        }

        private void e(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListBf = bf(sQLiteDatabase);
            if (arrayListBf == null || arrayListBf.size() <= 0) {
                return;
            }
            Iterator<String> it = arrayListBf.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }
}
