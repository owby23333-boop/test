package com.google.android.play.core.splitinstall;

/* JADX INFO: loaded from: classes7.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f6968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ b f6969b;

    public g(b bVar, int i) {
        this.f6969b = bVar;
        this.f6968a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f6969b;
        bVar.f6965b.a(bVar.f6964a.a(this.f6968a));
    }
}
