package com.xiaomi.ad;

import com.xiaomi.ad.common.util.ExecutorUtils;
import com.xiaomi.ad.common.util.MLog;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class u {
    public static final String d = "AdExpiredCacheCleanTask";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f7295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f7296b = new a();
    public Future c;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.this.c = null;
            u.this.f7295a.b();
            u.this.a();
        }
    }

    public u(s sVar) {
        this.f7295a = sVar;
    }

    public void a() {
        StringBuilder sb;
        String str;
        long jD = this.f7295a.d();
        Future future = this.c;
        if (future != null) {
            future.cancel(true);
        }
        if (jD > 0) {
            this.c = ExecutorUtils.WORKING_EXECUTOR.schedule(this.f7296b, jD, TimeUnit.MILLISECONDS);
            sb = new StringBuilder();
            str = "clean adcache runable  start  timeout = ";
        } else {
            sb = new StringBuilder();
            str = "clean adcache runable don't starterror msg ->  timeout = ";
        }
        sb.append(str);
        sb.append(jD);
        MLog.d(d, sb.toString());
    }
}
