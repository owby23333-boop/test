package com.kwad.components.core.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.umeng.message.proguard.ad;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static volatile a HQ;
    private final SQLiteDatabase HP;

    /* JADX INFO: renamed from: com.kwad.components.core.b.a$a, reason: collision with other inner class name */
    static class C0386a extends SQLiteOpenHelper {
        private static int HR = 1;
        private String HS;
        private String HT;

        public C0386a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, HR);
            this.HS = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.HT = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.HS);
            sQLiteDatabase.execSQL(this.HT);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    private a(Context context) {
        this.HP = new C0386a(context).getWritableDatabase();
    }

    private <T extends h> void b(List<T> list, String str) {
        try {
            try {
                this.HP.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        com.kwad.sdk.core.d.b.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.HP.insertWithOnConflict(str, null, it.next().mE(), 5));
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
                this.HP.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.HP;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.b.printStackTrace(e3);
                    }
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.d.b.printStackTrace(e4);
                SQLiteDatabase sQLiteDatabase2 = this.HP;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e5) {
                        com.kwad.sdk.core.d.b.printStackTrace(e5);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.HP;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.b.printStackTrace(e6);
                }
            }
            throw th;
        }
    }

    @Nullable
    public static a mr() {
        KsAdSDKImpl ksAdSDKImpl;
        if (HQ == null) {
            synchronized (a.class) {
                if (HQ == null && (ksAdSDKImpl = KsAdSDKImpl.get()) != null) {
                    try {
                        HQ = new a(ksAdSDKImpl.getContext());
                    } catch (SQLiteException e2) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                        HQ = null;
                    }
                }
            }
        }
        return HQ;
    }

    public final void a(e eVar) {
        b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @WorkerThread
    public final e ae(String str) throws Throwable {
        Cursor cursorRawQuery;
        ?? r02 = 0;
        try {
            try {
                cursorRawQuery = this.HP.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r02);
                throw th;
            }
            try {
                List<e> listA = e.a(cursorRawQuery);
                if (listA != null && listA.size() > 0) {
                    e eVar = listA.get(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return eVar;
                }
            } catch (Exception e3) {
                e = e3;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            return null;
        } catch (Throwable th2) {
            r02 = str;
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r02);
            throw th;
        }
    }

    @Nullable
    @WorkerThread
    public final List<g> b(String str, long j2, int i2) throws Throwable {
        Cursor cursorRawQuery;
        try {
            try {
                cursorRawQuery = this.HP.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                throw th;
            }
            try {
                List<g> listA = g.a(cursorRawQuery);
                if (listA == null) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return null;
                }
                StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                for (g gVar : listA) {
                    i3++;
                    if (i3 > i2) {
                        sb.append(" creativeId = ");
                        sb.append(gVar.mM());
                        sb.append(i3 == listA.size() ? ad.f20406s : " OR");
                    } else if (gVar.mK() >= j2) {
                        arrayList.add(gVar);
                    }
                }
                if (i3 > i2) {
                    this.HP.delete("ksad_ad_cache", sb.toString(), new String[0]);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
            throw th;
        }
    }

    @WorkerThread
    public final void h(List<g> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void m(long j2) {
        try {
            com.kwad.sdk.core.d.b.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.HP.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j2)}));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @WorkerThread
    public final void ms() {
        try {
            this.HP.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }
}
