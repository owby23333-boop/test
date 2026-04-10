package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends AlertDialog {
    protected static volatile AtomicInteger g = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Button f1415a;
    private Button dl;
    private SSWebView e;
    private z fo;
    private ImageView gc;
    private String gz;
    private boolean i;
    private HashMap<String, String> kb;
    private ListView m;
    private String uy;
    private List<dl> wp;
    protected Context z;

    public interface z {
        void dl(Dialog dialog);

        void g(Dialog dialog);

        void z(Dialog dialog);
    }

    public g(Context context, String str) {
        super(context, tb.gz(context, "tt_dialog_full"));
        this.wp = new ArrayList();
        this.i = false;
        this.z = context;
        this.uy = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
        if (!this.i) {
            a();
        } else {
            gc();
        }
        dl();
    }

    private void a() {
        if (this.z == null) {
            this.z = zw.getContext();
        }
        if (this.z.getResources().getConfiguration().orientation == 1) {
            setContentView(z(1));
        } else {
            setContentView(z(0));
        }
    }

    private void gc() {
        if (this.z == null) {
            this.z = zw.getContext();
        }
        if (this.z.getResources().getConfiguration().orientation == 1) {
            setContentView(g(1));
        } else {
            setContentView(g(0));
        }
    }

    private View z(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.z);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.z);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.z);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(oq.dl(this.z, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.z);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return z(i, linearLayout, linearLayout2, relativeLayout);
    }

    private LinearLayout z(int i, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.z);
        this.gc = imageView;
        imageView.setMaxHeight(oq.dl(this.z, 46.0f));
        this.gc.setMaxWidth(oq.dl(this.z, 46.0f));
        this.gc.setMinimumHeight(oq.dl(this.z, 46.0f));
        this.gc.setMinimumWidth(oq.dl(this.z, 46.0f));
        this.gc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.dl dlVar = new com.bytedance.sdk.openadsdk.res.dl(oq.dl(this.z, 14.0f));
        dlVar.z(-16777216);
        dlVar.z(oq.dl(this.z, 2.0f));
        this.gc.setImageDrawable(dlVar);
        relativeLayout.addView(this.gc);
        TextView textView = new TextView(this.z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view = new View(this.z);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, oq.dl(this.z, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return z(i, linearLayout, z(linearLayout2, view));
    }

    private LinearLayout z(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.m = new ListView(this.z);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = oq.dl(this.z, 20.0f);
        int iDl = oq.dl(this.z, 16.0f);
        this.m.setPadding(iDl, 0, iDl, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(oq.dl(this.z, 1.0f), Color.parseColor("#F0F0F0"));
        this.m.setDivider(gradientDrawable);
        this.m.setDividerHeight(oq.dl(this.z, 24.0f));
        this.m.setSelector(new ColorDrawable(0));
        this.m.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.m);
        View view2 = new View(this.z);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, oq.dl(this.z, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout z(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iDl = oq.dl(this.z, 16.0f);
        linearLayout3.setPadding(iDl, iDl, iDl, iDl);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.f1415a = new Button(this.z);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iDl2 = oq.dl(this.z, 7.0f);
        layoutParams2.leftMargin = iDl2;
        layoutParams2.rightMargin = iDl2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(oq.dl(this.z, 3.0f));
        gradientDrawable.setStroke(oq.dl(this.z, 0.5f), Color.parseColor("#E0161823"));
        this.f1415a.setBackground(gradientDrawable);
        int iDl3 = oq.dl(this.z, 12.0f);
        this.f1415a.setText("上一步");
        this.f1415a.setPadding(0, iDl3, 0, iDl3);
        this.f1415a.setTextColor(Color.parseColor("#A8161823"));
        this.f1415a.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.f1415a);
        return z(iDl2, iDl3, linearLayout3, g(i, linearLayout, linearLayout2));
    }

    private LinearLayout z(int i, int i2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.dl = new Button(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(oq.dl(this.z, 3.0f));
        this.dl.setBackground(gradientDrawable);
        this.dl.setText("立即下载");
        this.dl.setPadding(0, i2, 0, i2);
        this.dl.setTextColor(-1);
        this.dl.setLayoutParams(layoutParams);
        linearLayout.addView(this.dl);
        return linearLayout2;
    }

    private LinearLayout g(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.z);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, oq.dl(this.z, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    private View g(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.z);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.z);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.z);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(oq.dl(this.z, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return z(i, linearLayout, relativeLayout);
    }

    private LinearLayout z(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.z);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.z);
        this.gc = imageView;
        imageView.setMaxHeight(oq.dl(this.z, 46.0f));
        this.gc.setMaxWidth(oq.dl(this.z, 46.0f));
        this.gc.setMinimumHeight(oq.dl(this.z, 46.0f));
        this.gc.setMinimumWidth(oq.dl(this.z, 46.0f));
        this.gc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.dl dlVar = new com.bytedance.sdk.openadsdk.res.dl(oq.dl(this.z, 14.0f));
        dlVar.z(-16777216);
        dlVar.z(oq.dl(this.z, 2.0f));
        this.gc.setImageDrawable(dlVar);
        relativeLayout2.addView(this.gc);
        TextView textView = new TextView(this.z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout2.addView(textView);
        relativeLayout.addView(relativeLayout2);
        return g(i, linearLayout, relativeLayout);
    }

    private LinearLayout g(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.z);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, oq.dl(this.z, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.e = new SSWebView(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.e.setLayoutParams(layoutParams);
        relativeLayout.addView(this.e);
        View view2 = new View(this.z);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, oq.dl(this.z, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return dl(i, linearLayout, relativeLayout);
    }

    private LinearLayout dl(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.z);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int iDl = oq.dl(this.z, 16.0f);
        linearLayout2.setPadding(iDl, iDl, iDl, iDl);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.f1415a = new Button(this.z);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iDl2 = oq.dl(this.z, 7.0f);
        layoutParams2.leftMargin = iDl2;
        layoutParams2.rightMargin = iDl2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(oq.dl(this.z, 3.0f));
        gradientDrawable.setStroke(oq.dl(this.z, 0.5f), Color.parseColor("#E0161823"));
        this.f1415a.setBackground(gradientDrawable);
        int iDl3 = oq.dl(this.z, 12.0f);
        this.f1415a.setText("上一步");
        this.f1415a.setPadding(0, iDl3, 0, iDl3);
        this.f1415a.setTextColor(Color.parseColor("#A8161823"));
        this.f1415a.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.f1415a);
        return z(i, linearLayout, relativeLayout, linearLayout2, iDl2, iDl3);
    }

    private LinearLayout z(int i, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i2, int i3) {
        return z(i2, i3, linearLayout2, a(i, linearLayout, relativeLayout));
    }

    private LinearLayout a(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.z);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, oq.dl(this.z, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    protected void z() {
        this.e.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.z.a(this.z, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.g.1
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
                this.gz = g.g;
                return super.z(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a
            public boolean z(WebView webView, String str) {
                this.gz = g.g;
                return super.z(webView, str);
            }
        });
        this.e.setJavaScriptEnabled(true);
        this.e.setDisplayZoomControls(false);
        this.e.setCacheMode(2);
        this.e.loadUrl(this.gz);
    }

    protected void g() {
        if (TextUtils.isEmpty(this.uy)) {
            z(this.kb);
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.iq.m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(new JSONObject(this.uy));
            if (mVarGc != null) {
                HashMap<String, String> mapZ = mVarGc.z();
                this.kb = mapZ;
                if (!mapZ.isEmpty()) {
                    this.i = false;
                    z(this.kb);
                } else if (!TextUtils.isEmpty(mVarGc.g())) {
                    this.gz = mVarGc.g();
                    this.i = true;
                } else {
                    z(this.kb);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    private void z(HashMap<String, String> map) {
        List<dl> list = this.wp;
        if (list != null && list.size() > 0) {
            this.wp.clear();
        }
        if (this.wp == null) {
            this.wp = new ArrayList();
        }
        if (map == null || map.size() <= 0) {
            this.wp.add(new dl("补充中，可于应用官网查看", ""));
            return;
        }
        for (String str : map.keySet()) {
            this.wp.add(new dl(str, map.get(str)));
        }
    }

    protected void dl() {
        if (this.i) {
            z();
        } else {
            SSWebView sSWebView = this.e;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new SSWebView.z());
            }
        }
        this.dl.setVisibility(0);
        this.dl.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.g.set(0);
                if (g.this.fo != null) {
                    g.this.fo.z(g.this);
                }
            }
        });
        this.gc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.g.set(0);
                if (g.this.fo != null) {
                    g.this.fo.g(g.this);
                }
            }
        });
        this.f1415a.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.g.set(0);
                if (g.this.fo != null) {
                    g.this.fo.dl(g.this);
                }
            }
        });
        List<dl> list = this.wp;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.m.setAdapter((ListAdapter) new C0213g(this.z, 0, this.wp));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    public g z(z zVar) {
        this.fo = zVar;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        g.set(0);
        z zVar = this.fo;
        if (zVar != null) {
            zVar.g(this);
        }
    }

    class dl {
        private String dl;
        private String g;

        dl(String str, String str2) {
            this.g = str;
            this.dl = str2;
        }

        public String z() {
            return this.g;
        }

        public String g() {
            return this.dl;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.g$g, reason: collision with other inner class name */
    class C0213g extends ArrayAdapter<dl> {
        C0213g(Context context, int i, List<dl> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            z zVar;
            View view2;
            dl item = getItem(i);
            if (view == null) {
                RelativeLayout relativeLayout = new RelativeLayout(g.this.z);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setPadding(0, 0, 0, oq.dl(g.this.z, 17.0f));
                TextView textView = new TextView(g.this.z);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int iDl = oq.dl(g.this.z, 16.0f);
                layoutParams.leftMargin = iDl;
                layoutParams.rightMargin = iDl;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, oq.dl(g.this.z, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                ImageView imageView = new ImageView(g.this.z);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDl, iDl);
                layoutParams2.topMargin = oq.dl(g.this.z, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                tb.z(g.this.z, "tt_open_app_detail_list_item", (View) imageView);
                imageView.setLayoutParams(layoutParams2);
                relativeLayout.addView(imageView);
                TextView textView2 = new TextView(g.this.z);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = oq.dl(g.this.z, 8.0f);
                layoutParams3.topMargin = oq.dl(g.this.z, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout.addView(textView2);
                zVar = new z();
                zVar.g = textView;
                zVar.dl = textView2;
                zVar.f1416a = imageView;
                relativeLayout.setTag(zVar);
                view2 = relativeLayout;
            } else {
                zVar = (z) view.getTag();
                view2 = view;
            }
            zVar.f1416a.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.z())) {
                zVar.f1416a.setVisibility(4);
            }
            zVar.g.setText(item.z());
            zVar.dl.setText(item.g());
            return view2;
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.g$g$z */
        class z {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private ImageView f1416a;
            private TextView dl;
            private TextView g;

            z() {
            }
        }
    }
}
