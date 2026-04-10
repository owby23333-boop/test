package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.uf;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.dislike.ui.z;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.m;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.p.a;
import com.bytedance.sdk.openadsdk.core.p.z;
import com.bytedance.sdk.openadsdk.core.playable.g.g;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.l;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.q;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
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
public class TTVideoWebPageActivity extends BaseLandingPageActivity implements dl.InterfaceC0027dl, a {
    protected NativeVideoTsView e;
    private com.bytedance.sdk.openadsdk.wp.a ec;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl eo;
    private g f;
    private SSWebView fo;
    private LinearLayout fv;
    private RoundImageView gk;
    protected dl gz;
    private TextView h;
    private TextView i;
    private FrameLayout iq;
    private Activity jq;
    private Context js;
    private ImageView kb;
    private RelativeLayout l;
    private TextView lq;
    private TextView ls;
    z m;
    private TTViewStub mc;
    private TextView p;
    private TextView pf;
    private RelativeLayout q;
    private boolean sv;
    private int t;
    private mc tb;
    private TTProgressBar ti;
    private Button un;
    private ImageView uy;
    private TextView v;
    private com.bytedance.sdk.openadsdk.core.multipro.g.z vm;
    private TextView wp;
    private TextView x;
    private gc y;
    private long zw;
    private int io = 0;
    private int uf = 0;
    private int sy = 0;
    private int hh = 0;
    private final Map<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> oq = Collections.synchronizedMap(new HashMap());
    private boolean wj = false;
    private boolean na = false;
    private boolean xl = true;
    private boolean j = false;
    private String gp = null;
    private AtomicBoolean bv = new AtomicBoolean(true);
    private JSONArray gb = null;
    private int yx = 0;
    private String qd = "立即下载";
    private com.bytedance.sdk.openadsdk.core.kb.g.z zx = new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.16
        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z() {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.g(tTVideoWebPageActivity.v());
            z.C0193z.z(TTVideoWebPageActivity.this.z, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.g("下载中...");
            if (j > 0) {
                z.C0193z.z(TTVideoWebPageActivity.this.z, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void g(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.g("暂停");
            if (j > 0) {
                z.C0193z.z(TTVideoWebPageActivity.this.z, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void dl(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.g("下载失败");
            if (j > 0) {
                z.C0193z.z(TTVideoWebPageActivity.this.z, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(long j, String str, String str2) {
            TTVideoWebPageActivity.this.g("点击安装");
            z.C0193z.z(TTVideoWebPageActivity.this.z, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(String str, String str2) {
            TTVideoWebPageActivity.this.g("点击打开");
            z.C0193z.z(TTVideoWebPageActivity.this.z, 6, 100);
        }
    };
    private com.bytedance.sdk.openadsdk.core.g.z b = null;
    private final dl.g lw = new dl.g() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.5
        @Override // com.bykv.vk.openvk.component.video.api.a.dl.g
        public void z(boolean z) {
            TTVideoWebPageActivity.this.wj = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                oq.z((View) TTVideoWebPageActivity.this.fo, 8);
                oq.z((View) TTVideoWebPageActivity.this.q, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.iq.getLayoutParams();
                TTVideoWebPageActivity.this.uf = marginLayoutParams.leftMargin;
                TTVideoWebPageActivity.this.io = marginLayoutParams.topMargin;
                TTVideoWebPageActivity.this.sy = marginLayoutParams.width;
                TTVideoWebPageActivity.this.hh = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoWebPageActivity.this.iq.setLayoutParams(marginLayoutParams);
                return;
            }
            oq.z((View) TTVideoWebPageActivity.this.fo, 0);
            oq.z((View) TTVideoWebPageActivity.this.q, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.iq.getLayoutParams();
            marginLayoutParams2.width = TTVideoWebPageActivity.this.sy;
            marginLayoutParams2.height = TTVideoWebPageActivity.this.hh;
            marginLayoutParams2.leftMargin = TTVideoWebPageActivity.this.uf;
            marginLayoutParams2.topMargin = TTVideoWebPageActivity.this.io;
            TTVideoWebPageActivity.this.iq.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean rv = false;
    private final uf.z tc = new uf.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7
        @Override // com.bytedance.sdk.component.utils.uf.z
        public void z(Context context, Intent intent, boolean z, int i) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.t == 0 && i != 0 && TTVideoWebPageActivity.this.fo != null && TTVideoWebPageActivity.this.gp != null) {
                    gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TTVideoWebPageActivity.this.fo != null) {
                                TTVideoWebPageActivity.this.fo.loadUrl(TTVideoWebPageActivity.this.gp);
                            }
                        }
                    });
                }
                if (TTVideoWebPageActivity.this.e != null && TTVideoWebPageActivity.this.e.getNativeVideoController() != null && !TTVideoWebPageActivity.this.uf() && TTVideoWebPageActivity.this.t != i) {
                    ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) TTVideoWebPageActivity.this.e.getNativeVideoController()).z(context, i);
                }
                TTVideoWebPageActivity.this.t = i;
            }
        }
    };

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void q_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void s_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void t_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gc == null) {
            return;
        }
        this.jq = this;
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            zw.z(this.jq);
        } catch (Throwable unused2) {
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.t = v.dl(getApplicationContext());
        setContentView(com.bytedance.sdk.openadsdk.res.gc.z(this.jq, this.gc));
        this.js = this.jq;
        Intent intent = getIntent();
        this.sv = intent.getBooleanExtra("is_outer_click", false);
        this.yx = intent.getIntExtra("get_phone_num_status", 0);
        String stringExtra = intent.getStringExtra("title");
        this.j = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.zw = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_data");
        if (stringExtra2 != null) {
            try {
                this.vm = com.bytedance.sdk.openadsdk.core.multipro.g.z.z(new JSONObject(stringExtra2));
            } catch (Exception unused3) {
            }
            com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = this.vm;
            if (zVar != null) {
                this.zw = zVar.e;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.gc == null) {
                try {
                    this.gc = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(string));
                } catch (Throwable unused4) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.zw = j;
            }
        }
        this.gp = intent.getStringExtra("url");
        this.gp = eo.g(this.gc, this.gp);
        pf();
        z(this.gc);
        q();
        zw();
        z(4);
        SSWebView sSWebView = this.fo;
        if (sSWebView != null) {
            sSWebView.addJavascriptInterface(new com.bytedance.sdk.openadsdk.core.lq.g.z(this.fo, getApplicationContext(), this.gc != null ? this.gc.dl() : this.yx, this.gc), "CCWifiJSBridge");
            com.bytedance.sdk.openadsdk.core.widget.z.g.z(this.js).z(true).g(false).z(this.fo);
            this.y = new gc(this.gc, this.fo).g(true).g(jCurrentTimeMillis).a(this.fo.getCreateDuration());
            wp();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.z);
            jSONObject.put("url", this.gp);
            jSONObject.put("web_title", stringExtra);
            jSONObject.put("is_multi_process", com.bytedance.sdk.openadsdk.core.multipro.g.dl());
            jSONObject.put("event_tag", this.dl);
        } catch (JSONException unused5) {
        }
        this.y.z(jSONObject);
        this.fo.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.z.a(this.js, this.tb, this.z, this.y, this.ec) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.a, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoWebPageActivity.this.ti == null || TTVideoWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTVideoWebPageActivity.this.ti.setVisibility(8);
                } catch (Throwable unused6) {
                }
            }
        });
        SSWebView sSWebView2 = this.fo;
        if (sSWebView2 != null) {
            q.z(sSWebView2, gk.dl, na.a(this.gc));
            this.fo.setMixedContentMode(0);
        }
        this.fo.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.z.dl(this.tb, this.y) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.widget.z.dl, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoWebPageActivity.this.ti == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i != 100 || !TTVideoWebPageActivity.this.ti.isShown()) {
                    TTVideoWebPageActivity.this.ti.setProgress(i);
                } else {
                    TTVideoWebPageActivity.this.ti.setVisibility(8);
                }
            }
        });
        this.fo.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.11
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (TTVideoWebPageActivity.this.oq.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = (com.bytedance.sdk.openadsdk.core.kb.g.dl) TTVideoWebPageActivity.this.oq.get(str);
                    if (dlVar != null) {
                        dlVar.z(eo.js(TTVideoWebPageActivity.this.gc), false);
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.kb.gz.z(TTVideoWebPageActivity.this.jq, str, TTVideoWebPageActivity.this.gc, TTVideoWebPageActivity.this.dl);
                dlVarZ.z(uy.z(TTVideoWebPageActivity.this.gc));
                TTVideoWebPageActivity.this.oq.put(str, dlVarZ);
                dlVarZ.z(eo.js(TTVideoWebPageActivity.this.gc), false);
            }
        });
        TextView textView = this.wp;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = tb.z(this.jq, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        TextView textView2 = this.ls;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.g(tTVideoWebPageActivity.gc);
                }
            });
        }
        TextView textView3 = this.p;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.dl(tTVideoWebPageActivity.gc);
                }
            });
        }
        gc();
        p();
        i();
        com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, getClass().getName());
        this.fo.setVisibility(0);
        this.y.dl(System.currentTimeMillis());
        this.fo.loadUrl(this.gp);
        com.bytedance.sdk.openadsdk.core.i.a.g(this.gc);
        this.f = new g(this.y.z());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g gVar = this.f;
        if (gVar != null) {
            gVar.z(this.jq, this.gc);
        }
    }

    private void wp() {
        na naVar = this.gc;
        if (naVar == null) {
            return;
        }
        this.ec = com.bytedance.sdk.openadsdk.wp.a.z(this.js, naVar, this.gp);
    }

    private void z(na naVar) {
        LinearLayout linearLayout = this.fv;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (naVar == null) {
            return;
        }
        String strGy = naVar.gy();
        if (TextUtils.isEmpty(strGy)) {
            LinearLayout linearLayout2 = this.fv;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(strGy)) {
                return;
            }
            m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(new JSONObject(strGy));
            if (mVarGc == null) {
                LinearLayout linearLayout3 = this.fv;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(mVarGc.i())) {
                LinearLayout linearLayout4 = this.fv;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout5 = this.fv;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            String strGc = mVarGc.gc();
            String strE = mVarGc.e();
            String strV = mVarGc.v();
            if (TextUtils.isEmpty(strV)) {
                strV = uy.g(naVar);
            }
            if (this.v != null) {
                this.v.setText(String.format(tb.z(this.js, "tt_open_app_detail_developer"), strE));
            }
            if (this.pf != null) {
                this.pf.setText(String.format(tb.z(this.js, "tt_open_landing_page_app_name"), strV, strGc));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(na naVar) {
        if (naVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(this.js, naVar.mj(), naVar.gy(), new m.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                TTVideoWebPageActivity.this.iq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(na naVar) {
        if (naVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(this.js, naVar.mj(), new m.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                TTVideoWebPageActivity.this.iq();
            }
        }, naVar.gy());
    }

    private void i() {
        if (this.gc == null || this.gc.lt() != 4) {
            return;
        }
        this.mc.setVisibility(0);
        Button button = (Button) findViewById(2114387729);
        this.un = button;
        if (button != null) {
            g(v());
            com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.eo;
            if (dlVar != null) {
                dlVar.z(this.zx, false);
            }
            this.un.setOnClickListener(this.b);
            this.un.setOnTouchListener(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String v() {
        if (this.gc != null && !TextUtils.isEmpty(this.gc.no())) {
            this.qd = this.gc.no();
        }
        return this.qd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.un) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.17
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoWebPageActivity.this.un == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoWebPageActivity.this.un.setText(str);
            }
        });
    }

    private void pf() {
        this.ti = (TTProgressBar) findViewById(2114387922);
        this.mc = (TTViewStub) findViewById(2114387956);
        this.fo = (SSWebView) findViewById(2114387733);
        this.uy = (ImageView) findViewById(2114387705);
        if (this.gc != null && this.gc.ct() != null) {
            this.gc.ct().z("landing_page");
        }
        ImageView imageView = this.uy;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (oq.z(TTVideoWebPageActivity.this.fo)) {
                        return;
                    }
                    if (TTVideoWebPageActivity.this.f != null) {
                        TTVideoWebPageActivity.this.f.z(0);
                    }
                    TTVideoWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.kb = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.z("detail_skip");
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387627);
        this.i = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.e();
                }
            });
        }
        this.wp = (TextView) findViewById(2114387952);
        this.v = (TextView) findViewById(2114387886);
        this.pf = (TextView) findViewById(2114387745);
        this.ls = (TextView) findViewById(2114387647);
        this.p = (TextView) findViewById(2114387612);
        this.fv = (LinearLayout) findViewById(2114387890);
        this.iq = (FrameLayout) findViewById(2114387708);
        this.q = (RelativeLayout) findViewById(2114387943);
        this.l = (RelativeLayout) findViewById(2114387655);
        this.h = (TextView) findViewById(2114387957);
        this.x = (TextView) findViewById(2114387764);
        this.lq = (TextView) findViewById(2114387686);
        this.gk = (RoundImageView) findViewById(2114387664);
        tb();
        ls();
    }

    private void ls() {
        if (this.gc == null || this.q == null || !this.gc.kb()) {
            return;
        }
        this.q.setVisibility(8);
    }

    public void z(String str) {
        NativeVideoTsView nativeVideoTsView = this.e;
        com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, "embeded_ad", str, fv(), js(), (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) ? null : eo.z(this.gc, this.e.getNativeVideoController().wp(), this.e.getNativeVideoController().p()));
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i();
    }

    private void p() {
        if (na.g(this.gc)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.e = new NativeVideoTsView(this.js, this.gc, true, true);
                } else {
                    this.e = new NativeVideoTsView(this.js, this.gc, true, false);
                }
                if (this.e.getNativeVideoController() != null) {
                    this.e.getNativeVideoController().z(false);
                    if (this.vm != null) {
                        this.e.getNativeVideoController().dl(this.vm.z);
                    }
                }
                this.e.setVideoAdInteractionListener(this);
                if (!this.j) {
                    this.zw = 0L;
                }
                if (this.vm != null && this.e.getNativeVideoController() != null) {
                    this.e.getNativeVideoController().dl(this.vm.e);
                    this.e.getNativeVideoController().a(this.vm.gc);
                }
                if (this.e.getNativeVideoController() != null) {
                    this.e.getNativeVideoController().z(false);
                    this.e.getNativeVideoController().z(this.lw);
                    this.e.setIsQuiet(zw.g().a(eo.fo(this.gc)));
                }
                if (this.e.z(this.zw, this.xl, uf())) {
                    this.iq.setVisibility(0);
                    this.iq.removeAllViews();
                    this.iq.addView(this.e);
                }
                if (uf()) {
                    this.e.a(true);
                }
                this.gz = this.e.getNativeVideoController();
            } catch (Exception e) {
                wp.z(e);
            }
            if (v.dl(this.jq.getApplicationContext()) == 0) {
                try {
                    Activity activity = this.jq;
                    hh.z(activity, tb.z(activity, "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    private long fv() {
        NativeVideoTsView nativeVideoTsView = this.e;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.e.getNativeVideoController().v();
    }

    private int js() {
        NativeVideoTsView nativeVideoTsView = this.e;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.e.getNativeVideoController().pf();
    }

    private void tb() {
        String strHy;
        if (this.gc == null || this.gc.lt() != 4) {
            return;
        }
        oq.z((View) this.l, 0);
        if (!TextUtils.isEmpty(this.gc.li())) {
            strHy = this.gc.li();
        } else if (!TextUtils.isEmpty(this.gc.he())) {
            strHy = this.gc.he();
        } else {
            strHy = !TextUtils.isEmpty(this.gc.hy()) ? this.gc.hy() : "";
        }
        com.bytedance.sdk.openadsdk.core.iq.gk gkVarKp = this.gc.kp();
        if (gkVarKp != null && gkVarKp.z() != null) {
            oq.z((View) this.gk, 0);
            oq.z((View) this.h, 4);
            com.bytedance.sdk.openadsdk.gz.g.z(gkVarKp).to(this.gk);
        } else if (!TextUtils.isEmpty(strHy)) {
            oq.z((View) this.gk, 4);
            oq.z((View) this.h, 0);
            this.h.setText(strHy.substring(0, 1));
        }
        if (this.x != null && !TextUtils.isEmpty(strHy)) {
            this.x.setText(strHy);
        }
        if (!TextUtils.isEmpty(this.gc.no())) {
            this.lq.setText(this.gc.no());
        }
        oq.z((View) this.x, 0);
        if (sy()) {
            oq.z((View) this.lq, 8);
        } else {
            oq.z((View) this.lq, 0);
        }
    }

    private void q() {
        if (this.gc == null || this.gc.lt() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.kb.gz.z((Context) this.jq, this.gc, this.dl, false);
        this.eo = dlVarZ;
        dlVarZ.z(this.jq);
        this.eo.z(uy.z(this.gc));
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.eo;
        if (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
            ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVar).m(true);
        }
        com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.jq, this.gc, "embeded_ad_landingpage", this.f913a);
        this.b = zVar;
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.b.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(true);
        this.lq.setOnClickListener(this.b);
        this.lq.setOnTouchListener(this.b);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.b.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.eo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iq() {
        int iFv = com.bytedance.sdk.openadsdk.core.iq.tb.fv(this.gc);
        if (this.gc != null) {
            if (this.gc.lt() == 4 || iFv != 0) {
                com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.kb.gz.z((Context) this.jq, this.gc, this.dl, false);
                this.eo = dlVarZ;
                dlVarZ.z(this.jq);
                com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.eo;
                if (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc) {
                    ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVar).m(true);
                    ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) this.eo).gz().z(false);
                }
                com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.jq, this.gc, "embeded_ad_landingpage", this.f913a);
                this.b = zVar;
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.b.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(true);
                this.eo.z(this.gc, false);
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.b.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.eo);
            }
        }
    }

    private void zw() {
        if (this.fo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gc);
        mc mcVar = new mc(this.jq);
        this.tb = mcVar;
        mcVar.a(this.sv);
        this.tb.g(this.fo).z(this.gc).dl(arrayList).g(this.z).z(this.dl).a(this.g).g(uy.z(this.gc)).dl(this.f913a).z(this.fo).z(true).gc(eo.ls(this.gc));
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        g gVar = this.f;
        if (gVar != null) {
            gVar.z(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if ((na.dl(this.gc) || com.bytedance.sdk.openadsdk.core.iq.mc.z(this.gc)) && oq.z(this.fo)) {
            return;
        }
        if (this.wj && (nativeVideoTsView = this.e) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.component.video.api.a.z) this.e.getNativeVideoController()).gc(null, null);
            this.wj = false;
            return;
        }
        g gVar = this.f;
        if (gVar == null || !gVar.g(this.jq, this.gc)) {
            z("detail_back");
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("material_meta", this.gc != null ? this.gc.kv().toString() : null);
        bundle.putLong("video_play_position", this.zw);
        bundle.putBoolean("is_complete", uf());
        long jKb = this.zw;
        NativeVideoTsView nativeVideoTsView = this.e;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            jKb = this.e.getNativeVideoController().kb();
        }
        bundle.putLong("video_play_position", jKb);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.xl = false;
        if (this.na && uy() && !kb()) {
            this.na = false;
            this.gz.gz();
        }
        mc mcVar = this.tb;
        if (mcVar != null) {
            mcVar.hh();
            this.tb.z(new SSWebView.g() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.6
                @Override // com.bytedance.sdk.component.widget.SSWebView.g
                public void z(int i) {
                    TTVideoWebPageActivity.this.tb.z(i);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.eo;
        if (dlVar != null) {
            dlVar.z();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> map = this.oq;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().z();
                }
            }
        }
        gc gcVar = this.y;
        if (gcVar != null) {
            gcVar.a();
        }
        io();
    }

    @Override // android.app.Activity
    protected void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.na && !kb()) {
                this.na = true;
                this.gz.m();
            }
        } catch (Throwable th) {
            wp.a("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        mc mcVar = this.tb;
        if (mcVar != null) {
            mcVar.l();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> map = this.oq;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        if (uf() || ((nativeVideoTsView2 = this.e) != null && nativeVideoTsView2.getNativeVideoController() != null && this.e.getNativeVideoController().tb())) {
            com.bytedance.sdk.component.a.g.dl dlVarZ = x.z("sp_multi_native_video_data");
            dlVarZ.put("key_video_is_update_flag", true);
            dlVarZ.put("key_native_video_complete", true);
            dlVarZ.put("key_video_isfromvideodetailpage", true);
        }
        if (uf() || (nativeVideoTsView = this.e) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        z(this.e.getNativeVideoController());
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        gc gcVar = this.y;
        if (gcVar != null) {
            gcVar.gc();
        }
    }

    private void z(dl dlVar) {
        wp.a("mutilproces", "initFeedNaitiveControllerData-isComplete=" + dlVar.tb() + ",position=" + dlVar.kb() + ",totalPlayDuration=" + (dlVar.v() + dlVar.wp()) + ",duration=" + dlVar.v());
        com.bytedance.sdk.component.a.g.dl dlVarZ = x.z("sp_multi_native_video_data");
        dlVarZ.put("key_video_is_update_flag", true);
        dlVarZ.put("key_video_isfromvideodetailpage", true);
        dlVarZ.put("key_native_video_complete", dlVar.tb());
        dlVarZ.put("key_video_current_play_position", dlVar.kb());
        dlVarZ.put("key_video_total_play_duration", dlVar.v() + dlVar.wp());
        dlVarZ.put("key_video_duration", dlVar.v());
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        m();
        gc gcVar = this.y;
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
            com.bytedance.sdk.openadsdk.core.oq.z(this.js, sSWebView);
            com.bytedance.sdk.openadsdk.core.oq.z(this.fo);
        }
        this.fo = null;
        com.bytedance.sdk.openadsdk.wp.a aVar = this.ec;
        if (aVar != null) {
            aVar.a();
        }
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.eo;
        if (dlVar != null) {
            dlVar.g();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> map = this.oq;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.kb.g.dl> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().g();
                }
            }
            this.oq.clear();
        }
        mc mcVar = this.tb;
        if (mcVar != null) {
            mcVar.h();
        }
        NativeVideoTsView nativeVideoTsView = this.e;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.e.getNativeVideoController().uy();
        }
        NativeVideoTsView nativeVideoTsView2 = this.e;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.js();
            this.e = null;
        }
        this.gc = null;
        gc gcVar2 = this.y;
        if (gcVar2 != null) {
            gcVar2.m();
        }
    }

    protected void gc() {
        uf.z(this.tc, this.js);
    }

    protected void m() {
        try {
            uf.z(this.tc);
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

    private void io() {
        if (this.gc == null) {
            return;
        }
        JSONArray jSONArrayDl = dl(this.gp);
        int iFo = eo.fo(this.gc);
        int iGz = eo.gz(this.gc);
        sy<com.bytedance.sdk.openadsdk.core.i.z> syVarZ = zw.z();
        if (jSONArrayDl == null || syVarZ == null || iFo <= 0 || iGz <= 0) {
            return;
        }
        j jVar = new j();
        jVar.gc = jSONArrayDl;
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = this.gc.lw();
        if (gVarLw == null) {
            return;
        }
        syVarZ.z(l.g(gVarLw).dl(6).z(), jVar, iGz, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar) {
                TTVideoWebPageActivity.this.z(0);
                gVar.z(i);
                com.bytedance.sdk.openadsdk.core.iq.g.z(gVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar) {
                if (zVar != null) {
                    try {
                        TTVideoWebPageActivity.this.bv.set(false);
                        TTVideoWebPageActivity.this.tb.z(zVar.dl());
                    } catch (Exception unused) {
                        TTVideoWebPageActivity.this.z(0);
                    }
                }
            }
        });
    }

    private JSONArray dl(String str) {
        int i;
        JSONArray jSONArray = this.gb;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.gb;
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

    @Override // com.bytedance.sdk.openadsdk.core.p.a
    public void z(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.gb = jSONArray;
        io();
    }

    protected void e() {
        if (isFinishing() || this.gc == null) {
            return;
        }
        if (this.m == null) {
            gz();
        }
        this.m.z();
    }

    void gz() {
        this.m = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(this.jq, this.gc.ct(), this.dl, true);
        com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.jq, this.gc, this.m);
        this.m.z(new z.InterfaceC0168z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void z() {
                if (TTVideoWebPageActivity.this.fo()) {
                    TTVideoWebPageActivity.this.gz.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void z(int i, String str, boolean z) {
                if (TTVideoWebPageActivity.this.uy()) {
                    TTVideoWebPageActivity.this.gz.gz();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void g() {
                if (TTVideoWebPageActivity.this.uy()) {
                    TTVideoWebPageActivity.this.gz.gz();
                }
            }
        });
    }

    boolean fo() {
        dl dlVar = this.gz;
        return (dlVar == null || dlVar.p() == null || !this.gz.p().i()) ? false : true;
    }

    protected boolean uy() {
        dl dlVar = this.gz;
        return (dlVar == null || dlVar.p() == null || !this.gz.p().v()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uf() {
        NativeVideoTsView nativeVideoTsView = this.e;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.e.getNativeVideoController().tb();
    }

    protected boolean kb() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = this.m;
        if (zVar != null) {
            return zVar.dl();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void z(long j, long j2) {
        if (sy()) {
            com.bytedance.sdk.openadsdk.core.uy.ls().z(j);
        }
    }

    private boolean sy() {
        if (this.gc == null) {
            return false;
        }
        int iYx = this.gc.yx();
        return this.f913a == 1 && "embeded_ad_landingpage".equals(this.dl) && (iYx == 1 || iYx == 2);
    }
}
