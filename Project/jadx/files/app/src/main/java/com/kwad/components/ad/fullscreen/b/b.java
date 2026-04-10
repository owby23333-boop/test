package com.kwad.components.ad.fullscreen.b;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.e.d;
import com.kwad.components.ad.reward.presenter.e.i;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.q;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements f {
    private com.kwad.components.ad.fullscreen.b gt;
    private ViewGroup gu;
    private com.kwad.components.core.j.b gv;
    private q gw;
    private com.kwad.components.ad.reward.presenter.e.b gx;
    private com.kwad.components.core.webview.a.d.b gy;
    private FrameLayout mPlayLayout;

    public b(com.kwad.components.core.j.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, j jVar) {
        this.gv = bVar;
        this.gt = bVar2;
        this.gu = viewGroup;
        this.qS = jVar;
        bR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return getPriority() - fVar.getPriority();
    }

    private void bR() {
        if (this.gt == null) {
            return;
        }
        bV();
        AdInfo adInfoBK = this.gt.bK();
        if (com.kwad.sdk.core.response.a.a.co(adInfoBK) && !com.kwad.sdk.core.response.a.a.cA(adInfoBK)) {
            this.qS.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.a.c.a.rE().a(bW());
            bT();
        } else if (!j.a(this.qS)) {
            this.qS.a(RewardRenderResult.DEFAULT);
            bS();
        } else {
            this.qS.a(RewardRenderResult.FULLSCREEN_TK);
            bU();
            com.kwad.components.core.webview.a.c.a.rE().a(bW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS() {
        com.kwad.components.core.webview.a.c.a.rE().b(this.gy);
        AdTemplate adTemplate = this.gt.getAdTemplate();
        AdInfo adInfoBK = this.gt.bK();
        boolean z2 = this.gt.bL() && !ah.DI();
        a(new v(), true);
        if (com.kwad.sdk.core.response.a.a.aI(adInfoBK)) {
            a(new com.kwad.components.ad.reward.presenter.c(), true);
        }
        a(new l(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        a(new d(), true);
        if (com.kwad.sdk.core.response.a.b.cE(adInfoBK)) {
            a(new i(), true);
        }
        if (!z2) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        if (com.kwad.sdk.core.response.a.b.bL(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.b.kwai.f(), true);
        }
        a(new k(), true);
        a(new com.kwad.components.ad.reward.presenter.a.c(), true);
        a(new com.kwad.components.ad.reward.presenter.a.b(), true);
        a(new com.kwad.components.ad.reward.presenter.j(), true);
        a(new com.kwad.components.ad.reward.presenter.a.a(), true);
        a(new c(), true);
        a(new com.kwad.components.ad.reward.presenter.i(), true);
    }

    private void bT() {
        this.gx = new com.kwad.components.ad.reward.presenter.e.b();
        a(this.gx);
    }

    private void bU() {
        a(new com.kwad.components.ad.fullscreen.b.b.b(), true);
    }

    private void bV() {
        AdTemplate adTemplate = this.gt.getAdTemplate();
        AdInfo adInfoBK = this.gt.bK();
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.c.b(adTemplate, false), true);
        this.gw = new q(adTemplate, false, false);
        a(this.gw, true);
        a(new com.kwad.components.ad.reward.presenter.d(adTemplate, adInfoBK, this.gu), true);
    }

    private com.kwad.components.core.webview.a.d.b bW() {
        if (this.gy == null) {
            final String strB = com.kwad.components.core.webview.a.i.b("ksad-fullscreen-video-card", this.gt.getAdTemplate());
            final String strB2 = com.kwad.components.core.webview.a.i.b("ksad-live-video-card", this.qS.mAdTemplate);
            this.gy = new com.kwad.components.core.webview.a.d.b() { // from class: com.kwad.components.ad.fullscreen.b.b.1
                @Override // com.kwad.components.core.webview.a.d.b
                public final void u(String str) {
                    if (strB.equals(str) || strB2.equals(str)) {
                        j.a(b.this.getContext(), b.this.qS, b.this.mPlayLayout);
                        b.this.bS();
                    }
                }
            };
        }
        return this.gy;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.b(this);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        this.qS.H(true);
    }

    public final boolean bX() {
        q qVar = this.gw;
        if (qVar != null && qVar.bX()) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.e.b bVar = this.gx;
        return bVar != null && bVar.gI() == BackPressHandleResult.HANDLED;
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mPlayLayout = (FrameLayout) this.gu.findViewById(R.id.ksad_reward_play_layout);
        if (RewardRenderResult.DEFAULT.equals(this.qS.gl())) {
            j.a(getContext(), this.qS, this.mPlayLayout);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.c(this);
        com.kwad.components.core.webview.a.c.a.rE().b(this.gy);
    }
}
