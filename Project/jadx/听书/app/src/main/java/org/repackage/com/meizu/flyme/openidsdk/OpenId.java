package org.repackage.com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: classes4.dex */
class OpenId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f2548a;
    String b;
    String c;
    int d;

    OpenId(String str) {
        this.c = str;
    }

    void a(int i) {
        this.d = i;
    }

    void a(long j) {
        this.f2548a = j;
    }

    void a(String str) {
        this.b = str;
    }

    boolean a() {
        return this.f2548a > System.currentTimeMillis();
    }

    void b() {
        this.f2548a = 0L;
    }
}
