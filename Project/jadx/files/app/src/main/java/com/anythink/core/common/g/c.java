package com.anythink.core.common.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATPrivacyConfig;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.b.p;
import com.anythink.core.common.e.ak;
import com.anythink.core.common.k.q;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final String A = "it_src";
    public static final String B = "lat";
    public static final String C = "lon";
    public static final String D = "inst_wx";
    public static final String E = "mini_sdk";
    public static final String F = "ms_type";
    public static final String G = "device_set";
    public static final String H = "gdpr_cs";
    public static final String I = "abtest_id";
    public static final String J = "first_init_time";
    public static final String K = "days_from_first_init";
    public static final String L = "cs_cl";
    public static final String M = "is_ofm";
    public static final String N = "app_id";
    public static final String O = "api_ver";
    public static final String P = "custom";
    public static final String Q = "rdid";
    public static final String R = "rc";
    public static final String S = "data";
    public static final String T = "tcp_tk_da_type";
    public static final String U = "ofl";
    public static final String V = "tcp_rate";
    public static final String W = "p";
    public static final String X = "p2";
    public static final String Y = "sign";
    public static final String Z = "common";
    public static final String a = "platform";
    public static final int aa = 1;
    public static final int ab = 2;
    public static final int ac = 3;
    public static final String ad = "area_type";
    public static final String ae = "sp_http";
    public static final String af = "os_fw";
    public static final String ag = "is_test";
    public static final String ah = "mdna_oid";
    public static final String ai = "mdna_appkey";
    public static final String aj = "mdna_r";
    public static final String ak = "user_num";
    public static final String al = "cp_device_id";
    public static final String am = "cp_pl_id";
    public static int an = -1;
    public static int ao = -1;
    public static final String ap = "al_it_apil";
    public static final String aq = "wx_data";
    public static final String b = "os_vn";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7464c = "os_vc";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7465d = "package_name";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7466e = "app_vn";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7467f = "app_vc";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7468g = "brand";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7469h = "model";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7470i = "screen";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f7471j = "network_type";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f7472k = "mnc";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f7473l = "mcc";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7474m = "language";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7475n = "timezone";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7476o = "sdk_ver";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f7477p = "gp_ver";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f7478q = "nw_ver";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f7479r = "ua";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f7480s = "orient";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f7481t = "system";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7482u = "android_id";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f7483v = "gaid";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f7484w = "channel";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f7485x = "sub_channel";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f7486y = "upid";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f7487z = "ps_id";

    public static JSONObject a(int i2) {
        com.anythink.core.common.k.d.q(n.a().g());
        JSONObject jSONObject = new JSONObject();
        Context contextG = n.a().g();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", com.anythink.core.common.k.d.e());
            jSONObject.put("os_vc", com.anythink.core.common.k.d.d());
            jSONObject.put("package_name", com.anythink.core.common.k.d.k(contextG));
            jSONObject.put("app_vn", com.anythink.core.common.k.d.i(contextG));
            jSONObject.put("app_vc", com.anythink.core.common.k.d.h(contextG));
            jSONObject.put("brand", com.anythink.core.common.k.d.b());
            jSONObject.put("model", com.anythink.core.common.k.d.a());
            jSONObject.put("screen", com.anythink.core.common.k.d.j(contextG));
            jSONObject.put("network_type", com.anythink.core.common.k.d.m(contextG));
            jSONObject.put("mnc", com.anythink.core.common.k.d.c(contextG));
            jSONObject.put("mcc", com.anythink.core.common.k.d.b(contextG));
            jSONObject.put("language", com.anythink.core.common.k.d.f(contextG));
            jSONObject.put("timezone", com.anythink.core.common.k.d.c());
            jSONObject.put("sdk_ver", com.anythink.core.common.k.g.a());
            jSONObject.put("gp_ver", com.anythink.core.common.k.d.n(contextG));
            jSONObject.put("ua", com.anythink.core.common.k.d.i());
            jSONObject.put("orient", com.anythink.core.common.k.d.g(contextG));
            jSONObject.put("system", 1);
            if (!TextUtils.isEmpty(n.a().n())) {
                jSONObject.put("channel", n.a().n());
            }
            if (!TextUtils.isEmpty(n.a().o())) {
                jSONObject.put("sub_channel", n.a().o());
            }
            jSONObject.put("upid", p.a(contextG).b() ? n.a().x() : "");
            jSONObject.put("ps_id", n.a().r());
            com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(contextG).b(n.a().p());
            if (aVarB != null) {
                jSONObject.put(I, TextUtils.isEmpty(aVarB.A()) ? "" : aVarB.A());
            }
            jSONObject.put(J, n.a().h());
            jSONObject.put(K, n.a().i());
            StringBuilder sb = new StringBuilder();
            sb.append(n.a().e());
            sb.append(p.a(contextG).a());
            jSONObject.put(H, sb.toString());
            if (n.a().j() == 1) {
                jSONObject.put(M, 1);
            }
            if (n.a().H() && com.anythink.core.common.b.i.a().a(aVarB)) {
                String strB = com.anythink.core.common.b.i.a().b();
                String strC = com.anythink.core.common.b.i.a().c();
                String strD = com.anythink.core.common.b.i.a().d();
                if (TextUtils.isEmpty(strB)) {
                    strB = "";
                }
                jSONObject.put(ah, strB);
                if (TextUtils.isEmpty(strC)) {
                    strC = "";
                }
                jSONObject.put(ai, strC);
                if (TextUtils.isEmpty(strD)) {
                    strD = "";
                }
                jSONObject.put(Q, strD);
                jSONObject.put("mdna_r", n.a().K());
            }
            jSONObject.put(ae, n.a().C() ? n.a().D() ? "1" : "3" : n.a().D() ? "2" : "4");
            IExHandler iExHandlerB = n.a().b();
            if (iExHandlerB != null) {
                iExHandlerB.fillRequestDeviceData(jSONObject, i2);
            }
            String strJ = com.anythink.core.common.k.d.j();
            if (!TextUtils.isEmpty(strJ)) {
                jSONObject.put(af, Integer.parseInt(strJ));
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void b(JSONObject jSONObject) throws JSONException {
        ATPrivacyConfig aTPrivacyConfigJ = n.a().J();
        if (aTPrivacyConfigJ != null) {
            String devGaid = aTPrivacyConfigJ.getDevGaid();
            String devImei = aTPrivacyConfigJ.getDevImei();
            String devOaid = aTPrivacyConfigJ.getDevOaid();
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(devGaid)) {
                jSONObject2.put("set_gaid", devGaid);
            }
            if (!TextUtils.isEmpty(devImei)) {
                jSONObject2.put("set_imei", devImei);
            }
            if (!TextUtils.isEmpty(devOaid)) {
                jSONObject2.put("set_oaid", devOaid);
            }
            jSONObject.put(G, jSONObject2);
        }
    }

    public static JSONObject b() {
        return a(n.a().m());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.anythink.core.api.IExHandler] */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.g.c.a():org.json.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    private static void a(Context context, JSONObject jSONObject) throws JSONException {
        int i2 = an;
        if (i2 == -1) {
            boolean zB = q.a().b(context);
            boolean zA = q.a().a(context);
            ?? r3 = zA ? 2 : zB;
            if (zB && zA) {
                r3 = 3;
            }
            if (r3 > 0) {
                jSONObject.put(F, r3);
            }
            an = r3;
        } else if (i2 > 0) {
            jSONObject.put(F, i2);
        }
        int i3 = ao;
        if (i3 != -1) {
            if (i3 == 1) {
                jSONObject.put(E, i3);
            }
        } else {
            boolean zB2 = q.a().b();
            if (zB2) {
                jSONObject.put(E, 1);
            }
            ao = zB2 ? 1 : 0;
        }
    }

    public static void a(JSONObject jSONObject) {
        try {
            ak akVarL = n.a().L();
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 1;
            if (akVarL.b() != 1) {
                i2 = 0;
            }
            jSONObject2.put("has_sdk", i2);
            jSONObject2.put("sdk_ver", String.valueOf(akVarL.c()));
            jSONObject2.put("sdk_api_ver", String.valueOf(akVarL.d()));
            jSONObject2.put("open_app_id", com.anythink.core.common.k.d.l());
            jSONObject.put(aq, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(String str) {
        return a(n.a().d(str));
    }

    public static JSONObject a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    if (obj != null) {
                        try {
                            jSONObject.put(str, obj.toString());
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }
}
