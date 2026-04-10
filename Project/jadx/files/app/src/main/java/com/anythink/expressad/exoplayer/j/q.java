package com.anythink.expressad.exoplayer.j;

import com.anythink.expressad.exoplayer.j.s;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends s.a {
    private final String a;
    private final aa<? super h> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f9735e;

    public q(String str) {
        this(str, null);
    }

    private p b(s.f fVar) {
        return new p(this.a, null, this.b, this.f9733c, this.f9734d, this.f9735e, fVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.s.a
    protected final /* synthetic */ s a(s.f fVar) {
        return new p(this.a, null, this.b, this.f9733c, this.f9734d, this.f9735e, fVar);
    }

    public q(String str, aa<? super h> aaVar) {
        this(str, aaVar, (byte) 0);
    }

    private q(String str, aa<? super h> aaVar, byte b) {
        this.a = str;
        this.b = aaVar;
        this.f9733c = 8000;
        this.f9734d = 8000;
        this.f9735e = false;
    }
}
