package com.alibaba.sdk.android.httpdns.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class d extends SQLiteOpenHelper {
    private static final Object a = new Object();

    d(Context context) {
        super(context, "aliclound_httpdns.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private long a(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f2171i));
        contentValues.put("ip", gVar.f2172o);
        contentValues.put("ttl", gVar.f2173p);
        try {
            return sQLiteDatabase.insert("ip", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[PHI: r10
  0x008e: PHI (r10v4 android.database.sqlite.SQLiteDatabase) = (r10v3 android.database.sqlite.SQLiteDatabase), (r10v5 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x008c, B:13:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.alibaba.sdk.android.httpdns.b.g> a(long r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            java.lang.String r3 = "ip"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r2 = 0
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r6[r2] = r12     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r1 == 0) goto L6d
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r12 <= 0) goto L6d
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
        L2c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.id = r2     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.f2171i = r2     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.f2172o = r13     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.f2173p = r13     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r0.add(r12)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r12 != 0) goto L2c
        L6d:
            if (r1 == 0) goto L72
            r1.close()
        L72:
            if (r10 == 0) goto L91
            goto L8e
        L75:
            r12 = move-exception
            goto L7b
        L77:
            goto L87
        L79:
            r12 = move-exception
            r10 = r1
        L7b:
            if (r1 == 0) goto L80
            r1.close()
        L80:
            if (r10 == 0) goto L85
            r10.close()
        L85:
            throw r12
        L86:
            r10 = r1
        L87:
            if (r1 == 0) goto L8c
            r1.close()
        L8c:
            if (r10 == 0) goto L91
        L8e:
            r10.close()
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.a(long):java.util.List");
    }

    private List<g> a(e eVar) {
        return a(eVar.id);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m10a(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete(Constants.KEY_HOST, "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void a(g gVar) {
        m11b(gVar.id);
    }

    private long b(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f2171i));
        contentValues.put("ip", gVar.f2172o);
        contentValues.put("ttl", gVar.f2173p);
        try {
            return sQLiteDatabase.insert("ipv6", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[PHI: r10
  0x008e: PHI (r10v4 android.database.sqlite.SQLiteDatabase) = (r10v3 android.database.sqlite.SQLiteDatabase), (r10v5 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x008c, B:13:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.alibaba.sdk.android.httpdns.b.g> b(long r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            java.lang.String r3 = "ipv6"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r2 = 0
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r6[r2] = r12     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r1 == 0) goto L6d
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r12 <= 0) goto L6d
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
        L2c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.id = r2     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.f2171i = r2     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.f2172o = r13     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r12.f2173p = r13     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            r0.add(r12)     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L75 java.lang.Exception -> L77
            if (r12 != 0) goto L2c
        L6d:
            if (r1 == 0) goto L72
            r1.close()
        L72:
            if (r10 == 0) goto L91
            goto L8e
        L75:
            r12 = move-exception
            goto L7b
        L77:
            goto L87
        L79:
            r12 = move-exception
            r10 = r1
        L7b:
            if (r1 == 0) goto L80
            r1.close()
        L80:
            if (r10 == 0) goto L85
            r10.close()
        L85:
            throw r12
        L86:
            r10 = r1
        L87:
            if (r1 == 0) goto L8c
            r1.close()
        L8c:
            if (r10 == 0) goto L91
        L8e:
            r10.close()
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.b(long):java.util.List");
    }

    private List<g> b(e eVar) {
        return b(eVar.id);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private void m11b(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete("ip", "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void b(g gVar) {
        c(gVar.id);
    }

    private void c(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete("ipv6", "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void c(e eVar) {
        m10a(eVar.id);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    long m12a(e eVar) {
        SQLiteDatabase writableDatabase;
        synchronized (a) {
            b(eVar.f2169m, eVar.host);
            ContentValues contentValues = new ContentValues();
            try {
                writableDatabase = getWritableDatabase();
            } catch (Exception unused) {
                writableDatabase = null;
            } catch (Throwable th) {
                th = th;
                writableDatabase = null;
            }
            try {
                writableDatabase.beginTransaction();
                contentValues.put(Constants.KEY_HOST, eVar.host);
                contentValues.put("sp", eVar.f2169m);
                contentValues.put("time", c.c(eVar.f2170n));
                contentValues.put("extra", eVar.a);
                contentValues.put("cache_key", eVar.b);
                long jInsert = writableDatabase.insert(Constants.KEY_HOST, null, contentValues);
                eVar.id = jInsert;
                if (eVar.f7a != null) {
                    for (g gVar : eVar.f7a) {
                        gVar.f2171i = jInsert;
                        gVar.id = a(writableDatabase, gVar);
                    }
                }
                if (eVar.f8b != null) {
                    for (g gVar2 : eVar.f8b) {
                        gVar2.f2171i = jInsert;
                        gVar2.id = b(writableDatabase, gVar2);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
                return jInsert;
            } catch (Exception unused2) {
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
                return 0L;
            } catch (Throwable th2) {
                th = th2;
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.alibaba.sdk.android.httpdns.b.e a(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.Object r0 = com.alibaba.sdk.android.httpdns.b.d.a
            monitor-enter(r0)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lb3
            java.lang.String r3 = "host"
            r4 = 0
            java.lang.String r5 = "sp=? AND host=?"
            r2 = 2
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            r2 = 0
            r6[r2] = r12     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            r12 = 1
            r6[r12] = r13     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La2
            if (r12 == 0) goto L93
            int r13 = r12.getCount()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r13 <= 0) goto L93
            r12.moveToFirst()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            com.alibaba.sdk.android.httpdns.b.e r13 = new com.alibaba.sdk.android.httpdns.b.e     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r13.<init>()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r1 = "id"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            int r1 = r12.getInt(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            long r1 = (long) r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            r13.id = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = "host"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            r13.host = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = "sp"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            r13.f2169m = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = "time"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = com.alibaba.sdk.android.httpdns.b.c.d(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            r13.f2170n = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.util.List r1 = r11.a(r13)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            r13.f7a = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.util.List r1 = r11.b(r13)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            r13.f8b = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = "extra"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            r13.a = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = "cache_key"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            r13.b = r1     // Catch: java.lang.Exception -> L8d java.lang.Throwable -> L8f
            goto L94
        L8d:
            goto Lb6
        L8f:
            r13 = move-exception
            goto La8
        L91:
            r13 = r1
            goto Lb6
        L93:
            r13 = r1
        L94:
            if (r12 == 0) goto L99
            r12.close()     // Catch: java.lang.Throwable -> Lbc
        L99:
            if (r10 == 0) goto Lc1
        L9b:
            r10.close()     // Catch: java.lang.Throwable -> Lbc
            goto Lc1
        L9f:
            r13 = move-exception
            r12 = r1
            goto La8
        La2:
            r12 = r1
            r13 = r12
            goto Lb6
        La5:
            r13 = move-exception
            r12 = r1
            r10 = r12
        La8:
            if (r12 == 0) goto Lad
            r12.close()     // Catch: java.lang.Throwable -> Lbc
        Lad:
            if (r10 == 0) goto Lb2
            r10.close()     // Catch: java.lang.Throwable -> Lbc
        Lb2:
            throw r13     // Catch: java.lang.Throwable -> Lbc
        Lb3:
            r12 = r1
            r13 = r12
            r10 = r13
        Lb6:
            if (r12 == 0) goto Lbe
            r12.close()     // Catch: java.lang.Throwable -> Lbc
            goto Lbe
        Lbc:
            r12 = move-exception
            goto Lc3
        Lbe:
            if (r10 == 0) goto Lc1
            goto L9b
        Lc1:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbc
            return r13
        Lc3:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbc
            goto Lc6
        Lc5:
            throw r12
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.a(java.lang.String, java.lang.String):com.alibaba.sdk.android.httpdns.b.e");
    }

    List<e> b() {
        ArrayList arrayList;
        SQLiteDatabase readableDatabase;
        synchronized (a) {
            arrayList = new ArrayList();
            Cursor cursorQuery = null;
            try {
                readableDatabase = getReadableDatabase();
                try {
                    cursorQuery = readableDatabase.query(Constants.KEY_HOST, null, null, null, null, null, null);
                    if (cursorQuery != null && cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        do {
                            e eVar = new e();
                            eVar.id = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                            eVar.host = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.KEY_HOST));
                            eVar.f2169m = cursorQuery.getString(cursorQuery.getColumnIndex("sp"));
                            eVar.f2170n = c.d(cursorQuery.getString(cursorQuery.getColumnIndex("time")));
                            eVar.f7a = (ArrayList) a(eVar);
                            eVar.f8b = (ArrayList) b(eVar);
                            eVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                            eVar.b = cursorQuery.getString(cursorQuery.getColumnIndex("cache_key"));
                            arrayList.add(eVar);
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (readableDatabase != null) {
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                readableDatabase = null;
            } catch (Throwable th2) {
                th = th2;
                readableDatabase = null;
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
        }
        return arrayList;
    }

    void b(String str, String str2) {
        synchronized (a) {
            e eVarA = a(str, str2);
            if (eVarA != null) {
                c(eVarA);
                if (eVarA.f7a != null) {
                    Iterator<g> it = eVarA.f7a.iterator();
                    while (it.hasNext()) {
                        a(it.next());
                    }
                }
                if (eVarA.f8b != null) {
                    Iterator<g> it2 = eVarA.f8b.iterator();
                    while (it2.hasNext()) {
                        b(it2.next());
                    }
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE host (id INTEGER PRIMARY KEY,host TEXT,sp TEXT,time TEXT,extra TEXT,cache_key TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ip (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ipv6 (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 != i3) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS host;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ip;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ipv6;");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } catch (Exception unused) {
            }
        }
    }
}
