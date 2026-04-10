package com.bytedance.sdk.openadsdk.core.i;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ls.z;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.xl;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1141a;
    private String gc;
    private String gk;
    private long hh;
    private JSONObject iq;
    private Runnable l;
    private WeakReference<g> lq;
    private final na m;
    private com.bytedance.sdk.component.i.dl tb;
    private com.bytedance.sdk.openadsdk.m.z zw;
    private int z = 0;
    private volatile boolean g = false;
    private int dl = -1;
    private String e = "landingpage";
    private long gz = 0;
    private long fo = 0;
    private long uy = 0;
    private long kb = 0;
    private long wp = 0;
    private boolean i = false;
    private long v = 0;
    private long pf = 0;
    private long ls = 0;
    private long p = -1;
    private boolean fv = false;
    private AtomicInteger js = new AtomicInteger(0);
    private boolean q = false;
    private AtomicBoolean io = new AtomicBoolean(false);
    private boolean uf = false;
    private boolean sy = true;
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final Map<String, xl.z> x = new ConcurrentHashMap();

    public interface g {
        void z(String str);
    }

    public void z(g gVar) {
        this.lq = new WeakReference<>(gVar);
    }

    public gc(na naVar, com.bytedance.sdk.component.i.dl dlVar) {
        this.m = naVar;
        this.tb = dlVar;
        if (dlVar != null) {
            dlVar.addJavascriptInterface(new z(this.js, this.lq), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.hh = System.currentTimeMillis();
        this.gk = String.valueOf(SystemClock.elapsedRealtime());
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e = str;
    }

    public String z() {
        return this.e;
    }

    public void z(long j) {
        this.uy = j;
    }

    public boolean g() {
        return this.uf;
    }

    public void z(boolean z2) {
        this.uf = z2;
    }

    public com.bytedance.sdk.openadsdk.m.z dl() {
        return this.zw;
    }

    public void z(com.bytedance.sdk.openadsdk.m.z zVar) {
        this.zw = zVar;
    }

    public void z(JSONObject jSONObject) {
        this.iq = jSONObject;
    }

    public gc g(boolean z2) {
        this.q = z2;
        return this;
    }

    public gc g(long j) {
        this.pf = j;
        return this;
    }

    public gc dl(long j) {
        this.ls = j;
        return this;
    }

    public gc a(long j) {
        this.p = j;
        return this;
    }

    public void z(WebView webView, int i) {
        if (this.kb == 0 && i > 0) {
            this.z = 1;
            this.kb = System.currentTimeMillis();
        } else {
            if (i != 100 || this.i) {
                return;
            }
            this.i = true;
            this.wp = System.currentTimeMillis();
            if (!"landingpage".equals(this.e) || this.z == 3) {
                return;
            }
            g("landingpage_load_hundred");
        }
    }

    public void z(WebView webView, String str, Bitmap bitmap) {
        com.bytedance.sdk.openadsdk.m.z zVar = this.zw;
        if (zVar != null) {
            zVar.m();
        }
        if (this.g) {
            return;
        }
        this.v = System.currentTimeMillis();
        this.g = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        z("load_start", jSONObject);
    }

    public void z(WebView webView) {
        com.bytedance.sdk.openadsdk.m.z zVar = this.zw;
        if (zVar != null) {
            zVar.e();
        }
        if (this.wp <= 0) {
            this.wp = System.currentTimeMillis();
        }
        if (webView != null && !this.fv && this.q) {
            this.fv = true;
            kb.z(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.io.get()) {
            return;
        }
        if (this.z != 3) {
            this.z = 2;
        }
        this.io.set(true);
        this.gz = System.currentTimeMillis();
        if (this.z == 2) {
            g("load_finish");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", this.dl);
            jSONObject.put("error_msg", this.f1141a);
            jSONObject.put("error_url", this.gc);
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        z("load_fail", jSONObject);
    }

    public void z(int i, String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.m.z zVar = this.zw;
        if (zVar != null) {
            zVar.gz();
        }
        if (!(str3 != null && str3.startsWith("image")) && this.z != 2) {
            this.z = 3;
        }
        this.dl = i;
        this.f1141a = str;
        this.gc = str2;
    }

    public void a() {
        this.gz = System.currentTimeMillis();
        if (this.v == 0) {
            this.v = System.currentTimeMillis();
        }
        if ("landingpage".equals(this.e) || "landingpage_endcard".equals(this.e)) {
            if (this.h.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.core.v.dl.gc().z("landingStart", this.m, this.gk);
            } else {
                com.bytedance.sdk.openadsdk.core.v.dl.gc().z("landingContinue", this.m, this.gk);
            }
        }
    }

    public void gc() {
        if (this.sy) {
            this.sy = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.START, this.hh);
                jSONObject.put(TtmlNode.END, System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, this.m);
            } catch (JSONException e) {
                wp.z(e);
            }
            a.z(this.m, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.gc.1
                @Override // com.bytedance.sdk.openadsdk.m.z.z
                public void z(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
        if (this.z == 2) {
            if (this.uy > 0 || !g()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.fo = jCurrentTimeMillis;
                long jMax = jCurrentTimeMillis - Math.max(this.gz, this.uy);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("load_status", this.z);
                    jSONObject2.put("max_scroll_percent", this.js.get());
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                z("stay_page", jSONObject2, Math.min(jMax, TTAdConstant.AD_MAX_EVENT_TIME));
                com.bytedance.sdk.openadsdk.core.v.dl.gc().z("landingPause", this.m, this.gk);
            }
        }
    }

    public void m() {
        com.bytedance.sdk.component.i.dl dlVar = this.tb;
        if (dlVar != null) {
            dlVar.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        this.tb = null;
        if (!this.io.get() && this.g) {
            a.dl(this.m, this.e, System.currentTimeMillis() - this.v);
        }
        if ("landingpage".equals(this.e) || "landingpage_endcard".equals(this.e)) {
            com.bytedance.sdk.openadsdk.core.v.dl.gc().z("landingFinish", this.m, this.gk);
        }
        this.l = null;
        if (this.x.isEmpty()) {
            return;
        }
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.gc.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("web_cache_hit_report");
                if (gc.this.m != null) {
                    gVarZ.m(gc.this.m.aq());
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (xl.z zVar : gc.this.x.values()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", zVar.dl());
                        jSONObject2.put("hit", zVar.a());
                        jSONObject2.put("miss", zVar.gc());
                        jSONArray.put(jSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                try {
                    jSONObject.put("hit_records", jSONArray);
                } catch (JSONException unused2) {
                }
                gVarZ.g(jSONObject.toString());
                return gVarZ;
            }
        }, "web_cache_hit_report");
    }

    private void z(String str, JSONObject jSONObject) {
        z(str, jSONObject, -1L);
    }

    private void z(String str, JSONObject jSONObject, long j) {
        if (!this.q || this.m == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
            }
        }
        a.dl(this.m, this.e, str, jSONObject2);
    }

    public void g(String str) {
        if (this.q) {
            if ("load_finish".equals(str) && "landingpage".equals(this.e)) {
                this.l = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.gc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        gc.this.fo();
                    }
                };
                com.bytedance.sdk.openadsdk.core.ls.z.z(new z.RunnableC0187z(this.l));
            }
            long j = this.wp - this.kb;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.dl);
                jSONObject.put("error_msg", this.f1141a);
                jSONObject.put("error_url", this.gc);
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                long j2 = this.pf;
                if (j2 > 0) {
                    jSONObject.put("exp_duration", this.wp - j2);
                }
                long j3 = this.ls;
                if (j3 > 0) {
                    jSONObject.put("web_duration", this.wp - j3);
                }
                long j4 = this.p;
                if (j4 >= 0) {
                    jSONObject.put("webview_duration", j4);
                }
            } catch (Exception unused) {
            }
            z(str, jSONObject, Math.min(j, TTAdConstant.AD_MAX_EVENT_TIME));
        }
    }

    private static class z {
        private final WeakReference<g> g;
        private final AtomicInteger z;

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }

        z(AtomicInteger atomicInteger, WeakReference<g> weakReference) {
            this.z = atomicInteger;
            this.g = weakReference;
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue > 100) {
                    i = 100;
                } else if (iIntValue >= 0) {
                    i = iIntValue;
                }
            } catch (Throwable unused) {
            }
            AtomicInteger atomicInteger = this.z;
            if (atomicInteger != null) {
                atomicInteger.set(i);
            }
            WeakReference<g> weakReference = this.g;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.g.get().z(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo() {
        try {
            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ls.z.z) && this.m != null) {
                StringBuilder sb = new StringBuilder(com.bytedance.sdk.openadsdk.core.ls.z.z);
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(CmcdConfiguration.KEY_CONTENT_ID, this.m.mj());
                jSONObject.putOpt(MediationConstant.EXTRA_ADID, this.m.mk());
                jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, this.m.vk());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("web_init_time", this.ls);
                jSONObject2.put("click_time", this.pf);
                jSONObject2.put("web_url", this.m.fp());
                jSONObject.put("client_info", jSONObject2);
                com.bytedance.sdk.openadsdk.core.ls.z.z(sb, "\"/** adInfo **/\"", jSONObject.toString());
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                String strConcat = "javascript:".concat(String.valueOf(string));
                com.bytedance.sdk.component.i.dl dlVar = this.tb;
                if (dlVar != null) {
                    kb.z(dlVar, strConcat);
                }
            }
        } catch (Throwable th) {
            wp.dl(th.getMessage());
        }
    }

    public void e() {
        com.bytedance.sdk.openadsdk.core.ls.z.z zVarF;
        com.bytedance.sdk.component.i.dl dlVar;
        if (!(this.z == 2 && this.i) || (zVarF = zw.g().f()) == null || (dlVar = this.tb) == null) {
            return;
        }
        zVarF.z(dlVar.getWebView(), this.m);
    }

    public Map<String, xl.z> gz() {
        return this.x;
    }
}
