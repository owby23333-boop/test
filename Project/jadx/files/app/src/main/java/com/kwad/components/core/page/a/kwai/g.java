package com.kwad.components.core.page.a.kwai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.page.a.kwai.f;
import com.kwad.components.core.webview.a.a.j;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends a {
    private com.kwad.components.core.webview.b Mj;
    private ae Ml;
    private ac Mm;
    private KsAdWebView mAdWebView;
    private boolean Mk = false;
    private final com.kwad.sdk.core.b.c xe = new com.kwad.sdk.core.b.d() { // from class: com.kwad.components.core.page.a.kwai.g.1
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            g.this.show();
        }
    };
    private ac.b LP = new ac.b() { // from class: com.kwad.components.core.page.a.kwai.g.2
        @Override // com.kwad.components.core.webview.jshandler.ac.b
        public final void oO() {
            if (g.this.Mm != null) {
                g.this.Mm.rq();
            }
        }
    };
    private com.kwad.components.core.webview.c Mn = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.a.kwai.g.3
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new ak(new ak.b() { // from class: com.kwad.components.core.page.a.kwai.g.3.1
                @Override // com.kwad.components.core.webview.jshandler.ak.b
                public final void a(ak.a aVar2) {
                    f.a aVar3 = g.this.LL.LO;
                    if (aVar3 == null || aVar2 == null) {
                        return;
                    }
                    aVar3.ax(aVar2.visibility);
                }
            }));
            g.this.Mm = new ac(new ac.c() { // from class: com.kwad.components.core.page.a.kwai.g.3.2
                @Override // com.kwad.components.core.webview.jshandler.ac.c
                public final void oS() {
                    g gVar = g.this;
                    gVar.LL.a(gVar.LP);
                }
            });
            aVar.a(g.this.Mm);
            aVar.a(new com.kwad.components.core.webview.a.kwai.b(bVar, g.this.LL.mAdTemplate));
            j jVar = new j();
            jVar.UV = g.this.LL.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.a.kwai.g(jVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(z.a aVar) {
            g.this.LL.LQ = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean oP() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean oQ() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void oR() {
            g.this.Mk = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.Mk = true;
            if (g.this.LL.oF()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void onRegisterLifecycleLisener(ae aeVar) {
            g.this.Ml = aeVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void pageClose(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.c.kwai.b bVar = g.this.LL.mWebCardCloseListener;
            if (bVar != null) {
                bVar.a(webCloseStatus);
            }
        }
    };

    static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }

    private void eP() {
        this.Mj = new com.kwad.components.core.webview.b();
        this.Mj.a(new b.a().R(this.LL.mAdTemplate).aD(this.LL.mPageUrl).e(this.mAdWebView).j(this.LL.gu).a(this.Mn).b(this.LL.LN));
        oN();
        this.mAdWebView.loadUrl(this.LL.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void oN() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().cr(this.LL.mAdTemplate).aY(false));
        if (com.kwad.sdk.core.response.a.a.bv(com.kwad.sdk.core.response.a.d.cb(this.LL.mAdTemplate)) > 0) {
            bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.a.kwai.g.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().aY(true);
                    }
                }
            }, com.kwad.sdk.core.response.a.a.bv(com.kwad.sdk.core.response.a.d.cb(this.LL.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.a.a.bv(com.kwad.sdk.core.response.a.d.cb(this.LL.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().aY(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.a.kwai.g.5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                g.this.mAdWebView.getClientConfig().aY(true);
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        eP();
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.a(this.xe);
    }

    public final void hide() {
        ae aeVar = this.Ml;
        if (aeVar != null) {
            aeVar.rt();
        }
        ViewGroup viewGroup = this.LL.gu;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ae aeVar2 = this.Ml;
        if (aeVar2 != null) {
            aeVar2.ru();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Mj.unBind();
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.b(this.xe);
    }

    public final void show() {
        if (this.Mk) {
            ae aeVar = this.Ml;
            if (aeVar != null) {
                aeVar.rr();
            }
            try {
                if (this.LL.gu != null) {
                    this.LL.gu.setVisibility(0);
                }
            } catch (Exception e2) {
                com.kwad.components.core.c.a.b(e2);
            }
            ae aeVar2 = this.Ml;
            if (aeVar2 != null) {
                aeVar2.rs();
            }
        }
    }
}
