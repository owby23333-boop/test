package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.ls.dl.dl.a;
import com.bytedance.sdk.openadsdk.ls.dl.dl.dl;
import com.kuaishou.weapon.p0.bi;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    public static final com.bytedance.sdk.openadsdk.ls.dl.dl.a z = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f1388a;
    private volatile String dl;
    private volatile String e;
    private String eo;
    private volatile int fo;
    private volatile boolean fv;
    private volatile String g;
    private volatile String gc;
    private int gk;
    private String gp;
    private volatile com.bytedance.sdk.openadsdk.core.hh.z gz;
    private int h;
    private volatile Function<SparseArray<Object>, Object> hh;
    private Bitmap i;
    private HashMap<String, Object> io;
    private volatile int iq;
    private com.bytedance.sdk.openadsdk.core.playable.a j;
    private volatile boolean js;
    private final Set<Integer> kb;
    private int l;
    private gc lq;
    private String ls;
    private volatile String m;
    private boolean mc;
    private volatile boolean na;
    private String oq;
    private String p;
    private volatile com.bytedance.sdk.openadsdk.ls.dl.dl.a pf;
    private volatile boolean q;
    private boolean sy;
    private Function<SparseArray<Object>, Object> tb;
    private String ti;
    private boolean uf;
    private volatile String un;
    private volatile boolean uy;
    private volatile com.bytedance.sdk.openadsdk.core.un.z v;
    private a wj;
    private volatile boolean wp;
    private long x;
    private Map<String, Object> xl;
    private volatile JSONObject zw;

    public static class dl {
        public static final com.bytedance.sdk.component.a.g.dl z = com.bytedance.sdk.openadsdk.core.un.x.z("sp_global_info");
    }

    public boolean z() {
        return this.v != null && this.v.g();
    }

    public boolean z(boolean z2) {
        return this.v != null && this.v.z(z2);
    }

    public void z(String str) {
        this.un = str;
    }

    public String g() {
        if (TextUtils.isEmpty(this.un)) {
            this.un = com.bytedance.sdk.openadsdk.core.kb.fo.z();
        }
        return this.un;
    }

    public boolean dl() {
        if (!this.sy) {
            this.sy = true;
            try {
                ShortcutManager shortcutManager = (ShortcutManager) zw.getContext().getSystemService(ShortcutManager.class);
                if (shortcutManager != null) {
                    this.uf = shortcutManager.isRequestPinShortcutSupported();
                }
            } catch (Throwable unused) {
            }
        }
        return this.uf;
    }

    public boolean z(Activity activity) {
        return this.v != null && this.v.z(activity);
    }

    public com.bytedance.sdk.openadsdk.core.un.z a() {
        if (this.v == null) {
            dl(zw.getContext());
        }
        return this.v;
    }

    public boolean gc() {
        return com.bytedance.sdk.openadsdk.pf.dl.z().gc();
    }

    public String m() {
        return com.bytedance.sdk.openadsdk.pf.dl.z().g();
    }

    public boolean e() {
        return this.na;
    }

    public boolean gz() {
        return com.bytedance.sdk.openadsdk.pf.dl.z().m();
    }

    public boolean fo() {
        return uy() && com.bytedance.sdk.openadsdk.core.a.z.dl();
    }

    public boolean uy() {
        return !kb() && gz();
    }

    public boolean kb() {
        return com.bytedance.sdk.openadsdk.pf.dl.z().e();
    }

    public boolean wp() {
        return com.bytedance.sdk.openadsdk.pf.dl.z().gz();
    }

    public void i() {
        com.bytedance.sdk.openadsdk.pf.dl.z().a();
    }

    private uy() {
        this.gz = new com.bytedance.sdk.openadsdk.core.hh.z(2);
        this.fo = 0;
        this.uy = true;
        this.kb = Collections.synchronizedSet(new HashSet());
        this.wp = false;
        this.i = null;
        this.fv = false;
        this.js = true;
        this.q = true;
        this.iq = 0;
        this.zw = new JSONObject();
        this.io = new HashMap<>();
        this.uf = false;
        this.sy = false;
        this.hh = null;
        this.l = -1;
        this.h = -1;
        this.gk = -1;
        this.x = -1L;
        this.gp = null;
    }

    public void v() {
        pf();
        Context context = zw.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.api.m.z.z(context);
        }
        this.kb.add(4);
        dl(context);
    }

    public void pf() {
        this.na = com.bytedance.sdk.openadsdk.core.a.z.g();
    }

    private void dl(Context context) {
        this.v = new com.bytedance.sdk.openadsdk.core.un.z();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.v);
        } else {
            if (context == null || context.getApplicationContext() == null) {
                return;
            }
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.v);
        }
    }

    private static class g {
        private static uy z = new uy();
    }

    public static uy ls() {
        return g.z;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar) {
        this.pf = aVar;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.dl.a p() {
        return new l(js());
    }

    public String fv() {
        return this.gp;
    }

    public void g(String str) {
        this.gp = str;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.dl.a js() {
        if (this.pf == null || this.pf.i()) {
            this.pf = t() ? z : r();
        }
        return this.pf;
    }

    public boolean tb() {
        return dl.z.get("sdk_activate_init", true);
    }

    public void g(boolean z2) {
        dl.z.put("sdk_activate_init", z2);
    }

    public String q() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        return com.bytedance.sdk.openadsdk.core.dl.a.z().a();
    }

    public void dl(String str) {
        ls(str);
        this.g = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, str);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            jSONObject.put("sdk_version", gk.f1105a);
            this.zw.put("com.byted.pangle", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public String iq() {
        if (!TextUtils.isEmpty(this.dl)) {
            return this.dl;
        }
        return com.bytedance.sdk.openadsdk.core.dl.a.z().gc();
    }

    public void a(String str) {
        p(str);
        this.dl = str;
    }

    public boolean zw() {
        if (com.bytedance.sdk.openadsdk.core.dl.dl.z().g()) {
            return com.bytedance.sdk.openadsdk.core.dl.a.z().z(this.f1388a);
        }
        return this.f1388a;
    }

    public void dl(boolean z2) {
        this.f1388a = z2;
    }

    public String io() {
        if (!TextUtils.isEmpty(this.gc)) {
            return this.gc;
        }
        return com.bytedance.sdk.openadsdk.core.dl.a.z().m("");
    }

    public void gc(String str) {
        fv(str);
        this.gc = str;
    }

    public void z(int i) {
        this.gz = new com.bytedance.sdk.openadsdk.core.hh.z(i, true);
    }

    public com.bytedance.sdk.openadsdk.core.hh.z uf() {
        return this.gz;
    }

    public String sy() {
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        return com.bytedance.sdk.openadsdk.core.dl.a.z().gz("");
    }

    public Map<String, Object> hh() {
        if (!this.io.isEmpty()) {
            return this.io;
        }
        String strUy = com.bytedance.sdk.openadsdk.core.dl.a.z().uy("");
        this.io.putAll(TextUtils.isEmpty(strUy) ? pf(strUy) : new HashMap<>());
        return this.io;
    }

    public void m(final String str) {
        js(str);
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("setUserData") { // from class: com.bytedance.sdk.openadsdk.core.uy.1
            @Override // java.lang.Runnable
            public void run() {
                uy.this.v(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        HashMap map = new HashMap();
        JSONArray jSONArray2 = new JSONArray();
        boolean z2 = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                if (!jSONObjectOptJSONObject.isNull("__name__")) {
                    String strOptString = jSONObjectOptJSONObject.optString("__name__");
                    String strOptString2 = jSONObjectOptJSONObject.optString("value");
                    if (!TextUtils.isEmpty(strOptString)) {
                        map.put(strOptString, strOptString2);
                    }
                } else if ("csj_rit_list".equals(jSONObjectOptJSONObject.optString("name"))) {
                    uy(jSONObjectOptJSONObject.optString("value"));
                    jSONArray.remove(i);
                    z2 = true;
                } else {
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
        }
        if (z2) {
            this.m = jSONArray.toString();
        } else {
            this.m = str;
        }
        if ((jSONArray2.length() == 0 && map.isEmpty()) || jSONArray2.length() != 0) {
            this.m = jSONArray2.toString();
        }
        if (map.isEmpty()) {
            return;
        }
        this.io.putAll(map);
    }

    public void g(int i) {
        this.fo = i;
    }

    public int l() {
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            return dl.z.get("title_bar_theme", 0);
        }
        return this.fo;
    }

    public void a(boolean z2) {
        this.uy = z2;
    }

    public boolean h() {
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            return dl.z.get("allow_show_notify", true);
        }
        return this.uy;
    }

    public void gc(boolean z2) {
        dl(z2);
        com.bytedance.sdk.openadsdk.core.dl.a.z().g(z2);
    }

    public void e(String str) {
        m(str);
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            com.bytedance.sdk.openadsdk.core.dl.a.z().e(str);
            com.bytedance.sdk.openadsdk.core.dl.a.z().fo(z(this.io));
        }
    }

    public void gz(String str) {
        gc(str);
        com.bytedance.sdk.openadsdk.core.dl.a.z().gc(str);
    }

    public void z(boolean z2, SparseArray<Object> sparseArray) {
        com.bytedance.sdk.component.utils.wp.a("bstsdk", "bst(true) stat-quit, run new pl");
        this.fv = z2;
        com.bytedance.sdk.openadsdk.core.a.z.z(true);
        com.bytedance.sdk.component.utils.wp.z("bstsdk", "setQuitWork, resultValues: " + sparseArray);
        Object obj = sparseArray == null ? null : sparseArray.get(23);
        if (obj instanceof Map) {
            this.xl = (Map) obj;
        }
        com.bytedance.sdk.openadsdk.core.a.dl.z();
    }

    public boolean fo(String str) {
        Map<String, Object> map = this.xl;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.xl.containsKey(str);
    }

    public boolean gk() {
        return this.fv;
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.dl.a.z().g(this.iq);
        com.bytedance.sdk.openadsdk.core.dl.a.z().z(this.g);
        com.bytedance.sdk.openadsdk.core.dl.a.z().g(this.dl);
        com.bytedance.sdk.openadsdk.core.dl.a.z().g(this.f1388a);
        com.bytedance.sdk.openadsdk.core.dl.a.z().gc(this.gc);
        com.bytedance.sdk.openadsdk.core.dl.a.z().e(this.m);
        com.bytedance.sdk.openadsdk.core.dl.a.z().fo(z(this.io));
        dl.z.put("title_bar_theme", this.fo);
        dl.z.put("allow_show_notify", this.uy);
        com.bytedance.sdk.openadsdk.core.dl.a.z().a(this.wp);
        Set<Integer> set = this.kb;
        if (set != null && !set.isEmpty()) {
            Iterator<Integer> it = this.kb.iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append(it.next()).append(",");
            }
            dl.z.put("network_state", sb.toString());
            return;
        }
        dl.z.remove("network_state");
    }

    public JSONObject lq() {
        if (gk.g()) {
            ls().eo();
        }
        return this.zw;
    }

    public void z(String str, String str2) {
        try {
            JSONObject jSONObjectOptJSONObject = this.zw.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, str2);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.wp.a("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public void z(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObjectOptJSONObject = this.zw.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.g;
            }
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            jSONObjectOptJSONObject.put(PluginConstants.KEY_APP_ID, str4);
            jSONObjectOptJSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            jSONObjectOptJSONObject.put("sdk_version", str2);
            this.zw.put(str, jSONObjectOptJSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.g("GlobalInfo", "addPluginConfig for " + str + " failed: " + e.getMessage());
        }
    }

    public String mc() {
        if (!TextUtils.isEmpty(this.eo)) {
            return this.eo;
        }
        try {
            Object objInvoke = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                this.eo = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String un() {
        if (!TextUtils.isEmpty(this.ti)) {
            return this.ti;
        }
        try {
            Object objInvoke = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                this.ti = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String ti() {
        if (!TextUtils.isEmpty(this.oq)) {
            return this.oq;
        }
        try {
            Object obj = Class.forName("com.miui.zeus.mimo.sdk.BuildConfig").getField("VERSION_NAME").get(null);
            if (obj instanceof String) {
                String str = (String) obj;
                this.oq = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void eo() {
        /*
            r7 = this;
            java.lang.String r0 = "gdt_version"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = r7.un()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L27
            java.lang.String r3 = r7.mc()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L25
            java.lang.String r3 = r7.ti()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L27
        L25:
            java.lang.String r2 = "1.0.0"
        L27:
            r1.put(r0, r2)     // Catch: org.json.JSONException -> L2a
        L2a:
            java.lang.String r2 = "com.byted.mixed"
            int r3 = com.bytedance.sdk.openadsdk.hh.kb.dl(r2)
            if (r3 == 0) goto L71
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 0
        L45:
            int r6 = r3.length()
            if (r5 >= r6) goto L62
            char r6 = r3.charAt(r5)
            r4.append(r6)
            int r6 = r3.length()
            int r6 = r6 + (-1)
            if (r5 == r6) goto L5f
            java.lang.String r6 = "."
            r4.append(r6)
        L5f:
            int r5 = r5 + 1
            goto L45
        L62:
            java.lang.String r3 = r4.toString()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L71
            java.lang.String r3 = r4.toString()
            goto L73
        L71:
            java.lang.String r3 = "1.0.0.0"
        L73:
            boolean r0 = r1.has(r0)
            if (r0 == 0) goto L96
            java.lang.String r0 = "app_id"
            java.lang.String r4 = r7.g     // Catch: org.json.JSONException -> L96
            r1.put(r0, r4)     // Catch: org.json.JSONException -> L96
            java.lang.String r0 = "plugin_version"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L96
            java.lang.String r0 = "sdk_version"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L96
            java.lang.String r0 = "plugin_update_network"
            java.lang.String r3 = "2"
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L96
            org.json.JSONObject r0 = r7.zw     // Catch: org.json.JSONException -> L96
            r0.put(r2, r1)     // Catch: org.json.JSONException -> L96
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.uy.eo():void");
    }

    public void z(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() <= 0) {
            return;
        }
        for (String str : bundle.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    if (bundle2 == null) {
                        return;
                    }
                    String string = bundle2.getString(PluginConstants.KEY_APP_ID, this.g);
                    z(str, bundle2.getString("sdk_version"), bundle2.getString(PluginConstants.KEY_PLUGIN_VERSION), string);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        }
    }

    public Function<SparseArray<Object>, Object> oq() {
        Function<SparseArray<Object>, Object> function = this.tb;
        if (function != null) {
            return function;
        }
        if (com.bytedance.sdk.openadsdk.ls.dl.a.g(gk.dl)) {
            this.tb = com.bytedance.sdk.openadsdk.core.kb.a.ls.z(zw.getContext());
        } else {
            this.tb = m(3);
        }
        return this.tb;
    }

    public boolean dl(int i) {
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            String str = dl.z.get("network_state", "");
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split(",");
                if (strArrSplit.length > 0) {
                    for (String str2 : strArrSplit) {
                        if (!TextUtils.isEmpty(str2) && String.valueOf(i).equals(str2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        Set<Integer> set = this.kb;
        return set != null && set.contains(Integer.valueOf(i));
    }

    public void z(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.kb.clear();
            for (int i : iArr) {
                this.kb.add(Integer.valueOf(i));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    private static final String z(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        }
        return jSONObject.toString();
    }

    private static final HashMap<String, Object> pf(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    map.put(next, jSONObject.opt(next));
                }
            }
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    private static void ls(String str) {
        com.bytedance.sdk.component.utils.ls.z(str, "appid不能为空");
    }

    private static void p(String str) {
        com.bytedance.sdk.component.utils.ls.z(str, "name不能为空");
    }

    private static void fv(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.ls.z(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    private static void js(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.ls.z(str.length() <= 20000, "data超长, 最长为20000");
    }

    public com.bytedance.sdk.openadsdk.core.playable.a wj() {
        if (this.j == null) {
            this.j = new com.bytedance.sdk.openadsdk.core.playable.a(10, 8);
        }
        return this.j;
    }

    public boolean na() {
        if (com.bytedance.sdk.openadsdk.core.dl.dl.z().g()) {
            return com.bytedance.sdk.openadsdk.core.dl.a.z().dl(false);
        }
        return this.wp;
    }

    public void m(boolean z2) {
        gk.gz = z2;
        this.wp = z2;
    }

    public Bitmap xl() {
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            return com.bytedance.sdk.component.utils.a.z(dl.z.get("pause_icon", ""));
        }
        return this.i;
    }

    public void z(Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            String strZ = com.bytedance.sdk.component.utils.a.z(bitmap);
            if (!TextUtils.isEmpty(strZ)) {
                dl.z.put("pause_icon", strZ);
            }
        }
        this.i = bitmap;
    }

    public int j() {
        if (com.bytedance.sdk.openadsdk.core.dl.dl.z().g()) {
            int iM = com.bytedance.sdk.openadsdk.core.dl.a.z().m();
            return iM == Integer.MIN_VALUE ? this.iq : iM;
        }
        return this.iq;
    }

    public void a(int i) {
        if (i < 0 || i > 2) {
            i = 0;
        }
        try {
            this.iq = i;
        } catch (Throwable unused) {
        }
    }

    public String gp() {
        if (!com.bytedance.sdk.openadsdk.core.dl.dl.z().g()) {
            return TextUtils.isEmpty(this.ls) ? "" : this.ls;
        }
        String str = dl.z.get("tob_ab_sdk_version", "");
        return TextUtils.isEmpty(str) ? "" : str;
    }

    private static com.bytedance.sdk.openadsdk.ls.dl.dl.a r() {
        return new a.z().g(true).z(true).z((com.bytedance.sdk.openadsdk.ls.dl.dl.dl) null).dl(true).z((String) null).a(true).g((String) null).gc(true).dl((String) null).m(true).a((String) null).e(false).z();
    }

    public static final class z extends com.bytedance.sdk.openadsdk.ls.dl.dl.a {
        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean e() {
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean i() {
            return true;
        }

        public z() {
            super(null);
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean z() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.g.z(7, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean g() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.g.z(17, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean dl() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.g.z(9, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean a() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.g.z(11, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean gc() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.g.z(12, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean m() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.g.z(22, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public boolean gz() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.g.z(24, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public com.bytedance.sdk.openadsdk.ls.dl.dl.dl fo() {
            String[] strArrSplit;
            String strZ = com.bytedance.sdk.openadsdk.tools.g.z(8, "");
            if (TextUtils.isEmpty(strZ) || (strArrSplit = strZ.split(",")) == null) {
                return null;
            }
            String str = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new dl.z().z(Double.valueOf(str).doubleValue()).g(Double.valueOf(str2).doubleValue()).z();
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public String uy() {
            return com.bytedance.sdk.openadsdk.tools.g.z(10, "");
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public String kb() {
            return com.bytedance.sdk.openadsdk.tools.g.z(18, "");
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
        public String wp() {
            return com.bytedance.sdk.openadsdk.tools.g.z(13, "");
        }
    }

    public boolean t() {
        return "5001121".equals(this.g) && "com.union_test.toutiao".equals(com.bytedance.sdk.openadsdk.core.un.eo.fo());
    }

    public boolean vm() {
        return "5001121".equals(this.g);
    }

    public String y() {
        if (!TextUtils.isEmpty(this.p)) {
            return this.p;
        }
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        String str = dlVarZ.get("any_door_id", (String) null);
        this.p = str;
        if (!TextUtils.isEmpty(str)) {
            return this.p;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        dlVarZ.put("any_door_id", strValueOf);
        this.p = strValueOf;
        return strValueOf;
    }

    public boolean ec() {
        return this.js;
    }

    public void e(boolean z2) {
        this.js = z2;
    }

    public void gc(int i) {
        com.bytedance.sdk.openadsdk.core.dl.a.z().dl(i);
    }

    public int bv() {
        return com.bytedance.sdk.openadsdk.core.dl.a.z().a(0);
    }

    public Function<SparseArray<Object>, Object> gb() {
        return this.hh;
    }

    public Function<SparseArray<Object>, Object> m(int i) {
        if (this.hh == null) {
            return null;
        }
        return (Function) this.hh.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(10).z(Object.class).z(0, Integer.valueOf(i)).g());
    }

    public void z(Function<SparseArray<Object>, Object> function) {
        if (this.hh != null) {
            return;
        }
        this.hh = function;
    }

    public boolean jq() {
        return this.mc;
    }

    public void gz(boolean z2) {
        this.mc = z2;
    }

    public String sv() {
        return this.e;
    }

    public void uy(String str) {
        this.e = str;
        com.bytedance.sdk.openadsdk.core.gk.gz.z((com.bytedance.sdk.openadsdk.core.gk.gc) null).z(true);
    }

    public boolean z(Context context) {
        if (com.bytedance.sdk.openadsdk.core.l.z.z().gc()) {
            this.l = 2;
        } else {
            this.l = 1;
        }
        return this.l == 1;
    }

    public boolean g(Context context) {
        if (com.bytedance.sdk.openadsdk.core.l.z.z().gc()) {
            this.h = 2;
        } else {
            this.h = 1;
        }
        return this.h == 1;
    }

    public void e(int i) {
        this.gk = i;
    }

    public int f() {
        return this.gk;
    }

    public void z(long j) {
        this.x = j;
    }

    public long yx() {
        return this.x;
    }

    public void z(z.g gVar) {
        if (this.hh != null) {
            if (this.lq == null) {
                gc gcVar = new gc();
                this.lq = gcVar;
                gcVar.z(this.hh);
            }
            this.lq.z(gVar);
        }
    }

    public String qd() {
        try {
            if ((zw.g().wx() & 1) == 1) {
                return com.bytedance.sdk.openadsdk.core.dl.gc.z().gc();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object zx() {
        WeakReference<Activity> weakReferenceZ = this.v.z();
        if (weakReferenceZ != null) {
            return weakReferenceZ.get();
        }
        Object objApply = this.hh != null ? this.hh.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(14).z(Activity.class).g()) : null;
        return objApply == null ? nh() : objApply;
    }

    public void fo(boolean z2) {
        dl.z.put("update_advance_preview_mode", z2);
        dl.z.put("update_advance_preview_mode_time", System.currentTimeMillis());
    }

    public boolean b() {
        if (dl.z.get("update_advance_preview_mode", false)) {
            long j = dl.z.get("update_advance_preview_mode_time", -1L);
            if (j != -1) {
                if (System.currentTimeMillis() - j <= bi.s) {
                    return true;
                }
                fo(false);
            }
        }
        return false;
    }

    public void kb(String str) {
        dl.z.put("toolsQueryHost", str);
    }

    public String lw() {
        return dl.z.get("toolsQueryHost", "api-access.pangolin-sdk-toutiao.com");
    }

    public void wp(String str) {
        dl.z.put("toolsAdPreviewUrl", str);
    }

    public String rv() {
        return dl.z.get("toolsAdPreviewUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.2/html/ad_preview.html");
    }

    public void i(String str) {
        dl.z.put("toolsBasicInfUrl", str);
    }

    public String tc() {
        return dl.z.get("toolsBasicInfUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.2/html/basic_info.html");
    }

    public a me() {
        return this.wj;
    }

    public void z(a aVar) {
        this.wj = aVar;
    }

    public static Object nh() {
        Map map;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            map = (Map) declaredField.get(objInvoke);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("isTopResumedActivity");
                declaredField2.setAccessible(true);
                if (declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return declaredField3.get(obj);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static class a {
        private String g;
        private Map<String, Object> z;

        public a(Map<String, Object> map, String str) {
            this.z = map;
            this.g = str;
        }

        public void z(JSONObject jSONObject) throws JSONException {
            Map<String, Object> map;
            if (jSONObject == null || (map = this.z) == null || map.size() == 0 || TextUtils.isEmpty(this.g)) {
                return;
            }
            for (Map.Entry<String, Object> entry : this.z.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("preview_ads", new JSONObject(this.g));
        }
    }
}
