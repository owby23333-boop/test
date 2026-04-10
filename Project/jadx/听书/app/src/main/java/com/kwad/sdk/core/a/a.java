package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.utils.v;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements g {
    private static String sPkgId;

    @Override // com.kwad.sdk.core.a.g
    public final void g(Map<String, String> map) {
        map.put("Ks-PkgId", He());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.g
    public final String as(String str) throws Throwable {
        try {
            String strEO = v.eO(0);
            return new String(c.Hf().encode(b.encrypt(strEO.getBytes("UTF-8"), b.compress(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.g
    public final String getResponseData(String str) {
        try {
            return new String(b.decompress(b.decrypt(v.eO(0), c.Hh().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.g
    public final void a(String str, Map<String, String> map, String str2) {
        f.a(str, map, str2);
    }

    private static String He() {
        if (!TextUtils.isEmpty(sPkgId)) {
            return sPkgId;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        String str = context.getPackageName() + bl.getSignMd5Str(context);
        sPkgId = str;
        return str;
    }
}
