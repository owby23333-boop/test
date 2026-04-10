package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.e.ae;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class l extends com.anythink.core.common.c.a<ae> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile l f7054c;
    private final String b;

    public static class a {
        public static final String a = "placement_ad_impression";
        public static final String b = "format";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7055c = "placement_id";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7056d = "adsource_id";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f7057e = "hour_time";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7058f = "hour_imp";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f7059g = "date_time";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f7060h = "date_imp";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f7061i = "show_time";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f7062j = "CREATE TABLE IF NOT EXISTS placement_ad_impression(format INTEGER ,placement_id TEXT ,adsource_id TEXT ,hour_time TEXT ,hour_imp INTEGER ,date_time TEXT ,date_imp INTEGER , show_time INTEGER)";
    }

    private l(b bVar) {
        super(bVar);
        this.b = l.class.getName();
    }

    public static l a(b bVar) {
        if (f7054c == null) {
            synchronized (l.class) {
                if (f7054c == null) {
                    f7054c = new l(bVar);
                }
            }
        }
        return f7054c;
    }

    private boolean b(String str) {
        Cursor cursorQuery = a().query(a.a, new String[]{"adsource_id"}, "adsource_id=?", new String[]{str}, "adsource_id", null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    private static ae.a b(Cursor cursor, String str, String str2) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        cursor.moveToNext();
        ae.a aVar = new ae.a();
        aVar.a = cursor.getString(cursor.getColumnIndex("adsource_id"));
        aVar.b = cursor.getString(cursor.getColumnIndex(a.f7057e));
        aVar.f7143c = cursor.getString(cursor.getColumnIndex(a.f7059g));
        if (!TextUtils.equals(aVar.b, str2)) {
            aVar.f7145e = 0;
        } else {
            aVar.f7145e = cursor.getInt(cursor.getColumnIndex(a.f7058f));
        }
        if (!TextUtils.equals(aVar.f7143c, str)) {
            aVar.f7144d = 0;
        } else {
            aVar.f7144d = cursor.getInt(cursor.getColumnIndex(a.f7060h));
        }
        aVar.f7146f = cursor.getLong(cursor.getColumnIndex("show_time"));
        return aVar;
    }

    public final synchronized Map<String, ae> a(int i2, String str, String str2) {
        HashMap map = new HashMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query(a.a, null, "format=?", new String[]{String.valueOf(i2)}, null, null, null);
            } catch (Exception unused) {
                if (cursorQuery != null) {
                }
            } catch (OutOfMemoryError unused2) {
                System.gc();
                if (cursorQuery != null) {
                }
            } catch (Throwable unused3) {
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                if (cursorQuery != null) {
                }
                return map;
            }
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(a.f7055c));
                ae aeVar = (ae) map.get(string);
                if (aeVar == null) {
                    aeVar = new ae();
                    aeVar.b = string;
                    aeVar.a = cursorQuery.getInt(cursorQuery.getColumnIndex("format"));
                    aeVar.f7142f = new ConcurrentHashMap<>();
                    map.put(string, aeVar);
                }
                ae.a aVar = new ae.a();
                aVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("adsource_id"));
                aVar.b = cursorQuery.getString(cursorQuery.getColumnIndex(a.f7057e));
                aVar.f7143c = cursorQuery.getString(cursorQuery.getColumnIndex(a.f7059g));
                if (!TextUtils.equals(aVar.b, str2)) {
                    aVar.f7145e = 0;
                } else {
                    aVar.f7145e = cursorQuery.getInt(cursorQuery.getColumnIndex(a.f7058f));
                }
                aeVar.f7140d += aVar.f7145e;
                if (!TextUtils.equals(aVar.f7143c, str)) {
                    aVar.f7144d = 0;
                } else {
                    aVar.f7144d = cursorQuery.getInt(cursorQuery.getColumnIndex(a.f7060h));
                }
                aeVar.f7139c += aVar.f7144d;
                aVar.f7146f = cursorQuery.getLong(cursorQuery.getColumnIndex("show_time"));
                if (aVar.f7146f >= aeVar.f7141e) {
                    aeVar.f7141e = aVar.f7146f;
                }
                aeVar.f7142f.put(aVar.a, aVar);
            }
            cursorQuery.close();
            return map;
            cursorQuery.close();
            return map;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea A[Catch: all -> 0x00f9, PHI: r11
  0x00ea: PHI (r11v7 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v6 android.database.Cursor), (r11v8 android.database.Cursor) binds: [B:32:0x00e1, B:36:0x00e8, B:43:0x00f6] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #4 {, blocks: (B:28:0x00db, B:37:0x00ea, B:40:0x00f1, B:41:0x00f4, B:35:0x00e5), top: B:51:0x0002, inners: #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.anythink.core.common.e.ae a(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.l.a(java.lang.String, java.lang.String, java.lang.String):com.anythink.core.common.e.ae");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0 A[Catch: all -> 0x00af, PHI: r11
  0x00a0: PHI (r11v7 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v6 android.database.Cursor), (r11v8 android.database.Cursor) binds: [B:26:0x0097, B:30:0x009e, B:37:0x00ac] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #7 {, blocks: (B:22:0x0091, B:31:0x00a0, B:34:0x00a7, B:35:0x00aa, B:29:0x009b), top: B:47:0x0002, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.anythink.core.common.e.ae.a a(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.a()     // Catch: java.lang.Throwable -> L96 java.lang.OutOfMemoryError -> L9a java.lang.Exception -> Lab
            java.lang.String r2 = "placement_ad_impression"
            r3 = 0
            java.lang.String r4 = "adsource_id=? AND placement_id=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L96 java.lang.OutOfMemoryError -> L9a java.lang.Exception -> Lab
            r9 = 0
            r5[r9] = r12     // Catch: java.lang.Throwable -> L96 java.lang.OutOfMemoryError -> L9a java.lang.Exception -> Lab
            r12 = 1
            r5[r12] = r11     // Catch: java.lang.Throwable -> L96 java.lang.OutOfMemoryError -> L9a java.lang.Exception -> Lab
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L96 java.lang.OutOfMemoryError -> L9a java.lang.Exception -> Lab
            if (r11 == 0) goto L8e
            int r12 = r11.getCount()     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            if (r12 <= 0) goto L8e
            r11.moveToNext()     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            com.anythink.core.common.e.ae$a r12 = new com.anythink.core.common.e.ae$a     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            r12.<init>()     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            java.lang.String r1 = "adsource_id"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            java.lang.String r1 = r11.getString(r1)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            r12.a = r1     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            java.lang.String r1 = "hour_time"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            java.lang.String r1 = r11.getString(r1)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            r12.b = r1     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            java.lang.String r1 = "date_time"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            java.lang.String r1 = r11.getString(r1)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            r12.f7143c = r1     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            java.lang.String r1 = r12.b     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            boolean r14 = android.text.TextUtils.equals(r1, r14)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            if (r14 != 0) goto L5a
            r12.f7145e = r9     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            goto L66
        L5a:
            java.lang.String r14 = "hour_imp"
            int r14 = r11.getColumnIndex(r14)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            int r14 = r11.getInt(r14)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            r12.f7145e = r14     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
        L66:
            java.lang.String r14 = r12.f7143c     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            boolean r13 = android.text.TextUtils.equals(r14, r13)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            if (r13 != 0) goto L71
            r12.f7144d = r9     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            goto L7d
        L71:
            java.lang.String r13 = "date_imp"
            int r13 = r11.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            int r13 = r11.getInt(r13)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            r12.f7144d = r13     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
        L7d:
            java.lang.String r13 = "show_time"
            int r13 = r11.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            long r13 = r11.getLong(r13)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            r12.f7146f = r13     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c java.lang.OutOfMemoryError -> L9b
            goto L8f
        L8a:
            goto L97
        L8c:
            goto Lac
        L8e:
            r12 = r0
        L8f:
            if (r11 == 0) goto L94
            r11.close()     // Catch: java.lang.Throwable -> Laf
        L94:
            monitor-exit(r10)
            return r12
        L96:
            r11 = r0
        L97:
            if (r11 == 0) goto Lb2
            goto Lae
        L9a:
            r11 = r0
        L9b:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> La4
            if (r11 == 0) goto Lb2
        La0:
            r11.close()     // Catch: java.lang.Throwable -> Laf
            goto Lb2
        La4:
            r12 = move-exception
            if (r11 == 0) goto Laa
            r11.close()     // Catch: java.lang.Throwable -> Laf
        Laa:
            throw r12     // Catch: java.lang.Throwable -> Laf
        Lab:
            r11 = r0
        Lac:
            if (r11 == 0) goto Lb2
        Lae:
            goto La0
        Laf:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        Lb2:
            monitor-exit(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.l.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.anythink.core.common.e.ae$a");
    }

    public final synchronized long a(int i2, String str, ae.a aVar) {
        boolean z2;
        if (b() == null || aVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("format", Integer.valueOf(i2));
            contentValues.put(a.f7055c, str);
            contentValues.put("adsource_id", aVar.a);
            contentValues.put(a.f7057e, aVar.b);
            contentValues.put(a.f7058f, Integer.valueOf(aVar.f7145e));
            contentValues.put(a.f7059g, aVar.f7143c);
            contentValues.put(a.f7060h, Integer.valueOf(aVar.f7144d));
            contentValues.put("show_time", Long.valueOf(aVar.f7146f));
            Cursor cursorQuery = a().query(a.a, new String[]{"adsource_id"}, "adsource_id=?", new String[]{aVar.a}, "adsource_id", null, null);
            if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                z2 = false;
            } else {
                cursorQuery.close();
                z2 = true;
            }
            if (z2) {
                return b().update(a.a, contentValues, "adsource_id = ? ", new String[]{aVar.a});
            }
            return b().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static ae a(Cursor cursor, String str, String str2) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        ae aeVar = new ae();
        aeVar.f7142f = new ConcurrentHashMap<>();
        while (cursor.moveToNext()) {
            aeVar.a = cursor.getInt(cursor.getColumnIndex("format"));
            aeVar.b = cursor.getString(cursor.getColumnIndex(a.f7055c));
            ae.a aVar = new ae.a();
            aVar.a = cursor.getString(cursor.getColumnIndex("adsource_id"));
            aVar.b = cursor.getString(cursor.getColumnIndex(a.f7057e));
            aVar.f7143c = cursor.getString(cursor.getColumnIndex(a.f7059g));
            if (!TextUtils.equals(aVar.b, str2)) {
                aVar.f7145e = 0;
            } else {
                aVar.f7145e = cursor.getInt(cursor.getColumnIndex(a.f7058f));
            }
            aeVar.f7140d += aVar.f7145e;
            if (!TextUtils.equals(aVar.f7143c, str)) {
                aVar.f7144d = 0;
            } else {
                aVar.f7144d = cursor.getInt(cursor.getColumnIndex(a.f7060h));
            }
            aeVar.f7139c += aVar.f7144d;
            aVar.f7146f = cursor.getLong(cursor.getColumnIndex("show_time"));
            long j2 = aVar.f7146f;
            if (j2 >= aeVar.f7141e) {
                aeVar.f7141e = j2;
            }
            aeVar.f7142f.put(aVar.a, aVar);
        }
        cursor.close();
        return aeVar;
    }

    public final void a(String str) {
        synchronized (this) {
            try {
                String str2 = "date_time!='" + str + "'";
                if (b() == null) {
                } else {
                    b().delete(a.a, str2, null);
                }
            } catch (Exception unused) {
            }
        }
    }
}
