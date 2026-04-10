package com.anythink.core.activity.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.h;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacyPolicyView extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f6470n = PrivacyPolicyView.class.getSimpleName();
    ViewGroup a;
    LinearLayout b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LoadingView f6471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TextView f6472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    FrameLayout f6473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    WebView f6474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    CheckBox f6475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    View f6476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    TextView f6477i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f6478j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f6479k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String f6480l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    a f6481m;

    /* JADX INFO: renamed from: com.anythink.core.activity.component.PrivacyPolicyView$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                if (PrivacyPolicyView.this.f6474f == null || PrivacyPolicyView.this.f6479k) {
                    return;
                }
                PrivacyPolicyView.this.f6478j = true;
                String unused = PrivacyPolicyView.f6470n;
                PrivacyPolicyView.this.loadPolicyUrl(PrivacyPolicyView.this.f6480l);
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.activity.component.PrivacyPolicyView$2, reason: invalid class name */
    final class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            try {
                String unused = PrivacyPolicyView.f6470n;
                String str2 = "onPageFinished：" + str + "   mIsWebViewloadSuccess:" + PrivacyPolicyView.this.f6478j;
                if (PrivacyPolicyView.this.f6480l.equals(str)) {
                    if (PrivacyPolicyView.this.f6478j) {
                        PrivacyPolicyView.this.b.setVisibility(4);
                        PrivacyPolicyView.this.a.setVisibility(0);
                        PrivacyPolicyView.this.b.setVisibility(8);
                        PrivacyPolicyView.this.f6471c.clearAnimation();
                        if (PrivacyPolicyView.this.f6481m != null) {
                            PrivacyPolicyView.this.f6481m.onPageLoadSuccess();
                        }
                    } else {
                        PrivacyPolicyView.this.b.setVisibility(0);
                        PrivacyPolicyView.this.f6471c.clearAnimation();
                        PrivacyPolicyView.this.f6472d.setVisibility(0);
                        PrivacyPolicyView.this.a.setVisibility(8);
                        if (PrivacyPolicyView.this.f6481m != null) {
                            PrivacyPolicyView.this.f6481m.onPageLoadFail();
                        }
                    }
                    PrivacyPolicyView.this.f6479k = false;
                    super.onPageFinished(webView, str);
                }
            } catch (Throwable unused2) {
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String unused = PrivacyPolicyView.f6470n;
            "onPageStarted：".concat(String.valueOf(str));
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(23)
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            PrivacyPolicyView.this.f6478j = false;
            String unused = PrivacyPolicyView.f6470n;
            String str = "onPageFinished：" + webResourceError.getErrorCode();
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String unused = PrivacyPolicyView.f6470n;
            "shouldOverrideUrlLoading：".concat(String.valueOf(str));
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PrivacyPolicyView.a(PrivacyPolicyView.this.getContext(), str);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.activity.component.PrivacyPolicyView$3, reason: invalid class name */
    final class AnonymousClass3 extends WebChromeClient {
        AnonymousClass3() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView webView, String str) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("error")) {
                PrivacyPolicyView.this.f6478j = false;
            }
            super.onReceivedTitle(webView, str);
        }
    }

    public interface a {
        void onLevelSelect(int i2);

        void onPageLoadFail();

        void onPageLoadSuccess();
    }

    public PrivacyPolicyView(Context context) {
        super(context);
        this.f6478j = true;
        this.f6479k = false;
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "privace_policy_layout", "layout"), this);
        this.a = (ViewGroup) findViewById(h.a(getContext(), "policy_content_view", "id"));
        this.b = (LinearLayout) findViewById(h.a(getContext(), "policy_loading_view", "id"));
        this.f6471c = new LoadingView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h.a(getContext(), 30.0f), h.a(getContext(), 30.0f));
        layoutParams.gravity = 1;
        this.f6471c.setLayoutParams(layoutParams);
        this.f6472d = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = h.a(getContext(), 5.0f);
        this.f6472d.setLayoutParams(layoutParams2);
        this.f6472d.setText("Page failed to load, please try again later.");
        this.f6472d.setTextColor(-8947849);
        this.f6472d.setTextSize(1, 12.0f);
        this.b.addView(this.f6471c);
        this.b.addView(this.f6472d);
        this.b.setOnClickListener(new AnonymousClass1());
        this.f6473e = (FrameLayout) findViewById(h.a(getContext(), "policy_webview_area", "id"));
        this.f6474f = new WebView(getContext());
        g.a(this.f6474f);
        this.f6473e.addView(this.f6474f, new FrameLayout.LayoutParams(-1, -1));
        WebSettings settings = this.f6474f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setAppCacheEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f6474f.setWebViewClient(new AnonymousClass2());
        this.f6474f.setWebChromeClient(new AnonymousClass3());
        this.f6475g = (CheckBox) findViewById(h.a(getContext(), "policy_check_box", "id"));
        this.f6476h = findViewById(h.a(getContext(), "policy_agree_view", "id"));
        this.f6477i = (TextView) findViewById(h.a(getContext(), "policy_reject_view", "id"));
        this.f6476h.setOnClickListener(this);
        this.f6477i.setOnClickListener(this);
        int iA = h.a(getContext(), 20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13472268);
        gradientDrawable.setCornerRadius(iA);
        this.f6476h.setBackgroundDrawable(gradientDrawable);
        this.f6477i.setText(Html.fromHtml("<u>No,Thanks</u>"));
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "privace_policy_layout", "layout"), this);
        this.a = (ViewGroup) findViewById(h.a(getContext(), "policy_content_view", "id"));
        this.b = (LinearLayout) findViewById(h.a(getContext(), "policy_loading_view", "id"));
        this.f6471c = new LoadingView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h.a(getContext(), 30.0f), h.a(getContext(), 30.0f));
        layoutParams.gravity = 1;
        this.f6471c.setLayoutParams(layoutParams);
        this.f6472d = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = h.a(getContext(), 5.0f);
        this.f6472d.setLayoutParams(layoutParams2);
        this.f6472d.setText("Page failed to load, please try again later.");
        this.f6472d.setTextColor(-8947849);
        this.f6472d.setTextSize(1, 12.0f);
        this.b.addView(this.f6471c);
        this.b.addView(this.f6472d);
        this.b.setOnClickListener(new AnonymousClass1());
        this.f6473e = (FrameLayout) findViewById(h.a(getContext(), "policy_webview_area", "id"));
        this.f6474f = new WebView(getContext());
        g.a(this.f6474f);
        this.f6473e.addView(this.f6474f, new FrameLayout.LayoutParams(-1, -1));
        WebSettings settings = this.f6474f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setAppCacheEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f6474f.setWebViewClient(new AnonymousClass2());
        this.f6474f.setWebChromeClient(new AnonymousClass3());
        this.f6475g = (CheckBox) findViewById(h.a(getContext(), "policy_check_box", "id"));
        this.f6476h = findViewById(h.a(getContext(), "policy_agree_view", "id"));
        this.f6477i = (TextView) findViewById(h.a(getContext(), "policy_reject_view", "id"));
        this.f6476h.setOnClickListener(this);
        this.f6477i.setOnClickListener(this);
        int iA = h.a(getContext(), 20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13472268);
        gradientDrawable.setCornerRadius(iA);
        this.f6476h.setBackgroundDrawable(gradientDrawable);
        this.f6477i.setText(Html.fromHtml("<u>No,Thanks</u>"));
    }

    private void c() {
        WebSettings settings = this.f6474f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setAppCacheEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f6474f.setWebViewClient(new AnonymousClass2());
        this.f6474f.setWebChromeClient(new AnonymousClass3());
    }

    public void destory() {
        try {
            removeAllViews();
            if (this.a != null) {
                this.a.removeAllViews();
            }
            if (this.f6473e != null) {
                this.f6473e.removeView(this.f6474f);
                this.f6474f.removeAllViews();
            }
            if (this.f6474f != null) {
                this.f6474f.clearHistory();
                this.f6474f.clearCache(true);
                this.f6474f.destroy();
                this.f6474f = null;
            }
        } catch (Throwable unused) {
        }
    }

    public void loadPolicyUrl(String str) {
        if (this.f6479k) {
            return;
        }
        this.f6480l = str;
        if (!h.a(getContext())) {
            this.f6478j = false;
            this.b.setVisibility(0);
            this.f6471c.clearAnimation();
            this.f6472d.setVisibility(0);
            this.a.setVisibility(8);
            a aVar = this.f6481m;
            if (aVar != null) {
                aVar.onPageLoadFail();
                return;
            }
            return;
        }
        this.f6478j = true;
        this.b.setVisibility(0);
        this.f6471c.clearAnimation();
        this.f6471c.startAnimation();
        this.f6472d.setVisibility(8);
        this.f6479k = true;
        if (this.f6480l.equals(this.f6474f.getUrl())) {
            this.f6474f.reload();
        } else {
            this.f6474f.loadUrl(this.f6480l);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f6476h) {
            ATSDK.setGDPRUploadDataLevel(getContext(), 0);
            view.setTag(0);
            a aVar = this.f6481m;
            if (aVar != null) {
                aVar.onLevelSelect(0);
                return;
            }
            return;
        }
        if (view == this.f6477i) {
            ATSDK.setGDPRUploadDataLevel(getContext(), 1);
            view.setTag(1);
            a aVar2 = this.f6481m;
            if (aVar2 != null) {
                aVar2.onLevelSelect(1);
            }
        }
    }

    public void setResultCallbackListener(a aVar) {
        this.f6481m = aVar;
    }

    static /* synthetic */ void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    private static void b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }
}
