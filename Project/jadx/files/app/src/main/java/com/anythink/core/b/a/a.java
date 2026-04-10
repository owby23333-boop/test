package com.anythink.core.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.c.d;
import com.anythink.core.c.e;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.c;
import com.anythink.core.common.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.anythink.core.common.g.a {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6485c = "ex_pkg";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6486d = "unit_ids";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f6487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f6488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f6489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f6490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f6491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f6492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String f6493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f6494l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f6495p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f6496q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    String f6497r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String f6498s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String f6499t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f6500u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f6501v = d.a.f6718j;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f6502w = ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f6503x = "ch_info";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final String f6504y = "wf";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final String f6505z = "np";
    private final String A = "hb_size";
    private final String B = "last_wf";
    private final String C = "co";
    private final String D = d.a.T;
    private final String E = "debug";

    public a(String str, String str2, String str3, List<JSONObject> list, int i2) {
        this.f6500u = 0;
        this.f6487e = str3;
        this.f6490h = str;
        this.f6491i = str2;
        this.f6500u = i2;
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        this.f6488f = c.a(jSONArray.toString().getBytes());
        d dVarA = e.a(n.a().g()).a(str2);
        if (dVarA != null) {
            this.f6494l = dVarA.O();
            this.f6495p = dVarA.ae();
        }
    }

    private void a(String str, String str2, String str3) {
        if (str != null) {
            this.f6489g = c.a(str.getBytes());
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, str2)) {
            this.f6492j = c.a(str2.getBytes());
        }
        if (TextUtils.isEmpty(str3) || TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, str3)) {
            return;
        }
        this.f6493k = c.a(str3.getBytes());
    }

    private void d(int i2) {
        this.f6496q = i2;
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
        return this.f6490h;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        HashMap map = new HashMap();
        if (this.f6500u == 0) {
            map.put("Accept-Encoding", "gzip");
        }
        map.put("Content-Type", "application/json;charset=utf-8");
        return map;
    }

    @Override // com.anythink.core.common.g.a
    protected final JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("app_id", n.a().p());
            jSONObjectE.put("pl_id", this.f6491i);
            jSONObjectE.put("session_id", n.a().g(this.f6491i));
            jSONObjectE.put("t_g_id", this.f6494l);
            jSONObjectE.put("gro_id", this.f6495p);
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
            if (this.f6500u == 0) {
                jSONObjectE.put("misk_spt", p.a().c());
                p.a();
                jSONObjectE.put("misk_pt_det", p.b());
            }
            jSONObjectE.put(com.anythink.core.common.g.c.ap, com.anythink.core.common.n.a().c());
            JSONObject jSONObjectA = com.anythink.core.common.g.c.a(this.f6491i);
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

    @Override // com.anythink.core.common.g.a
    protected final String g() {
        HashMap map = new HashMap();
        String strA = c.a(e().toString());
        String strA2 = c.a(f().toString());
        map.put("p", strA);
        map.put(com.anythink.core.common.g.c.X, strA2);
        map.put(d.a.f6718j, this.f6488f);
        map.put(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, this.f6487e);
        int i2 = this.f6496q;
        if (i2 > 0) {
            map.put("hb_size", Integer.valueOf(i2));
        }
        if (this.f6500u == 0) {
            if (!TextUtils.isEmpty(this.f6489g)) {
                map.put("ch_info", this.f6489g);
            }
            if (!TextUtils.isEmpty(this.f6492j)) {
                map.put("wf", this.f6492j);
            }
            if (!TextUtils.isEmpty(this.f6493k)) {
                map.put("np", this.f6493k);
            }
            if (!TextUtils.isEmpty(this.f6497r)) {
                map.put("last_wf", this.f6497r);
            }
            if (!TextUtils.isEmpty(this.f6498s)) {
                map.put("co", this.f6498s);
            }
            map.put(d.a.T, this.f6499t);
            if (n.a().l() != null) {
                map.put(f6485c, c.a(n.a().l().toString()));
            }
            if (n.a().A() && n.a().u()) {
                map.put("debug", 1);
            }
        }
        Set<String> setKeySet = map.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : setKeySet) {
                jSONObject.put(str, map.get(str));
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            System.gc();
            return null;
        }
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

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return g().getBytes();
    }

    public final void a(b bVar) {
        String str = bVar.a;
        if (str != null) {
            this.f6489g = c.a(str.getBytes());
        }
        this.f6496q = bVar.f6509f;
        if (!TextUtils.isEmpty(bVar.b) && !TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, bVar.b)) {
            this.f6492j = c.a(bVar.b.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.f6506c) && !TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, bVar.f6506c)) {
            this.f6493k = c.a(bVar.f6506c.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.f6507d) && !TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, bVar.f6507d)) {
            this.f6497r = c.a(bVar.f6507d.getBytes());
        }
        if (!TextUtils.isEmpty(bVar.f6508e) && !TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, bVar.f6508e)) {
            this.f6498s = c.a(bVar.f6508e.getBytes());
        }
        this.f6499t = "";
        if (TextUtils.isEmpty(bVar.f6510g)) {
            return;
        }
        this.f6499t = c.a(bVar.f6510g.getBytes());
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
