package com.amgcyo.cuttadon.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.setting.MkBigPicActivity;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.utils.otherutils.ScannerUtils;
import com.amgcyo.cuttadon.utils.otherutils.i0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.amgcyo.cuttadon.view.webview.MkWebProgress;
import com.fatcatfat.io.R;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import me.jessyan.art.mvp.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseWebViewAcitivity<P extends me.jessyan.art.mvp.c> extends BaseTitleBarActivity implements com.amgcyo.cuttadon.view.webview.a, PullToRefreshView.j {

    @BindView(R.id.swipe_refresh_layout)
    protected PullToRefreshView mRefreshView;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected String f2284n0 = "H5App";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected boolean f2285o0 = true;

    @BindView(R.id.pb_progress)
    protected MkWebProgress pbProgress;

    @BindView(R.id.webview)
    protected WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void f(String str) {
        Bitmap bitmapA = com.amgcyo.cuttadon.utils.otherutils.w.a(str);
        if (bitmapA != null) {
            a(com.open.hule.library.c.b.a(str), bitmapA);
        } else {
            runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.base.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2296s.n();
                }
            });
        }
    }

    private boolean o() {
        final WebView.HitTestResult hitTestResult = this.webView.getHitTestResult();
        if (hitTestResult.getType() != 5 && hitTestResult.getType() != 8) {
            return false;
        }
        new AlertDialog.Builder(this).setItems(new String[]{"查看大图", "保存图片到相册"}, new DialogInterface.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.base.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f2297s.a(hitTestResult, dialogInterface, i2);
            }
        }).show();
        return true;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void p() {
        WebSettings settings = this.webView.getSettings();
        settings.setLoadWithOverviewMode(false);
        settings.setSaveFormData(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        this.webView.setInitialScale(100);
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setTextZoom(100);
        this.webView.setWebChromeClient(new com.amgcyo.cuttadon.view.webview.c(this));
        this.webView.setWebViewClient(new com.amgcyo.cuttadon.view.webview.d(this));
        this.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.amgcyo.cuttadon.activity.base.r
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f2304s.e(view);
            }
        });
        this.webView.setDownloadListener(new DownloadListener() { // from class: com.amgcyo.cuttadon.activity.base.s
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

    public /* synthetic */ boolean e(View view) {
        return o();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.from_top_to_bottom);
    }

    protected void g(String str) {
        if (this.B == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.B.setText(str);
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
        p();
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

    public /* synthetic */ void n() {
        showMessage("保存图片失败!");
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
        g(webView.getTitle());
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.evaluateJavascript("sendData('webViewDidLoad','true')", null);
        }
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setRefreshing(false);
        }
    }

    @Override // com.amgcyo.cuttadon.view.webview.a
    public void onReceivedTitle(WebView webView, String str) {
        g(str);
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
        if (!this.f2285o0 || (mkWebProgress = this.pbProgress) == null) {
            return;
        }
        mkWebProgress.setWebProgress(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e(String str) throws Throwable {
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ == null) {
            return "{\"isLogin\":false}";
        }
        String str2 = "邀请码：" + mkUserJ.getInvitation_code();
        mkUserJ.setLogin(true);
        mkUserJ.setAppName(com.amgcyo.cuttadon.f.o.d(R.string.app_name));
        mkUserJ.setAppFlag(com.amgcyo.cuttadon.a.a.intValue());
        if (TextUtils.isEmpty(mkUserJ.getUser())) {
            mkUserJ.setUser("书友" + mkUserJ.getUser_id());
        }
        String strB = com.amgcyo.cuttadon.utils.otherutils.g.b(mkUserJ.getAvatar());
        if (!"base64".equals(str)) {
            if (!"url".equals(str)) {
                return "{\"isLogin\":false}";
            }
            mkUserJ.setAvatar(strB);
            return com.amgcyo.cuttadon.utils.otherutils.r.a(mkUserJ);
        }
        if (TextUtils.isEmpty(strB)) {
            return "{\"isLogin\":false}";
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(z.b() + File.separator + "user_avatar.jpg");
        if (bitmapDecodeFile == null) {
            return "{\"isLogin\":false}";
        }
        mkUserJ.setAvatar("data:image/*;base64," + com.amgcyo.cuttadon.utils.otherutils.w.a(bitmapDecodeFile));
        return com.amgcyo.cuttadon.utils.otherutils.r.a(mkUserJ);
    }

    public /* synthetic */ void a(WebView.HitTestResult hitTestResult, DialogInterface dialogInterface, int i2) {
        final String extra = hitTestResult.getExtra();
        if (TextUtils.isEmpty(extra)) {
            showMessage("无法获取到图片信息!");
        } else {
            if (i2 != 0) {
                new Thread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.base.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2299s.f(extra);
                    }
                }).start();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("default_pic_url", extra);
            r0.startActivity(this.f2277w, bundle, MkBigPicActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final String str, final Bitmap bitmap) {
        runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.base.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f2301s.a(bitmap, str);
            }
        });
    }

    public /* synthetic */ void a(Bitmap bitmap, String str) {
        boolean[] zArr = new boolean[1];
        if (i0.a()) {
            zArr[0] = z.a(a(), bitmap, str, "image/jpeg");
            if (zArr[0]) {
                com.amgcyo.cuttadon.f.o.b("已成功保存图片到相册");
                return;
            }
            return;
        }
        if (!com.hjq.permissions.f.a(a(), com.amgcyo.cuttadon.f.n.f3693g)) {
            com.hjq.permissions.f fVarA = com.hjq.permissions.f.a((FragmentActivity) a());
            fVarA.a(com.amgcyo.cuttadon.f.n.f3693g);
            fVarA.a(new w(this, zArr, str, bitmap));
        } else {
            zArr[0] = ScannerUtils.a(a(), str, bitmap, ScannerUtils.ScannerType.RECEIVER);
            if (zArr[0]) {
                com.amgcyo.cuttadon.f.o.b("已成功保存图片到相册");
            }
        }
    }
}
