package com.bytedance.msdk.core.v;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.api.a.ls;
import com.bytedance.msdk.core.gz.v;
import com.bytedance.msdk.core.uy.a;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.m.g.gc;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f414a;
    private boolean b;
    private com.bytedance.msdk.core.dl.g bv;
    private String dl;
    private String e;
    private int ec;
    private String fo;
    private long fv;
    private long gc;
    private String gz;
    private int h;
    private int i;
    private com.bytedance.msdk.core.g.g j;
    private String kb;
    private com.bytedance.msdk.core.m.g lw;
    private String m;
    private int na;
    private int oq;
    private long p;
    private int uy;
    private String wj;
    private String wp;
    private int xl;
    private int z = 259200000;
    private final List<Object> g = new CopyOnWriteArrayList();
    private String v = null;
    private int pf = 0;
    private String ls = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";
    private int js = Integer.MAX_VALUE;
    private final List<ls> tb = new CopyOnWriteArrayList();
    private Map<String, Boolean> q = new HashMap();
    private final AtomicBoolean iq = new AtomicBoolean(false);
    private final AtomicBoolean zw = new AtomicBoolean(false);
    private int io = 0;
    private Map<String, String> uf = new ConcurrentHashMap();
    private Map<String, List<String>> sy = new ConcurrentHashMap();
    private double hh = 0.0d;
    private boolean l = false;
    private Map<String, com.bytedance.msdk.core.uy.dl> gk = new ConcurrentHashMap();
    private int x = 0;
    private final Map<String, List<com.bytedance.msdk.core.uy.dl>> lq = new ConcurrentHashMap();
    private final Map<String, a> mc = new ConcurrentHashMap();
    private final Map<String, Integer> un = new ConcurrentHashMap();
    private final Map<String, Integer> ti = new ConcurrentHashMap();
    private int eo = 0;
    private int gp = 0;
    private int t = 0;
    private int vm = 0;
    private int y = 0;
    private int gb = 0;
    private int jq = 0;
    private boolean sv = false;
    private boolean f = false;
    private boolean yx = false;
    private boolean qd = false;
    private int zx = 0;

    public int z() {
        return this.jq;
    }

    public boolean g() {
        return this.sv;
    }

    public boolean dl() {
        return this.f;
    }

    public boolean a() {
        return this.yx;
    }

    public void g(boolean z) {
        this.yx = z;
    }

    public boolean gc() {
        return this.qd;
    }

    public boolean m() {
        return this.zx == 1;
    }

    public boolean e() {
        return this.iq.get();
    }

    public com.bytedance.msdk.core.uy.g z(String str, int i, int i2) {
        return com.bytedance.msdk.e.z.dl.z().z(str, i, i2);
    }

    public long z(int i, String str) {
        com.bytedance.msdk.core.uy.g gVarZ = z(str, i, 101);
        return gVarZ != null ? gVarZ.na() : C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    }

    public com.bytedance.msdk.core.uy.z z(String str) {
        return com.bytedance.msdk.e.z.g.z().z(str);
    }

    public com.bytedance.msdk.core.uy.z g(String str) {
        return com.bytedance.msdk.e.z.g.z().z(str);
    }

    public boolean dl(String str) {
        return com.bytedance.msdk.e.z.g.z().g(str);
    }

    public boolean z(String str, String str2, int i) {
        List<uy> listT;
        com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.e.z.dl.z().z(str, i, 101);
        if (gVarZ == null || (listT = gVarZ.t()) == null) {
            return false;
        }
        for (uy uyVar : listT) {
            if (uyVar != null && TextUtils.equals(uyVar.fv(), str2)) {
                return uyVar.oq();
            }
        }
        return false;
    }

    public boolean z(String str, int i) {
        com.bytedance.msdk.core.uy.g gVarZ;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.bytedance.msdk.e.z.dl.z().dl() || (gVarZ = com.bytedance.msdk.e.z.dl.z().z(str, i, 101)) == null || gVarZ.ti() == i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.msdk.core.m.g, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    @Override // com.bytedance.msdk.core.v.z
    public void z(JSONObject jSONObject, final boolean z) {
        boolean z2;
        ?? r2;
        dl dlVar;
        final String strDl;
        final JSONArray jSONArrayOptJSONArray;
        final String str;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("app_abtest");
            this.v = strOptString;
            gz(strOptString);
            this.jq = jSONObject.optInt("is_trusteeship_monetize");
            this.zx = jSONObject.optInt("share_cache_enable");
            this.dl = jSONObject.optString("etag");
            this.f414a = jSONObject.optLong("max_age");
            this.gc = System.currentTimeMillis() + this.f414a;
            this.m = jSONObject.optString("ab_version");
            this.e = jSONObject.optString("ab_params");
            this.gz = jSONObject.optString(an.O);
            this.fo = jSONObject.optString("transparent_params");
            this.h = jSONObject.optInt("if_test");
            this.uy = jSONObject.optInt("if_get_detail_return");
            this.kb = jSONObject.optString("ecpm_precision_level");
            this.wp = jSONObject.optString("fetch_primerit_level");
            final String strOptString2 = jSONObject.optString("url");
            this.pf = jSONObject.optInt("innerLog", 0);
            this.ls = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.p = jSONObject.optLong("break_request_times", 0L);
            this.fv = jSONObject.optLong("break_request_hold_time", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            this.oq = jSONObject.optInt("ex_info", 0);
            this.wj = jSONObject.optString("ex_");
            this.x = jSONObject.optInt("if_enable_label", 0);
            this.z = jSONObject.optInt("ecpm_ttl", 259200000);
            int iOptInt = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
            this.js = iOptInt;
            if (iOptInt != 0 && iOptInt != 1) {
                this.js = 1;
            }
            this.hh = jSONObject.optDouble("custom_adn_sample_ratio", 0.0d);
            int iOptInt2 = jSONObject.optInt("enable_label_return", 0);
            this.na = iOptInt2;
            if (iOptInt2 != 0 && iOptInt2 != 1) {
                this.na = 0;
            }
            this.xl = jSONObject.optInt("dynamic_policy_enable", 0);
            com.bytedance.msdk.z.gc.dl.g("DynamicPolicy", "mDynamicPolicyEnable=" + this.xl);
            int i = this.xl;
            if (i != 0 && i != 1) {
                this.xl = 0;
            }
            int i2 = this.gp;
            int i3 = this.t;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("p_c");
            if (jSONObjectOptJSONObject != null) {
                this.gp = jSONObjectOptJSONObject.optInt("l_p_a", 0);
                this.t = jSONObjectOptJSONObject.optInt("l_p_r", 0);
            } else {
                this.gp = 0;
                this.t = 0;
            }
            if (i2 != this.gp || i3 != this.t) {
                gc.z();
            }
            com.bytedance.msdk.core.e.z.z().z(this.p, this.fv);
            this.vm = jSONObject.optInt("enable_bid_result_return", 0);
            this.y = jSONObject.optInt("enable_bid_result_return_for_baidu", 0);
            this.gb = jSONObject.optInt("enable_bid_result_return_for_ks", 0);
            final JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("supervisor_feature");
            if (jSONObjectOptJSONObject2 != null) {
                com.bytedance.msdk.gz.ls.z(true);
                com.bytedance.msdk.gz.ls.z(jSONObjectOptJSONObject2);
            } else {
                com.bytedance.msdk.gz.ls.z(false);
            }
            final JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ra_info");
            if (jSONArrayOptJSONArray2 != null) {
                com.bytedance.msdk.core.admanager.reward.rewardagain.dl.z(jSONArrayOptJSONArray2);
            }
            com.bytedance.msdk.e.z.z.z().z(jSONObject.optJSONObject("app_common_config"));
            com.bytedance.msdk.e.z.g.z().z(jSONObject.optJSONObject("adn_init_conf"));
            final String strG = g(jSONObject.optJSONArray("adn_control_conf"));
            final String strDl2 = dl(jSONObject.optJSONArray("rit_adn_control_conf"));
            final String strM = m(jSONObject.optJSONObject("poor_network_config"));
            com.bytedance.msdk.e.z.dl.z().z(jSONObject.optJSONArray("rit_conf"));
            final String strFo = fo(jSONObject.optJSONObject("module_disable_control"));
            final JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("call_stack_conf");
            e(jSONObjectOptJSONObject3);
            final JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("custom_adn_feature");
            gz(jSONObjectOptJSONObject4);
            final JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("timeout_req");
            uy(jSONObjectOptJSONObject5);
            final JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("is_callback");
            kb(jSONObjectOptJSONObject6);
            final String strGc = gc(jSONObject.optJSONObject("label_outputs"));
            final String strA = a(jSONObject.optJSONObject("label_group_infos"));
            final String strZ = z(jSONObject.optJSONArray("dynamic_rules"));
            final String strG2 = g(jSONObject.optJSONObject("dynamic_policy"));
            this.ec = jSONObject.optInt("behavior_policy_enable", 0);
            try {
                com.bytedance.msdk.z.gc.dl.g("BehaviorPolicy", "mBehaviorPolicyConfigEnable=" + this.ec);
                strDl = dl(jSONObject.optJSONObject("behavior_policy"));
                JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("inter_full_refresh_cfg");
                String string = jSONObjectOptJSONObject7 != null ? jSONObjectOptJSONObject7.toString() : null;
                com.bytedance.msdk.core.admanager.z.z(string);
                com.bytedance.msdk.dl.gz.a.z(jSONObject.optJSONObject("csj_code_mapping_conf"));
                jSONArrayOptJSONArray = jSONObject.optJSONArray("gm_req_sr");
                com.bytedance.msdk.dl.gz.gc.z(jSONArrayOptJSONArray);
                str = string;
            } catch (Throwable th) {
                th = th;
                r2 = 0;
                dlVar = this;
                z2 = false;
            }
            try {
                m.a(new Runnable() { // from class: com.bytedance.msdk.core.v.dl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String strZ2;
                        String strZ3;
                        String strZ4;
                        String strZ5;
                        String strZ6;
                        String strZ7;
                        String strZ8;
                        String strZ9;
                        String strZ10;
                        l lVarZ = com.bytedance.msdk.e.z.z();
                        lVarZ.z("is_trusteeship_monetize", dl.this.jq);
                        lVarZ.z("share_cache_enable", dl.this.zx);
                        lVarZ.z("etag", dl.this.dl);
                        lVarZ.z("max_age", dl.this.f414a);
                        lVarZ.z("max_expire_time", dl.this.gc);
                        lVarZ.z("ab_version", dl.this.m);
                        lVarZ.z("ab_params", dl.this.e);
                        lVarZ.z(an.O, dl.this.gz);
                        lVarZ.z("transparent_params", dl.this.fo);
                        lVarZ.z("if_test", dl.this.h);
                        lVarZ.z("network_permission", dl.this.uy);
                        lVarZ.z("ecpm_precision_level", dl.this.kb);
                        lVarZ.z("fetch_primerit_level", dl.this.wp);
                        lVarZ.z("app_abtest", dl.this.v);
                        lVarZ.z("module_control", strFo);
                        lVarZ.z("tt_app_log_url", dl.this.ls);
                        lVarZ.z("break_request_times", dl.this.p);
                        lVarZ.z("break_request_hold_time", dl.this.fv);
                        lVarZ.z("ex_info", dl.this.oq);
                        lVarZ.z("if_enable_label", dl.this.x);
                        lVarZ.z("cpm_expire_time", dl.this.z);
                        JSONObject jSONObject2 = jSONObjectOptJSONObject2;
                        lVarZ.z("key_supervisor_feature", jSONObject2 != null ? jSONObject2.toString() : "");
                        lVarZ.z("custom_adn_sample_ratio", (float) dl.this.hh);
                        lVarZ.z("enable_label_return", dl.this.na);
                        lVarZ.z("dynamic_policy_enable", dl.this.xl);
                        lVarZ.z("behavior_policy_enable", dl.this.ec);
                        lVarZ.z("limit_p_a", dl.this.gp);
                        lVarZ.z("limit_p_r", dl.this.t);
                        lVarZ.z("enable_bid_result_return", dl.this.vm);
                        lVarZ.z("enable_bid_result_return_for_baidu", dl.this.y);
                        lVarZ.z("enable_bid_result_return_for_ks", dl.this.gb);
                        JSONObject jSONObject3 = jSONObjectOptJSONObject3;
                        if (jSONObject3 != null) {
                            lVarZ.z("call_stack", jSONObject3.toString());
                        } else {
                            lVarZ.z("call_stack", "");
                        }
                        JSONObject jSONObject4 = jSONObjectOptJSONObject4;
                        if (jSONObject4 != null) {
                            lVarZ.z("custom_adn_feature", jSONObject4.toString());
                        } else {
                            lVarZ.z("custom_adn_feature", "");
                        }
                        JSONObject jSONObject5 = jSONObjectOptJSONObject5;
                        if (jSONObject5 != null) {
                            lVarZ.z("timeout_req", jSONObject5.toString());
                        } else {
                            lVarZ.z("timeout_req", "");
                        }
                        JSONObject jSONObject6 = jSONObjectOptJSONObject6;
                        if (jSONObject6 != null) {
                            lVarZ.z("is_callback", jSONObject6.toString());
                        } else {
                            lVarZ.z("is_callback", "");
                        }
                        String str2 = strOptString2;
                        if (str2 != null && !TextUtils.isEmpty(str2)) {
                            String strZ11 = com.bytedance.msdk.gz.z.z(strOptString2, com.bytedance.msdk.gz.g.z());
                            if (strZ11 != null) {
                                lVarZ.z("server_dist_host", strZ11);
                            }
                        } else {
                            lVarZ.m("server_dist_host");
                        }
                        String str3 = strG;
                        if (str3 != null && (strZ10 = com.bytedance.msdk.gz.z.z(str3, com.bytedance.msdk.gz.g.z())) != null) {
                            lVarZ.z("adn_control_conf", strZ10);
                        }
                        if (!TextUtils.isEmpty(strDl2)) {
                            lVarZ.z("rit_adn_control_conf", strDl2);
                        } else {
                            lVarZ.m("rit_adn_control_conf");
                        }
                        String str4 = strM;
                        if (str4 != null) {
                            lVarZ.z("network_conf", str4);
                        }
                        if (!TextUtils.isEmpty(strGc) && (strZ9 = com.bytedance.msdk.gz.z.z(strGc, com.bytedance.msdk.gz.g.z())) != null) {
                            lVarZ.z("label_outputs", strZ9);
                        }
                        if (!TextUtils.isEmpty(strA) && (strZ8 = com.bytedance.msdk.gz.z.z(strA, com.bytedance.msdk.gz.g.z())) != null) {
                            lVarZ.z("label_group_infos", strZ8);
                        }
                        if (!TextUtils.isEmpty(strZ) && (strZ7 = com.bytedance.msdk.gz.z.z(strZ, com.bytedance.msdk.gz.g.z())) != null) {
                            lVarZ.z("dynamic_rules", strZ7);
                        }
                        if (!TextUtils.isEmpty(dl.this.wj) && (strZ6 = com.bytedance.msdk.gz.z.z(dl.this.wj, com.bytedance.msdk.gz.g.z())) != null) {
                            lVarZ.z("ex_", strZ6);
                        }
                        JSONArray jSONArray = jSONArrayOptJSONArray2;
                        if (jSONArray != null) {
                            String string2 = jSONArray.toString();
                            if (!TextUtils.isEmpty(string2) && (strZ5 = com.bytedance.msdk.gz.z.z(string2, com.bytedance.msdk.gz.g.z())) != null) {
                                lVarZ.z("reward_again_styles", strZ5);
                            }
                        }
                        if (!TextUtils.isEmpty(strG2) && (strZ4 = com.bytedance.msdk.gz.z.z(strG2, com.bytedance.msdk.gz.g.z())) != null) {
                            lVarZ.z("dynamic_policy", strZ4);
                        }
                        if (!TextUtils.isEmpty(strDl) && (strZ3 = com.bytedance.msdk.gz.z.z(strDl, com.bytedance.msdk.gz.g.z())) != null) {
                            lVarZ.z("behavior_policy", strZ3);
                        }
                        if (!TextUtils.isEmpty(str) && (strZ2 = com.bytedance.msdk.gz.z.z(str, com.bytedance.msdk.gz.g.z())) != null) {
                            lVarZ.z("inter_full_refresh_cfg", strZ2);
                        }
                        JSONArray jSONArray2 = jSONArrayOptJSONArray;
                        if (jSONArray2 != null && jSONArray2.length() > 0) {
                            String strZ12 = com.bytedance.msdk.gz.z.z(jSONArrayOptJSONArray.toString(), com.bytedance.msdk.gz.g.z());
                            if (strZ12 != null) {
                                lVarZ.z("gm_req_sr", strZ12);
                            }
                        } else {
                            lVarZ.m("gm_req_sr");
                        }
                        lVarZ.z("is_config_from_assert", z);
                        lVarZ.z("has_config_in_sp", true);
                    }
                });
                z(false, (JSONObject) null, (com.bytedance.msdk.core.m.g) null);
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                z2 = false;
                dlVar = this;
                try {
                    wp.z(th);
                } finally {
                    dlVar.z(z2, (JSONObject) r2, (com.bytedance.msdk.core.m.g) r2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            r2 = 0;
            dlVar = this;
        }
    }

    private String g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.j = new com.bytedance.msdk.core.g.g(jSONObject);
        return jSONObject.toString();
    }

    private String dl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.bv = new com.bytedance.msdk.core.dl.g(jSONObject);
        return jSONObject.toString();
    }

    private String z(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                a.z(jSONArray.optJSONObject(i), this.mc);
            } catch (Exception e) {
                com.bytedance.msdk.z.gc.dl.dl("TTMediationSDK", "maybe some rit parse dynamic rules fail .....");
                wp.z(e);
            }
        }
        return jSONArray.toString();
    }

    private String a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return "";
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(next);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(com.bytedance.msdk.core.uy.dl.z(next, jSONArray.optJSONObject(i)));
                    }
                    this.lq.put(next, arrayList);
                }
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return jSONObject.toString();
    }

    private String gc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.gk.put(next, com.bytedance.msdk.core.uy.dl.z(next, jSONObject.optJSONObject(next)));
        }
        return jSONObject.toString();
    }

    public void z(com.bytedance.msdk.core.m.g gVar) {
        this.lw = gVar;
    }

    public void z(final boolean z, final JSONObject jSONObject, com.bytedance.msdk.core.m.g gVar) {
        if (gVar != null) {
            this.lw = gVar;
        }
        final boolean zL = l();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.m.g.z.g().z(com.bytedance.msdk.core.g.getContext(), z, zL, new com.bytedance.msdk.core.m.g() { // from class: com.bytedance.msdk.core.v.dl.2
            @Override // com.bytedance.msdk.core.m.g
            public void z() {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + zL);
                if (zL) {
                    dl.this.iq.set(true);
                    dl.this.rv();
                    if (dl.this.lw != null) {
                        dl.this.lw.z();
                    }
                    m.a(new Runnable() { // from class: com.bytedance.msdk.core.v.dl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!dl.this.zw.get()) {
                                dl.this.zw.set(true);
                                int iZ = com.bytedance.msdk.m.g.z.z();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - com.bytedance.msdk.m.dl.z();
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                try {
                                    if (jSONObject != null) {
                                        jSONObject.put("adn_time", jElapsedRealtime3);
                                    }
                                } catch (Throwable unused) {
                                }
                                HashMap map = new HashMap();
                                map.put("csj_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.gc.f870a - com.bytedance.sdk.gromore.init.gc.z));
                                if (dl.this.b) {
                                    map.put("is_import_cfg", Boolean.valueOf(dl.this.b));
                                }
                                if (!com.bytedance.msdk.m.a.z()) {
                                    com.bytedance.msdk.z.gc.dl.z("TMe", "-----==---- 延时上报sdk_init_end");
                                    com.bytedance.msdk.m.a.z(jElapsedRealtime2, iZ, z ? 1 : 0, jSONObject, map);
                                } else {
                                    com.bytedance.msdk.z.gc.dl.z("TMe", "-----==---- 正常上报sdk_init_end");
                                    com.bytedance.msdk.m.a.z(jElapsedRealtime2, iZ, z ? 1 : 0, -1L, jSONObject, map);
                                }
                                com.bytedance.msdk.core.g.z.z();
                                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "sdk init end, duration: " + jElapsedRealtime2 + ", initAdnCount: " + iZ + ", isFromLocalConfig: " + z);
                            }
                            g.z(com.bytedance.msdk.core.g.g()).z(new com.bytedance.msdk.api.a.gc() { // from class: com.bytedance.msdk.core.v.dl.2.1.1
                                @Override // com.bytedance.msdk.api.a.gc
                                public void z(List<String> list) {
                                    com.bytedance.msdk.z.gc.dl.z("TMe", "初始化更新pangle配置成功");
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override // com.bytedance.msdk.core.v.z
    public void z(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        l lVarZ = com.bytedance.msdk.e.z.z();
        this.f414a = jSONObject.optLong("max_age");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f414a;
        this.gc = jCurrentTimeMillis + j;
        lVarZ.z("max_age", j);
        lVarZ.z("max_expire_time", this.gc);
    }

    public boolean g(String str, int i) {
        return (com.bytedance.msdk.e.z.g.z().a() || com.bytedance.msdk.e.z.dl.z().dl() || com.bytedance.msdk.e.z.dl.z().z(str, i, 101) == null) ? false : true;
    }

    public String gz() {
        return this.gz;
    }

    public String fo() {
        return this.fo;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0114 A[Catch: all -> 0x04aa, TryCatch #2 {all -> 0x04aa, blocks: (B:3:0x0007, B:5:0x0014, B:7:0x001e, B:10:0x002e, B:25:0x009e, B:28:0x00b2, B:30:0x00bc, B:32:0x00d7, B:41:0x010e, B:42:0x0114, B:15:0x0044, B:17:0x005d, B:22:0x008c, B:24:0x0094, B:43:0x0130, B:45:0x0239, B:46:0x0241, B:48:0x024d, B:49:0x0258, B:52:0x0268, B:54:0x026e, B:56:0x0274, B:57:0x027c, B:58:0x0284, B:60:0x0290, B:61:0x0298, B:63:0x02a4, B:64:0x02ac, B:66:0x02b4, B:67:0x02bf, B:69:0x02cb, B:70:0x02d3, B:72:0x02df, B:73:0x02e7, B:75:0x02f3, B:76:0x02fb, B:78:0x0307, B:79:0x030f, B:81:0x031b, B:83:0x032a, B:85:0x0336, B:87:0x033c, B:89:0x0342, B:90:0x034a, B:92:0x0350, B:93:0x0358, B:95:0x0364, B:97:0x036a, B:99:0x0370, B:100:0x0378, B:102:0x037e, B:103:0x0386, B:105:0x0392, B:107:0x0398, B:109:0x039e, B:110:0x03a6, B:112:0x03ac, B:113:0x03b4, B:115:0x03c0, B:117:0x03c6, B:119:0x03cc, B:120:0x03d4, B:122:0x03da, B:123:0x03e2, B:125:0x03ee, B:127:0x03f4, B:129:0x03fa, B:130:0x0402, B:132:0x0408, B:133:0x0410, B:135:0x041c, B:137:0x042a, B:138:0x042d, B:140:0x0439, B:145:0x0451, B:146:0x0454, B:148:0x0460, B:150:0x0466, B:152:0x046c, B:153:0x0476, B:155:0x0480, B:82:0x0327, B:142:0x0447, B:12:0x003c, B:19:0x006f), top: B:176:0x0007, inners: #0, #1, #3 }] */
    @Override // com.bytedance.msdk.core.v.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(boolean r15) {
        /*
            Method dump skipped, instruction units count: 1227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.v.dl.z(boolean):void");
    }

    private String m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.i = jSONObject.optInt("fetch_ad_type", 0);
        return jSONObject.toString();
    }

    private void e(String str) {
        try {
            com.bytedance.msdk.core.admanager.reward.rewardagain.dl.z(new JSONArray(str));
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    private String g(JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONArray != null) {
            ConcurrentHashMap<String, com.bytedance.msdk.core.gz.g> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("break_request_error_code")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        arrayList.add(jSONArrayOptJSONArray.optString(i2));
                    }
                    com.bytedance.msdk.core.gz.g gVar = new com.bytedance.msdk.core.gz.g();
                    gVar.z(jSONObjectOptJSONObject.optLong("break_request_duration"));
                    gVar.z(arrayList);
                    concurrentHashMap.put(jSONObjectOptJSONObject.optString(MediationConstant.EXTRA_ADN_NAME), gVar);
                }
            }
            com.bytedance.msdk.core.gz.dl.z().z(concurrentHashMap);
            return jSONArray.toString();
        }
        com.bytedance.msdk.core.gz.dl.z().z(null);
        return null;
    }

    private String dl(JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        if (jSONArray != null) {
            ConcurrentHashMap<String, List<com.bytedance.msdk.core.gz.g>> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(MediationConstant.EXTRA_ADN_NAME);
                    if (!TextUtils.isEmpty(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("break_request_error_code")) != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("rit_list")) != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                        com.bytedance.msdk.core.gz.g gVar = new com.bytedance.msdk.core.gz.g();
                        gVar.z(jSONObjectOptJSONObject.optLong("break_request_duration"));
                        gVar.z(arrayList);
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                            arrayList2.add(jSONArrayOptJSONArray2.optString(i3));
                        }
                        gVar.g(arrayList2);
                        List<com.bytedance.msdk.core.gz.g> arrayList3 = concurrentHashMap.get(strOptString);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        arrayList3.add(gVar);
                        concurrentHashMap.put(strOptString, arrayList3);
                    }
                }
            }
            v.z().z(concurrentHashMap);
            return jSONArray.toString();
        }
        v.z().z(null);
        return null;
    }

    private void gz(String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(new JSONObject(str).optString("app_ab_params")).optJSONObject("mediation_settings");
            if (jSONObjectOptJSONObject != null) {
                this.eo = jSONObjectOptJSONObject.optInt("ad_request_optmize");
                boolean z = true;
                this.sv = jSONObjectOptJSONObject.optInt("applog_cypher") == 2;
                this.f = jSONObjectOptJSONObject.optInt("reward_cypher") == 2;
                this.yx = jSONObjectOptJSONObject.optInt("config_cypher") == 2;
                if (jSONObjectOptJSONObject.optInt("exchange_cypher") != 2) {
                    z = false;
                }
                this.qd = z;
            }
        } catch (Throwable unused) {
        }
    }

    private void e(JSONObject jSONObject) {
        this.uf.clear();
        this.io = 0;
        if (jSONObject == null) {
            return;
        }
        this.io = jSONObject.optInt("if_sample", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (jSONObjectOptJSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObjectOptJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                            this.uf.put(next, strOptString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void gz(JSONObject jSONObject) {
        this.sy.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                if (jSONArrayOptJSONArray.get(i) != null) {
                                    arrayList.add(jSONArrayOptJSONArray.get(i).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.sy.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String fo(JSONObject jSONObject) {
        this.q.clear();
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("ad_event_control")) {
                this.q.put("ad_event_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_banner_control")) {
                this.q.put("type_banner_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interaction_control")) {
                this.q.put("type_interaction_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interactionfull_control")) {
                this.q.put("type_interactionfull_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_splash_control")) {
                this.q.put("type_splash_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_feed_control")) {
                this.q.put("type_feed_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_reward_control")) {
                this.q.put("type_reward_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_full_control")) {
                this.q.put("type_full_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_native_control")) {
                this.q.put("type_native_control", Boolean.TRUE);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void uy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.un.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.un.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private void kb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ti.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.ti.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    public String uy() {
        if (this.dl == null) {
            this.dl = com.bytedance.msdk.e.z.z().g("etag");
        }
        return this.dl;
    }

    public String kb() {
        return this.ls;
    }

    public boolean wp() {
        return this.i == 1;
    }

    public String i() {
        return this.v;
    }

    public void a(String str) {
        try {
            l lVarZ = com.bytedance.msdk.e.z.z();
            if ("2".equals(str)) {
                this.q.put("active_control", Boolean.TRUE);
                lVarZ.z("all_active_control", true);
            } else {
                this.q.put("active_control", Boolean.FALSE);
                lVarZ.z("all_active_control", false);
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private boolean lw() {
        Boolean bool = this.q.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean v() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("ad_event_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean z(int i) {
        if (!lw()) {
            return false;
        }
        if (i == 1) {
            return pf();
        }
        if (i == 2) {
            return ls();
        }
        if (i == 3) {
            return fv();
        }
        if (i == 5) {
            return js() && iq();
        }
        if (i == 10) {
            return p();
        }
        if (i == 7) {
            return tb();
        }
        if (i != 8) {
            return true;
        }
        return q();
    }

    public boolean pf() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("type_banner_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean ls() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("type_interaction_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean p() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("type_interactionfull_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean fv() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("type_splash_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean js() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("type_feed_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean tb() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("type_reward_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean q() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("type_full_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean iq() {
        if (!lw()) {
            return false;
        }
        Boolean bool = this.q.get("type_native_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean zw() {
        return this.uy > 0;
    }

    public boolean io() {
        try {
            return Integer.valueOf(this.kb).intValue() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean uf() {
        return Integer.valueOf(this.kb).intValue() > 1;
    }

    public int sy() {
        return com.bytedance.msdk.e.z.z.z().g();
    }

    public long hh() {
        return com.bytedance.msdk.e.z.z.z().dl();
    }

    public boolean l() {
        return (com.bytedance.msdk.e.z.dl.z().dl() || com.bytedance.msdk.e.z.g.z().a()) ? false : true;
    }

    public boolean h() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.z.kb().wp())) {
            return false;
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit: " + e());
        if (!com.bytedance.msdk.e.z.dl.z().dl() && e()) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 1");
            return true;
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 2");
        return false;
    }

    public List<String> z(List<String> list) {
        if (list != null && list.size() > 0) {
            if (com.bytedance.msdk.e.z.dl.z().dl()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (com.bytedance.msdk.e.z.dl.z().z(str, 0, 101) == null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public void z(ls lsVar) {
        if (lsVar == null) {
            return;
        }
        if (h()) {
            lsVar.z();
            return;
        }
        synchronized (this.tb) {
            if (!this.tb.contains(lsVar)) {
                this.tb.add(lsVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        com.bytedance.msdk.core.kb.z.z().gc();
        if (h()) {
            Iterator<ls> it = this.tb.iterator();
            while (it.hasNext()) {
                it.next().z();
            }
            this.tb.clear();
        }
    }

    public void g(int i) {
        this.js = i;
    }

    public boolean gk() {
        if (this.js == Integer.MAX_VALUE) {
            this.js = 1;
        }
        return this.js == 1;
    }

    public boolean x() {
        return this.io == 1;
    }

    public Map<String, String> lq() {
        return this.uf;
    }

    public Map<String, List<String>> mc() {
        return this.sy;
    }

    public double un() {
        return this.hh;
    }

    public boolean ti() {
        return this.na == 1;
    }

    public boolean eo() {
        return this.xl == 1;
    }

    public boolean oq() {
        return this.ec == 1;
    }

    public com.bytedance.msdk.core.g.g wj() {
        return this.j;
    }

    public com.bytedance.msdk.core.dl.g na() {
        if (oq()) {
            return this.bv;
        }
        return null;
    }

    public boolean xl() {
        return this.h == 1;
    }

    public int j() {
        return this.h;
    }

    public void dl(int i) {
        this.h = i;
    }

    public Map<String, com.bytedance.msdk.core.uy.dl> gp() {
        return this.gk;
    }

    public boolean t() {
        return this.oq == 1;
    }

    public String vm() {
        return this.wj;
    }

    public boolean y() {
        return this.x == 1;
    }

    public boolean z(long j) {
        return j < ((long) this.z);
    }

    public int ec() {
        return this.z;
    }

    public a gc(String str) {
        return this.mc.get(str);
    }

    public List<com.bytedance.msdk.core.uy.dl> m(String str) {
        return this.lq.get(str);
    }

    public int bv() {
        com.bytedance.msdk.core.g.g gVar = this.j;
        if (gVar != null) {
            return gVar.z();
        }
        return 0;
    }

    public Map<String, Integer> gb() {
        return this.un;
    }

    public Map<String, Integer> jq() {
        return this.ti;
    }

    public int sv() {
        return this.gp;
    }

    public int f() {
        return this.t;
    }

    public boolean yx() {
        com.bytedance.msdk.z.gc.dl.g("TMe", "enable_bid_result_return = " + this.vm);
        com.bytedance.msdk.z.gc.dl.g("TMe", "enable_bid_result_return_for_baidu = " + this.y);
        return qd() || zx();
    }

    public boolean qd() {
        return this.vm == 1 && this.y == 1;
    }

    public boolean zx() {
        return this.vm == 1 && this.y == 2;
    }

    public boolean b() {
        com.bytedance.msdk.z.gc.dl.g("TMe", "enable_bid_result_return = " + this.vm);
        com.bytedance.msdk.z.gc.dl.g("TMe", "enable_bid_result_return_for_ks = " + this.gb);
        return this.vm == 1 && this.gb == 1;
    }
}
