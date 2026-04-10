package com.bytedance.sdk.openadsdk.core.dl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.zw;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile String f1034a;
    protected volatile String dl;
    protected volatile String e;
    protected volatile String fo;
    private volatile String fv;
    protected volatile String g;
    protected volatile String gc;
    private volatile String gk;
    protected volatile String gz;
    private volatile String hh;
    private volatile String i;
    private volatile String io;
    private volatile String iq;
    private volatile String l;
    protected volatile String m;
    private volatile String p;
    private volatile String q;
    private volatile String sy;
    private volatile JSONArray uf;
    protected volatile String uy;
    private volatile String v;
    protected volatile String z;
    private volatile String zw;
    private volatile int wp = -1;
    private volatile int pf = -1;
    private volatile int ls = -1;
    private volatile int js = -1;
    private volatile int tb = -1;
    private volatile int h = -1;
    private volatile SharedPreferences kb = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), "sp_exec_getad_config", 0);

    public boolean e(int i) {
        return i == 3 || i == 4;
    }

    private static class z {
        private static a z = new a();
    }

    public static a z() {
        return z.z;
    }

    public SharedPreferences g() {
        return this.kb;
    }

    public int dl() {
        if (this.wp == -1) {
            this.wp = g("live_ad_clk_cnt", 0);
        }
        return this.wp;
    }

    public void z(int i) {
        if (this.wp == i) {
            return;
        }
        this.wp = i;
        z("live_ad_clk_cnt", i);
    }

    public String a() {
        if (this.i == null) {
            this.i = dl(PluginConstants.KEY_APP_ID, "");
        }
        return this.i;
    }

    public void z(String str) {
        if (str == null || !str.equals(this.i)) {
            this.i = str;
            g(PluginConstants.KEY_APP_ID, str);
        }
    }

    public String gc() {
        if (this.v == null) {
            this.v = dl(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, "");
        }
        return this.v;
    }

    public void g(String str) {
        if (str == null || !str.equals(this.v)) {
            this.v = str;
            g(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, str);
        }
    }

    public boolean z(boolean z2) {
        if (this.pf == -1) {
            this.pf = g("is_paid", z2 ? 1 : 2);
        }
        return this.pf == 1;
    }

    public void g(boolean z2) {
        this.pf = z2 ? 1 : 2;
        z("is_paid", this.pf);
    }

    public String dl(String str) {
        if (this.p == null) {
            this.p = dl("dev03", str);
        }
        return this.p;
    }

    public void a(String str) {
        this.p = str;
        g("dev03", str);
    }

    public void gc(String str) {
        if (str == null || !str.equals(this.fv)) {
            this.fv = str;
            g("keywords", str);
        }
    }

    public String m(String str) {
        if (this.fv == null) {
            this.fv = dl("keywords", str);
        }
        return this.fv;
    }

    public void g(int i) {
        if (i == this.js) {
            return;
        }
        this.js = i;
        z("age_group", i);
    }

    public int m() {
        if (this.js == -1) {
            this.js = g("age_group", Integer.MIN_VALUE);
        }
        return this.js;
    }

    public String z(String str, String str2) {
        return dl("code_group_rit_".concat(String.valueOf(str)), str2);
    }

    public void dl(int i) {
        if (i == this.tb) {
            return;
        }
        this.tb = i;
        z("sdk_theme_status", i);
    }

    public int a(int i) {
        if (this.tb == -1) {
            this.tb = g("sdk_theme_status", i);
        }
        return this.tb;
    }

    public void e(String str) {
        if (str == null || !str.equals(this.q)) {
            this.q = str;
            g("extra_data", str);
        }
    }

    public String gz(String str) {
        if (this.q == null) {
            this.q = dl("extra_data", str);
        }
        return this.q;
    }

    public void fo(String str) {
        if (str == null || !str.equals(this.iq)) {
            this.iq = str;
            g("extra_internal_data", str);
        }
    }

    public String uy(String str) {
        if (this.iq == null) {
            this.iq = dl("extra_internal_data", str);
        }
        return this.iq;
    }

    public String gc(int i) {
        if (TextUtils.isEmpty(this.zw)) {
            try {
                String strDl = dl("logsdk_version", "");
                if (!TextUtils.isEmpty(strDl)) {
                    JSONObject jSONObject = new JSONObject(strDl);
                    int iOptInt = jSONObject.optInt(PluginConstants.KEY_PLUGIN_VERSION);
                    this.zw = jSONObject.optString("log_version");
                    if (iOptInt != 7105 || TextUtils.isEmpty(this.zw)) {
                        io();
                    }
                } else {
                    io();
                }
            } catch (Exception unused) {
            }
        }
        return this.zw;
    }

    private void io() {
        try {
            this.zw = com.bytedance.sdk.openadsdk.core.m.z().gc();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, 7105);
            jSONObject.put("log_version", this.zw);
            g("logsdk_version", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public String kb(String str) {
        if (this.z == null) {
            this.z = dl("dev01", str);
        }
        return this.z;
    }

    public String e() {
        if (this.g == null) {
            this.g = com.bytedance.sdk.component.utils.z.dl(dl("dev02", (String) null));
        }
        return this.g;
    }

    public String gz() {
        if (this.dl == null) {
            this.dl = dl("dev04", (String) null);
        }
        return this.dl;
    }

    public String fo() {
        if (this.f1034a == null) {
            this.f1034a = dl("dev05", (String) null);
        }
        return this.f1034a;
    }

    public String uy() {
        if (this.gc == null) {
            this.gc = dl("dev07", (String) null);
        }
        return this.gc;
    }

    public String kb() {
        if (this.m == null) {
            this.m = dl("dev08", (String) null);
        }
        return this.m;
    }

    public String wp() {
        if (this.e == null) {
            this.e = dl("dev17", (String) null);
        }
        return this.e;
    }

    public String i() {
        if (this.gz == null) {
            this.gz = dl("dev18", (String) null);
        }
        return this.gz;
    }

    public String v() {
        if (this.fo == null) {
            this.fo = dl("dev09", (String) null);
        }
        return this.fo;
    }

    public void wp(String str) {
        if (str == null || str.equals(this.io)) {
            return;
        }
        this.io = str;
        g("dev10", str);
    }

    public String pf() {
        if (this.io == null) {
            this.io = dl("dev10", (String) null);
        }
        return this.io;
    }

    public String ls() {
        if (this.uy == null) {
            this.uy = dl("dev11", (String) null);
        }
        return this.uy;
    }

    public void z(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.toString().equals(this.uf == null ? null : this.uf.toString())) {
            return;
        }
        this.uf = jSONArray;
        g("dev12", jSONArray.toString());
    }

    public JSONArray p() {
        String strDl;
        if (this.uf == null && (strDl = dl("dev12", (String) null)) != null) {
            try {
                this.uf = new JSONArray(strDl);
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        return this.uf;
    }

    public void i(String str) {
        if (str == null || str.equals(this.sy)) {
            return;
        }
        this.sy = str;
        a("dev13", str);
    }

    public String fv() {
        if (this.sy == null) {
            this.sy = dl("dev13", (String) null);
        }
        return this.sy;
    }

    public void v(String str) {
        if (str == null || str.equals(this.hh)) {
            return;
        }
        this.hh = str;
        a("dev15", str);
    }

    public String js() {
        if (this.hh == null) {
            this.hh = dl("dev15", (String) null);
        }
        return this.hh;
    }

    public int tb() {
        return g("sp_device_app_direction", -1);
    }

    public void m(int i) {
        z("sp_device_app_direction", i);
    }

    public String q() {
        if (this.l == null) {
            this.l = dl("dev16", "");
        }
        return this.l;
    }

    public void pf(String str) {
        if (str == null || !str.equals(this.l)) {
            this.l = str;
            g("dev16", str);
        }
    }

    public boolean dl(boolean z2) {
        if (this.ls == -1) {
            this.ls = g("is_use_mediation", z2 ? 1 : 2);
        }
        return this.ls == 1;
    }

    public void a(boolean z2) {
        int i = z2 ? 1 : 2;
        if (this.ls != i) {
            this.ls = i;
            z("is_use_mediation", i);
        }
    }

    public void gz(int i) {
        if (this.h == i) {
            return;
        }
        this.h = i;
        z("dev_level", i);
    }

    public String iq() {
        if (this.gk == null) {
            this.gk = dl("spl_strategy", "");
        }
        return this.gk;
    }

    public void ls(String str) {
        if (str == null || !str.equals(this.gk)) {
            this.gk = str;
            g("spl_strategy", this.gk);
        }
    }

    public void z(String str, boolean z2) {
        try {
            if (dl.z().g()) {
                com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", str, Boolean.valueOf(z2));
                return;
            }
            SharedPreferences.Editor editorEdit = g().edit();
            editorEdit.putBoolean(str, z2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public boolean g(String str, boolean z2) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", str, z2);
            }
            return g().getBoolean(str, z2);
        } catch (Throwable unused) {
            return z2;
        }
    }

    public void z(String str, long j) {
        try {
            if (dl.z().g()) {
                com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", str, Long.valueOf(j));
                return;
            }
            SharedPreferences.Editor editorEdit = g().edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public long g(String str, long j) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", str, j);
            }
            return g().getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public void z(String str, int i) {
        try {
            if (dl.z().g()) {
                com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", str, Integer.valueOf(i));
                return;
            }
            SharedPreferences.Editor editorEdit = g().edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public int g(String str, int i) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", str, i);
            }
            return g().getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void g(String str, String str2) {
        try {
            if (dl.z().g()) {
                com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = g().edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public String dl(String str, String str2) {
        try {
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.g("sp_exec_getad_config", str, str2);
            }
            return g().getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public String dl(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strDl = dl(str, "");
            if (TextUtils.isEmpty(strDl)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strDl);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString("value");
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strDl = dl(str, "");
            if (TextUtils.isEmpty(strDl)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strDl);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString("value");
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("p_version", 7105);
            g(str, jSONObject.toString());
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    public void zw() {
        try {
            SharedPreferences.Editor editorEdit = g().edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static class g {
        private Map<String, Object> z = new HashMap();

        public g z(String str) {
            if (str == null || str.equals(a.z().z)) {
                return this;
            }
            a.z().z = str;
            this.z.put("dev01", str);
            return this;
        }

        public g g(String str) {
            if (str == null || str.equals(a.z().g)) {
                return this;
            }
            a.z().g = str;
            this.z.put("dev02", com.bytedance.sdk.component.utils.z.g(str));
            return this;
        }

        public g dl(String str) {
            if (str == null || str.equals(a.z().dl)) {
                return this;
            }
            a.z().dl = str;
            this.z.put("dev04", str);
            return this;
        }

        public g a(String str) {
            if (str == null || str.equals(a.z().f1034a)) {
                return this;
            }
            a.z().f1034a = str;
            this.z.put("dev05", str);
            return this;
        }

        public g gc(String str) {
            if (str == null || str.equals(a.z().uy)) {
                return this;
            }
            a.z().uy = str;
            this.z.put("dev11", str);
            return this;
        }

        public g m(String str) {
            if (str == null || str.equals(a.z().gc)) {
                return this;
            }
            a.z().gc = str;
            this.z.put("dev07", str);
            return this;
        }

        public g e(String str) {
            if (str == null || str.equals(a.z().m)) {
                return this;
            }
            a.z().m = str;
            this.z.put("dev08", str);
            return this;
        }

        public g gz(String str) {
            if (str == null || str.equals(a.z().e)) {
                return this;
            }
            a.z().e = str;
            this.z.put("dev17", str);
            return this;
        }

        public g fo(String str) {
            if (str == null || str.equals(a.z().gz)) {
                return this;
            }
            a.z().gz = str;
            this.z.put("dev18", str);
            return this;
        }

        public g uy(String str) {
            if (str == null || str.equals(a.z().fo)) {
                return this;
            }
            a.z().fo = str;
            this.z.put("dev09", str);
            return this;
        }

        public void z() {
            try {
                if (dl.z().g()) {
                    for (Map.Entry<String, Object> entry : this.z.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.e.dl.z.g.z("sp_exec_getad_config", key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = a.z().g().edit();
                for (Map.Entry<String, Object> entry2 : this.z.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        editorEdit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        editorEdit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        editorEdit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        editorEdit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        editorEdit.putString(key2, (String) value2);
                    }
                }
                editorEdit.apply();
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }
}
