package com.anythink.expressad.video.dynview.i.c;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final long a = 1000;
    private long b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.anythink.expressad.video.dynview.i.c.a f11643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f11644e;

    private static class a extends CountDownTimer {
        private com.anythink.expressad.video.dynview.i.c.a a;

        public a(long j2, long j3) {
            super(j2, j3);
        }

        final void a(com.anythink.expressad.video.dynview.i.c.a aVar) {
            this.a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.anythink.expressad.video.dynview.i.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j2) {
            com.anythink.expressad.video.dynview.i.c.a aVar = this.a;
            if (aVar != null) {
                aVar.a(j2);
            }
        }
    }

    private void d() {
        a aVar = this.f11644e;
        if (aVar != null) {
            aVar.cancel();
            this.f11644e = null;
        }
        if (this.f11642c <= 0) {
            this.f11642c = this.b + 1000;
        }
        this.f11644e = new a(this.b, this.f11642c);
        this.f11644e.a(this.f11643d);
    }

    public final b a() {
        this.f11642c = 1000L;
        return this;
    }

    public final void b() {
        if (this.f11644e == null) {
            d();
        }
        this.f11644e.start();
    }

    public final void c() {
        a aVar = this.f11644e;
        if (aVar != null) {
            aVar.cancel();
            this.f11644e = null;
        }
    }

    public final b a(com.anythink.expressad.video.dynview.i.c.a aVar) {
        this.f11643d = aVar;
        return this;
    }

    public final b a(long j2) {
        this.b = j2;
        return this;
    }

    public final void a(long j2, com.anythink.expressad.video.dynview.i.c.a aVar) {
        this.b = j2;
        this.f11643d = aVar;
        d();
        a aVar2 = this.f11644e;
        if (aVar2 != null) {
            aVar2.start();
        }
    }
}
