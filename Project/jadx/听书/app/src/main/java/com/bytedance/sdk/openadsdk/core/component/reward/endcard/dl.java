package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.reward.a.fo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.g.g;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.i.m;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.v.e;
import com.bytedance.sdk.openadsdk.v.gz;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bytedance.sdk.openadsdk.core.component.reward.endcard.z implements l.z, gc.g {
    private static final e.z t = new e.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.2
        @Override // com.bytedance.sdk.openadsdk.v.e.z
        public void z(String str, String str2, Throwable th) {
            wp.dl(str, str2, th);
        }
    };
    private com.bytedance.sdk.openadsdk.core.g.g bv;
    private DownloadListener ec;
    private g.InterfaceC0155g eo;
    private String gb;
    private final AtomicBoolean gk;
    private g.z gp;
    long h;
    protected final AtomicBoolean hh;
    private final z j;
    final l l;
    private com.bytedance.sdk.openadsdk.core.ugeno.dl.dl lq;
    private m mc;
    private final com.bytedance.sdk.openadsdk.core.playable.z na;
    private PlayableEndcardFrameLayout oq;
    protected final AtomicBoolean sy;
    private boolean ti;
    protected final AtomicBoolean uf;
    private gz un;
    private final com.bytedance.sdk.openadsdk.core.js.a vm;
    private RewardLpBottomView wj;
    private FrameLayout x;
    private com.bytedance.sdk.openadsdk.core.multipro.g.z xl;
    private com.bytedance.sdk.openadsdk.core.js.g y;

    public interface z {
        void z(WebView webView, String str);

        void z(WebView webView, String str, Bitmap bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public String io() {
        return "playable";
    }

    public dl(TTBaseVideoActivity tTBaseVideoActivity, na naVar, String str, int i, int i2, boolean z2, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, naVar, str, i, i2, z2);
        this.uf = new AtomicBoolean(false);
        this.sy = new AtomicBoolean(false);
        this.hh = new AtomicBoolean(false);
        this.gk = new AtomicBoolean(false);
        this.l = new l(Looper.getMainLooper(), this);
        this.h = 0L;
        this.j = new z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.z
            public void z(WebView webView, String str2) {
                if (dl.this.z.gb() instanceof fo) {
                    return;
                }
                dl.this.l.removeMessages(101);
                if (dl.this.uf.getAndSet(true)) {
                    return;
                }
                if (iq.dl(dl.this.g) || dl.this.ti) {
                    if (!dl.this.iq()) {
                        if (dl.this.gp != null) {
                            dl.this.gp.z();
                            return;
                        }
                        return;
                    }
                    dl.this.z(0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.z
            public void z(WebView webView, String str2, Bitmap bitmap) {
                if (iq.dl(dl.this.g)) {
                    if (dl.this.g.da() == 1 || js.kb(dl.this.g)) {
                        dl.this.l.sendEmptyMessageDelayed(101, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                    }
                    if (dl.this.sy.getAndSet(true)) {
                        return;
                    }
                    dl.this.h = System.currentTimeMillis();
                    dl.this.eo.z();
                }
            }
        };
        this.vm = new com.bytedance.sdk.openadsdk.core.js.a() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.3
            @Override // com.bytedance.sdk.openadsdk.core.js.a
            public void z(int i3) {
                dl.this.gz.fo(true);
                if (js.kb(dl.this.g)) {
                    dl.this.eo.g();
                }
                dl.this.z.dl(i3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.js.a
            public void z() {
                if (gb.kb(dl.this.g)) {
                    dl.this.z.a(3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.js.a
            public void g() {
                if (!js.z(dl.this.g) || js.kb(dl.this.g)) {
                    return;
                }
                dl.this.z.z(1);
            }
        };
        this.y = new com.bytedance.sdk.openadsdk.core.js.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.4
            @Override // com.bytedance.sdk.openadsdk.core.js.g
            public void z(boolean z3, int i3, String str2) {
                if (z3) {
                    dl.this.ls = true;
                }
            }
        };
        this.e = abstractEndCardFrameLayout.getPlayableWebView();
        this.x = (FrameLayout) this.z.findViewById(2114387919);
        this.oq = (PlayableEndcardFrameLayout) this.z.findViewById(2114387675);
        this.wj = (RewardLpBottomView) this.z.findViewById(2114387824);
        this.na = new com.bytedance.sdk.openadsdk.core.playable.z(this.dl, tTBaseVideoActivity, naVar, iq.dl(this.g) ? 2 : 1, tTBaseVideoActivity.gb().mc(), abstractEndCardFrameLayout.getVideoArea());
        z();
    }

    public void z(com.bytedance.sdk.openadsdk.core.multipro.g.z zVar) {
        this.xl = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void z(boolean z2, Map<String, Object> map, View view) {
        if (eo.tb(this.g) && this.x != null) {
            z(map, view);
        } else {
            g(z2, map, view);
        }
    }

    private void z(final Map<String, Object> map, final View view) {
        m mVar = new m(this.g);
        this.mc = mVar;
        mVar.z(true);
        this.mc.z();
        this.x.setVisibility(0);
        com.bytedance.sdk.openadsdk.core.ugeno.dl.dl dlVar = new com.bytedance.sdk.openadsdk.core.ugeno.dl.dl(this.z, this.x, this.mc, this.g, this.dl, eo.g(this.dl), this.xl);
        this.lq = dlVar;
        dlVar.z();
        this.lq.z(new com.bytedance.sdk.openadsdk.core.ugeno.a.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
            public void z(View view2) {
                dl.this.un();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.a.z
            public void z(int i) {
                dl.this.lq = null;
                com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (dl.this.x != null) {
                            dl.this.x.setVisibility(8);
                        }
                        dl.this.pf = false;
                        dl.this.g(dl.this.f952a, map, view);
                        dl.this.g(dl.this.ec, dl.this.bv);
                        dl.this.ec = null;
                        dl.this.hh();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void un() {
        this.ls = true;
        this.hh.set(true);
        this.l.sendMessage(g(4));
        if (this.z != null) {
            this.z.wp(8);
        }
        g.InterfaceC0155g interfaceC0155g = this.eo;
        if (interfaceC0155g != null) {
            interfaceC0155g.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z2, Map<String, Object> map, View view) {
        if (this.e == null) {
            return;
        }
        this.wp = new gc(this.g, this.e).g(true);
        this.wp.z(this);
        this.wp.z(true);
        this.wp.z(z2 ? "reward_endcard" : "fullscreen_endcard");
        this.gz = new mc(this.z);
        this.gz.g(this.e).z(this.g).g(this.g.mj()).a(this.g.vk()).dl(z2 ? 7 : 5).z(this.zw).gc(eo.ls(this.g)).z(this.e).g(uy.z(this.g)).z(this.dl).z(map).z(this.io).z(view).dl(this.z.z()).z(this.vm);
        if (!iq.dl(this.g)) {
            this.gz.gz(true);
        }
        this.gz.z(this.y);
        ti();
        eo();
        mc();
    }

    private void ti() {
        RewardLpBottomView rewardLpBottomView;
        if (!iq.e(this.g)) {
            this.wj = null;
            return;
        }
        if (js.a(this.g)) {
            this.wj = null;
            return;
        }
        if (!js.gc(this.g)) {
            this.wj = null;
        } else {
            if (this.oq == null || (rewardLpBottomView = this.wj) == null) {
                return;
            }
            rewardLpBottomView.z(this.g, this.dl);
            this.oq.z(new PlayableEndcardFrameLayout.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.z
                public void z() {
                    if (dl.this.wj != null) {
                        dl.this.wj.g();
                    }
                    if (dl.this.z != null) {
                        dl.this.z.fo(1);
                    }
                }
            });
        }
    }

    private void eo() {
        this.uy = iq.z(this.g);
        float fTk = this.g.tk();
        if (TextUtils.isEmpty(this.uy)) {
            return;
        }
        if (this.js == 1) {
            if (this.uy.contains("?")) {
                this.uy += "&orientation=portrait";
            } else {
                this.uy += "?orientation=portrait";
            }
        }
        if (this.uy.contains("?")) {
            this.uy += "&height=" + this.q + "&width=" + this.tb + "&aspect_ratio=" + fTk;
        } else {
            this.uy += "?height=" + this.q + "&width=" + this.tb + "&aspect_ratio=" + fTk;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void z(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.g.g gVar) {
        this.ec = downloadListener;
        this.bv = gVar;
        g(downloadListener, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.g.g gVar) {
        if (this.e == null) {
            return;
        }
        this.bv = null;
        this.kb = new com.bytedance.sdk.openadsdk.core.widget.z.a(this.z, this.gz, this.g.mj(), this.wp) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String string = webResourceRequest.getUrl().toString();
                    if (dl.this.g == null) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    if (TextUtils.isEmpty(dl.this.g.pd())) {
                        return super.shouldInterceptRequest(webView, string);
                    }
                    dl.this.gc++;
                    return super.shouldInterceptRequest(webView, string);
                } catch (Throwable th) {
                    wp.dl("PlayableEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                dl.this.p.set(false);
                dl.this.fv = this.gz;
                dl.this.i = i;
                dl.this.v = str;
                if (dl.this.un != null) {
                    dl.this.un.z(i, str, str2);
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    dl.this.p.set(false);
                    dl.this.fv = this.gz;
                }
                dl.this.i = webResourceError.getErrorCode();
                dl.this.v = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (dl.this.un != null) {
                    try {
                        dl.this.un.z(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                if (dl.this.uy.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        dl.this.p.set(false);
                        dl.this.fv = this.gz;
                    }
                    if (webResourceResponse != null) {
                        dl.this.i = webResourceResponse.getStatusCode();
                        dl.this.v = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (dl.this.un != null && str != null && !str.contains("about:blank")) {
                    dl.this.un.e(str);
                }
                super.onPageFinished(webView, str);
                dl.this.j.z(webView, str);
                if (dl.this.wj != null) {
                    dl.this.wj.z();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                dl.this.hh.set(true);
                dl.this.j.z(webView, str, bitmap);
            }
        };
        this.e.setWebViewClient(this.kb);
        this.e.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.gz, this.wp));
        z(this.e);
        this.e.setBackgroundColor(-16777216);
        this.e.setDisplayZoomControls(false);
        this.e.setDownloadListener(downloadListener);
        z(gVar);
    }

    private void z(com.bytedance.sdk.openadsdk.core.g.g gVar) {
        RewardLpBottomView rewardLpBottomView;
        if (!iq.e(this.g) || (rewardLpBottomView = this.wj) == null) {
            return;
        }
        rewardLpBottomView.setDownLoadClickListener(gVar);
    }

    public void hh() {
        if (this.pf || this.e == null || this.e.getWebView() == null) {
            return;
        }
        this.e.loadUrl(this.uy);
        this.pf = true;
        gz gzVar = this.un;
        if (gzVar != null) {
            gzVar.m(this.uy);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void i() {
        super.i();
        gz gzVar = this.un;
        if (gzVar != null) {
            gzVar.g(false);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.dl.dl dlVar = this.lq;
        if (dlVar != null) {
            dlVar.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void wp() {
        super.wp();
        if (this.un != null && oq.a(this.e)) {
            this.un.g(true);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.dl.dl dlVar = this.lq;
        if (dlVar != null) {
            dlVar.dl();
        }
        m mVar = this.mc;
        if (mVar != null) {
            mVar.dl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void v() {
        super.v();
        m mVar = this.mc;
        if (mVar != null) {
            mVar.z(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void pf() {
        super.pf();
        gz gzVar = this.un;
        if (gzVar != null) {
            gzVar.mc();
        }
        if (this.wp != null) {
            this.wp.z((gc.g) null);
        }
        this.na.a();
        com.bytedance.sdk.openadsdk.core.ugeno.dl.dl dlVar = this.lq;
        if (dlVar != null) {
            dlVar.a();
        }
        m mVar = this.mc;
        if (mVar != null) {
            mVar.a();
        }
        this.ec = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void z(int i) {
        super.z(i);
        wj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void uf() {
        super.uf();
        this.na.dl();
        com.bytedance.sdk.openadsdk.core.ugeno.dl.dl dlVar = this.lq;
        if (dlVar != null) {
            dlVar.dl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void a(boolean z2) {
        super.a(z2);
        if (!z2) {
            this.na.g();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.dl.dl dlVar = this.lq;
        if (dlVar != null) {
            dlVar.g();
        }
    }

    public void l() {
        z(true);
        gz gzVar = this.un;
        if (gzVar != null) {
            gzVar.g(true);
        }
        dl(true);
        z(false, true);
        if (this.kb != null) {
            this.kb.g(false);
        }
    }

    public void gc(boolean z2) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        try {
            this.gz.e(z2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isReward", z2);
            this.gz.z("isVerifyReward", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void g(int i, int i2) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("skip_remain_time", i);
            if (this.f952a) {
                jSONObject.put("reward_remain_time", i2);
            }
            this.gz.z("reward_button_status", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void z(g.InterfaceC0155g interfaceC0155g) {
        this.eo = interfaceC0155g;
    }

    public long h() {
        return System.currentTimeMillis() - this.h;
    }

    public boolean gk() {
        if (this.gz != null) {
            return this.gz.uy();
        }
        return true;
    }

    public mc x() {
        return this.gz;
    }

    public boolean lq() {
        return !this.hh.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void g(boolean z2) {
        gz gzVar = this.un;
        if (gzVar != null) {
            gzVar.z(z2);
        }
        this.na.z(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void m() {
        if (this.e != null && this.e.getVisibility() == 0) {
            this.eo.dl().z(true);
        }
        super.m();
        this.na.z();
        gz gzVar = this.un;
        if (gzVar != null) {
            gzVar.g(false);
        }
        z(true, false);
    }

    public void mc() {
        if (this.e == null || this.un != null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.uy.ls().t()) {
            e.z(t);
        }
        com.bytedance.sdk.openadsdk.core.tb.dl dlVar = new com.bytedance.sdk.openadsdk.core.tb.dl();
        a aVar = new a(this.vm);
        com.bytedance.sdk.openadsdk.core.tb.gc gcVar = new com.bytedance.sdk.openadsdk.core.tb.gc(this.gz);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, this.g.mj());
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.g.vk());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        gz gzVarZ = dlVar.z(zw.getContext(), this.e, gcVar, aVar, hashSet, gz.z.LAND_PAGE).gc(this.uy).a(com.bytedance.sdk.openadsdk.core.gz.z.e()).z(com.bytedance.sdk.openadsdk.core.gz.z.z()).gc(jSONObject).z("sdkEdition", com.bytedance.sdk.openadsdk.core.gz.z.dl()).g(com.bytedance.sdk.openadsdk.core.gz.z.gc()).dl(com.bytedance.sdk.openadsdk.core.gz.z.a()).z(10L).g(10L).dl(false).z(false);
        this.un = gzVarZ;
        Set<String> setUy = gzVarZ.uy();
        if (this.gz == null || setUy == null || setUy.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.un);
        Iterator<String> it = setUy.iterator();
        while (it.hasNext()) {
            this.gz.m().z(it.next(), (com.bytedance.sdk.component.z.gc<?, ?>) new com.bytedance.sdk.component.z.gc<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.dl.8
                @Override // com.bytedance.sdk.component.z.gc
                public JSONObject z(JSONObject jSONObject2, com.bytedance.sdk.component.z.m mVar) throws Exception {
                    try {
                        gz gzVar = (gz) weakReference.get();
                        if (gzVar == null) {
                            return null;
                        }
                        return gzVar.a(z(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        int i = message.what;
        if (i == 101) {
            oq();
            return;
        }
        if (i != 102) {
            return;
        }
        this.l.removeMessages(102);
        this.eo.dl().z(true);
        this.z.f();
        if (message.arg1 == 2) {
            g.z zVar = this.gp;
            if (zVar != null) {
                zVar.z();
                return;
            }
            return;
        }
        if (message.arg1 == 0 || message.arg1 == 1) {
            l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.i.gc.g
    public void z(String str) {
        if (TextUtils.isEmpty(this.gb)) {
            this.gb = str;
        }
        if (TextUtils.equals(this.gb, str)) {
            return;
        }
        this.gb = str;
        this.z.fo(1);
    }

    private void oq() {
        this.l.sendMessage(g(3));
        g.z zVar = this.gp;
        if (zVar != null) {
            zVar.z();
        }
        this.z.dl(0);
    }

    public void m(boolean z2) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        this.ti = z2;
    }

    private Message g(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 102;
        messageObtain.arg1 = i;
        return messageObtain;
    }

    public void z(g.z zVar) {
        this.gp = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.z
    public void z(Map<String, Object> map) {
        if (this.fo != null) {
            this.fo.uy();
        }
        if (map == null || !iq.dl(this.g)) {
            return;
        }
        map.put("duration", Long.valueOf(h()));
    }

    private void wj() {
        if (this.z.ec() == null) {
            return;
        }
        long jLs = !this.z.ec().z() ? this.z.ec().ls() : 0L;
        boolean zI = this.z.ec().i();
        if (!(this.z.gb() instanceof fo)) {
            gz gzVar = this.un;
            zI = gzVar != null && gzVar.e();
        }
        this.na.z(jLs, zI);
    }
}
