package com.anythink.core.common.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.e.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j extends com.anythink.core.common.c.a<x> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static j f7042c;
    private final String b;

    public static class a {
        public static final String a = "offer_action_record";
        public static final String b = "adsource_id";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7043c = "type";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f7044d = "unit_id";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f7045e = "click_count";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f7046f = "show_count";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f7047g = "expire_time";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f7048h = "CREATE TABLE IF NOT EXISTS offer_action_record(adsource_id TEXT ,type INTEGER ,unit_id TEXT ,click_count INTEGER ,show_count INTEGER ,expire_time INTEGER )";
    }

    private j(b bVar) {
        super(bVar);
        this.b = j.class.getName();
    }

    public static j a(b bVar) {
        if (f7042c == null) {
            synchronized (j.class) {
                if (f7042c == null) {
                    f7042c = new j(bVar);
                }
            }
        }
        return f7042c;
    }

    private static String b(int i2) {
        if (i2 <= 0) {
            throw new RuntimeException("No placeholders");
        }
        StringBuilder sb = new StringBuilder((i2 * 2) - 1);
        sb.append("?");
        for (int i3 = 1; i3 < i2; i3++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    private boolean c(String str, int i2, String str2) {
        Cursor cursorQuery = a().query(a.a, null, "adsource_id = ? and type = ? and unit_id = ?", new String[]{str, String.valueOf(i2), str2}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    private synchronized long b(String str, int i2, String str2) {
        if (b() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("adsource_id", str);
            contentValues.put("type", Integer.valueOf(i2));
            contentValues.put("unit_id", str2);
            x xVarA = a(i2, str2);
            if (xVarA != null) {
                contentValues.put(a.f7045e, Integer.valueOf(xVarA.d()));
                contentValues.put("show_count", Integer.valueOf(xVarA.c()));
                contentValues.put(a.f7047g, Long.valueOf(xVarA.b()));
            } else {
                contentValues.put(a.f7045e, (Integer) 0);
                contentValues.put("show_count", (Integer) 0);
                contentValues.put(a.f7047g, (Integer) (-1));
            }
            return b().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized void a(int i2, String str, int i3, int i4) {
        x xVarA = a(i2, str);
        if (xVarA != null) {
            xVarA.b(xVarA.d() + i3);
            xVarA.a(xVarA.c() + i4);
            a(xVarA);
        }
    }

    public final synchronized void a(int i2, String str, long j2) {
        x xVarA = a(i2, str);
        if (xVarA != null) {
            xVarA.a(System.currentTimeMillis() + j2);
            a(xVarA);
        }
    }

    public final synchronized List<x> a(int i2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query(a.a, null, "type = ? and expire_time > ?", new String[]{String.valueOf(i2), String.valueOf(System.currentTimeMillis())}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        x xVar = new x(i2, cursorQuery.getString(cursorQuery.getColumnIndex("unit_id")));
                        xVar.b(cursorQuery.getInt(cursorQuery.getColumnIndex(a.f7045e)));
                        xVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex("show_count")));
                        xVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.f7047g)));
                        arrayList.add(xVar);
                    }
                }
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
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    private boolean b(int i2, String str) {
        Cursor cursorQuery = a().query(a.a, null, "type = ? and unit_id = ?", new String[]{String.valueOf(i2), str}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    public final synchronized List<x> a(List<String> list, int i2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("SELECT * FROM offer_action_record WHERE adsource_id IN (");
        sb.append(b(list.size()));
        sb.append(") and type = ? and expire_time > ?");
        Cursor cursorQuery = null;
        try {
            try {
                String[] strArr = new String[list.size() + 2];
                list.toArray(strArr);
                strArr[list.size()] = String.valueOf(i2);
                strArr[list.size() + 1] = String.valueOf(System.currentTimeMillis());
                cursorQuery = a().query(a.a, null, "adsource_id IN (" + b(list.size()) + ") and type = ? and expire_time > ?", strArr, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        x xVar = new x(i2, cursorQuery.getString(cursorQuery.getColumnIndex("unit_id")));
                        xVar.b(cursorQuery.getInt(cursorQuery.getColumnIndex(a.f7045e)));
                        xVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex("show_count")));
                        xVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.f7047g)));
                        arrayList.add(xVar);
                    }
                }
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
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    private synchronized long a(x xVar) {
        if (b() == null || xVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(xVar.e()));
            contentValues.put("unit_id", xVar.a());
            contentValues.put(a.f7045e, Integer.valueOf(xVar.d()));
            contentValues.put("show_count", Integer.valueOf(xVar.c()));
            contentValues.put(a.f7047g, Long.valueOf(xVar.b()));
            return b().update(a.a, contentValues, "type = ? and unit_id = ?", new String[]{String.valueOf(xVar.e()), xVar.a()});
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0075 A[Catch: all -> 0x0084, PHI: r1
  0x0075: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:20:0x006c, B:24:0x0073, B:31:0x0081] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #2 {, blocks: (B:10:0x005b, B:16:0x0066, B:25:0x0075, B:28:0x007c, B:29:0x007f, B:23:0x0070), top: B:39:0x0002, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized com.anythink.core.common.e.x a(int r10, java.lang.String r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.a()     // Catch: java.lang.Throwable -> L6b java.lang.OutOfMemoryError -> L6f java.lang.Exception -> L80
            java.lang.String r2 = "offer_action_record"
            r3 = 0
            java.lang.String r4 = "type=? and unit_id = ?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L6b java.lang.OutOfMemoryError -> L6f java.lang.Exception -> L80
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L6b java.lang.OutOfMemoryError -> L6f java.lang.Exception -> L80
            r5[r6] = r7     // Catch: java.lang.Throwable -> L6b java.lang.OutOfMemoryError -> L6f java.lang.Exception -> L80
            r6 = 1
            r5[r6] = r11     // Catch: java.lang.Throwable -> L6b java.lang.OutOfMemoryError -> L6f java.lang.Exception -> L80
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6b java.lang.OutOfMemoryError -> L6f java.lang.Exception -> L80
            if (r1 == 0) goto L64
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            if (r2 <= 0) goto L64
            r1.moveToNext()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            com.anythink.core.common.e.x r2 = new com.anythink.core.common.e.x     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            r2.<init>(r10, r11)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            java.lang.String r10 = "click_count"
            int r10 = r1.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            int r10 = r1.getInt(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            r2.b(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            java.lang.String r10 = "show_count"
            int r10 = r1.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            int r10 = r1.getInt(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            r2.a(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            java.lang.String r10 = "expire_time"
            int r10 = r1.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            long r10 = r1.getLong(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            r2.a(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            r1.close()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L62 java.lang.OutOfMemoryError -> L70
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Throwable -> L84
        L5e:
            monitor-exit(r9)
            return r2
        L60:
            goto L6c
        L62:
            goto L81
        L64:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.lang.Throwable -> L84
        L69:
            monitor-exit(r9)
            return r0
        L6b:
            r1 = r0
        L6c:
            if (r1 == 0) goto L87
            goto L83
        L6f:
            r1 = r0
        L70:
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L87
        L75:
            r1.close()     // Catch: java.lang.Throwable -> L84
            goto L87
        L79:
            r10 = move-exception
            if (r1 == 0) goto L7f
            r1.close()     // Catch: java.lang.Throwable -> L84
        L7f:
            throw r10     // Catch: java.lang.Throwable -> L84
        L80:
            r1 = r0
        L81:
            if (r1 == 0) goto L87
        L83:
            goto L75
        L84:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L87:
            monitor-exit(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.c.j.a(int, java.lang.String):com.anythink.core.common.e.x");
    }

    public final synchronized void a(String str, int i2, String str2) {
        boolean z2 = false;
        Cursor cursorQuery = a().query(a.a, null, "adsource_id = ? and type = ? and unit_id = ?", new String[]{str, String.valueOf(i2), str2}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            z2 = true;
        } else if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (!z2) {
            b(str, i2, str2);
        }
    }
}
