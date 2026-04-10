package com.anythink.expressad.foundation.d;

import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.expressad.a.c;
import com.anythink.expressad.foundation.h.t;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.anythink.expressad.out.j implements com.anythink.expressad.e.b, Serializable {
    public static final String cA = "adv_id";
    public static final String cB = "ttc_type";
    public static final String cC = "ttc_ct2";
    public static final String cD = "gh_id";
    public static final String cE = "gh_path";
    public static final String cF = "bind_id";
    public static final String cG = "mark";
    public static final String cH = "isPost";
    public static final int cI = 604800;
    public static final int cJ = 1800;
    public static final String cK = "apk_download_start";
    public static final String cL = "apk_download_end";
    public static final String cM = "apk_install";
    public static final String cN = "loopback";
    public static final String cO = "domain";
    public static final String cP = "key";
    public static final String cQ = "value";
    public static final String co = h.class.getSimpleName();
    public static final String cp = "apk_alt";
    public static final String cq = "disableApkAlt";
    public static final String cr = "apk_info";
    public static final String cs = "ntbarpt";
    public static final String ct = "ntbarpasbl";
    public static final String cu = "atat_type";
    public static final String cv = "akdlui";
    public static final String cw = "ttc";
    public static final String cx = "ttc_ct";
    public static final String cy = "ttc_pe";
    public static final String cz = "ttc_po";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f10265l = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f10267d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f10272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f10273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f10274k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f10276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f10277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f10278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, String> f10279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f10280r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f10281s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f10282t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f10283u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private c.b f10284v;
    private int a = 0;
    private int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10266c = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10268e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10269f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10270g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10271h = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f10275m = false;

    private void a(a aVar) {
        this.f10267d = aVar;
    }

    private void b(int i2) {
        this.a = i2;
    }

    private void c(int i2) {
        this.f10268e = i2;
    }

    private void d(int i2) {
        this.f10269f = i2;
    }

    private void e(int i2) {
        this.f10270g = i2;
    }

    private void f(String str) {
        this.f10277o = str;
    }

    private void g(int i2) {
        this.f10283u = i2;
    }

    private void h(int i2) {
        this.f10282t = i2;
    }

    private void i(int i2) {
        this.f10276n = i2;
    }

    public final a aG() {
        return this.f10267d;
    }

    public final int aH() {
        return this.b;
    }

    public final int aI() {
        return this.a;
    }

    public final int aJ() {
        return this.f10268e;
    }

    public final int aK() {
        return this.f10269f;
    }

    public final int aL() {
        return this.f10270g;
    }

    public final String aM() {
        return this.f10271h;
    }

    public final String aN() {
        return this.f10272i;
    }

    public final String aO() {
        return this.f10273j;
    }

    @Deprecated
    public final String aP() {
        return this.f10274k;
    }

    public final String aQ() {
        return this.f10277o;
    }

    public final int aR() {
        return this.f10278p;
    }

    public final int aS() {
        return this.f10283u;
    }

    public final int aT() {
        return this.f10282t;
    }

    public final String aU() {
        return this.f10281s;
    }

    public final int aV() {
        return this.f10276n;
    }

    public final boolean aW() {
        return this.f10275m;
    }

    public c.b aj() {
        return this.f10284v;
    }

    public final String u(String str) {
        Map<String, String> map;
        try {
            if (TextUtils.isEmpty(str) || (map = this.f10279q) == null || map.size() <= 0) {
                return str;
            }
            Uri uri = Uri.parse(str);
            String host = uri.getHost();
            String str2 = map.get("domain");
            if (TextUtils.isEmpty(host) || !host.contains(str2)) {
                return str;
            }
            String str3 = map.get("key");
            String str4 = map.get("value");
            if (!str.contains(str3) && TextUtils.isEmpty(uri.getQueryParameter(str3)) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                return str + DispatchConstants.SIGN_SPLIT_SYMBOL + str3 + "=" + str4;
            }
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return str;
            }
            return str.replace(str3 + "=" + (!TextUtils.isEmpty(uri.getQueryParameter(str3)) ? uri.getQueryParameter(str3) : ""), str3 + "=" + str4);
        } catch (Throwable unused) {
            com.anythink.expressad.foundation.h.o.d("", "matchLoopback error");
            return str;
        }
    }

    private void a(int i2) {
        this.b = i2;
    }

    private void b(String str) {
        this.f10272i = str;
    }

    private void c(String str) {
        this.f10273j = str;
    }

    private void d(String str) {
        this.f10274k = str;
    }

    private void e(String str) {
        this.f10280r = str;
    }

    private void f(int i2) {
        this.f10278p = i2;
    }

    private void g(String str) {
        this.f10281s = str;
    }

    private static Map<String, String> h(String str) {
        HashMap map = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap map2 = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                map2.put("domain", jSONObject.getString("domain"));
                map2.put("key", jSONObject.getString("key"));
                map2.put("value", jSONObject.getString("value"));
                return map2;
            } catch (Throwable unused) {
                map = map2;
            }
        } catch (Throwable unused2) {
        }
        com.anythink.expressad.foundation.h.o.d("", "loopbackStrToMap error");
        return map;
    }

    private void a(String str) {
        this.f10271h = str;
    }

    private String b() {
        return this.f10280r;
    }

    private static JSONObject c(JSONObject jSONObject, c cVar) throws JSONException {
        if (cVar == null) {
            return jSONObject;
        }
        jSONObject.put(cw, ((h) cVar).f10275m);
        jSONObject.put(cx, ((h) cVar).f10276n);
        jSONObject.put(cA, ((h) cVar).f10281s);
        jSONObject.put("ttc_type", ((h) cVar).f10282t);
        jSONObject.put(cC, ((h) cVar).f10283u);
        jSONObject.put(cD, ((h) cVar).f10272i);
        jSONObject.put(cE, com.anythink.expressad.foundation.h.j.a(((h) cVar).f10273j));
        jSONObject.put(cF, ((h) cVar).f10274k);
        jSONObject.put(cp, ((h) cVar).a);
        jSONObject.put(cq, ((h) cVar).b);
        a aVar = ((h) cVar).f10267d;
        if (aVar != null) {
            jSONObject.put(cr, aVar.g());
        }
        jSONObject.put(cG, ((h) cVar).f10277o);
        jSONObject.put(cH, ((h) cVar).f10278p);
        jSONObject.put(c.bc, cVar.x());
        jSONObject.put(ct, ((h) cVar).f10269f);
        jSONObject.put(cs, ((h) cVar).f10268e);
        jSONObject.put(cu, ((h) cVar).f10270g);
        jSONObject.put(cv, ((h) cVar).f10271h);
        return jSONObject;
    }

    private Map<String, String> a() {
        return this.f10279q;
    }

    public static c b(JSONObject jSONObject, c cVar) {
        if (jSONObject == null) {
            return null;
        }
        try {
            ((h) cVar).f10275m = jSONObject.optBoolean(cw);
            ((h) cVar).f10276n = jSONObject.optInt(cx, 604800);
            ((h) cVar).f10281s = jSONObject.optString(cA);
            ((h) cVar).f10282t = jSONObject.optInt("ttc_type", 3);
            ((h) cVar).f10283u = jSONObject.optInt(cC, 1800);
            ((h) cVar).f10277o = jSONObject.optString(cG);
            ((h) cVar).f10278p = jSONObject.optInt(cH);
            try {
                if (jSONObject.has(cN)) {
                    String strOptString = jSONObject.optString(cN);
                    if (!TextUtils.isEmpty(strOptString)) {
                        ((h) cVar).f10280r = strOptString;
                        ((h) cVar).f10279q = h(strOptString);
                    }
                }
            } catch (Exception unused) {
                com.anythink.expressad.foundation.h.o.d("", "loopback parser error");
            }
            String strOptString2 = jSONObject.optString(cD);
            if (!TextUtils.isEmpty(strOptString2)) {
                ((h) cVar).f10272i = strOptString2;
                String strOptString3 = jSONObject.optString(cE);
                if (!TextUtils.isEmpty(strOptString3)) {
                    ((h) cVar).f10273j = com.anythink.expressad.foundation.h.j.b(strOptString3);
                }
                ((h) cVar).f10274k = jSONObject.optString(cF);
            }
            cVar.e(jSONObject.optString("cam_html"));
            cVar.b(jSONObject.optString("cam_html"));
            ((h) cVar).a = jSONObject.optInt(cp, 0);
            ((h) cVar).b = jSONObject.optInt(cq, 0);
            ((h) cVar).f10267d = a.a(jSONObject.optString(cr));
            ((h) cVar).f10269f = jSONObject.optInt(ct, 0);
            ((h) cVar).f10268e = jSONObject.optInt(cs, 0);
            ((h) cVar).f10270g = jSONObject.optInt(cu, 0);
            ((h) cVar).f10271h = jSONObject.optString(cv, "");
            return cVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.anythink.expressad.foundation.h.o.d(co, "parse campaign json exception: " + e2.getLocalizedMessage());
            return cVar;
        }
    }

    private void a(Map<String, String> map) {
        this.f10279q = map;
    }

    private void a(boolean z2) {
        this.f10275m = z2;
    }

    public void a(c.b bVar) {
        this.f10284v = bVar;
    }

    public static c a(JSONObject jSONObject, c cVar) {
        if (jSONObject == null) {
            return null;
        }
        try {
            ((h) cVar).f10275m = jSONObject.optBoolean(cw);
            ((h) cVar).f10276n = jSONObject.optInt(cx, 604800);
            ((h) cVar).f10281s = jSONObject.optString(cA);
            ((h) cVar).f10282t = jSONObject.optInt("ttc_type", 3);
            ((h) cVar).f10283u = jSONObject.optInt(cC, 1800);
            cVar.a(System.currentTimeMillis());
            cVar.m(jSONObject.optString(d.f10216f));
            cVar.n(jSONObject.optString(d.f10221k));
            ((h) cVar).f10277o = jSONObject.optString(cG);
            ((h) cVar).f10278p = jSONObject.optInt(cH);
            try {
                if (jSONObject.has(cN)) {
                    String strOptString = jSONObject.optString(cN);
                    if (!TextUtils.isEmpty(strOptString)) {
                        ((h) cVar).f10280r = strOptString;
                        ((h) cVar).f10279q = h(strOptString);
                    }
                }
            } catch (Exception unused) {
                com.anythink.expressad.foundation.h.o.d("", "loopback parser error");
            }
            String strOptString2 = jSONObject.optString(cD);
            if (!TextUtils.isEmpty(strOptString2)) {
                ((h) cVar).f10272i = strOptString2;
                String strOptString3 = jSONObject.optString(cE);
                if (!TextUtils.isEmpty(strOptString3)) {
                    ((h) cVar).f10273j = com.anythink.expressad.foundation.h.j.b(strOptString3);
                }
                ((h) cVar).f10274k = jSONObject.optString(cF);
            }
            ((h) cVar).a = jSONObject.optInt(cp, 0);
            ((h) cVar).b = jSONObject.optInt(cq, 0);
            ((h) cVar).f10267d = a.a(jSONObject.optString(cr));
            ((h) cVar).f10269f = jSONObject.optInt(ct, 0);
            ((h) cVar).f10268e = jSONObject.optInt(cs, 0);
            ((h) cVar).f10270g = jSONObject.optInt(cu, 0);
            ((h) cVar).f10271h = jSONObject.optString(cv, "");
            return cVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.anythink.expressad.foundation.h.o.d(co, "parse campaign json exception: " + e2.getLocalizedMessage());
            return cVar;
        }
    }

    public final boolean b(c cVar) {
        boolean z2 = this.a == 1 && cVar.Q() == 3 && ((h) cVar).b != 1;
        if (!z2) {
            return z2;
        }
        try {
            if (t.a(com.anythink.core.common.b.n.a().g(), ba())) {
                return false;
            }
            return z2;
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.a(co, th.getMessage());
            return z2;
        }
    }

    protected static String a(d dVar, c cVar, String str) {
        if (dVar != null && !TextUtils.isEmpty(str)) {
            try {
                HashMap<String, String> mapA = dVar.a();
                if (mapA != null) {
                    mapA.entrySet().iterator();
                    for (Map.Entry<String, String> entry : mapA.entrySet()) {
                        String key = entry.getKey();
                        str = str.replaceAll("\\{" + key + "\\}", entry.getValue());
                    }
                }
                HashMap<String, String> mapZ = cVar.z();
                if (mapZ != null) {
                    mapZ.entrySet().iterator();
                    for (Map.Entry<String, String> entry2 : mapZ.entrySet()) {
                        String key2 = entry2.getKey();
                        str = str.replaceAll("\\{" + key2 + "\\}", entry2.getValue());
                    }
                }
                HashMap<String, String> mapB = dVar.b();
                if (mapB != null) {
                    for (Map.Entry<String, String> entry3 : mapB.entrySet()) {
                        String key3 = entry3.getKey();
                        str = str.replaceAll("\\{" + key3 + "\\}", entry3.getValue());
                    }
                }
                str = str.replaceAll("\\{c\\}", URLEncoder.encode(dVar.e(), com.anythink.expressad.foundation.g.a.bN));
                Matcher matcher = Pattern.compile("=\\{.*?\\}").matcher(str);
                while (matcher.find()) {
                    str = str.replace(matcher.group(0), "=");
                }
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(co, th.getMessage(), th);
            }
        }
        return str;
    }
}
