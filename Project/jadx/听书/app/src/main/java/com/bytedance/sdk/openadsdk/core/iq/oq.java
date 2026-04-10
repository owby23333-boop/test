package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class oq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1187a;
    private boolean dl;
    private JSONArray e;
    private g fo;
    private boolean g;
    private String gc;
    private int gz;
    private String m;
    private z uy;
    private String z;

    public static oq z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        oq oqVar = new oq();
        oqVar.z = jSONObject.optString("promotion_id");
        oqVar.g = jSONObject.optBoolean("is_silent_auth", false);
        oqVar.dl = jSONObject.optBoolean("enable_playable_auth", false);
        oqVar.f1187a = jSONObject.optString("aweme_agreements");
        oqVar.gc = jSONObject.optString("aweme_privacy");
        oqVar.m = jSONObject.optString("live_csj_libra_param");
        oqVar.e = jSONObject.optJSONArray("tasks");
        oqVar.gz = jSONObject.optInt("live_playable");
        oqVar.uy = z.z(jSONObject.optJSONObject("product"));
        oqVar.fo = g.z(jSONObject.optJSONObject("coupon"));
        return oqVar;
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.z);
            jSONObject.put("is_silent_auth", this.g);
            jSONObject.put("enable_playable_auth", this.dl);
            jSONObject.put("aweme_agreements", this.f1187a);
            jSONObject.put("aweme_privacy", this.gc);
            jSONObject.put("live_csj_libra_param", this.m);
            jSONObject.put("tasks", this.e);
            jSONObject.put("live_playable", this.gz);
            z zVar = this.uy;
            if (zVar != null) {
                jSONObject.put("product", zVar.gc());
            }
            g gVar = this.fo;
            if (gVar != null) {
                jSONObject.put("coupon", gVar.dl());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    public String g() {
        return this.z;
    }

    public boolean dl() {
        return this.g;
    }

    public boolean a() {
        return this.dl;
    }

    public String gc() {
        return this.f1187a;
    }

    public String m() {
        return this.gc;
    }

    public String e() {
        return this.m;
    }

    public JSONArray gz() {
        return this.e;
    }

    public boolean fo() {
        return this.gz == 2 && this.dl;
    }

    public g uy() {
        return this.fo;
    }

    public z kb() {
        return this.uy;
    }

    public static class g {
        int g;
        int z;

        public static g z(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            g gVar = new g();
            gVar.z = jSONObject.optInt("amount");
            gVar.g = jSONObject.optInt("threshold");
            return gVar;
        }

        public int z() {
            return this.z;
        }

        public int g() {
            return this.g;
        }

        public JSONObject dl() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("amount", this.z);
                jSONObject.put("threshold", this.g);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f1188a;
        double dl;
        String g;
        String z;

        public static z z(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            z zVar = new z();
            zVar.z = jSONObject.optString("title");
            zVar.g = jSONObject.optString("image");
            zVar.f1188a = jSONObject.optDouble("price");
            zVar.dl = jSONObject.optDouble("origin_price");
            return zVar;
        }

        public String z() {
            return this.z;
        }

        public String g() {
            return this.g;
        }

        public double dl() {
            return this.dl;
        }

        public double a() {
            return this.f1188a;
        }

        public JSONObject gc() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.z);
                jSONObject.put("image", this.g);
                jSONObject.put("price", this.f1188a);
                jSONObject.put("origin_price", this.dl);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }
}
