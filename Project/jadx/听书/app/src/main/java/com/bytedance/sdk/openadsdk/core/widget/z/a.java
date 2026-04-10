package com.bytedance.sdk.openadsdk.core.widget.z;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.i.e;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.iq.l;
import com.bytedance.sdk.openadsdk.core.iq.lq;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.m;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.q;
import com.bytedance.sdk.openadsdk.core.un.xl;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.google.common.net.HttpHeaders;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a extends WebViewClient implements SSWebView.dl {
    private static final HashSet<String> kb;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f1429a;
    protected final Context dl;
    protected final mc g;
    protected gc gc;
    private com.bytedance.sdk.openadsdk.wp.a z;
    protected boolean m = true;
    protected boolean e = true;
    protected volatile AtomicInteger gz = new AtomicInteger(0);
    private long fo = -1;
    private boolean uy = false;

    public a(Context context, mc mcVar, String str) {
        this.dl = context;
        this.g = mcVar;
        this.f1429a = str;
    }

    public a(Context context, mc mcVar, String str, gc gcVar) {
        this.dl = context;
        this.g = mcVar;
        this.f1429a = str;
        this.gc = gcVar;
    }

    public a(Context context, mc mcVar, String str, gc gcVar, com.bytedance.sdk.openadsdk.wp.a aVar) {
        this.dl = context;
        this.g = mcVar;
        this.f1429a = str;
        this.gc = gcVar;
        this.z = aVar;
    }

    private boolean z(Uri uri) {
        File fileG = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext());
        if (uri == null) {
            return false;
        }
        try {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                return false;
            }
            File canonicalFile = new File(fileG, lastPathSegment).getCanonicalFile();
            if (canonicalFile.exists()) {
                return !canonicalFile.getPath().startsWith(fileG.toString());
            }
            return false;
        } catch (Exception e) {
            wp.z(e);
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null && z(webResourceRequest.getUrl())) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.z != null) {
            webResourceResponseShouldInterceptRequest = this.z.z(webView, new com.bytedance.sdk.openadsdk.wp.g(webResourceRequest, null), webResourceResponseShouldInterceptRequest);
        }
        if (z(webView, webResourceRequest)) {
            return new WebResourceResponse("", "", null);
        }
        List<l.dl> listZ = xl.z().z(webResourceRequest.getUrl().toString());
        if (listZ == null || listZ.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        xl xlVarZ = xl.z();
        String string = webResourceRequest.getUrl().toString();
        gc gcVar = this.gc;
        return xlVarZ.z(webResourceResponseShouldInterceptRequest, string, listZ, gcVar != null ? gcVar.gz() : null);
    }

    protected boolean z(WebView webView, WebResourceRequest webResourceRequest) {
        return lq.z(webView, this.gz, this.g, webResourceRequest, false, g()) && !(this instanceof m);
    }

    public boolean z(WebView webView, String str) {
        return lq.z(webView, this.gz, this.g, str, false, g()) && !(this instanceof m);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str != null && z(Uri.parse(str))) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        if (this.z != null) {
            webResourceResponseShouldInterceptRequest = this.z.z(webView, new com.bytedance.sdk.openadsdk.wp.g(null, str), webResourceResponseShouldInterceptRequest);
        }
        if (z(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        List<l.dl> listZ = xl.z().z(str);
        if (listZ == null || listZ.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        xl xlVarZ = xl.z();
        gc gcVar = this.gc;
        return xlVarZ.z(webResourceResponseShouldInterceptRequest, str, listZ, gcVar != null ? gcVar.gz() : null);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    private void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket")) || str.contains("alipays://platformapi/startapp?appId")) {
            com.bytedance.sdk.openadsdk.core.i.a.dl(this.g.gz(), "landingpage", "lp_pay");
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        mc mcVar;
        z(str);
        try {
            if (z(webView, str)) {
                return true;
            }
            com.bytedance.sdk.openadsdk.wp.a aVar = this.z;
            if (aVar != null) {
                aVar.z(webView, str);
            }
            Uri uri = Uri.parse(str);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                q.z(uri, this.g);
                return true;
            }
            if (uy.ls().oq() != null) {
                boolean z = false;
                if (((Boolean) uy.ls().oq().apply(com.bytedance.sdk.openadsdk.ls.a.z().z(15).z(Boolean.class).z(0, new com.bytedance.sdk.openadsdk.core.un.lq().z(ContentProviderManager.PROVIDER_URI, uri)).g())).booleanValue()) {
                    mc mcVar2 = this.g;
                    if (mcVar2 != null && mcVar2.gz() != null) {
                        boolean z2 = zw.g().aq() != 1;
                        if (com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(str) && z2) {
                            na naVarGz = this.g.gz();
                            com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarG = gz.g(this.dl, naVarGz, this.g.sy(), true);
                            if (dlVarG instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                                ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVarG).m(true);
                            }
                            dlVarG.z(naVarGz, false);
                            z = true;
                        } else {
                            z = com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(uri, this.g.gz(), this.dl, this.g.sy(), hashCode());
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.g.z().put("is_landing_page_open_market", true);
                    if (z) {
                        return true;
                    }
                }
            }
            if (!v.z(str) && (mcVar = this.g) != null && mcVar.gz() != null) {
                final String strSy = this.g.sy();
                final na naVarGz2 = this.g.gz();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.addFlags(268435456);
                com.bytedance.sdk.openadsdk.core.i.a.g(naVarGz2, strSy, "lp_open_dpl", lowerCase);
                if (eo.g(this.dl)) {
                    if (eo.z(this.dl, intent)) {
                        com.bytedance.sdk.component.utils.g.z(this.dl, intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.widget.z.a.1
                            @Override // com.bytedance.sdk.component.utils.g.z
                            public void z() {
                                com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_openurl", (Throwable) null);
                                com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_deeplink_success_realtime", (Throwable) null);
                            }

                            @Override // com.bytedance.sdk.component.utils.g.z
                            public void z(Throwable th) {
                                com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_openurl_failed", th);
                                com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_deeplink_fail_realtime", th);
                            }
                        }, TextUtils.equals("main", UMModuleRegister.INNER));
                        e.z().z(naVarGz2, strSy, true);
                    } else {
                        com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_openurl_failed", (Throwable) null);
                        com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_deeplink_fail_realtime", (Throwable) null);
                    }
                } else {
                    try {
                        z(this.dl, intent);
                        com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_openurl", (Throwable) null);
                        com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_deeplink_success_realtime", (Throwable) null);
                        e.z().z(naVarGz2, strSy, true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_openurl_failed", th);
                        com.bytedance.sdk.openadsdk.core.i.a.z(naVarGz2, strSy, "lp_deeplink_fail_realtime", th);
                    }
                }
                return true;
            }
        } catch (Exception e) {
            wp.g("WebChromeClient", "shouldOverrideUrlLoading", e);
            mc mcVar3 = this.g;
            if (mcVar3 != null && mcVar3.fo()) {
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    private void z(Context context, Intent intent) {
        if (intent != null) {
            try {
                ComponentName componentNameResolveActivity = intent.resolveActivity(context.getPackageManager());
                if ((componentNameResolveActivity == null || !componentNameResolveActivity.getPackageName().equals(context.getPackageName())) && (intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) {
                    com.bytedance.sdk.component.utils.g.z(context, intent, null, TextUtils.equals("main", UMModuleRegister.INNER));
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        gc gcVar = this.gc;
        if (gcVar != null) {
            gcVar.z(webView);
        }
        if (webView != null && this.m) {
            try {
                String strZ = g.z(zw.g().oq(), this.f1429a);
                if (!TextUtils.isEmpty(strZ)) {
                    kb.z(webView, strZ);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        gc gcVar = this.gc;
        if (gcVar != null) {
            gcVar.z(webView, str, bitmap);
        }
        if (this.e) {
            g.z(this.dl).z(true).z(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        gc gcVar = this.gc;
        if (gcVar != null) {
            gcVar.z(i, str, str2, g(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.gc == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey(HttpHeaders.ACCEPT)) {
            str = requestHeaders.get(HttpHeaders.ACCEPT);
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.gc.z(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.gc == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey(HttpHeaders.ACCEPT)) {
            str = requestHeaders.get(HttpHeaders.ACCEPT);
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.gc.z(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.gc != null) {
            int primaryError = 0;
            String str = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    url = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            this.gc.z(primaryError, str, url, g(url));
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        kb = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    private static String g(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !kb.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + strSubstring;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (!renderProcessGoneDetail.didCrash()) {
            wp.a("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                com.bytedance.sdk.component.adexpress.gc.gc.z().g();
            }
            return true;
        }
        wp.a("WebChromeClient", "The WebView rendering process crashed!");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            com.bytedance.sdk.component.adexpress.gc.gc.z().g();
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.dl
    public void z(boolean z) {
        mc mcVar = this.g;
        if (mcVar != null) {
            mcVar.dl(z);
        }
    }

    public boolean g() {
        return System.currentTimeMillis() - this.fo < 1000;
    }

    public void g(boolean z) {
        if (!z || this.uy) {
            this.fo = System.currentTimeMillis();
        }
    }

    public void dl() {
        this.uy = true;
    }
}
