package com.kwad.components.ad.l;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bz;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private bf BP;
    protected View Mm;
    private String Mo;
    private a Mp;
    private InterfaceC0290b Mq;
    protected KsAdWebView eN;
    protected com.kwad.sdk.core.webview.b eQ;
    protected az eS;
    private com.kwad.sdk.core.webview.d.a.a eT;
    private FrameLayout fc;
    private AdBaseFrameLayout gt;
    private com.kwad.components.core.webview.b iP;
    protected AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    private List<AdTemplate> Mk = new ArrayList();
    private List<c> Ml = new ArrayList();
    private int eR = -1;
    protected boolean Mn = false;
    private com.kwad.components.core.webview.c iQ = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.ad.l.b.1
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            b.this.eQ = bVar;
            b.this.b(bVar);
            b.this.a(aVar);
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.l.b.1.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (b.this.Mp != null) {
                        b.this.Mp.jL();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(as.a aVar) {
            b.this.eR = aVar.status;
            com.kwad.sdk.core.d.c.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.Mo);
            if (aVar.isSuccess() && b.this.Mq != null) {
                b.this.Mq.iU();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(az azVar) {
            b.this.eS = azVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.eT != null) {
                b.this.eT.a(aVar);
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i, String str) {
            b.this.Mn = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            b.this.Mn = true;
            b.this.gx();
        }
    };
    private ak.b eV = new ak.b() { // from class: com.kwad.components.ad.l.b.2
        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            b.this.nM();
        }
    };

    public interface a {
        void jL();
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.l.b$b, reason: collision with other inner class name */
    public interface InterfaceC0290b {
        void iU();
    }

    protected String getName() {
        return "PlayEndWebCard";
    }

    protected boolean gt() {
        return true;
    }

    protected void gv() {
    }

    protected void gw() {
    }

    protected void gx() {
    }

    public b() {
    }

    public b(JSONObject jSONObject, String str) {
        this.mReportExtData = jSONObject;
        this.Mo = str;
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.eT = aVar;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i) {
        this.Ml.add(cVar);
        this.gt = adBaseFrameLayout;
        this.fc = frameLayout;
        this.mAdTemplate = adTemplate;
        gs();
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2) {
        this.Ml = list2;
        this.gt = adBaseFrameLayout;
        this.fc = frameLayout;
        if (list != null && list.size() > 0) {
            this.Mk = list;
            this.mAdTemplate = list.get(0);
        }
        gs();
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    protected void gs() {
        this.fc.removeAllViews();
        this.fc.setVisibility(4);
        this.Mm = m.inflate(this.fc.getContext(), getLayoutId(), this.fc);
        KsAdWebView ksAdWebView = (KsAdWebView) this.fc.findViewById(R.id.ksad_web_card_webView);
        this.eN = ksAdWebView;
        if (ksAdWebView != null) {
            boolean z = false;
            ksAdWebView.setBackgroundColor(0);
            this.eN.getBackground().setAlpha(0);
            this.iP = new com.kwad.components.core.webview.b();
            b.a aVarF = new b.a().aM(this.mAdTemplate).aP(K(this.mAdTemplate)).d(this.eN).e(this.mReportExtData).k(this.gt).f(this.Ml.get(0));
            if (this.Ml.size() > 1 && this.Mk.size() > 1) {
                z = true;
            }
            this.iP.a(aVarF.aV(z).a(this.iQ));
            this.eN.loadUrl(K(this.mAdTemplate));
            gv();
        }
    }

    public final void ai(boolean z) {
        this.BP.ai(true);
    }

    protected void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    public final void a(InterfaceC0290b interfaceC0290b) {
        this.Mq = interfaceC0290b;
        this.fc.setVisibility(4);
        this.eR = -1;
        String strK = K(this.mAdTemplate);
        com.kwad.sdk.core.d.c.d("PlayEndWebCard", "startPreloadWebView url : " + strK);
        if (TextUtils.isEmpty(strK) || this.eN == null) {
            return;
        }
        gw();
        this.eN.loadUrl(strK);
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.eN;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void a(a aVar) {
        this.Mp = aVar;
    }

    protected String K(AdTemplate adTemplate) {
        String str = this.Mo;
        return str == null ? com.kwad.sdk.core.response.b.b.cK(this.mAdTemplate) : str;
    }

    protected void a(com.kwad.components.core.webview.a aVar) {
        if (this.Ml.size() > 1 && this.Mk.size() > 1) {
            aVar.a(new ac(this.eQ, this.Ml.get(0), this.eT, (byte) 0));
            aVar.a(new z(this.eQ, this.Ml, this.eT));
            aVar.a(new ao(this.Mk, this.Ml));
        }
        bf bfVar = new bf();
        this.BP = bfVar;
        aVar.a(bfVar);
        aVar.a(new ak(this.eV));
    }

    protected boolean cH() {
        return this.eR == 1;
    }

    public final boolean aW() {
        if (cH()) {
            az azVar = this.eS;
            if (azVar != null) {
                azVar.uF();
            }
            FrameLayout frameLayout = this.fc;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.eS == null || !gt()) {
                return true;
            }
            this.eS.uG();
            return true;
        }
        FrameLayout frameLayout2 = this.fc;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(4);
        }
        bm();
        return false;
    }

    public final void nM() {
        if (bz.a(this.eN, 50, false)) {
            az azVar = this.eS;
            if (azVar != null) {
                azVar.uH();
            }
            this.fc.setVisibility(4);
            az azVar2 = this.eS;
            if (azVar2 != null) {
                azVar2.uI();
            }
        }
    }

    private void bm() {
        int i = this.eR;
        com.kwad.sdk.core.d.c.w("PlayEndWebCard", "show webCard fail, reason: ".concat(i == -1 ? "timeout" : i != 1 ? "h5error" : "others"));
    }

    public final void release() {
        this.Mq = null;
    }

    public final void ny() {
        com.kwad.components.core.webview.b bVar = this.iP;
        if (bVar != null) {
            bVar.kz();
        }
    }
}
