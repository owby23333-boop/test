package com.anythink.core.common.k;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.IExHandler;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final String A = "it_src";
    public static final String a = "platform";
    public static final String b = "os_vn";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7716c = "os_vc";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7717d = "package_name";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7718e = "app_vn";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7719f = "app_vc";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7720g = "brand";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7721h = "model";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7722i = "screen";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f7723j = "network_type";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f7724k = "mnc";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f7725l = "mcc";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7726m = "language";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7727n = "timezone";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7728o = "sdk_ver";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f7729p = "gp_ver";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f7730q = "nw_ver";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f7731r = "ua";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f7732s = "orient";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f7733t = "system";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7734u = "android_id";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f7735v = "gaid";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f7736w = "channel";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f7737x = "sub_channel";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f7738y = "upid";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f7739z = "ps_id";

    public static JSONObject a() {
        JSONObject jSONObjectB = b();
        JSONObject jSONObjectC = c();
        try {
            jSONObjectB.put("app_id", com.anythink.core.common.b.n.a().p());
            Iterator<String> itKeys = jSONObjectC.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectB.put(next, jSONObjectC.opt(next));
            }
        } catch (JSONException unused) {
        }
        return jSONObjectB;
    }

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        Context contextG = com.anythink.core.common.b.n.a().g();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", d.e());
            jSONObject.put("os_vc", d.d());
            jSONObject.put("package_name", d.k(contextG));
            jSONObject.put("app_vn", d.i(contextG));
            jSONObject.put("app_vc", d.h(contextG));
            jSONObject.put("brand", d.b());
            jSONObject.put("model", d.a());
            jSONObject.put("screen", d.j(contextG));
            jSONObject.put("network_type", String.valueOf(d.m(contextG)));
            jSONObject.put("mnc", d.c(contextG));
            jSONObject.put("mcc", d.b(contextG));
            jSONObject.put("language", d.f(contextG));
            jSONObject.put("timezone", d.c());
            jSONObject.put("sdk_ver", g.a());
            jSONObject.put("gp_ver", d.n(contextG));
            jSONObject.put("ua", d.i());
            jSONObject.put("orient", d.g(contextG));
            jSONObject.put("system", 1);
            if (!TextUtils.isEmpty(com.anythink.core.common.b.n.a().n())) {
                jSONObject.put("channel", com.anythink.core.common.b.n.a().n());
            }
            if (!TextUtils.isEmpty(com.anythink.core.common.b.n.a().o())) {
                jSONObject.put("sub_channel", com.anythink.core.common.b.n.a().o());
            }
            jSONObject.put("upid", com.anythink.core.common.b.n.a().x());
            jSONObject.put("ps_id", com.anythink.core.common.b.n.a().r());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject c() {
        String strF;
        Context contextG = com.anythink.core.common.b.n.a().g();
        JSONObject jSONObject = new JSONObject();
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(contextG).b(com.anythink.core.common.b.n.a().p());
        if (aVarB != null) {
            try {
                strF = aVarB.F();
            } catch (Exception unused) {
            }
        } else {
            strF = "";
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(strF)) {
            try {
                JSONObject jSONObject2 = new JSONObject(strF);
                if (!jSONObject2.isNull("a")) {
                    if (jSONObject2.optInt("a") != 1) {
                        z2 = false;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        jSONObject.put("android_id", z2 ? d.d(contextG) : "");
        jSONObject.put("gaid", d.f());
        IExHandler iExHandlerB = com.anythink.core.common.b.n.a().b();
        if (iExHandlerB != null) {
            iExHandlerB.fillRequestData(jSONObject, aVarB);
            jSONObject.put("is_cn_sdk", "1");
        } else {
            jSONObject.put("is_cn_sdk", "0");
        }
        String strL = d.l(contextG);
        if (TextUtils.isEmpty(strL)) {
            strL = "";
        }
        jSONObject.put("it_src", strL);
        return jSONObject;
    }
}
