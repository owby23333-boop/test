package com.anythink.basead.ui;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final /* synthetic */ ThirdPartyFullScreenAdView f6326s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final /* synthetic */ int f6327t;

    public /* synthetic */ f(ThirdPartyFullScreenAdView thirdPartyFullScreenAdView, int i2) {
        this.f6326s = thirdPartyFullScreenAdView;
        this.f6327t = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6326s.f(this.f6327t);
    }
}
