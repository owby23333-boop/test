package com.kwad.sdk.core.videocache.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.m;
import com.kwad.sdk.utils.an;

/* JADX INFO: loaded from: classes3.dex */
final class a extends SQLiteOpenHelper implements b {
    private static final String[] anK = {"_id", "url", "length", "mime"};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        an.checkNotNull(context);
    }

    private static ContentValues a(m mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", mVar.url);
        contentValues.put("length", Long.valueOf(mVar.anE));
        contentValues.put("mime", mVar.anF);
        return contentValues;
    }

    private static m g(Cursor cursor) {
        return new m(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public final void a(String str, m mVar) {
        an.e(str, mVar);
        boolean z2 = cI(str) != null;
        ContentValues contentValuesA = a(mVar);
        if (z2) {
            getWritableDatabase().update("SourceInfo", contentValuesA, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, contentValuesA);
        }
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public final m cI(String str) throws Throwable {
        an.et(str);
        Cursor cursor = null;
        mVarG = null;
        m mVarG = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("SourceInfo", anK, "url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        mVarG = g(cursorQuery);
                    }
                } catch (Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            return mVarG;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        an.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
