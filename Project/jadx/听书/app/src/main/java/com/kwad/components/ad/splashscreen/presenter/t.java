package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.i;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends e implements com.kwad.sdk.core.j.c {
    private SkipView HU;
    private ImageView ke;
    private AdInfo mAdInfo;
    private volatile boolean HR = false;
    private boolean HS = false;
    private boolean HT = false;
    private i.a kf = new i.a() { // from class: com.kwad.components.ad.splashscreen.presenter.t.1
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            t.this.HR = false;
            if (t.this.ke != null) {
                t.this.ke.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.t.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (t.this.Gf.Fq != null) {
                            t.this.Gf.Fq.setAudioEnabled(t.this.HR, false);
                        }
                        if (t.this.Gf != null) {
                            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(t.this.Gf.mAdTemplate);
                            String str = t.this.HR ? adInfoEl.adSplashInfo.speakerIconUrl : adInfoEl.adSplashInfo.speakerMuteIconUrl;
                            if (!TextUtils.isEmpty(str)) {
                                KSImageLoader.loadImage(t.this.ke, str, t.this.Gf.mAdTemplate);
                            } else {
                                t.this.ke.setImageDrawable(t.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            }
                            t.this.ke.setSelected(false);
                        }
                    }
                });
            }
        }
    };
    private com.kwad.components.core.video.l HV = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.splashscreen.presenter.t.2
        private boolean HY = false;
        private String HZ = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FN);

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, final long j2) {
            t.this.Gf.al(((int) j2) / 1000);
            final int iMin = Math.min(t.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
            final String str = this.HZ;
            t tVar = t.this;
            if (t.a(tVar, tVar.mAdInfo)) {
                t.this.HU.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.t.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = (int) ((((long) (iMin * 1000)) - j2) / 1000);
                        if (i <= 0) {
                            i = 1;
                        }
                        t.this.HU.ac(str + i);
                    }
                });
            }
            float f = j2 / 1000.0f;
            if (iMin <= 0 || ((double) f) + 0.5d <= iMin - 1 || this.HY) {
                return;
            }
            t tVar2 = t.this;
            if (t.a(tVar2, tVar2.mAdInfo)) {
                t.this.Gf.lQ();
                this.HY = true;
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            if (t.this.Gf.Fq != null) {
                t.this.Gf.Fq.setAudioEnabled(t.this.HR, false);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            if (t.this.HS) {
                return;
            }
            t.this.Gf.af(false);
            if (t.this.Gf.Fq != null) {
                t.this.Gf.Fq.ag(true);
                t.this.Gf.Fq.setAudioEnabled(t.this.HR, true);
            }
            t.b(t.this, true);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            if (this.HY) {
                return;
            }
            t.this.Gf.lQ();
            this.HY = true;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            if (t.this.Gf != null && t.this.Gf.Fq != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.b(t.this.Gf.mAdTemplate, 1, t.this.Gf.Fq.Gl, 2, jElapsedRealtime - t.this.Gf.Fq.Jm, jElapsedRealtime - t.this.Gf.mAdTemplate.showTime);
            }
            if (t.this.HT || t.this.Gf == null) {
                return;
            }
            t.this.Gf.c(0, "onMediaPlayError");
        }
    };

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
    }

    static /* synthetic */ boolean a(t tVar, AdInfo adInfo) {
        return u(adInfo);
    }

    static /* synthetic */ boolean b(t tVar, boolean z) {
        tVar.HS = true;
        return true;
    }

    private void a(final DetailVideoView detailVideoView) {
        final View viewFindViewById = findViewById(R.id.splash_play_card_view);
        viewFindViewById.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.t.3
            @Override // java.lang.Runnable
            public final void run() {
                float width = viewFindViewById.getWidth();
                float height = viewFindViewById.getHeight();
                if (width <= 0.0f || height <= 0.0f) {
                    return;
                }
                if (com.kwad.sdk.core.response.b.a.aV(t.this.mAdInfo).videoWidth > 0) {
                    com.kwad.sdk.c.a.a.a(detailVideoView, r0.width, r0.height);
                }
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        int i;
        super.at();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        DetailVideoView detailVideoView = (DetailVideoView) this.Gf.mRootContainer.findViewById(R.id.ksad_splash_video_player);
        detailVideoView.setVisibility(0);
        if (com.kwad.sdk.core.response.b.a.dn(this.mAdInfo)) {
            a(detailVideoView);
        }
        if (this.Gf.Fq != null) {
            this.Gf.Fq.b(this.HV);
        }
        this.Gf.Fs.a(this);
        AdBaseFrameLayout adBaseFrameLayout = this.Gf.mRootContainer;
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            i = R.id.ksad_splash_skip_right_view;
        } else {
            i = R.id.ksad_splash_skip_left_view;
        }
        this.HU = (SkipView) adBaseFrameLayout.findViewById(i);
        if (u(this.mAdInfo)) {
            a(this.HU, this.mAdInfo);
        }
        int i2 = this.mAdInfo.adSplashInfo.mute;
        if (i2 == 2) {
            this.HR = true;
        } else if (i2 == 3) {
            this.HR = com.kwad.sdk.utils.m.cH(this.Gf.mRootContainer.getContext()) > 0;
        } else {
            this.HR = false;
        }
        if (com.kwad.components.core.t.a.aC(getContext()).sW()) {
            this.HR = false;
        }
        if (this.Gf.Fq != null) {
            this.Gf.Fq.setAudioEnabled(this.HR, false);
            this.Gf.Fq.a(this.kf);
        }
        this.ke = (ImageView) this.Gf.mRootContainer.findViewById(R.id.ksad_splash_sound);
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ke.getLayoutParams();
            layoutParams.gravity = 51;
            this.ke.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ke.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(this.ke.getContext(), 32.0f);
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.ke.getContext(), 16.0f);
            }
        }
        this.ke.setVisibility(0);
        String str = this.HR ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        if (!TextUtils.isEmpty(str)) {
            KSImageLoader.loadImage(this.ke, str, this.Gf.mAdTemplate);
        } else {
            this.ke.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        }
        this.ke.setSelected(this.HR);
        this.ke.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.t.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.this.HR = !r4.HR;
                String str2 = t.this.HR ? t.this.mAdInfo.adSplashInfo.speakerIconUrl : t.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                if (!TextUtils.isEmpty(str2)) {
                    KSImageLoader.loadImage(t.this.ke, str2, t.this.Gf.mAdTemplate);
                } else {
                    t.this.ke.setImageDrawable(t.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                t.this.ke.setSelected(t.this.HR);
                t.this.Gf.Fq.setAudioEnabled(t.this.HR, true);
            }
        });
    }

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cB(adInfo);
    }

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cE(adInfo));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.Gf.Fq != null) {
            this.Gf.Fq.a(this.HV);
            this.Gf.Fq.b(this.kf);
        }
        if (this.HU.getHandler() != null) {
            this.HU.getHandler().removeCallbacksAndMessages(null);
        }
        this.Gf.Fs.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.HT = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        if (this.Gf.Fq != null) {
            this.Gf.Fq.pause();
        }
    }
}
