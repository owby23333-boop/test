package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.core.common.g.g;
import com.anythink.core.common.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.anythink.core.common.g.a {
    String a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f6055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f6057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f6058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f6059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String[] f6060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f6061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f6062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f6063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String f6064l = "OnlineOfferLoader";

    public d(j jVar, int i2, int i3, String[] strArr, String str) {
        this.a = jVar.f7303d;
        this.b = jVar.b;
        this.f6055c = jVar.f7302c;
        this.f6061i = jVar.f7304e;
        this.f6058f = i2;
        this.f6059g = i3;
        this.f6060h = strArr;
        this.f6056d = jVar.f7307h;
        this.f6057e = jVar.f7308i;
        this.f6062j = jVar.f7309j;
        this.f6063k = str;
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
                a(i2, g.f7506k, obj.toString(), ErrorCode.getErrorCode(ErrorCode.noADError, "", obj.toString()));
            } else {
                super.a(i2, obj);
            }
        } catch (Throwable th) {
            a(i2, -99999, obj != null ? obj.toString() : th.getMessage(), ErrorCode.getErrorCode(ErrorCode.noADError, "", obj != null ? obj.toString() : "Online Api Service Error."));
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
        i.a();
        return i.h();
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
            jSONObjectE.put("pl_id", this.b);
            jSONObjectE.put("session_id", n.a().g(this.b));
            jSONObjectE.put("t_g_id", this.f6056d);
            jSONObjectE.put("gro_id", this.f6057e);
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
            jSONObjectE.put(com.anythink.core.common.g.c.ap, com.anythink.core.common.n.a().c());
            JSONObject jSONObjectA = com.anythink.core.common.g.c.a(this.b);
            if (jSONObjectA != null) {
                jSONObjectE.put("customs", jSONObjectA);
            }
            com.anythink.core.common.g.c.a(jSONObjectE);
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

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e1  */
    @Override // com.anythink.core.common.g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final java.lang.String g() {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.g.d.g():java.lang.String");
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
