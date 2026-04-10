package com.tramini.plugin.a.f;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes3.dex */
public class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f19335c;

    private c(b bVar) {
        super(bVar);
    }

    public static c b(b bVar) {
        if (f19335c == null) {
            f19335c = new c(bVar);
        }
        return f19335c;
    }

    @Override // com.tramini.plugin.a.f.e
    public final synchronized long a(com.tramini.plugin.a.g.d dVar) {
        if (b() == null || dVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", dVar.f19340s);
            contentValues.put("value", dVar.f19341t);
            contentValues.put("time", Long.valueOf(dVar.f19342u));
            if (a(dVar.f19340s)) {
                return b().update("il_all", contentValues, "id = ? ", new String[]{dVar.f19340s});
            }
            return b().insert("il_all", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061 A[Catch: all -> 0x0065, PHI: r1
  0x0061: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:21:0x005f, B:18:0x005b] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:14:0x0054, B:22:0x0061), top: B:29:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.Set<com.tramini.plugin.a.g.d> d() {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.a()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r2 = "il_all"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5e
            if (r1 == 0) goto L5b
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L59
            if (r2 <= 0) goto L5b
            java.util.HashSet r2 = new java.util.HashSet     // Catch: java.lang.Throwable -> L59
            r2.<init>()     // Catch: java.lang.Throwable -> L59
        L1f:
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L52
            com.tramini.plugin.a.g.d r3 = new com.tramini.plugin.a.g.d     // Catch: java.lang.Throwable -> L59
            r3.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = "id"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L59
            r3.f19340s = r4     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = "value"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L59
            r3.f19341t = r4     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = "time"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L59
            long r4 = r1.getLong(r4)     // Catch: java.lang.Throwable -> L59
            r3.f19342u = r4     // Catch: java.lang.Throwable -> L59
            r2.add(r3)     // Catch: java.lang.Throwable -> L59
            goto L1f
        L52:
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.lang.Throwable -> L65
        L57:
            monitor-exit(r9)
            return r2
        L59:
            goto L5f
        L5b:
            if (r1 == 0) goto L68
            goto L61
        L5e:
            r1 = r0
        L5f:
            if (r1 == 0) goto L68
        L61:
            r1.close()     // Catch: java.lang.Throwable -> L65
            goto L68
        L65:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L68:
            monitor-exit(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.f.c.d():java.util.Set");
    }

    public final synchronized long e() {
        if (b() == null) {
            return -1L;
        }
        try {
            return b().delete("il_all", null, null);
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
