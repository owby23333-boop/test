package com.xiaomi.onetrack.f;

/* JADX INFO: loaded from: classes8.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7677b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    public e(String str, String str2, String str3, String str4) {
        this.f7676a = str;
        this.f7677b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.onetrack.c.c.a().a(com.xiaomi.onetrack.e.b.a(this.f7676a, this.f7677b, this.c, this.d));
    }
}
