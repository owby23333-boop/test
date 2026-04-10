package com.anythink.expressad.video.bt.module.b;

import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends c {
    private static final String a = "H5ShowRewardListener";
    private com.anythink.expressad.video.bt.module.a.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11560c;

    public d(com.anythink.expressad.video.bt.module.a.b bVar, String str) {
        this.b = bVar;
        this.f11560c = str;
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a() {
        if (this.b != null) {
            o.a(a, "onAdShow");
            this.b.a(this.f11560c);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void b() {
        if (this.b != null) {
            o.a(a, "onVideoComplete");
            this.b.b(this.f11560c);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void c() {
        if (this.b != null) {
            o.a(a, "onEndcardShow");
            this.b.c(this.f11560c);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(boolean z2, com.anythink.expressad.videocommon.c.c cVar) {
        if (this.b != null) {
            o.a(a, "onAdClose");
            this.b.a(this.f11560c, z2, cVar);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(String str) {
        if (this.b != null) {
            o.a(a, "onShowFail");
            this.b.a(this.f11560c, str);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        if (this.b != null) {
            o.a(a, "onVideoAdClicked");
            this.b.a(this.f11560c, cVar);
        }
    }
}
