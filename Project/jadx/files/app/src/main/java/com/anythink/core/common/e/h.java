package com.anythink.core.common.e;

import android.text.TextUtils;
import com.anythink.core.c.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends q {
    public String A;
    public String B;
    public String C;
    public String D;
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f7256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f7260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f7261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f7263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f7264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f7265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f7266o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f7267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f7268q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f7269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f7270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f7271t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f7272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f7273v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f7274w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f7275x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f7276y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f7277z;

    private h() {
    }

    @Override // com.anythink.core.common.e.q
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.a);
            jSONObject.put("requestid", this.b);
            jSONObject.put("unitid", this.f7255d);
            jSONObject.put(com.anythink.core.common.b.e.f6775c, this.f7256e);
            jSONObject.put("sessionid", this.f7257f);
            jSONObject.put("groupid", this.f7258g);
            jSONObject.put("unitgroupid", this.f7259h);
            jSONObject.put("timestamp", this.f7260i);
            jSONObject.put("asid", this.f7261j);
            jSONObject.put("refresh", this.f7262k);
            jSONObject.put("traffic_group_id", this.f7263l);
            jSONObject.put("msg", this.f7264m);
            jSONObject.put("msg1", this.f7265n);
            jSONObject.put("msg2", this.f7266o);
            jSONObject.put("msg3", this.f7267p);
            jSONObject.put("msg4", this.f7268q);
            jSONObject.put("msg5", this.f7269r);
            jSONObject.put("msg6", this.f7270s);
            jSONObject.put("msg7", this.f7271t);
            jSONObject.put("msg8", this.f7272u);
            jSONObject.put("msg9", this.f7273v);
            jSONObject.put("msg10", this.f7274w);
            jSONObject.put("msg11", this.f7275x);
            jSONObject.put("msg12", this.f7276y);
            jSONObject.put("msg13", this.f7277z);
            jSONObject.put(d.a.U, this.C);
            jSONObject.put(com.anythink.core.common.g.c.am, this.D);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public h(String str, String str2) {
        this.A = str;
        this.B = str2;
    }

    public static h a(String str) {
        h hVar = new h();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("key")) {
                    hVar.a = jSONObject.optString("key", "");
                }
                if (jSONObject.has("requestid")) {
                    hVar.b = jSONObject.optString("requestid", "");
                }
                if (jSONObject.has("unitid")) {
                    hVar.f7255d = jSONObject.optString("unitid", "");
                }
                if (jSONObject.has(com.anythink.core.common.b.e.f6775c)) {
                    hVar.f7256e = jSONObject.optString(com.anythink.core.common.b.e.f6775c, "");
                }
                if (jSONObject.has("sessionid")) {
                    hVar.f7257f = jSONObject.optString("sessionid", "");
                }
                if (jSONObject.has("groupid")) {
                    hVar.f7258g = jSONObject.optString("groupid", "");
                }
                if (jSONObject.has("unitgroupid")) {
                    hVar.f7259h = jSONObject.optString("unitgroupid", "");
                }
                if (jSONObject.has("timestamp")) {
                    hVar.f7260i = jSONObject.optString("timestamp", "");
                }
                if (jSONObject.has("asid")) {
                    hVar.f7261j = jSONObject.optString("asid", "");
                }
                if (jSONObject.has("refresh")) {
                    hVar.f7262k = jSONObject.optString("refresh", "");
                }
                if (jSONObject.has("traffic_group_id")) {
                    hVar.f7263l = jSONObject.optString("traffic_group_id", "");
                }
                if (jSONObject.has("msg")) {
                    hVar.f7264m = jSONObject.optString("msg", "");
                }
                if (jSONObject.has("msg1")) {
                    hVar.f7265n = jSONObject.optString("msg1", "");
                }
                if (jSONObject.has("msg2")) {
                    hVar.f7266o = jSONObject.optString("msg2", "");
                }
                if (jSONObject.has("msg3")) {
                    hVar.f7267p = jSONObject.optString("msg3", "");
                }
                if (jSONObject.has("msg4")) {
                    hVar.f7268q = jSONObject.optString("msg4", "");
                }
                if (jSONObject.has("msg5")) {
                    hVar.f7269r = jSONObject.optString("msg5", "");
                }
                if (jSONObject.has("msg6")) {
                    hVar.f7270s = jSONObject.optString("msg6", "");
                }
                if (jSONObject.has("msg7")) {
                    hVar.f7271t = jSONObject.optString("msg7", "");
                }
                if (jSONObject.has("msg8")) {
                    hVar.f7272u = jSONObject.optString("msg8", "");
                }
                if (jSONObject.has("msg9")) {
                    hVar.f7273v = jSONObject.optString("msg9", "");
                }
                if (jSONObject.has("msg10")) {
                    hVar.f7274w = jSONObject.optString("msg10", "");
                }
                if (jSONObject.has("msg11")) {
                    hVar.f7275x = jSONObject.optString("msg11", "");
                }
                if (jSONObject.has("msg12")) {
                    hVar.f7276y = jSONObject.optString("msg12", "");
                }
                if (jSONObject.has("msg13")) {
                    hVar.f7277z = jSONObject.optString("msg13", "");
                }
                if (jSONObject.has(d.a.U)) {
                    hVar.C = jSONObject.optString(d.a.U, "");
                }
                if (jSONObject.has(com.anythink.core.common.g.c.am)) {
                    hVar.D = jSONObject.optString(com.anythink.core.common.g.c.am, "");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hVar;
    }
}
