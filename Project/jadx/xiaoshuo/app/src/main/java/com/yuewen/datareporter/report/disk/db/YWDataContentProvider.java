package com.yuewen.datareporter.report.disk.db;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.yuewen.h;
import com.yuewen.l;

/* JADX INFO: loaded from: classes8.dex */
public class YWDataContentProvider extends ContentProvider {
    public static UriMatcher c = new UriMatcher(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f10119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10120b = true;

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        if (!this.f10120b) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.f10119a.getWritableDatabase();
                writableDatabase.beginTransaction();
                int length = contentValuesArr.length;
                for (ContentValues contentValues : contentValuesArr) {
                    insert(uri, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return length;
            } catch (SQLiteException e) {
                this.f10120b = false;
                h.a(e);
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase;
        try {
            if (!this.f10120b) {
                return 0;
            }
            try {
                writableDatabase = this.f10119a.getWritableDatabase();
            } catch (SQLiteException e) {
                this.f10120b = false;
                h.a(e);
                writableDatabase = null;
            }
            writableDatabase.delete("reports", "_id <= ?", strArr);
        } catch (Exception e2) {
            h.a(e2);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (!this.f10120b) {
            return uri;
        }
        try {
            if (c.match(uri) != 1) {
                return uri;
            }
            try {
                return ContentUris.withAppendedId(uri, this.f10119a.getWritableDatabase().insert("reports", "_id", contentValues));
            } catch (SQLiteException e) {
                this.f10120b = false;
                h.a(e);
                return uri;
            }
        } catch (Exception e2) {
            h.a(e2);
            return uri;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            String str = context.getApplicationContext().getPackageName() + ".YWDataContentProvider";
            context.getContentResolver();
            c.addURI(str, "reports", 1);
            this.f10119a = new l(context);
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!this.f10120b) {
            return null;
        }
        try {
            if (c.match(uri) != 1) {
                return null;
            }
            try {
                return this.f10119a.getWritableDatabase().query("reports", strArr, str, strArr2, null, null, str2);
            } catch (SQLiteException e) {
                this.f10120b = false;
                h.a(e);
                return null;
            }
        } catch (Exception e2) {
            h.a(e2);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
