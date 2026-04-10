package com.amgcyo.cuttadon.view.xtablayout;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: ValueAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
class d {
    private final g a;

    /* JADX INFO: compiled from: ValueAnimatorCompat.java */
    class a implements g.b {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.d.g.b
        public void a() {
            this.a.a(d.this);
        }
    }

    /* JADX INFO: compiled from: ValueAnimatorCompat.java */
    class b implements g.a {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.d.g.a
        public void a() {
            this.a.c(d.this);
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.d.g.a
        public void b() {
            this.a.b(d.this);
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.d.g.a
        public void c() {
            this.a.a(d.this);
        }
    }

    /* JADX INFO: compiled from: ValueAnimatorCompat.java */
    interface c {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.view.xtablayout.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ValueAnimatorCompat.java */
    static class C0121d implements c {
        C0121d() {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.d.c
        public void a(d dVar) {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.d.c
        public void b(d dVar) {
        }
    }

    /* JADX INFO: compiled from: ValueAnimatorCompat.java */
    interface e {
        void a(d dVar);
    }

    /* JADX INFO: compiled from: ValueAnimatorCompat.java */
    interface f {
        d c();
    }

    /* JADX INFO: compiled from: ValueAnimatorCompat.java */
    static abstract class g {

        /* JADX INFO: compiled from: ValueAnimatorCompat.java */
        interface a {
            void a();

            void b();

            void c();
        }

        /* JADX INFO: compiled from: ValueAnimatorCompat.java */
        interface b {
            void a();
        }

        g() {
        }

        abstract void a();

        abstract void a(float f2, float f3);

        abstract void a(int i2);

        abstract void a(int i2, int i3);

        abstract void a(Interpolator interpolator);

        abstract void a(a aVar);

        abstract void a(b bVar);

        abstract float b();

        abstract int c();

        abstract long d();

        abstract boolean e();

        abstract void f();
    }

    d(g gVar) {
        this.a = gVar;
    }

    public void a(Interpolator interpolator) {
        this.a.a(interpolator);
    }

    public float b() {
        return this.a.b();
    }

    public int c() {
        return this.a.c();
    }

    public long d() {
        return this.a.d();
    }

    public boolean e() {
        return this.a.e();
    }

    public void f() {
        this.a.f();
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.a.a(new a(eVar));
        } else {
            this.a.a((g.b) null);
        }
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.a.a(new b(cVar));
        } else {
            this.a.a((g.a) null);
        }
    }

    public void a(int i2, int i3) {
        this.a.a(i2, i3);
    }

    public void a(float f2, float f3) {
        this.a.a(f2, f3);
    }

    public void a(int i2) {
        this.a.a(i2);
    }

    public void a() {
        this.a.a();
    }
}
