package com.bytedance.sdk.openadsdk.core.i;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.nh;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements com.bytedance.sdk.openadsdk.m.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f1138a;
    private Boolean dl;
    private JSONArray e;
    private boolean fo;
    private na g;
    private Boolean gc;
    private JSONArray gz;
    private volatile int i;
    private AtomicLong kb;
    private JSONObject m;
    private int uy;
    private volatile boolean v;
    private JSONObject wp;
    private String z;

    public fo(String str, na naVar, JSONObject jSONObject) {
        this.z = "embeded_ad";
        this.dl = Boolean.FALSE;
        this.f1138a = Boolean.FALSE;
        this.gc = Boolean.FALSE;
        this.fo = false;
        this.kb = new AtomicLong();
        this.i = 0;
        this.v = false;
        this.z = str;
        this.g = naVar;
        this.m = jSONObject;
        this.e = new JSONArray();
        this.gz = new JSONArray();
    }

    protected fo() {
        this.z = "embeded_ad";
        this.dl = Boolean.FALSE;
        this.f1138a = Boolean.FALSE;
        this.gc = Boolean.FALSE;
        this.fo = false;
        this.kb = new AtomicLong();
        this.i = 0;
        this.v = false;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.dl
    public void z() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.1
                @Override // java.lang.Runnable
                public void run() {
                    fo.this.kb.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    fo foVar = fo.this;
                    foVar.z(jSONObject, "ts", Long.valueOf(foVar.kb.get()));
                    fo foVar2 = fo.this;
                    foVar2.z(jSONObject, "render_sequence", Integer.valueOf(vm.g(foVar2.g)));
                    fo foVar3 = fo.this;
                    foVar3.z(jSONObject, "render_timeout", Integer.valueOf(foVar3.uy));
                    fo.this.z(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.gc.gc.z().gc()));
                    fo.this.z(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.gc.gc.z().dl()));
                    nh nhVarE = vm.e(fo.this.g);
                    if (nhVarE != null) {
                        fo.this.z(jSONObject, "rule_id", nhVarE.gz());
                    } else {
                        fo.this.z(jSONObject, "rule_id", "0");
                    }
                    fo foVar4 = fo.this;
                    foVar4.z(foVar4.m, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.dl
    public void g() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.12
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "render_success", jSONObject);
                    if (fo.this.z.equals("splash_ad") || fo.this.z.equals("cache_splash_ad")) {
                        return;
                    }
                    if (fo.this.m.optInt("webview_source", -1) == 2) {
                        wp.z(fo.this.z, "no count ENDCARD_SOURCE");
                    } else {
                        com.bytedance.sdk.openadsdk.core.sy.z.z().z("ugen_render", "h5_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                    }
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.dl
    public void z(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.26
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo.this.z(jSONObject, "code", Integer.valueOf(i));
                    String str2 = str;
                    if (str2 != null) {
                        fo.this.z(jSONObject, MediationConstant.KEY_REASON, str2);
                    }
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.g
    public void dl() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.27
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.z
    public void z(final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.28
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.z
    public void g(final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.29
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.z
    public void dl(final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.30
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, str, jSONObject);
                    if (fo.this.z.equals("splash_ad") || fo.this.z.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.sy.z.z().z("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.z
    public void g(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.31
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo.this.z(jSONObject, "code", Integer.valueOf(i));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, str, jSONObject);
                    if (fo.this.z.equals("splash_ad") || fo.this.z.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.sy.z.z().z("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1");
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.z
    public void a(final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.2
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.z
    public void gc(final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.3
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, str, jSONObject);
                    if (fo.this.z.equals("splash_ad") || fo.this.z.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.sy.z.z().z("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.z
    public void dl(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.4
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo.this.z(jSONObject, "code", Integer.valueOf(i));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, str, jSONObject);
                    if (fo.this.z.equals("splash_ad") || fo.this.z.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.sy.z.z().z("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1");
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.z
    public void z(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.5
                @Override // java.lang.Runnable
                public void run() {
                    fo.this.z(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "render_exception", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.a
    public void z(final int i) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.6
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo.this.z(jSONObject, "isWebViewCache", Integer.valueOf(i));
                    if (fo.this.g != null) {
                        if (vm.gz(fo.this.g)) {
                            fo.this.z(jSONObject, "engine_version", "v3");
                        } else {
                            fo.this.z(jSONObject, "engine_version", "v1");
                        }
                    }
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    public void a() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.7
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.g
    public void gc() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.8
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "native_render_end", jSONObject);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    fo.this.z(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                    fo foVar2 = fo.this;
                    foVar2.z(foVar2.m, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.a
    public void m() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.9
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.a
    public void e() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.10
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.a
    public void gz() {
        g((JSONObject) null);
    }

    public void g(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    fo.this.z(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    public void fo() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.13
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    public void uy() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.14
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    public void kb() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.15
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo.this.z(jSONObject, "type", "native_enterBackground");
                    fo foVar = fo.this;
                    foVar.z(foVar.e, jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    public void wp() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.16
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo.this.z(jSONObject, "type", "native_enterForeground");
                    fo foVar = fo.this;
                    foVar.z(foVar.e, jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.a
    public void z(final String str, final long j, final long j2, final int i) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "start_ts", Long.valueOf(j));
                    fo.this.z(jSONObject, "end_ts", Long.valueOf(j2));
                    fo.this.z(jSONObject, "intercept_type", Integer.valueOf(i));
                    fo.this.z(jSONObject, "type", "intercept_html");
                    fo.this.z(jSONObject, "url", str);
                    fo.this.z(jSONObject, "duration", Long.valueOf(j2 - j));
                    fo foVar = fo.this;
                    foVar.z(foVar.gz, jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.a
    public void g(final String str, final long j, final long j2, final int i) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "start_ts", Long.valueOf(j));
                    fo.this.z(jSONObject, "end_ts", Long.valueOf(j2));
                    fo.this.z(jSONObject, "intercept_type", Integer.valueOf(i));
                    fo.this.z(jSONObject, "type", "intercept_js");
                    fo.this.z(jSONObject, "url", str);
                    fo.this.z(jSONObject, "duration", Long.valueOf(j2 - j));
                    fo foVar = fo.this;
                    foVar.z(foVar.gz, jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.a
    public void m(final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo.this.z(jSONObject, "jsb", str);
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.a
    public void e(final String str) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.20
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo.this.z(jSONObject, "jsb", str);
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.g
    public void i() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.dl
    public void v() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.22
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    fo.this.z(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a.dl
    public void dl(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.23
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    fo.this.z(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis));
                    fo foVar = fo.this;
                    foVar.z(foVar.m, "render_did_finish", jSONObject2);
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.z
    public void a(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.24
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (fo.this.m == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        fo foVar = fo.this;
                        foVar.z(foVar.m, next, jSONObject.opt(next));
                    }
                    fo.this.f1138a = Boolean.TRUE;
                    fo.this.ls();
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.z
    public void pf() {
        this.dl = Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.openadsdk.m.z
    public void z(boolean z) {
        this.gc = Boolean.valueOf(z);
    }

    @Override // com.bytedance.sdk.openadsdk.m.z
    public void ls() {
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.i.fo.25
                @Override // java.lang.Runnable
                public void run() {
                    if (fo.this.p() && !fo.this.fo) {
                        if (fo.this.e != null && fo.this.e.length() != 0) {
                            try {
                                fo.this.m.put("native_switchBackgroundAndForeground", fo.this.e);
                            } catch (Exception unused) {
                            }
                        }
                        if (fo.this.gz != null && fo.this.gz.length() != 0) {
                            try {
                                fo.this.m.put("intercept_source", fo.this.gz);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap map = new HashMap();
                        map.put("webview_time_track", fo.this.m);
                        uy.ls().t();
                        a.e(fo.this.g, fo.this.z, "webview_time_track", map);
                        fo.this.fo = true;
                    }
                }
            });
        } catch (Throwable th) {
            wp.g("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.z
    public void z(boolean z, int i) {
        try {
            if (this.wp == null) {
                this.wp = new JSONObject();
            }
            this.wp.put("error_code", i);
            this.wp.put("webview_time_cost", System.currentTimeMillis() - this.kb.get());
            this.wp.put("webview_result", z ? 0 : 1);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.z
    public void z(int i, int i2, String str) {
        try {
            this.i = i;
            if (this.wp == null) {
                this.wp = new JSONObject();
            }
            this.wp.put("render_type", i);
            this.wp.put("error_code", i2);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.z
    public void g(boolean z) {
        try {
            if (!this.v && this.g != null) {
                this.v = true;
                if (vm.g(this.g) == 0 && this.i != 0) {
                    if (this.wp == null) {
                        this.wp = new JSONObject();
                    }
                    this.wp.put("render_sequence", vm.g(this.g));
                    this.wp.put("render_control", vm.z(this.g));
                    this.wp.put("fetch_tpl_time_out", zw.g().z(this.z, vm.g(this.g)));
                    this.wp.put("req_id", this.g.aq());
                    this.wp.put(MediationConstant.EXTRA_ADID, this.g.mj());
                    this.wp.put("ad_slot_type", eo.gz(this.g));
                    if (z) {
                        this.wp.put("webview_time_cost", System.currentTimeMillis() - this.kb.get());
                        this.wp.put("webview_result", 2);
                    }
                    v.z().z(this.wp);
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        if (this.gc.booleanValue()) {
            return true;
        }
        return this.f1138a.booleanValue() && this.dl.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception e) {
                wp.g("WebviewTimeTrack", e.getMessage());
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    public void z(JSONObject jSONObject, String str, Object obj) {
        z(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e) {
            wp.g("WebviewTimeTrack", e.getMessage());
        }
    }

    public void g(int i) {
        this.uy = i;
    }
}
