package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.sdk.component.adexpress.a.uy;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g.z;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.q;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InteractWebView extends SSWebView {
    private Map<String, Object> e;
    private v fo;
    private Context gc;
    private na gz;
    private mc m;

    public InteractWebView(Context context) {
        super(context);
        this.gc = context;
    }

    public void setUGenExtraMap(Map<String, Object> map) {
        this.e = map;
    }

    public void setUGenContext(v vVar) {
        this.fo = vVar;
    }

    public v getUGenContext() {
        return this.fo;
    }

    public void m() {
        Map<String, Object> map = this.e;
        if (map == null || map.size() <= 0 || !this.e.containsKey("key_material")) {
            return;
        }
        Object obj = this.e.get("key_material");
        if (obj instanceof na) {
            this.gz = (na) obj;
            this.m = (mc) this.e.get("key_js_object");
            if (this.e.containsKey("key_data_list") && (this.e.get("key_data_list") instanceof List)) {
                this.m.g((List<JSONObject>) this.e.get("key_data_list"));
            }
            this.m.g(this).z(this.gz).z(eo.g(this.gz)).g(this.gz.mj()).a(this.gz.vk()).gc(eo.ls(this.gz)).z((SSWebView) this);
        }
    }

    public void e() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        z((SSWebView) this);
        if (this.gz != null) {
            Context context = this.gc;
            mc mcVar = this.m;
            na naVar = this.gz;
            setWebViewClient(new z(context, mcVar, naVar, naVar.mj()));
        } else {
            setWebViewClient(new SSWebView.z());
        }
        com.bytedance.sdk.component.adexpress.gc.gc.z().z(this, this.m);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.m));
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void z(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.z.g.z(this.gc).z(false).z(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            q.z(sSWebView, gk.dl, na.a(this.gz));
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
            com.bytedance.sdk.component.utils.wp.a("InteractWebView", e.toString());
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.i.dl
    public void loadUrl(String str) {
        super.loadUrl(str);
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
                com.bytedance.sdk.component.adexpress.z.g.z zVarZ = com.bytedance.sdk.openadsdk.core.nativeexpress.g.z.z(webView, this.z, str, new z.InterfaceC0191z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.InteractWebView.z.1
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
                com.bytedance.sdk.component.utils.wp.dl("InteractWebView", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }
}
