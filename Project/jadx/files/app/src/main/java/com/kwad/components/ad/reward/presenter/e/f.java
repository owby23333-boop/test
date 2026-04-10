package com.kwad.components.ad.reward.presenter.e;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bc;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends c implements RewardActionBarControl.d {
    private FrameLayout lC;
    private int wG = 0;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.e.f.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            f.this.hide();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.lC.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (ck()) {
            this.wG = this.lC.getVisibility();
            getRootView().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(8);
            this.qS.b(this.mPlayEndPageListener);
            this.qS.pz.a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c
    protected final boolean ck() {
        return j.d(this.qS) && !this.qS.pw.jY();
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
    public final void f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.lC.setVisibility(0);
        RewardActionBarControl.a(aVar, this.lC, RewardActionBarControl.ShowActionBarResult.TK);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.lC;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-video-bottom-card-v2", this.qS.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lC = (FrameLayout) findViewById(R.id.ksad_js_bottom);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        aVar.width = (int) ((bc.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((bc.getScreenHeight(getContext()) / fAG) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new com.kwad.components.ad.reward.b.f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.presenter.e.f.2
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                com.kwad.sdk.core.d.b.d("TkRewardActionBarPresenter", "onUpdateExtraReward : " + bVar2.hl());
                f.this.a(bVar2);
            }
        }));
        lVar.c(new com.kwad.components.core.webview.jshandler.b(new com.kwad.components.core.webview.jshandler.c() { // from class: com.kwad.components.ad.reward.presenter.e.f.3
            @Override // com.kwad.components.core.webview.jshandler.c
            public final void a(com.kwad.components.core.webview.jshandler.b bVar2, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    bVar2.a(com.kwad.components.ad.reward.b.a.hi().hj());
                    com.kwad.components.ad.reward.b.a.hi().a(bVar2);
                }
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.lC.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (ck()) {
            this.qS.c(this.mPlayEndPageListener);
            this.lC.setVisibility(this.wG);
            this.qS.pz.a((RewardActionBarControl.d) null);
        }
    }
}
