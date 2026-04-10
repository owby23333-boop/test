package com.taobao.accs.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.anythink.core.api.ATAdConst;
import com.kwad.sdk.collector.AppStatusRules;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f18113c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lock f18114e = new ReentrantLock();
    public int a;
    LinkedList<C0531a> b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f18115d;

    /* JADX INFO: renamed from: com.taobao.accs.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    private class C0531a {
        String a;
        Object[] b;

        private C0531a(String str, Object[] objArr) {
            this.a = str;
            this.b = objArr;
        }
    }

    private a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.a = 0;
        this.b = new LinkedList<>();
        this.f18115d = context;
    }

    public static a a(Context context) {
        if (f18113c == null) {
            synchronized (a.class) {
                if (f18113c == null) {
                    f18113c = new a(context, Constants.DB_NAME, null, 3);
                }
            }
        }
        return f18113c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (j.a(super.getWritableDatabase().getPath(), AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE)) {
            return super.getWritableDatabase();
        }
        return null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            if (f18114e.tryLock()) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS traffic(_id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, host TEXT,serviceid TEXT, bid TEXT, isbackground TEXT, size TEXT)");
            }
        } finally {
            f18114e.unlock();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 < i3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS service");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS network");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ping");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS election");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindApp");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bindUser");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS traffic");
            onCreate(sQLiteDatabase);
        }
    }

    public void a(String str, String str2, String str3, boolean z2, long j2, String str4) {
        if (a(str, str3, z2, str4)) {
            a("UPDATE traffic SET size=? WHERE date=? AND host=? AND bid=? AND isbackground=?", new Object[]{Long.valueOf(j2), str4, str, str3, String.valueOf(z2)}, true);
        } else {
            a("INSERT INTO traffic VALUES(null,?,?,?,?,?,?)", new Object[]{str4, str, str2, str3, String.valueOf(z2), Long.valueOf(j2)}, true);
        }
    }

    private synchronized boolean a(String str, String str2, boolean z2, String str3) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
            } catch (Exception e2) {
                ALog.w("DBHelper", e2.toString(), new Object[0]);
                if (cursorQuery != null) {
                }
            }
            if (writableDatabase == null) {
                return false;
            }
            cursorQuery = writableDatabase.query(d.F, new String[]{"_id", "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE}, "date=? AND host=? AND bid=? AND isbackground=?", new String[]{str3, str, str2, String.valueOf(z2)}, null, null, null, String.valueOf(100));
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0) {
                    return true;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public void a() {
        a("DELETE FROM traffic", null, true);
    }

    public List<TrafficsMonitor.a> a(boolean z2) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                } catch (Exception e2) {
                    e = e2;
                }
                if (writableDatabase == null) {
                    return null;
                }
                if (z2) {
                    cursorQuery = writableDatabase.query(d.F, new String[]{"_id", "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE}, "date=?", new String[]{UtilityImpl.a(System.currentTimeMillis())}, null, null, null, String.valueOf(100));
                } else {
                    cursorQuery = writableDatabase.query(d.F, new String[]{"_id", "date", Constants.KEY_HOST, "serviceid", "bid", "isbackground", ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE}, null, null, null, null, null, String.valueOf(100));
                }
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(1);
                            String string2 = cursorQuery.getString(2);
                            String string3 = cursorQuery.getString(3);
                            String string4 = cursorQuery.getString(4);
                            boolean zBooleanValue = Boolean.valueOf(cursorQuery.getString(5)).booleanValue();
                            long j2 = cursorQuery.getLong(6);
                            if (string4 != null && j2 > 0) {
                                arrayList.add(new TrafficsMonitor.a(string, string4, string3, zBooleanValue, string2, j2));
                            }
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e3) {
                    cursor = cursorQuery;
                    e = e3;
                    ALog.w("DBHelper", e.toString(), new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        com.taobao.accs.utl.ALog.d("DBHelper", "db is full!", new java.lang.Object[0]);
        onUpgrade(r5, 0, 1);
        r4.a = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void a(java.lang.String r5, java.lang.Object[] r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.util.LinkedList<com.taobao.accs.b.a$a> r1 = r4.b     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            com.taobao.accs.b.a$a r2 = new com.taobao.accs.b.a$a     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r3 = 0
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r1.add(r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            java.util.LinkedList<com.taobao.accs.b.a$a> r5 = r4.b     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            r6 = 5
            if (r5 > r6) goto L18
            if (r7 == 0) goto L7c
        L18:
            android.database.sqlite.SQLiteDatabase r5 = r4.getWritableDatabase()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            if (r5 != 0) goto L20
            monitor-exit(r4)
            return
        L20:
            java.util.LinkedList<com.taobao.accs.b.a$a> r6 = r4.b     // Catch: java.lang.Throwable -> L69
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L69
            if (r6 <= 0) goto L65
            java.util.LinkedList<com.taobao.accs.b.a$a> r6 = r4.b     // Catch: java.lang.Throwable -> L69
            java.lang.Object r6 = r6.removeFirst()     // Catch: java.lang.Throwable -> L69
            com.taobao.accs.b.a$a r6 = (com.taobao.accs.b.a.C0531a) r6     // Catch: java.lang.Throwable -> L69
            java.lang.Object[] r7 = r6.b     // Catch: java.lang.Throwable -> L69
            if (r7 == 0) goto L3c
            java.lang.String r7 = r6.a     // Catch: java.lang.Throwable -> L69
            java.lang.Object[] r1 = r6.b     // Catch: java.lang.Throwable -> L69
            r5.execSQL(r7, r1)     // Catch: java.lang.Throwable -> L69
            goto L41
        L3c:
            java.lang.String r7 = r6.a     // Catch: java.lang.Throwable -> L69
            r5.execSQL(r7)     // Catch: java.lang.Throwable -> L69
        L41:
            java.lang.String r6 = r6.a     // Catch: java.lang.Throwable -> L69
            java.lang.String r7 = "INSERT"
            boolean r6 = r6.contains(r7)     // Catch: java.lang.Throwable -> L69
            if (r6 == 0) goto L20
            int r6 = r4.a     // Catch: java.lang.Throwable -> L69
            r7 = 1
            int r6 = r6 + r7
            r4.a = r6     // Catch: java.lang.Throwable -> L69
            int r6 = r4.a     // Catch: java.lang.Throwable -> L69
            r1 = 4000(0xfa0, float:5.605E-42)
            if (r6 <= r1) goto L20
            java.lang.String r6 = "DBHelper"
            java.lang.String r1 = "db is full!"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L69
            com.taobao.accs.utl.ALog.d(r6, r1, r2)     // Catch: java.lang.Throwable -> L69
            r4.onUpgrade(r5, r0, r7)     // Catch: java.lang.Throwable -> L69
            r4.a = r0     // Catch: java.lang.Throwable -> L69
        L65:
            r5.close()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            goto L7c
        L69:
            r6 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
            throw r6     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70
        L6e:
            r5 = move-exception
            goto L7e
        L70:
            r5 = move-exception
            java.lang.String r6 = "DBHelper"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6e
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L6e
            com.taobao.accs.utl.ALog.d(r6, r5, r7)     // Catch: java.lang.Throwable -> L6e
        L7c:
            monitor-exit(r4)
            return
        L7e:
            monitor-exit(r4)
            goto L81
        L80:
            throw r5
        L81:
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.a(java.lang.String, java.lang.Object[], boolean):void");
    }
}
