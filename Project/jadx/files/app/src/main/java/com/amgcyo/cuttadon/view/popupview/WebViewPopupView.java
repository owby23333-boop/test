package com.amgcyo.cuttadon.view.popupview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.webview.MkWebProgress;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.CenterPopupView;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: loaded from: classes.dex */
public class WebViewPopupView extends CenterPopupView implements View.OnClickListener, com.amgcyo.cuttadon.view.webview.a {
    TextView R;
    TextView S;
    ImageView T;
    WebView U;
    protected MkWebProgress V;
    String W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    String f5175a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    Context f5176b0;

    public WebViewPopupView(@NonNull Context context, String str, String str2) {
        super(context);
        this.f5176b0 = context;
        this.W = str;
        this.f5175a0 = str2;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void y() {
        WebSettings settings = this.U.getSettings();
        settings.setLoadWithOverviewMode(false);
        settings.setSaveFormData(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        settings.setUseWideViewPort(true);
        this.U.setInitialScale(100);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportMultipleWindows(true);
        this.U.setWebChromeClient(new com.amgcyo.cuttadon.view.webview.c(this));
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setTextZoom(100);
        this.U.setDownloadListener(new DownloadListener() { // from class: com.amgcyo.cuttadon.view.popupview.f
            @Override // com.tencent.smtt.sdk.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                this.a.a(str, str2, str3, str4, j2);
            }
        });
        this.U.setHorizontalScrollBarEnabled(false);
        this.U.setVerticalScrollBarEnabled(false);
    }

    public /* synthetic */ void a(String str, String str2, String str3, String str4, long j2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        this.f5176b0.startActivity(intent);
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.popup_webview;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return n.c(MkApplication.getAppContext());
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public boolean isOpenThirdApp(String str) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_close || id == R.id.tv_knows) {
            g();
        }
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void onPageFinished(WebView webView, String str) {
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void onReceivedTitle(WebView webView, String str) {
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void onScaleChanged(float f2) {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.T = (ImageView) findViewById(R.id.iv_close);
        this.R = (TextView) findViewById(R.id.tv_title);
        this.R.setText(this.f5175a0);
        this.U = (WebView) findViewById(R.id.wb_rule);
        this.S = (TextView) findViewById(R.id.tv_knows);
        this.V = (MkWebProgress) findViewById(R.id.pb_progress);
        this.T.setOnClickListener(this);
        this.S.setOnClickListener(this);
        y();
        if (TextUtils.isEmpty(this.W)) {
            return;
        }
        this.U.loadUrl(this.W);
    }

    public void setUrl(String str) {
        this.W = str;
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void startProgress(int i2) {
        MkWebProgress mkWebProgress = this.V;
        if (mkWebProgress != null) {
            mkWebProgress.setWebProgress(i2);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
