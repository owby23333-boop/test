package com.liulishuo.filedownloader.e0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import com.liulishuo.filedownloader.e0.a;
import com.liulishuo.filedownloader.h0.f;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SqliteDatabaseImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements com.liulishuo.filedownloader.e0.a {
    private final SQLiteDatabase a = new e(com.liulishuo.filedownloader.h0.c.a()).getWritableDatabase();

    /* JADX INFO: compiled from: SqliteDatabaseImpl.java */
    public class a implements a.InterfaceC0484a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f17184s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private b f17185t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f17186u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final SparseArray<List<com.liulishuo.filedownloader.model.a>> f17187v;

        a(d dVar) {
            this(null, null);
        }

        @Override // com.liulishuo.filedownloader.e0.a.InterfaceC0484a
        public void a(FileDownloadModel fileDownloadModel) {
            SparseArray<FileDownloadModel> sparseArray = this.f17186u;
            if (sparseArray != null) {
                sparseArray.put(fileDownloadModel.e(), fileDownloadModel);
            }
        }

        @Override // com.liulishuo.filedownloader.e0.a.InterfaceC0484a
        public void b(FileDownloadModel fileDownloadModel) {
        }

        @Override // com.liulishuo.filedownloader.e0.a.InterfaceC0484a
        public void f() {
            b bVar = this.f17185t;
            if (bVar != null) {
                bVar.a();
            }
            int size = this.f17184s.size();
            if (size < 0) {
                return;
            }
            d.this.a.beginTransaction();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    int iKeyAt = this.f17184s.keyAt(i2);
                    FileDownloadModel fileDownloadModel = this.f17184s.get(iKeyAt);
                    d.this.a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                    d.this.a.insert("filedownloader", null, fileDownloadModel.u());
                    if (fileDownloadModel.a() > 1) {
                        List<com.liulishuo.filedownloader.model.a> listC = d.this.c(iKeyAt);
                        if (listC.size() > 0) {
                            d.this.a.delete("filedownloaderConnection", "id = ?", new String[]{String.valueOf(iKeyAt)});
                            for (com.liulishuo.filedownloader.model.a aVar : listC) {
                                aVar.a(fileDownloadModel.e());
                                d.this.a.insert("filedownloaderConnection", null, aVar.f());
                            }
                        }
                    }
                } finally {
                    d.this.a.endTransaction();
                }
            }
            if (this.f17186u != null && this.f17187v != null) {
                int size2 = this.f17186u.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    int iE = this.f17186u.valueAt(i3).e();
                    List<com.liulishuo.filedownloader.model.a> listC2 = d.this.c(iE);
                    if (listC2 != null && listC2.size() > 0) {
                        this.f17187v.put(iE, listC2);
                    }
                }
            }
            d.this.a.setTransactionSuccessful();
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            b bVar = d.this.new b();
            this.f17185t = bVar;
            return bVar;
        }

        a(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<com.liulishuo.filedownloader.model.a>> sparseArray2) {
            this.f17184s = new SparseArray<>();
            this.f17186u = sparseArray;
            this.f17187v = sparseArray2;
        }

        @Override // com.liulishuo.filedownloader.e0.a.InterfaceC0484a
        public void a(int i2, FileDownloadModel fileDownloadModel) {
            this.f17184s.put(i2, fileDownloadModel);
        }
    }

    /* JADX INFO: compiled from: SqliteDatabaseImpl.java */
    class b implements Iterator<FileDownloadModel> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Cursor f17189s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final List<Integer> f17190t = new ArrayList();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f17191u;

        b() {
            this.f17189s = d.this.a.rawQuery("SELECT * FROM filedownloader", null);
        }

        void a() {
            this.f17189s.close();
            if (this.f17190t.isEmpty()) {
                return;
            }
            String strJoin = TextUtils.join(", ", this.f17190t);
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "delete %s", strJoin);
            }
            d.this.a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "filedownloader", "_id", strJoin));
            d.this.a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "filedownloaderConnection", "id", strJoin));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17189s.moveToNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f17190t.add(Integer.valueOf(this.f17191u));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public FileDownloadModel next() {
            FileDownloadModel fileDownloadModelB = d.b(this.f17189s);
            this.f17191u = fileDownloadModelB.e();
            return fileDownloadModelB;
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void b(int i2) {
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void b(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j2));
        update(i2, contentValues);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public List<com.liulishuo.filedownloader.model.a> c(int i2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.a.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "filedownloaderConnection", "id"), new String[]{Integer.toString(i2)});
            while (cursorRawQuery.moveToNext()) {
                com.liulishuo.filedownloader.model.a aVar = new com.liulishuo.filedownloader.model.a();
                aVar.a(i2);
                aVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("connectionIndex")));
                aVar.c(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(DBDefinition.START_OFFSET)));
                aVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("currentOffset")));
                aVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(DBDefinition.END_OFFSET)));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void clear() {
        this.a.delete("filedownloader", null, null);
        this.a.delete("filedownloaderConnection", null, null);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public FileDownloadModel d(int i2) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            cursorRawQuery = this.a.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "filedownloader", "_id"), new String[]{Integer.toString(i2)});
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!cursorRawQuery.moveToNext()) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return null;
            }
            FileDownloadModel fileDownloadModelB = b(cursorRawQuery);
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return fileDownloadModelB;
        } catch (Throwable th2) {
            cursor = cursorRawQuery;
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void e(int i2) {
        this.a.execSQL("DELETE FROM filedownloaderConnection WHERE id = " + i2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void insert(FileDownloadModel fileDownloadModel) {
        this.a.insert("filedownloader", null, fileDownloadModel.u());
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public boolean remove(int i2) {
        return this.a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(i2)}) != 0;
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void update(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            com.liulishuo.filedownloader.h0.d.e(this, "update but model == null!", new Object[0]);
        } else if (d(fileDownloadModel.e()) == null) {
            insert(fileDownloadModel);
        } else {
            this.a.update("filedownloader", fileDownloadModel.u(), "_id = ? ", new String[]{String.valueOf(fileDownloadModel.e())});
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(com.liulishuo.filedownloader.model.a aVar) {
        this.a.insert("filedownloaderConnection", null, aVar.f());
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, int i3, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j2));
        this.a.update("filedownloaderConnection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileDownloadModel b(Cursor cursor) {
        FileDownloadModel fileDownloadModel = new FileDownloadModel();
        fileDownloadModel.b(cursor.getInt(cursor.getColumnIndex("_id")));
        fileDownloadModel.d(cursor.getString(cursor.getColumnIndex("url")));
        fileDownloadModel.a(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        fileDownloadModel.a((byte) cursor.getShort(cursor.getColumnIndex("status")));
        fileDownloadModel.b(cursor.getLong(cursor.getColumnIndex("sofar")));
        fileDownloadModel.c(cursor.getLong(cursor.getColumnIndex("total")));
        fileDownloadModel.b(cursor.getString(cursor.getColumnIndex("errMsg")));
        fileDownloadModel.a(cursor.getString(cursor.getColumnIndex("etag")));
        fileDownloadModel.c(cursor.getString(cursor.getColumnIndex(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME)));
        fileDownloadModel.a(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return fileDownloadModel;
    }

    private void update(int i2, ContentValues contentValues) {
        this.a.update("filedownloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i3));
        this.a.update("filedownloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, String str, long j2, long j3, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j2));
        contentValues.put("total", Long.valueOf(j3));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i3));
        update(i2, contentValues);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void c(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j2));
        update(i2, contentValues);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, long j2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, str2);
        update(i2, contentValues);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, Throwable th, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j2));
        update(i2, contentValues);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        update(i2, contentValues);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, long j2) {
        remove(i2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public a.InterfaceC0484a a() {
        return new a(this);
    }

    public a.InterfaceC0484a a(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<com.liulishuo.filedownloader.model.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }
}
