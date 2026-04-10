package com.google.android.play.core.splitinstall;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplitInstallSessionState f6964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f6965b;

    public b(f fVar, SplitInstallSessionState splitInstallSessionState) {
        this.f6965b = fVar;
        this.f6964a = splitInstallSessionState;
    }

    public void a(int i) {
        this.f6965b.f6967b.post(new g(this, i));
    }
}
