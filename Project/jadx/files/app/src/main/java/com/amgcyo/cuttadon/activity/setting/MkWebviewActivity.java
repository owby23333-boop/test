package com.amgcyo.cuttadon.activity.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.fatcatfat.io.R;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class MkWebviewActivity extends BaseWebViewAcitivity {

    /* JADX INFO: Access modifiers changed from: private */
    class b {
        private b() {
        }

        public /* synthetic */ void a() {
            String str = com.amgcyo.cuttadon.f.o.d(R.string.app_name) + "分享二维码";
            ((BaseWebViewAcitivity) MkWebviewActivity.this).webView.setVisibility(0);
            MkWebviewActivity.this.hideLoading();
            Bitmap bitmapA = com.amgcyo.cuttadon.view.webview.b.a(((BaseWebViewAcitivity) MkWebviewActivity.this).webView);
            if (bitmapA != null) {
                MkWebviewActivity.this.a(str, bitmapA);
            }
        }

        @JavascriptInterface
        public String getUserInfo() {
            return MkWebviewActivity.this.e("base64");
        }

        @JavascriptInterface
        public String getUserInfoByType(String str) {
            return MkWebviewActivity.this.e(str);
        }

        @JavascriptInterface
        public void showToast(String str) {
            MkWebviewActivity.this.showMessage(str);
        }

        @JavascriptInterface
        public void webViewDidH5Load() {
            MkWebviewActivity.this.runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.setting.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2863s.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    public MkWebviewActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        setFinishOnTouchOutside(true);
        super.initData(bundle);
        this.f2285o0 = false;
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("param_url");
        int intExtra = intent.getIntExtra("webview_width", 750);
        int intExtra2 = intent.getIntExtra("webview_height", 1333);
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setEnabled(false);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point point = new Point();
        defaultDisplay.getSize(point);
        String str = "宽度：" + intExtra + " 高度：" + intExtra2 + " url: " + stringExtra;
        attributes.width = (int) (point.x * 0.75f);
        double dDoubleValue = new BigDecimal(intExtra2 / intExtra).setScale(6, 4).doubleValue();
        double d2 = point.x;
        Double.isNaN(d2);
        double d3 = dDoubleValue * d2;
        double d4 = 0.75f;
        Double.isNaN(d4);
        attributes.height = (int) (d3 * d4);
        getWindow().setAttributes(attributes);
        this.webView.addJavascriptInterface(new b(), this.f2284n0);
        this.webView.loadUrl(stringExtra);
        showLoading("正在生成图片...");
        this.webView.setVisibility(4);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }
}
