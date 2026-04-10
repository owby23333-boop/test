package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.adexpress.gc.gc;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;

/* JADX INFO: loaded from: classes3.dex */
public class EcBackUpWebView extends SSWebView {
    public EcBackUpWebView(Context context) {
        super(context);
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcBackUpWebView.this.m();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView.2
            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (renderProcessGoneDetail.didCrash()) {
                    if (webView != null) {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                        gc.z().g();
                    }
                    return true;
                }
                if (webView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(webView);
                    }
                    webView.destroy();
                    gc.z().g();
                }
                return true;
            }
        });
        setWebChromeClient(new WebChromeClient());
        com.bytedance.sdk.openadsdk.core.gk.g gVarPo = zw.g().po();
        if (gVarPo != null) {
            String strA = gVarPo.a();
            if (!TextUtils.isEmpty(strA)) {
                loadUrl(strA);
                return;
            }
        }
        loadUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/pattern-aggregation/pattern-aggregation-eCommerce-abtest/shoppingMall-defaultPage/index.html");
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        super.destroy();
    }
}
