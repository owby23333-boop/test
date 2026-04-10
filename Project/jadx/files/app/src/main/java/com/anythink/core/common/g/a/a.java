package com.anythink.core.common.g.a;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.o;
import com.anythink.core.common.k.f;
import com.anythink.core.common.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {
    List<String> a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f7438c;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f7439k = a.class.getSimpleName();

    public a(List<String> list) {
        this.a = list;
        this.b = list.size();
    }

    private String i() throws JSONException {
        JSONObject jSONObjectG = super.g();
        JSONObject jSONObjectA = com.anythink.core.common.g.c.a();
        if (jSONObjectG != null) {
            try {
                jSONObjectG.put("app_id", n.a().p());
                jSONObjectG.put("nw_ver", com.anythink.core.common.k.d.h());
                JSONArray jSONArray = new JSONArray();
                if (this.a != null && this.a.size() > 0) {
                    for (String str : this.a) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONArray.put(new JSONObject(str));
                        }
                    }
                }
                jSONObjectG.put("data", jSONArray);
            } catch (Exception unused) {
            }
        }
        try {
            jSONObjectA.put(com.anythink.core.common.g.c.T, this.f7447i);
            jSONObjectA.put(com.anythink.core.common.g.c.V, this.f7448j);
        } catch (Exception unused2) {
        }
        HashMap map = new HashMap();
        String strA = com.anythink.core.common.k.c.a(jSONObjectG.toString());
        String strA2 = com.anythink.core.common.k.c.a(jSONObjectA.toString());
        map.put(com.anythink.core.common.g.c.O, "1.0");
        map.put("p", strA);
        map.put(com.anythink.core.common.g.c.X, strA2);
        ArrayList<String> arrayList = new ArrayList(map.size());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            if (sb.length() > 0) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            }
            sb.append(str2);
            sb.append("=");
            sb.append(map.get(str2));
        }
        map.put("sign", f.c(n.a().q() + sb.toString()));
        return new JSONObject(map).toString();
    }

    public final void a() {
        this.f7438c = true;
    }

    public final int b() {
        return this.b;
    }

    @Override // com.anythink.core.common.g.a.c
    public final int c() {
        return 2;
    }

    @Override // com.anythink.core.common.g.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.g.a.c
    public final byte[] e() {
        return c.a(i());
    }

    @Override // com.anythink.core.common.g.a.c
    public final boolean f() {
        return false;
    }

    @Override // com.anythink.core.common.g.a.c
    public final void a(String str, String str2, String str3, int i2) throws JSONException {
        if (this.f7438c) {
            u.a().a(3, "", "", i(), o.a(1001));
        }
    }
}
