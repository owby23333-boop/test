package com.anythink.core.common.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import com.anythink.core.common.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j extends a {
    public static final String a = "sdk_custom";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f7508d = "j";
    long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f7509c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7510e = n.a().r();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f7513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f7514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f7516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<String, Object> f7517l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private JSONObject f7518p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, Object> f7519q;

    public j(Context context, String str, String str2, String str3, String str4, Map<String, Object> map, Map<String, Object> map2) {
        this.f7514i = str;
        this.f7515j = str2;
        this.f7513h = context;
        this.f7512g = str3;
        this.f7511f = n.a().g(str3);
        this.f7516k = str4;
        this.f7517l = map;
        this.f7519q = map2;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    public final void a(int i2, i iVar) {
        this.b = System.currentTimeMillis();
        this.f7509c = SystemClock.elapsedRealtime();
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
        return com.anythink.core.common.i.c();
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
        Object obj;
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", this.f7514i);
            jSONObjectE.put("pl_id", this.f7512g);
            jSONObjectE.put("session_id", this.f7511f);
            jSONObjectE.put("nw_ver", com.anythink.core.common.k.d.h());
            jSONObjectE.put("exclude_myofferid", s.a().a(this.f7513h));
            if (n.a().l() != null) {
                jSONObjectE.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, n.a().l());
            }
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
            JSONObject jSONObjectA = c.a(this.f7517l);
            if (jSONObjectA != null) {
                jSONObjectE.put("custom", jSONObjectA);
            }
            if (n.a().b() != null) {
                jSONObjectE.put("deny", com.anythink.core.common.k.d.o(n.a().g()));
            }
            if (n.a().v()) {
                n.a().w().fillRequestParam(jSONObjectE);
            }
            jSONObjectE.put(c.ap, com.anythink.core.common.n.a().c());
            if (this.f7519q != null && (obj = this.f7519q.get(ATAdConst.KEY.CP_PLACEMENT_ID)) != null) {
                jSONObjectE.put(c.am, obj.toString());
            }
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
        return this.f7514i;
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return this.f7513h;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return this.f7515j;
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
        com.anythink.core.common.j.c.a("placement", adError.getPlatformCode(), adError.getPlatformMSG(), (String) null, this.f7512g, "", "");
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        String strTrim = str.trim();
        try {
            JSONObject jSONObject = new JSONObject(strTrim);
            if (this.f7517l != null) {
                jSONObject.put(a, new JSONObject(this.f7517l));
            }
            strTrim = jSONObject.toString();
        } catch (Exception unused) {
        }
        com.anythink.core.common.j.c.a("placement", this.f7512g, this.b, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.f7509c);
        return strTrim;
    }
}
