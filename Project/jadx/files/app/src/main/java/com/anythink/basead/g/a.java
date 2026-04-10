package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.n;
import com.anythink.core.common.c.k;
import com.anythink.core.common.e.j;
import com.anythink.core.common.g.g;
import com.anythink.core.common.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.anythink.core.common.g.a {
    String a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f6050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f6052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f6053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f6054g;

    public a(j jVar) {
        this.a = jVar.a;
        this.b = jVar.f7303d;
        this.f6050c = jVar.b;
        this.f6051d = jVar.f7307h;
        this.f6052e = jVar.f7308i;
        this.f6053f = jVar.f7310k;
        this.f6054g = jVar.f7311l;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return str;
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(int i2, Object obj) {
        if (obj == null) {
            a(i2, g.f7505j, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", ""));
            return;
        }
        try {
            if (TextUtils.isEmpty(new JSONObject(obj.toString()).optString("data"))) {
                a(i2, g.f7506k, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", obj.toString()));
            } else {
                super.a(i2, obj);
            }
        } catch (Throwable unused) {
            a(i2, -99999, "Return Empty Ad.", ErrorCode.getErrorCode(ErrorCode.noADError, "", obj != null ? obj.toString() : "Adx Service Error."));
        }
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
        if (!TextUtils.isEmpty(this.f6054g)) {
            return this.f6054g;
        }
        i.a();
        return i.f();
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
        try {
            return g().getBytes(com.anythink.expressad.foundation.g.a.bN);
        } catch (Exception unused) {
            return g().getBytes();
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", n.a().p());
            jSONObjectE.put("pl_id", this.f6050c);
            jSONObjectE.put("session_id", n.a().g(this.f6050c));
            jSONObjectE.put("t_g_id", this.f6051d);
            jSONObjectE.put("gro_id", this.f6052e);
            String strY = n.a().y();
            if (!TextUtils.isEmpty(strY)) {
                jSONObjectE.put("sy_id", strY);
            }
            String strZ = n.a().z();
            if (TextUtils.isEmpty(strZ)) {
                n.a().j(n.a().x());
                jSONObjectE.put("bk_id", n.a().x());
            } else {
                jSONObjectE.put("bk_id", strZ);
            }
            if (n.a().b() != null) {
                jSONObjectE.put("deny", com.anythink.core.common.k.d.o(n.a().g()));
            }
            JSONObject jSONObjectA = com.anythink.core.common.g.c.a(this.f6050c);
            if (jSONObjectA != null) {
                jSONObjectE.put("customs", jSONObjectA);
            }
        } catch (Exception unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.g.a
    protected final JSONObject f() {
        JSONObject jSONObjectF = super.f();
        try {
            if (n.a().b() != null) {
                jSONObjectF.put("btts", com.anythink.core.common.k.d.g());
            }
        } catch (JSONException unused) {
        }
        return jSONObjectF;
    }

    @Override // com.anythink.core.common.g.a
    protected final String g() {
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.k.c.a(e().toString());
        String strA2 = com.anythink.core.common.k.c.a(f().toString());
        map.put("p", strA);
        map.put(com.anythink.core.common.g.c.X, strA2);
        map.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.b);
        map.put(k.a.b, this.a);
        return new JSONObject(map).toString();
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
    protected final int m() {
        return 2;
    }
}
