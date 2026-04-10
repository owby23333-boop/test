package com.xiaomi.onetrack.api;

/* JADX INFO: loaded from: classes8.dex */
class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Thread f7563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Throwable f7564b;
    final /* synthetic */ k c;

    public l(k kVar, Thread thread, Throwable th) {
        this.c = kVar;
        this.f7563a = thread;
        this.f7564b = th;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        this.c.a(this.f7563a, this.f7564b);
    }
}
