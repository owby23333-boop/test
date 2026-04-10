package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends a {
    o a;
    boolean b = true;

    public l(o oVar) {
        this.a = oVar;
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return this.a.b;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return null;
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
        return this.a.f7372d;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        String str = this.a.f7371c;
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
        } catch (Exception unused) {
        }
        return map;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        JSONObject jSONObject;
        String str = this.a.f7371c;
        boolean z2 = str != null && str.contains("gzip");
        try {
            jSONObject = new JSONObject(this.a.f7373e);
            try {
                if (this.b) {
                    jSONObject.put(c.U, 1);
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            jSONObject = null;
        }
        return z2 ? jSONObject != null ? a.c(jSONObject.toString()) : new byte[0] : jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
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
    protected final boolean o() {
        return true;
    }

    public final void p() {
        this.b = false;
    }

    public final o q() {
        return this.a;
    }
}
