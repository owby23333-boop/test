package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static boolean a = false;
    private static w b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static x f18802c;

    /* JADX INFO: compiled from: BUGLY */
    class a extends Thread {
        private int b = 4;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private v f18803c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f18804d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ContentValues f18805e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f18806f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String[] f18807g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f18808h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String[] f18809i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f18810j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f18811k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f18812l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f18813m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f18814n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String[] f18815o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f18816p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f18817q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private byte[] f18818r;

        public a() {
        }

        public final void a(int i2, String str, byte[] bArr) {
            this.f18816p = i2;
            this.f18817q = str;
            this.f18818r = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.b) {
                case 1:
                    w.this.a(this.f18804d, this.f18805e, this.f18803c);
                    break;
                case 2:
                    w.this.a(this.f18804d, this.f18814n, this.f18815o, this.f18803c);
                    break;
                case 3:
                    Cursor cursorA = w.this.a(this.f18806f, this.f18804d, this.f18807g, this.f18808h, this.f18809i, this.f18810j, this.f18811k, this.f18812l, this.f18813m, this.f18803c);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    break;
                case 4:
                    w.this.a(this.f18816p, this.f18817q, this.f18818r, this.f18803c);
                    break;
                case 5:
                    w.this.a(this.f18816p, this.f18803c);
                    break;
                case 6:
                    w.this.a(this.f18816p, this.f18817q, this.f18803c);
                    break;
            }
        }
    }

    private w(Context context, List<o> list) {
        f18802c = new x(context, list);
    }

    private synchronized boolean b(y yVar) {
        ContentValues contentValuesD;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f18802c.getWritableDatabase();
            if (writableDatabase == null || (contentValuesD = d(yVar)) == null) {
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", "_id", contentValuesD);
            if (jReplace >= 0) {
                al.c("[Database] insert %s success.", "t_pf");
                yVar.a = jReplace;
                return true;
            }
            if (a && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    private static ContentValues c(y yVar) {
        if (yVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (yVar.a > 0) {
                contentValues.put("_id", Long.valueOf(yVar.a));
            }
            contentValues.put(com.umeng.analytics.pro.aq.f19513e, Integer.valueOf(yVar.b));
            contentValues.put("_pc", yVar.f18821c);
            contentValues.put("_th", yVar.f18822d);
            contentValues.put("_tm", Long.valueOf(yVar.f18823e));
            if (yVar.f18825g != null) {
                contentValues.put("_dt", yVar.f18825g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(y yVar) {
        if (yVar != null && !ap.a(yVar.f18824f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (yVar.a > 0) {
                    contentValues.put("_id", Long.valueOf(yVar.a));
                }
                contentValues.put(com.umeng.analytics.pro.aq.f19513e, yVar.f18824f);
                contentValues.put("_tm", Long.valueOf(yVar.f18823e));
                if (yVar.f18825g != null) {
                    contentValues.put("_dt", yVar.f18825g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized w a(Context context, List<o> list) {
        if (b == null) {
            b = new w(context, list);
        }
        return b;
    }

    public static synchronized w a() {
        return b;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(str, strArr, str2, (String) null, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b0 A[Catch: all -> 0x00b4, PHI: r1
  0x00b0: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:57:0x00cb, B:43:0x00ae] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {, blocks: (B:9:0x0025, B:10:0x0028, B:13:0x002e, B:30:0x0097, B:31:0x009a, B:34:0x00a0, B:54:0x00c4, B:55:0x00c7, B:44:0x00b0, B:63:0x00d3, B:64:0x00d6, B:67:0x00dc, B:68:0x00df, B:41:0x00aa, B:50:0x00b9, B:52:0x00bf), top: B:77:0x0002, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.y> c(int r12) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.c(int):java.util.List");
    }

    public final Cursor a(String str, String[] strArr, String str2, String str3, String str4) {
        return a(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    public final int a(String str, String str2) {
        return a(str, str2, (String[]) null, (v) null);
    }

    public final synchronized long a(String str, ContentValues contentValues, v vVar) {
        long j2;
        SQLiteDatabase writableDatabase = null;
        j2 = -1;
        try {
            writableDatabase = f18802c.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, "_id", contentValues);
                if (jReplace >= 0) {
                    al.c("[Database] insert %s success.", str);
                } else {
                    al.d("[Database] replace %s error.", str);
                }
                j2 = jReplace;
            }
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (vVar != null) {
                    Long.valueOf(-1L);
                }
                if (a && 0 != 0) {
                }
            } finally {
                if (vVar != null) {
                    Long.valueOf(-1L);
                }
                if (a && 0 != 0) {
                    writableDatabase.close();
                }
            }
        }
        return j2;
    }

    public final synchronized void b(int i2) {
        String strConcat;
        SQLiteDatabase writableDatabase = f18802c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                try {
                    strConcat = "_tp = ".concat(String.valueOf(i2));
                } catch (Throwable th) {
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (a && writableDatabase != null) {
                            writableDatabase.close();
                            return;
                        }
                    } finally {
                        if (a && writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                strConcat = null;
            }
            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", strConcat, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z2, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, v vVar) {
        Cursor cursorQuery;
        cursorQuery = null;
        try {
            SQLiteDatabase writableDatabase = f18802c.getWritableDatabase();
            if (writableDatabase != null) {
                cursorQuery = writableDatabase.query(z2, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
        }
        return cursorQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, v vVar) {
        int iDelete;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f18802c.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (vVar != null) {
                    Integer.valueOf(0);
                }
                if (a && writableDatabase != null) {
                }
            } finally {
                if (vVar != null) {
                    Integer.valueOf(0);
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
        return iDelete;
    }

    private static y b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.f18823e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f18824f = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.aq.f19513e));
            yVar.f18825g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final boolean a(int i2, String str, byte[] bArr, boolean z2) {
        if (!z2) {
            a aVar = new a();
            aVar.a(i2, str, bArr);
            ak.a().a(aVar);
            return true;
        }
        return a(i2, str, bArr, (v) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str, byte[] bArr, v vVar) {
        try {
            y yVar = new y();
            yVar.a = i2;
            yVar.f18824f = str;
            yVar.f18823e = System.currentTimeMillis();
            yVar.f18825g = bArr;
            boolean zB = b(yVar);
            if (vVar == null) {
                return zB;
            }
            Boolean.valueOf(zB);
            return zB;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
                if (vVar != null) {
                    Boolean bool = Boolean.FALSE;
                }
            }
        }
    }

    public final Map<String, byte[]> a(int i2, v vVar) {
        HashMap map = null;
        try {
            List<y> listC = c(i2);
            if (listC == null) {
                return null;
            }
            HashMap map2 = new HashMap();
            try {
                for (y yVar : listC) {
                    byte[] bArr = yVar.f18825g;
                    if (bArr != null) {
                        map2.put(yVar.f18824f, bArr);
                    }
                }
                return map2;
            } catch (Throwable th) {
                th = th;
                map = map2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (al.a(th)) {
            return map;
        }
        th.printStackTrace();
        return map;
    }

    public final synchronized boolean a(y yVar) {
        ContentValues contentValuesC;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f18802c.getWritableDatabase();
            if (writableDatabase != null && (contentValuesC = c(yVar)) != null) {
                long jReplace = writableDatabase.replace("t_lr", "_id", contentValuesC);
                if (jReplace >= 0) {
                    al.c("[Database] insert %s success.", "t_lr");
                    yVar.a = jReplace;
                    return true;
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            if (a && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b1 A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #0 {all -> 0x00c3, blocks: (B:43:0x00ab, B:45:0x00b1), top: B:67:0x00ab, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b6 A[Catch: all -> 0x00d5, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:14:0x002e, B:15:0x0031, B:18:0x0037, B:35:0x009c, B:36:0x009f, B:39:0x00a5, B:47:0x00b6, B:48:0x00b9, B:51:0x00bf, B:54:0x00c6, B:55:0x00c9, B:58:0x00cf, B:59:0x00d2, B:43:0x00ab, B:45:0x00b1), top: B:69:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.y> a(int r11) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int):java.util.List");
    }

    public final synchronized void a(List<y> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f18802c.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (y yVar : list) {
                        sb.append(" or _id = ");
                        sb.append(yVar.a);
                    }
                    String string = sb.toString();
                    if (string.length() > 0) {
                        string = string.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string, null)));
                    } catch (Throwable th) {
                        try {
                            if (!al.a(th)) {
                                th.printStackTrace();
                            }
                            if (a) {
                                writableDatabase.close();
                            }
                        } finally {
                            if (a) {
                                writableDatabase.close();
                            }
                        }
                    }
                }
            }
        }
    }

    private static y a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.b = cursor.getInt(cursor.getColumnIndex(com.umeng.analytics.pro.aq.f19513e));
            yVar.f18821c = cursor.getString(cursor.getColumnIndex("_pc"));
            yVar.f18822d = cursor.getString(cursor.getColumnIndex("_th"));
            yVar.f18823e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f18825g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i2, String str, v vVar) {
        boolean z2;
        SQLiteDatabase writableDatabase;
        String strConcat;
        z2 = false;
        try {
            writableDatabase = f18802c.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (ap.a(str)) {
                        strConcat = "_id = ".concat(String.valueOf(i2));
                    } else {
                        strConcat = "_id = " + i2 + " and _tp = \"" + str + "\"";
                    }
                    int iDelete = writableDatabase.delete("t_pf", strConcat, null);
                    al.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(iDelete));
                    if (iDelete > 0) {
                        z2 = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (vVar != null) {
                            Boolean bool = Boolean.FALSE;
                        }
                        if (a && writableDatabase != null) {
                        }
                        return z2;
                    } catch (Throwable th2) {
                        if (vVar != null) {
                            Boolean bool2 = Boolean.FALSE;
                        }
                        if (a && writableDatabase != null) {
                            writableDatabase.close();
                        }
                        throw th2;
                    }
                }
            }
            if (vVar != null) {
                Boolean.valueOf(z2);
            }
        } catch (Throwable th3) {
            th = th3;
            writableDatabase = null;
        }
        if (a && writableDatabase != null) {
            writableDatabase.close();
        }
        return z2;
    }
}
