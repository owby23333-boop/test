package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.n;
import com.kwad.sdk.utils.ax;
import com.umeng.analytics.pro.ar;

/* JADX INFO: loaded from: classes4.dex */
final class a extends SQLiteOpenHelper implements c {
    private static final String[] aLH = {ar.d, "url", "length", "mime"};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        ax.checkNotNull(context);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ax.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eS(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        ax.hh(str);
        n nVarH = null;
        try {
            cursorQuery = getReadableDatabase().query("SourceInfo", aLH, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        nVarH = h(cursorQuery);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            return nVarH;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        ax.d(str, nVar);
        boolean z = eS(str) != null;
        ContentValues contentValuesA = a(nVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", contentValuesA, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValuesA);
        }
    }

    private static n h(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    private static ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.url);
        contentValues.put("length", Long.valueOf(nVar.aLB));
        contentValues.put("mime", nVar.aLC);
        return contentValues;
    }
}
