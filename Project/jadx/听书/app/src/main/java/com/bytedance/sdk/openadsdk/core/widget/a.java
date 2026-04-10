package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a extends AlertDialog {
    protected static volatile AtomicInteger m = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f1412a;
    protected TextView dl;
    private String e;
    protected Context g;
    protected z gc;
    protected SSWebView z;

    public interface z {
        void z(Dialog dialog);
    }

    public a(Context context, String str, String str2) {
        super(context, tb.gz(context, "tt_dialog_full"));
        this.g = context;
        this.e = str2;
        this.f1412a = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.gc.jq(getContext()));
        z();
    }

    protected void z() {
        this.z = (SSWebView) findViewById(2114387839);
        this.dl = (TextView) findViewById(2114387912);
        ((TextView) findViewById(2114387696)).setText(this.e);
        this.dl.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.m.set(0);
                if (a.this.gc != null) {
                    a.this.gc.z(a.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.z.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.z.a(this.g, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
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
                    return true;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a
            protected boolean z(WebView webView, WebResourceRequest webResourceRequest) {
                this.gz = a.m;
                return super.z(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a
            public boolean z(WebView webView, String str) {
                this.gz = a.m;
                return super.z(webView, str);
            }
        });
        this.z.setJavaScriptEnabled(true);
        this.z.setDisplayZoomControls(false);
        this.z.setCacheMode(2);
        this.z.loadUrl(this.f1412a);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        m.set(0);
        z zVar = this.gc;
        if (zVar != null) {
            zVar.z(this);
        }
    }

    public a z(z zVar) {
        this.gc = zVar;
        return this;
    }
}
