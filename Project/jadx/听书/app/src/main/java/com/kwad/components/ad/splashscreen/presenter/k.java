package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends e implements com.kwad.sdk.core.j.c {
    private View GC;
    private View GD;
    private ViewTreeObserver.OnGlobalLayoutListener GE;
    private boolean GB = false;
    private boolean GF = false;

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
    }

    static /* synthetic */ boolean a(k kVar, View view) {
        return v(view);
    }

    static /* synthetic */ boolean a(k kVar, boolean z) {
        kVar.GB = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.Gf.mAdTemplate.addStartTime = SystemClock.elapsedRealtime();
        this.Gf.Fs.a(this);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.f(this.Gf.mAdTemplate, SystemClock.elapsedRealtime() - this.Gf.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.ap(this.Gf.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cF(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            this.Gf.U(getContext());
        }
        try {
            this.GD = getRootView();
            this.GE = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ad.splashscreen.presenter.k.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    try {
                        if (k.this.GC == null || k.this.GD == null || k.this.GC.getVisibility() != 0 || k.this.GB) {
                            return;
                        }
                        k.a(k.this, true);
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.aj(k.this.Gf.mAdTemplate);
                        k.this.GD.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.k.1.1
                            @Override // com.kwad.sdk.utils.bg
                            public final void doTask() {
                                if (k.this.GD.getVisibility() == 0) {
                                    if (k.this.Gf.mAdTemplate.mPvReported) {
                                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                        com.kwad.components.ad.splashscreen.monitor.b.ak(k.this.Gf.mAdTemplate);
                                        return;
                                    }
                                    if (!k.this.Gf.Fs.wl()) {
                                        boolean zA = k.a(k.this, k.this.GD);
                                        boolean z = false;
                                        if (k.this.GC != null && k.this.GC.getVisibility() == 0) {
                                            z = true;
                                        }
                                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(k.this.Gf.mAdTemplate, zA, z, k.this.GF);
                                        return;
                                    }
                                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                    com.kwad.components.ad.splashscreen.monitor.b.al(k.this.Gf.mAdTemplate);
                                    return;
                                }
                                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                                com.kwad.components.ad.splashscreen.monitor.b.am(k.this.Gf.mAdTemplate);
                            }
                        }, 1000L);
                    } catch (Throwable unused) {
                    }
                }
            };
            if (this.GD != null && getRootView().getParent() != null && (getRootView().getParent() instanceof View)) {
                View view = (View) getRootView().getParent();
                this.GC = view;
                if (view.getViewTreeObserver() != null) {
                    this.GC.getViewTreeObserver().addOnGlobalLayoutListener(this.GE);
                    return;
                }
                return;
            }
            if (this.GD == null) {
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.an(this.Gf.mAdTemplate);
            } else {
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.ao(this.Gf.mAdTemplate);
            }
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.GF = true;
        this.Gf.Fs.b(this);
        View view = this.GC;
        if (view != null && view.getViewTreeObserver() != null && this.GE != null) {
            this.GC.getViewTreeObserver().removeOnGlobalLayoutListener(this.GE);
        }
        this.GC = null;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        this.Gf.U(getContext());
    }

    private static boolean v(View view) {
        if (view == null) {
            return false;
        }
        com.kwad.sdk.core.c.b.Ho();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.Ho();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && bz.a(view, 70, true);
        }
        return bz.a(view, 70, true);
    }
}
