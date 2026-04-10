package com.bytedance.sdk.component.p.e.e.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.p.e.zk;
import com.yuewen.w51;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class bf {
    private Context bf;
    private C0104bf e;

    public class e extends AbstractCursor {
        private e() {
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

    public bf(Context context) {
        try {
            this.bf = context.getApplicationContext();
            if (this.e == null) {
                this.e = new C0104bf();
            }
        } catch (Throwable unused) {
        }
    }

    private Context getContext() {
        return this.bf;
    }

    public C0104bf e() {
        return this.e;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.p.e.e.e.bf$bf, reason: collision with other inner class name */
    public class C0104bf {
        private volatile SQLiteDatabase bf = null;

        public C0104bf() {
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private synchronized boolean bf() {
            /*
                r1 = this;
                monitor-enter(r1)
                android.database.sqlite.SQLiteDatabase r0 = r1.bf     // Catch: java.lang.Throwable -> L10
                if (r0 == 0) goto Ld
                boolean r0 = r0.inTransaction()     // Catch: java.lang.Throwable -> L10
                if (r0 == 0) goto Ld
                r0 = 1
                goto Le
            Ld:
                r0 = 0
            Le:
                monitor-exit(r1)
                return r0
            L10:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.p.e.e.e.bf.C0104bf.bf():boolean");
        }

        private void e() {
            boolean zBf;
            try {
                if (this.bf == null || !this.bf.isOpen()) {
                    synchronized (this) {
                        if (this.bf == null || !this.bf.isOpen()) {
                            this.bf = zk.ga().d().e(zk.ga().getContext());
                            this.bf.setLockingEnabled(false);
                            com.bytedance.sdk.component.p.e.d.d.e("---------------DB CREATE  SUCCESS------------");
                        }
                    }
                }
            } finally {
                if (!zBf) {
                }
            }
        }

        public synchronized int delete(String str, String str2, String[] strArr) {
            int iDelete;
            try {
                e();
                iDelete = this.bf.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (bf()) {
                    throw e;
                }
                iDelete = 0;
            }
            return iDelete;
        }

        public synchronized long insert(String str, String str2, ContentValues contentValues) {
            long jInsert;
            try {
                e();
                jInsert = this.bf.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (bf()) {
                    throw e;
                }
                jInsert = -1;
            }
            return jInsert;
        }

        public synchronized Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery;
            try {
                e();
                cursorQuery = this.bf.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                e eVar = new e();
                if (bf()) {
                    throw th;
                }
                cursorQuery = eVar;
            }
            return cursorQuery;
        }

        public synchronized int update(String str, ContentValues contentValues, String str2, String[] strArr) {
            int iUpdate;
            try {
                e();
                iUpdate = this.bf.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (bf()) {
                    throw e;
                }
                iUpdate = 0;
            }
            return iUpdate;
        }

        public synchronized void insert(String str, String str2, List<com.bytedance.sdk.component.p.e.tg.e> list) {
            SQLiteDatabase sQLiteDatabase;
            JSONObject jSONObjectP;
            try {
                try {
                    e();
                    this.bf.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i = 0; i < list.size(); i++) {
                        com.bytedance.sdk.component.p.e.tg.e eVar = list.get(i);
                        if (eVar != null && (jSONObjectP = eVar.p()) != null) {
                            contentValues.put("id", eVar.d());
                            String strBf = zk.ga().bh().bf(jSONObjectP.toString());
                            if (!TextUtils.isEmpty(strBf)) {
                                contentValues.put("value", strBf);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                this.bf.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.bf.setTransactionSuccessful();
                    com.bytedance.sdk.component.p.e.d.d.bf("DBHelper", str + " insert list size=" + list.size());
                } catch (Exception e) {
                    e.printStackTrace();
                    if (!bf()) {
                        if (this.bf != null) {
                            sQLiteDatabase = this.bf;
                        }
                    } else {
                        throw e;
                    }
                }
                if (this.bf != null) {
                    sQLiteDatabase = this.bf;
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th) {
                if (this.bf != null) {
                    this.bf.endTransaction();
                }
                throw th;
            }
        }

        public synchronized void e(String str) throws SQLException {
            try {
                e();
                this.bf.execSQL(str);
            } catch (Throwable th) {
                if (bf()) {
                    throw th;
                }
            }
        }
    }
}
