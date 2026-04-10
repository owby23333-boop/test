package com.anythink.expressad.exoplayer.h;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.s;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements r, r.a {
    public final s a;
    public final s.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.b f9356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private r f9357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private r.a f9358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f9359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private a f9360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f9362i = com.anythink.expressad.exoplayer.b.b;

    public interface a {
        void a(s.a aVar, IOException iOException);
    }

    public l(s sVar, s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        this.b = aVar;
        this.f9356c = bVar;
        this.a = sVar;
    }

    private void h() {
        this.f9358e.a(this);
    }

    public final void a(a aVar) {
        this.f9360g = aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j2) {
        this.f9357d.a_(j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.f9357d.b();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        return this.f9357d.c();
    }

    public final void d(long j2) {
        if (this.f9359f != 0 || j2 == 0) {
            return;
        }
        this.f9362i = j2;
        this.f9359f = j2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        return this.f9357d.e();
    }

    public final void f() {
        this.f9357d = this.a.a(this.b, this.f9356c);
        if (this.f9358e != null) {
            this.f9357d.a(this, this.f9359f);
        }
    }

    public final void g() {
        r rVar = this.f9357d;
        if (rVar != null) {
            this.a.a(rVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j2) {
        this.f9358e = aVar;
        this.f9359f = j2;
        r rVar = this.f9357d;
        if (rVar != null) {
            rVar.a(this, j2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j2) {
        return this.f9357d.b(j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j2) {
        r rVar = this.f9357d;
        return rVar != null && rVar.c(j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        return this.f9357d.d();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() throws IOException {
        try {
            if (this.f9357d != null) {
                this.f9357d.a();
            } else {
                this.a.b();
            }
        } catch (IOException e2) {
            a aVar = this.f9360g;
            if (aVar != null) {
                if (this.f9361h) {
                    return;
                }
                this.f9361h = true;
                aVar.a(this.b, e2);
                return;
            }
            throw e2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2) {
        long j3;
        long j4 = this.f9362i;
        if (j4 == com.anythink.expressad.exoplayer.b.b || j2 != 0) {
            j3 = j2;
        } else {
            this.f9362i = com.anythink.expressad.exoplayer.b.b;
            j3 = j4;
        }
        return this.f9357d.a(fVarArr, zArr, yVarArr, zArr2, j3);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j2, boolean z2) {
        this.f9357d.a(j2, z2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j2, com.anythink.expressad.exoplayer.ac acVar) {
        return this.f9357d.a(j2, acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(r rVar) {
        this.f9358e.a((r) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(z zVar) {
        this.f9358e.a(this);
    }
}
