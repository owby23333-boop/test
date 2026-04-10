package com.kwad.components.ad.fullscreen.b.b;

import android.os.Vibrator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.sdk.R;
import com.kwad.sdk.core.f.d;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.e.a {
    private d ee;
    private Vibrator ef;
    private FrameLayout hv;
    private ImageView hw;
    private h hx = new h() { // from class: com.kwad.components.ad.fullscreen.b.b.b.1
        @Override // com.kwad.components.ad.reward.d.h
        public final void a(PlayableSource playableSource, @Nullable l lVar) {
        }

        @Override // com.kwad.components.ad.reward.d.h
        public final void ca() {
            b.this.hv.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.d.h
        public final void cb() {
            b.this.hv.setVisibility(4);
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.b.b.2
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (b.this.ee != null) {
                b.this.ee.bj(b.this.getContext());
            }
            if (b.this.hw != null) {
                b.this.hw.setVisibility(0);
            }
            if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.cb(b.this.qS.mAdTemplate))) {
                b.this.hv.setVisibility(4);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        if (this.ee != null) {
            return;
        }
        float fDf = com.kwad.sdk.core.response.a.b.df(com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate));
        this.ee = new d(fDf);
        this.ee.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.fullscreen.b.b.b.3
            @Override // com.kwad.sdk.core.f.b
            public final void a(double d2) {
                if (com.kwad.components.core.d.a.b.na() || !b.this.jb()) {
                    bh.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.b.b.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.ee.xP();
                        }
                    }, null, 500L);
                    return;
                }
                if (b.this.qS != null) {
                    i iVar = new i();
                    iVar.i(d2);
                    b.this.qS.a(1, b.this.getContext(), 157, 1, 0L, false, iVar);
                }
                bh.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.b.b.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("TKFullScreenVideoPresenter", "onShakeEvent openGate2");
                        b.this.ee.xP();
                    }
                }, null, 500L);
                bh.a(b.this.getContext(), b.this.ef);
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        this.ee.e(fDf);
        this.ee.bi(getContext());
        if (getContext() != null) {
            this.ef = (Vibrator) getContext().getSystemService("vibrator");
        }
    }

    private void cl() {
        final String strH = com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate));
        bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.b.b.5
            @Override // java.lang.Runnable
            public final void run() {
                ImageLoaderProxy.INSTANCE.load(b.this.hw, strH);
            }
        }, 1000L);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        ImageView imageView;
        ImageView.ScaleType scaleType;
        super.ar();
        this.qS.pO = true;
        com.kwad.components.ad.reward.b.fz().a(this.hx);
        this.qS.b(this.mPlayEndPageListener);
        if (ah.cu(getContext())) {
            imageView = this.hw;
            scaleType = ImageView.ScaleType.FIT_XY;
        } else {
            imageView = this.hw;
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        imageView.setScaleType(scaleType);
        cl();
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.hv;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-fullscreen-video-card", this.qS.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hv = (FrameLayout) findViewById(R.id.ksad_js_full_card);
        this.hw = (ImageView) findViewById(R.id.ksad_tk_bg_view);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a, com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new ag(new ag.a() { // from class: com.kwad.components.ad.fullscreen.b.b.b.4
            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void bJ() {
                b.this.bB();
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.hv.setVisibility(8);
        this.hw.setVisibility(8);
        this.qS.pO = false;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.fz().b(this.hx);
    }
}
