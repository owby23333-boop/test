package com.anythink.core.c;

import android.text.TextUtils;
import com.anythink.core.common.k.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f6664m = "ofm_logger";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f6665n = "ofm_tk_sw";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f6666o = "ofm_da_sw";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f6667p = "tk_address";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f6668q = "tk_max_amount";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f6669r = "tk_interval";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f6670s = "da_rt_keys_ft";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static String f6671t = "tk_no_t_ft";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f6672u = "da_not_keys_ft";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static String f6673v = "ofm_system";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f6674w = "ofm_tid";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static String f6675x = "ofm_firm_info";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static String f6676y = "ofm_st_vt";
    String a = String.valueOf(hashCode());
    public Map<String, Object> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6683i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f6685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<String, String> f6686l;

    private Map<String, Object> b(String str) {
        try {
            if (this.b != null) {
                return h.c(this.b.get(str).toString());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int c() {
        return this.f6679e;
    }

    private int d() {
        return this.f6681g;
    }

    private int e() {
        return this.f6682h;
    }

    private String f() {
        return this.f6683i;
    }

    private int g() {
        return this.f6684j;
    }

    private long h() {
        return this.f6685k;
    }

    private Map<String, String> i() {
        return this.f6686l;
    }

    private String j() {
        return this.a;
    }

    private boolean k() {
        return this.f6677c;
    }

    public final long a() {
        return this.f6680f;
    }

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.f6678d = jSONObject.optInt(f6673v);
            cVar.f6679e = jSONObject.optInt(f6674w);
            cVar.f6680f = jSONObject.optLong(f6676y);
            cVar.b = h.c(jSONObject.optString(f6675x));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(f6664m);
            if (jSONObjectOptJSONObject != null) {
                cVar.f6681g = jSONObjectOptJSONObject.optInt(f6665n);
                cVar.f6682h = jSONObjectOptJSONObject.optInt(f6666o);
                cVar.f6683i = jSONObjectOptJSONObject.optString(f6667p);
                cVar.f6684j = jSONObjectOptJSONObject.optInt(f6668q);
                cVar.f6685k = jSONObjectOptJSONObject.optLong(f6669r);
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString(f6671t));
                    Iterator<String> itKeys = jSONObject2.keys();
                    HashMap map = new HashMap();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.optString(next));
                    }
                    cVar.f6686l = map;
                } catch (Throwable unused) {
                }
            }
            return cVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static c c(String str) {
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.f6677c = true;
            cVar.f6678d = jSONObject.optInt(f6673v);
            cVar.b = h.c(jSONObject.optString(f6675x));
            cVar.f6681g = 1;
            cVar.f6682h = 1;
            return cVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private int b() {
        return this.f6678d;
    }
}
