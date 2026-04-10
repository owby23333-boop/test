package com.kwad.components.ad.reward.presenter.e;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.h.k;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.g.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.a;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends a implements com.kwad.components.ad.reward.d.h, a.InterfaceC0399a {
    private com.kwad.components.core.webview.a.e lF;
    private List<com.kwad.components.core.g.c> tA;
    private FrameLayout wI;
    private FrameLayout wJ;
    private FrameLayout wK;
    private FrameLayout wf;
    private boolean wg = false;
    private final com.kwad.components.core.webview.a.d.a pH = new com.kwad.components.core.webview.a.d.a() { // from class: com.kwad.components.ad.reward.presenter.e.g.1
        @Override // com.kwad.components.core.webview.a.d.a
        public final void cr() {
            if (g.this.lF != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UN = g.this.qS.fN ? 1 : 0;
                g.this.lF.b(aVar);
            }
        }
    };

    private void Z(boolean z2) {
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "fullTK: " + z2);
        FrameLayout frameLayout = this.wf;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z2 ? 0 : 8);
        this.wI.setVisibility(z2 ? 8 : 0);
        this.wJ.setVisibility(z2 ? 8 : 0);
        this.wK.setVisibility(z2 ? 8 : 0);
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.g.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.g.c.k(list));
        return arrayList;
    }

    private com.kwad.components.core.webview.a.b en() {
        return new com.kwad.components.core.webview.a.b() { // from class: com.kwad.components.ad.reward.presenter.e.g.6
            @Override // com.kwad.components.core.webview.a.b, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
                cVar2.UP = com.kwad.components.ad.reward.model.b.cQ();
                cVar.a(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.a.e eo() {
        return new com.kwad.components.core.webview.a.e() { // from class: com.kwad.components.ad.reward.presenter.e.g.5
            @Override // com.kwad.components.core.webview.a.e, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UN = g.this.qS.fN ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
        FrameLayout frameLayout;
        if (this.wg || (frameLayout = this.wf) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (!this.wg) {
            Z(true);
        }
        j jVar = this.qS;
        jVar.pO = true ^ this.wg;
        jVar.a((a.InterfaceC0399a) this);
        com.kwad.components.ad.reward.b.fz().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        FrameLayout frameLayout;
        if (this.wg || (frameLayout = this.wf) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
    }

    public final BackPressHandleResult gI() {
        com.kwad.components.ad.reward.h.kwai.d dVar = this.wh;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.gI();
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.wf;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-neo-video-card", this.qS.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        if (aVar == null || com.kwad.sdk.core.response.a.d.b(this.qS.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
            this.qS.mAdOpenInteractionListener.bN();
            return;
        }
        com.kwad.components.core.g.c cVarA = j.a(this.tA, aVar.creativeId);
        if (cVarA != null) {
            this.qS.b(cVarA);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wf = (FrameLayout) findViewById(R.id.ksad_js_reward_card);
        this.wI = (FrameLayout) findViewById(R.id.ksad_js_top);
        this.wJ = (FrameLayout) findViewById(R.id.ksad_js_middle);
        this.wK = (FrameLayout) findViewById(R.id.ksad_js_bottom);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onError(int i2, String str) {
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onInnerAdLoad(@Nullable List<com.kwad.components.core.g.c> list) {
        if (list == null || list.size() == 0 || this.wh == null) {
            return;
        }
        this.tA = list;
        List<AdTemplate> listA = a(list, this.qS.mAdTemplate);
        com.kwad.sdk.core.webview.b jsBridgeContext = this.wh.getJsBridgeContext();
        if (jsBridgeContext != null) {
            jsBridgeContext.setAdTemplateList(listA);
        }
        k kVarJC = this.wh.jC();
        if (kVarJC != null) {
            kVarJC.f(listA);
        } else {
            this.wh.g(listA);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a, com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new com.kwad.components.ad.reward.b.f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.presenter.e.g.2
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.hl());
                g.this.a(bVar2);
            }
        }));
        this.lF = eo();
        this.qS.a(this.pH);
        lVar.c(this.lF);
        lVar.c(new com.kwad.components.core.webview.a.a(new a.InterfaceC0411a() { // from class: com.kwad.components.ad.reward.presenter.e.g.3
            @Override // com.kwad.components.core.webview.a.a.InterfaceC0411a
            public final void es() {
                com.kwad.components.ad.reward.model.b.L(g.this.qS.mContext);
            }
        }));
        lVar.c(en());
        lVar.c(new com.kwad.components.core.webview.jshandler.b(new com.kwad.components.core.webview.jshandler.c() { // from class: com.kwad.components.ad.reward.presenter.e.g.4
            @Override // com.kwad.components.core.webview.jshandler.c
            public final void a(com.kwad.components.core.webview.jshandler.b bVar2, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    AdTemplate adTemplate = g.this.qS.mAdTemplate;
                    AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    bVar2.h(!com.kwad.sdk.core.response.a.a.bu(adInfoCb) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null), j.h(adInfoCb) && com.kwad.sdk.core.c.a.wh() && g.this.qS.mScreenOrientation == 0);
                }
            }
        }));
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onRequestResult(int i2) {
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onSkipClick(s sVar) {
        com.kwad.components.ad.reward.d.b bVar;
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onSkipClick: " + sVar.Vc);
        j jVar = this.qS;
        if (jVar != null && (bVar = jVar.mAdOpenInteractionListener) != null) {
            bVar.onVideoSkipToEnd(sVar.Vc * 1000);
        }
        com.kwad.components.ad.reward.presenter.e.q(this.qS);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        com.kwad.sdk.core.d.b.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.wg = true;
        this.qS.pO = false;
        Z(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.b((a.InterfaceC0399a) this);
        com.kwad.components.ad.reward.b.fz().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
    }

    public final void s(AdTemplate adTemplate) {
        this.wh.resetAdTemplate(adTemplate);
    }
}
