package com.tramini.plugin.a.f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    private a a;

    private class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            b.this.a(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            b.this.b(sQLiteDatabase);
        }
    }

    public b(Context context) {
        this.a = new a(context, c());
    }

    public final SQLiteDatabase a() {
        return this.a.getReadableDatabase();
    }

    protected abstract void a(SQLiteDatabase sQLiteDatabase);

    public final synchronized SQLiteDatabase b() {
        SQLiteDatabase writableDatabase;
        writableDatabase = null;
        try {
            writableDatabase = this.a.getWritableDatabase();
        } catch (Exception unused) {
        }
        return writableDatabase;
    }

    protected abstract void b(SQLiteDatabase sQLiteDatabase);

    protected abstract String c();
}
