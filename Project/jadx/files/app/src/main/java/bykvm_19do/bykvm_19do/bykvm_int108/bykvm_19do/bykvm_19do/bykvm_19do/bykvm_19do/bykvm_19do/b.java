package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes.dex */
class b {
    private static final Object b = new Object();
    private c a;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$b, reason: collision with other inner class name */
    private class C0058b extends AbstractCursor {
        private C0058b(b bVar) {
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
        private volatile SQLiteDatabase a = null;

        public c() {
        }

        private void a() {
            synchronized (this) {
                try {
                    synchronized (b.b) {
                        if (this.a == null || !this.a.isOpen()) {
                            this.a = j.l().e().a(j.l().d());
                            this.a.setLockingEnabled(false);
                            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("---------------DB CREATE  SUCCESS------------");
                        }
                    }
                } finally {
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean b() {
            /*
                r1 = this;
                monitor-enter(r1)
                android.database.sqlite.SQLiteDatabase r0 = r1.a     // Catch: java.lang.Throwable -> L10
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
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.c.b():boolean");
        }

        public long a(String str, String str2, ContentValues contentValues) {
            long jInsert;
            synchronized (this) {
                try {
                    a();
                    jInsert = this.a.insert(str, str2, contentValues);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (b()) {
                        throw e2;
                    }
                    jInsert = -1;
                }
            }
            return jInsert;
        }

        public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery;
            synchronized (this) {
                try {
                    a();
                    cursorQuery = this.a.query(str, strArr, str2, strArr2, str3, str4, str5);
                } catch (Throwable th) {
                    th.printStackTrace();
                    C0058b c0058b = new C0058b();
                    if (b()) {
                        throw th;
                    }
                    cursorQuery = c0058b;
                }
            }
            return cursorQuery;
        }

        public void a(String str) throws SQLException {
            synchronized (this) {
                try {
                    a();
                    this.a.execSQL(str);
                } catch (Throwable th) {
                    if (b()) {
                        throw th;
                    }
                }
            }
        }
    }

    b(Context context) {
        try {
            context.getApplicationContext();
            if (this.a == null) {
                this.a = new c();
            }
        } catch (Throwable unused) {
        }
    }

    public c a() {
        return this.a;
    }
}
