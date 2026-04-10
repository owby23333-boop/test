package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f1166a;
    private static g dl;
    private static g e;
    private static g g;
    private static g gc;
    private static g gz = new g(null);
    private static g m;
    private static g z;

    public static void z(com.bytedance.sdk.component.a.g.dl dlVar) {
        try {
            z = new g(new JSONObject(dlVar.get("cache_strategy_reward", "")));
        } catch (JSONException unused) {
        }
        try {
            g = new g(new JSONObject(dlVar.get("cache_strategy_full", "")));
        } catch (JSONException unused2) {
        }
        try {
            f1166a = new g(new JSONObject(dlVar.get("cache_strategy_banner", "")));
        } catch (JSONException unused3) {
        }
        try {
            gc = new g(new JSONObject(dlVar.get("cache_strategy_feed", "")));
        } catch (JSONException unused4) {
        }
        try {
            m = new g(new JSONObject(dlVar.get("cache_strategy_draw", "")));
        } catch (JSONException unused5) {
        }
        try {
            e = new g(new JSONObject(dlVar.get("cache_strategy_stream", "")));
        } catch (JSONException unused6) {
        }
    }

    public static void g(com.bytedance.sdk.component.a.g.dl dlVar) {
        g gVar = z;
        if (gVar != null) {
            dlVar.put("cache_strategy_reward", gVar.z());
        }
        g gVar2 = g;
        if (gVar2 != null) {
            dlVar.put("cache_strategy_full", gVar2.z());
        }
        g gVar3 = f1166a;
        if (gVar3 != null) {
            dlVar.put("cache_strategy_banner", gVar3.z());
        }
        g gVar4 = gc;
        if (gVar4 != null) {
            dlVar.put("cache_strategy_feed", gVar4.z());
        }
        g gVar5 = m;
        if (gVar5 != null) {
            dlVar.put("cache_strategy_draw", gVar5.z());
        }
        g gVar6 = e;
        if (gVar6 != null) {
            dlVar.put("cache_strategy_stream", gVar6.z());
        }
        if (dl != null) {
            com.bytedance.sdk.openadsdk.core.dl.a.z().g("cache_strategy_splash", dl.z());
        }
    }

    private static g g() {
        g gVar = z;
        return gVar == null ? new g(new JSONObject()) : gVar;
    }

    private static g dl() {
        g gVar = g;
        return gVar == null ? new g(new JSONObject()) : gVar;
    }

    private static g a() {
        g gVar = f1166a;
        return gVar == null ? new g(new JSONObject()) : gVar;
    }

    private static g gc() {
        g gVar = gc;
        return gVar == null ? new g(new JSONObject()) : gVar;
    }

    private static g m() {
        g gVar = m;
        return gVar == null ? new g(new JSONObject()) : gVar;
    }

    private static g e() {
        g gVar = e;
        return gVar == null ? new g(new JSONObject()) : gVar;
    }

    public static g z() {
        if (dl == null) {
            String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("cache_strategy_splash", (String) null);
            try {
                if (TextUtils.isEmpty(strDl)) {
                    g gVar = new g(new JSONObject());
                    dl = gVar;
                    gVar.f1168a = 0;
                } else {
                    dl = new g(new JSONObject(strDl));
                }
            } catch (JSONException unused) {
            }
        }
        return dl;
    }

    public static void z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_reward");
                if (jSONObjectOptJSONObject2 != null) {
                    z = new g(jSONObjectOptJSONObject2);
                }
            } catch (Exception e2) {
                new Object[]{e2};
            }
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_full");
                if (jSONObjectOptJSONObject3 != null) {
                    g = new g(jSONObjectOptJSONObject3);
                }
            } catch (Exception e3) {
                new Object[]{e3};
            }
            try {
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_banner");
                if (jSONObjectOptJSONObject4 != null) {
                    f1166a = new g(jSONObjectOptJSONObject4);
                }
            } catch (Exception e4) {
                new Object[]{e4};
            }
            try {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_feed");
                if (jSONObjectOptJSONObject5 != null) {
                    gc = new g(jSONObjectOptJSONObject5);
                }
            } catch (Exception e5) {
                new Object[]{e5};
            }
            try {
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_draw");
                if (jSONObjectOptJSONObject6 != null) {
                    m = new g(jSONObjectOptJSONObject6);
                }
            } catch (Exception e6) {
                new Object[]{e6};
            }
            try {
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_splash");
                if (jSONObjectOptJSONObject7 != null) {
                    dl = new g(jSONObjectOptJSONObject7);
                }
            } catch (Exception e7) {
                new Object[]{e7};
            }
            try {
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_stream");
                if (jSONObjectOptJSONObject8 != null) {
                    e = new g(jSONObjectOptJSONObject8);
                }
            } catch (Exception e8) {
                new Object[]{e8};
            }
        }
    }

    public static g z(int i) {
        switch (i) {
            case 1:
                return a();
            case 2:
            default:
                return gz;
            case 3:
            case 4:
                return z();
            case 5:
                return gc();
            case 6:
                return e();
            case 7:
                return g();
            case 8:
                return dl();
            case 9:
                return m();
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1168a;
        private int dl;
        private int e;
        private dl fo;
        private int g;
        private int gc;
        private int gz;
        private int i;
        private boolean kb;
        private boolean m;
        private int uy;
        private int v;
        private z wp;
        private int z;

        public g(JSONObject jSONObject) {
            this.kb = false;
            this.i = 1;
            this.v = 0;
            if (jSONObject != null) {
                this.z = jSONObject.optInt("get_type", 1);
                this.g = jSONObject.optInt("max_count", 1);
                this.dl = jSONObject.optInt("strategy_type", -1);
                this.f1168a = jSONObject.optInt("store_type", 1);
                this.gc = jSONObject.optInt("online_timeout", 10000);
                this.m = jSONObject.optBoolean("enable", false);
                this.e = jSONObject.optInt("load_type", -1);
                this.gz = jSONObject.optInt("trans_cache", 0);
                this.fo = new dl(jSONObject.optJSONObject("score_config"));
                this.uy = jSONObject.optInt("cache_check_type", 0);
                this.kb = jSONObject.optBoolean("disable_sdk_bidding", false);
                this.wp = new z(jSONObject.optJSONObject("control_el"));
                this.i = jSONObject.optInt("ad_count_max", 1);
                this.v = jSONObject.optInt("ad_count_complement", 0);
            }
        }

        public String z() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_type", this.z);
                jSONObject.put("max_count", this.g);
                jSONObject.put("strategy_type", this.dl);
                jSONObject.put("store_type", this.f1168a);
                jSONObject.put("online_timeout", this.gc);
                jSONObject.put("enable", this.m);
                jSONObject.put("load_type", this.e);
                jSONObject.put("trans_cache", this.gz);
                jSONObject.put("cache_check_type", this.uy);
                jSONObject.put("score_config", this.fo.z());
                jSONObject.put("disable_sdk_bidding", this.kb);
                jSONObject.put("control_el", this.wp.z());
                jSONObject.put("ad_count_max", this.i);
                jSONObject.put("ad_count_complement", this.v);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public int g() {
            return this.z;
        }

        public int dl() {
            if (this.g <= 0) {
                this.g = 1;
            }
            return this.g;
        }

        public int a() {
            return this.dl;
        }

        public int gc() {
            return this.f1168a;
        }

        public int m() {
            return this.gc;
        }

        public boolean e() {
            return this.m;
        }

        public int gz() {
            return this.e;
        }

        public int fo() {
            return this.gz;
        }

        public dl uy() {
            return this.fo;
        }

        public boolean z(na naVar) {
            Map<String, Object> mapFq;
            Object obj;
            return (!this.kb || naVar == null || (mapFq = naVar.fq()) == null || mapFq.isEmpty() || (obj = mapFq.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) ? false : true;
        }

        public boolean z(String str, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar) {
            z zVar = this.wp;
            if (zVar == null) {
                return false;
            }
            return zVar.z(str, gVar, naVar);
        }

        public int kb() {
            return Math.max(this.i, 1);
        }
    }

    public static class dl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1167a;
        private int dl;
        private int e;
        private int fo;
        private int g;
        private int gc;
        private int gz;
        private int kb;
        private LinkedHashMap<Integer, Integer> m;
        private int uy;
        private int z;

        public dl(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.z = jSONObject.optInt("device_score_threshold", 0);
                this.g = jSONObject.optInt("net_type_threshold", 0);
                this.dl = jSONObject.optInt("base_score", 60);
                this.f1167a = jSONObject.optInt("score_threshold", 60);
                this.gc = jSONObject.optInt("backup_score_threshold", 0);
                LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("last_cache_score");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        int iOptInt = jSONArrayOptJSONArray2.optInt(0);
                        int iOptInt2 = jSONArrayOptJSONArray2.optInt(1);
                        if (iOptInt > 0) {
                            linkedHashMap.put(Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2));
                        }
                    }
                }
                this.m = linkedHashMap;
                this.e = jSONObject.optInt("freq_send_score", 0);
                this.gz = jSONObject.optInt("freq_send_duration", 0);
                this.fo = jSONObject.optInt("continuous_send_score", 0);
                this.uy = jSONObject.optInt("continuous_send_count", 0);
                this.kb = jSONObject.optInt("show_score", 0);
            }
        }

        public JSONObject z() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score_threshold", this.z);
                jSONObject.put("net_type_threshold", this.g);
                jSONObject.put("base_score", this.dl);
                jSONObject.put("score_threshold", this.f1167a);
                jSONObject.put("backup_score_threshold", this.gc);
                JSONArray jSONArray = new JSONArray();
                LinkedHashMap<Integer, Integer> linkedHashMap = this.m;
                if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                    for (Integer num : this.m.keySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(num);
                        jSONArray2.put(this.m.get(num));
                        jSONArray.put(jSONArray2);
                    }
                }
                jSONObject.put("last_cache_score", jSONArray);
                jSONObject.put("freq_send_score", this.e);
                jSONObject.put("freq_send_duration", this.gz);
                jSONObject.put("continuous_send_score", this.fo);
                jSONObject.put("continuous_send_count", this.uy);
                jSONObject.put("show_score", this.kb);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int g() {
            return this.z;
        }

        public int dl() {
            return this.g;
        }

        public int a() {
            return this.f1167a;
        }

        public int gc() {
            return this.gc;
        }

        public int m() {
            return this.gz;
        }

        public int e() {
            return this.e;
        }

        public int gz() {
            return this.uy;
        }

        public int fo() {
            return this.fo;
        }

        public int uy() {
            return this.kb;
        }

        public int kb() {
            return this.dl;
        }

        public LinkedHashMap<Integer, Integer> wp() {
            return this.m;
        }
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1169a;
        private String dl;
        private String g;
        JSONObject z;

        public z(JSONObject jSONObject) {
            this.z = jSONObject;
            if (jSONObject != null) {
                this.g = jSONObject.optString("mix_ad");
                this.dl = jSONObject.optString("disable_trans_cache");
                this.f1169a = jSONObject.optString("delete_on_load");
            }
        }

        public JSONObject z() {
            return this.z;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private boolean g(String str, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar) {
            String str2;
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1085434702:
                    if (str.equals("delete_on_load")) {
                        b = 0;
                    }
                    break;
                case -1073750810:
                    if (str.equals("mix_ad")) {
                        b = 1;
                    }
                    break;
                case -883700652:
                    if (str.equals("disable_trans_cache")) {
                        b = 2;
                    }
                    break;
            }
            String strZ = null;
            switch (b) {
                case 0:
                    str2 = this.f1169a;
                    break;
                case 1:
                    str2 = !TextUtils.isEmpty(this.g) ? this.g : "${(meta.group_info.group_id != null) || (meta.insert_ad_control == 1) || (meta.refresh_ad_control == 1) || (meta.force_refresh_ad_control == 1) || (meta.refresh_control == 1)}";
                    break;
                case 2:
                    str2 = this.dl;
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            System.currentTimeMillis();
            try {
                strZ = com.bytedance.adsdk.ugeno.a.g.z(str2, z(gVar, naVar, null, null));
            } catch (Exception unused) {
            }
            return TextUtils.equals(strZ, "true");
        }

        private JSONObject z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar, JSONObject jSONObject, JSONObject jSONObject2) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("adSlot", gVar);
                if (naVar != null) {
                    jSONObject3.put("meta", naVar.kv());
                }
                jSONObject3.put("cache", jSONObject);
                jSONObject3.put(com.umeng.analytics.pro.z.f2258a, jSONObject2);
                return jSONObject3;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean z(String str, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar) {
            return g(str, gVar, naVar);
        }
    }
}
