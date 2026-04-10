package com.anythink.core.common;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.e.ai;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    com.anythink.core.common.e.e a;
    ai b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f7070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ATBaseAdAdapter f7071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f7072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Runnable f7073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Runnable f7074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f7075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f7076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Boolean f7077j;

    private d(int i2) {
        this.f7072e = i2;
    }

    private void a(com.anythink.core.common.e.e eVar) {
        this.a = eVar;
    }

    private boolean b() {
        return this.f7077j != null;
    }

    private com.anythink.core.common.e.e c() {
        return this.a;
    }

    private long d() {
        return this.f7070c;
    }

    private void e() {
        this.f7071d = null;
    }

    private int f() {
        return this.f7072e;
    }

    private void g() {
        if (this.f7073f != null) {
            com.anythink.core.common.b.n.a().c(this.f7073f);
            this.f7073f = null;
        }
        if (this.f7074g != null) {
            com.anythink.core.common.b.n.a().c(this.f7074g);
            this.f7074g = null;
        }
    }

    private void h() {
        if (this.f7073f != null) {
            com.anythink.core.common.b.n.a().c(this.f7073f);
            this.f7073f = null;
        }
    }

    private void i() {
        if (this.f7074g != null) {
            com.anythink.core.common.b.n.a().c(this.f7074g);
            this.f7074g = null;
        }
    }

    private Boolean j() {
        return this.f7077j;
    }

    private boolean k() {
        return this.f7075h || this.f7076i;
    }

    private ai l() {
        return this.b;
    }

    private void a(long j2) {
        this.f7070c = j2;
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter) {
        this.f7071d = aTBaseAdAdapter;
    }

    private void a(long j2, final Runnable runnable, long j3, final Runnable runnable2) {
        if (j2 != -1 && runnable != null) {
            this.f7073f = new Runnable() { // from class: com.anythink.core.common.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (d.this) {
                        d.this.f7076i = true;
                        runnable.run();
                    }
                }
            };
            com.anythink.core.common.b.n.a().a(this.f7073f, j2);
        }
        if (j3 == -1 || runnable2 == null) {
            return;
        }
        this.f7074g = new Runnable() { // from class: com.anythink.core.common.d.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this) {
                    d.this.f7075h = true;
                    runnable2.run();
                }
            }
        };
        com.anythink.core.common.b.n.a().a(this.f7074g, j3);
    }

    private void a(boolean z2) {
        this.f7077j = Boolean.valueOf(z2);
    }

    private void a(ai aiVar) {
        this.b = aiVar;
    }

    private boolean a() {
        if (this.f7077j != null) {
            if (this.f7075h || this.f7076i) {
                return false;
            }
        }
        return true;
    }
}
