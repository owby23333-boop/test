package com.xiaomi.push;

import com.xiaomi.push.aj;

/* JADX INFO: loaded from: classes8.dex */
class ht extends aj.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f8054a;

    public ht(Runnable runnable) {
        this.f8054a = runnable;
    }

    @Override // com.xiaomi.push.aj.b
    public void b() {
        this.f8054a.run();
    }
}
