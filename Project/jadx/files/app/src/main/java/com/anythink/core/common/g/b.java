package com.anythink.core.common.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.o;
import com.anythink.core.common.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    Context a;
    int b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    List<String> f7461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f7462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f7463g = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f7459c = n.a().p();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f7460d = n.a().q();

    public b(Context context, int i2, List<String> list) {
        this.a = context;
        this.f7461e = list;
        this.b = list.size();
        this.f7462f = i2;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(int i2, i iVar) {
        if (!TextUtils.isEmpty(b())) {
            super.a(i2, iVar);
        } else if (iVar != null) {
            iVar.onLoadFinish(i2, Integer.valueOf(this.b));
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.k();
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
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
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        if (jSONObjectE != null) {
            try {
                jSONObjectE.put("app_id", this.f7459c);
                jSONObjectE.put("nw_ver", com.anythink.core.common.k.d.h());
                Map<String, Object> mapM = n.a().m();
                if (mapM != null) {
                    try {
                        if (mapM.size() > 0 && mapM != null) {
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
                }
                JSONArray jSONArray = new JSONArray();
                if (this.f7461e != null && this.f7461e.size() > 0) {
                    for (String str2 : this.f7461e) {
                        if (!TextUtils.isEmpty(str2)) {
                            jSONArray.put(new JSONObject(str2));
                        }
                    }
                }
                jSONObjectE.put("data", jSONArray);
            } catch (Exception unused2) {
            }
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.g.a
    protected final JSONObject f() {
        JSONObject jSONObjectF = super.f();
        if (jSONObjectF != null) {
            try {
                jSONObjectF.put(c.T, this.f7462f);
            } catch (Exception unused) {
            }
        }
        return jSONObjectF;
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return this.f7459c;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.a;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.f7460d;
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
    protected final boolean o() {
        return true;
    }

    public final void p() {
        this.f7463g = true;
    }

    private static String b(String str) {
        try {
            return URLEncoder.encode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return Integer.valueOf(this.b);
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
        if (this.f7463g) {
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
            String strG = g();
            u.a().a(1, b(), string, strG, o.a(1001));
        }
    }
}
