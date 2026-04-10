package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMDBManager.java */
/* JADX INFO: loaded from: classes3.dex */
class g {
    private static SQLiteOpenHelper b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f19681d;
    private AtomicInteger a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f19682c;

    /* JADX INFO: compiled from: UMDBManager.java */
    private static class a {
        private static final g a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (f19681d == null && context != null) {
            f19681d = context.getApplicationContext();
            b = f.a(f19681d);
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.f19682c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private g() {
        this.a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.a.incrementAndGet() == 1) {
            this.f19682c = b.getWritableDatabase();
        }
        return this.f19682c;
    }
}
