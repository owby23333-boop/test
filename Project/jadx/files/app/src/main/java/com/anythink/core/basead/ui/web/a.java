package com.anythink.core.basead.ui.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.e.am;
import com.anythink.core.common.res.d;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
final class a extends WebViewClient {
    private WebLandPageActivity a;

    public a(WebLandPageActivity webLandPageActivity) {
        this.a = webLandPageActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebProgressBarView webProgressBarViewA = this.a.a();
        if (webProgressBarViewA != null) {
            webProgressBarViewA.setVisibility(0);
            webProgressBarViewA.setProgress(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(26)
    public final boolean onRenderProcessGone(@Nullable WebView webView, @Nullable RenderProcessGoneDetail renderProcessGoneDetail) {
        this.a.finish();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && !d.a.equals(str)) {
            WebLandPageActivity webLandPageActivity = this.a;
            if (webLandPageActivity != null) {
                if (webLandPageActivity.b == null) {
                    webLandPageActivity.b = new JSONArray();
                }
                webLandPageActivity.b.put(str);
            }
            am amVarA = com.anythink.core.basead.a.a.a(webView.getContext(), str);
            if (amVarA.f7206m) {
                WebLandPageActivity webLandPageActivity2 = this.a;
                if (webLandPageActivity2 != null) {
                    webLandPageActivity2.a(amVarA);
                }
                return true;
            }
            WebLandPageActivity webLandPageActivity3 = this.a;
            if (webLandPageActivity3 != null) {
                webLandPageActivity3.a(amVarA);
            }
            am amVarA2 = com.anythink.core.basead.a.a.a(str);
            WebLandPageActivity webLandPageActivity4 = this.a;
            if (webLandPageActivity4 != null) {
                webLandPageActivity4.a(amVarA2);
            }
            if (!TextUtils.equals(amVarA2.f7208o, str)) {
                webView.loadUrl(amVarA2.f7208o);
                return true;
            }
        }
        return false;
    }
}
