package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gb {
    private static int dl = 0;
    private static int g = 0;
    private static long z = 27000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1161a;
    private boolean e;
    private boolean fo;
    private boolean fv;
    private int gc;
    private boolean gk;
    private double gz;
    private int h;
    private boolean hh;
    private int i;
    private boolean io;
    private int iq;
    private double js;
    private String kb;
    private boolean l;
    private boolean ls;
    private boolean m;
    private double p;
    private int pf;
    private int q;
    private jq sy;
    private int tb;
    private ArrayList<bm> uf;
    private double uy;
    private int v;
    private int wp;
    private int x;
    private boolean zw;

    public gb(JSONObject jSONObject) {
        this.iq = 0;
        this.zw = false;
        this.io = false;
        this.uf = new ArrayList<>();
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("retain_dialog_config");
            if (jSONArrayOptJSONArray != null) {
                this.uf = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null) {
                        this.uf.add(new bm(jSONObjectOptJSONObject2));
                    }
                }
            }
            this.sy = new jq(jSONObjectOptJSONObject);
            this.l = jSONObjectOptJSONObject.optBoolean("endcard_transform_enabled", false);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject3 != null) {
            this.gc = jSONObjectOptJSONObject3.optInt(MediationConstant.REWARD_AMOUNT, 0);
            this.f1161a = jSONObjectOptJSONObject3.optString(MediationConstant.REWARD_NAME, "");
            this.m = jSONObjectOptJSONObject3.optBoolean("reward_info_show", false);
            this.i = jSONObjectOptJSONObject3.optInt("reward_back_type", 0);
            this.v = jSONObjectOptJSONObject3.optInt("reward_backup_timing", 0);
            this.pf = jSONObjectOptJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.h = jSONObjectOptJSONObject3.optInt("reward_is_callback", 0);
            this.gk = jSONObjectOptJSONObject3.optBoolean("reward_need_click", false);
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("reward_advanced_config");
            if (jSONObjectOptJSONObject4 != null) {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("easy_playable");
                if (jSONObjectOptJSONObject5 != null) {
                    this.e = jSONObjectOptJSONObject5.optBoolean("enable");
                    double dOptDouble = jSONObjectOptJSONObject5.optDouble("propose_reward", 0.0d);
                    this.gz = dOptDouble;
                    if (dOptDouble < 0.0d) {
                        this.gz = 0.0d;
                    }
                }
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("play_complete");
                if (jSONObjectOptJSONObject6 != null) {
                    this.fo = jSONObjectOptJSONObject6.optBoolean("enable");
                    double dOptDouble2 = jSONObjectOptJSONObject6.optDouble("propose_reward", 0.0d);
                    this.uy = dOptDouble2;
                    if (dOptDouble2 < 0.0d) {
                        this.uy = 0.0d;
                    }
                    this.kb = jSONObjectOptJSONObject6.optString("tip_toast");
                    this.wp = jSONObjectOptJSONObject6.optInt("min_duration");
                }
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("playable_interactive");
                if (jSONObjectOptJSONObject7 != null) {
                    this.ls = jSONObjectOptJSONObject7.optBoolean("enable");
                    this.p = jSONObjectOptJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("click_landing");
                if (jSONObjectOptJSONObject8 != null) {
                    this.fv = jSONObjectOptJSONObject8.optBoolean("enable");
                    this.js = jSONObjectOptJSONObject8.optDouble("propose_reward", 0.0d);
                    this.tb = jSONObjectOptJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.q = jSONObject.optInt("reward_full_play_time", 30);
        this.iq = jSONObject.optInt("reward_full_time_type", 0);
        this.hh = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.x = jSONObject.optInt("template_sign", 0);
        this.zw = jSONObject.optBoolean("__is_use_local_time", false);
        this.io = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    public static void z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                z = jSONObjectOptJSONObject.optLong("reward_time_limited", 27000L);
                g = jSONObjectOptJSONObject.optInt("reward_force_close_max_count", 0);
                dl = jSONObjectOptJSONObject.optInt("reward_local_countdown_close_style", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static void z(com.bytedance.sdk.component.a.g.dl dlVar) {
        dlVar.put("reward_time_limited", z);
        dlVar.put("reward_force_close_max_count", g);
        dlVar.put("reward_local_countdown_close_style", dl);
    }

    public static void g(com.bytedance.sdk.component.a.g.dl dlVar) {
        z = dlVar.get("reward_time_limited", 27000L);
        g = dlVar.get("reward_force_close_max_count", 0);
        dl = dlVar.get("reward_local_countdown_close_style", 0);
    }

    public void g(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<bm> arrayList = this.uf;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<bm> it = this.uf.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().z());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            jq jqVar = this.sy;
            if (jqVar != null) {
                jqVar.z(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.l);
            jSONObject.put("reward", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MediationConstant.REWARD_NAME, this.f1161a);
            jSONObject3.put(MediationConstant.REWARD_AMOUNT, this.gc);
            jSONObject3.put("reward_info_show", this.m);
            jSONObject3.put("reward_back_type", this.i);
            jSONObject3.put("reward_backup_timing", this.v);
            jSONObject3.put("reward_backup_duration", this.pf);
            jSONObject3.put("reward_is_callback", this.h);
            jSONObject3.put("reward_need_click", this.gk);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("enable", this.e);
            jSONObject5.put("propose_reward", this.gz);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("enable", this.fo);
            jSONObject6.put("propose_reward", this.uy);
            jSONObject6.put("tip_toast", this.kb);
            jSONObject6.put("min_duration", this.wp);
            jSONObject4.put("play_complete", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("enable", this.ls);
            jSONObject7.put("propose_reward", this.p);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("enable", this.fv);
            jSONObject8.put("propose_reward", this.js);
            jSONObject8.put("landing_view_time", this.tb);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        try {
            jSONObject.put("reward_full_play_time", this.q);
            jSONObject.put("reward_full_time_type", this.iq);
            jSONObject.put("interstitial_bg_transparent", this.hh);
            jSONObject.put("template_sign", this.x);
            jSONObject.put("__is_use_local_time", this.zw);
            jSONObject.put("__is_click_landing_reward", this.io);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.wp.z(e3);
        }
    }

    private static gb l(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.j();
    }

    public static String z(na naVar) {
        gb gbVarL = l(naVar);
        return gbVarL == null ? "" : gbVarL.f1161a;
    }

    public static int g(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return 0;
        }
        return gbVarL.gc;
    }

    public static boolean dl(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return false;
        }
        return gbVarL.m;
    }

    public static long z() {
        return z;
    }

    public static long g() {
        return g;
    }

    public static boolean dl() {
        return dl == 1;
    }

    public static boolean a(na naVar) {
        gb gbVarL = l(naVar);
        return gbVarL != null && gbVarL.i == 1;
    }

    public static boolean gc(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return false;
        }
        return gbVarL.e;
    }

    public static double m(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return 0.0d;
        }
        return gbVarL.gz;
    }

    public static boolean e(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return false;
        }
        return gbVarL.fo;
    }

    public static double gz(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return 0.0d;
        }
        return gbVarL.uy;
    }

    public static String fo(na naVar) {
        gb gbVarL = l(naVar);
        return gbVarL == null ? "" : TextUtils.isEmpty(gbVarL.kb) ? "别急着跳过，继续观看完整视频，可获得更多额外奖励～" : gbVarL.kb;
    }

    public static int uy(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        }
        int iMax = Math.max(gbVarL.wp, 30);
        return (iMax <= 60 ? iMax : 30) * 1000;
    }

    public static boolean kb(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return false;
        }
        return gbVarL.ls;
    }

    public static double wp(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return 0.0d;
        }
        return gbVarL.p;
    }

    public static boolean i(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return false;
        }
        return gbVarL.fv;
    }

    public static int v(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return 5;
        }
        return Math.max(5, gbVarL.tb);
    }

    public static float z(na naVar, int i) {
        double dM;
        if (i == 0) {
            return 1.0f;
        }
        if (i == 1) {
            dM = m(naVar);
        } else if (i == 2) {
            dM = gz(naVar);
        } else {
            if (i != 3) {
                return 0.0f;
            }
            dM = wp(naVar);
        }
        return (float) dM;
    }

    public static int pf(na naVar) {
        int i;
        gb gbVarL = l(naVar);
        if (gbVarL != null && (i = gbVarL.q) >= 10 && i <= 60) {
            return i;
        }
        return 30;
    }

    public static int ls(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return 0;
        }
        return gbVarL.iq;
    }

    public static boolean p(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL != null && gbVarL.zw) {
            return js.a(naVar) || ls(naVar) == 1 || ls(naVar) == 2;
        }
        return false;
    }

    public static boolean fv(na naVar) {
        gb gbVarL = l(naVar);
        return gbVarL != null && gbVarL.zw && ls(naVar) == 1;
    }

    public static boolean js(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL != null && gbVarL.io) {
            return i(naVar);
        }
        return false;
    }

    public static void z(na naVar, boolean z2) {
        gb gbVarL = l(naVar);
        if (gbVarL != null) {
            gbVarL.zw = z2;
        }
    }

    public static void g(na naVar, boolean z2) {
        gb gbVarL = l(naVar);
        if (gbVarL != null) {
            gbVarL.io = z2;
        }
    }

    public static ArrayList<bm> tb(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL != null) {
            return gbVarL.uf;
        }
        return new ArrayList<>();
    }

    public static boolean q(na naVar) {
        gb gbVarL = l(naVar);
        return gbVarL != null && gbVarL.v == 1;
    }

    public static int g(na naVar, int i) {
        int i2;
        gb gbVarL = l(naVar);
        return (gbVarL != null && (i2 = gbVarL.pf) > 0) ? Math.min(i, i2) : i;
    }

    public static jq iq(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL != null) {
            return gbVarL.sy;
        }
        return null;
    }

    public static boolean zw(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL != null) {
            return gbVarL.hh;
        }
        return false;
    }

    public static boolean io(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return false;
        }
        return gbVarL.l;
    }

    public static boolean uf(na naVar) {
        gb gbVarL = l(naVar);
        return gbVarL != null && gbVarL.h == 1;
    }

    public static boolean sy(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return false;
        }
        return gbVarL.gk;
    }

    public static int hh(na naVar) {
        gb gbVarL = l(naVar);
        if (gbVarL == null) {
            return 0;
        }
        return gbVarL.x;
    }
}
