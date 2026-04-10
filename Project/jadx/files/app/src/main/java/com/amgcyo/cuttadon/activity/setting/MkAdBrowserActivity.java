package com.amgcyo.cuttadon.activity.setting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.view.dialog.h1;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.amgcyo.cuttadon.view.webview.MkWebProgress;
import com.fatcatfat.io.R;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MkAdBrowserActivity extends BaseTitleBarActivity implements com.amgcyo.cuttadon.view.webview.a, PullToRefreshView.j {

    @BindView(R.id.swipe_refresh_layout)
    protected PullToRefreshView mRefreshView;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private NewApiAd f2823n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected boolean f2824o0 = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    h1 f2825p0;

    @BindView(R.id.pb_progress)
    protected MkWebProgress pbProgress;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    boolean f2826q0;

    @BindView(R.id.webview)
    protected WebView webView;

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void n() {
        WebSettings settings = this.webView.getSettings();
        settings.setLoadWithOverviewMode(false);
        settings.setSaveFormData(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        settings.setUseWideViewPort(true);
        this.webView.setInitialScale(100);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportMultipleWindows(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setTextZoom(100);
        this.webView.setWebChromeClient(new com.amgcyo.cuttadon.view.webview.c(this));
        this.webView.setWebViewClient(new com.amgcyo.cuttadon.view.webview.d(this));
        this.webView.setDownloadListener(new DownloadListener() { // from class: com.amgcyo.cuttadon.activity.setting.h
            @Override // com.tencent.smtt.sdk.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                this.a.a(str, str2, str3, str4, j2);
            }
        });
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setVerticalScrollBarEnabled(false);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(String str, String str2, String str3, String str4, long j2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    protected void e(String str) {
        if (this.B == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.B.setText(str);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.from_top_to_bottom);
    }

    public void hindWebView() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.setVisibility(4);
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        getWindow().setFormat(-3);
        this.mRefreshView.setColorSchemeColors(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
        this.mRefreshView.setOnRefreshListener(this);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        try {
            this.f2823n0 = (NewApiAd) intent.getSerializableExtra("new_api_ad");
            if (this.f2823n0 == null) {
                finish();
                showMessage(com.amgcyo.cuttadon.f.o.d(R.string.code_id_error_params));
            } else {
                n();
                this.webView.loadUrl(this.f2823n0.getDown_url());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_x5_webview;
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public boolean isOpenThirdApp(String str) {
        return com.amgcyo.cuttadon.view.webview.b.a((Activity) this, str);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        WebView webView = this.webView;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.webView);
            }
            this.webView.removeAllViews();
            this.webView.loadDataWithBaseURL(null, "", "text/html", com.anythink.expressad.foundation.g.a.bN, null);
            this.webView.stopLoading();
            this.webView.setWebChromeClient(null);
            this.webView.setWebViewClient(null);
            this.webView.destroy();
            this.webView = null;
        }
        super.onDestroy();
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void onPageFinished(WebView webView, String str) {
        e(webView.getTitle());
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setRefreshing(false);
        }
        NewApiAd newApiAd = this.f2823n0;
        if (newApiAd != null) {
            String down_package = newApiAd.getDown_package();
            final Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(down_package);
            if (this.f2826q0 || !com.amgcyo.cuttadon.utils.otherutils.g.b(this, down_package)) {
                return;
            }
            if (this.f2825p0 == null) {
                this.f2825p0 = new h1(this.f2277w);
            }
            if (isFinishing() || this.f2825p0.isShowing()) {
                return;
            }
            this.f2825p0.show();
            this.f2826q0 = true;
            this.f2825p0.a(String.format(Locale.getDefault(), com.amgcyo.cuttadon.f.o.d(R.string.browser_title), this.f2823n0.getDown_package_name()));
            this.f2825p0.a(new h1.a() { // from class: com.amgcyo.cuttadon.activity.setting.g
                @Override // com.amgcyo.cuttadon.view.dialog.h1.a
                public final void onClick() {
                    this.a.a(launchIntentForPackage);
                }
            });
        }
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void onReceivedTitle(WebView webView, String str) {
        e(str);
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        if (this.webView == null) {
            this.mRefreshView.setRefreshing(false);
            return;
        }
        this.mRefreshView.setRefreshing(true);
        String url = this.webView.getUrl();
        if (TextUtils.isEmpty(url)) {
            this.mRefreshView.setRefreshing(false);
        } else {
            this.webView.loadUrl(url);
        }
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void onScaleChanged(float f2) {
    }

    public void showWebView() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.setVisibility(0);
        }
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void startProgress(int i2) {
        MkWebProgress mkWebProgress;
        if (!this.f2824o0 || (mkWebProgress = this.pbProgress) == null) {
            return;
        }
        mkWebProgress.setWebProgress(i2);
    }

    public /* synthetic */ void a(Intent intent) {
        startActivity(intent);
    }
}
