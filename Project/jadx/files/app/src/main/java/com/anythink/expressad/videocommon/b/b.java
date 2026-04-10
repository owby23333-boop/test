package com.anythink.expressad.videocommon.b;

import com.anythink.core.common.res.a.a;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private String a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.anythink.core.common.res.a.a f12134d;

    public b(String str, int i2, int i3) {
        this.a = str;
        this.b = i2;
        this.f12133c = i3;
        this.f12134d = com.anythink.core.common.res.a.c.a().a(this.a);
        this.f12134d.a(new com.anythink.core.common.res.a.b(i2, i3));
    }

    public final void a(a.AbstractC0170a abstractC0170a) {
        this.f12134d.a(abstractC0170a);
    }

    public final void b() {
        this.f12134d.f();
    }

    public final void a() {
        this.f12134d.e();
    }
}
