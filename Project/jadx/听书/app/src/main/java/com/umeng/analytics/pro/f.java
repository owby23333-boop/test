package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.e;

/* JADX INFO: compiled from: UMDBCreater.java */
/* JADX INFO: loaded from: classes4.dex */
class f extends SQLiteOpenHelper {
    private static Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2230a;

    /* JADX INFO: compiled from: UMDBCreater.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f2231a = new f(f.b, h.b(f.b), e.b, null, 2);

        private a() {
        }
    }

    public static f a(Context context) {
        if (b == null) {
            b = context.getApplicationContext();
        }
        return a.f2231a;
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new c(context, str), str2, cursorFactory, i);
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, TextUtils.isEmpty(str) ? e.b : str, cursorFactory, i);
        this.f2230a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.f2227a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.f2224a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.f2221a, writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a(e.a.f2218a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(b);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2230a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2230a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2230a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2230a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= i || i != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            f(sQLiteDatabase);
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, e.d.f2227a, "__av")) {
            h.a(sQLiteDatabase, e.d.f2227a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.f2227a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.f2227a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.f2227a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.f2221a, "__av")) {
            h.a(sQLiteDatabase, e.b.f2221a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.f2221a, "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, e.a.f2218a, "__av")) {
            return;
        }
        h.a(sQLiteDatabase, e.a.f2218a, "__av", "TEXT");
        h.a(sQLiteDatabase, e.a.f2218a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, e.d.f2227a);
        a(sQLiteDatabase, e.b.f2221a);
        a(sQLiteDatabase, e.a.f2218a);
        a();
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
