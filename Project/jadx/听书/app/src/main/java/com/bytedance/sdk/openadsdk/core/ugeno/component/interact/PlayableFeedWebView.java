package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.a.uy;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.i.g;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.pf;
import com.bytedance.sdk.openadsdk.core.iq.sy;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.uf;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.q;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.v.gz;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PlayableFeedWebView extends SSWebView implements g.z, fo, com.bytedance.sdk.openadsdk.core.zw.dl {
    private final na e;
    private pf fo;
    private com.bytedance.sdk.component.adexpress.g.kb fv;
    private final Context gc;
    private com.bytedance.sdk.openadsdk.core.zw.g gz;
    private boolean i;
    private pf js;
    private boolean kb;
    private final Runnable ls;
    private mc m;
    private com.bytedance.sdk.openadsdk.v.gz p;
    private final Runnable pf;
    private double q;
    private pf tb;
    private final ViewGroup uy;
    private int v;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z wp;

    public mc getJsObject() {
        return this.m;
    }

    public void m() {
        this.i = true;
        mc mcVar = this.m;
        if (mcVar != null) {
            mcVar.lq();
        }
    }

    public PlayableFeedWebView(com.bytedance.sdk.openadsdk.core.zw.g gVar, ViewGroup viewGroup) {
        super(gVar.getContext());
        this.kb = false;
        this.i = false;
        this.v = 8;
        this.pf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.g(0);
            }
        };
        this.ls = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.g(8);
            }
        };
        this.fv = new com.bytedance.sdk.component.adexpress.g.kb() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.3
            @Override // com.bytedance.sdk.component.adexpress.g.kb
            public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, int i2) {
            }

            @Override // com.bytedance.sdk.component.adexpress.g.kb
            public void z(v vVar) {
            }

            @Override // com.bytedance.sdk.component.adexpress.g.kb
            public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                PlayableFeedWebView.this.wp.g(view, i, dlVar);
            }
        };
        this.gz = gVar;
        this.gc = gVar.getContext();
        this.e = gVar.z();
        this.uy = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        setTouchEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        z(Integer.MIN_VALUE, Integer.MIN_VALUE, this.uy.getWidth(), this.uy.getHeight());
        uy();
        fo();
        kb();
        loadUrl(sy.gc(this.e).z(this.uy.getWidth() <= this.uy.getHeight()));
        setExpressVideoListener(this.wp);
    }

    private void fo() {
        com.bytedance.sdk.openadsdk.core.tb.dl dlVar = new com.bytedance.sdk.openadsdk.core.tb.dl();
        com.bytedance.sdk.openadsdk.core.tb.gc gcVar = new com.bytedance.sdk.openadsdk.core.tb.gc(this.m);
        com.bytedance.sdk.openadsdk.core.tb.a aVar = new com.bytedance.sdk.openadsdk.core.tb.a();
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        com.bytedance.sdk.openadsdk.v.gz gzVarDl = dlVar.z(zw.getContext(), this, gcVar, aVar, hashSet, gz.z.OTHER).gc(getUrl()).a(com.bytedance.sdk.openadsdk.core.gz.z.e()).z(com.bytedance.sdk.openadsdk.core.gz.z.z()).z("sdkEdition", com.bytedance.sdk.openadsdk.core.gz.z.dl()).g(com.bytedance.sdk.openadsdk.core.gz.z.gc()).dl(com.bytedance.sdk.openadsdk.core.gz.z.a()).dl(false);
        this.p = gzVarDl;
        Set<String> setUy = gzVarDl.uy();
        if (this.m == null || setUy == null || setUy.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.p);
        Iterator<String> it = setUy.iterator();
        while (it.hasNext()) {
            this.m.m().z(it.next(), (com.bytedance.sdk.component.z.gc<?, ?>) new com.bytedance.sdk.component.z.gc<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.4
                @Override // com.bytedance.sdk.component.z.gc
                public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.v.gz gzVar = (com.bytedance.sdk.openadsdk.v.gz) weakReference.get();
                        if (gzVar == null) {
                            return null;
                        }
                        return gzVar.a(z(), jSONObject);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public void a() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z zVar = this.wp;
        if (zVar != null) {
            zVar.z((View) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public void dl() {
        if (this.gz != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", 1);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.g("xeasy", e.getMessage());
            }
            this.gz.z(false, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public void setEasyPlayInteractionAreaInfo(pf pfVar) {
        this.tb = pfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.zw.dl
    public JSONObject getMaxRectJson() {
        return pf.z(this.js);
    }

    @Override // com.bytedance.sdk.openadsdk.core.zw.dl
    public JSONObject getActualRectJson() {
        return pf.z(this.tb);
    }

    @Override // com.bytedance.sdk.openadsdk.core.zw.dl
    public double getExceedAreaRate() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public void z(pf pfVar, double d) {
        this.js = pfVar;
        this.q = d;
        this.fo = pfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public void g() {
        com.bytedance.sdk.openadsdk.core.zw.g gVar = this.gz;
        if (gVar != null) {
            gVar.dl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public JSONObject getEstimatedInteractionAreaInfo() {
        com.bytedance.sdk.openadsdk.core.zw.g gVar = this.gz;
        if (gVar != null) {
            return gVar.g();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public JSONObject getContainerInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int left = this.uy.getLeft();
            int top2 = this.uy.getTop();
            jSONArray.put(0, oq.a(getContext(), left));
            jSONArray.put(1, oq.a(getContext(), top2));
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int measuredWidth = this.uy.getMeasuredWidth();
            int measuredHeight = this.uy.getMeasuredHeight();
            jSONArray2.put(0, oq.a(getContext(), measuredWidth));
            jSONArray2.put(1, oq.a(getContext(), measuredHeight));
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.a("xeasy", e.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public JSONObject getCreativeVideoViewInfo() {
        return new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public boolean E_() {
        return this.i;
    }

    public void e() {
        if (this.kb) {
            return;
        }
        this.kb = true;
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.5
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.update();
            }
        }, 100L);
    }

    public void gz() {
        z(false);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        z(i == 0);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        z(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public void z(final int i, final int i2, final int i3, final int i4) {
        com.bytedance.sdk.openadsdk.hh.e.z((Runnable) new com.bytedance.sdk.component.uy.fo("changeFrame") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.6
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
                if (i == Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
                    layoutParams.gravity = 17;
                }
                int i5 = i;
                if (i5 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationX(i5);
                }
                int i6 = i2;
                if (i6 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationY(i6);
                }
                PlayableFeedWebView.this.setLayoutParams(layoutParams);
            }
        });
    }

    private void uy() {
        mc mcVar = new mc(this.gc);
        this.m = mcVar;
        mcVar.g(this).z(this.e).g(this.e.mj()).a(this.e.vk()).z(eo.g(this.e)).gc(eo.ls(this.e)).z((fo) this).gc(com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(0.0f, 0.0f, false, this.e)).z(this.fv).z((SSWebView) this);
    }

    private void kb() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        z((SSWebView) this);
        if (this.e != null) {
            Context context = this.gc;
            mc mcVar = this.m;
            na naVar = this.e;
            setWebViewClient(new z(context, mcVar, naVar, naVar.mj()));
        }
        com.bytedance.sdk.component.adexpress.gc.gc.z().z(this, this.m);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.m));
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo
    public void F_() {
        if (this.m == null || ((ViewGroup) getParent()) == null) {
            return;
        }
        setOnShakeListener(new uf(this, this.m, this.e));
        if (this.gz != null) {
            this.gz.z(true, getMaxRectJson());
        }
        g(getVisibility());
    }

    private void z(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.z.g.z(this.gc).z(false).z(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            q.z(sSWebView, gk.dl, na.a(this.e));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.a("xeasy", e.toString());
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.i.dl
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void z(boolean z2) {
        mc mcVar = this.m;
        if (mcVar != null) {
            mcVar.kb(z2);
        }
    }

    public void setExpressVideoListener(com.bytedance.sdk.openadsdk.core.nativeexpress.uy uyVar) {
        mc mcVar = this.m;
        if (mcVar != null) {
            mcVar.z(uyVar);
        }
    }

    public void setEasyPlayableListener(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z zVar) {
        this.wp = zVar;
    }

    @Override // com.bytedance.sdk.component.i.g.z
    public Pair<Boolean, Boolean> z(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return null;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int iA = oq.a(getContext(), x);
        int iA2 = oq.a(getContext(), y);
        pf pfVar = this.fo;
        if (pfVar == null || pfVar.z(iA, iA2)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.zw.g.z(this.e, iA, iA2, 2);
        return new Pair<>(Boolean.TRUE, Boolean.FALSE);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class z extends com.bytedance.sdk.openadsdk.core.widget.z.a {
        private na z;

        public z(Context context, mc mcVar, na naVar, String str) {
            super(context, mcVar, str);
            this.z = naVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.z.g.z zVarZ = com.bytedance.sdk.openadsdk.core.nativeexpress.g.z.z(webView, this.z, str, new z.InterfaceC0191z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.z.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g.z.InterfaceC0191z
                    public boolean z() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g.z.InterfaceC0191z
                    public com.bytedance.sdk.component.adexpress.z.g.z z(String str2, uy.z zVar, String str3) {
                        com.bytedance.sdk.component.adexpress.z.g.z zVar2 = new com.bytedance.sdk.component.adexpress.z.g.z();
                        zVar2.z(5);
                        zVar2.z(com.bytedance.sdk.openadsdk.core.ugeno.gc.z.g().z(webView, zVar, str2));
                        return zVar2;
                    }
                });
                if (zVarZ != null && zVarZ.z() != null) {
                    return zVarZ.z();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.dl("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.ls);
        removeCallbacks(this.pf);
        if (i == 0) {
            postDelayed(this.pf, 50L);
        } else {
            postDelayed(this.ls, 50L);
        }
    }

    public void g(int i) {
        if (i == this.v) {
            return;
        }
        this.v = i;
        if (this.m == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", i == 0);
            this.m.z("expressAdShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.i.dl
    public void destroy() {
        this.wp = null;
        I_();
        setOnShakeListener(null);
        mc mcVar = this.m;
        if (mcVar != null) {
            mcVar.gc();
            this.m.z((SSWebView.g) null);
        }
        this.m = null;
        super.destroy();
    }
}
