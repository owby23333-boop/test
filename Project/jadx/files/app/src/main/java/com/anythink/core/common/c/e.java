package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.anythink.core.common.c.a<com.anythink.core.common.a.e> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f7008c;
    private final String b;

    public static class a {
        public static final String a = "dsp_offer_install_record";
        public static final String b = "dsp_id";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7009c = "dsp_offer_id";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7010d = "package_name";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f7011e = "last_update_time";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7012f = "CREATE TABLE IF NOT EXISTS dsp_offer_install_record(dsp_id TEXT ,dsp_offer_id TEXT ,package_name TEXT ,last_update_time INTEGER)";
    }

    private e(b bVar) {
        super(bVar);
        this.b = e.class.getName();
    }

    public static e a(b bVar) {
        if (f7008c == null) {
            synchronized (e.class) {
                if (f7008c == null) {
                    f7008c = new e(bVar);
                }
            }
        }
        return f7008c;
    }

    public final synchronized long a(com.anythink.core.common.a.e eVar) {
        if (b() == null) {
            return -1L;
        }
        if (!a(eVar.a(), eVar.b())) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("dsp_id", eVar.a());
                contentValues.put("dsp_offer_id", eVar.b());
                contentValues.put("package_name", eVar.c());
                contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                StringBuilder sb = new StringBuilder("insertDspOfferInstallRecord--insert,dspid:");
                sb.append(eVar.a());
                sb.append(",dspoferrId:");
                sb.append(eVar.b());
                sb.append(",packagename:");
                sb.append(eVar.c());
                return b().insert(a.a, null, contentValues);
            } catch (Exception unused) {
            }
        } else {
            StringBuilder sb2 = new StringBuilder("insertDspOfferInstallRecord--had inserted...,dspid:");
            sb2.append(eVar.a());
            sb2.append(",dspoferrId:");
            sb2.append(eVar.b());
            sb2.append(",packagename:");
            sb2.append(eVar.c());
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[Catch: all -> 0x0044, PHI: r0
  0x0036: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:14:0x002e, B:17:0x0034, B:23:0x0041] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {, blocks: (B:9:0x0025, B:18:0x0036, B:21:0x003d, B:22:0x0040, B:16:0x0031), top: B:30:0x0003, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean a(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.a()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c java.lang.OutOfMemoryError -> L31
            java.lang.String r3 = "dsp_offer_install_record"
            r4 = 0
            java.lang.String r5 = "dsp_id = ?  AND dsp_offer_id = ? "
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c java.lang.OutOfMemoryError -> L31
            r6[r1] = r11     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c java.lang.OutOfMemoryError -> L31
            r11 = 1
            r6[r11] = r12     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c java.lang.OutOfMemoryError -> L31
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c java.lang.OutOfMemoryError -> L31
            int r12 = r0.getCount()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c java.lang.OutOfMemoryError -> L31
            if (r12 <= 0) goto L22
            goto L23
        L22:
            r11 = 0
        L23:
            if (r0 == 0) goto L28
            r0.close()     // Catch: java.lang.Throwable -> L44
        L28:
            monitor-exit(r10)
            return r11
        L2a:
            goto L2e
        L2c:
            goto L41
        L2e:
            if (r0 == 0) goto L47
            goto L43
        L31:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L47
        L36:
            r0.close()     // Catch: java.lang.Throwable -> L44
            goto L47
        L3a:
            r11 = move-exception
            if (r0 == 0) goto L40
            r0.close()     // Catch: java.lang.Throwable -> L44
        L40:
            throw r11     // Catch: java.lang.Throwable -> L44
        L41:
            if (r0 == 0) goto L47
        L43:
            goto L36
        L44:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        L47:
            monitor-exit(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.e.a(java.lang.String, java.lang.String):boolean");
    }

    public final synchronized List<com.anythink.core.common.a.d> a(int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 <= 0) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query(a.a, null, null, null, null, null, "last_update_time DESC", String.valueOf(i2));
                List<com.anythink.core.common.a.e> listA = a(cursorQuery);
                new StringBuilder("get limit install record list size:").append(listA.size());
                arrayList.addAll(listA);
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
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private synchronized List<com.anythink.core.common.a.e> a(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    try {
                        com.anythink.core.common.a.e eVar = new com.anythink.core.common.a.e();
                        eVar.a(cursor.getString(cursor.getColumnIndex("dsp_id")));
                        eVar.b(cursor.getString(cursor.getColumnIndex("dsp_offer_id")));
                        eVar.c(cursor.getString(cursor.getColumnIndex("package_name")));
                        arrayList.add(eVar);
                    } catch (Throwable unused) {
                    }
                }
                cursor.close();
            }
        }
        return arrayList;
    }
}
