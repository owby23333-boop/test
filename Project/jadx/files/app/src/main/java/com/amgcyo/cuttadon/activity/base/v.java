package com.amgcyo.cuttadon.activity.base;

import com.amgcyo.cuttadon.utils.otherutils.g0;

/* JADX INFO: compiled from: BaseTitleBarActivity.java */
/* JADX INFO: loaded from: classes.dex */
class v extends com.amgcyo.cuttadon.j.g.h.a<String, Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseTitleBarActivity f2306c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v(BaseTitleBarActivity baseTitleBarActivity, String str) {
        super(str);
        this.f2306c = baseTitleBarActivity;
    }

    @Override // com.amgcyo.cuttadon.j.g.g.a
    public Boolean a(String str) {
        return Boolean.valueOf(this.f2306c.isRunningInForeground());
    }

    @Override // com.amgcyo.cuttadon.j.g.g.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Boolean bool) {
        this.f2306c.f2263c0 = bool.booleanValue();
        g0.a().b("currentt_run_foreground", this.f2306c.f2263c0);
        if (this.f2306c.f2263c0) {
            return;
        }
        String str = this.f2306c.f2273s;
        com.amgcyo.cuttadon.app.o.c.a(com.amgcyo.cuttadon.app.o.c.a() + 1);
        if (com.amgcyo.cuttadon.sdk.utils.h.a("awaken", "scheme") == 2) {
            com.amgcyo.cuttadon.utils.otherutils.h.Q0();
        }
    }
}
