package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class qd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1190a;
    private int dl;
    private int e;
    private int g;
    private String gc;
    private boolean m;
    private boolean z;

    public qd(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("splash_card")) == null) {
            return;
        }
        this.m = true;
        this.z = jSONObjectOptJSONObject.optBoolean("click_on_close", false);
        this.g = jSONObjectOptJSONObject.optInt("card_stay_count_down", 5);
        this.dl = jSONObjectOptJSONObject.optInt("card_click_area", 2);
        this.gc = jSONObjectOptJSONObject.optString("card_text", "详情页或第三方应用");
        int iOptInt = jSONObjectOptJSONObject.optInt("splash_card_style_id", 0);
        this.e = iOptInt;
        if (iOptInt == 1) {
            this.f1190a = jSONObjectOptJSONObject.optString("card_top_text", "摇一摇或点击了解更多");
        } else {
            this.f1190a = jSONObjectOptJSONObject.optString("card_top_text", "点击跳转");
        }
    }

    public void z(JSONObject jSONObject) {
        try {
            if (this.m) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_on_close", this.z);
                jSONObject2.put("card_stay_count_down", this.g);
                jSONObject2.put("card_click_area", this.dl);
                jSONObject2.put("card_text", this.gc);
                jSONObject2.put("card_top_text", this.f1190a);
                jSONObject2.put("splash_card_style_id", this.e);
                jSONObject.put("splash_card", jSONObject2);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public static boolean z(na naVar) {
        qd qdVarUy = uy(naVar);
        if (qdVarUy != null && !naVar.jh() && naVar.zr() != 2 && qdVarUy.m && g() < com.bytedance.sdk.openadsdk.core.zw.g().mt() && fo(naVar)) {
            return qdVarUy.m;
        }
        return false;
    }

    public static void g(na naVar) {
        qd qdVarUy = uy(naVar);
        if (qdVarUy == null || naVar.jh() || naVar.zr() == 2 || !qdVarUy.m || g() >= com.bytedance.sdk.openadsdk.core.zw.g().mt()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a.dl(naVar, "splash_ad", "if_splash_card");
        if (fo(naVar)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a.dl(naVar, "splash_ad", "card_show_fail");
    }

    public static String dl(na naVar) {
        qd qdVarUy = uy(naVar);
        return (qdVarUy == null || TextUtils.isEmpty(qdVarUy.gc)) ? "详情页或第三方应用" : qdVarUy.gc;
    }

    public static String a(na naVar) {
        qd qdVarUy = uy(naVar);
        return qdVarUy == null ? "点击跳转" : gc(naVar) == 1 ? TextUtils.isEmpty(qdVarUy.f1190a) ? "摇一摇或点击了解更多" : qdVarUy.f1190a : TextUtils.isEmpty(qdVarUy.f1190a) ? "点击跳转" : qdVarUy.f1190a;
    }

    public static int gc(na naVar) {
        qd qdVarUy = uy(naVar);
        if (qdVarUy == null) {
            return 0;
        }
        return qdVarUy.e;
    }

    public static int m(na naVar) {
        int i;
        qd qdVarUy = uy(naVar);
        if (qdVarUy != null && (i = qdVarUy.g) > 0 && i <= 5) {
            return i;
        }
        return 5;
    }

    public static boolean e(na naVar) {
        qd qdVarUy = uy(naVar);
        return qdVarUy == null || qdVarUy.dl == 1;
    }

    public static boolean gz(na naVar) {
        qd qdVarUy = uy(naVar);
        if (qdVarUy == null) {
            return true;
        }
        return qdVarUy.z;
    }

    private static qd uy(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.sv();
    }

    public static void z() {
        int i = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.un.x.z(null);
        int i2 = dlVarZ.get("splash_card_show_day", -1) == i ? dlVarZ.get("splash_card_show_count", 0) : 0;
        dlVarZ.put("splash_card_show_day", i);
        dlVarZ.put("splash_card_show_count", i2 + 1);
    }

    public static int g() {
        int i = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.un.x.z(null);
        int i2 = dlVarZ.get("splash_card_show_day", -1);
        int i3 = dlVarZ.get("splash_card_show_count", 0);
        if (i2 == i) {
            return i3;
        }
        return 0;
    }

    public static boolean fo(na naVar) {
        if (naVar == null || naVar.kp() == null || !naVar.kp().gc() || naVar.jz() == null || naVar.jz().isEmpty() || !naVar.jz().get(0).gc() || TextUtils.isEmpty(naVar.li())) {
            return false;
        }
        if (TextUtils.isEmpty(naVar.hy())) {
            return (naVar.c() == null || TextUtils.isEmpty(naVar.c().dl())) ? false : true;
        }
        return true;
    }
}
