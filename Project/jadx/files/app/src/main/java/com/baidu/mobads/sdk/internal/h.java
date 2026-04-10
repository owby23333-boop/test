package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h<T> implements Runnable {
    private static final String b = "BaseTask";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f13134c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f13135d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f13136e = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static b f13137j;
    protected Future<T> a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f13139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f13141i;

    private static class a<T> {
        final h a;
        final T b;

        a(h hVar, T t2) {
            this.a = hVar;
            this.b = t2;
        }
    }

    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.a.a(aVar.b);
            } else if (i2 == 2) {
                aVar.a.a((Throwable) aVar.b);
            } else {
                if (i2 != 3) {
                    return;
                }
                aVar.a.j();
            }
        }
    }

    public h() {
        this.f13138f = "default";
    }

    private static Handler k() {
        b bVar;
        synchronized (h.class) {
            if (f13137j == null) {
                f13137j = new b(Looper.getMainLooper());
            }
            bVar = f13137j;
        }
        return bVar;
    }

    public String a() {
        return this.f13138f;
    }

    protected void a(T t2) {
    }

    protected void a(Throwable th) {
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.f13140h - this.f13139g;
    }

    public long f() {
        return this.f13141i - this.f13139g;
    }

    public long g() {
        return this.f13141i - this.f13140h;
    }

    public h h() {
        try {
            this.f13140h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
            } finally {
            }
        }
        return this;
    }

    protected abstract T i();

    protected void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(Future future) {
        this.a = future;
    }

    public h(String str) {
        this.f13138f = str;
    }

    public void a(long j2) {
        this.f13139g = j2;
    }

    public void a(boolean z2) {
        Future<T> future = this.a;
        if (future != null) {
            future.cancel(z2);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }
}
