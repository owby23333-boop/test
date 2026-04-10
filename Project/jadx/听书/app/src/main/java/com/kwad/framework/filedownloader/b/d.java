package com.kwad.framework.filedownloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import com.umeng.analytics.pro.ar;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    private static boolean amQ;
    private final e amR = new e(com.kwad.framework.filedownloader.f.c.zz());
    private SQLiteDatabase amS;

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bC(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bH(int i) {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0048 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bD(int i) throws Throwable {
        Cursor cursorRawQuery;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursorRawQuery = xV().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", ar.d), new String[]{Integer.toString(i)});
            } catch (SQLiteException e) {
                e = e;
                cursorRawQuery = null;
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    com.kwad.framework.filedownloader.d.c cVarD = d(cursorRawQuery);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return cVarD;
                }
            } catch (SQLiteException e3) {
                e = e3;
                a(i, e);
            } catch (Exception e4) {
                e = e4;
                printStackTrace(e);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bE(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = xV().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                    aVar.setId(i);
                    aVar.setIndex(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("startOffset")));
                    aVar.X(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("currentOffset")));
                    aVar.Y(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("endOffset")));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e) {
                a(i, e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bF(int i) {
        try {
            xV().execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        if (aVar != null) {
            try {
                xV().insert("ksad_file_download_connection", null, aVar.yX());
            } catch (SQLiteException e) {
                a(aVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            xV().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void t(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            xV().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        try {
            xV().insert("ksad_file_download", null, cVar.yX());
        } catch (SQLiteException e) {
            cVar.by(e.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bD(cVar.getId()) != null) {
            try {
                xV().update("ksad_file_download", cVar.yX(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
                return;
            } catch (SQLiteException e) {
                cVar.by(e.toString());
                cVar.d((byte) -1);
                a(cVar.getId(), e);
                return;
            } catch (Exception e2) {
                printStackTrace(e2);
                return;
            }
        }
        d(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bG(int i) {
        try {
            return xV().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
        } catch (SQLiteException e) {
            printStackTrace(e);
            return false;
        } catch (Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        try {
            xV().delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            a(e);
        }
        try {
            xV().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) 5);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        bG(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0371a xT() {
        return new a(null, null);
    }

    public final a.InterfaceC0371a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    private void a(int i, ContentValues contentValues) {
        try {
            xV().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    public class a implements a.InterfaceC0371a {
        private final SparseArray<com.kwad.framework.filedownloader.d.c> amG;
        private final SparseArray<List<com.kwad.framework.filedownloader.d.a>> amH;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> amT = new SparseArray<>();
        private b amU;

        a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.amG = sparseArray;
            this.amH = sparseArray2;
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            b bVar = d.this.new b();
            this.amU = bVar;
            return bVar;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0371a
        public final void xU() {
            b bVar = this.amU;
            if (bVar != null) {
                bVar.xU();
            }
            try {
                SQLiteDatabase sQLiteDatabaseXV = d.this.xV();
                if (sQLiteDatabaseXV == null) {
                    return;
                }
                int size = this.amT.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        sQLiteDatabaseXV.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int iKeyAt = this.amT.keyAt(i);
                            com.kwad.framework.filedownloader.d.c cVar = this.amT.get(iKeyAt);
                            sQLiteDatabaseXV.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                            sQLiteDatabaseXV.insert("ksad_file_download", null, cVar.yX());
                            if (cVar.zc() > 1) {
                                List<com.kwad.framework.filedownloader.d.a> listBE = d.this.bE(iKeyAt);
                                if (listBE.size() > 0) {
                                    sQLiteDatabaseXV.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(iKeyAt)});
                                    for (com.kwad.framework.filedownloader.d.a aVar : listBE) {
                                        aVar.setId(cVar.getId());
                                        sQLiteDatabaseXV.insert("ksad_file_download_connection", null, aVar.yX());
                                    }
                                }
                            }
                        }
                        SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.amG;
                        if (sparseArray != null && this.amH != null) {
                            synchronized (sparseArray) {
                                int size2 = this.amG.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int id = this.amG.valueAt(i2).getId();
                                    List<com.kwad.framework.filedownloader.d.a> listBE2 = d.this.bE(id);
                                    if (listBE2 != null && listBE2.size() > 0) {
                                        synchronized (this.amH) {
                                            this.amH.put(id, listBE2);
                                        }
                                    }
                                }
                            }
                        }
                        sQLiteDatabaseXV.setTransactionSuccessful();
                        if (sQLiteDatabaseXV != null) {
                            try {
                                sQLiteDatabaseXV.endTransaction();
                            } catch (Exception e) {
                                d.printStackTrace(e);
                            }
                        }
                    } catch (SQLiteException e2) {
                        d.this.a(e2);
                        if (sQLiteDatabaseXV != null) {
                            try {
                                sQLiteDatabaseXV.endTransaction();
                            } catch (Exception e3) {
                                d.printStackTrace(e3);
                            }
                        }
                    } catch (Exception e4) {
                        d.printStackTrace(e4);
                        if (sQLiteDatabaseXV != null) {
                            try {
                                sQLiteDatabaseXV.endTransaction();
                            } catch (Exception e5) {
                                d.printStackTrace(e5);
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabaseXV != null) {
                        try {
                            sQLiteDatabaseXV.endTransaction();
                        } catch (Exception e6) {
                            d.printStackTrace(e6);
                        }
                    }
                    throw th;
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0371a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.amG;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.amG.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0371a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
            this.amT.put(i, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase xV() {
        if (this.amS == null) {
            this.amS = this.amR.getWritableDatabase();
        }
        return this.amS;
    }

    class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        private Cursor amW;
        private final List<Integer> amX = new ArrayList();
        private int amY;

        b() {
            try {
                this.amW = d.this.xV().query("ksad_file_download", null, null, null, null, null, null);
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.amW;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: xW, reason: merged with bridge method [inline-methods] */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c cVarD = d.d(this.amW);
            this.amY = cVarD.getId();
            return cVarD;
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.amX.add(Integer.valueOf(this.amY));
        }

        final void xU() {
            Cursor cursor = this.amW;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (this.amX.isEmpty()) {
                return;
            }
            String strJoin = TextUtils.join(", ", this.amX);
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "delete %s", strJoin);
            }
            try {
                SQLiteDatabase sQLiteDatabaseXV = d.this.xV();
                sQLiteDatabaseXV.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", ar.d, strJoin));
                sQLiteDatabaseXV.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", strJoin));
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex(ar.d)));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.d(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS)));
        cVar.Z(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.ab(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.by(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.bx(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.bz(cursor.getString(cursor.getColumnIndex("filename")));
        cVar.bW(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void a(int i, SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i != -1) {
                bG(i);
                bF(i);
            }
            h(sQLiteException);
            amQ = true;
            return;
        }
        printStackTrace(sQLiteException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        h(th);
    }

    private static void h(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }
}
