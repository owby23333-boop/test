package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static volatile AtomicInteger f1414a = new AtomicInteger(0);
    protected z dl;
    private ImageView e;
    private TextView fo;
    protected Context g;
    private LinearLayout gc;
    private TextView gz;
    private com.bytedance.sdk.openadsdk.core.dislike.dl.g i;
    private Intent kb;
    private FrameLayout ls;
    private ImageView m;
    private int p;
    private TTViewStub pf;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.z uy;
    private TTViewStub v;
    private String wp;
    protected SSWebView z;

    public interface z {
        void z(Dialog dialog);
    }

    static /* synthetic */ int dl(fo foVar) {
        int i = foVar.p;
        foVar.p = i + 1;
        return i;
    }

    static /* synthetic */ int g(fo foVar) {
        int i = foVar.p;
        foVar.p = i - 1;
        return i;
    }

    public fo(Context context, Intent intent) {
        super(context, tb.gz(context, "tt_dialog_full"));
        this.p = 0;
        this.g = context;
        this.kb = intent;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().clearFlags(131072);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.g);
        this.gc = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.gc.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.gc.setOrientation(1);
        this.z = new SSWebView(this.g);
        if (this.kb != null && TTDelegateActivity.z != null) {
            this.i = TTDelegateActivity.z.ct();
            this.wp = this.kb.getStringExtra("event_tag");
        }
        setContentView(com.bytedance.sdk.openadsdk.res.gc.eo(this.g));
        g();
    }

    private void dl() {
        TTViewStub tTViewStub;
        this.ls = (FrameLayout) findViewById(2114387634);
        this.v = (TTViewStub) findViewById(2114387770);
        this.pf = (TTViewStub) findViewById(2114387792);
        this.ls.addView(this.z, new LinearLayout.LayoutParams(-1, -1));
        int iL = com.bytedance.sdk.openadsdk.core.uy.ls().l();
        if (iL == 0) {
            TTViewStub tTViewStub2 = this.v;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
        } else if (iL == 1 && (tTViewStub = this.pf) != null) {
            tTViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.m = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fo.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    fo.f1414a.set(0);
                    if (fo.this.z != null && fo.this.z.canGoBack() && fo.this.p > 1) {
                        fo.this.z.goBack();
                        fo.g(fo.this);
                    } else {
                        fo.this.dismiss();
                        if (fo.this.dl != null) {
                            fo.this.dl.z(fo.this);
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.e = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fo.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    fo.f1414a.set(0);
                    fo.this.dismiss();
                    if (fo.this.dl != null) {
                        fo.this.dl.z(fo.this);
                    }
                }
            });
        }
        this.gz = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.fo = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fo.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    fo.this.z();
                }
            });
        }
    }

    protected void z() {
        if (this.g == null || this.i == null) {
            return;
        }
        if (this.uy == null) {
            this.uy = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(this.g, this.i, this.wp, true);
            com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.g, TTDelegateActivity.z, this.uy);
        }
        this.uy.z();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        getWindow().getAttributes().height = oq.gc(this.g) - oq.dl(this.g, 50.0f);
    }

    protected void g() {
        dl();
        if (this.gz != null && TTDelegateActivity.z != null && !TextUtils.isEmpty(TTDelegateActivity.z.li())) {
            this.gz.setText(TTDelegateActivity.z.li());
        }
        com.bytedance.sdk.openadsdk.core.widget.z.g.z(this.g).z(false).g(false).z(this.z);
        this.z.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.z.a(this.g, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.fo.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.getDefault());
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    fo.dl(fo.this);
                    return true;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a
            protected boolean z(WebView webView, WebResourceRequest webResourceRequest) {
                this.gz = fo.f1414a;
                return super.z(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a
            public boolean z(WebView webView, String str) {
                this.gz = fo.f1414a;
                return super.z(webView, str);
            }
        });
        this.z.setJavaScriptEnabled(true);
        this.z.setDisplayZoomControls(false);
        this.z.setCacheMode(2);
        this.z.loadUrl("https://phoniex.toutiao.com");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f1414a.set(0);
        z zVar = this.dl;
        if (zVar != null) {
            zVar.z(this);
        }
    }

    public fo z(z zVar) {
        this.dl = zVar;
        return this;
    }
}
