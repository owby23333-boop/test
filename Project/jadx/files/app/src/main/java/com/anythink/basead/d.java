package com.anythink.basead;

import android.os.SystemClock;
import com.anythink.core.common.b.n;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    long a;
    long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Runnable f5958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f5959d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.anythink.core.common.i.a f5961f = com.anythink.core.common.i.c.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    com.anythink.core.common.i.b f5960e = new com.anythink.core.common.i.b() { // from class: com.anythink.basead.d.1
        @Override // java.lang.Runnable
        public final void run() {
            d dVar = d.this;
            dVar.f5959d = false;
            dVar.b = -1L;
            n.a().a(d.this.f5958c);
        }
    };

    public d(long j2, Runnable runnable) {
        this.b = j2;
        this.f5958c = runnable;
    }

    public final synchronized void a() {
        if (this.b >= 0 && !this.f5959d) {
            this.f5959d = true;
            this.a = SystemClock.elapsedRealtime();
            this.f5961f.a(this.f5960e, this.b);
        }
    }

    public final synchronized void b() {
        if (this.f5959d) {
            this.f5959d = false;
            this.b -= SystemClock.elapsedRealtime() - this.a;
            this.f5961f.a(this.f5960e);
        }
    }

    public final synchronized void c() {
        this.f5959d = false;
        this.f5961f.a(this.f5960e);
        this.b = -1L;
    }
}
