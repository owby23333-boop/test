package com.anythink.expressad.f.a;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final long a = 1000;
    private long b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.anythink.expressad.f.a.a f10110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f10111e;

    private static class a extends CountDownTimer {
        private com.anythink.expressad.f.a.a a;

        public a(long j2, long j3) {
            super(j2, j3);
        }

        final void a(com.anythink.expressad.f.a.a aVar) {
            this.a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j2) {
        }
    }

    private b a(long j2) {
        if (j2 < 0) {
            j2 = 1000;
        }
        this.f10109c = j2;
        return this;
    }

    private b b(long j2) {
        this.b = j2;
        return this;
    }

    private void c() {
        a aVar = this.f10111e;
        if (aVar != null) {
            aVar.cancel();
            this.f10111e = null;
        }
    }

    private b a(com.anythink.expressad.f.a.a aVar) {
        this.f10110d = aVar;
        return this;
    }

    private void b() {
        a aVar = this.f10111e;
        if (aVar == null) {
            if (aVar != null) {
                aVar.cancel();
                this.f10111e = null;
            }
            if (this.f10109c <= 0) {
                this.f10109c = this.b + 1000;
            }
            this.f10111e = new a(this.b, this.f10109c);
            this.f10111e.a(this.f10110d);
        }
        this.f10111e.start();
    }

    private void a() {
        a aVar = this.f10111e;
        if (aVar != null) {
            aVar.cancel();
            this.f10111e = null;
        }
        if (this.f10109c <= 0) {
            this.f10109c = this.b + 1000;
        }
        this.f10111e = new a(this.b, this.f10109c);
        this.f10111e.a(this.f10110d);
    }
}
