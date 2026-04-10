package com.xiaomi.push;

import com.xiaomi.push.aj;

/* JADX INFO: loaded from: classes8.dex */
class al implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aj.b f7793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    final /* synthetic */ aj f133a;

    public al(aj ajVar, aj.b bVar) {
        this.f133a = ajVar;
        this.f7793a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f133a.a(this.f7793a);
    }
}
