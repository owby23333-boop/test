package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1154a;
    private String dl;
    private int g;
    private int gc;
    private boolean m;
    private int z;

    public ec(JSONObject jSONObject) {
        this.m = false;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live");
        if (jSONObjectOptJSONObject != null) {
            this.m = true;
            g(jSONObjectOptJSONObject.optInt("reward_live_type", 1));
            dl(jSONObjectOptJSONObject.optInt("reward_live_style", 1));
            z(jSONObjectOptJSONObject.optString("reward_live_text"));
            z(jSONObjectOptJSONObject.optInt("reward_start_time", 5));
            a(jSONObjectOptJSONObject.optInt("reward_close_time", 10));
        }
    }

    public void z(JSONObject jSONObject) {
        if (this.m) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_live_type", this.z);
                jSONObject2.put("reward_live_style", this.g);
                jSONObject2.put("reward_live_text", this.dl);
                jSONObject2.put("reward_start_time", this.f1154a);
                jSONObject2.put("reward_close_time", this.gc);
                jSONObject.put("reward_live", jSONObject2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    public static boolean z(na naVar) {
        ec ecVarFo = fo(naVar);
        if (ecVarFo == null) {
            return false;
        }
        return ecVarFo.m;
    }

    public static int g(na naVar) {
        ec ecVarFo = fo(naVar);
        if (ecVarFo == null) {
            return 1;
        }
        return ecVarFo.z;
    }

    public static boolean dl(na naVar) {
        ec ecVarFo = fo(naVar);
        return ecVarFo == null || !ecVarFo.m || ecVarFo.z == 1;
    }

    public static boolean a(na naVar) {
        int i;
        ec ecVarFo = fo(naVar);
        return ecVarFo != null && ecVarFo.m && com.bytedance.sdk.openadsdk.core.live.g.z().z(naVar) && ((i = ecVarFo.z) == 3 || i == 4);
    }

    private void g(int i) {
        if (i != 2 && i != 3 && i != 4 && i != 1) {
            i = 1;
        }
        this.z = i;
    }

    public static int gc(na naVar) {
        ec ecVarFo = fo(naVar);
        if (ecVarFo == null) {
            return 1;
        }
        return ecVarFo.g;
    }

    private void dl(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 1;
        }
        this.g = i;
    }

    public static String m(na naVar) {
        ec ecVarFo = fo(naVar);
        return ecVarFo == null ? "去抖音观看直播\n可提前5s获得奖励哦" : ecVarFo.dl;
    }

    private void z(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.g == 3 ? "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦" : "去抖音观看直播\n可提前5s获得奖励哦";
        }
        this.dl = str;
    }

    public static int e(na naVar) {
        ec ecVarFo = fo(naVar);
        if (ecVarFo == null) {
            return 5;
        }
        return Math.max(ecVarFo.f1154a, 0);
    }

    public void z(int i) {
        this.f1154a = i;
    }

    public static int gz(na naVar) {
        ec ecVarFo = fo(naVar);
        if (ecVarFo == null) {
            return 10;
        }
        return Math.max(ecVarFo.gc, 3);
    }

    private void a(int i) {
        if (i <= 3) {
            i = 3;
        }
        this.gc = i;
    }

    private static ec fo(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.ao();
    }
}
