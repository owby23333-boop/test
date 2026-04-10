package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.o;
import com.anythink.core.common.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m extends a {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7520c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7521d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7522e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7523f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7524g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7525h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7526i = 9;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7527j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7528k = 11;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7529l = 12;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f7530p = 13;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7531q = 15;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7532r = 16;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f7533s = 18;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f7534t = 19;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f7535u = 20;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7536v = 21;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f7537x = "m";
    private List<com.anythink.core.common.e.f> B;
    private com.anythink.core.common.e.f C;
    private int D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Context f7539y;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f7538w = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f7540z = n.a().p();
    private String A = n.a().q();

    public m(Context context, int i2, List<com.anythink.core.common.e.f> list) {
        this.f7539y = context;
        this.D = i2;
        this.B = list;
    }

    private void a(JSONObject jSONObject) {
        if (!this.f7538w || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(c.U, 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        com.anythink.core.common.e.f fVar = this.C;
        if (fVar != null) {
            return fVar.b.ao;
        }
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.j();
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put("Content-Type", "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return a.c(g());
    }

    @Override // com.anythink.core.common.g.a
    protected final JSONObject e() throws JSONException {
        JSONObject jSONObjectE = super.e();
        JSONObject jSONObjectF = super.f();
        try {
            jSONObjectE.put("app_id", this.f7540z);
            jSONObjectE.put(c.T, this.D);
            Iterator<String> itKeys = jSONObjectF.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectE.put(next, jSONObjectF.opt(next));
            }
            Map<String, Object> mapM = n.a().m();
            if (mapM != null && mapM.size() > 0 && mapM != null) {
                JSONObject jSONObject = new JSONObject();
                for (String str : mapM.keySet()) {
                    Object obj = mapM.get(str);
                    if (obj != null) {
                        jSONObject.put(str, obj.toString());
                    }
                }
                jSONObjectE.put("custom", jSONObject);
            }
        } catch (Throwable unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.g.a
    protected final String g() {
        JSONObject jSONObject = new JSONObject();
        String strA = com.anythink.core.common.k.c.a(e().toString());
        JSONArray jSONArray = new JSONArray();
        List<com.anythink.core.common.e.f> list = this.B;
        if (list != null) {
            Iterator<com.anythink.core.common.e.f> it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectA = it.next().a();
                a(jSONObjectA);
                jSONArray.put(jSONObjectA);
            }
        } else {
            com.anythink.core.common.e.f fVar = this.C;
            if (fVar != null) {
                JSONObject jSONObjectA2 = fVar.a();
                a(jSONObjectA2);
                jSONArray.put(jSONObjectA2);
            }
        }
        String strA2 = com.anythink.core.common.k.c.a(jSONArray.toString());
        String strC = com.anythink.core.common.k.f.c(this.A + "api_ver=1.0&common=" + strA + "&data=" + strA2);
        try {
            jSONObject.put(c.Z, strA);
            jSONObject.put("data", strA2);
            jSONObject.put(c.O, "1.0");
            jSONObject.put("sign", strC);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return this.f7540z;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.f7539y;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.A;
    }

    @Override // com.anythink.core.common.g.a
    protected final String k() {
        return "1.0";
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, Object> l() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final int m() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean o() {
        return true;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return str.trim();
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> mapC = c();
        if (mapC != null) {
            try {
                for (String str : mapC.keySet()) {
                    jSONObject.put(str, mapC.get(str));
                }
            } catch (Exception unused) {
            }
        }
        String string = jSONObject.toString();
        this.f7538w = true;
        String strG = g();
        this.f7538w = false;
        u.a().a(1, b(), string, strG, o.a(1000));
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
        List<com.anythink.core.common.e.f> list = this.B;
        com.anythink.core.common.j.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), b(), (String) null, String.valueOf(list != null ? list.size() : 1), "0");
    }
}
