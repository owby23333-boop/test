package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g implements t.a {
    private final List<t> a;
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c f942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y f944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final p f946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f948j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f949k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f950l;

    public g(List<t> list, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c cVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2, int i2, y yVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar, int i3, int i4, int i5) {
        this.a = list;
        this.f942d = cVar2;
        this.b = gVar;
        this.f941c = cVar;
        this.f943e = i2;
        this.f944f = yVar;
        this.f945g = eVar;
        this.f946h = pVar;
        this.f947i = i3;
        this.f948j = i4;
        this.f949k = i5;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int a() {
        return this.f949k;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public a0 a(y yVar) throws IOException {
        return a(yVar, this.b, this.f941c, this.f942d);
    }

    public a0 a(y yVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c cVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2) throws Exception {
        if (this.f943e >= this.a.size()) {
            throw new AssertionError();
        }
        this.f950l++;
        if (this.f941c != null && !this.f942d.a(yVar.g())) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.f943e - 1) + " must retain the same host and port");
        }
        if (this.f941c != null && this.f950l > 1) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.f943e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.a, gVar, cVar, cVar2, this.f943e + 1, yVar, this.f945g, this.f946h, this.f947i, this.f948j, this.f949k);
        t tVar = this.a.get(this.f943e);
        try {
            a0 a0VarA = tVar.a(gVar2);
            if (cVar != null && this.f943e + 1 < this.a.size() && gVar2.f950l != 1) {
                throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
            }
            if (a0VarA == null) {
                return new a0.a().a(yVar).a((cVar2 == null || cVar2.d() == null) ? w.a("Unknown") : cVar2.d()).a(0).a("internal error").a();
            }
            if (a0VarA.i() != null) {
                return a0VarA;
            }
            throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public y b() {
        return this.f944f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int c() {
        return this.f947i;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int d() {
        return this.f948j;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e e() {
        return this.f945g;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i f() {
        return this.f942d;
    }

    public p g() {
        return this.f946h;
    }

    public c h() {
        return this.f941c;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g i() {
        return this.b;
    }
}
