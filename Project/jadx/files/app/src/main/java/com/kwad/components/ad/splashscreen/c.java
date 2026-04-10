package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bg;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.core.j.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private KsSplashScreenAd.SplashScreenAdInteractionListener BP;
    private com.kwad.components.ad.splashscreen.e.d BQ;
    private int BR;
    private com.kwad.sdk.core.g.b cb;
    private AdInfo mAdInfo;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private KsVideoPlayConfig mVideoPlayConfig;

    private c(Context context, AdTemplate adTemplate) {
        super(context);
        this.mAdTemplate = adTemplate;
        this.mAdScene = adTemplate.mAdScene;
        oa();
    }

    public static c a(Context context, @NonNull AdResultData adResultData, com.kwad.sdk.core.g.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) throws Throwable {
        c cVar;
        AdTemplate adTemplate;
        try {
            com.kwad.sdk.f.a.T(com.anythink.expressad.foundation.g.a.f.f10440f, TTLogUtil.TAG_EVENT_SHOW);
            Context contextWrapContextIfNeed = Wrapper.wrapContextIfNeed(context);
            adTemplate = new AdTemplate();
            if (!adResultData.getAdTemplateList().isEmpty()) {
                adTemplate = adResultData.getAdTemplateList().get(0);
            }
            adTemplate.showStartTime = SystemClock.elapsedRealtime();
            cVar = new c(contextWrapContextIfNeed, adTemplate);
        } catch (Throwable th) {
            th = th;
            cVar = null;
        }
        try {
            cVar.setPageExitListener(bVar);
            cVar.setSplashScreenAdListener(splashScreenAdInteractionListener);
            com.kwad.components.splash.monitor.a.sp();
            com.kwad.components.splash.monitor.a.X(adTemplate);
            com.kwad.components.splash.monitor.a.sp();
            com.kwad.components.splash.monitor.a.i(adTemplate, KsAdSDKImpl.get().getSDKInitTime());
            com.kwad.sdk.f.a.U(com.anythink.expressad.foundation.g.a.f.f10440f, TTLogUtil.TAG_EVENT_SHOW);
        } catch (Throwable th2) {
            th = th2;
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            com.kwad.components.core.c.a.b(th);
        }
        return cVar;
    }

    private com.kwad.sdk.core.g.c a(final h hVar) {
        return new com.kwad.sdk.core.g.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.g.c
            public final void aS() {
                bg bgVar = hVar.mTimerHelper;
                if (bgVar != null) {
                    bgVar.ET();
                }
            }

            @Override // com.kwad.sdk.core.g.c
            public final void aT() {
                bg bgVar = hVar.mTimerHelper;
                if (bgVar != null) {
                    bgVar.EU();
                }
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.kwad.sdk.mvp.Presenter c(android.content.Context r5, com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            com.kwad.sdk.mvp.Presenter r0 = new com.kwad.sdk.mvp.Presenter
            r0.<init>()
            com.kwad.components.ad.splashscreen.b.b r1 = new com.kwad.components.ad.splashscreen.b.b
            r1.<init>()
            r0.a(r1)
            com.kwad.components.ad.splashscreen.b.c r1 = new com.kwad.components.ad.splashscreen.b.c
            r1.<init>()
            r0.a(r1)
            com.kwad.components.ad.splashscreen.b.n r1 = new com.kwad.components.ad.splashscreen.b.n
            r1.<init>()
            r0.a(r1)
            boolean r1 = com.kwad.sdk.core.response.a.a.aV(r6)
            if (r1 == 0) goto L31
            com.kwad.components.ad.splashscreen.b.d r1 = new com.kwad.components.ad.splashscreen.b.d
            r1.<init>()
            r0.a(r1)
            com.kwad.components.ad.splashscreen.b.p r1 = new com.kwad.components.ad.splashscreen.b.p
            r1.<init>()
            goto L36
        L31:
            com.kwad.components.ad.splashscreen.b.h r1 = new com.kwad.components.ad.splashscreen.b.h
            r1.<init>()
        L36:
            r0.a(r1)
            boolean r1 = com.kwad.sdk.core.response.a.b.cU(r6)
            boolean r2 = com.kwad.sdk.core.response.a.b.cW(r6)
            boolean r3 = com.kwad.sdk.core.response.a.b.da(r6)
            boolean r4 = com.kwad.sdk.core.response.a.b.cY(r6)
            if (r4 == 0) goto L54
            com.kwad.components.ad.splashscreen.b.m r1 = new com.kwad.components.ad.splashscreen.b.m
            r1.<init>()
        L50:
            r0.a(r1)
            goto L6c
        L54:
            if (r1 == 0) goto L5c
            com.kwad.components.ad.splashscreen.b.l r1 = new com.kwad.components.ad.splashscreen.b.l
            r1.<init>()
            goto L50
        L5c:
            if (r2 == 0) goto L64
            com.kwad.components.ad.splashscreen.b.k r1 = new com.kwad.components.ad.splashscreen.b.k
            r1.<init>()
            goto L50
        L64:
            if (r3 == 0) goto L6c
            com.kwad.components.ad.splashscreen.b.o r1 = new com.kwad.components.ad.splashscreen.b.o
            r1.<init>()
            goto L50
        L6c:
            boolean r1 = com.kwad.sdk.core.response.a.a.aI(r6)
            if (r1 == 0) goto L7a
            com.kwad.components.ad.splashscreen.b.f r1 = new com.kwad.components.ad.splashscreen.b.f
            r1.<init>()
            r0.a(r1)
        L7a:
            boolean r5 = com.kwad.components.ad.splashscreen.h.d(r5, r6)
            if (r5 == 0) goto L88
            com.kwad.components.ad.splashscreen.b.kwai.f r5 = new com.kwad.components.ad.splashscreen.b.kwai.f
            r5.<init>()
            r0.a(r5)
        L88:
            com.kwad.components.ad.splashscreen.b.j r5 = new com.kwad.components.ad.splashscreen.b.j
            r5.<init>()
            r0.a(r5)
            com.kwad.components.ad.splashscreen.b.a r5 = new com.kwad.components.ad.splashscreen.b.a
            r5.<init>()
            r0.a(r5)
            com.kwad.components.ad.splashscreen.b.g r5 = new com.kwad.components.ad.splashscreen.b.g
            r5.<init>()
            r0.a(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.c.c(android.content.Context, com.kwad.sdk.core.response.model.AdInfo):com.kwad.sdk.mvp.Presenter");
    }

    private int getSplashLayoutId() {
        int i2 = this.BR;
        return i2 == 1 ? R.layout.ksad_splash_screen_skip_button_top_left : i2 == 0 ? R.layout.ksad_splash_screen_skip_button_top_right : i2 == 2 ? R.layout.ksad_splash_screen_skip_button_bottom_left : i2 == 3 ? R.layout.ksad_splash_screen_skip_button_bottom_right : R.layout.ksad_splash_screen_skip_button_top_right;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.j.c
    /* JADX INFO: renamed from: kE, reason: merged with bridge method [inline-methods] */
    public h kH() {
        this.BQ = new com.kwad.components.ad.splashscreen.e.d(this.lU, 70);
        this.BQ.a(this.cb);
        this.BQ.rU();
        if (this.mVideoPlayConfig == null) {
            this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        }
        h hVar = new h();
        hVar.setSplashScreenAdListener(this.BP);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdTemplate = this.mAdTemplate;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.BZ = this.BQ;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.BR = this.BR;
        hVar.mTimerHelper = new bg();
        if (com.kwad.sdk.core.response.a.a.aV(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.d.a aVar = new com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.BY = aVar;
            hVar.BZ.a(aVar);
        }
        hVar.BZ.a(a(hVar));
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kG() {
        if (com.kwad.components.ad.splashscreen.e.c.a(getContext(), getWidth(), getHeight()) && this.BR != 0) {
            if (com.kwad.components.ad.splashscreen.e.c.d((h) this.Ki) == 2) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 16, 16, -1);
            } else if (com.kwad.components.ad.splashscreen.e.c.d((h) this.Ki) == 3) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 16, -1, 16);
            }
        }
    }

    private void notifyPageDismiss() {
        com.kwad.sdk.kwai.kwai.c.tm().tp();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    public static boolean o(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.core.j.c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.j.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.BR = this.mAdInfo.adSplashInfo.skipButtonPosition;
        this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.j.c
    public final boolean kD() {
        return true;
    }

    @Override // com.kwad.components.core.j.c
    public final void kF() {
        this.mRootContainer = (AdBaseFrameLayout) this.lU.findViewById(R.id.ksad_splash_root_container);
        this.mDetailVideoView = (DetailVideoView) this.lU.findViewById(R.id.ksad_splash_video_player);
        this.mDetailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (com.kwad.sdk.b.kwai.a.tN() || !c.o(c.this.mAdInfo) || c.this.Ki == null) {
                    return;
                }
                ((h) c.this.Ki).c(1, view.getContext(), 53, 2);
            }
        });
    }

    @Override // com.kwad.components.core.j.c
    @NonNull
    public final Presenter onCreatePresenter() {
        return c(getContext(), this.mAdInfo);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean zNc = dialogInterface instanceof com.kwad.components.core.d.a.b ? ((com.kwad.components.core.d.a.b) dialogInterface).nc() : false;
        try {
            if (this.BP != null) {
                if (zNc) {
                    this.BP.onDownloadTipsDialogDismiss();
                } else {
                    this.BP.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            if (this.BP != null) {
                this.BP.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.components.core.j.c, com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        com.kwad.components.splash.monitor.a.sp();
        com.kwad.components.splash.monitor.a.W(this.mAdTemplate);
        post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // java.lang.Runnable
            public final void run() {
                c.this.kG();
            }
        });
        T t2 = this.Ki;
        if (((h) t2).BY != null) {
            ((h) t2).BY.lL();
        }
    }

    @Override // com.kwad.components.core.j.c, com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.setOnDismissListener(null);
            this.mApkDownloadHelper.setOnShowListener(null);
        }
        this.BQ.rV();
        notifyPageDismiss();
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    public final void setPageExitListener(com.kwad.sdk.core.g.b bVar) {
        this.cb = bVar;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.BP = splashScreenAdInteractionListener;
        T t2 = this.Ki;
        if (t2 != 0) {
            ((h) t2).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }
}
