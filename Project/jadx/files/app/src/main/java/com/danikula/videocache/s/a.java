package com.danikula.videocache.s;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.k;
import com.danikula.videocache.o;

/* JADX INFO: compiled from: DatabaseSourceInfoStorage.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends SQLiteOpenHelper implements b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String[] f14794s = {"_id", "url", "length", "mime"};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        k.a(context);
    }

    @Override // com.danikula.videocache.s.b
    public void a(String str, o oVar) {
        k.a(str, oVar);
        boolean z2 = get(str) != null;
        ContentValues contentValuesA = a(oVar);
        if (z2) {
            getWritableDatabase().update("SourceInfo", contentValuesA, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValuesA);
        }
    }

    @Override // com.danikula.videocache.s.b
    public o get(String str) throws Throwable {
        k.a(str);
        Cursor cursor = null;
        oVarA = null;
        o oVarA = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("SourceInfo", f14794s, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        oVarA = a(cursorQuery);
                    }
                } catch (Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return oVarA;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        k.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    private o a(Cursor cursor) {
        return new o(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    private ContentValues a(o oVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", oVar.a);
        contentValues.put("length", Long.valueOf(oVar.b));
        contentValues.put("mime", oVar.f14790c);
        return contentValues;
    }
}
