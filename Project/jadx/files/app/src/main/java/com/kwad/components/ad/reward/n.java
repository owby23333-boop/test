package com.kwad.components.ad.reward;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.q;
import com.kwad.components.ad.reward.presenter.s;
import com.kwad.components.ad.reward.presenter.t;
import com.kwad.components.ad.reward.presenter.u;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.d.f, com.kwad.components.ad.reward.g.b, e.b, com.kwad.components.core.webview.a.d.b {
    private ViewGroup gu;
    private com.kwad.components.core.j.b gv;
    private q gw;
    private com.kwad.components.ad.reward.presenter.e.b gx;
    private com.kwad.components.ad.reward.model.c mModel;
    private FrameLayout mPlayLayout;
    private j qS;

    @Nullable
    private a qT;

    @Nullable
    private s qU;
    private com.kwad.components.ad.reward.presenter.e.g qV;

    public interface a {
        void onUnbind();
    }

    public n(com.kwad.components.core.j.b bVar, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, j jVar) {
        this.gu = viewGroup;
        this.mModel = cVar;
        this.qS = jVar;
        this.gv = bVar;
        this.qS.a((e.a) this);
        this.qS.a((e.b) this);
        a(cVar);
        AdInfo adInfoBK = cVar.bK();
        boolean z2 = false;
        boolean z3 = com.kwad.sdk.core.response.a.a.co(adInfoBK) || j.r(cVar.getAdTemplate());
        if (com.kwad.sdk.core.response.a.a.co(adInfoBK) && !com.kwad.sdk.core.response.a.a.cA(adInfoBK)) {
            z2 = true;
        }
        com.kwad.sdk.core.d.b.d("RewardPresenter", "notFullTk: " + z3 + ", mLoadStrategy: " + this.qS.qo);
        if (z2) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
            jVar.a(RewardRenderResult.LIVE_TK);
            bT();
        } else if (z3 || !this.qS.qo.equals(LoadStrategy.FULL_TK)) {
            jVar.a(RewardRenderResult.DEFAULT);
            a(bVar, cVar);
        } else {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
            jVar.a(RewardRenderResult.NEO_TK);
            gH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.d.f fVar) {
        return getPriority() - fVar.getPriority();
    }

    private void a(com.kwad.components.ad.reward.model.c cVar) {
        AdTemplate adTemplate = cVar.getAdTemplate();
        AdInfo adInfoBK = cVar.bK();
        if (t(adTemplate)) {
            this.qU = new s();
            a(this.qU);
        }
        if (j.h(adInfoBK)) {
            a(new com.kwad.components.ad.reward.presenter.f());
        }
        if (com.kwad.sdk.core.response.a.a.aH(adInfoBK)) {
            a(new com.kwad.components.ad.reward.presenter.g.a());
        }
        if (com.kwad.sdk.core.response.a.b.cE(adInfoBK)) {
            a(new com.kwad.components.ad.reward.presenter.e.i());
        }
        this.gw = new q(adTemplate);
        a((Presenter) this.gw, true);
    }

    private void a(com.kwad.components.core.j.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        com.kwad.components.ad.reward.model.c cVar2 = this.mModel;
        if (cVar2 == null) {
            return;
        }
        AdInfo adInfoBK = cVar2.bK();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        a((Presenter) new v(), true);
        if (com.kwad.sdk.core.response.a.a.aI(adInfoBK)) {
            a((Presenter) new com.kwad.components.ad.reward.presenter.c(), true);
        }
        a((Presenter) new com.kwad.components.ad.reward.presenter.l(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.g(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.platdetail.kwai.e(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.e.d(), true);
        boolean zHB = cVar.hB();
        boolean zHC = cVar.hC();
        boolean z2 = cVar.bL() && !ah.DI();
        if (!zHB && !zHC && !z2) {
            a((Presenter) new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a((Presenter) new com.kwad.components.ad.reward.presenter.m(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.b(adInfoBK), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.c.b(adTemplate, true), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.b.a(), true);
        a((Presenter) new u(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.d(adTemplate, adInfoBK, this.gu), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.k(), true);
        j jVar = this.qS;
        if (jVar.pN && com.kwad.components.ad.reward.c.a.b(jVar.mContext, com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            a((Presenter) new com.kwad.components.ad.reward.presenter.kwai.a(), true);
        }
        if (com.kwad.sdk.core.response.a.b.bM(adTemplate)) {
            a((Presenter) new t(), true);
        }
        a((Presenter) new com.kwad.components.ad.reward.presenter.a.c(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.a.a(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.a.b(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.j(), true);
        a((Presenter) new com.kwad.components.ad.reward.presenter.i(), true);
    }

    private void bT() {
        this.gx = new com.kwad.components.ad.reward.presenter.e.b();
        a(this.gx);
    }

    private void gH() {
        this.qV = new com.kwad.components.ad.reward.presenter.e.g();
        a(this.qV);
    }

    public static boolean t(AdTemplate adTemplate) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        return com.kwad.sdk.core.response.a.a.ct(adInfoCb) && !(com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(adInfoCb)) || com.kwad.sdk.core.response.a.d.q(adTemplate));
    }

    public final void a(@Nullable a aVar) {
        this.qT = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.b(this);
        com.kwad.components.ad.reward.b.a.hi().setCallerContext(this.qS);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        this.qS.H(true);
    }

    public final BackPressHandleResult gI() {
        BackPressHandleResult backPressHandleResultGI;
        s sVar = this.qU;
        if (sVar != null && (backPressHandleResultGI = sVar.gI()) != BackPressHandleResult.NOT_HANDLED) {
            return backPressHandleResultGI;
        }
        q qVar = this.gw;
        if (qVar != null && qVar.bX()) {
            return BackPressHandleResult.HANDLED;
        }
        com.kwad.components.ad.reward.presenter.e.b bVar = this.gx;
        if (bVar != null) {
            return bVar.gI();
        }
        com.kwad.components.ad.reward.presenter.e.g gVar = this.qV;
        return gVar != null ? gVar.gI() : BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.b
    public final void gJ() {
        if (this.qS.gm()) {
            return;
        }
        com.kwad.components.ad.reward.g.a.a(getActivity(), this, this.qS.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a
    public final boolean gK() {
        s sVar = this.qU;
        if (sVar == null) {
            return false;
        }
        if (sVar.isRefluxVisible()) {
            return true;
        }
        return this.qU.ie();
    }

    @Override // com.kwad.components.ad.reward.g.b
    public final void gL() {
        this.qS.mAdOpenInteractionListener.h(false);
        hH();
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    public final boolean isRefluxVisible() {
        s sVar = this.qU;
        return sVar != null && sVar.isRefluxVisible();
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
    public final void onDestroy() {
        super.onDestroy();
        this.gv = null;
        com.kwad.components.core.webview.a.c.a.rE().b(this);
    }

    @Override // com.kwad.components.ad.reward.g.c, com.kwad.components.core.webview.jshandler.d.a
    public final void onPlayAgainClick(boolean z2) {
        this.qS.C(z2);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.c(this);
        a aVar = this.qT;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.ad.reward.b.a.hi().reset();
    }

    public final void s(AdTemplate adTemplate) {
        com.kwad.components.ad.reward.presenter.e.g gVar = this.qV;
        if (gVar != null) {
            gVar.s(adTemplate);
        }
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = com.kwad.components.core.webview.a.i.b("ksad-neo-video-card", this.qS.mAdTemplate);
        String strB2 = com.kwad.components.core.webview.a.i.b("ksad-live-video-card", this.qS.mAdTemplate);
        com.kwad.sdk.core.d.b.d("RewardPresenter", "onTkLoadFailed, rewardPageTemplateId: " + strB + ", templateId: " + str);
        if (TextUtils.equals(strB, str) || TextUtils.equals(strB2, str)) {
            j.a(getContext(), this.qS, this.mPlayLayout);
            this.qS.a(RewardRenderResult.DEFAULT);
            a(this.gv, this.mModel);
        }
    }
}
