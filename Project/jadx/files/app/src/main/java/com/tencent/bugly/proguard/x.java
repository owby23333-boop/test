package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends SQLiteOpenHelper {
    public static String a = "bugly_db";
    public static int b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f18819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<o> f18820d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, List<o> list) {
        super(context, a + "_", (SQLiteDatabase.CursorFactory) null, b);
        aa.a(context).getClass();
        this.f18819c = context;
        this.f18820d = list;
    }

    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i2 = 0; i2 < 3; i2++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(strArr[i2])), new String[0]);
            }
        } catch (Throwable th) {
            if (!al.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase readableDatabase;
        readableDatabase = null;
        int i2 = 0;
        while (readableDatabase == null && i2 < 5) {
            i2++;
            try {
                readableDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                al.d("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    al.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        writableDatabase = null;
        int i2 = 0;
        while (writableDatabase == null && i2 < 5) {
            i2++;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                al.d("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    al.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (writableDatabase == null) {
            al.d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_ui ( _id INTEGER PRIMARY KEY , _tm int , _ut int , _tp int , _dt blob , _pc text ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_lr ( _id INTEGER PRIMARY KEY , _tp int , _tm int , _pc text , _th text , _dt blob ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_pf ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_cr ( _id INTEGER PRIMARY KEY , _tm int , _s1 text , _up int , _me int , _uc int , _dt blob ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS dl_1002 (_id integer primary key autoincrement, _dUrl varchar(100), _sFile varchar(100), _sLen INTEGER, _tLen INTEGER, _MD5 varchar(100), _DLTIME INTEGER)");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002 (_id integer primary key autoincrement, _time INTEGER, _datas blob)");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS st_1002 ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_sla ( _id TEXT NOT NULL , _tm INTEGER NOT NULL , _dt TEXT NOT NULL , PRIMARY KEY(_id) ) ");
            String string = sb.toString();
            al.c(string, new Object[0]);
            sQLiteDatabase.execSQL(string, new String[0]);
        } catch (Throwable th) {
            if (!al.b(th)) {
                th.printStackTrace();
            }
        }
        if (this.f18820d == null) {
            return;
        }
        Iterator<o> it = this.f18820d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDbCreate(sQLiteDatabase);
            } catch (Throwable th2) {
                if (!al.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (ab.c() >= 11) {
            al.d("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i2), Integer.valueOf(i3));
            if (this.f18820d != null) {
                Iterator<o> it = this.f18820d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbDowngrade(sQLiteDatabase, i2, i3);
                    } catch (Throwable th) {
                        if (!al.b(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            al.d("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f18819c.getDatabasePath(a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        al.d("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.f18820d != null) {
            Iterator<o> it = this.f18820d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDbUpgrade(sQLiteDatabase, i2, i3);
                } catch (Throwable th) {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
            return;
        }
        al.d("[Database] Failed to drop, delete db.", new Object[0]);
        File databasePath = this.f18819c.getDatabasePath(a);
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }
}
