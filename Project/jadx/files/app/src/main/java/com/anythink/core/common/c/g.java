package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.o;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.anythink.core.common.c.a<o> {
    private static final String b = "com.anythink.core.common.c.g";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static g f7021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7022d;

    public static class a {
        public static final String a = "request_info";
        public static final String b = "id";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7023c = "req_type";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7024d = "req_url";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f7025e = "req_head";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7026f = "req_content";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f7027g = "time";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f7028h = "extra";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f7029i = "CREATE TABLE IF NOT EXISTS request_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, req_content TEXT, time INTEGER, extra TEXT )";
    }

    private g(b bVar) {
        super(bVar);
        this.f7022d = 1000;
    }

    public static g a(b bVar) {
        if (f7021c == null) {
            synchronized (g.class) {
                if (f7021c == null) {
                    f7021c = new g(bVar);
                }
            }
        }
        return f7021c;
    }

    private synchronized void d() {
        try {
            if (b() == null) {
                return;
            }
            b().delete(a.a, null, null);
        } catch (Exception unused) {
        }
    }

    public final synchronized int b(o oVar) {
        if (b() == null || oVar == null) {
            return -1;
        }
        try {
            return b().delete(a.a, "id=?", new String[]{oVar.a});
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4 A[Catch: all -> 0x00b3, PHI: r1
  0x00a4: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:24:0x009b, B:28:0x00a2, B:35:0x00b0] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {, blocks: (B:14:0x008a, B:20:0x0095, B:29:0x00a4, B:32:0x00ab, B:33:0x00ae, B:27:0x009f), top: B:43:0x0002, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.anythink.core.common.e.o> c() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.a()     // Catch: java.lang.Throwable -> L9a java.lang.OutOfMemoryError -> L9e java.lang.Exception -> Laf
            java.lang.String r2 = "request_info"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "time"
            java.lang.String r9 = "10"
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L9a java.lang.OutOfMemoryError -> L9e java.lang.Exception -> Laf
            if (r1 == 0) goto L93
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            if (r2 <= 0) goto L93
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r2.<init>()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
        L22:
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            if (r3 == 0) goto L85
            com.anythink.core.common.e.o r3 = new com.anythink.core.common.e.o     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = "id"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r3.a = r4     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = "req_type"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            int r4 = r1.getInt(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r3.b = r4     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = "req_url"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r3.f7372d = r4     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = "req_head"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r3.f7371c = r4     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = "req_content"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r3.f7373e = r4     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = "time"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            long r4 = r1.getLong(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r3.f7374f = r4     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = "extra"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r3.f7375g = r4     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            r2.add(r3)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            goto L22
        L85:
            r1.close()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91 java.lang.OutOfMemoryError -> L9f
            if (r1 == 0) goto L8d
            r1.close()     // Catch: java.lang.Throwable -> Lb3
        L8d:
            monitor-exit(r10)
            return r2
        L8f:
            goto L9b
        L91:
            goto Lb0
        L93:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.lang.Throwable -> Lb3
        L98:
            monitor-exit(r10)
            return r0
        L9a:
            r1 = r0
        L9b:
            if (r1 == 0) goto Lb6
            goto Lb2
        L9e:
            r1 = r0
        L9f:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> La8
            if (r1 == 0) goto Lb6
        La4:
            r1.close()     // Catch: java.lang.Throwable -> Lb3
            goto Lb6
        La8:
            r0 = move-exception
            if (r1 == 0) goto Lae
            r1.close()     // Catch: java.lang.Throwable -> Lb3
        Lae:
            throw r0     // Catch: java.lang.Throwable -> Lb3
        Laf:
            r1 = r0
        Lb0:
            if (r1 == 0) goto Lb6
        Lb2:
            goto La4
        Lb3:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        Lb6:
            monitor-exit(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.g.c():java.util.List");
    }

    public final synchronized long a(o oVar) {
        Cursor cursorQuery;
        if (b() == null) {
            return -1L;
        }
        Cursor cursor = null;
        try {
            cursorQuery = a().query(a.a, null, null, null, null, null, null);
            try {
                if (cursorQuery.getCount() >= this.f7022d) {
                    d();
                }
            } catch (Exception unused) {
                if (cursorQuery != null) {
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", oVar.a);
                contentValues.put("req_type", Integer.valueOf(oVar.b));
                contentValues.put("req_url", oVar.f7372d);
                contentValues.put("req_head", oVar.f7371c);
                contentValues.put(a.f7026f, oVar.f7373e);
                contentValues.put("time", Long.valueOf(oVar.f7374f));
                contentValues.put("extra", oVar.f7375g);
                return b().insert(a.a, null, contentValues);
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Exception unused4) {
            }
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("id", oVar.a);
            contentValues2.put("req_type", Integer.valueOf(oVar.b));
            contentValues2.put("req_url", oVar.f7372d);
            contentValues2.put("req_head", oVar.f7371c);
            contentValues2.put(a.f7026f, oVar.f7373e);
            contentValues2.put("time", Long.valueOf(oVar.f7374f));
            contentValues2.put("extra", oVar.f7375g);
            return b().insert(a.a, null, contentValues2);
        } catch (Exception unused5) {
            return -1L;
        }
    }
}
