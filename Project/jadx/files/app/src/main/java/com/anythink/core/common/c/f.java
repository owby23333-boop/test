package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.anythink.core.common.c.a<com.anythink.core.common.a.f> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile f f7013d;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7014c;

    public static class a {
        public static final String a = "dsp_offer_show_record";
        public static final String b = "dsp_id";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7015c = "dsp_offer_id";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7016d = "show_limit";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f7017e = "show_count";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7018f = "create_time";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f7019g = "last_update_time";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f7020h = "CREATE TABLE IF NOT EXISTS dsp_offer_show_record(dsp_id TEXT ,dsp_offer_id TEXT ,show_limit INTEGER ,show_count INTEGER ,create_time INTEGER ,last_update_time INTEGER)";
    }

    private f(b bVar) {
        super(bVar);
        this.b = f.class.getName();
        this.f7014c = 86400000L;
    }

    public static f a(b bVar) {
        if (f7013d == null) {
            synchronized (f.class) {
                if (f7013d == null) {
                    f7013d = new f(bVar);
                }
            }
        }
        return f7013d;
    }

    public final synchronized long b(com.anythink.core.common.a.f fVar) {
        if (b() == null) {
            return -1L;
        }
        if (fVar.c() <= 0) {
            return -1L;
        }
        com.anythink.core.common.a.f fVarA = a(fVar.a(), fVar.b());
        if (fVarA != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("dsp_id", fVar.a());
                contentValues.put("dsp_offer_id", fVar.b());
                contentValues.put(a.f7016d, Integer.valueOf(fVar.c()));
                contentValues.put("show_count", Integer.valueOf(fVarA.d() + 1));
                contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                StringBuilder sb = new StringBuilder("updateDspOfferShowRecord--update dspid:");
                sb.append(fVar.a());
                sb.append(",dspOfferId:");
                sb.append(fVar.b());
                sb.append(",cur show count:");
                sb.append(fVarA.d() + 1);
                sb.append(",limit show cap:");
                sb.append(fVar.c());
                return b().update(a.a, contentValues, "dsp_id = ? and dsp_offer_id = ? ", new String[]{fVar.a(), fVar.b()});
            } catch (Exception unused) {
            }
        }
        return -1L;
    }

    public final void c() {
        try {
            String str = "create_time < " + (System.currentTimeMillis() - 86400000);
            if (b() == null) {
                return;
            }
            b().delete(a.a, str, null);
        } catch (Exception unused) {
        }
    }

    public final synchronized long a(com.anythink.core.common.a.f fVar) {
        if (b() == null) {
            return -1L;
        }
        if (fVar.c() <= 0) {
            return -1L;
        }
        if (a(fVar.a(), fVar.b()) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("dsp_id", fVar.a());
            contentValues.put("dsp_offer_id", fVar.b());
            contentValues.put(a.f7016d, Integer.valueOf(fVar.c()));
            contentValues.put("show_count", (Integer) 0);
            contentValues.put(a.f7018f, Long.valueOf(System.currentTimeMillis()));
            contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
            StringBuilder sb = new StringBuilder("insertDspOfferShowRecord--insert dspid:");
            sb.append(fVar.a());
            sb.append(",dspOfferId:");
            sb.append(fVar.b());
            return b().insert(a.a, null, contentValues);
        }
        StringBuilder sb2 = new StringBuilder("insertDspOfferShowRecord--had inserted...,dspid:");
        sb2.append(fVar.a());
        sb2.append(",dspOfferId:");
        sb2.append(fVar.b());
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: all -> 0x0052, PHI: r11
  0x003c: PHI (r11v8 android.database.Cursor) = 
  (r11v5 android.database.Cursor)
  (r11v6 android.database.Cursor)
  (r11v7 android.database.Cursor)
  (r11v10 android.database.Cursor)
 binds: [B:17:0x003a, B:22:0x0044, B:29:0x004f, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:9:0x002d, B:18:0x003c, B:26:0x004a, B:27:0x004d, B:21:0x0041), top: B:37:0x0002, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized com.anythink.core.common.a.f a(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.a()     // Catch: java.lang.Throwable -> L39 java.lang.OutOfMemoryError -> L40 java.lang.Exception -> L4e
            java.lang.String r2 = "dsp_offer_show_record"
            r3 = 0
            java.lang.String r4 = "dsp_id = ?  AND dsp_offer_id = ? "
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L39 java.lang.OutOfMemoryError -> L40 java.lang.Exception -> L4e
            r9 = 0
            r5[r9] = r11     // Catch: java.lang.Throwable -> L39 java.lang.OutOfMemoryError -> L40 java.lang.Exception -> L4e
            r11 = 1
            r5[r11] = r12     // Catch: java.lang.Throwable -> L39 java.lang.OutOfMemoryError -> L40 java.lang.Exception -> L4e
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L39 java.lang.OutOfMemoryError -> L40 java.lang.Exception -> L4e
            java.util.List r12 = r10.a(r11)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37 java.lang.OutOfMemoryError -> L41
            int r1 = r12.size()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37 java.lang.OutOfMemoryError -> L41
            if (r1 <= 0) goto L32
            java.lang.Object r12 = r12.get(r9)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37 java.lang.OutOfMemoryError -> L41
            com.anythink.core.common.a.f r12 = (com.anythink.core.common.a.f) r12     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37 java.lang.OutOfMemoryError -> L41
            if (r11 == 0) goto L30
            r11.close()     // Catch: java.lang.Throwable -> L52
        L30:
            monitor-exit(r10)
            return r12
        L32:
            if (r11 == 0) goto L55
            goto L51
        L35:
            goto L3a
        L37:
            goto L4f
        L39:
            r11 = r0
        L3a:
            if (r11 == 0) goto L55
        L3c:
            r11.close()     // Catch: java.lang.Throwable -> L52
            goto L55
        L40:
            r11 = r0
        L41:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L47
            if (r11 == 0) goto L55
            goto L51
        L47:
            r12 = move-exception
            if (r11 == 0) goto L4d
            r11.close()     // Catch: java.lang.Throwable -> L52
        L4d:
            throw r12     // Catch: java.lang.Throwable -> L52
        L4e:
            r11 = r0
        L4f:
            if (r11 == 0) goto L55
        L51:
            goto L3c
        L52:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        L55:
            monitor-exit(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.f.a(java.lang.String, java.lang.String):com.anythink.core.common.a.f");
    }

    private synchronized List<com.anythink.core.common.a.f> a(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    try {
                        com.anythink.core.common.a.f fVar = new com.anythink.core.common.a.f();
                        fVar.a(cursor.getString(cursor.getColumnIndex("dsp_id")));
                        fVar.b(cursor.getString(cursor.getColumnIndex("dsp_offer_id")));
                        fVar.a(cursor.getInt(cursor.getColumnIndex(a.f7016d)));
                        fVar.b(cursor.getInt(cursor.getColumnIndex("show_count")));
                        arrayList.add(fVar);
                    } catch (Throwable unused) {
                    }
                }
                cursor.close();
            }
        }
        return arrayList;
    }

    public final synchronized List<com.anythink.core.common.a.d> a(int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 <= 0) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query(a.a, null, "show_count > show_limit", null, null, null, "last_update_time DESC", String.valueOf(i2));
                List<com.anythink.core.common.a.f> listA = a(cursorQuery);
                new StringBuilder("get limit show cap record list size:").append(listA.size());
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
}
