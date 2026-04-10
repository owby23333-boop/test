package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends AlertDialog {
    protected static volatile AtomicInteger z = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f1420a;
    private Context dl;
    private String e;
    private RelativeLayout fo;
    private SSWebView g;
    private String gc;
    private RelativeLayout gz;
    private ImageView kb;
    private z m;
    private ImageView uy;

    public interface z {
        void z(Dialog dialog);
    }

    public kb(Context context, String str) {
        super(context, tb.gz(context, "tt_dialog_full"));
        this.e = str;
        this.dl = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.gc.na(this.dl));
        g();
        z();
    }

    protected void z() {
        String strGy = zw.g().gy();
        if (TextUtils.isEmpty(strGy)) {
            this.gc = "https://www.pangle.cn/privacy/partner";
        } else {
            this.gc = strGy;
        }
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        if (this.gc.contains("?")) {
            this.gc += "&ad_info=" + this.e;
        } else {
            this.gc += "?ad_info=" + this.e;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        z.set(0);
        z zVar = this.m;
        if (zVar != null) {
            zVar.z(this);
        }
    }

    protected void g() {
        this.g = (SSWebView) findViewById(2114387763);
        TextView textView = (TextView) findViewById(2114387652);
        this.f1420a = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.kb.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kb.this.m != null) {
                    kb.this.m.z(kb.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.g.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.z.a(this.dl, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.kb.2
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
                    String lowerCase = scheme.toLowerCase(Locale.US);
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a
            protected boolean z(WebView webView, WebResourceRequest webResourceRequest) {
                this.gz = kb.z;
                return super.z(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a
            public boolean z(WebView webView, String str) {
                this.gz = kb.z;
                return super.z(webView, str);
            }
        });
        this.g.setJavaScriptEnabled(true);
        this.g.setDisplayZoomControls(false);
        this.g.setCacheMode(2);
        this.g.loadUrl(this.gc);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387883);
        this.gz = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387894);
        this.fo = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.f1420a.setVisibility(8);
        this.uy = (ImageView) findViewById(2114387813);
        this.kb = (ImageView) findViewById(2114387836);
        this.uy.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.kb.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kb.this.m != null) {
                    kb.this.m.z(kb.this);
                    kb.z.set(0);
                }
            }
        });
        this.kb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.kb.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((ClipboardManager) kb.this.dl.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, kb.this.gc));
                    hh.z(kb.this.dl, "链接复制成功", 1);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                    hh.z(kb.this.dl, "链接复制失败", 1);
                }
            }
        });
    }

    public kb z(z zVar) {
        this.m = zVar;
        return this;
    }
}
