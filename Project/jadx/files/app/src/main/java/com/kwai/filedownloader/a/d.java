package com.kwai.filedownloader.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.kwai.filedownloader.a.a {
    private static boolean aFh = false;
    private SQLiteDatabase aFg;

    public class a implements a.InterfaceC0462a {
        private final SparseArray<com.kwai.filedownloader.c.c> aEW;
        private final SparseArray<List<com.kwai.filedownloader.c.a>> aEX;
        private final SparseArray<com.kwai.filedownloader.c.c> aFi;
        private b aFj;

        a(d dVar) {
            this(null, null);
        }

        a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
            this.aFi = new SparseArray<>();
            this.aEW = sparseArray;
            this.aEX = sparseArray2;
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0462a
        public final void Hm() {
            b bVar = this.aFj;
            if (bVar != null) {
                bVar.Hm();
            }
            if (d.this.aFg == null) {
                return;
            }
            int size = this.aFi.size();
            try {
                if (size < 0) {
                    return;
                }
                try {
                    d.this.aFg.beginTransaction();
                    for (int i2 = 0; i2 < size; i2++) {
                        int iKeyAt = this.aFi.keyAt(i2);
                        com.kwai.filedownloader.c.c cVar = this.aFi.get(iKeyAt);
                        d.this.aFg.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                        d.this.aFg.insert("ksad_file_download", null, cVar.In());
                        if (cVar.Ir() > 1) {
                            List<com.kwai.filedownloader.c.a> listCE = d.this.cE(iKeyAt);
                            if (listCE.size() > 0) {
                                d.this.aFg.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(iKeyAt)});
                                for (com.kwai.filedownloader.c.a aVar : listCE) {
                                    aVar.setId(cVar.getId());
                                    d.this.aFg.insert("ksad_file_download_connection", null, aVar.In());
                                }
                            }
                        }
                    }
                    if (this.aEW != null && this.aEX != null) {
                        synchronized (this.aEW) {
                            int size2 = this.aEW.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                int id = this.aEW.valueAt(i3).getId();
                                List<com.kwai.filedownloader.c.a> listCE2 = d.this.cE(id);
                                if (listCE2 != null && listCE2.size() > 0) {
                                    synchronized (this.aEX) {
                                        this.aEX.put(id, listCE2);
                                    }
                                }
                            }
                        }
                    }
                    d.this.aFg.setTransactionSuccessful();
                    if (d.this.aFg != null) {
                        try {
                            d.this.aFg.endTransaction();
                        } catch (Exception e2) {
                            d.printStackTrace(e2);
                        }
                    }
                } catch (SQLiteException e3) {
                    d.this.a(e3);
                    if (d.this.aFg != null) {
                        try {
                            d.this.aFg.endTransaction();
                        } catch (Exception e4) {
                            d.printStackTrace(e4);
                        }
                    }
                } catch (Exception e5) {
                    d.printStackTrace(e5);
                    if (d.this.aFg != null) {
                        try {
                            d.this.aFg.endTransaction();
                        } catch (Exception e6) {
                            d.printStackTrace(e6);
                        }
                    }
                }
            } catch (Throwable th) {
                if (d.this.aFg != null) {
                    try {
                        d.this.aFg.endTransaction();
                    } catch (Exception e7) {
                        d.printStackTrace(e7);
                    }
                }
                throw th;
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0462a
        public final void a(int i2, com.kwai.filedownloader.c.c cVar) {
            this.aFi.put(i2, cVar);
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0462a
        public final void c(com.kwai.filedownloader.c.c cVar) {
            SparseArray<com.kwai.filedownloader.c.c> sparseArray = this.aEW;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.aEW.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            b bVar = d.this.new b();
            this.aFj = bVar;
            return bVar;
        }
    }

    class b implements Iterator<com.kwai.filedownloader.c.c> {
        private Cursor aFl;
        private final List<Integer> aFm = new ArrayList();
        private int aFn;

        b() {
            if (d.this.aFg != null) {
                try {
                    this.aFl = d.this.aFg.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e2) {
                    d.this.a(e2);
                } catch (Exception e3) {
                    d.printStackTrace(e3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: Hn, reason: merged with bridge method [inline-methods] */
        public com.kwai.filedownloader.c.c next() {
            com.kwai.filedownloader.c.c cVarJ = d.j(this.aFl);
            this.aFn = cVarJ.getId();
            return cVarJ;
        }

        final void Hm() {
            Cursor cursor;
            if (d.this.aFg == null || (cursor = this.aFl) == null) {
                return;
            }
            cursor.close();
            if (this.aFm.isEmpty()) {
                return;
            }
            String strJoin = TextUtils.join(", ", this.aFm);
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "delete %s", strJoin);
            }
            try {
                d.this.aFg.execSQL(f.j("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", strJoin));
                d.this.aFg.execSQL(f.j("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", strJoin));
            } catch (SQLiteException e2) {
                d.this.a(e2);
            } catch (Exception e3) {
                d.printStackTrace(e3);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                if (this.aFl != null) {
                    return this.aFl.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.aFm.add(Integer.valueOf(this.aFn));
        }
    }

    public d() {
        try {
            this.aFg = new e(com.kwai.filedownloader.e.c.IN()).getWritableDatabase();
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    private void a(int i2, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase = this.aFg;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
            } catch (SQLiteException e2) {
                a(i2, e2);
            } catch (Exception e3) {
                printStackTrace(e3);
            }
        }
    }

    private void a(int i2, @Nullable SQLiteException sQLiteException) {
        if (!(sQLiteException instanceof SQLiteFullException)) {
            printStackTrace(sQLiteException);
            return;
        }
        if (i2 != -1) {
            cG(i2);
            cF(i2);
        }
        m(sQLiteException);
        aFh = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void d(com.kwai.filedownloader.c.c cVar) {
        SQLiteDatabase sQLiteDatabase = this.aFg;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.insert("ksad_file_download", null, cVar.In());
            } catch (SQLiteException e2) {
                cVar.ff(e2.toString());
                cVar.e((byte) -1);
                a(cVar.getId(), e2);
            } catch (Exception e3) {
                printStackTrace(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwai.filedownloader.c.c j(Cursor cursor) {
        com.kwai.filedownloader.c.c cVar = new com.kwai.filedownloader.c.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.g(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.e((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.ao(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.aq(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.ff(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.fe(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.fg(cursor.getString(cursor.getColumnIndex(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME)));
        cVar.cW(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    private static void m(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        m(th);
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0462a Hl() {
        return new a(this);
    }

    public final a.InterfaceC0462a a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, int i3, long j2) {
        if (this.aFg == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j2));
        try {
            this.aFg.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, long j2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, str2);
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, String str, long j2, long j3, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j2));
        contentValues.put("total", Long.valueOf(j3));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i3));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        if (aVar == null || (sQLiteDatabase = this.aFg) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download_connection", null, aVar.In());
        } catch (SQLiteException e2) {
            a(aVar.getId(), e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        if (this.aFg == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.e.d.h(this, "update but model == null!", new Object[0]);
            return;
        }
        if (cD(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        try {
            this.aFg.update("ksad_file_download", cVar.In(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
        } catch (SQLiteException e2) {
            cVar.ff(e2.toString());
            cVar.e((byte) -1);
            a(cVar.getId(), e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cC(int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cD(int i2) throws Throwable {
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabase = this.aFg;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(f.j("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i2)});
            } catch (SQLiteException e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Exception e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(sQLiteDatabase2);
                throw th;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    com.kwai.filedownloader.c.c cVarJ = j(cursorRawQuery);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return cVarJ;
                }
            } catch (SQLiteException e4) {
                e = e4;
                a(i2, e);
            } catch (Exception e5) {
                e = e5;
                printStackTrace(e);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            return null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase2 = sQLiteDatabase;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cE(int i2) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.aFg;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                try {
                    cursorRawQuery = sQLiteDatabase.rawQuery(f.j("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i2)});
                    while (cursorRawQuery.moveToNext()) {
                        com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
                        aVar.setId(i2);
                        aVar.setIndex(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("connectionIndex")));
                        aVar.setStartOffset(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(DBDefinition.START_OFFSET)));
                        aVar.am(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("currentOffset")));
                        aVar.an(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(DBDefinition.END_OFFSET)));
                        arrayList.add(aVar);
                    }
                } catch (Exception e2) {
                    printStackTrace(e2);
                }
            } catch (SQLiteException e3) {
                a(i2, e3);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cF(int i2) {
        SQLiteDatabase sQLiteDatabase = this.aFg;
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i2);
        } catch (SQLiteException e2) {
            printStackTrace(e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cG(int i2) {
        SQLiteDatabase sQLiteDatabase = this.aFg;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i2)}) != 0;
        } catch (SQLiteException | Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i2) {
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        SQLiteDatabase sQLiteDatabase = this.aFg;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.delete("ksad_file_download", null, null);
            } catch (SQLiteException e2) {
                a(e2);
            }
            try {
                this.aFg.delete("ksad_file_download_connection", null, null);
            } catch (SQLiteException e3) {
                a(e3);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void d(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i2, long j2) {
        cG(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void z(int i2, int i3) {
        if (this.aFg == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i3));
        try {
            this.aFg.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            printStackTrace(e3);
        }
    }
}
