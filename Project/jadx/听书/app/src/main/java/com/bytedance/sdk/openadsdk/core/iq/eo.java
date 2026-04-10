package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1155a;
    private int dl;
    private String e;
    private int fo;
    private String g;
    private String gc;
    private String gz;
    private boolean i;
    private int kb;
    private String m;
    private int uy;
    private int wp;
    private int z;

    public eo(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_ad")) == null) {
            return;
        }
        this.i = true;
        z(jSONObjectOptJSONObject.optInt("live_show_time", 60));
        this.g = jSONObjectOptJSONObject.optString("live_author_nickname");
        this.dl = jSONObjectOptJSONObject.optInt("live_author_follower_count", -1);
        this.f1155a = jSONObjectOptJSONObject.optInt("live_watch_count", -1);
        this.gc = jSONObjectOptJSONObject.optString("live_description");
        this.m = jSONObjectOptJSONObject.optString("live_feed_url");
        this.e = jSONObjectOptJSONObject.optString("live_cover_image_url");
        this.gz = jSONObjectOptJSONObject.optString("live_avatar_url");
        this.fo = jSONObjectOptJSONObject.optInt("live_avatar_width");
        this.uy = jSONObjectOptJSONObject.optInt("live_avatar_height");
        this.kb = jSONObjectOptJSONObject.optInt("live_cover_width");
        this.wp = jSONObjectOptJSONObject.optInt("live_cover_height");
    }

    public boolean z() {
        return this.i;
    }

    public void z(JSONObject jSONObject) {
        if (this.i) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("live_show_time", this.z);
                jSONObject2.put("live_author_nickname", this.g);
                jSONObject2.put("live_author_follower_count", this.dl);
                jSONObject2.put("live_watch_count", this.f1155a);
                jSONObject2.put("live_description", this.gc);
                jSONObject2.put("live_feed_url", this.m);
                jSONObject2.put("live_cover_image_url", this.e);
                jSONObject2.put("live_avatar_url", this.gz);
                jSONObject2.put("live_cover_width", this.kb);
                jSONObject2.put("live_cover_height", this.wp);
                jSONObject2.put("live_avatar_width", this.fo);
                jSONObject2.put("live_avatar_height", this.uy);
                jSONObject.put("live_ad", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private static eo v(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.bf();
    }

    public static boolean z(na naVar) {
        eo eoVarV = v(naVar);
        if (eoVarV == null) {
            return false;
        }
        return eoVarV.i;
    }

    public static int g(na naVar) {
        eo eoVarV = v(naVar);
        if (eoVarV == null) {
            return 0;
        }
        return eoVarV.z;
    }

    public void z(int i) {
        if (i <= 0 || i > 300) {
            i = 60;
        }
        this.z = i;
    }

    public static String dl(na naVar) {
        eo eoVarV = v(naVar);
        return eoVarV == null ? "" : eoVarV.g;
    }

    public static int a(na naVar) {
        eo eoVarV = v(naVar);
        if (eoVarV == null) {
            return 0;
        }
        return eoVarV.dl;
    }

    public static int gc(na naVar) {
        eo eoVarV = v(naVar);
        if (eoVarV == null) {
            return 0;
        }
        return eoVarV.f1155a;
    }

    public static String m(na naVar) {
        eo eoVarV = v(naVar);
        return eoVarV == null ? "" : eoVarV.gc;
    }

    public static String e(na naVar) {
        eo eoVarV = v(naVar);
        return eoVarV == null ? "" : eoVarV.m;
    }

    public static String gz(na naVar) {
        eo eoVarV = v(naVar);
        return eoVarV == null ? "" : eoVarV.e;
    }

    public static String fo(na naVar) {
        eo eoVarV = v(naVar);
        return eoVarV == null ? "" : eoVarV.gz;
    }

    public static int uy(na naVar) {
        eo eoVarV = v(naVar);
        if (eoVarV == null) {
            return 0;
        }
        return eoVarV.fo;
    }

    public static int kb(na naVar) {
        eo eoVarV = v(naVar);
        if (eoVarV == null) {
            return 0;
        }
        return eoVarV.uy;
    }

    public static int wp(na naVar) {
        eo eoVarV = v(naVar);
        if (eoVarV == null) {
            return 0;
        }
        return eoVarV.kb;
    }

    public static int i(na naVar) {
        eo eoVarV = v(naVar);
        if (eoVarV == null) {
            return 0;
        }
        return eoVarV.wp;
    }
}
