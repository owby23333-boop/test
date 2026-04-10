package com.miui.zeus.landingpage.sdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.miui.zeus.landingpage.sdk.LPWebView;
import com.miui.zeus.landingpage.sdk.R;
import com.miui.zeus.landingpage.sdk.d;
import com.miui.zeus.landingpage.sdk.h;
import com.miui.zeus.landingpage.sdk.n;
import com.yuewen.rr3;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f7187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f7188b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewActivity.this.finish();
        }
    }

    public final void a() {
        Intent intent = getIntent();
        if (intent == null) {
            h.b("WebViewActivity", "intent == null");
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            h.b("WebViewActivity", "bundle == null");
            finish();
            return;
        }
        String string = extras.getString(rr3.i);
        if (TextUtils.isEmpty(string)) {
            h.b("WebViewActivity", "url is empty");
            return;
        }
        if (extras.getBoolean("key_show_top_bar", false)) {
            findViewById(R.id.lp_webview_rl_tool_bar).setVisibility(0);
        }
        if (extras.containsKey("key_orientation")) {
            int i = extras.getInt("key_orientation", -1);
            h.a("WebViewActivity", "orientation=" + i);
            setRequestedOrientation(i);
        }
        if (n.a(string)) {
            LPWebView lPWebView = new LPWebView(this);
            lPWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            lPWebView.setScrollBarSize((int) ((getResources().getDisplayMetrics().density * 3.0f) + 0.5f));
            lPWebView.setScrollBarStyle(33554432);
            lPWebView.setVerticalScrollBarEnabled(true);
            this.f7187a = lPWebView;
        } else {
            this.f7187a = new d(getApplicationContext());
        }
        this.f7188b.addView(this.f7187a);
        h.a("WebViewActivity", "url=" + string);
        this.f7187a.loadUrl(string);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.lp_activity_webview);
            this.f7188b = (FrameLayout) findViewById(R.id.lp_webView_container);
            ((ImageView) findViewById(R.id.lp_webview_iv_back)).setOnClickListener(new a());
            a();
        } catch (Exception e) {
            h.a("WebViewActivity", "WebViewActivity onCreate:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.f7187a;
        if (webView != null) {
            webView.destroy();
            this.f7187a = null;
        }
        FrameLayout frameLayout = this.f7188b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f7187a.canGoBack()) {
            this.f7187a.goBack();
            return true;
        }
        finish();
        return true;
    }
}
