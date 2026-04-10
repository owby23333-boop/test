package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMDBManager.java */
/* JADX INFO: loaded from: classes4.dex */
class g {
    private static SQLiteOpenHelper b;
    private static Context d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f2232a;
    private SQLiteDatabase c;

    private g() {
        this.f2232a = new AtomicInteger();
    }

    /* JADX INFO: compiled from: UMDBManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f2233a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = f.a(applicationContext);
        }
        return a.f2233a;
    }

    public synchronized SQLiteDatabase a() {
        if (this.f2232a.incrementAndGet() == 1) {
            this.c = b.getWritableDatabase();
        }
        return this.c;
    }

    public synchronized void b() {
        try {
            if (this.f2232a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (Throwable unused) {
        }
    }
}
