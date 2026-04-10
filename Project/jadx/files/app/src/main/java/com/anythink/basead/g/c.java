package com.anythink.basead.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.anythink.core.common.g.a {
    String a;
    boolean b;

    public c(String str, String str2, boolean z2) {
        this.b = false;
        this.b = z2;
        this.a = str.replaceAll("\\{req_id\\}", str2 == null ? "" : str2);
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

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final String b() {
        return this.a;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    @Override // com.anythink.core.common.g.a
    protected final Map<String, String> c() {
        if (!this.b) {
            return null;
        }
        HashMap map = new HashMap();
        String strI = com.anythink.core.common.k.d.i();
        if (!TextUtils.isEmpty(strI)) {
            map.put("User-Agent", strI);
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
}
