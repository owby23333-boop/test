package com.anythink.core.common.g.a;

import com.anythink.core.common.b.n;
import com.anythink.core.common.e.f;
import com.anythink.core.common.e.o;
import com.anythink.core.common.u;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends c {
    List<f> a;
    boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7458c = e.class.getSimpleName();

    public e(List<f> list) {
        this.a = list;
    }

    @Override // com.anythink.core.common.g.a.c
    public final void a(String str, String str2, String str3, int i2) {
        if (this.b) {
            return;
        }
        String str4 = str3 + ":" + i2;
        List<f> list = this.a;
        com.anythink.core.common.j.c.a("tk", str, str2, str4, (String) null, String.valueOf(list != null ? list.size() : 0), "1");
        u.a().a(3, "", "", a(true), o.a(1000));
    }

    @Override // com.anythink.core.common.g.a.c
    public final int c() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.g.a.c
    public final byte[] e() {
        List<f> list = this.a;
        return (list == null || list.size() <= 0) ? new byte[0] : c.a(a(false));
    }

    @Override // com.anythink.core.common.g.a.c
    public final boolean f() {
        return this.b;
    }

    @Override // com.anythink.core.common.g.a.c
    protected final int h() {
        return 2;
    }

    private String a(boolean z2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectG = super.g();
        JSONObject jSONObjectA = com.anythink.core.common.g.c.a();
        try {
            jSONObjectG.put("app_id", n.a().p());
            jSONObjectG.put(com.anythink.core.common.g.c.T, this.f7447i);
            jSONObjectG.put(com.anythink.core.common.g.c.V, this.f7448j);
            Iterator<String> itKeys = jSONObjectA.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectG.put(next, jSONObjectA.opt(next));
            }
            Map<String, Object> mapM = n.a().m();
            if (mapM != null && mapM.size() > 0 && mapM != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : mapM.keySet()) {
                    Object obj = mapM.get(str);
                    if (obj != null) {
                        jSONObject2.put(str, obj.toString());
                    }
                }
                jSONObjectG.put("custom", jSONObject2);
            }
        } catch (Throwable unused) {
        }
        String strA = com.anythink.core.common.k.c.a(jSONObjectG.toString());
        JSONArray jSONArray = new JSONArray();
        List<f> list = this.a;
        if (list != null) {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectA2 = it.next().a();
                if (z2 && jSONObjectA2 != null) {
                    try {
                        jSONObjectA2.put(com.anythink.core.common.g.c.U, 1);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                jSONArray.put(jSONObjectA2);
            }
        }
        String strA2 = com.anythink.core.common.k.c.a(jSONArray.toString());
        String strC = com.anythink.core.common.k.f.c(n.a().q() + "api_ver=1.0&common=" + strA + "&data=" + strA2);
        try {
            jSONObject.put(com.anythink.core.common.g.c.Z, strA);
            jSONObject.put("data", strA2);
            jSONObject.put(com.anythink.core.common.g.c.O, "1.0");
            jSONObject.put("sign", strC);
        } catch (Exception unused2) {
        }
        return jSONObject.toString();
    }
}
