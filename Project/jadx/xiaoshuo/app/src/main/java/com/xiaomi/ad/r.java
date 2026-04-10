package com.xiaomi.ad;

import com.xiaomi.ad.common.util.ExecutorUtils;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class r {
    public static final String e = "AdBidCacheCleanTask";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f7284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Future f7285b;
    public int c;
    public String d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f7285b = null;
            r.this.f7284a.a(r.this.c, r.this.d);
        }
    }

    public r(s sVar) {
        this.f7284a = sVar;
    }

    public void a(int i, String str) {
        Future future = this.f7285b;
        if (future != null) {
            future.cancel(true);
        }
        this.c = i;
        this.d = str;
        this.f7285b = ExecutorUtils.WORKING_EXECUTOR.schedule(new a(), 20L, TimeUnit.MILLISECONDS);
    }
}
