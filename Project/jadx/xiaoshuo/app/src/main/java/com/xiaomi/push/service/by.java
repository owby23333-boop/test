package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class by implements ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile by f8269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f1004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Context f1005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f1006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f1008a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, a> f1007a = new ConcurrentHashMap<>();

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f8270a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f1009a;

        public a(String str, long j) {
            this.f1009a = str;
            this.f8270a = j;
        }

        public abstract void a(by byVar);

        @Override // java.lang.Runnable
        public void run() {
            if (by.f8269a != null) {
                Context context = by.f8269a.f1005a;
                if (com.xiaomi.push.bf.d(context)) {
                    if (System.currentTimeMillis() - by.f8269a.f1006a.getLong(":ts-" + this.f1009a, 0L) > this.f8270a || com.xiaomi.push.ad.a(context)) {
                        com.xiaomi.push.p.a(by.f8269a.f1006a.edit().putLong(":ts-" + this.f1009a, System.currentTimeMillis()));
                        a(by.f8269a);
                    }
                }
            }
        }
    }

    private by(Context context) {
        this.f1005a = context.getApplicationContext();
        this.f1006a = context.getSharedPreferences("sync", 0);
    }

    public static by a(Context context) {
        if (f8269a == null) {
            synchronized (by.class) {
                if (f8269a == null) {
                    f8269a = new by(context);
                }
            }
        }
        return f8269a;
    }

    @Override // com.xiaomi.push.service.ar
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo783a() {
        if (this.f1008a) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f1004a < 3600000) {
            return;
        }
        this.f1004a = jCurrentTimeMillis;
        this.f1008a = true;
        com.xiaomi.push.ag.a(this.f1005a).a(new bz(this), (int) (Math.random() * 10.0d));
    }

    public String a(String str, String str2) {
        return this.f1006a.getString(str + ":" + str2, "");
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.p.a(f8269a.f1006a.edit().putString(str + ":" + str2, str3));
    }

    public void a(a aVar) {
        if (this.f1007a.putIfAbsent(aVar.f1009a, aVar) == null) {
            com.xiaomi.push.ag.a(this.f1005a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }
}
