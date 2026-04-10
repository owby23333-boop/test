package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.p;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.anythink.core.common.c.a<p> {
    private static final String b = "com.anythink.core.common.c.h";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile h f7030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7031d;

    public static class a {
        public static final String a = "inspect_info";
        public static final String b = "inspect_id";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7032c = "update_time";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7033d = "CREATE TABLE IF NOT EXISTS inspect_info(inspect_id TEXT, update_time INTEGER )";
    }

    private h(b bVar) {
        super(bVar);
        this.f7031d = 100;
    }

    public static h a(b bVar) {
        if (f7030c == null) {
            synchronized (h.class) {
                if (f7030c == null) {
                    f7030c = new h(bVar);
                }
            }
        }
        return f7030c;
    }

    private synchronized boolean b(String str) {
        if (str == null) {
            return false;
        }
        Cursor cursorQuery = a().query(a.a, new String[]{a.b}, "inspect_id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[Catch: all -> 0x0053, DONT_GENERATE, PHI: r0 r1
  0x003f: PHI (r0v6 android.database.Cursor) = 
  (r0v2 android.database.Cursor)
  (r0v3 android.database.Cursor)
  (r0v4 android.database.Cursor)
  (r0v9 android.database.Cursor)
 binds: [B:14:0x003d, B:18:0x0046, B:24:0x0050, B:12:0x003a] A[DONT_GENERATE, DONT_INLINE]
  0x003f: PHI (r1v5 long) = (r1v2 long), (r1v3 long), (r1v4 long), (r1v8 long) binds: [B:14:0x003d, B:18:0x0046, B:24:0x0050, B:12:0x003a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:15:0x003f, B:22:0x004c, B:23:0x004f, B:17:0x0043), top: B:37:0x0004, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void c() {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 0
            r1 = -1
            android.database.sqlite.SQLiteDatabase r3 = r12.a()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            java.lang.String r4 = "inspect_info"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "update_time DESC"
            int r11 = r12.f7031d     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            if (r0 == 0) goto L3a
            int r3 = r0.getCount()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            int r4 = r12.f7031d     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            if (r3 < r4) goto L3a
            r0.moveToLast()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            java.lang.String r3 = "update_time"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            long r1 = r0.getLong(r3)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            r0.close()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L43
            goto L3a
        L36:
            goto L3d
        L38:
            goto L50
        L3a:
            if (r0 == 0) goto L56
            goto L52
        L3d:
            if (r0 == 0) goto L56
        L3f:
            r0.close()     // Catch: java.lang.Throwable -> L53
            goto L56
        L43:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L56
            goto L52
        L49:
            r1 = move-exception
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.lang.Throwable -> L53
        L4f:
            throw r1     // Catch: java.lang.Throwable -> L53
        L50:
            if (r0 == 0) goto L56
        L52:
            goto L3f
        L53:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        L56:
            r3 = 0
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L73
            android.database.sqlite.SQLiteDatabase r0 = r12.b()     // Catch: java.lang.Throwable -> L73
            java.lang.String r3 = "inspect_info"
            java.lang.String r4 = "update_time<?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L73
            r6 = 0
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L73
            r5[r6] = r1     // Catch: java.lang.Throwable -> L73
            r0.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L73
            monitor-exit(r12)
            return
        L73:
            monitor-exit(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.h.c():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0068 A[Catch: all -> 0x0077, PHI: r1
  0x0068: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:24:0x005f, B:28:0x0066, B:35:0x0074] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {, blocks: (B:14:0x004e, B:20:0x0059, B:29:0x0068, B:32:0x006f, B:33:0x0072, B:27:0x0063), top: B:43:0x0002, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.anythink.core.common.e.p> d() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.a()     // Catch: java.lang.Throwable -> L5e java.lang.OutOfMemoryError -> L62 java.lang.Exception -> L73
            java.lang.String r2 = "inspect_info"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5e java.lang.OutOfMemoryError -> L62 java.lang.Exception -> L73
            if (r1 == 0) goto L57
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            if (r2 <= 0) goto L57
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            r2.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
        L20:
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            if (r3 == 0) goto L49
            com.anythink.core.common.e.p r3 = new com.anythink.core.common.e.p     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            r3.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            java.lang.String r4 = "inspect_id"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            java.lang.String r5 = "update_time"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            long r5 = r1.getLong(r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            r3.a(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            r3.a(r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            r2.add(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            goto L20
        L49:
            r1.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55 java.lang.OutOfMemoryError -> L63
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.lang.Throwable -> L77
        L51:
            monitor-exit(r10)
            return r2
        L53:
            goto L5f
        L55:
            goto L74
        L57:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.lang.Throwable -> L77
        L5c:
            monitor-exit(r10)
            return r0
        L5e:
            r1 = r0
        L5f:
            if (r1 == 0) goto L7a
            goto L76
        L62:
            r1 = r0
        L63:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L7a
        L68:
            r1.close()     // Catch: java.lang.Throwable -> L77
            goto L7a
        L6c:
            r0 = move-exception
            if (r1 == 0) goto L72
            r1.close()     // Catch: java.lang.Throwable -> L77
        L72:
            throw r0     // Catch: java.lang.Throwable -> L77
        L73:
            r1 = r0
        L74:
            if (r1 == 0) goto L7a
        L76:
            goto L68
        L77:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L7a:
            monitor-exit(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.h.d():java.util.List");
    }

    public final synchronized long a(String str) {
        if (b() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.b, str);
            contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
            if (b(str)) {
                return b().update(a.a, contentValues, "inspect_id = ? ", new String[]{str});
            }
            return b().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }
}
