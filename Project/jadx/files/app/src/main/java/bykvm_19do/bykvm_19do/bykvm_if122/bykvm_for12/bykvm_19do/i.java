package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f1673c = new Object();
    private c a;
    private Context b;

    private class b extends AbstractCursor {
        private b(i iVar) {
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
        public double getDouble(int i2) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i2) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i2) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i2) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i2) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i2) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i2) {
            return true;
        }
    }

    public class c {
        private SQLiteDatabase a = null;

        public c() {
        }

        private void b() {
            try {
                synchronized (i.f1673c) {
                    if (this.a == null || !this.a.isOpen()) {
                        this.a = new j(i.this.c(), "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.a.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                c();
            }
        }

        private boolean c() {
            SQLiteDatabase sQLiteDatabase = this.a;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }

        public int a(String str, String str2, String[] strArr) throws Exception {
            try {
                b();
                return this.a.delete(str, str2, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (c()) {
                    throw e2;
                }
                return 0;
            }
        }

        public long a(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                b();
                return this.a.insert(str, str2, contentValues);
            } catch (Exception e2) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.a("insert:" + str, e2.toString());
                e2.printStackTrace();
                if (c()) {
                    throw e2;
                }
                return -1L;
            }
        }

        public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            try {
                b();
                return this.a.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            } catch (Throwable th) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.b.a("query2:" + str, th.toString());
                th.printStackTrace();
                b bVar = new b();
                if (c()) {
                    throw th;
                }
                return bVar;
            }
        }

        public SQLiteDatabase a() {
            b();
            return this.a;
        }

        public void a(String str) throws SQLException {
            boolean zC;
            try {
                b();
                this.a.execSQL(str);
            } finally {
                if (!zC) {
                }
            }
        }
    }

    i(Context context) {
        try {
            this.b = context == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() : context.getApplicationContext();
            if (this.a == null) {
                this.a = new c();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c() {
        Context context = this.b;
        return context == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() : context;
    }

    public c a() {
        return this.a;
    }
}
