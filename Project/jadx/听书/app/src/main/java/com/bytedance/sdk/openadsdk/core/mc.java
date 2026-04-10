package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.p.z;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class mc implements com.bytedance.sdk.component.adexpress.gc.g, l.z, com.bytedance.sdk.openadsdk.core.p.g {
    private static final Map<String, Boolean> dl;
    private static volatile boolean gb;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<SSWebView> f1261a;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo> bv;
    private com.bytedance.sdk.openadsdk.core.p.dl e;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.e.g> ec;
    private WeakReference<View> fo;
    private SoftReference<com.bytedance.sdk.component.adexpress.g.kb> fv;
    private e.z gp;
    private String gz;
    private HashMap<String, kb> h;
    private WeakReference<com.bytedance.sdk.openadsdk.core.js.m> hh;
    private na i;
    private WeakReference<com.bytedance.sdk.openadsdk.uy.z> io;
    private WeakReference<com.bytedance.sdk.openadsdk.core.js.z> iq;
    private AtomicBoolean jq;
    private int kb;
    private List<na> l;
    private com.bytedance.sdk.openadsdk.m.z lq;
    private final WeakReference<Context> m;
    private com.bytedance.sdk.component.z.p mc;
    private boolean oq;
    private WeakReference<com.bytedance.sdk.openadsdk.core.p.a> q;
    private WeakReference<com.bytedance.sdk.openadsdk.core.js.gc> sv;
    private WeakReference<com.bytedance.sdk.openadsdk.core.js.g> sy;
    private com.bytedance.sdk.openadsdk.core.ugeno.g t;
    private JSONObject tb;
    private com.bytedance.sdk.openadsdk.core.widget.z.z ti;
    private JSONObject uf;
    private String un;
    private String uy;
    private String v;
    private JSONObject vm;
    private boolean wj;
    private String wp;
    private List<JSONObject> y;
    protected Map<String, Object> z;
    private WeakReference<com.bytedance.sdk.openadsdk.core.js.a> zw;
    boolean g = false;
    private boolean pf = false;
    private boolean ls = true;
    private boolean p = true;
    private final com.bytedance.sdk.openadsdk.core.nativeexpress.kb js = new com.bytedance.sdk.openadsdk.core.nativeexpress.kb();
    private boolean gk = false;
    private boolean x = false;
    private boolean eo = false;
    private boolean na = false;
    private boolean xl = false;
    private boolean j = false;
    private com.bytedance.sdk.component.utils.l gc = new com.bytedance.sdk.component.utils.l(Looper.getMainLooper(), this);

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f1262a;
        public String dl;
        public String g;
        public int gc;
        public String z;
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void adAnalysisData(String str) {
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        dl = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        concurrentHashMap.put("private", Boolean.TRUE);
        concurrentHashMap.put("dispatch_message", Boolean.TRUE);
        concurrentHashMap.put("custom_event", Boolean.TRUE);
        concurrentHashMap.put("log_event_v3", Boolean.TRUE);
        gb = false;
    }

    public mc(Context context) {
        this.m = new WeakReference<>(context);
    }

    public Context getContext() {
        return this.m.get();
    }

    public static JSONArray z(List<na> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).kv());
        }
        return jSONArray;
    }

    public mc z(String str) {
        this.un = str;
        return this;
    }

    public mc z(boolean z2) {
        this.na = z2;
        return this;
    }

    private boolean ti() {
        return uy.ls().t();
    }

    public mc z(SSWebView sSWebView) {
        com.bytedance.sdk.component.utils.wp.a("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        if (sSWebView == null) {
            return this;
        }
        com.bytedance.sdk.component.z.p pVarG = com.bytedance.sdk.component.z.p.z(sSWebView).z(new com.bytedance.sdk.openadsdk.fo.z()).z("ToutiaoJSBridge").z(new com.bytedance.sdk.component.z.wp() { // from class: com.bytedance.sdk.openadsdk.core.mc.1
            @Override // com.bytedance.sdk.component.z.wp
            public <T> T z(String str, Type type) {
                return null;
            }

            @Override // com.bytedance.sdk.component.z.wp
            public <T> String z(T t) {
                return null;
            }
        }).z(ti()).g(true).z().g();
        this.mc = pVarG;
        com.bytedance.sdk.openadsdk.core.fv.z.q.z(pVarG, this);
        com.bytedance.sdk.openadsdk.core.fv.z.gc.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.m.z(this.mc, this, this.i);
        com.bytedance.sdk.openadsdk.core.fv.z.v.z(this.mc);
        com.bytedance.sdk.openadsdk.core.fv.z.io.z(this.mc, sSWebView);
        com.bytedance.sdk.openadsdk.core.fv.z.e.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.kb.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.mc.z(this.mc, this);
        com.bytedance.sdk.openadsdk.fo.z.a.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.js.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.p.z(this.mc, this);
        com.bytedance.sdk.openadsdk.fo.z.dl.z(this.mc, this);
        com.bytedance.sdk.openadsdk.fo.z.z.z(this.mc, this);
        com.bytedance.sdk.openadsdk.fo.z.gc.z(this.mc, this);
        com.bytedance.sdk.openadsdk.fo.z.m.z(this.mc, this);
        com.bytedance.sdk.openadsdk.fo.z.g.z(this.mc, this);
        eo();
        com.bytedance.sdk.openadsdk.core.fv.z.dl.z(this.mc, this.f1261a.get(), this.gz);
        com.bytedance.sdk.openadsdk.core.fv.z.sy.z(this.mc, this.f1261a.get(), this.gz);
        com.bytedance.sdk.openadsdk.core.fv.z.g.z(this.mc, this.f1261a.get(), this.gz);
        com.bytedance.sdk.openadsdk.core.fv.z.uf.z(this.mc, this.f1261a.get(), this.gz);
        com.bytedance.sdk.openadsdk.core.fv.z.gk.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.tb.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.lq.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.ls.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.pf.z(this.mc, this.i);
        com.bytedance.sdk.openadsdk.core.fv.z.iq.z(this.mc, this.m.get(), this.i);
        com.bytedance.sdk.openadsdk.core.fv.z.uy.z(this.mc, this.i, this.y);
        com.bytedance.sdk.openadsdk.core.fv.z.zw.z(this.mc, this, this.ec);
        com.bytedance.sdk.openadsdk.core.fv.z.h.z(this.mc, this, this.ec);
        com.bytedance.sdk.openadsdk.core.fv.z.eo.z(this.mc, sSWebView, this);
        com.bytedance.sdk.openadsdk.core.fv.z.fo.z(this.mc, this.i, this);
        com.bytedance.sdk.openadsdk.core.fv.z.i.z(this.mc, this.i, this);
        com.bytedance.sdk.openadsdk.core.fv.z.ti.z(this.mc, this.gp);
        com.bytedance.sdk.openadsdk.core.fv.z.un.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.hh.z(this.mc, this.t);
        com.bytedance.sdk.openadsdk.core.fv.z.l.z(this.mc, this, this.i);
        com.bytedance.sdk.openadsdk.core.fv.z.wp.z(this.mc, this.tb);
        com.bytedance.sdk.openadsdk.core.fv.z.gz.z(this.mc, this.i, this);
        com.bytedance.sdk.openadsdk.core.fv.z.z.z(this.mc, this.m.get());
        com.bytedance.sdk.openadsdk.core.fv.z.x.z(this.mc, this.i);
        com.bytedance.sdk.openadsdk.core.fv.z.a.z(this.mc, this);
        com.bytedance.sdk.openadsdk.core.fv.z.fv.z(this.mc, this, this.m.get(), this.i);
        return this;
    }

    private void eo() {
        na naVar;
        WeakReference<SSWebView> weakReference = this.f1261a;
        if (weakReference == null || weakReference.get() == null || (naVar = this.i) == null) {
            return;
        }
        int iFn = naVar.fn();
        int iVl = this.i.vl();
        int iHs = this.i.hs();
        int iYw = this.i.yw();
        int iS = this.i.s();
        JSONObject jSONObjectKk = this.i.kk();
        JSONObject jSONObjectEb = this.i.eb();
        JSONObject jSONObjectJb = this.i.jb();
        this.f1261a.get().setShakeValue(iFn);
        this.f1261a.get().setDeepShakeValue(iVl);
        this.f1261a.get().setWriggleValue(iHs);
        this.f1261a.get().setTwistConfig(jSONObjectKk);
        this.f1261a.get().setShakeInteractConf(jSONObjectEb);
        this.f1261a.get().setTwistInteractConf(jSONObjectJb);
        this.f1261a.get().setCalculationMethod(iYw);
        this.f1261a.get().setCalculationTwistMethod(iS);
    }

    public JSONObject z() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo> weakReference = this.bv;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.bv.get().getContainerInfo();
    }

    public JSONObject g() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo> weakReference = this.bv;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.bv.get().getCreativeVideoViewInfo();
    }

    public void z(SSWebView.g gVar) {
        WeakReference<SSWebView> weakReference = this.f1261a;
        if (weakReference == null || weakReference.get() == null || gVar == null) {
            return;
        }
        this.f1261a.get().setOnShakeListener(gVar);
    }

    public mc z(com.bytedance.sdk.openadsdk.core.ugeno.e.g gVar) {
        this.ec = new WeakReference<>(gVar);
        return this;
    }

    public mc z(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo foVar) {
        this.bv = new WeakReference<>(foVar);
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo dl() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo> weakReference = this.bv;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean a() {
        WeakReference<SSWebView> weakReference = this.f1261a;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.f1261a.get().H_();
    }

    public static void g(boolean z2) {
        gb = z2;
    }

    public void z(int i) {
        if (gb) {
            com.bytedance.sdk.component.utils.wp.g("TTAndroidObject", "blocked Twist");
            return;
        }
        if (i != 1) {
            if (i == 2) {
                z("twist_callback", (JSONObject) null);
            }
        } else {
            if (this.i != null && a()) {
                com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.f1219a = true;
            }
            z("wobble_callback", (JSONObject) null);
        }
    }

    public void dl(boolean z2) {
        this.oq = z2;
    }

    public void a(boolean z2) {
        this.wj = z2;
    }

    public int gc(boolean z2) {
        if (com.bytedance.sdk.openadsdk.core.iq.lq.z(this.i) != 0 && z2) {
            return 2;
        }
        if (this.oq) {
            return 1;
        }
        return this.wj ? com.bytedance.sdk.openadsdk.core.iq.lq.z(this.i) == 2 ? 2 : 1 : com.bytedance.sdk.openadsdk.core.iq.lq.z(this.i) == 0 ? 1 : 2;
    }

    public void gc() {
        com.bytedance.sdk.component.z.p pVar = this.mc;
        if (pVar == null) {
            return;
        }
        pVar.z();
        this.mc = null;
    }

    public com.bytedance.sdk.component.z.p m() {
        return this.mc;
    }

    private com.bytedance.sdk.component.i.dl oq() {
        WeakReference<SSWebView> weakReference = this.f1261a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public mc g(SSWebView sSWebView) {
        this.f1261a = new WeakReference<>(sSWebView);
        return this;
    }

    public mc z(com.bytedance.sdk.openadsdk.m.z zVar) {
        this.lq = zVar;
        return this;
    }

    public mc m(boolean z2) {
        this.x = z2;
        return this;
    }

    public mc g(String str) {
        this.gz = str;
        return this;
    }

    public mc z(View view) {
        this.fo = new WeakReference<>(view);
        return this;
    }

    public mc g(List<JSONObject> list) {
        this.y = list;
        return this;
    }

    public mc g(int i) {
        this.pf = true;
        return this;
    }

    public boolean e() {
        return this.xl;
    }

    public void e(boolean z2) {
        this.xl = z2;
    }

    public void gz(boolean z2) {
        this.j = z2;
    }

    private JSONObject wj() {
        View view;
        SSWebView sSWebView;
        try {
            view = this.fo.get();
            sSWebView = this.f1261a.get();
        } catch (Throwable unused) {
        }
        if (view == null || sSWebView == null) {
            com.bytedance.sdk.component.utils.wp.a("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        }
        int[] iArrG = com.bytedance.sdk.openadsdk.core.un.oq.g(view);
        int[] iArrG2 = com.bytedance.sdk.openadsdk.core.un.oq.g(sSWebView);
        if (iArrG != null && iArrG2 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", com.bytedance.sdk.openadsdk.core.un.oq.a(zw.getContext(), iArrG[0] - iArrG2[0]));
            jSONObject.put("y", com.bytedance.sdk.openadsdk.core.un.oq.a(zw.getContext(), iArrG[1] - iArrG2[1]));
            jSONObject.put("w", com.bytedance.sdk.openadsdk.core.un.oq.a(zw.getContext(), view.getWidth()));
            jSONObject.put("h", com.bytedance.sdk.openadsdk.core.un.oq.a(zw.getContext(), view.getHeight()));
            jSONObject.put("isExist", true);
            return jSONObject;
        }
        com.bytedance.sdk.component.utils.wp.a("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
        return null;
    }

    public mc z(com.bytedance.sdk.openadsdk.core.js.g gVar) {
        this.sy = new WeakReference<>(gVar);
        return this;
    }

    public mc z(com.bytedance.sdk.openadsdk.core.js.m mVar) {
        this.hh = new WeakReference<>(mVar);
        return this;
    }

    public na gz() {
        return this.i;
    }

    public mc z(na naVar) {
        this.i = naVar;
        return this;
    }

    public mc dl(String str) {
        this.v = str;
        return this;
    }

    public boolean fo() {
        na naVar = this.i;
        return naVar != null && naVar.vm();
    }

    public mc a(String str) {
        this.uy = str;
        return this;
    }

    public mc dl(int i) {
        this.kb = i;
        return this;
    }

    public mc gc(String str) {
        this.wp = str;
        return this;
    }

    public mc z(com.bytedance.sdk.component.adexpress.g.kb kbVar) {
        this.fv = new SoftReference<>(kbVar);
        return this;
    }

    public mc z(com.bytedance.sdk.openadsdk.core.nativeexpress.uy uyVar) {
        this.js.z(uyVar);
        return this;
    }

    public mc z(com.bytedance.sdk.openadsdk.core.p.a aVar) {
        this.q = new WeakReference<>(aVar);
        return this;
    }

    public mc z(JSONObject jSONObject) {
        this.uf = jSONObject;
        return this;
    }

    public mc z(Map<String, Object> map) {
        this.z = map;
        return this;
    }

    public mc z(com.bytedance.sdk.openadsdk.core.js.z zVar) {
        this.iq = new WeakReference<>(zVar);
        return this;
    }

    public mc z(com.bytedance.sdk.openadsdk.core.js.a aVar) {
        this.zw = new WeakReference<>(aVar);
        return this;
    }

    public mc z(com.bytedance.sdk.openadsdk.uy.z zVar) {
        this.io = new WeakReference<>(zVar);
        return this;
    }

    public mc dl(List<na> list) {
        this.l = list;
        return this;
    }

    public boolean uy() {
        return this.g;
    }

    public void fo(boolean z2) {
        this.g = z2;
    }

    public void z(e.z zVar) {
        this.gp = zVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.g gVar) {
        this.t = gVar;
    }

    public void g(JSONObject jSONObject) {
        this.vm = jSONObject;
    }

    public JSONObject kb() {
        return this.vm;
    }

    private static List<String> na() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    public static void dl(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = na().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.core.gz.z.z());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.core.gz.z.gc());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.core.gz.z.g());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.core.gz.z.dl());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.core.gz.z.a());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.core.gz.z.m());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.core.gz.z.e());
        jSONObject.put("themeStatus", uy.ls().bv());
    }

    public JSONObject wp() throws Exception {
        return com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(this.i, this.v);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0271 A[PHI: r3
  0x0271: PHI (r3v22 org.json.JSONObject) = (r3v17 org.json.JSONObject), (r3v23 org.json.JSONObject) binds: [B:166:0x026f, B:155:0x0241] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject z(com.bytedance.sdk.openadsdk.core.mc.z r18, int r19) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 942
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mc.z(com.bytedance.sdk.openadsdk.core.mc$z, int):org.json.JSONObject");
    }

    public void a(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.m.z zVar;
        if (jSONObject == null || (zVar = this.lq) == null) {
            return;
        }
        zVar.a(jSONObject);
    }

    private void g(String str, boolean z2) {
        if (this.lq == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z2) {
            this.lq.m(str);
        } else {
            this.lq.e(str);
        }
    }

    private void xl() {
        WeakReference<com.bytedance.sdk.openadsdk.core.js.m> weakReference = this.hh;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.hh.get().z();
    }

    private void j() {
        WeakReference<com.bytedance.sdk.openadsdk.core.js.m> weakReference = this.hh;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.hh.get().g();
    }

    private void pf(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.js.g> weakReference = this.sy;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.sy.get().z(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = wp();
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            dl(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public String getTemplateInfo() {
        g("getTemplateInfo", true);
        try {
            i();
            g("getTemplateInfo", false);
            return this.tb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public mc gc(JSONObject jSONObject) {
        this.tb = jSONObject;
        return this;
    }

    public JSONObject i() {
        JSONObject jSONObject = this.tb;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        if (this.i != null) {
            jSONObject.put("setting", gp());
            jSONObject.put("extension", this.i.gm());
        }
        this.tb = jSONObject;
        return jSONObject;
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            kb(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mc.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mc.this.m(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            wp(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mc.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mc.this.e(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mc.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mc.this.uy(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.core.q.v.z().dl(this.i, "stats_reward_full_call_skip_video");
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mc.8
            @Override // java.lang.Runnable
            public void run() {
                mc.this.v();
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        ls(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void initRenderFinish() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mc.9
            @Override // java.lang.Runnable
            public void run() {
                if (mc.this.ti != null) {
                    com.bytedance.sdk.openadsdk.core.widget.z.z unused = mc.this.ti;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.js.z(jSONObject.optInt("time"), jSONObject.optString("flag"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state_type", 2);
            jSONObject2.put("jsb_name", "requestPauseVideo");
            com.bytedance.sdk.openadsdk.core.q.v.z().z(this.i, jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.gc.g
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.tb.toString();
        }
        try {
            JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(this.tb, new JSONObject(str));
            if (jSONObjectZ == null) {
                return this.tb.toString();
            }
            return jSONObjectZ.toString();
        } catch (Exception unused) {
            return this.tb.toString();
        }
    }

    public void v() {
        com.bytedance.sdk.openadsdk.core.q.v.z().dl(this.i, "stats_reward_full_deal_skip_video");
        this.js.e();
    }

    public void pf() {
        this.js.gz();
    }

    public void m(JSONObject jSONObject) {
        if (this.js.wp() == null || jSONObject == null) {
            return;
        }
        try {
            this.js.wp().z(jSONObject.optBoolean("mute", false));
        } catch (Exception unused) {
        }
    }

    public void e(JSONObject jSONObject) {
        if (this.js.wp() == null || jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("stateType", -1);
            this.js.wp().z(iOptInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jsb_name", "changeVideoState");
            jSONObject2.put("state_type", iOptInt);
            com.bytedance.sdk.openadsdk.core.q.v.z().z(this.i, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void z(float f) {
        if (this.js.wp() == null) {
            return;
        }
        try {
            this.js.wp().z(f);
        } catch (Exception unused) {
        }
    }

    public void ls() {
        this.js.a();
    }

    public void p() {
        this.js.gc();
    }

    public void a(int i) {
        this.js.g(i);
    }

    public void fv() {
        WeakReference<com.bytedance.sdk.openadsdk.uy.z> weakReference = this.io;
        if (weakReference != null && weakReference.get() != null) {
            this.io.get().z();
        } else {
            this.js.kb();
        }
    }

    public void z(float f, float f2, float f3, float f4, int i) {
        this.js.z(f, f2, f3, f4, i);
    }

    private boolean ls(JSONObject jSONObject) {
        if (this.js.wp() != null && jSONObject != null) {
            double dZ = this.js.wp().z();
            int iG = this.js.wp().g();
            try {
                jSONObject.put("currentTime", dZ / 1000.0d);
                jSONObject.put("state", iG);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private JSONObject gp() {
        return z(this.i, this.jq);
    }

    public static JSONObject z(na naVar, AtomicBoolean atomicBoolean) {
        boolean z2;
        JSONObject jSONObject = new JSONObject();
        if (zw.g() == null) {
            return jSONObject;
        }
        try {
            int iFo = com.bytedance.sdk.openadsdk.core.un.eo.fo(naVar);
            int iGz = com.bytedance.sdk.openadsdk.core.un.eo.gz(naVar);
            boolean z3 = true;
            int iGc = com.bytedance.sdk.openadsdk.core.iq.x.g(true, naVar, true) ? 0 : zw.g().gc(iFo);
            int iM = (com.bytedance.sdk.openadsdk.core.iq.x.g(false, naVar, true) || (com.bytedance.sdk.openadsdk.core.iq.hh.z(naVar) && com.bytedance.sdk.openadsdk.core.iq.hh.g(naVar) > 0)) ? 0 : zw.g().m(iFo);
            boolean zGc = zw.g().gc(String.valueOf(iFo));
            if (atomicBoolean != null) {
                z2 = atomicBoolean.get();
            } else if (iGz == 7 || iGz == 8) {
                z2 = zw.g().z(naVar, iFo);
            } else {
                z2 = zw.g().a(iFo);
            }
            jSONObject.put("ad_slot_type", iGz);
            jSONObject.put("voice_control", z2);
            jSONObject.put("rv_skip_time", iGc);
            jSONObject.put("fv_skip_show", zGc);
            jSONObject.put("iv_skip_time", iM);
            if (naVar == null || !naVar.sz()) {
                z3 = false;
            }
            jSONObject.put("show_dislike", z3);
            jSONObject.put("video_adaptation", naVar != null ? naVar.qd() : 0);
            jSONObject.put("h5_cache_resources_enable", com.bytedance.sdk.openadsdk.core.iq.l.z);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int gz(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.i.dl(true);
            return 2;
        }
        if (jSONObject.optInt("downloadDialogStatus") != 1) {
            return 0;
        }
        if (this.i.dt().z() == 2) {
            this.i.dl(true);
        }
        return 1;
    }

    public void fo(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double dOptDouble;
        String str;
        String str2;
        double d7;
        double d8;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("subConvertLinkTag");
            int iOptInt2 = jSONObject.optInt("dpaPosition", -1);
            String strOptString3 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            double d9 = -1.0d;
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("down_x", -1.0d);
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble("down_y", -1.0d);
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble("up_x", -1.0d);
                double dOptDouble5 = jSONObjectOptJSONObject.optDouble("up_y", -1.0d);
                double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_time", -1.0d);
                double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", -1.0d);
                double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", -1.0d);
                double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", -1.0d);
                double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", -1.0d);
                dOptDouble = jSONObjectOptJSONObject.optDouble("button_height", -1.0d);
                str = strOptString;
                d9 = dOptDouble2;
                d = dOptDouble3;
                d7 = dOptDouble4;
                d2 = dOptDouble6;
                d3 = dOptDouble7;
                d4 = dOptDouble8;
                d5 = dOptDouble9;
                d6 = dOptDouble10;
                str2 = strOptString2;
                d8 = dOptDouble5;
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                dOptDouble = -1.0d;
                str = strOptString;
                str2 = strOptString2;
                d7 = -1.0d;
                d8 = -1.0d;
            }
            com.bytedance.sdk.openadsdk.core.iq.zw zwVarZ = new zw.z().a((int) d9).dl((int) d).g((int) d7).z((int) d8).g((long) d2).z((long) d3).z((int) d4).g((int) d5).dl((int) d6).a((int) dOptDouble).z(strOptString3).z(true).z(jSONObject2).z((SparseArray<a.z>) null).gc(str2).gc(iOptInt2).z();
            SoftReference<com.bytedance.sdk.component.adexpress.g.kb> softReference = this.fv;
            if (softReference != null && softReference.get() != null) {
                this.fv.get().z(null, iOptInt, zwVarZ, gz(jSONObject));
            }
            z(str, iOptInt, zwVarZ);
        } catch (Exception unused) {
            SoftReference<com.bytedance.sdk.component.adexpress.g.kb> softReference2 = this.fv;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.fv.get().z(null, -1, null, 0);
        }
    }

    public void uy(JSONObject jSONObject) {
        mc mcVar;
        double d;
        double d2;
        double d3;
        double d4;
        double dOptDouble;
        String str;
        int i;
        String str2;
        String str3;
        int i2;
        JSONObject jSONObject2;
        double d5;
        double d6;
        double d7;
        double d8;
        com.bytedance.sdk.openadsdk.core.iq.zw zwVarZ;
        int i3;
        SoftReference<com.bytedance.sdk.component.adexpress.g.kb> softReference;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            String strOptString3 = jSONObject.optString("clickAreaId");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            String strOptString4 = jSONObject.optString("subConvertLinkTag");
            int iOptInt2 = jSONObject.optInt("dpaPosition", -1);
            JSONObject jSONObject3 = new JSONObject();
            com.bytedance.sdk.openadsdk.core.iq.ls.z(jSONObject.optString("clickScene"));
            jSONObject3.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            jSONObject3.put("live_saas_param_interaction_type", jSONObject.optInt("live_saas_param_interaction_type", -1));
            jSONObject3.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            double d9 = -1.0d;
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("down_x", -1.0d);
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble("down_y", -1.0d);
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble("up_x", -1.0d);
                double dOptDouble5 = jSONObjectOptJSONObject.optDouble("up_y", -1.0d);
                double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_time", -1.0d);
                double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", -1.0d);
                double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", -1.0d);
                double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", -1.0d);
                double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", -1.0d);
                dOptDouble = jSONObjectOptJSONObject.optDouble("button_height", -1.0d);
                d9 = dOptDouble2;
                d = dOptDouble3;
                d2 = dOptDouble4;
                d3 = dOptDouble9;
                d4 = dOptDouble10;
                str = strOptString;
                str2 = strOptString2;
                str3 = strOptString4;
                d7 = dOptDouble5;
                d6 = dOptDouble6;
                i = iOptInt;
                i2 = iOptInt2;
                jSONObject2 = jSONObject3;
                d5 = dOptDouble7;
                d8 = dOptDouble8;
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                dOptDouble = -1.0d;
                str = strOptString;
                i = iOptInt;
                str2 = strOptString2;
                str3 = strOptString4;
                i2 = iOptInt2;
                jSONObject2 = jSONObject3;
                d5 = -1.0d;
                d6 = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
            }
            try {
                zwVarZ = new zw.z().a((float) d9).dl((float) d).g((float) d2).z((float) d7).g((long) d6).z((long) d5).z((int) d8).g((int) d3).dl((int) d4).a((int) dOptDouble).z(str2).g(strOptString3).z(true).z((SparseArray<a.z>) null).z(jSONObject2).gc(str3).gc(i2).z();
                mcVar = this;
                i3 = i;
            } catch (Exception unused) {
                mcVar = this;
            }
        } catch (Exception unused2) {
            mcVar = this;
        }
        try {
            if (!mcVar.z(str, i3, zwVarZ) && (softReference = mcVar.fv) != null && softReference.get() != null) {
                mcVar.fv.get().z(null, i3, zwVarZ);
            } else {
                t();
            }
        } catch (Exception unused3) {
            SoftReference<com.bytedance.sdk.component.adexpress.g.kb> softReference2 = mcVar.fv;
            if (softReference2 != null && softReference2.get() != null) {
                mcVar.fv.get().z(null, -1, null);
            } else {
                t();
            }
        }
    }

    private void t() {
        ja jaVarFx;
        Context context;
        na naVar = this.i;
        if (naVar != null && (jaVarFx = naVar.fx()) != null && jaVarFx.g() == 1 && jaVarFx.m() == 1) {
            ec();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", new JSONObject());
            } catch (Throwable unused) {
            }
            WeakReference<Context> weakReference = this.m;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            this.e.z(context, jSONObject, this.uy, this.kb, this.pf, true);
            z(jSONObject, false);
        }
    }

    public void kb(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.m.z zVar = this.lq;
        if (zVar != null) {
            zVar.dl(jSONObject);
        }
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("renderDidFinish") { // from class: com.bytedance.sdk.openadsdk.core.mc.10
            @Override // java.lang.Runnable
            public void run() {
                int i;
                double dOptDouble;
                double dOptDouble2;
                boolean z2;
                double d;
                double d2;
                double d3;
                double d4;
                double d5;
                if (mc.this.fv == null || mc.this.fv.get() == null || jSONObject == null || mc.this.m == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.g.v vVar = new com.bytedance.sdk.component.adexpress.g.v();
                vVar.z(1);
                try {
                    boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
                    if (jSONObjectOptJSONObject != null) {
                        dOptDouble = jSONObjectOptJSONObject.optDouble(MediaFormat.KEY_WIDTH);
                        dOptDouble2 = jSONObjectOptJSONObject.optDouble(MediaFormat.KEY_HEIGHT);
                    } else {
                        dOptDouble = 0.0d;
                        dOptDouble2 = 0.0d;
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
                    if (jSONObjectOptJSONObject2 != null) {
                        float f = ((Context) mc.this.m.get()).getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                        z2 = zOptBoolean;
                        double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                        d2 = dOptDouble2;
                        double dOptDouble5 = jSONObjectOptJSONObject2.optDouble(MediaFormat.KEY_WIDTH);
                        double dOptDouble6 = jSONObjectOptJSONObject2.optDouble(MediaFormat.KEY_HEIGHT);
                        if (mc.this.p(jSONObjectOptJSONObject2)) {
                            d = dOptDouble;
                            double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft");
                            d4 = dOptDouble6;
                            double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight");
                            d5 = dOptDouble5;
                            double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft");
                            d3 = dOptDouble4;
                            double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight");
                            if (zw.g().mz()) {
                                vVar.z(com.bytedance.sdk.openadsdk.core.un.oq.g(f, com.bytedance.sdk.openadsdk.core.un.oq.z(f2, (float) dOptDouble7)));
                                vVar.g(com.bytedance.sdk.openadsdk.core.un.oq.g(f, com.bytedance.sdk.openadsdk.core.un.oq.z(f2, (float) dOptDouble8)));
                                vVar.dl(com.bytedance.sdk.openadsdk.core.un.oq.g(f, com.bytedance.sdk.openadsdk.core.un.oq.z(f2, (float) dOptDouble9)));
                                vVar.a(com.bytedance.sdk.openadsdk.core.un.oq.g(f, com.bytedance.sdk.openadsdk.core.un.oq.z(f2, (float) dOptDouble10)));
                            } else {
                                vVar.z((float) dOptDouble7);
                                vVar.g((float) dOptDouble8);
                                vVar.dl((float) dOptDouble9);
                                vVar.a((float) dOptDouble10);
                            }
                        } else {
                            d3 = dOptDouble4;
                            d4 = dOptDouble6;
                            d = dOptDouble;
                            d5 = dOptDouble5;
                        }
                        if (zw.g().mz()) {
                            vVar.dl(com.bytedance.sdk.openadsdk.core.un.oq.g(f, com.bytedance.sdk.openadsdk.core.un.oq.z(f2, (float) dOptDouble3)));
                            vVar.a(com.bytedance.sdk.openadsdk.core.un.oq.g(f, com.bytedance.sdk.openadsdk.core.un.oq.z(f2, (float) d3)));
                            vVar.gc(com.bytedance.sdk.openadsdk.core.un.oq.g(f, com.bytedance.sdk.openadsdk.core.un.oq.z(f2, (float) d5)));
                            vVar.m(com.bytedance.sdk.openadsdk.core.un.oq.g(f, com.bytedance.sdk.openadsdk.core.un.oq.z(f2, (float) d4)));
                        } else {
                            vVar.dl(dOptDouble3);
                            vVar.a(d3);
                            vVar.gc(d5);
                            vVar.m(d4);
                        }
                    } else {
                        z2 = zOptBoolean;
                        d = dOptDouble;
                        d2 = dOptDouble2;
                    }
                    try {
                        String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, fo.z(101));
                        int iOptInt = jSONObject.optInt("code", 101);
                        vVar.z(z2);
                        vVar.z(d);
                        vVar.g(d2);
                        vVar.z(strOptString);
                        vVar.g(iOptInt);
                        ((com.bytedance.sdk.component.adexpress.g.kb) mc.this.fv.get()).z(vVar);
                    } catch (Exception unused) {
                        i = 101;
                        vVar.g(i);
                        vVar.z(fo.z(i));
                        ((com.bytedance.sdk.component.adexpress.g.kb) mc.this.fv.get()).z(vVar);
                    }
                } catch (Exception unused2) {
                    i = 101;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    public void wp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.core.un.q.z(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    private void fv(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.p.a> weakReference;
        com.bytedance.sdk.openadsdk.core.p.a aVar;
        if (jSONObject == null || (weakReference = this.q) == null || (aVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                aVar.z(true, jSONArrayOptJSONArray);
            } else {
                aVar.z(false, null);
            }
        } catch (Exception unused) {
            aVar.z(false, null);
        }
    }

    public boolean i(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", z(this.l));
        } catch (Exception unused) {
        }
        return true;
    }

    private void z(final z zVar, final JSONObject jSONObject) {
        if (zVar == null) {
            return;
        }
        try {
            z(zVar.f1262a, new com.bytedance.sdk.openadsdk.core.js.dl() { // from class: com.bytedance.sdk.openadsdk.core.mc.11
                @Override // com.bytedance.sdk.openadsdk.core.js.dl
                public void z(boolean z2, List<na> list, boolean z3) {
                    if (!z2) {
                        mc.this.dl(zVar.g, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", mc.z(list));
                        mc.this.dl(zVar.g, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public void js() {
        z((JSONObject) null, new com.bytedance.sdk.openadsdk.core.js.dl() { // from class: com.bytedance.sdk.openadsdk.core.mc.12
            @Override // com.bytedance.sdk.openadsdk.core.js.dl
            public void z(boolean z2, List<na> list, boolean z3) {
                mc.this.l = list;
                mc.this.vm();
                mc.this.tb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm() {
        Context context;
        List<na> list = this.l;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.h = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.f1261a;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.m;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (na naVar : this.l) {
            this.h.put(naVar.mj(), new kb(context, naVar, sSWebView, this.un));
        }
    }

    private boolean z(String str, int i, com.bytedance.sdk.openadsdk.core.iq.zw zwVar) {
        HashMap<String, kb> map;
        kb kbVar;
        if (TextUtils.isEmpty(str) || (map = this.h) == null || (kbVar = map.get(str)) == null) {
            return false;
        }
        kbVar.z(i, zwVar);
        return true;
    }

    public void z(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.js.dl dlVar) {
        com.bytedance.sdk.openadsdk.core.io.g.z(this.i, jSONObject, dlVar, (com.bytedance.sdk.openadsdk.ls.dl.dl.g) null);
    }

    public void tb() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", z(this.l));
            z("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    private boolean y() {
        na naVar = this.i;
        if (naVar == null || naVar.rw() == null || com.bytedance.sdk.openadsdk.core.un.iq.g(this.i) || this.gk || this.i.rw().optInt("parent_type") != 2) {
            return false;
        }
        int iGz = com.bytedance.sdk.openadsdk.core.un.eo.gz(this.i);
        if (iGz != 8 && iGz != 7) {
            return false;
        }
        this.gk = true;
        return true;
    }

    public void uy(boolean z2) {
        this.eo = z2;
    }

    public boolean q() {
        return this.eo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            js(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void js(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            tb(jSONObject);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mc.2
                @Override // java.lang.Runnable
                public void run() {
                    mc.this.tb(jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(JSONObject jSONObject) {
        com.bytedance.sdk.component.i.dl dlVarOq = oq();
        if (dlVarOq != null) {
            com.bytedance.sdk.component.utils.kb.z(dlVarOq, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")");
        }
    }

    private void a(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            js(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void m(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                z zVar = new z();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        zVar.z = jSONObjectOptJSONObject.optString("__msg_type", null);
                        zVar.g = jSONObjectOptJSONObject.optString("__callback_id", null);
                        zVar.dl = jSONObjectOptJSONObject.optString("func");
                        zVar.f1262a = jSONObjectOptJSONObject.optJSONObject("params");
                        zVar.gc = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(zVar.z) && !TextUtils.isEmpty(zVar.dl)) {
                    Message messageObtainMessage = this.gc.obtainMessage(11);
                    messageObtainMessage.obj = zVar;
                    this.gc.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.component.utils.wp.z()) {
                com.bytedance.sdk.component.utils.wp.g("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
            } else {
                com.bytedance.sdk.component.utils.wp.g("TTAndroidObject", "failed to parse jsbridge msg queue");
            }
        }
    }

    public boolean z(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (dl.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void g(final Uri uri) {
        long j;
        JSONObject jSONObjectQ;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.component.utils.wp.g("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        mc.this.gz(uri.toString());
                    }
                });
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            if (e(queryParameter3)) {
                if (com.bytedance.sdk.openadsdk.core.iq.mc.g(this.i) && TextUtils.equals(queryParameter3, "track")) {
                    return;
                }
                long j2 = 0;
                try {
                    j = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception unused) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                long j3 = j2;
                JSONObject jSONObject = new JSONObject();
                String queryParameter4 = uri.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused3) {
                    }
                }
                gc(queryParameter3, jSONObject);
                if ("click".equals(queryParameter3)) {
                    jSONObjectQ = q(jSONObject);
                    WeakReference<com.bytedance.sdk.openadsdk.core.js.a> weakReference = this.zw;
                    if (weakReference != null && weakReference.get() != null) {
                        this.zw.get().g();
                    }
                } else {
                    jSONObjectQ = jSONObject;
                }
                com.bytedance.sdk.openadsdk.core.i.a.z(queryParameter, z(queryParameter2, queryParameter3), queryParameter3, j, j3, jSONObjectQ);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.g("TTAndroidObject", "handleUri exception: ", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void z(na naVar, int i) {
        WeakReference<Context> weakReference = this.m;
        if (weakReference == null || naVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.m.get();
        com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(context, naVar, this.un, this.kb);
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).g(true);
        com.bytedance.sdk.component.kb.gc.z.z().z(naVar.hashCode() + naVar.aq()).put("live_saas_interaction_type", Integer.valueOf(i));
        final String strMj = naVar.mj();
        com.bytedance.sdk.openadsdk.core.kb.g.a aVarG = com.bytedance.sdk.openadsdk.core.kb.gz.g(context, naVar, this.un, false);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z((com.bytedance.sdk.openadsdk.core.kb.g.dl) aVarG);
        zVar.z(null, new com.bytedance.sdk.openadsdk.core.iq.uy());
        if (aVarG != null) {
            aVarG.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.mc.4
                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z() {
                    z.C0193z.z(strMj, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void g(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void dl(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(long j, String str, String str2) {
                    z.C0193z.z(strMj, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(String str, String str2) {
                    z.C0193z.z(strMj, 6, 100);
                }
            });
        }
        if (bv()) {
            WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo> weakReference2 = this.bv;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.bv.get().a();
            return;
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.gz.g) {
            ((com.bytedance.sdk.openadsdk.core.gz.g) context).z(1);
        }
    }

    private boolean e(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || iq();
    }

    boolean iq() {
        na naVar = this.i;
        return naVar != null && com.bytedance.sdk.openadsdk.core.iq.tb.kb(naVar) == 1;
    }

    private JSONObject q(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw;
        if (this.z != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                if (gk.e()) {
                    try {
                        na naVar = this.i;
                        if (naVar != null && (gVarLw = naVar.lw()) != null) {
                            String strI = gVarLw.i();
                            if (!TextUtils.isEmpty(strI)) {
                                jSONObject2.putOpt("media_extra", strI);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.z.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.dl(e.toString());
            }
        }
        return jSONObject;
    }

    private void gc(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        JSONObject jSONObject2;
        String str2 = "click";
        String strG = "";
        try {
            if ("show".equals(str)) {
                jSONArray = jSONObject.optJSONArray("show_url");
                str2 = "show";
            } else if ("click".equals(str)) {
                jSONArray = jSONObject.getJSONArray("click_url");
            } else {
                str2 = null;
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                String strDl = tb.dl();
                if (TextUtils.isEmpty(strDl)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                String strOptString5 = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
                try {
                    jSONObject2 = new JSONObject(strOptString5);
                    strOptString = jSONObject2.optString(MediationConstant.EXTRA_ADID);
                } catch (Throwable unused) {
                    strOptString = "";
                    strOptString2 = strOptString;
                }
                try {
                    strOptString2 = jSONObject2.optString("creative_id");
                    try {
                        strOptString3 = jSONObject2.optString("req_id");
                        try {
                            strOptString4 = jSONObject2.optString("customer_id");
                            try {
                                strG = com.bytedance.sdk.openadsdk.core.un.eo.g(jSONObject2.optInt("ad_slot_type"));
                            } catch (Throwable unused2) {
                            }
                        } catch (Throwable unused3) {
                            strOptString4 = "";
                        }
                    } catch (Throwable unused4) {
                        strOptString3 = "";
                        strOptString4 = strOptString3;
                    }
                } catch (Throwable unused5) {
                    strOptString2 = "";
                    strOptString3 = strOptString2;
                    strOptString4 = strOptString3;
                    HashMap map = new HashMap();
                    map.put("aid", strOptString);
                    map.put(CmcdConfiguration.KEY_CONTENT_ID, strOptString2);
                    map.put("req_id", strOptString3);
                    map.put("customer_id", strOptString4);
                    com.bytedance.sdk.openadsdk.core.q.g.z(strDl, arrayList, true, map, com.bytedance.sdk.openadsdk.core.i.a.z(strOptString5, strOptString, strOptString3, strG, str2));
                }
                HashMap map2 = new HashMap();
                map2.put("aid", strOptString);
                map2.put(CmcdConfiguration.KEY_CONTENT_ID, strOptString2);
                map2.put("req_id", strOptString3);
                map2.put("customer_id", strOptString4);
                com.bytedance.sdk.openadsdk.core.q.g.z(strDl, arrayList, true, map2, com.bytedance.sdk.openadsdk.core.i.a.z(strOptString5, strOptString, strOptString3, strG, str2));
            }
        } catch (Throwable unused6) {
        }
    }

    public void zw() {
        na naVar = this.i;
        if (naVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.g(naVar, this.m.get(), sy());
    }

    public void io() {
        na naVar = this.i;
        if (naVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.dl(naVar, this.m.get(), sy());
    }

    public JSONObject uf() {
        JSONObject jSONObject = new JSONObject();
        na naVar = this.i;
        if (naVar == null) {
            return jSONObject;
        }
        String strGy = naVar.gy();
        if (TextUtils.isEmpty(strGy)) {
            return jSONObject;
        }
        try {
            return new JSONObject(strGy);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return jSONObject;
        }
    }

    public String sy() {
        return com.bytedance.sdk.openadsdk.core.un.eo.z(this.kb);
    }

    private String z(String str, String str2) {
        return ((("landing_perf_stats".equals(str2) || "landing_perf_exception".equals(str2)) && "landingpage".equals(str)) || this.fv != null || bv()) ? str : com.bytedance.sdk.openadsdk.core.un.eo.z(this.kb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(String str) {
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    com.bytedance.sdk.component.i.dl dlVarOq = oq();
                    if (dlVarOq != null) {
                        com.bytedance.sdk.component.utils.kb.z(dlVarOq, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (!str.startsWith("bytedance://private/setresult/") || (iIndexOf = str.indexOf(38, 30)) <= 0) {
                    return;
                }
                String strSubstring = str.substring(30, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (!strSubstring.equals("SCENE_FETCHQUEUE") || strSubstring2.length() <= 0) {
                    return;
                }
                m(strSubstring2);
            } catch (Exception unused) {
            }
        }
    }

    public void hh() {
        com.bytedance.sdk.openadsdk.core.p.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.z();
        }
        if (y()) {
            js();
        }
    }

    public void l() {
        com.bytedance.sdk.openadsdk.core.p.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.g();
        }
    }

    public void h() {
        gc();
        com.bytedance.sdk.openadsdk.core.p.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.dl();
        }
        WeakReference<SSWebView> weakReference = this.f1261a;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<View> weakReference2 = this.fo;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<Context> weakReference3 = this.m;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        this.ti = null;
        this.t = null;
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof z)) {
            try {
                z((z) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    public void v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.gz = jSONObject.optString(CmcdConfiguration.KEY_CONTENT_ID);
        this.uy = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
    }

    private void ec() {
        if (this.e == null) {
            this.e = com.bytedance.sdk.openadsdk.core.p.z.z(this, this.i, this.na);
        }
    }

    public void z(String str, boolean z2) {
        com.bytedance.sdk.openadsdk.core.p.dl dlVar = this.e;
        if (dlVar != null) {
            dlVar.z(str, z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.g
    public void z(String str, JSONObject jSONObject) {
        ti();
        a(str, jSONObject);
    }

    public void g(String str, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.z.p pVar = this.mc;
            if (pVar != null) {
                pVar.z(str, jSONObject);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.dl("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public void gk() {
        WeakReference<com.bytedance.sdk.openadsdk.core.js.a> weakReference = this.zw;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.zw.get().z();
    }

    public void z(JSONObject jSONObject, boolean z2) {
        WeakReference<Context> weakReference;
        if (this.e == null || (weakReference = this.m) == null || weakReference.get() == null) {
            return;
        }
        this.e.z(this.p && this.ls);
        this.e.g(z2);
        this.e.z(this.m.get(), jSONObject, this.un, this.uy);
    }

    public int x() {
        if (this.js.wp() == null) {
            return 0;
        }
        return this.js.wp().dl();
    }

    public void z(com.bytedance.sdk.openadsdk.core.js.gc gcVar) {
        this.sv = new WeakReference<>(gcVar);
    }

    public void kb(boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", z2 ? 0 : 1);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.a("TTAndroidObject", e.getMessage());
        }
        a("visibleStateChange", jSONObject);
    }

    public void lq() {
        WeakReference<com.bytedance.sdk.openadsdk.core.js.gc> weakReference = this.sv;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sv.get().z();
    }

    private boolean bv() {
        return this.bv != null;
    }

    public void z(int i, int i2) {
        int iDl = com.bytedance.sdk.openadsdk.core.un.oq.dl(zw.getContext(), i);
        int iDl2 = com.bytedance.sdk.openadsdk.core.un.oq.dl(zw.getContext(), i2);
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo> weakReference = this.bv;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.bv.get().z(Integer.MIN_VALUE, Integer.MIN_VALUE, iDl, iDl2);
    }

    public void z(int i, int i2, int i3, int i4) {
        int iDl;
        int iDl2;
        int iDl3;
        int iDl4 = Integer.MIN_VALUE;
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            iDl = Integer.MIN_VALUE;
            iDl2 = Integer.MIN_VALUE;
        } else {
            iDl = com.bytedance.sdk.openadsdk.core.un.oq.dl(zw.getContext(), i);
            iDl2 = com.bytedance.sdk.openadsdk.core.un.oq.dl(zw.getContext(), i2);
        }
        if (i3 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) {
            iDl3 = Integer.MIN_VALUE;
        } else {
            iDl4 = com.bytedance.sdk.openadsdk.core.un.oq.dl(zw.getContext(), i3);
            iDl3 = com.bytedance.sdk.openadsdk.core.un.oq.dl(zw.getContext(), i4);
        }
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo> weakReference = this.bv;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.bv.get().z(iDl, iDl2, iDl4, iDl3);
    }

    public void wp(boolean z2) {
        this.jq = new AtomicBoolean(z2);
    }

    public void mc() {
        if (this.js.wp() != null) {
            this.js.wp().fo();
        }
    }

    public void un() {
        this.js.m();
    }
}
