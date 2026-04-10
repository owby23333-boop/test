package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1175a;
    private int dl;
    private boolean e;
    private String fo;
    private int g;
    private int gc;
    private String gz;
    private int m;
    private int uy;
    private String z;

    public js(JSONObject jSONObject) {
        this.g = 0;
        if (jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("reward_browse_type", 0);
        this.g = iOptInt;
        if (iOptInt < 0 || iOptInt > 3) {
            this.g = 0;
        }
        if (this.g == 2) {
            this.g = 3;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
        if (jSONObjectOptJSONObject != null) {
            this.z = jSONObjectOptJSONObject.optString("direct_landing_url");
            this.dl = jSONObjectOptJSONObject.optInt("display_duration", 0);
            this.f1175a = jSONObjectOptJSONObject.optInt("close_time", 0);
            this.gc = jSONObjectOptJSONObject.optInt("page_type");
            this.m = jSONObjectOptJSONObject.optInt("show_type");
            this.e = jSONObjectOptJSONObject.optBoolean("is_landing_with_sound", false);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_browse_banner");
            if (jSONObjectOptJSONObject2 != null) {
                this.gz = jSONObjectOptJSONObject2.optString("ugen_url");
                this.fo = jSONObjectOptJSONObject2.optString("ugen_md5");
            }
            this.uy = jSONObjectOptJSONObject.optInt("close_btn_position");
        }
    }

    public void z(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.g);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.z);
            jSONObject2.put("display_duration", this.dl);
            jSONObject2.put("close_time", this.f1175a);
            jSONObject2.put("page_type", this.gc);
            jSONObject2.put("show_type", this.m);
            jSONObject2.put("close_btn_position", this.uy);
            jSONObject2.put("is_landing_with_sound", this.e);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.gz);
            jSONObject3.put("ugen_md5", this.fo);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    public static boolean z(na naVar) {
        js jsVarLs = ls(naVar);
        return (jsVarLs == null || gz(naVar) == 0 || TextUtils.isEmpty(jsVarLs.z)) ? false : true;
    }

    public static boolean g(na naVar) {
        if (z(naVar)) {
            return e(naVar);
        }
        return false;
    }

    public static boolean dl(na naVar) {
        js jsVarLs = ls(naVar);
        return jsVarLs != null && jsVarLs.g == 1 && jsVarLs.gc == 1;
    }

    public static boolean a(na naVar) {
        js jsVarLs = ls(naVar);
        return jsVarLs != null && z(naVar) && jsVarLs.g == 1 && jsVarLs.gc == 2;
    }

    public static boolean gc(na naVar) {
        js jsVarLs = ls(naVar);
        return jsVarLs != null && jsVarLs.m == 3;
    }

    public static String m(na naVar) {
        js jsVarLs = ls(naVar);
        return jsVarLs == null ? "" : jsVarLs.z;
    }

    public static boolean e(na naVar) {
        js jsVarLs = ls(naVar);
        if (jsVarLs == null) {
            return false;
        }
        return jsVarLs.e;
    }

    public static int gz(na naVar) {
        js jsVarLs = ls(naVar);
        if (jsVarLs == null) {
            return 0;
        }
        return jsVarLs.g;
    }

    private static js ls(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.jq();
    }

    public static int fo(na naVar) {
        int i;
        js jsVarLs = ls(naVar);
        if (jsVarLs != null && (i = jsVarLs.dl) >= 0) {
            return i;
        }
        return 0;
    }

    public static int uy(na naVar) {
        int i;
        js jsVarLs = ls(naVar);
        if (jsVarLs != null && (i = jsVarLs.f1175a) >= 0) {
            return i;
        }
        return 0;
    }

    public static boolean kb(na naVar) {
        return ls(naVar) != null && gz(naVar) == 3 && z(naVar);
    }

    public static com.bytedance.sdk.openadsdk.core.ugeno.m.z wp(na naVar) {
        js jsVarLs = ls(naVar);
        if (jsVarLs == null || TextUtils.isEmpty(jsVarLs.gz)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.z();
        zVar.dl(jsVarLs.gz);
        zVar.g(jsVarLs.fo);
        zVar.z(jsVarLs.gz);
        return zVar;
    }

    public static boolean i(na naVar) {
        js jsVarLs = ls(naVar);
        return jsVarLs != null && jsVarLs.uy == 1;
    }

    public static boolean v(na naVar) {
        js jsVarLs = ls(naVar);
        return jsVarLs != null && jsVarLs.uy == 2;
    }

    public static int pf(na naVar) {
        js jsVarLs = ls(naVar);
        if (jsVarLs == null) {
            return 0;
        }
        return jsVarLs.uy;
    }
}
