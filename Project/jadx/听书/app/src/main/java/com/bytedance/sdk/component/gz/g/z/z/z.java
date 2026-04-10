package com.bytedance.sdk.component.gz.g.z.z;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.gz.z.gc;
import com.bytedance.sdk.component.utils.wp;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class z {
    private static volatile z dl;
    private Context g;
    private g z;

    public static z z(Context context) {
        if (dl == null) {
            synchronized (z.class) {
                if (dl == null) {
                    dl = new z(context);
                }
            }
        }
        return dl;
    }

    private z(Context context) {
        try {
            this.g = context.getApplicationContext();
            if (this.z == null) {
                this.z = new g();
            }
        } catch (Throwable unused) {
        }
    }

    private Context getContext() {
        return this.g;
    }

    public class g {
        public g() {
        }

        private SQLiteDatabase z(gc gcVar) {
            boolean zG;
            try {
                SQLiteDatabase sQLiteDatabaseZ = gcVar.g().z(gcVar.getContext());
                if (sQLiteDatabaseZ == null || !sQLiteDatabaseZ.isOpen()) {
                    return null;
                }
                sQLiteDatabaseZ.setLockingEnabled(false);
                return sQLiteDatabaseZ;
            } finally {
                if (!zG) {
                }
            }
        }

        public void z(gc gcVar, String str) throws SQLException {
            try {
                SQLiteDatabase sQLiteDatabaseZ = z(gcVar);
                if (sQLiteDatabaseZ != null) {
                    sQLiteDatabaseZ.execSQL(str);
                }
            } catch (Throwable th) {
                if (g(gcVar)) {
                    throw th;
                }
            }
        }

        public Cursor query(gc gcVar, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            byte b = 0;
            try {
                SQLiteDatabase sQLiteDatabaseZ = z(gcVar);
                return sQLiteDatabaseZ != null ? sQLiteDatabaseZ.query(str, strArr, str2, strArr2, str3, str4, str5) : null;
            } catch (Throwable th) {
                wp.z(th);
                C0135z c0135z = new C0135z();
                if (g(gcVar)) {
                    throw th;
                }
                return c0135z;
            }
        }

        public int update(gc gcVar, String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseZ = z(gcVar);
                if (sQLiteDatabaseZ != null) {
                    return sQLiteDatabaseZ.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                wp.z(e);
                if (g(gcVar)) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(gc gcVar, String str, String str2, ContentValues contentValues) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseZ = z(gcVar);
                if (sQLiteDatabaseZ != null) {
                    return sQLiteDatabaseZ.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e) {
                wp.z(e);
                if (g(gcVar)) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void insert(gc gcVar, String str, String str2, List<com.bytedance.sdk.component.gz.z.g> list) {
            JSONObject jSONObjectE;
            SQLiteDatabase sQLiteDatabaseZ = null;
            try {
                try {
                    sQLiteDatabaseZ = z(gcVar);
                    if (sQLiteDatabaseZ != null) {
                        sQLiteDatabaseZ.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < list.size(); i++) {
                            com.bytedance.sdk.component.gz.z.g gVar = list.get(i);
                            if (gVar != null && (jSONObjectE = gVar.e()) != null) {
                                contentValues.put("id", gVar.dl());
                                String strG = gcVar.a().g(jSONObjectE.toString());
                                if (!TextUtils.isEmpty(strG)) {
                                    contentValues.put("value", strG);
                                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                    contentValues.put("retry", (Integer) 0);
                                    contentValues.put("encrypt", (Integer) 1);
                                    sQLiteDatabaseZ.insert(str, str2, contentValues);
                                }
                                contentValues.clear();
                            }
                        }
                        sQLiteDatabaseZ.setTransactionSuccessful();
                        com.bytedance.sdk.component.gz.g.dl.dl.z("DBHelper", str + " insert list size=" + list.size(), gcVar);
                    }
                } finally {
                    if (sQLiteDatabaseZ != null) {
                        sQLiteDatabaseZ.endTransaction();
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.gz.g.dl.dl.z("DBHelper", str + " insert list error=" + list.size(), gcVar);
                wp.z(e);
                if (g(gcVar)) {
                    throw e;
                }
                if (sQLiteDatabaseZ != null) {
                    sQLiteDatabaseZ.endTransaction();
                }
            }
        }

        public int delete(gc gcVar, String str, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseZ = z(gcVar);
                if (sQLiteDatabaseZ != null) {
                    return sQLiteDatabaseZ.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                wp.z(e);
                if (g(gcVar)) {
                    throw e;
                }
                return 0;
            }
        }

        private boolean g(gc gcVar) {
            SQLiteDatabase sQLiteDatabaseZ = z(gcVar);
            return sQLiteDatabaseZ != null && sQLiteDatabaseZ.inTransaction();
        }
    }

    public g z() {
        return this.z;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.gz.g.z.z.z$z, reason: collision with other inner class name */
    private class C0135z extends AbstractCursor {
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

        private C0135z() {
        }
    }
}
