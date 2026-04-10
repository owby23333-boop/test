package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.bw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e implements com.kwad.sdk.core.j.c {
    private TextView FX;
    private com.kwad.components.ad.splashscreen.widget.b FY;
    private AdInfo.AdPreloadInfo FZ;
    private boolean Ga = false;
    private View Gb;
    private AdInfo vz;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onBind");
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        this.vz = adInfoEl;
        t(adInfoEl);
        v(this.vz);
        if (u(this.vz)) {
            this.FY = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.z(this.vz) ? R.id.ksad_splash_skip_right_view : R.id.ksad_splash_skip_left_view);
        } else {
            this.FY = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.z(this.vz) ? R.id.ksad_splash_circle_skip_right_view : R.id.ksad_splash_circle_skip_left_view);
        }
        this.FY.a(ma(), this.vz);
        this.FY.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void me() {
                c.this.mb();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void mf() {
                c.this.mc();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void am(int i) {
                c.this.Gf.al(i);
            }
        });
        w(this.vz);
        this.Gf.Fs.a(this);
    }

    private void t(AdInfo adInfo) {
        findViewById(com.kwad.components.ad.splashscreen.e.c.z(adInfo) ? R.id.ksad_splash_right_top_root : R.id.ksad_splash_left_top_root).setVisibility(0);
    }

    private SplashSkipViewModel ma() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        int i = this.vz.adSplashInfo.imageDisplaySecond <= 0 ? 5 : this.vz.adSplashInfo.imageDisplaySecond;
        int iMin = Math.min(this.vz.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.b.a.L(this.vz));
        if (com.kwad.sdk.core.response.b.a.bc(this.vz)) {
            i = iMin;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cB(adInfo);
    }

    private void v(AdInfo adInfo) {
        int i;
        if (com.kwad.components.ad.splashscreen.e.c.z(adInfo)) {
            i = R.id.ksad_splash_preload_right_tips;
        } else {
            i = R.id.ksad_splash_preload_left_tips;
        }
        this.FX = (TextView) findViewById(i);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.FZ = adPreloadInfo;
        if (adPreloadInfo != null && !bp.isNullString(adPreloadInfo.preloadTips)) {
            this.FX.setVisibility(0);
            this.FX.setText(this.FZ.preloadTips);
        } else {
            this.FX.setVisibility(8);
        }
    }

    private void w(AdInfo adInfo) {
        this.Gb = findViewById(R.id.ksad_skip_view_area);
        if (com.kwad.sdk.core.response.b.a.cC(adInfo) && adInfo.adSplashInfo.skipButtonPosition == 0) {
            this.Gb.setVisibility(0);
            this.Gb.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.mb();
                }
            });
            this.Gb.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    ((View) c.this.FY).post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            int iAo = c.this.FY.ao(35);
                            ViewGroup.LayoutParams layoutParams = c.this.Gb.getLayoutParams();
                            layoutParams.width = iAo + com.kwad.sdk.c.a.a.a(c.this.Gf.mRootContainer.getContext(), 66.0f);
                            c.this.Gb.setLayoutParams(layoutParams);
                        }
                    });
                }
            });
            return;
        }
        this.Gb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb() {
        com.kwad.components.ad.splashscreen.monitor.a.lX().ah(this.Gf.mAdTemplate);
        this.Gf.lS();
        JSONObject jSONObject = new JSONObject();
        if (this.Gf.Fq != null) {
            try {
                jSONObject.put("duration", this.Gf.Fq.getCurrentPosition());
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        a.C0392a c0392a = new a.C0392a();
        if (this.Gf.mTimerHelper != null) {
            c0392a.duration = this.Gf.mTimerHelper.getTime();
        }
        com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().de(1).dm(22).b(c0392a), jSONObject);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Gf.Fs.b(this);
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.FY != null) {
                    c.this.FY.cq();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageVisible");
        this.FY.B(this.vz);
        md();
    }

    public final void mc() {
        this.Gf.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.oW()) {
                    c.this.Gf.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.Gf.lQ();
                }
            }
        });
    }

    private synchronized void md() {
        if (!this.Ga && this.FY != null) {
            if (com.kwad.sdk.core.response.b.a.cD(this.vz) && com.kwad.sdk.core.response.b.a.cE(this.vz)) {
                com.kwad.sdk.core.adlog.c.b(this.Gf.mAdTemplate, 124, (JSONObject) null);
                this.Ga = true;
            }
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageInvisible");
        this.FY.A(this.vz);
    }
}
