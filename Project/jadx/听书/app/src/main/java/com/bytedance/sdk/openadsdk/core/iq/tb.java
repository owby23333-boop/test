package com.bytedance.sdk.openadsdk.core.iq;

import androidx.media3.extractor.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1197a;
    private int dl;
    private int e;
    private int fo;
    private int fv;
    private int g;
    private int gc;
    private int gz;
    private int i;
    private int js;
    private int kb;
    private int ls;
    private int m;
    private int p;
    private int pf;
    private String q;
    private String tb;
    private int uy;
    private int v;
    private int wp;
    private int z;

    public static boolean z(na naVar) {
        tb tbVarIq = iq(naVar);
        return tbVarIq != null && tbVarIq.ls == 1;
    }

    private static tb iq(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.dt();
    }

    public static int g(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 0;
        }
        return tbVarIq.a();
    }

    public static String dl(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return "close_obm";
        }
        int iA = tbVarIq.a();
        String strPo = naVar.po();
        return (iA != 1 || strPo == null) ? "close_" + iA + "_" + strPo : TtmlNode.TEXT_EMPHASIS_MARK_OPEN;
    }

    public static int a(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 1;
        }
        return tbVarIq.m;
    }

    public static int gc(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 0;
        }
        return tbVarIq.e;
    }

    public static int m(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return -1;
        }
        return tbVarIq.kb;
    }

    public static boolean e(na naVar) {
        tb tbVarIq = iq(naVar);
        return tbVarIq != null && tbVarIq.gz == 1;
    }

    public static boolean gz(na naVar) {
        tb tbVarIq = iq(naVar);
        return tbVarIq != null && tbVarIq.fo == 1;
    }

    public static int fo(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 300;
        }
        return tbVarIq.uy;
    }

    public static boolean uy(na naVar) {
        tb tbVarIq = iq(naVar);
        return tbVarIq != null && tbVarIq.wp == 1;
    }

    public static int kb(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 0;
        }
        return tbVarIq.z;
    }

    public static int wp(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 1;
        }
        return tbVarIq.g;
    }

    public static int i(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 1;
        }
        return tbVarIq.dl;
    }

    public static int v(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 1;
        }
        return tbVarIq.f1197a;
    }

    public static int pf(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 1;
        }
        return tbVarIq.i;
    }

    public static int ls(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 31457280;
        }
        return tbVarIq.v * 1048576;
    }

    public static boolean p(na naVar) {
        tb tbVarIq = iq(naVar);
        return tbVarIq != null && tbVarIq.pf == 1;
    }

    public static int fv(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 1;
        }
        return tbVarIq.gc;
    }

    public static int js(na naVar) {
        tb tbVarIq = iq(naVar);
        if (tbVarIq == null) {
            return 0;
        }
        return tbVarIq.p;
    }

    public static String tb(na naVar) {
        tb tbVarIq = iq(naVar);
        return tbVarIq == null ? "" : tbVarIq.tb;
    }

    public static String q(na naVar) {
        tb tbVarIq = iq(naVar);
        return tbVarIq == null ? "" : tbVarIq.q;
    }

    public tb(JSONObject jSONObject) {
        this.z = 0;
        this.g = 1;
        this.dl = 1;
        this.f1197a = 1;
        this.gc = 1;
        this.m = 1;
        this.e = 0;
        this.gz = 0;
        this.fo = 0;
        this.uy = 300;
        this.kb = -1;
        this.wp = 1;
        this.i = 1;
        this.v = 31457280;
        this.pf = 0;
        this.ls = 0;
        this.p = 0;
        this.fv = 0;
        this.js = 0;
        if (jSONObject == null) {
            return;
        }
        this.m = jSONObject.optInt("auto_open", 1);
        this.e = jSONObject.optInt("download_mode", 0);
        this.gz = jSONObject.optInt("auto_control", 0);
        this.fo = jSONObject.optInt("auto_control_choose", 0);
        this.uy = jSONObject.optInt("auto_control_time", 300);
        this.kb = jSONObject.optInt("download_type", -1);
        this.wp = jSONObject.optInt("if_suspend_download", 1);
        this.z = jSONObject.optInt("if_send_click", 0);
        this.g = jSONObject.optInt("dl_popup", 1);
        this.dl = jSONObject.optInt("market_popup", 1);
        this.f1197a = jSONObject.optInt("if_pop_lp", 1);
        this.gc = jSONObject.optInt("pop_up_style_id", 1);
        this.i = jSONObject.optInt("dl_network", 1);
        this.v = jSONObject.optInt("dl_size", 31457280);
        this.pf = jSONObject.optInt("if_toast_market", 0);
        this.ls = jSONObject.optInt("enable_download_opt", 0);
        if (com.bytedance.sdk.openadsdk.core.multipro.g.dl()) {
            this.p = 0;
        } else {
            this.p = jSONObject.optInt("dl_suspend_popup", 0);
        }
        this.fv = jSONObject.optInt("is_use_obm_convert", 0);
        this.js = jSONObject.optInt("enable_notification", 0);
        this.tb = jSONObject.optString("ugen_url");
        String strOptString = jSONObject.optString("ugen_md5");
        this.q = strOptString;
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z(this.tb, strOptString, (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
    }

    public int z() {
        return this.g;
    }

    public int g() {
        return this.e;
    }

    public boolean dl() {
        return this.wp == 1;
    }

    public int a() {
        return this.fv;
    }

    public int gc() {
        return this.p;
    }

    public void z(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("auto_open", this.m);
            jSONObject2.put("download_mode", this.e);
            jSONObject2.put("download_type", this.kb);
            jSONObject2.put("auto_control", this.gz);
            jSONObject2.put("auto_control_choose", this.fo);
            jSONObject2.put("auto_control_time", this.uy);
            jSONObject2.put("if_suspend_download", this.wp);
            jSONObject2.put("if_send_click", this.z);
            jSONObject2.put("dl_popup", this.g);
            jSONObject2.put("market_popup", this.dl);
            jSONObject2.put("if_pop_lp", this.f1197a);
            jSONObject2.put("pop_up_style_id", this.gc);
            jSONObject2.put("dl_network", this.i);
            jSONObject2.put("dl_size", this.v);
            jSONObject2.put("if_toast_market", this.pf);
            jSONObject2.put("enable_download_opt", this.ls);
            jSONObject2.put("dl_suspend_popup", this.p);
            jSONObject2.put("is_use_obm_convert", this.fv);
            jSONObject2.put("ugen_url", this.tb);
            jSONObject2.put("ugen_md5", this.q);
            jSONObject2.put("enable_notification", this.js);
            jSONObject.put("download_conf", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
