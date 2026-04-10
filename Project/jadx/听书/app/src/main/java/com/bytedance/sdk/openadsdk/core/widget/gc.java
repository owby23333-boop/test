package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends AlertDialog {
    protected static volatile AtomicInteger dl = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSWebView f1417a;
    private Button e;
    private z fo;
    protected String g;
    private Context gc;
    private Button gz;
    private ImageView m;
    protected String z;

    public interface z {
        void dl(Dialog dialog);

        void g(Dialog dialog);

        void z(Dialog dialog);
    }

    public gc(Context context, String str, String str2, String str3) {
        super(context, tb.gz(context, "tt_dialog_full"));
        this.gc = context;
        this.z = str;
        this.g = str3;
        if (TextUtils.isEmpty(str) || !(this.z.startsWith("https") || this.z.startsWith("http"))) {
            this.z = str2;
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gc == null) {
            this.gc = zw.getContext();
        }
        z();
    }

    private View z(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.gc);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.gc);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.gc);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(oq.dl(this.gc, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.gc);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.gc);
        this.m = imageView;
        imageView.setMaxHeight(oq.dl(this.gc, 46.0f));
        this.m.setMaxWidth(oq.dl(this.gc, 46.0f));
        this.m.setMinimumHeight(oq.dl(this.gc, 46.0f));
        this.m.setMinimumWidth(oq.dl(this.gc, 46.0f));
        this.m.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.dl dlVar = new com.bytedance.sdk.openadsdk.res.dl(oq.dl(this.gc, 14.0f));
        dlVar.z(-16777216);
        dlVar.z(oq.dl(this.gc, 2.0f));
        this.m.setImageDrawable(dlVar);
        relativeLayout.addView(this.m);
        TextView textView = new TextView(this.gc);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText(this.g);
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.gc);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, oq.dl(this.gc, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.f1417a = new SSWebView(this.gc);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.f1417a.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.f1417a);
        View view3 = new View(this.gc);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, oq.dl(this.gc, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.gc);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iDl = oq.dl(this.gc, 16.0f);
        linearLayout3.setPadding(iDl, iDl, iDl, iDl);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.gz = new Button(this.gc);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int iDl2 = oq.dl(this.gc, 7.0f);
        layoutParams7.leftMargin = iDl2;
        layoutParams7.rightMargin = iDl2;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(oq.dl(this.gc, 3.0f));
        gradientDrawable2.setStroke(oq.dl(this.gc, 0.5f), Color.parseColor("#E0161823"));
        this.gz.setBackground(gradientDrawable2);
        int iDl3 = oq.dl(this.gc, 12.0f);
        this.gz.setText("上一步");
        this.gz.setPadding(0, iDl3, 0, iDl3);
        this.gz.setTextColor(Color.parseColor("#A8161823"));
        this.gz.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.gz);
        this.e = new Button(this.gc);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = iDl2;
        layoutParams8.rightMargin = iDl2;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(oq.dl(this.gc, 3.0f));
        this.e.setBackground(gradientDrawable3);
        this.e.setText("立即下载");
        this.e.setPadding(0, iDl3, 0, iDl3);
        this.e.setTextColor(-1);
        this.e.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.e);
        if (i == 0) {
            return linearLayout;
        }
        View view4 = new View(this.gc);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, oq.dl(this.gc, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    protected void z() {
        if (this.gc.getResources().getConfiguration().orientation == 1) {
            setContentView(z(1));
        } else {
            setContentView(z(0));
        }
        this.m.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.gc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                gc.dl.set(0);
                if (gc.this.fo != null) {
                    gc.this.fo.g(gc.this);
                }
            }
        });
        this.gz.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.gc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                gc.dl.set(0);
                if (gc.this.fo != null) {
                    gc.this.fo.dl(gc.this);
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.gc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                gc.dl.set(0);
                if (gc.this.fo != null) {
                    gc.this.fo.z(gc.this);
                }
            }
        });
        this.f1417a.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.z.a(this.gc, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.gc.4
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
                    String lowerCase = scheme.toLowerCase(Locale.ROOT);
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
                this.gz = gc.dl;
                return super.z(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a
            public boolean z(WebView webView, String str) {
                this.gz = gc.dl;
                return super.z(webView, str);
            }
        });
        this.f1417a.setJavaScriptEnabled(true);
        this.f1417a.setDisplayZoomControls(false);
        this.f1417a.setCacheMode(2);
        this.f1417a.loadUrl(this.z);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dl.set(0);
        z zVar = this.fo;
        if (zVar != null) {
            zVar.g(this);
        }
    }

    public gc z(z zVar) {
        this.fo = zVar;
        return this;
    }
}
