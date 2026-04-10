package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class x implements e {
    final v a;
    final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p f1301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final y f1302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f1303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1304f;

    final class a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        private final f b;

        a(f fVar) {
            super("OkHttp %s", x.this.c());
            this.b = fVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        protected void b() {
            boolean z2;
            try {
                try {
                    a0 a0VarA = x.this.a();
                    try {
                        if (x.this.b.a()) {
                            this.b.a(x.this, new IOException("Canceled"));
                        } else {
                            this.b.a(x.this, a0VarA);
                        }
                        if (a0VarA.f895c == 0) {
                            throw new IOException(a0VarA.f896d);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        z2 = true;
                        if (z2) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(4, "Callback failure for " + x.this.d(), e);
                        } else {
                            x.this.f1301c.a(x.this, e);
                            this.b.a(x.this, e);
                        }
                    }
                } finally {
                    x.this.a.g().b(this);
                }
            } catch (IOException e3) {
                e = e3;
                z2 = false;
            }
        }

        String c() {
            return x.this.f1302d.g().g();
        }
    }

    private x(v vVar, y yVar, boolean z2) {
        this.a = vVar;
        this.f1302d = yVar;
        this.f1303e = z2;
        this.b = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.j(vVar, z2);
    }

    static x a(v vVar, y yVar, boolean z2) {
        x xVar = new x(vVar, yVar, z2);
        xVar.f1301c = vVar.j().a(xVar);
        return xVar;
    }

    private void e() {
        this.b.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a("response.body().close()"));
    }

    a0 a() throws IOException {
        ArrayList arrayList = new ArrayList(this.a.n());
        arrayList.add(this.b);
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.a(this.a.f()));
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.a(this.a.o()));
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.a(this.a));
        if (!this.f1303e) {
            arrayList.addAll(this.a.p());
        }
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.b(this.f1303e));
        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.g(arrayList, null, null, null, 0, this.f1302d, this, this.f1301c, this.a.c(), this.a.u(), this.a.y()).a(this.f1302d);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e
    public void a(f fVar) {
        synchronized (this) {
            if (this.f1304f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f1304f = true;
        }
        e();
        this.f1301c.b(this);
        this.a.g().a(new a(fVar));
    }

    public boolean b() {
        return this.b.a();
    }

    String c() {
        return this.f1302d.g().l();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public x m8clone() {
        return a(this.a, this.f1302d, this.f1303e);
    }

    String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(b() ? "canceled " : "");
        sb.append(this.f1303e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(c());
        return sb.toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e
    public a0 i() throws IOException {
        synchronized (this) {
            if (this.f1304f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f1304f = true;
        }
        e();
        this.f1301c.b(this);
        try {
            try {
                this.a.g().a(this);
                a0 a0VarA = a();
                if (a0VarA == null) {
                    throw new IOException("Canceled");
                }
                if (a0VarA.f895c != 0) {
                    return a0VarA;
                }
                throw new IOException(a0VarA.f896d);
            } catch (IOException e2) {
                this.f1301c.a(this, e2);
                throw e2;
            }
        } finally {
            this.a.g().b(this);
        }
    }
}
