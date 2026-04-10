package com.kwad.components.ad.reward.presenter.e;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.a.a;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends c implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private com.kwad.components.core.webview.a.e lF;
    private final com.kwad.components.core.webview.a.d.a pH = new com.kwad.components.core.webview.a.d.a() { // from class: com.kwad.components.ad.reward.presenter.e.d.4
        @Override // com.kwad.components.core.webview.a.d.a
        public final void cr() {
            if (d.this.lF != null) {
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UN = d.this.qS.fN ? 1 : 0;
                d.this.lF.b(aVar);
            }
        }
    };
    private FrameLayout wA;
    private ViewGroup wv;
    private ViewGroup ww;
    private ViewGroup wx;
    private View wy;
    private ViewGroup wz;

    private void U(final int i2) {
        this.qS.mRootContainer.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.e.d.3
            @Override // java.lang.Runnable
            public final void run() {
                int iJm = d.this.jm();
                int iV = d.this.V(i2);
                if (d.this.wA != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.wA.getLayoutParams();
                    layoutParams.width = -1;
                    int height = (d.this.qS.mRootContainer.getHeight() - iJm) - iV;
                    if (height < 0) {
                        height = 0;
                    }
                    layoutParams.topMargin = iJm;
                    layoutParams.height = height;
                    d.this.wA.setLayoutParams(layoutParams);
                }
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int V(int i2) {
        ViewGroup viewGroup = this.ww;
        if (viewGroup != null && viewGroup.getHeight() > 0) {
            return this.ww.getHeight();
        }
        ViewGroup viewGroup2 = this.wz;
        return (viewGroup2 == null || viewGroup2.getHeight() <= 0) ? i2 > 0 ? i2 : com.kwad.sdk.b.kwai.a.a(getContext(), 120.0f) : this.wz.getHeight();
    }

    private com.kwad.components.core.webview.a.b en() {
        return new com.kwad.components.core.webview.a.b() { // from class: com.kwad.components.ad.reward.presenter.e.d.7
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
        return new com.kwad.components.core.webview.a.e() { // from class: com.kwad.components.ad.reward.presenter.e.d.6
            @Override // com.kwad.components.core.webview.a.e, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.a.a.a aVar = new com.kwad.components.core.webview.a.a.a();
                aVar.UN = d.this.qS.fN ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int jm() {
        ViewGroup viewGroup;
        int height;
        if (this.wv.getHeight() > 0) {
            viewGroup = this.wv;
        } else {
            if (com.kwad.sdk.core.response.a.a.aI(com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate)) && (height = ((ViewGroup.MarginLayoutParams) this.wy.getLayoutParams()).topMargin + 0 + this.wy.getHeight()) > 0) {
                return height;
            }
            viewGroup = this.wx;
        }
        return viewGroup.getHeight();
    }

    private com.kwad.components.core.webview.a.d jn() {
        return new com.kwad.components.core.webview.a.d() { // from class: com.kwad.components.ad.reward.presenter.e.d.5
            @Override // com.kwad.components.core.webview.a.d, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.a.a.i iVar = new com.kwad.components.core.webview.a.a.i();
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(d.this.qS.mAdTemplate);
                int iAF = com.kwad.sdk.core.response.a.a.aH(adInfoCb) && com.kwad.components.core.p.a.pJ().pK() == 0 ? com.kwad.sdk.core.response.a.a.aF(adInfoCb) : com.kwad.sdk.core.response.a.a.aD(adInfoCb);
                if (!d.this.qS.pQ) {
                    iAF = 0;
                }
                iVar.rewardTime = iAF;
                cVar.a(iVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        U(layoutParams != null ? layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + layoutParams.height : layoutParams.height : 0);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.pz.a(this);
        this.wA.setVisibility(0);
        U(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c
    protected final boolean ck() {
        return !this.qS.pw.jY();
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.wA;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-video-middle-card", this.qS.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wA = (FrameLayout) findViewById(R.id.ksad_js_middle);
        this.wv = (ViewGroup) findViewById(R.id.ksad_js_top);
        this.wx = (ViewGroup) findViewById(R.id.ksad_play_detail_top_toolbar);
        this.ww = (ViewGroup) findViewById(R.id.ksad_js_bottom);
        this.wz = (ViewGroup) findViewById(R.id.ksad_play_web_card_webView);
        this.wy = findViewById(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        this.lF = eo();
        this.qS.a(this.pH);
        lVar.c(this.lF);
        lVar.c(jn());
        lVar.c(new com.kwad.components.core.webview.a.a(new a.InterfaceC0411a() { // from class: com.kwad.components.ad.reward.presenter.e.d.1
            @Override // com.kwad.components.core.webview.a.a.InterfaceC0411a
            public final void es() {
                com.kwad.components.ad.reward.model.b.L(d.this.qS.mContext);
            }
        }));
        lVar.c(en());
        lVar.c(new com.kwad.components.core.webview.jshandler.b(new com.kwad.components.core.webview.jshandler.c() { // from class: com.kwad.components.ad.reward.presenter.e.d.2
            @Override // com.kwad.components.core.webview.jshandler.c
            public final void a(com.kwad.components.core.webview.jshandler.b bVar2, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    AdTemplate adTemplate = d.this.qS.mAdTemplate;
                    AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    bVar2.h(!com.kwad.sdk.core.response.a.a.bu(adInfoCb) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null), j.h(adInfoCb) && com.kwad.sdk.core.c.a.wh() && d.this.qS.mScreenOrientation == 0);
                }
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.wA.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.pz.b(this);
        this.qS.a((com.kwad.components.core.webview.a.d.a) null);
    }
}
