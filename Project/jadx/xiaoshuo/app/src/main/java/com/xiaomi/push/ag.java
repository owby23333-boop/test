package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ag f7785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ScheduledThreadPoolExecutor f125a = new ScheduledThreadPoolExecutor(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, ScheduledFuture> f124a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f123a = new Object();

    public static abstract class a implements Runnable {
        /* JADX INFO: renamed from: a */
        public abstract String mo239a();
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f7786a;

        public b(a aVar) {
            this.f7786a = aVar;
        }

        public void a() {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.f7786a.run();
            b();
        }
    }

    private ag(Context context) {
        this.f122a = context.getSharedPreferences("mipush_extra", 0);
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> scheduledFutureSchedule = this.f125a.schedule(new ai(this, aVar), i, TimeUnit.SECONDS);
        synchronized (this.f123a) {
            this.f124a.put(aVar.mo239a(), scheduledFutureSchedule);
        }
        return true;
    }

    public static ag a(Context context) {
        if (f7785a == null) {
            synchronized (ag.class) {
                if (f7785a == null) {
                    f7785a = new ag(context);
                }
            }
        }
        return f7785a;
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        String strA = a(aVar.mo239a());
        ah ahVar = new ah(this, aVar, z, strA);
        if (!z) {
            long jAbs = Math.abs(System.currentTimeMillis() - this.f122a.getLong(strA, 0L)) / 1000;
            if (jAbs < i - i2) {
                i2 = (int) (((long) i) - jAbs);
            }
        }
        try {
            ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = this.f125a.scheduleAtFixedRate(ahVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f123a) {
                this.f124a.put(aVar.mo239a(), scheduledFutureScheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f125a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m188a(a aVar) {
        return b(aVar, 0);
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f123a) {
            scheduledFuture = this.f124a.get(aVar.mo239a());
        }
        return scheduledFuture;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m189a(String str) {
        synchronized (this.f123a) {
            ScheduledFuture scheduledFuture = this.f124a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f124a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }
}
