package com.anythink.core.common.h;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.e;
import com.anythink.core.common.i;
import com.anythink.core.common.k.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.anythink.core.common.g.a {
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7571c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f7575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.anythink.core.c.d f7576h;
    boolean a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7572d = n.a().p();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7573e = n.a().q();

    public c(Context context, int i2, String str, e eVar, com.anythink.core.c.d dVar) {
        this.b = context;
        this.f7571c = i2;
        this.f7575g = eVar;
        this.f7576h = dVar;
        this.f7574f = str;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        i.a();
        return i.i();
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
        return com.anythink.core.common.g.a.c(g());
    }

    @Override // com.anythink.core.common.g.a
    protected final JSONObject e() throws JSONException {
        JSONObject jSONObjectE = super.e();
        JSONObject jSONObjectF = super.f();
        try {
            jSONObjectE.put("app_id", this.f7572d);
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
        String strC = f.c(this.f7573e + "api_ver=1.0&common=" + strA + "&data=" + this.f7574f + "&ss_a=" + this.f7571c);
        try {
            jSONObject.put(com.anythink.core.common.g.c.Z, strA);
            jSONObject.put("ss_a", this.f7571c);
            jSONObject.put("data", this.f7574f);
            jSONObject.put(com.anythink.core.common.g.c.O, "1.0");
            jSONObject.put("sign", strC);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return this.f7572d;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.b;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.f7573e;
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
    protected final Object a(String str) {
        return str.trim();
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
        try {
            if (ErrorCode.httpStatuException.equals(adError.getCode())) {
                com.anythink.core.common.j.c.a(this.f7575g, this.f7576h, adError.getPlatformCode(), adError.getPlatformMSG());
            } else if (this.a) {
                com.anythink.core.common.j.c.a(this.f7575g, this.f7576h, adError.getPlatformCode(), adError.getPlatformMSG());
            } else {
                this.a = true;
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.h.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c cVar = c.this;
                        cVar.a(0, ((com.anythink.core.common.g.a) cVar).f7435m);
                    }
                }, 5000L);
            }
        } catch (Throwable unused) {
        }
    }
}
