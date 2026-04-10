package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1206a;
    private boolean dl;
    private boolean e;
    private int fo;
    private int g;
    private int gc;
    private int gz;
    private int i;
    private String kb;
    private boolean ls;
    private int m;
    private int pf;
    private int uy;
    private boolean v;
    private String wp;
    private boolean z;

    public y(JSONObject jSONObject) {
        this.uy = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_draw");
        if (jSONObjectOptJSONObject != null) {
            this.g = jSONObjectOptJSONObject.optInt("max_draw_play_time", 10);
            this.f1206a = jSONObjectOptJSONObject.optInt("draw_rewarded_play_time", 30);
            this.gc = jSONObjectOptJSONObject.optInt("skip_btn_left_style", 0);
            this.m = jSONObjectOptJSONObject.optInt("skip_btn_right_style", 0);
            this.e = jSONObjectOptJSONObject.optBoolean("auto_slide", false);
            this.gz = jSONObjectOptJSONObject.optInt("show_time_type", 0);
            this.fo = jSONObjectOptJSONObject.optInt("tip_time", 0);
            this.uy = jSONObjectOptJSONObject.optInt("show_type", 0);
            this.dl = jSONObjectOptJSONObject.optBoolean("single_max_countdown", false);
            this.kb = jSONObjectOptJSONObject.optString("top_template_url");
            this.wp = jSONObjectOptJSONObject.optString("top_template_md5");
            this.i = jSONObjectOptJSONObject.optInt("top_template_timeout");
            this.v = jSONObjectOptJSONObject.optBoolean("can_cancel");
            this.pf = jSONObjectOptJSONObject.optInt("init_status_time", 0);
            this.ls = jSONObjectOptJSONObject.optBoolean("is_pause_tip_by_express", false);
        } else {
            this.g = 10;
            this.f1206a = 30;
        }
        if (jSONObject.optJSONObject(d.K) != null) {
            this.z = !TextUtils.isEmpty(r6.optString("group_id"));
        }
    }

    public void z(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.g);
            jSONObject2.put("draw_rewarded_play_time", this.f1206a);
            jSONObject2.put("skip_btn_left_style", this.gc);
            jSONObject2.put("skip_btn_right_style", this.m);
            jSONObject2.put("auto_slide", this.e);
            jSONObject2.put("show_time_type", this.gz);
            jSONObject2.put("show_type", this.uy);
            jSONObject2.put("tip_time", this.fo);
            jSONObject2.put("single_max_countdown", this.dl);
            jSONObject2.put("top_template_url", this.kb);
            jSONObject2.put("top_template_md5", this.wp);
            jSONObject2.put("top_template_timeout", this.i);
            jSONObject2.put("can_cancel", this.v);
            jSONObject2.put("init_status_time", this.pf);
            jSONObject2.put("is_pause_tip_by_express", this.ls);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private static y p(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.fy();
    }

    public static boolean z(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return false;
        }
        return yVarP.z;
    }

    public static int g(na naVar) {
        int i;
        y yVarP = p(naVar);
        if (yVarP != null && (i = yVarP.g) > 0) {
            return i;
        }
        return 10;
    }

    public static int dl(na naVar) {
        int i;
        y yVarP = p(naVar);
        if (yVarP != null && (i = yVarP.f1206a) > 0) {
            return i;
        }
        return 30;
    }

    public static int a(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return 0;
        }
        return yVarP.gc;
    }

    public static int gc(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return 0;
        }
        return yVarP.m;
    }

    public static boolean m(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return false;
        }
        return yVarP.e;
    }

    public static int e(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return 10;
        }
        if (yVarP.gz == 1) {
            return Math.min((int) Math.max(tf.m(naVar), dl(naVar)), 60);
        }
        return dl(naVar);
    }

    public static boolean gz(na naVar) {
        y yVarP = p(naVar);
        return yVarP != null && z(naVar) && yVarP.uy == 1;
    }

    public static int fo(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return 25;
        }
        return yVarP.fo;
    }

    public static boolean uy(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return false;
        }
        return yVarP.dl;
    }

    public static String kb(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return null;
        }
        return yVarP.kb;
    }

    public static String wp(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return null;
        }
        return yVarP.wp;
    }

    public static int i(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return 0;
        }
        return yVarP.i;
    }

    public static boolean v(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return false;
        }
        return yVarP.v;
    }

    public static int pf(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return 0;
        }
        return yVarP.pf;
    }

    public static boolean ls(na naVar) {
        y yVarP = p(naVar);
        if (yVarP == null) {
            return false;
        }
        return yVarP.ls;
    }
}
