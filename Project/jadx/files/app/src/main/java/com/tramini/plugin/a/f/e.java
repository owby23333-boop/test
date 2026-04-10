package com.tramini.plugin.a.f;

import android.content.ContentValues;
import android.database.Cursor;

/* JADX INFO: loaded from: classes3.dex */
public class e extends a<com.tramini.plugin.a.g.d> {
    private static e b;

    e(b bVar) {
        super(bVar);
    }

    public static e a(b bVar) {
        if (b == null) {
            b = new e(bVar);
        }
        return b;
    }

    public final synchronized long b(com.tramini.plugin.a.g.d dVar) {
        if (b() == null || dVar == null) {
            return -1L;
        }
        try {
            return b().delete("il", "id= ?", new String[]{dVar.f19340s});
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063 A[Catch: all -> 0x0067, PHI: r1
  0x0063: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:21:0x0061, B:18:0x005d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:14:0x0056, B:22:0x0063), top: B:31:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.Map<java.lang.String, com.tramini.plugin.a.g.d> c() {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.a()     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "il"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L5d
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L5b
            if (r2 <= 0) goto L5d
            java.util.HashMap r2 = new java.util.HashMap     // Catch: java.lang.Throwable -> L5b
            r2.<init>()     // Catch: java.lang.Throwable -> L5b
        L1f:
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L54
            com.tramini.plugin.a.g.d r3 = new com.tramini.plugin.a.g.d     // Catch: java.lang.Throwable -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "id"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L5b
            r3.f19340s = r4     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "value"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L5b
            r3.f19341t = r4     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "time"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L5b
            long r4 = r1.getLong(r4)     // Catch: java.lang.Throwable -> L5b
            r3.f19342u = r4     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = r3.f19340s     // Catch: java.lang.Throwable -> L5b
            r2.put(r4, r3)     // Catch: java.lang.Throwable -> L5b
            goto L1f
        L54:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.lang.Throwable -> L67
        L59:
            monitor-exit(r9)
            return r2
        L5b:
            goto L61
        L5d:
            if (r1 == 0) goto L6a
            goto L63
        L60:
            r1 = r0
        L61:
            if (r1 == 0) goto L6a
        L63:
            r1.close()     // Catch: java.lang.Throwable -> L67
            goto L6a
        L67:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L6a:
            monitor-exit(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.f.e.c():java.util.Map");
    }

    public synchronized long a(com.tramini.plugin.a.g.d dVar) {
        if (b() == null || dVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", dVar.f19340s);
            contentValues.put("value", dVar.f19341t);
            contentValues.put("time", Long.valueOf(dVar.f19342u));
            if (a(dVar.f19340s)) {
                return b().update("il", contentValues, "id = ? ", new String[]{dVar.f19340s});
            }
            return b().insert("il", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    protected final boolean a(String str) {
        Cursor cursorQuery = a().query("il", new String[]{"id"}, "id = ? ", new String[]{str}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }
}
