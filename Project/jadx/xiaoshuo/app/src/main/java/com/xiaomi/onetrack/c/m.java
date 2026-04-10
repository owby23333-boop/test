package com.xiaomi.onetrack.c;

/* JADX INFO: loaded from: classes8.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7641b;
    final /* synthetic */ String c;
    final /* synthetic */ l d;

    public m(l lVar, String str, String str2, String str3) {
        this.d = lVar;
        this.f7640a = str;
        this.f7641b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.b(this.f7640a, this.f7641b, this.c);
    }
}
