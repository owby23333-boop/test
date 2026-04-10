package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.l.b;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private com.kwad.components.ad.l.b dF;
    private FrameLayout fc;
    private DetailVideoView mDetailVideoView;
    private int wC = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (c.this.dF == null || !g.P(c.this.tm.mAdTemplate)) {
                return;
            }
            c.this.dF.ai(true);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a eT = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.2
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            c.this.tm.rD.cW();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fc = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdTemplate adTemplate = this.tm.mAdTemplate;
        j jVar = this.tm.rH;
        this.dF = jVar;
        if (jVar == null) {
            return;
        }
        com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
        this.dF.a(this.eT);
        this.dF.a(this.fc, this.tm.mRootContainer, adTemplate, this.tm.mApkDownloadHelper, this.tm.mScreenOrientation);
        this.dF.a((b.InterfaceC0290b) null);
        com.kwad.components.ad.l.b bVar = this.dF;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i;
        super.onUnbind();
        com.kwad.components.ad.l.b bVar = this.dF;
        if (bVar != null) {
            bVar.nM();
            this.dF.ny();
        }
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i = this.wC) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.c.a.a.n(detailVideoView, i);
    }

    @Override // com.kwad.components.ad.l.b.a
    public final void jL() {
        iz();
    }
}
