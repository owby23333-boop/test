package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements h {
    private final h a;
    private final com.anythink.expressad.exoplayer.k.v b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9769c;

    public w(h hVar, com.anythink.expressad.exoplayer.k.v vVar, int i2) {
        this.a = (h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.b = (com.anythink.expressad.exoplayer.k.v) com.anythink.expressad.exoplayer.k.a.a(vVar);
        this.f9769c = i2;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        this.b.a(this.f9769c);
        return this.a.a(kVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.a.b();
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) {
        this.b.a(this.f9769c);
        return this.a.a(bArr, i2, i3);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    @Nullable
    public final Uri a() {
        return this.a.a();
    }
}
