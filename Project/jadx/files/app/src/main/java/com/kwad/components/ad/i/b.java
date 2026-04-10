package com.kwad.components.ad.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.webview.a.kwai.f;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.d;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    protected View GN;
    private String GP;
    private d.a GQ;
    private a GR;

    @Nullable
    private InterfaceC0353b GS;
    protected KsAdWebView cS;

    @Nullable
    private com.kwad.sdk.core.webview.c.kwai.a cV;
    private AdBaseFrameLayout dF;
    private FrameLayout de;
    protected AdTemplate mAdTemplate;
    protected ae mCardLifecycleHandler;
    protected com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;

    @Nullable
    private JSONObject mReportExtData;
    private int mScreenOrientation;
    private aj yr;
    private List<AdTemplate> GL = new ArrayList();

    @NonNull
    private List<c> GM = new ArrayList();
    private int cU = -1;
    protected boolean GO = false;
    private r.b cX = new r.b() { // from class: com.kwad.components.ad.i.b.4
        @Override // com.kwad.components.core.webview.jshandler.r.b
        public final void a(r.a aVar) {
            b.this.mf();
        }
    };
    private z.b cY = new z.b() { // from class: com.kwad.components.ad.i.b.5
        @Override // com.kwad.components.core.webview.jshandler.z.b
        public final void a(z.a aVar) {
            b.this.cU = aVar.status;
            com.kwad.sdk.core.d.b.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.GP);
            if (aVar.isSuccess() && b.this.GS != null) {
                b.this.GS.ic();
            }
        }
    };

    public interface a {
        void a(b bVar);

        void iT();
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.i.b$b, reason: collision with other inner class name */
    public interface InterfaceC0353b {
        void ic();
    }

    public b() {
    }

    public b(@Nullable JSONObject jSONObject, @Nullable String str) {
        this.mReportExtData = jSONObject;
        this.GP = str;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aG() {
        clearJsInterfaceRegister();
        this.cS.getSettings().setAllowFileAccess(true);
        this.mJsInterface = new com.kwad.components.core.webview.a(this.cS);
        a(this.mJsInterface);
        this.cS.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void aN() {
        int i2 = this.cU;
        com.kwad.sdk.core.d.b.w("PlayEndWebCard", "show webCard fail, reason: " + (i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : "others"));
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.i.b.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                b bVar = b.this;
                bVar.GO = true;
                bVar.fP();
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                b.this.GO = false;
            }
        };
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = this.mScreenOrientation;
        bVar.aoM = this.dF;
        bVar.LI = this.de;
        bVar.Lk = this.cS;
        bVar.mReportExtData = this.mReportExtData;
        b(bVar);
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i2) {
        this.GM.add(cVar);
        this.dF = adBaseFrameLayout;
        this.de = frameLayout;
        this.mScreenOrientation = i2;
        this.mAdTemplate = adTemplate;
        fK();
        inflateJsBridgeContext();
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2, int i2) {
        this.GM = list2;
        this.dF = adBaseFrameLayout;
        this.de = frameLayout;
        this.mScreenOrientation = i2;
        if (list != null && list.size() > 0) {
            this.GL = list;
            this.mAdTemplate = list.get(0);
        }
        fK();
        inflateJsBridgeContext();
    }

    public final void a(a aVar) {
        this.GR = aVar;
    }

    public final void a(@Nullable InterfaceC0353b interfaceC0353b) {
        this.GS = interfaceC0353b;
        this.de.setVisibility(4);
        this.cU = -1;
        String strM = m(this.mAdTemplate);
        com.kwad.sdk.core.d.b.d("PlayEndWebCard", "startPreloadWebView url : " + strM);
        if (TextUtils.isEmpty(strM) || this.cS == null) {
            return;
        }
        aG();
        fO();
        this.cS.loadUrl(strM);
    }

    protected void a(com.kwad.components.core.webview.a aVar) {
        if (this.GM.size() <= 1 || this.GL.size() <= 1) {
            c cVar = this.GM.get(0);
            aVar.a(new j(this.mJsBridgeContext, cVar, this.cV));
            aVar.a(new g(this.mJsBridgeContext, cVar, this.cV));
            aVar.a(new ah(this.mJsBridgeContext, cVar));
        } else {
            aVar.a(new j(this.mJsBridgeContext, this.GM.get(0), this.cV));
            aVar.a(new g(this.mJsBridgeContext, this.GM, this.cV));
            aVar.a(new v(this.GL, this.GM));
        }
        this.yr = new aj();
        aVar.a(this.yr);
        aVar.a(new m(this.mJsBridgeContext));
        aVar.a(new f());
        aVar.a(new p(this.mJsBridgeContext));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new z(this.cY, m(this.mAdTemplate)));
        this.mCardLifecycleHandler = new ae();
        aVar.a(this.mCardLifecycleHandler);
        aVar.a(new r(this.cX));
        aVar.a(new t(this.mJsBridgeContext));
        d dVar = new d();
        dVar.b(new d.a() { // from class: com.kwad.components.ad.i.b.2
            @Override // com.kwad.components.core.webview.jshandler.d.a
            public final void onPlayAgainClick(boolean z2) {
                if (b.this.GQ != null) {
                    b.this.GQ.onPlayAgainClick(z2);
                }
            }
        });
        aVar.a(dVar);
        aVar.a(new h(new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.ad.i.b.3
            @Override // com.kwad.sdk.core.webview.c.kwai.b
            public final void a(WebCloseStatus webCloseStatus) {
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.i.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.GR != null) {
                            b.this.GR.iT();
                        }
                    }
                });
            }
        }));
    }

    public final void a(d.a aVar) {
        this.GQ = aVar;
    }

    public final void a(com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this.cV = aVar;
    }

    public final void ai(boolean z2) {
        this.yr.ai(true);
    }

    public final boolean az() {
        if (!bE()) {
            FrameLayout frameLayout = this.de;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            aN();
            return false;
        }
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rr();
        }
        FrameLayout frameLayout2 = this.de;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        if (this.mCardLifecycleHandler != null && fL()) {
            this.mCardLifecycleHandler.rs();
        }
        a aVar = this.GR;
        if (aVar == null) {
            return true;
        }
        aVar.a(this);
        return true;
    }

    protected void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    protected boolean bE() {
        return this.cU == 1;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void fK() {
        this.de.removeAllViews();
        this.de.setVisibility(4);
        this.GN = com.kwad.sdk.i.a.inflate(this.de.getContext(), getLayoutId(), this.de);
        this.cS = (KsAdWebView) this.de.findViewById(R.id.ksad_web_card_webView);
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            this.cS.getBackground().setAlpha(0);
            this.cS.setClientConfig(this.cS.getClientConfig().cr(this.mAdTemplate).b(getWebListener()));
            fN();
        }
    }

    protected boolean fL() {
        return true;
    }

    protected void fN() {
    }

    protected void fO() {
    }

    protected void fP() {
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    protected String getName() {
        return "PlayEndWebCard";
    }

    public final void ko() {
        clearJsInterfaceRegister();
    }

    protected String m(AdTemplate adTemplate) {
        String str = this.GP;
        return str == null ? com.kwad.sdk.core.response.a.b.be(this.mAdTemplate) : str;
    }

    public final void mf() {
        if (com.kwad.sdk.b.kwai.a.a((View) this.cS, 50, false)) {
            ae aeVar = this.mCardLifecycleHandler;
            if (aeVar != null) {
                aeVar.rt();
            }
            this.de.setVisibility(4);
            ae aeVar2 = this.mCardLifecycleHandler;
            if (aeVar2 != null) {
                aeVar2.ru();
            }
        }
    }

    public final FrameLayout mg() {
        return this.de;
    }

    public final void release() {
        clearJsInterfaceRegister();
        this.GS = null;
    }
}
