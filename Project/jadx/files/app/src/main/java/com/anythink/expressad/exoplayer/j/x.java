package com.anythink.expressad.exoplayer.j;

import com.anythink.expressad.exoplayer.j.h;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements h.a {
    private final h.a a;
    private final com.anythink.expressad.exoplayer.k.v b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9770c;

    private x(h.a aVar, com.anythink.expressad.exoplayer.k.v vVar, int i2) {
        this.a = aVar;
        this.b = vVar;
        this.f9770c = i2;
    }

    private w b() {
        return new w(this.a.a(), this.b, this.f9770c);
    }

    @Override // com.anythink.expressad.exoplayer.j.h.a
    public final /* synthetic */ h a() {
        return new w(this.a.a(), this.b, this.f9770c);
    }
}
