package com.anythink.core.common.g;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {
    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return str;
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
        return com.anythink.core.common.i.e();
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
            jSONObjectE.put("curr_ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObjectE;
    }

    @Override // com.anythink.core.common.g.a
    protected final String g() {
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.k.c.a(e().toString());
        map.put(c.O, "1.0");
        map.put("p", strA);
        ArrayList<String> arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (sb.length() > 0) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
        }
        try {
            map.put("sign", URLEncoder.encode(com.anythink.core.common.k.f.c(n.a().q() + sb.toString()), com.anythink.expressad.foundation.g.a.bN));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return new JSONObject(map).toString();
    }

    @Override // com.anythink.core.common.g.a
    protected final String h() {
        return n.a().p();
    }

    @Override // com.anythink.core.common.g.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final String j() {
        return n.a().q();
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
