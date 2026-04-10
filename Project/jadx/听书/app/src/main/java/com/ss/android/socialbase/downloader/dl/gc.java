package com.ss.android.socialbase.downloader.dl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.dl.dl;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.kb.fo;
import com.umeng.analytics.pro.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class gc extends dl.z implements q {
    private static volatile SQLiteDatabase g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f2050a;
    private e dl;
    private e gc;
    private volatile boolean m;
    g z;

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public List<com.ss.android.socialbase.downloader.e.dl> a(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl e(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public List<com.ss.android.socialbase.downloader.e.dl> g() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public boolean gc() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
    }

    public gc() {
        this(false);
    }

    public gc(boolean z) {
        this.z = null;
        if (z) {
            this.m = false;
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz() {
        if (g == null) {
            synchronized (gc.class) {
                if (g == null) {
                    try {
                        g = z.z().getWritableDatabase();
                        this.dl = new e(g, "downloader", com.ss.android.socialbase.downloader.g.dl.z, com.ss.android.socialbase.downloader.g.dl.g);
                        this.f2050a = new e(g, "downloadChunk", com.ss.android.socialbase.downloader.g.dl.dl, com.ss.android.socialbase.downloader.g.dl.f2080a);
                        this.gc = new e(g, "segments", com.ss.android.socialbase.downloader.g.dl.gc, com.ss.android.socialbase.downloader.g.dl.m);
                    } catch (Throwable th) {
                        wp.z(th);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void z() {
        z(new SparseArray<>(), new SparseArray<>(), (a) null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void z(final SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.e.g>> sparseArray2, final a aVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.1
                /* JADX WARN: Removed duplicated region for block: B:170:0x034a A[PHI: r0
  0x034a: PHI (r0v14 com.ss.android.socialbase.downloader.dl.a) = (r0v13 com.ss.android.socialbase.downloader.dl.a), (r0v18 com.ss.android.socialbase.downloader.dl.a) binds: [B:169:0x0348, B:164:0x033f] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instruction units count: 886
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.dl.gc.AnonymousClass1.run():void");
                }
            };
            ExecutorService executorServiceP = com.ss.android.socialbase.downloader.downloader.dl.p();
            if (executorServiceP != null) {
                executorServiceP.execute(runnable);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<com.ss.android.socialbase.downloader.e.dl> list) {
        if (list == null) {
            return;
        }
        try {
            for (com.ss.android.socialbase.downloader.e.dl dlVar : list) {
                if (dlVar != null && dlVar.gl()) {
                    com.ss.android.socialbase.downloader.pf.m.g(dlVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void fo() {
        g.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<com.ss.android.socialbase.downloader.e.dl> list, List<Integer> list2, SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray, SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.e.g>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || g == null) {
            return;
        }
        synchronized (g) {
            try {
                try {
                    fo();
                    if (!list.isEmpty()) {
                        if (com.ss.android.socialbase.downloader.i.z.dl().z("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                strArr[i] = String.valueOf(list.get(i));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            g.delete("downloader", str, strArr);
                            g.delete("downloadChunk", str, strArr);
                        } else {
                            String strJoin = TextUtils.join(", ", list2);
                            g.delete("downloader", "_id IN (?)", new String[]{strJoin});
                            g.delete("downloadChunk", "_id IN (?)", new String[]{strJoin});
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        int iKeyAt = sparseArray.keyAt(i2);
                        com.ss.android.socialbase.downloader.e.dl dlVar = sparseArray.get(iKeyAt);
                        g.delete("downloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                        g.insert("downloader", null, dlVar.gc());
                        if (dlVar.ux() > 1) {
                            List<com.ss.android.socialbase.downloader.e.g> listDl = dl(iKeyAt);
                            if (listDl.size() > 0) {
                                g.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                                for (com.ss.android.socialbase.downloader.e.g gVar : listDl) {
                                    gVar.g(dlVar.e());
                                    g.insert("downloadChunk", null, gVar.z());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        int size2 = sparseArray2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            int iE = sparseArray2.valueAt(i3).e();
                            List<com.ss.android.socialbase.downloader.e.g> listZ = com.ss.android.socialbase.downloader.pf.m.z(dl(iE));
                            if (listZ != null && listZ.size() > 0) {
                                sparseArray3.put(iE, listZ);
                            }
                        }
                    }
                    g.setTransactionSuccessful();
                } finally {
                    try {
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public boolean z(int i) {
        try {
            return g(i) != null;
        } catch (Throwable th) {
            wp.z(th);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl g(int i) {
        Cursor cursorRawQuery;
        gz();
        if (g != null) {
            try {
                cursorRawQuery = g.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", ar.d), new String[]{Integer.toString(i)});
            } catch (Throwable th) {
                th = th;
                cursorRawQuery = null;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    com.ss.android.socialbase.downloader.e.dl dlVar = new com.ss.android.socialbase.downloader.e.dl(cursorRawQuery);
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                    return dlVar;
                }
                com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
            } catch (Throwable th2) {
                th = th2;
                try {
                    wp.z(th);
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        gz();
        ArrayList arrayList = new ArrayList();
        if (g != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = g.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursorRawQuery.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.e.dl(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    wp.z(th);
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public List<com.ss.android.socialbase.downloader.e.g> dl(int i) {
        ArrayList arrayList = new ArrayList();
        gz();
        if (g != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = g.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", ar.d), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.e.g(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    wp.z(th);
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void a(final int i) {
        gz();
        if (g == null || this.f2050a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gc.this.z(i, gc.this.f2050a.g());
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void z(final com.ss.android.socialbase.downloader.e.g gVar) {
        gz();
        if (g == null || this.f2050a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gc.this.z(gVar, gc.this.f2050a.z());
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void g(com.ss.android.socialbase.downloader.e.g gVar) {
        z(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, SQLiteStatement sQLiteStatement) {
        if (dlVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                dlVar.z(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.ss.android.socialbase.downloader.e.g gVar, SQLiteStatement sQLiteStatement) {
        if (gVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                gVar.z(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void z(final int i, final int i2, final long j) {
        gz();
        if (i == 0 || i2 < 0 || j < 0 || g == null || this.f2050a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gc.this.z(i, i2, j, gc.this.f2050a.dl());
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void z(final int i, final int i2, final int i3, final long j) {
        gz();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || g == null || this.f2050a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gc.this.z(i, i2, i3, j, gc.this.f2050a.dl());
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void z(final int i, final int i2, final int i3, final int i4) {
        gz();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || g == null || this.f2050a == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gc.this.z(i, i2, i3, i4, gc.this.f2050a.dl());
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                g.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                g.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                g.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void g(com.ss.android.socialbase.downloader.e.dl dlVar, SQLiteStatement sQLiteStatement) {
        if (dlVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                dlVar.z(sQLiteStatement);
                sQLiteStatement.bindLong(dlVar.m() + 1, dlVar.e());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl z(int i, int i2) {
        gz();
        if (g == null) {
            return null;
        }
        int i3 = 10;
        while (g.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    wp.z(th);
                }
            } catch (Throwable th2) {
                wp.z(th2);
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        g.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    private void dl(final com.ss.android.socialbase.downloader.e.dl dlVar) {
        gz();
        if (g == null || this.dl == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gc gcVar = gc.this;
                    gcVar.z(dlVar, gcVar.dl.z());
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public boolean z(final com.ss.android.socialbase.downloader.e.dl dlVar) {
        gz();
        if (dlVar == null || g == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.10
            @Override // java.lang.Runnable
            public void run() {
                gc.this.a(dlVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        try {
            if (!z(dlVar.e())) {
                dl(dlVar);
                return;
            }
            e eVar = this.dl;
            if (eVar == null) {
                return;
            }
            try {
                g(dlVar, eVar.dl());
            } catch (Throwable th) {
                wp.z(th);
            }
        } catch (Throwable th2) {
            wp.z(th2);
        }
    }

    private void uy() {
        try {
            if (g == null || !g.inTransaction()) {
                return;
            }
            g.endTransaction();
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public boolean gc(int i) {
        e eVar;
        gz();
        if (g != null && (eVar = this.dl) != null) {
            try {
                z(i, eVar.g());
                return true;
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public boolean m(final int i) {
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.11
            @Override // java.lang.Runnable
            public void run() {
                gc.this.gc(i);
                gc.this.a(i);
                gc.this.i(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void dl() {
        gz();
        if (g == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.2
            @Override // java.lang.Runnable
            public void run() {
                gc.this.kb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void kb() {
        try {
            fo();
            g.delete("downloader", null, null);
            g.delete("downloadChunk", null, null);
            g.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                wp.z(th);
            } finally {
                uy();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl z(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl z(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl g(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl gz(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl dl(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl gc(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl fo(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public com.ss.android.socialbase.downloader.e.dl uy(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public boolean a() {
        return this.m;
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        try {
            a(i);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.e.g gVar : list) {
                    if (gVar != null) {
                        z(gVar);
                        if (gVar.m()) {
                            Iterator<com.ss.android.socialbase.downloader.e.g> it = gVar.e().iterator();
                            while (it.hasNext()) {
                                z(it.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    /* JADX INFO: renamed from: kb, reason: merged with bridge method [inline-methods] */
    public ArrayList<fo> v(int i) {
        Map<Long, fo> mapWp = wp(i);
        if (mapWp == null || mapWp.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mapWp.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public Map<Long, fo> wp(int i) {
        Cursor cursorRawQuery;
        gz();
        if (g != null) {
            try {
                cursorRawQuery = g.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", ar.d), new String[]{Integer.toString(i)});
            } catch (Throwable th) {
                th = th;
                cursorRawQuery = null;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    int columnIndex = cursorRawQuery.getColumnIndex("info");
                    String string = columnIndex >= 0 ? cursorRawQuery.getString(columnIndex) : null;
                    HashMap map = new HashMap();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        fo foVar = new fo(jSONArray.getJSONObject(i2));
                        map.put(Long.valueOf(foVar.dl()), foVar);
                    }
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                    return map;
                }
                com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
            } catch (Throwable th2) {
                th = th2;
                try {
                    wp.z(th);
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.pf.m.z(cursorRawQuery);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean z(int i, Map<Long, fo> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        gz();
        if (g == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).kb());
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        SQLiteStatement sQLiteStatementA = this.gc.a();
        synchronized (sQLiteStatementA) {
            sQLiteStatementA.clearBindings();
            sQLiteStatementA.bindLong(1, i);
            sQLiteStatementA.bindString(2, jSONArray.toString());
            sQLiteStatementA.execute();
        }
        com.ss.android.socialbase.downloader.m.z.g("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.pf.m.dl(jCurrentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void i(int i) {
        gz();
        if (g == null) {
            return;
        }
        try {
            z(i, this.gc.g());
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        gz();
        if (g == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.dl(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.gc.3
            @Override // java.lang.Runnable
            public void run() {
                gc.this.z(i, contentValues);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, ContentValues contentValues) {
        int i2 = 10;
        while (g.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    wp.z(th);
                }
            } catch (Throwable th2) {
                wp.z(th2);
                return;
            }
        }
        try {
            g.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Throwable th3) {
            wp.z(th3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.dl.dl
    public void z(g gVar) {
        this.z = gVar;
    }

    public void z(SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.e.g>> sparseArray2) {
        try {
            HashMap mapZ = com.ss.android.socialbase.downloader.pf.m.z(sparseArray);
            HashMap mapZ2 = com.ss.android.socialbase.downloader.pf.m.z(sparseArray2);
            g gVar = this.z;
            if (gVar != null) {
                gVar.z(mapZ, mapZ2);
            }
        } catch (Throwable unused) {
        }
    }
}
