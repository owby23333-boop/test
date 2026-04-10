package com.kwad.components.ad.fullscreen.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.f.h;
import com.kwad.components.ad.reward.presenter.j;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.m;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.components.core.e.e.f;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements g, f {
    private com.kwad.components.ad.fullscreen.b jH;
    private ViewGroup jI;
    private com.kwad.components.core.m.b jJ;
    private r jK;
    private FrameLayout jL;
    private com.kwad.components.ad.reward.presenter.f.b jM;
    private com.kwad.components.core.webview.tachikoma.f.g jN;
    private com.kwad.components.ad.reward.presenter.e.a jO;
    private com.kwad.components.ad.reward.presenter.f.f jP;
    private boolean jQ = false;

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public b(com.kwad.components.core.m.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, com.kwad.components.ad.reward.g gVar) {
        this.jJ = bVar;
        this.jH = bVar2;
        this.jI = viewGroup;
        this.tm = gVar;
        db();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jL = (FrameLayout) this.jI.findViewById(R.id.ksad_reward_play_layout);
    }

    private static boolean a(com.kwad.components.ad.reward.g gVar) {
        if (!e.Fq()) {
            com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.SWITCH_CLOSE);
            return false;
        }
        if (com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate))) {
            return false;
        }
        AdMatrixInfo.FullScreenInfo fullScreenInfoDu = com.kwad.sdk.core.response.b.b.du(gVar.mAdTemplate);
        if (fullScreenInfoDu != null && fullScreenInfoDu.renderType == 1) {
            return true;
        }
        com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.TK_FILE_LOAD_ERROR);
        return false;
    }

    private void db() {
        if (this.jH == null) {
            return;
        }
        dg();
        AdInfo adInfoCU = this.jH.cU();
        boolean zDc = com.kwad.sdk.core.response.b.a.dc(adInfoCU);
        boolean zEq = com.kwad.sdk.core.response.b.b.eq(adInfoCU);
        if (zDc) {
            this.tm.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.tachikoma.e.c.vO().a(dh());
            dd();
        } else if (zEq) {
            com.kwad.components.core.webview.tachikoma.e.c.vO().a(dh());
            this.tm.a(RewardRenderResult.TK_IMAGE);
            de();
        } else if (a(this.tm)) {
            this.tm.a(RewardRenderResult.FULLSCREEN_TK);
            df();
            com.kwad.components.core.webview.tachikoma.e.c.vO().a(dh());
        } else {
            this.tm.a(RewardRenderResult.DEFAULT);
            dc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc() {
        com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.jN);
        com.kwad.components.core.e.e.g.pY().a(this);
        AdTemplate adTemplate = this.jH.getAdTemplate();
        AdInfo adInfoCU = this.jH.cU();
        boolean z = this.jH.cV() && !aq.isOrientationPortrait();
        if (this.jH.jk) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aP(adInfoCU)) {
            a(new d(), true);
        }
        a(new m(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        if (com.kwad.sdk.core.response.b.b.dA(adInfoCU)) {
            a(new h(), true);
        }
        if (!z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        if (com.kwad.sdk.core.response.b.b.dz(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.c.a.f(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bd(adInfoCU)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        a(new l(), true);
        if (com.kwad.sdk.core.response.b.a.cR(adInfoCU)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new k(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        }
        r rVar = new r(adTemplate, false, false);
        this.jK = rVar;
        a((Presenter) rVar, true);
        a(new c(), true);
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, false), true);
        a(new com.kwad.components.ad.reward.presenter.e(adInfoCU, this.jI), true);
        a(new j(), true);
    }

    private void dd() {
        com.kwad.components.ad.fullscreen.c.c.c cVar = new com.kwad.components.ad.fullscreen.c.c.c();
        this.jM = cVar;
        a(cVar);
    }

    private void de() {
        com.kwad.components.ad.fullscreen.c.c.a aVar = new com.kwad.components.ad.fullscreen.c.c.a();
        this.jP = aVar;
        a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (this.jQ) {
            return;
        }
        bVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.tm), true);
        this.jQ = true;
    }

    private void df() {
        a((Presenter) new com.kwad.components.ad.fullscreen.c.c.b(), true);
    }

    private void dg() {
        AdInfo adInfoCU = this.jH.cU();
        if (!this.jH.jk) {
            a(this);
        }
        if (com.kwad.sdk.core.response.b.b.en(adInfoCU) && aq.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.jO = aVar;
            a((Presenter) aVar, true);
        }
    }

    private com.kwad.components.core.webview.tachikoma.f.g dh() {
        if (this.jN == null) {
            this.jN = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.fullscreen.c.b.1
                @Override // com.kwad.components.core.webview.tachikoma.f.g
                public final void a(String str, long j, long j2, long j3) {
                    b.this.tm.mw = true;
                }

                @Override // com.kwad.components.core.webview.tachikoma.f.b
                public final void v(String str) {
                    if ("tk_fullscreen".equals(str) || "tk_live_video".equals(str)) {
                        b bVar = b.this;
                        bVar.a(bVar);
                        com.kwad.components.ad.reward.g.a(b.this.getContext(), b.this.tm, b.this.di());
                        b.this.dc();
                        return;
                    }
                    if ("tk_image_video".equals(str)) {
                        b bVar2 = b.this;
                        bVar2.a(bVar2);
                        b.this.tm.a(RewardRenderResult.DEFAULT);
                        b.this.dc();
                    }
                }
            };
        }
        return this.jN;
    }

    public final boolean onBackPressed() {
        r rVar = this.jK;
        if (rVar != null && rVar.onBackPressed()) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.jO;
        if (aVar != null && aVar.hx() == BackPressHandleResult.HANDLED) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.jM;
        return bVar != null && bVar.hx() == BackPressHandleResult.HANDLED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout di() {
        if (this.jL == null) {
            this.jL = (FrameLayout) this.jI.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.jL;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this);
        com.kwad.components.core.e.e.g.pY().b(this);
        com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.jN);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cX() {
        this.tm.D(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.tm.gE();
        this.tm.E(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.tm.E(false);
        this.tm.gD();
    }
}
