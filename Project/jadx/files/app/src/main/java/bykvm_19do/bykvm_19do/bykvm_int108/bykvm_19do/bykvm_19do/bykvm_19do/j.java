package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class j implements f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a f1915j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static j f1916k;
    private volatile Context a;
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f1919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e f1920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f1921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile g f1922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c f1923i;

    private j() {
    }

    public static j l() {
        j jVar;
        synchronized (j.class) {
            if (f1916k == null) {
                f1916k = new j();
            }
            jVar = f1916k;
        }
        return jVar;
    }

    public static bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.a m() {
        if (f1915j == null) {
            synchronized (j.class) {
                if (f1915j == null) {
                    f1915j = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.b();
                }
            }
        }
        return f1915j;
    }

    public void a() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.b();
    }

    public void a(Context context) {
        this.a = context;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e eVar) {
        this.f1920f = eVar;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c cVar) {
        this.f1923i = cVar;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.c(System.currentTimeMillis());
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.a(aVar, aVar.b());
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.f1918d = aVar;
    }

    public void a(g gVar) {
        this.f1922h = gVar;
    }

    public void a(boolean z2) {
        this.f1921g = z2;
    }

    public g b() {
        return this.f1922h;
    }

    public void b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.b = aVar;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a c() {
        return this.f1918d;
    }

    public void c(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.f1917c = aVar;
    }

    public Context d() {
        return this.a;
    }

    public void d(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar) {
        this.f1919e = aVar;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e e() {
        return this.f1920f;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a f() {
        return this.b;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a g() {
        return this.f1917c;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a h() {
        return this.f1919e;
    }

    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c i() {
        return this.f1923i;
    }

    public boolean j() {
        return this.f1921g;
    }

    public void k() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1894g.d();
    }
}
