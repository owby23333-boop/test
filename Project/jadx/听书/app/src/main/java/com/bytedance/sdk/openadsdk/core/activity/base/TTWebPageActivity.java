package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.dislike.ui.z;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.kb.g.dl;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.p.a;
import com.bytedance.sdk.openadsdk.core.p.z;
import com.bytedance.sdk.openadsdk.core.playable.g.g;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.q;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTWebPageActivity extends BaseLandingPageActivity implements l.z, a {
    private static final String gz = "TTWebPageActivity";
    gc e;
    private SSWebView fo;
    private LinearLayout fv;
    private String gk;
    private boolean h;
    private LinearLayout hh;
    private TextView i;
    private TTViewStub io;
    private TTViewStub iq;
    private int j;
    private ImageView js;
    private ImageView kb;
    private mc l;
    private TextView ls;
    com.bytedance.sdk.openadsdk.core.dislike.ui.z m;
    private Activity mc;
    private boolean na;
    private com.bytedance.sdk.openadsdk.core.widget.z.a oq;
    private TextView p;
    private TextView pf;
    private TTViewStub q;
    private TTProgressBar sy;
    private g t;
    private Context tb;
    private dl ti;
    private Button uf;
    private com.bytedance.sdk.openadsdk.wp.a un;
    private ImageView uy;
    private TextView v;
    private boolean wj;
    private TextView wp;
    private int xl;
    private TTViewStub zw;
    private AtomicBoolean x = new AtomicBoolean(true);
    private JSONArray lq = null;
    private final Map<String, dl> eo = Collections.synchronizedMap(new HashMap());
    private final l gp = new l(Looper.getMainLooper(), this);
    private int vm = 0;
    private String y = "立即下载";
    private com.bytedance.sdk.openadsdk.core.kb.g.z ec = new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.12
        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z() {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.z(tTWebPageActivity.e());
            z.C0193z.z(TTWebPageActivity.this.z, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.z("下载中...");
            String unused = TTWebPageActivity.gz;
            if (j > 0) {
                z.C0193z.z(TTWebPageActivity.this.z, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void g(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.z("暂停");
            if (j > 0) {
                z.C0193z.z(TTWebPageActivity.this.z, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void dl(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.z("下载失败");
            if (j > 0) {
                z.C0193z.z(TTWebPageActivity.this.z, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(long j, String str, String str2) {
            TTWebPageActivity.this.z("点击安装");
            z.C0193z.z(TTWebPageActivity.this.z, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(String str, String str2) {
            TTWebPageActivity.this.z("点击打开");
            z.C0193z.z(TTWebPageActivity.this.z, 6, 100);
        }
    };

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gc == null) {
            return;
        }
        this.mc = this;
        this.tb = this;
        try {
            zw.z(this);
        } catch (Throwable unused) {
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        setContentView(gz());
        Intent intent = getIntent();
        com.bytedance.sdk.openadsdk.core.playable.g.z().z(this.gc);
        wp();
        fo();
        if (this.fo != null) {
            com.bytedance.sdk.openadsdk.core.widget.z.g.z(this.tb).z(false).g(false).z(this.fo);
        }
        this.h = intent.getBooleanExtra("is_outer_click", false);
        String stringExtra = intent.getStringExtra("url");
        this.gk = stringExtra;
        this.gk = eo.g(this.gc, this.gk);
        String stringExtra2 = intent.getStringExtra("title");
        if (this.gc != null && this.gc.ct() != null) {
            this.gc.ct().z("landing_page");
        }
        this.vm = intent.getIntExtra("get_phone_num_status", 0);
        dl(this.gc);
        SSWebView sSWebView = this.fo;
        if (sSWebView != null) {
            sSWebView.addJavascriptInterface(new com.bytedance.sdk.openadsdk.core.lq.g.z(this.fo, getApplicationContext(), this.gc != null ? this.gc.dl() : this.vm, this.gc), "CCWifiJSBridge");
            this.e = new gc(this.gc, this.fo).g(true).g(jCurrentTimeMillis).a(this.fo.getCreateDuration());
            a();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.z);
            jSONObject.put("url", stringExtra);
            jSONObject.put("web_title", stringExtra2);
            jSONObject.put("is_multi_process", com.bytedance.sdk.openadsdk.core.multipro.g.dl());
            jSONObject.put("event_tag", this.dl);
        } catch (JSONException unused2) {
        }
        this.e.z(jSONObject);
        uy();
        com.bytedance.sdk.openadsdk.core.widget.z.a aVar = new com.bytedance.sdk.openadsdk.core.widget.z.a(this.tb, this.l, this.z, this.e, this.un) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTWebPageActivity.this.sy == null || TTWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTWebPageActivity.this.sy.setVisibility(8);
                } catch (Throwable unused3) {
                }
            }
        };
        this.oq = aVar;
        this.fo.setWebViewClient(aVar);
        SSWebView sSWebView2 = this.fo;
        if (sSWebView2 != null) {
            q.z(sSWebView2, gk.dl, na.a(this.gc));
        }
        this.fo.setMixedContentMode(0);
        this.fo.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.l, this.e) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.dl, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTWebPageActivity.this.sy == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i != 100 || !TTWebPageActivity.this.sy.isShown()) {
                    TTWebPageActivity.this.sy.setProgress(i);
                } else {
                    TTWebPageActivity.this.sy.setVisibility(8);
                }
            }
        });
        this.fo.setDownloadListener(new z(this.eo, this.gc, this.tb, this.dl));
        TextView textView = this.wp;
        if (textView != null && !this.wj && !this.na) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = tb.z(this.mc, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        TextView textView2 = this.ls;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.z(tTWebPageActivity.gc);
                }
            });
        }
        TextView textView3 = this.p;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.g(tTWebPageActivity.gc);
                }
            });
        }
        m();
        z(4);
        com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, getClass().getName());
        this.fo.setVisibility(0);
        this.e.dl(System.currentTimeMillis());
        this.fo.loadUrl(this.gk);
        com.bytedance.sdk.openadsdk.core.i.a.g(this.gc);
        if (this.wj || this.na) {
            i();
        }
        this.t = new g(this.e.z());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g gVar = this.t;
        if (gVar != null) {
            gVar.z(this.mc, this.gc);
        }
    }

    private void a() {
        na naVar = this.gc;
        if (naVar == null) {
            return;
        }
        this.un = com.bytedance.sdk.openadsdk.wp.a.z(this.tb, naVar, this.gk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(na naVar) {
        if (naVar == null) {
            return;
        }
        String strGy = naVar.gy();
        pf();
        m.z(this.tb, naVar.mj(), strGy, new m.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                TTWebPageActivity.this.ls();
                TTWebPageActivity.this.gc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                TTWebPageActivity.this.ls();
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                TTWebPageActivity.this.ls();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(na naVar) {
        if (naVar == null) {
            return;
        }
        String strGy = naVar.gy();
        pf();
        m.z(this.tb, naVar.mj(), new m.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.11
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                TTWebPageActivity.this.ls();
                TTWebPageActivity.this.gc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                TTWebPageActivity.this.ls();
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                TTWebPageActivity.this.ls();
            }
        }, strGy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        int iFv = com.bytedance.sdk.openadsdk.core.iq.tb.fv(this.gc);
        if (this.gc != null) {
            if (this.gc.lt() == 4 || iFv != 0) {
                if (this.ti == null) {
                    dl dlVarZ = gz.z((Context) this.mc, this.gc, TextUtils.isEmpty(this.dl) ? eo.z(this.f913a) : this.dl, false);
                    this.ti = dlVarZ;
                    dlVarZ.z(uy.z(this.gc));
                    this.ti.z(this.ec, false);
                }
                this.ti.z(this.mc);
                dl dlVar = this.ti;
                if (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                    ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVar).m(true);
                    ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) this.ti).gz().z(false);
                }
                com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.mc, this.gc, "embeded_ad_landingpage", this.f913a);
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(true);
                this.ti.z(this.gc, false);
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.ti);
            }
        }
    }

    private void m() {
        if (this.gc == null || this.gc.lt() != 4) {
            return;
        }
        TTViewStub tTViewStub = this.io;
        if (tTViewStub != null) {
            tTViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(2114387729);
        this.uf = button;
        if (button != null) {
            z(e());
            if (this.ti == null) {
                dl dlVarZ = gz.z((Context) this.mc, this.gc, TextUtils.isEmpty(this.dl) ? eo.z(this.f913a) : this.dl, false);
                this.ti = dlVarZ;
                dlVarZ.z(uy.z(this.gc));
                this.ti.z(this.ec, false);
            }
            this.ti.z(this.mc);
            dl dlVar = this.ti;
            if (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVar).m(true);
            }
            com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.mc, this.gc, "embeded_ad_landingpage", this.f913a);
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(true);
            this.uf.setOnClickListener(zVar);
            this.uf.setOnTouchListener(zVar);
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.ti);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        if (this.gc != null && !TextUtils.isEmpty(this.gc.no())) {
            this.y = this.gc.no();
        }
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.uf) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (TTWebPageActivity.this.uf == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTWebPageActivity.this.uf.setText(str);
            }
        });
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m();
    }

    private View gz() {
        Activity activity = this.mc;
        if (activity == null) {
            return null;
        }
        Resources resources = activity.getResources();
        this.hh = new LinearLayout(this.mc);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.hh.setOrientation(1);
        this.hh.setLayoutParams(layoutParams);
        TTViewStub tTViewStub = new TTViewStub(this.tb, new com.bytedance.sdk.openadsdk.res.layout.z.g());
        this.q = tTViewStub;
        tTViewStub.setId(2114387770);
        this.hh.addView(this.q, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub2 = new TTViewStub(this.tb, new com.bytedance.sdk.openadsdk.res.layout.z.dl());
        this.iq = tTViewStub2;
        tTViewStub2.setId(2114387792);
        this.hh.addView(this.iq, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub3 = new TTViewStub(this.tb, new com.bytedance.sdk.openadsdk.res.layout.z.a());
        this.zw = tTViewStub3;
        tTViewStub3.setId(2114387933);
        this.hh.addView(this.zw, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.mc);
        this.hh.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        SSWebView sSWebView = new SSWebView(this.mc);
        this.fo = sSWebView;
        sSWebView.setMaterialMeta(un.z(this.gc));
        this.fo.setId(2114387733);
        this.fo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.fo);
        TTViewStub tTViewStub4 = new TTViewStub(this.tb, new com.bytedance.sdk.openadsdk.res.layout.z.z());
        this.io = tTViewStub4;
        tTViewStub4.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.io, layoutParams2);
        TTProgressBar tTProgressBar = new TTProgressBar(this.mc, null, R.style.Widget.ProgressBar.Horizontal);
        this.sy = tTProgressBar;
        tTProgressBar.setId(2114387922);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.sy.setLayoutParams(layoutParams3);
        this.sy.setProgress(1);
        this.sy.setProgressDrawable(tb.dl(this.mc, "tt_browser_progress_style"));
        frameLayout.addView(this.sy);
        return this.hh;
    }

    private void fo() {
        TTViewStub tTViewStub;
        if (this.wj || this.na) {
            TTViewStub tTViewStub2 = this.zw;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.js = (ImageView) findViewById(2114387843);
        } else if (this.gc != null && this.gc.kb()) {
            TTViewStub tTViewStub3 = this.q;
            if (tTViewStub3 != null) {
                tTViewStub3.setVisibility(8);
            }
            TTViewStub tTViewStub4 = this.iq;
            if (tTViewStub4 != null) {
                tTViewStub4.setVisibility(8);
            }
        } else {
            int iL = com.bytedance.sdk.openadsdk.core.uy.ls().l();
            if (iL == 0) {
                TTViewStub tTViewStub5 = this.q;
                if (tTViewStub5 != null) {
                    tTViewStub5.setVisibility(0);
                }
            } else if (iL == 1 && (tTViewStub = this.iq) != null) {
                tTViewStub.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.uy = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (oq.z(TTWebPageActivity.this.fo)) {
                        return;
                    }
                    if (TTWebPageActivity.this.t != null) {
                        TTWebPageActivity.this.t.z(0);
                    }
                    TTWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.kb = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.wp = (TextView) findViewById(2114387952);
        this.i = (TextView) findViewById(2114387627);
        this.v = (TextView) findViewById(2114387610);
        this.pf = (TextView) findViewById(2114387701);
        this.ls = (TextView) findViewById(2114387598);
        this.p = (TextView) findViewById(2114387700);
        this.fv = (LinearLayout) findViewById(2114387676);
        TextView textView = this.i;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.z();
                }
            });
        }
    }

    private void uy() {
        if (this.fo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gc);
        mc mcVar = new mc(this.mc);
        this.l = mcVar;
        mcVar.a(this.h);
        this.l.g(this.fo).z(this.gc).dl(arrayList).g(this.z).a(this.g).dl(this.f913a).z(this.dl).gc(eo.ls(this.gc)).z(this.fo).z(true).g(uy.z(this.gc)).z(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        mc mcVar = this.l;
        if (mcVar != null) {
            mcVar.hh();
            this.l.z(new SSWebView.g() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.4
                @Override // com.bytedance.sdk.component.widget.SSWebView.g
                public void z(int i) {
                    TTWebPageActivity.this.l.z(i);
                }
            });
        }
        dl dlVar = this.ti;
        if (dlVar != null) {
            dlVar.z();
        }
        Map<String, dl> map = this.eo;
        if (map != null) {
            for (Map.Entry<String, dl> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().z();
                }
            }
        }
        gc gcVar = this.e;
        if (gcVar != null) {
            gcVar.a();
        }
        com.bytedance.sdk.openadsdk.core.widget.z.a aVar = this.oq;
        if (aVar != null) {
            aVar.g(true);
        }
        kb();
        ls();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        gc gcVar = this.e;
        if (gcVar != null) {
            gcVar.gc();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        mc mcVar = this.l;
        if (mcVar != null) {
            mcVar.l();
        }
        Map<String, dl> map = this.eo;
        if (map != null) {
            for (Map.Entry<String, dl> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.widget.z.a aVar = this.oq;
        if (aVar != null) {
            aVar.dl();
        }
        pf();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        g gVar = this.t;
        if (gVar != null) {
            gVar.z(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            if ((na.dl(this.gc) || com.bytedance.sdk.openadsdk.core.iq.mc.z(this.gc)) && oq.z(this.fo)) {
                return;
            }
            g gVar = this.t;
            if (gVar == null || !gVar.g(this.mc, this.gc)) {
                super.onBackPressed();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i) {
        if (na.dl(this.gc)) {
            oq.z((View) this.kb, 4);
        } else if (na.dl(this.gc)) {
            oq.z((View) this.kb, i);
        }
    }

    private void kb() {
        if (this.gc == null) {
            return;
        }
        JSONArray jSONArrayG = g(this.gk);
        int iFo = eo.fo(this.gc);
        int iGz = eo.gz(this.gc);
        sy<com.bytedance.sdk.openadsdk.core.i.z> syVarZ = zw.z();
        if (jSONArrayG == null || syVarZ == null || iFo <= 0 || iGz <= 0) {
            return;
        }
        j jVar = new j();
        jVar.gc = jSONArrayG;
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = this.gc.lw();
        if (gVarLw == null) {
            return;
        }
        syVarZ.z(com.bytedance.sdk.openadsdk.core.un.l.g(gVarLw).dl(6).z(), jVar, iGz, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar) {
                TTWebPageActivity.this.z(0);
                gVar.z(i);
                com.bytedance.sdk.openadsdk.core.iq.g.z(gVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar) {
                if (zVar != null) {
                    try {
                        TTWebPageActivity.this.x.set(false);
                        TTWebPageActivity.this.l.z(zVar.dl());
                    } catch (Exception unused) {
                        TTWebPageActivity.this.z(0);
                    }
                }
            }
        });
    }

    private JSONArray g(String str) {
        int i;
        JSONArray jSONArray = this.lq;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.lq;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?id=");
        int iIndexOf2 = str.indexOf("&");
        if (iIndexOf == -1 || iIndexOf2 == -1 || (i = iIndexOf + 4) >= iIndexOf2) {
            return null;
        }
        String strSubstring = str.substring(i, iIndexOf2);
        if (TextUtils.isEmpty(strSubstring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(strSubstring);
        return jSONArray2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        gc gcVar = this.e;
        if (gcVar != null) {
            gcVar.e();
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.fo;
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.oq.z(this.tb, sSWebView);
            com.bytedance.sdk.openadsdk.core.oq.z(this.fo);
        }
        this.fo = null;
        com.bytedance.sdk.openadsdk.wp.a aVar = this.un;
        if (aVar != null) {
            aVar.a();
        }
        mc mcVar = this.l;
        if (mcVar != null) {
            mcVar.h();
        }
        dl dlVar = this.ti;
        if (dlVar != null) {
            dlVar.g();
        }
        Map<String, dl> map = this.eo;
        if (map != null) {
            for (Map.Entry<String, dl> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().g();
                }
            }
            this.eo.clear();
        }
        gc gcVar2 = this.e;
        if (gcVar2 != null) {
            gcVar2.m();
        }
        com.bytedance.sdk.openadsdk.core.playable.g.z().g(this.gc);
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.a
    public void z(boolean z2, JSONArray jSONArray) {
        if (!z2 || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.lq = jSONArray;
        kb();
    }

    protected void z() {
        if (this.gc == null || isFinishing()) {
            return;
        }
        if (this.m == null) {
            g();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = this.m;
        if (zVar != null) {
            zVar.z();
        }
    }

    void g() {
        try {
            this.m = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(this.mc, this.gc.ct(), this.dl, true);
            com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.mc, this.gc, this.m);
            this.m.z(new z.InterfaceC0168z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                public void z() {
                    TTWebPageActivity.this.pf();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                public void z(int i, String str, boolean z2) {
                    TTWebPageActivity.this.ls();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                public void g() {
                    TTWebPageActivity.this.ls();
                }
            });
        } catch (Exception e) {
            wp.dl(e.getMessage());
        }
    }

    private void dl(na naVar) {
        LinearLayout linearLayout = this.fv;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (this.gc == null) {
            LinearLayout linearLayout2 = this.fv;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        String strGy = naVar.gy();
        if (TextUtils.isEmpty(strGy)) {
            LinearLayout linearLayout3 = this.fv;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(strGy)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.iq.m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(new JSONObject(strGy));
            if (mVarGc == null) {
                LinearLayout linearLayout4 = this.fv;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(mVarGc.i())) {
                LinearLayout linearLayout5 = this.fv;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout6 = this.fv;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            String strGc = mVarGc.gc();
            String strE = mVarGc.e();
            String strV = mVarGc.v();
            if (TextUtils.isEmpty(strV)) {
                strV = uy.g(naVar);
            }
            if (this.v != null) {
                this.v.setText(String.format(tb.z(this.tb, "tt_open_app_detail_developer"), strE));
            }
            if (this.pf != null) {
                this.pf.setText(String.format(tb.z(this.tb, "tt_open_landing_page_app_name"), strV, strGc));
            }
        } catch (Throwable unused) {
        }
    }

    private void wp() {
        this.na = gb.js(this.gc);
        this.wj = gb.fv(this.gc) && !com.bytedance.sdk.openadsdk.core.gz.a.dl;
        if (this.na) {
            if (com.bytedance.sdk.openadsdk.core.gz.a.f1113a) {
                if (this.wj) {
                    this.na = false;
                    return;
                }
                return;
            }
            this.wj = false;
        }
    }

    private void i() {
        this.xl = 0;
        if (this.wj) {
            this.xl = com.bytedance.sdk.openadsdk.core.gz.a.z;
        } else if (this.na && !com.bytedance.sdk.openadsdk.core.gz.a.f1113a) {
            this.xl = gb.v(this.gc);
        }
        g(this.xl);
        if (this.xl > 0 && !this.gp.hasMessages(10)) {
            if (this.wj) {
                this.gp.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.na) {
                this.gp.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what == 10 && v()) {
            int i = this.j + 1;
            this.j = i;
            if (this.wj) {
                com.bytedance.sdk.openadsdk.core.gz.a.g = i;
            }
            int iMax = Math.max(0, this.xl - this.j);
            g(iMax);
            if (iMax <= 0 && this.na) {
                com.bytedance.sdk.openadsdk.core.gz.a.f1113a = true;
            }
            this.gp.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    private boolean v() {
        return this.wj || this.na;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf() {
        if (v()) {
            this.gp.removeMessages(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        if (!v() || this.gp.hasMessages(10)) {
            return;
        }
        this.gp.sendEmptyMessageDelayed(10, 1000L);
    }

    private void g(int i) {
        if (i > 0) {
            if (this.wj) {
                oq.z(this.wp, i + "s后可领取奖励");
                return;
            } else {
                if (this.na) {
                    SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                    spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
                    oq.z(this.wp, spannableString);
                    return;
                }
                return;
            }
        }
        if (this.wj) {
            oq.z(this.wp, "领取成功");
        } else if (this.na) {
            oq.z((View) this.js, 8);
            oq.z(this.wp, "恭喜你！福利已领取");
        }
    }

    public static class z implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f921a;
        private Context dl;
        private na g;
        private Map<String, dl> z;

        z(Map<String, dl> map, na naVar, Context context, String str) {
            this.z = map;
            this.g = naVar;
            this.dl = context;
            this.f921a = str;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Map<String, dl> map = this.z;
            if (map != null && map.containsKey(str)) {
                dl dlVar = this.z.get(str);
                if (dlVar != null) {
                    dlVar.z(eo.js(this.g), false);
                    return;
                }
                return;
            }
            dl dlVarZ = gz.z(this.dl, str, this.g, this.f921a);
            dlVarZ.z(uy.z(this.g));
            this.z.put(str, dlVarZ);
            dlVarZ.z(eo.js(this.g), false);
        }
    }
}
