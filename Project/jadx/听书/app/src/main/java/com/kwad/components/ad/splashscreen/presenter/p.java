package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSlideHandView;
import com.kwad.components.ad.splashscreen.widget.KsSlideRoundView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends e {
    private KsSlideRoundView GJ;
    private KsSplashSlidePathView GK;
    private double GQ;
    private AdMatrixInfo.SplashSlideInfo GR;
    private float GS;
    private float GT;
    private float GU;
    private float GV;
    private float GW;
    private float GX;
    private boolean GY = false;
    private boolean GZ = false;
    private com.kwad.components.ad.splashscreen.e.a Gy;
    private View Hu;
    private TextView Hv;
    private KsSlideHandView Hw;
    private com.kwad.components.core.e.d.c Hx;
    private AdInfo mAdInfo;
    private long mStartTime;

    static /* synthetic */ boolean a(p pVar, boolean z) {
        pVar.GZ = true;
        return true;
    }

    static /* synthetic */ boolean b(p pVar, boolean z) {
        pVar.GY = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.Gf == null) {
            return;
        }
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        this.Hx = this.Gf.mApkDownloadHelper;
        this.GR = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.GQ = r0.convertDistance;
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
        if (viewStub != null) {
            this.GK = (KsSplashSlidePathView) viewStub.inflate();
        } else {
            this.GK = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
        }
        KsSplashSlidePathView ksSplashSlidePathView = this.GK;
        if (ksSplashSlidePathView != null) {
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.1
                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f, float f2, float f3, float f4) {
                    final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(p.this.mv(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                    if (fPx2dip < p.this.GQ || p.this.Gf == null) {
                        return;
                    }
                    p.this.Gf.a(1, p.this.mv(), MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.1.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.dn(p.this.GR.style);
                            bVar.m613do((int) fPx2dip);
                        }
                    });
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void c(MotionEvent motionEvent) {
                    if (p.this.GY && p.this.GZ) {
                        float x = motionEvent.getX() + p.this.GU;
                        float y = motionEvent.getY() + p.this.GV;
                        if (x >= p.this.GS && x <= p.this.GS + p.this.GW && y >= p.this.GT && y <= p.this.GT + p.this.GX) {
                            p.this.mu();
                            return;
                        }
                    }
                    if (com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                        p.this.mu();
                    }
                }
            });
            this.GK.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.p.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    p.this.GK.getLocationOnScreen(new int[2]);
                    p.this.GU = r0[0];
                    p.this.GV = r0[1];
                    p.a(p.this, true);
                }
            });
        }
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.p.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                p.this.Gf.FH = SystemClock.elapsedRealtime() - p.this.mStartTime;
            }
        });
        initView();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            mw();
        }
        ao();
        je();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mu() {
        if (this.Gf != null) {
            this.Gf.c(1, mv(), 53, 2);
        }
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_slide_combo_layout);
        if (viewStub != null) {
            this.Hu = viewStub.inflate();
        } else {
            this.Hu = findViewById(R.id.ksad_slide_combo_root);
        }
        this.Hw = (KsSlideHandView) findViewById(R.id.ksad_slide_combo_slide_hand);
        this.Hv = (TextView) findViewById(R.id.ksad_slide_combo_action_sub_text);
        this.GJ = (KsSlideRoundView) findViewById(R.id.ksad_slide_combo_round_bg);
        this.Hv.setText(mx());
        this.GJ.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.p.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                p.this.GJ.getLocationOnScreen(new int[2]);
                p.this.GS = r0[0];
                p.this.GT = r0[1];
                p.this.GW = r0.GJ.getWidth();
                p.this.GX = r0.GJ.getHeight();
                p.b(p.this, true);
            }
        });
    }

    protected final Context mv() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        return (context != null || (view = this.Hu) == null) ? context : view.getContext();
    }

    private void ao() {
        if (this.Hu == null || this.Gf == null) {
            return;
        }
        this.Hu.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE);
    }

    private void mw() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Gy;
        if (aVar == null) {
            com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(mv(), this.Gf.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.p.5
                {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void j(int i, String str) {
                    if (p.this.Hv != null) {
                        p.this.Hv.setText(str);
                    }
                }
            };
            this.Gy = aVar2;
            this.Hx.b(aVar2);
            return;
        }
        aVar.setAdTemplate(this.Gf.mAdTemplate);
    }

    private String mx() {
        try {
            return TextUtils.isEmpty(com.kwad.sdk.core.response.b.b.dI(this.mAdInfo)) ? com.kwad.sdk.core.response.b.b.dI(this.mAdInfo) : "跳转详情页或第三方应用";
        } catch (Exception unused) {
            return "跳转详情页或第三方应用";
        }
    }

    private void je() {
        KsSlideHandView ksSlideHandView = this.Hw;
        if (ksSlideHandView != null) {
            ksSlideHandView.fM();
        }
        KsSlideRoundView ksSlideRoundView = this.GJ;
        if (ksSlideRoundView != null) {
            ksSlideRoundView.fM();
        }
    }
}
