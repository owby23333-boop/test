package com.anythink.core.common.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {
    public static final String a = "custom";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f7488e = "d";
    long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f7489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, Object> f7490d = n.a().m();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f7493h;

    public d(Context context, String str, String str2) {
        this.f7491f = str;
        this.f7492g = str2;
        this.f7493h = context;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(int i2, i iVar) {
        this.b = System.currentTimeMillis();
        this.f7489c = SystemClock.elapsedRealtime();
        super.a(i2, iVar);
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
        com.anythink.core.common.i.a();
        return com.anythink.core.common.i.b();
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put("Accept-Encoding", "gzip");
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
            jSONObjectE.put("app_id", this.f7491f);
            jSONObjectE.put("nw_ver", com.anythink.core.common.k.d.h());
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
            JSONObject jSONObjectB = c.b();
            if (jSONObjectB != null) {
                jSONObjectE.put("custom", jSONObjectB);
            }
            if (n.a().b() != null) {
                jSONObjectE.put("deny", com.anythink.core.common.k.d.o(n.a().g()));
            }
            jSONObjectE.put(c.R, n.a().H() ? 1 : 2);
            if (n.a().v()) {
                jSONObjectE.put("is_test", 1);
            }
            jSONObjectE.put(c.ap, com.anythink.core.common.n.a().c());
            com.anythink.core.common.n.a();
            jSONObjectE.put("pil_offset", com.anythink.core.common.n.b());
        } catch (JSONException unused) {
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
    protected final String h() {
        return this.f7491f;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.f7493h;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.f7492g;
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
        return 3;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean n() {
        return true;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
        com.anythink.core.common.j.c.a("app", adError.getPlatformCode(), adError.getPlatformMSG(), (String) null, "", "", "");
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        String strTrim = str.trim();
        try {
            JSONObject jSONObject = new JSONObject(strTrim);
            if (this.f7490d != null) {
                jSONObject.put("custom", new JSONObject(this.f7490d));
            }
            strTrim = jSONObject.toString();
        } catch (Exception unused) {
        }
        com.anythink.core.common.j.c.a("app", (String) null, this.b, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.f7489c);
        return strTrim;
    }
}
