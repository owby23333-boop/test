package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reflux.KsRefluxView;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.g.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends a implements KsRefluxView.a, a.InterfaceC0399a, f.b, com.kwad.sdk.core.webview.c.kwai.a {
    private static long tP = 2000;

    @Nullable
    private KsAdWebView cS;
    private ae fB;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private List<com.kwad.components.core.g.c> tN;
    private KsRefluxView tO;
    private List<com.kwad.components.core.d.b.c> pq = new ArrayList();
    private int cU = -1;
    private Runnable tQ = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // java.lang.Runnable
        public final void run() {
            s.this.m68if();
            s sVar = s.this;
            com.kwad.components.ad.reward.monitor.a.a(sVar.qS.pN, "reflux", s.b(sVar), s.tP, 1);
        }
    };
    private com.kwad.components.core.g.d tR = new com.kwad.components.core.g.d(null) { // from class: com.kwad.components.ad.reward.presenter.s.2
        {
            super(null);
        }

        @Override // com.kwad.components.core.g.d
        public final void d(com.kwad.components.core.g.c cVar) {
            s.this.qS.b(cVar);
        }

        @Override // com.kwad.components.core.g.d
        public final void e(com.kwad.components.core.g.c cVar) {
            s.this.qS.c(cVar);
        }
    };
    private z.b cY = new z.b() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.components.core.webview.jshandler.z.b
        public final void a(z.a aVar) {
            s.this.cU = aVar.status;
            if (s.this.cU == 1) {
                s.this.tO.z(true);
            } else {
                s.this.tO.z(false);
                s sVar = s.this;
                com.kwad.components.ad.reward.monitor.a.a(sVar.qS.pN, "reflux", s.b(sVar), s.tP, 3);
            }
            bh.b(s.this.tQ);
        }
    };
    private KsAdWebView.d tS = new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.s.6
        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            s sVar = s.this;
            com.kwad.components.ad.reward.monitor.a.a(sVar.qS.pN, "reflux", s.b(sVar), System.currentTimeMillis() - s.this.cS.getLoadTime());
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            s.this.m68if();
            s sVar = s.this;
            com.kwad.components.ad.reward.monitor.a.a(sVar.qS.pN, "reflux", s.b(sVar), s.tP, 2);
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        this.fB = new ae();
        aVar.a(this.fB);
        aVar.a(new com.kwad.components.core.webview.jshandler.g(this.mJsBridgeContext, this.pq, this));
        aVar.a(new com.kwad.components.core.webview.jshandler.m(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.p(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
        aVar.a(new z(this.cY, getUrl()));
        List<AdTemplate> listK = com.kwad.components.core.g.c.k(this.tN);
        aVar.a(new com.kwad.components.core.webview.jshandler.v(listK, this.pq));
        aVar.a(new com.kwad.components.core.webview.jshandler.r(null));
        aVar.a(new com.kwad.components.core.webview.jshandler.t(this.mJsBridgeContext));
        com.kwad.components.core.webview.jshandler.f fVar = new com.kwad.components.core.webview.jshandler.f(listK);
        fVar.a(this);
        aVar.a(fVar);
        aVar.a(new x(new x.a() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // com.kwad.components.core.webview.jshandler.x.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                if (bVar.rn() <= 0 || s.this.tN == null) {
                    return;
                }
                AdTemplate adTemplate = null;
                Iterator it = s.this.tN.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdTemplate adTemplate2 = ((com.kwad.components.core.g.c) it.next()).getAdTemplate();
                    if (com.kwad.sdk.core.response.a.d.ck(adTemplate2) == bVar.rn()) {
                        adTemplate = adTemplate2;
                        break;
                    }
                }
                if (adTemplate != null) {
                    AdWebViewActivityProxy.launch(s.this.getContext(), new AdWebViewActivityProxy.a.C0405a().ar(bVar.title).as(bVar.url).ax(true).M(adTemplate).ow());
                }
            }
        }));
    }

    private void a(KsAdWebView ksAdWebView) {
        this.cU = -1;
        aG();
        this.tO.z(false);
        String url = getUrl();
        com.kwad.components.ad.reward.monitor.a.a(this.qS.pN, "reflux", url);
        com.kwad.sdk.core.d.b.d("RewardRefluxPresenter", "startPreloadWebView url : " + url);
        if (ba.isNullString(url)) {
            com.kwad.components.ad.reward.monitor.a.a(this.qS.pN, "reflux", getUrl(), tP, 0);
            m68if();
        } else {
            ksAdWebView.loadUrl(url);
            bh.runOnUiThreadDelay(this.tQ, tP);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aG() {
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(this.cS);
        a(this.mJsInterface);
        this.cS.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    static /* synthetic */ String b(s sVar) {
        return getUrl();
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    @Nullable
    private static String getUrl() {
        String str = com.kwad.components.ad.reward.kwai.b.gN() != null ? com.kwad.components.ad.reward.kwai.b.gN().h5Url : "";
        return TextUtils.isEmpty(str) ? "" : str;
    }

    private void id() {
        SceneImpl sceneImpl = this.qS.mAdTemplate.mAdScene;
        SceneImpl sceneImplM72clone = sceneImpl != null ? sceneImpl.m72clone() : null;
        if (sceneImplM72clone != null) {
            com.kwad.components.core.g.a.a(sceneImplM72clone, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public void m68if() {
        this.tO.getNativeView().c(com.kwad.components.ad.reflux.a.b(this.tN, this.pq));
        this.tO.z(false);
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplateList(com.kwad.components.core.g.c.k(this.tN));
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        com.kwad.components.ad.reward.j jVar = this.qS;
        bVar.mScreenOrientation = jVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = jVar.mRootContainer;
        bVar.aoM = adBaseFrameLayout;
        bVar.LI = adBaseFrameLayout;
        bVar.Lk = this.cS;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            this.cS.setClientConfig(ksAdWebView.getClientConfig().cr(this.qS.mAdTemplate).b(this.tS));
        }
        com.kwad.components.ad.reward.monitor.a.a(this.qS.pN, "reflux");
        id();
    }

    @Override // com.kwad.components.core.webview.jshandler.f.b
    public final void c(AdTemplate adTemplate, long j2) {
        this.qS.c(com.kwad.components.ad.reward.j.a(this.tN, j2));
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxView.a
    public final void dP() {
        List<com.kwad.components.core.g.c> list = this.tN;
        if (list != null && list.size() > 0) {
            com.kwad.sdk.core.report.a.b(this.tN.get(0).getAdTemplate(), new com.kwad.sdk.core.report.i().bg(1).bm(this.tO.ff() ? 8 : 9), (JSONObject) null);
        }
        this.qS.mAdOpenInteractionListener.h(false);
        hH();
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxView.a
    public final void fl() {
        this.qS.pw.pause();
    }

    public final BackPressHandleResult gI() {
        if (isRefluxVisible()) {
            return BackPressHandleResult.HANDLED_CLOSE;
        }
        if (this.qS.go() && ie()) {
            return BackPressHandleResult.HANDLED;
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    public final boolean ie() {
        List<com.kwad.components.core.g.c> list = this.tN;
        if (list == null || list.size() <= 0) {
            return false;
        }
        ae aeVar = this.fB;
        if (aeVar != null) {
            aeVar.rr();
        }
        this.tO.c(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.s.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (s.this.fB != null) {
                    s.this.fB.rs();
                }
                animator.removeListener(this);
            }
        });
        this.qS.mTimerHelper.EV();
        return true;
    }

    public final boolean isRefluxVisible() {
        if (this.tO == null) {
            return false;
        }
        return this.tO.getGlobalVisibleRect(new Rect());
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        if (aVar != null) {
            com.kwad.components.core.g.c cVarA = com.kwad.components.ad.reward.j.a(this.tN, aVar.creativeId);
            if (cVarA != null) {
                this.qS.b(cVarA);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tO = (KsRefluxView) findViewById(R.id.ksad_reward_reflux);
        this.cS = this.tO.getWebView();
        this.tO.setViewListener(this);
        this.tO.setInnerAdInteractionListener(this.tR);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onError(int i2, String str) {
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onInnerAdLoad(@Nullable List<com.kwad.components.core.g.c> list) {
        com.kwad.sdk.core.d.b.d("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
        this.tN = list;
        if (list.size() > 0) {
            this.pq.clear();
            Iterator<com.kwad.components.core.g.c> it = this.tN.iterator();
            while (it.hasNext()) {
                com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(it.next().getAdTemplate());
                com.kwad.sdk.core.d.b.d("RewardRefluxPresenter", "onRefluxAdLoad helper: " + cVar.nx());
                this.pq.add(cVar);
            }
            if (this.cS == null) {
                com.kwad.components.ad.reward.monitor.a.a(this.qS.pN, "reflux", getUrl(), tP, 0);
                m68if();
            } else {
                inflateJsBridgeContext();
                a(this.cS);
            }
        }
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onRequestResult(int i2) {
    }
}
