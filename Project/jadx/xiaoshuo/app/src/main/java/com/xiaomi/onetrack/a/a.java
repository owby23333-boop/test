package com.xiaomi.onetrack.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.onetrack.b.n;
import com.xiaomi.onetrack.util.p;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7486a = "AdMonitorManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f7487b = 204800;
    private static final int c = 100;
    private static final int d = 4;
    private static final int e = 300;
    private static final String f = "_id ASC";
    private static final int g = 7;
    private static a h;
    private final C0545a i = new C0545a(com.xiaomi.onetrack.f.a.a());

    /* JADX INFO: renamed from: com.xiaomi.onetrack.a.a$a, reason: collision with other inner class name */
    public static class C0545a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f7488a = "onetrack_ad";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f7489b = "monitor";
        public static final String c = "_id";
        public static final String d = "appid";
        public static final String e = "package";
        public static final String f = "event_name";
        public static final String g = "url";
        public static final String h = "timestamp";
        public static final String i = "send_count";
        private static final int j = 1;
        private static final String k = "CREATE TABLE monitor (_id INTEGER PRIMARY KEY AUTOINCREMENT,appid TEXT,package TEXT,event_name TEXT,url TEXT,send_count INTEGER DEFAULT 0,timestamp INTEGER)";

        public C0545a(Context context) {
            super(context, f7488a, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(k);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    private a() {
        c();
    }

    private void f() {
        try {
            this.i.getWritableDatabase().delete(C0545a.f7489b, null, null);
            p.a(f7486a, "delete table monitor");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00fa: MOVE (r17 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:47:0x00fa */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3 A[Catch: all -> 0x0102, PHI: r9
  0x00e3: PHI (r9v4 android.database.Cursor) = (r9v3 android.database.Cursor), (r9v5 android.database.Cursor) binds: [B:36:0x00e1, B:42:0x00f4] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:24:0x00cc, B:25:0x00cf, B:37:0x00e3, B:44:0x00f7, B:49:0x00fe, B:50:0x0101), top: B:54:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.xiaomi.onetrack.a.c.a b() {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.onetrack.a.a.b():com.xiaomi.onetrack.a.c.a");
    }

    public void c() {
        com.xiaomi.onetrack.a.a.a.a(new c(this), 1000L);
    }

    public void d() {
        synchronized (this.i) {
            Cursor cursorQuery = null;
            try {
                try {
                    SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
                    String[] strArr = {Long.toString(4L)};
                    cursorQuery = writableDatabase.query(C0545a.f7489b, new String[]{"timestamp"}, "send_count >= ? ", strArr, null, null, f);
                    if (cursorQuery.getCount() != 0) {
                        p.a(f7486a, "*** deleted obsolete ad monitor count=" + writableDatabase.delete(C0545a.f7489b, "send_count >= ? ", strArr));
                    }
                    if (p.f7764a) {
                        p.a(f7486a, "after delete obsolete ad monitor record remains=" + e());
                    }
                } catch (Exception e2) {
                    p.d(f7486a, "remove obsolete ad monitor failed with " + e2);
                    if (cursorQuery != null) {
                    }
                }
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
    }

    public long e() {
        try {
            return DatabaseUtils.queryNumEntries(this.i.getReadableDatabase(), C0545a.f7489b);
        } catch (Exception e2) {
            p.b(f7486a, "getTotalEventsNumberSync failed with " + e2.getMessage());
            return 0L;
        }
    }

    public static a a() {
        if (h == null) {
            a(com.xiaomi.onetrack.f.a.a());
        }
        return h;
    }

    public static void a(Context context) {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
    }

    public void a(com.xiaomi.onetrack.f.b bVar) {
        try {
            com.xiaomi.onetrack.a.a.a.a(new b(this, bVar));
        } catch (Throwable th) {
            p.a(f7486a, "filterAdMonitor Throwable：" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(com.xiaomi.onetrack.a.b.a aVar) {
        synchronized (this.i) {
            try {
                if (!aVar.h()) {
                    p.c(f7486a, "addAdMonitorToDatabase event is inValid, event:" + aVar.a());
                    return -1L;
                }
                SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("appid", aVar.e());
                contentValues.put("package", aVar.f());
                contentValues.put("event_name", aVar.a());
                contentValues.put("timestamp", Long.valueOf(aVar.d()));
                contentValues.put("url", aVar.c());
                long jInsert = writableDatabase.insert(C0545a.f7489b, null, contentValues);
                p.a(f7486a, "DB-Thread: AdMonitorManager.addAdMonitorToDatabase , row=" + jInsert);
                if (p.f7764a) {
                    p.a(f7486a, "添加后，ad monitor url 中事件个数为 " + e());
                }
                return jInsert;
            } catch (Throwable th) {
                p.a(f7486a, "addAdMonitorToDatabase Throwable：" + th.getMessage());
                return -1L;
            }
        }
    }

    public int a(ArrayList<Integer> arrayList) {
        synchronized (this.i) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    try {
                        SQLiteDatabase writableDatabase = this.i.getWritableDatabase();
                        StringBuilder sb = new StringBuilder(((Long.toString(arrayList.get(0).intValue()).length() + 1) * arrayList.size()) + 16);
                        sb.append("_id");
                        sb.append(" in (");
                        sb.append(arrayList.get(0));
                        int size = arrayList.size();
                        for (int i = 1; i < size; i++) {
                            sb.append(",");
                            sb.append(arrayList.get(i));
                        }
                        sb.append(")");
                        int iDelete = writableDatabase.delete(C0545a.f7489b, sb.toString(), null);
                        p.a(f7486a, "*** *** deleted ad monitor count " + iDelete);
                        if (p.f7764a) {
                            p.a(f7486a, "after delete ad monitor record remains=" + e());
                        }
                        return iDelete;
                    } catch (Exception e2) {
                        p.b(f7486a, "e=" + e2);
                        return 0;
                    }
                }
            }
            return 0;
        }
    }

    public void b(ArrayList<Integer> arrayList) {
        String str;
        String str2;
        synchronized (this.i) {
            if (arrayList != null) {
                try {
                } catch (Throwable th) {
                    p.a(f7486a, "addAdMonitorsRetryCount Throwable:" + th.getMessage());
                }
                if (arrayList.size() > 0) {
                    SQLiteDatabase writableDatabase = null;
                    try {
                        try {
                            writableDatabase = this.i.getWritableDatabase();
                            writableDatabase.beginTransaction();
                            Iterator<Integer> it = arrayList.iterator();
                            while (it.hasNext()) {
                                writableDatabase.execSQL(String.format("update %s set %s = %s + 1 where %s = %s", C0545a.f7489b, C0545a.i, C0545a.i, "_id", Integer.valueOf(it.next().intValue())));
                            }
                            writableDatabase.setTransactionSuccessful();
                            try {
                                writableDatabase.endTransaction();
                                writableDatabase.close();
                            } catch (Exception e2) {
                                str = f7486a;
                                str2 = "addAdMonitorsRetryCount endTransaction error: " + e2.getMessage();
                                p.b(str, str2);
                            }
                        } catch (Exception e3) {
                            p.b(f7486a, "addAdMonitorsRetryCount Exception: " + e3.getMessage());
                            if (writableDatabase != null) {
                                try {
                                    writableDatabase.endTransaction();
                                    writableDatabase.close();
                                } catch (Exception e4) {
                                    str = f7486a;
                                    str2 = "addAdMonitorsRetryCount endTransaction error: " + e4.getMessage();
                                    p.b(str, str2);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public boolean a(long j, long j2, int i) {
        if (i <= 0) {
            return true;
        }
        if (i < 4) {
            return Math.abs(j - j2) >= ((long) n.a(i - 1));
        }
        return false;
    }
}
