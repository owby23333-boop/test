package com.anythink.core.common.g;

import android.content.Context;
import com.anythink.core.api.AdError;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends a {
    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return null;
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
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strC = com.anythink.core.common.k.f.c(String.valueOf(jCurrentTimeMillis));
        StringBuilder sb = new StringBuilder();
        com.anythink.core.common.i.a();
        sb.append(com.anythink.core.common.i.d());
        sb.append("?t=");
        sb.append(jCurrentTimeMillis);
        sb.append("&sign=");
        sb.append(strC);
        return sb.toString();
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final byte[] d() {
        return new byte[0];
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
    protected final boolean n() {
        return true;
    }
}
