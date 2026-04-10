package com.tramini.plugin.a.f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public class d extends b {
    private static d b;

    private d(Context context) {
        super(context);
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (d.class) {
                b = new d(context.getApplicationContext());
            }
        }
        return b;
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS il(id TEXT ,value TEXT ,time INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS il_all(id TEXT ,value TEXT ,time INTEGER)");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.tramini.plugin.a.f.b
    protected final void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'il'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'il_all'");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c(sQLiteDatabase);
    }

    @Override // com.tramini.plugin.a.f.b
    protected final String c() {
        return "tramini.db";
    }

    @Override // com.tramini.plugin.a.f.b
    protected final void a(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }
}
