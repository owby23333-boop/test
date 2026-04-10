package com.kwad.components.ad.reward.presenter.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.kwai.e;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends c implements com.kwad.components.ad.reward.d.h, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private ae wD;
    private boolean wE;
    private boolean wF;
    private FrameLayout wP;

    @Nullable
    private View wQ;
    private boolean wR = false;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.e.i.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            i.this.wP.setVisibility(8);
        }
    };
    private j.a wS = new j.a() { // from class: com.kwad.components.ad.reward.presenter.e.i.2
        @Override // com.kwad.components.ad.reward.j.a
        public final void gt() {
            i.this.wF = true;
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gu() {
            i.this.wF = true;
            i.this.jo();
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gv() {
            i.this.wF = false;
            if (i.this.wD != null) {
                i.this.wD.rw();
            }
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gw() {
            i.this.wF = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void jo() {
        ae aeVar = this.wD;
        if (aeVar == null || !this.wF) {
            return;
        }
        if (this.wE) {
            aeVar.rv();
            return;
        }
        aeVar.rr();
        this.wD.rs();
        this.wE = true;
    }

    private e.b jq() {
        return new e.b() { // from class: com.kwad.components.ad.reward.presenter.e.i.3
            @Override // com.kwad.components.core.webview.a.kwai.e.b
            public final int jr() {
                if (i.this.qS.qa != null) {
                    return com.kwad.sdk.b.kwai.a.b(i.this.getContext(), r0.ch());
                }
                if (i.this.wQ == null) {
                    return 0;
                }
                return i.this.wQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? com.kwad.sdk.b.kwai.a.b(i.this.getContext(), i.this.wQ.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin) : com.kwad.sdk.b.kwai.a.b(i.this.getContext(), i.this.wQ.getHeight());
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.wQ = view;
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.a(this.wS);
        this.qS.pz.a(this);
        this.qS.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fz().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        if (this.wR) {
            this.wP.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        if (this.wR) {
            this.wP.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c
    protected final boolean ck() {
        return true;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.wP;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-video-topfloor", this.qS.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wP = (FrameLayout) findViewById(R.id.ksad_js_topfloor);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        float screenHeight = com.kwad.sdk.b.kwai.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((screenHeight / fAG) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onRegisterLifecycleLisener(ae aeVar) {
        super.onRegisterLifecycleLisener(aeVar);
        this.wD = aeVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new com.kwad.components.core.webview.a.kwai.e(jq()));
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rt();
            this.wD.ru();
        }
        this.wR = false;
        this.wP.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadSuccess() {
        super.onTkLoadSuccess();
        jo();
        this.wR = true;
        this.wP.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rt();
            this.wD.ru();
        }
        super.onUnbind();
        this.qS.b(this.wS);
        this.qS.pz.b(this);
        this.qS.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fz().b(this);
        this.qS.a((com.kwad.components.core.webview.a.d.a) null);
    }
}
