package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.k;
import com.anythink.core.common.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.anythink.core.common.g.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f6065f = "e";
    int a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    aa f6066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, Object> f6067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f6068e = false;

    public e(int i2, String str, aa aaVar, Map<String, Object> map) {
        this.a = i2;
        this.b = str;
        this.f6066c = aaVar;
        this.f6067d = map;
    }

    private void p() {
        String string;
        try {
            string = new JSONObject(c()).toString();
        } catch (Throwable unused) {
            string = new JSONObject().toString();
        }
        t.a().a(this.f7437o, string, this.f6066c.O());
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
    }

    public final void a(boolean z2) {
        this.f6068e = z2;
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        if (this.f6067d != null && !TextUtils.isEmpty(this.b)) {
            try {
                for (Map.Entry<String, Object> entry : this.f6067d.entrySet()) {
                    String key = entry.getKey();
                    this.b = this.b.replaceAll("\\{" + key + "\\}", (String) entry.getValue());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        if (this.f6066c == null) {
            return null;
        }
        HashMap map = new HashMap();
        k kVarK = this.f6066c.k();
        if (kVarK != null && com.anythink.basead.a.b.a(this.a, kVarK)) {
            String strI = com.anythink.core.common.k.d.i();
            if (!TextUtils.isEmpty(strI)) {
                map.put("User-Agent", strI);
            }
        }
        return map;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.g.a
    protected final String g() {
        return "";
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
    protected final void b(int i2) {
        String string;
        if (this.f6068e) {
            new StringBuilder("handleErrorStatusCode, start to check, url: ").append(this.b);
            t.a();
            if (t.a(i2)) {
                try {
                    string = new JSONObject(c()).toString();
                } catch (Throwable unused) {
                    string = new JSONObject().toString();
                }
                t.a().a(this.f7437o, string, this.f6066c.O());
            }
        }
    }
}
