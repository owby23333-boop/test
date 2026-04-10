package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.j.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f extends a implements j, a.InterfaceC0338a {
    private List<com.kwad.components.core.j.c> bK;
    private com.kwad.components.core.webview.tachikoma.e nD;
    protected FrameLayout zB;
    private boolean zC = false;
    private final com.kwad.components.core.webview.tachikoma.f.a rP = new com.kwad.components.core.webview.tachikoma.f.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        @Override // com.kwad.components.core.webview.tachikoma.f.a
        public final void kk() {
            if (f.this.nD != null) {
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.agT = f.this.tm.iH ? 1 : 0;
                f.this.nD.b(aVar);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void onRequestResult(int i) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zB = (FrameLayout) findViewById(du());
    }

    protected int du() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (!this.zC) {
            W(true);
        }
        this.tm.rT = true ^ this.zC;
        this.tm.a((a.InterfaceC0338a) this);
        com.kwad.components.ad.reward.a.gg().a(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.b((a.InterfaceC0338a) this);
        com.kwad.components.ad.reward.a.gg().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar == null || com.kwad.sdk.core.response.b.e.b(this.tm.mAdResultData.getProceedTemplateList(), aVar.creativeId, aVar.adStyle)) {
            this.tm.rD.cW();
            return;
        }
        if (aVar.adTemplate != null && !aVar.aNR) {
            this.tm.rD.cW();
            return;
        }
        com.kwad.components.core.j.c cVarA = com.kwad.components.ad.reward.g.a(this.bK, aVar.creativeId);
        if (cVarA != null) {
            this.tm.a(cVarA);
        }
    }

    public final BackPressHandleResult hx() {
        if (this.zF == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return this.zF.hx();
    }

    private void W(boolean z) {
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "fullTK: " + z);
        FrameLayout frameLayout = this.zB;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 8);
    }

    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dF(this.tm.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.zB;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.zC = true;
        this.tm.rT = false;
        W(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.hY());
                f.this.a(bVar2);
            }
        }));
        this.nD = eE();
        this.tm.a(this.rP);
        tVar.c(this.nD);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eN() {
                com.kwad.components.ad.reward.model.b.L(f.this.tm.mContext);
            }
        }));
        tVar.c(eD());
        tVar.c(new com.kwad.components.core.webview.jshandler.j(new p() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    jVar.aW(com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.b.e.el(f.this.tm.mAdTemplate)) && com.kwad.sdk.core.local.a.Hr() && f.this.tm.mScreenOrientation == 0);
                }
            }
        }));
    }

    private com.kwad.components.core.webview.tachikoma.e eE() {
        return new com.kwad.components.core.webview.tachikoma.e() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.agT = f.this.tm.iH ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.c eD() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.agV = com.kwad.components.ad.reward.model.b.dQ();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void e(List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0 || this.zF == null) {
            return;
        }
        this.bK = list;
        List<AdTemplate> listA = a(list, this.tm.mAdTemplate);
        com.kwad.sdk.core.webview.b bVarUU = this.zF.uU();
        if (bVarUU != null) {
            bVarUU.setAdTemplateList(listA);
        }
        l lVarKy = this.zF.ky();
        if (lVarKy != null) {
            lVarKy.g(listA);
        } else {
            this.zF.h(listA);
        }
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.j.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.j.c.n(list));
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
        FrameLayout frameLayout;
        if (this.zC || (frameLayout = this.zB) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onSkipClick: " + uVar.aci);
        if (this.tm != null && this.tm.rD != null) {
            this.tm.rD.onVideoSkipToEnd(uVar.aci * 1000);
        }
        com.kwad.components.ad.reward.presenter.f.u(this.tm);
        com.kwad.components.ad.reward.g.a(this.tm.rL, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
                c(aVar);
            }

            private static void c(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jV();
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
        FrameLayout frameLayout;
        if (this.zC || (frameLayout = this.zB) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBj = com.kwad.sdk.c.a.a.bj(getContext());
        FrameLayout frameLayout = this.zB;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.zB.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height == 0.0f || width == 0.0f) {
            super.a(aVar);
        } else {
            aVar.width = (int) ((width / fBj) + 0.5f);
            aVar.height = (int) ((height / fBj) + 0.5f);
        }
    }
}
