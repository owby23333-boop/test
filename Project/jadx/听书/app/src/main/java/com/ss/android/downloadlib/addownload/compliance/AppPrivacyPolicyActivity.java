package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.gromore.R;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.kb;

/* JADX INFO: loaded from: classes4.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1975a;
    private long dl;
    private WebView g;
    private String gc;
    private ImageView z;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (z()) {
            g();
        } else {
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
        }
    }

    public static void z(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean z() {
        this.dl = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.g.g gVarZ = dl.z().z(this.dl);
        if (gVarZ == null) {
            return false;
        }
        this.f1975a = gVarZ.g;
        String str = gVarZ.fo;
        this.gc = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.gc = wp.fo().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void g() {
        this.z = (ImageView) findViewById(R.id.iv_privacy_back);
        this.g = (WebView) findViewById(R.id.privacy_webview);
        this.z.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.z("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f1975a);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.g.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.g.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return z(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return z(Uri.parse(str));
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (!renderProcessGoneDetail.didCrash()) {
                    kb.z("System killed the WebView rendering process to reclaim memory. Recreating...");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                kb.z("The WebView rendering process crashed!");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            private boolean z(Uri uri) {
                String scheme = uri.getScheme();
                return ("http".equals(scheme) || "https".equals(scheme)) ? false : true;
            }
        });
        z(this.g);
        this.g.setScrollBarStyle(0);
        this.g.loadUrl(this.gc);
    }

    private void z(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.z("lp_app_privacy_click_close", this.f1975a);
        super.onBackPressed();
    }
}
