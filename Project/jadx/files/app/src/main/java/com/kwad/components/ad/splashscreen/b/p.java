package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.h;
import com.kwai.adclient.logger.model.BusinessType;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends e implements com.kwad.sdk.core.g.c {
    private SkipView DC;
    private ImageView gQ;
    private AdInfo mAdInfo;
    private volatile boolean DA = false;
    private boolean DB = false;
    private boolean Cz = false;
    private boolean CC = false;
    private h.a gS = new h.a() { // from class: com.kwad.components.ad.splashscreen.b.p.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            p.this.DA = false;
            if (p.this.gQ != null) {
                p.this.gQ.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.p.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        p pVar = p.this;
                        com.kwad.components.ad.splashscreen.d.a aVar = pVar.Cx.BY;
                        if (aVar != null) {
                            aVar.setAudioEnabled(pVar.DA, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = p.this.Cx;
                        if (hVar != null) {
                            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
                            boolean z2 = p.this.DA;
                            AdInfo.AdSplashInfo adSplashInfo = adInfoCb.adSplashInfo;
                            String str = z2 ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                p.this.gQ.setImageDrawable(p.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(p.this.gQ, str, p.this.Cx.mAdTemplate);
                            }
                            p.this.gQ.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.video.i DD = new com.kwad.components.core.video.i() { // from class: com.kwad.components.ad.splashscreen.b.p.2
        private boolean DG = false;
        private String DH = com.kwad.components.ad.splashscreen.a.b.kV();

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            if (this.DG) {
                return;
            }
            p.this.Cx.kO();
            this.DG = true;
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            if (p.this.CC) {
                return;
            }
            p.this.Cx.f(0, "onVideoPlayError");
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, final long j3) {
            p.this.Cx.ab(((int) j3) / 1000);
            final int iMin = Math.min(p.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j2) / 1000);
            final String str = this.DH;
            p pVar = p.this;
            if (p.a(pVar, pVar.mAdInfo)) {
                p.this.DC.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.p.2.1
                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i2 = (int) ((((long) (iMin * 1000)) - j3) / 1000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        p.this.DC.ad(str + i2);
                    }
                });
            }
            float f2 = j3 / 1000.0f;
            if (iMin > 0) {
                double d2 = f2;
                Double.isNaN(d2);
                if (d2 + 0.5d <= iMin - 1 || this.DG) {
                    return;
                }
                p pVar2 = p.this;
                if (p.a(pVar2, pVar2.mAdInfo)) {
                    p.this.Cx.kO();
                    this.DG = true;
                }
            }
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            p pVar = p.this;
            com.kwad.components.ad.splashscreen.d.a aVar = pVar.Cx.BY;
            if (aVar != null) {
                aVar.setAudioEnabled(pVar.DA, false);
            }
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            if (p.this.DB) {
                return;
            }
            p.this.Cx.kN();
            com.kwad.components.ad.splashscreen.d.a aVar = p.this.Cx.BY;
            if (aVar != null) {
                aVar.ag(true);
                p pVar = p.this;
                pVar.Cx.BY.setAudioEnabled(pVar.DA, true);
            }
            p.b(p.this, true);
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPrepared() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPreparing() {
        }
    };

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.a.a.cd(adInfo));
    }

    static /* synthetic */ boolean a(p pVar, AdInfo adInfo) {
        return q(adInfo);
    }

    static /* synthetic */ boolean b(p pVar, boolean z2) {
        pVar.DB = true;
        return true;
    }

    private static boolean q(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.a.a.ca(adInfo);
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aS() {
        if (this.Cz) {
            return;
        }
        this.Cz = true;
        com.kwad.components.ad.splashscreen.local.c.Z(getContext());
        com.kwad.components.core.r.c.qa().a(this.Cx.mAdTemplate, null, null);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "adShowSuccess").report();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aT() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cx.BY;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate);
        ((DetailVideoView) this.Cx.mRootContainer.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cx.BY;
        if (aVar != null) {
            aVar.a(this.DD);
        }
        this.Cx.BZ.a(this);
        this.DC = (SkipView) this.Cx.mRootContainer.findViewById(R.id.ksad_splash_skip_view);
        if (q(this.mAdInfo)) {
            a(this.DC, this.mAdInfo);
        }
        int i2 = this.mAdInfo.adSplashInfo.mute;
        boolean z2 = true;
        if (i2 == 2) {
            this.DA = z2;
        } else if (i2 != 3) {
            this.DA = false;
        } else {
            if (com.kwad.sdk.utils.k.bT(this.Cx.mRootContainer.getContext()) <= 0) {
                z2 = false;
            }
            this.DA = z2;
        }
        if (com.kwad.components.core.r.b.ar(getContext()).pY()) {
            this.DA = false;
        }
        com.kwad.components.ad.splashscreen.d.a aVar2 = this.Cx.BY;
        if (aVar2 != null) {
            aVar2.setAudioEnabled(this.DA, false);
            this.Cx.BY.a(this.gS);
        }
        this.gQ = (ImageView) this.Cx.mRootContainer.findViewById(R.id.ksad_splash_sound);
        this.gQ.setVisibility(0);
        String str = this.DA ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        if (TextUtils.isEmpty(str)) {
            this.gQ.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        } else {
            KSImageLoader.loadImage(this.gQ, str, this.Cx.mAdTemplate);
        }
        this.gQ.setSelected(this.DA);
        this.gQ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.b.p.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.this.DA = !r4.DA;
                String str2 = p.this.DA ? p.this.mAdInfo.adSplashInfo.speakerIconUrl : p.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    p.this.gQ.setImageDrawable(p.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(p.this.gQ, str2, p.this.Cx.mAdTemplate);
                }
                p.this.gQ.setSelected(p.this.DA);
                p pVar = p.this;
                pVar.Cx.BY.setAudioEnabled(pVar.DA, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.CC = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cx.BY;
        if (aVar != null) {
            aVar.b(this.DD);
            this.Cx.BY.b(this.gS);
        }
        if (this.DC.getHandler() != null) {
            this.DC.getHandler().removeCallbacksAndMessages(null);
        }
        this.Cx.BZ.b(this);
    }
}
