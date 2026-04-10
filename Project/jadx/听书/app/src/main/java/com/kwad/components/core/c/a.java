package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static volatile a Ns;
    private final SQLiteDatabase Nq;
    private ConcurrentHashMap<String, e> Nr = new ConcurrentHashMap<>();

    public static a nZ() {
        if (Ns == null) {
            synchronized (a.class) {
                if (Ns == null) {
                    try {
                        Ns = new a(ServiceProvider.Pp());
                    } catch (SQLiteException e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        Ns = null;
                    }
                }
            }
        }
        return Ns;
    }

    private a(Context context) {
        this.Nq = new C0323a(context).getWritableDatabase();
    }

    public final List<h> a(String str, long j, int i) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            cursorRawQuery = this.Nq.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
        } catch (Exception e) {
            e = e;
            cursorRawQuery = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                List<h> listA = h.a(cursorRawQuery);
                if (listA != null) {
                    StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (h hVar : listA) {
                        i2++;
                        if (i2 > i) {
                            sb.append(" creativeId = ");
                            sb.append(hVar.os());
                            if (i2 == listA.size()) {
                                sb.append(")");
                            } else {
                                sb.append(" OR");
                            }
                        } else if (hVar.oq() >= j) {
                            arrayList.add(hVar);
                        }
                    }
                    if (i2 > i) {
                        this.Nq.delete("ksad_ad_cache", sb.toString(), new String[0]);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return arrayList;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorRawQuery;
            }
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            return null;
        }
        th = th2;
        cursor = cursorRawQuery;
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        throw th;
    }

    public final void j(List<h> list) {
        b(list, "ksad_ad_cache");
    }

    public final void w(long j) {
        try {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.Nq.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)}));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public final void oa() {
        try {
            this.Nq.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public final e ad(String str) throws Throwable {
        Cursor cursorRawQuery;
        e eVar;
        ConcurrentHashMap<String, e> concurrentHashMap = this.Nr;
        if (concurrentHashMap != null && (eVar = concurrentHashMap.get(str)) != null) {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "findCacheStrategyList from cache, posId: " + str);
            return eVar;
        }
        Cursor cursor = null;
        try {
            cursorRawQuery = this.Nq.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
        } catch (Exception e) {
            e = e;
            cursorRawQuery = null;
        } catch (Throwable th) {
            th = th;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th;
        }
        try {
            try {
                List<e> listA = e.a(cursorRawQuery);
                if (listA != null && listA.size() > 0) {
                    e eVar2 = listA.get(0);
                    this.Nr.put(str, eVar2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return eVar2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorRawQuery;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        return null;
    }

    public final void ob() {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.Nq.rawQuery("select  * from ksad_ad_cache_strategy", null);
            List<e> listA = e.a(cursorRawQuery);
            if (listA != null && !listA.isEmpty()) {
                for (e eVar : listA) {
                    com.kwad.sdk.core.d.c.d("AdCacheDBManager", "readCacheStrategyList:" + eVar.og());
                    this.Nr.put(eVar.og(), eVar);
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
    }

    public final void a(final e eVar) {
        this.Nr.put(eVar.og(), eVar);
        GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.components.core.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends i> void b(List<T> list, String str) {
        try {
            try {
                this.Nq.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        com.kwad.sdk.core.d.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.Nq.insertWithOnConflict(str, null, it.next().ok(), 5));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
                this.Nq.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.Nq;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.c.printStackTrace(e2);
                    }
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.c.printStackTrace(e3);
                SQLiteDatabase sQLiteDatabase2 = this.Nq;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.c.printStackTrace(e4);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.Nq;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e5) {
                    com.kwad.sdk.core.d.c.printStackTrace(e5);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.core.c.a$a, reason: collision with other inner class name */
    static class C0323a extends SQLiteOpenHelper {
        private static int Nv = 1;
        private String Nw;
        private String Nx;

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public C0323a(Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, Nv);
            this.Nw = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.Nx = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.Nw);
            sQLiteDatabase.execSQL(this.Nx);
        }
    }
}
