package com.anythink.expressad.exoplayer;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    private final b a;
    private final a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ae f10087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f10089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f10090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10092h = com.anythink.expressad.exoplayer.b.b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10093i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10094j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f10095k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f10096l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f10097m;

    public interface a {
        void a(x xVar);
    }

    public interface b {
        void a(int i2, Object obj);
    }

    public x(a aVar, b bVar, ae aeVar, int i2, Handler handler) {
        this.b = aVar;
        this.a = bVar;
        this.f10087c = aeVar;
        this.f10090f = handler;
        this.f10091g = i2;
    }

    private synchronized x l() {
        com.anythink.expressad.exoplayer.k.a.b(this.f10094j);
        this.f10097m = true;
        a(false);
        return this;
    }

    public final ae a() {
        return this.f10087c;
    }

    public final b b() {
        return this.a;
    }

    public final int c() {
        return this.f10088d;
    }

    public final Object d() {
        return this.f10089e;
    }

    public final Handler e() {
        return this.f10090f;
    }

    public final long f() {
        return this.f10092h;
    }

    public final int g() {
        return this.f10091g;
    }

    public final boolean h() {
        return this.f10093i;
    }

    public final x i() {
        com.anythink.expressad.exoplayer.k.a.b(!this.f10094j);
        if (this.f10092h == com.anythink.expressad.exoplayer.b.b) {
            com.anythink.expressad.exoplayer.k.a.a(this.f10093i);
        }
        this.f10094j = true;
        this.b.a(this);
        return this;
    }

    public final synchronized boolean j() {
        return this.f10097m;
    }

    public final synchronized boolean k() {
        com.anythink.expressad.exoplayer.k.a.b(this.f10094j);
        com.anythink.expressad.exoplayer.k.a.b(this.f10090f.getLooper().getThread() != Thread.currentThread());
        long jElapsedRealtime = SystemClock.elapsedRealtime() + 500;
        for (long jElapsedRealtime2 = 500; !this.f10096l && jElapsedRealtime2 > 0; jElapsedRealtime2 = jElapsedRealtime - SystemClock.elapsedRealtime()) {
            wait(jElapsedRealtime2);
        }
        if (!this.f10096l) {
            throw new TimeoutException("Message delivery time out");
        }
        return this.f10095k;
    }

    private x b(boolean z2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f10094j);
        this.f10093i = z2;
        return this;
    }

    public final x a(int i2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f10094j);
        this.f10088d = i2;
        return this;
    }

    public final x a(@Nullable Object obj) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f10094j);
        this.f10089e = obj;
        return this;
    }

    private x a(Handler handler) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f10094j);
        this.f10090f = handler;
        return this;
    }

    private x a(long j2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f10094j);
        this.f10092h = j2;
        return this;
    }

    private x a(int i2, long j2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f10094j);
        com.anythink.expressad.exoplayer.k.a.a(j2 != com.anythink.expressad.exoplayer.b.b);
        if (i2 >= 0 && (this.f10087c.a() || i2 < this.f10087c.b())) {
            this.f10091g = i2;
            this.f10092h = j2;
            return this;
        }
        throw new o(this.f10087c, i2, j2);
    }

    public final synchronized void a(boolean z2) {
        this.f10095k = z2 | this.f10095k;
        this.f10096l = true;
        notifyAll();
    }
}
