package com.xiaomi.onetrack.f;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f7682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f7683b;

    public h(g gVar, Context context) {
        this.f7683b = gVar;
        this.f7682a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.onetrack.c.a.a();
        com.xiaomi.onetrack.api.c.a().d();
        com.xiaomi.onetrack.api.c.a().f();
        com.xiaomi.onetrack.c.c.a(this.f7682a);
    }
}
