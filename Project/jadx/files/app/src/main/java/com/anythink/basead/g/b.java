package com.anythink.basead.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.o;
import com.anythink.core.common.e.s;
import com.anythink.core.common.u;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.anythink.core.common.g.a {
    String a;
    JSONObject b;

    public b(int i2, s sVar, String str) {
        String strQ = "";
        try {
            switch (i2) {
                case 1:
                    strQ = sVar.Q();
                    break;
                case 2:
                    strQ = sVar.R();
                    break;
                case 3:
                    strQ = sVar.S();
                    break;
                case 4:
                    strQ = sVar.T();
                    break;
                case 5:
                    strQ = sVar.U();
                    break;
                case 6:
                    strQ = sVar.V();
                    break;
                case 7:
                    strQ = sVar.W();
                    break;
                case 8:
                    strQ = sVar.X();
                    break;
                case 9:
                    strQ = sVar.Y();
                    break;
            }
            Uri uri = Uri.parse(sVar.R(strQ));
            this.a = uri.getScheme() + HttpConstant.SCHEME_SPLIT + uri.getAuthority() + uri.getPath();
            this.b = new JSONObject();
            for (String str2 : uri.getQueryParameterNames()) {
                this.b.put(str2, URLEncoder.encode(uri.getQueryParameter(str2)));
            }
            this.b.put("req_id", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.g.a
    protected final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.g.a
    protected final Object a(String str) {
        return null;
    }

    @Override // com.anythink.core.common.g.a
    protected final void a(AdError adError) {
        JSONObject jSONObject = new JSONObject();
        Map<String, String> mapC = c();
        if (mapC != null) {
            try {
                for (String str : mapC.keySet()) {
                    jSONObject.put(str, mapC.get(str));
                }
            } catch (Exception unused) {
            }
        }
        String string = jSONObject.toString();
        JSONObject jSONObject2 = this.b;
        String string2 = jSONObject2 != null ? jSONObject2.toString() : "";
        u.a().a(1, b(), string, string2, o.a(1000));
        com.anythink.core.common.j.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), this.a, "", "1", "");
    }

    @Override // com.anythink.core.common.g.a
    protected final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.g.a
    protected final void b(AdError adError) {
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.b.put("scenario", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return new byte[0];
        }
        try {
            jSONObject.put("t", String.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
        return com.anythink.core.common.g.a.c(this.b.toString());
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
    protected final String b() {
        return this.a;
    }
}
