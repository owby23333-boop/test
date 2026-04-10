package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMProcessDBManager.java */
/* JADX INFO: loaded from: classes3.dex */
class c {
    private static c a;
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f19843c;

    private c() {
    }

    static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        c cVar = a;
        cVar.f19843c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.b.get(str) != null) {
            return this.b.get(str);
        }
        a aVarA = a.a(this.f19843c, str);
        this.b.put(str, aVarA);
        return aVarA;
    }

    synchronized void b(String str) {
        c(str).b();
    }

    /* JADX INFO: compiled from: UMProcessDBManager.java */
    static class a {
        private AtomicInteger a = new AtomicInteger();
        private SQLiteOpenHelper b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f19844c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.a.decrementAndGet() == 0) {
                    this.f19844c.close();
                }
            } catch (Throwable unused) {
            }
        }

        synchronized SQLiteDatabase a() {
            if (this.a.incrementAndGet() == 1) {
                this.f19844c = this.b.getWritableDatabase();
            }
            return this.f19844c;
        }
    }

    synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
