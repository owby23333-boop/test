package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.o;
import com.anythink.core.common.i;
import com.anythink.core.common.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.anythink.core.common.g.a {
    String a;
    JSONObject b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f6070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    aa f6071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Map<String, Object> f6072f;

    public f(int i2, aa aaVar, String str, Map<String, Object> map) {
        this.f6069c = i2;
        this.f6071e = aaVar;
        this.f6072f = map;
        this.f6070d = str;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return null;
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
        JSONObject jSONObject2 = this.b;
        String string2 = jSONObject2 != null ? jSONObject2.toString() : "";
        u.a().a(1, b(), string, string2, o.a(1000));
        com.anythink.core.common.j.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), this.a, "", "1", "");
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.b.put("scenario", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        k kVarK;
        HashMap map = new HashMap();
        map.put("Content-Encoding", "gzip");
        map.put("Content-Type", "application/json;charset=utf-8");
        aa aaVar = this.f6071e;
        if (aaVar != null && (kVarK = aaVar.k()) != null && com.anythink.basead.a.b.a(this.f6069c, kVarK)) {
            String strI = com.anythink.core.common.k.d.i();
            if (!TextUtils.isEmpty(strI)) {
                map.put("User-Agent", strI);
            }
        }
        return map;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return com.anythink.core.common.g.a.c(this.b.toString());
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String k() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, Object> l() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        try {
            if (!TextUtils.isEmpty(this.f6070d)) {
                this.b = new JSONObject(this.f6070d);
                for (Map.Entry<String, Object> entry : this.f6072f.entrySet()) {
                    this.b.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        i.a();
        this.a = i.g();
        return this.a;
    }
}
