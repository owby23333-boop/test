package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class i extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private t f868e;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f868e = tVar;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f868e = tVar;
        return this;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a() {
        return this.f868e.a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a(long j2) {
        return this.f868e.a(j2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a(long j2, TimeUnit timeUnit) {
        return this.f868e.a(j2, timeUnit);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t b() {
        return this.f868e.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public long c() {
        return this.f868e.c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public boolean d() {
        return this.f868e.d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public void e() throws IOException {
        this.f868e.e();
    }

    public final t g() {
        return this.f868e;
    }
}
