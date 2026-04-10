package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {
    @Override // com.efs.sdk.base.core.c.c
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z) {
        HttpResponse httpResponse;
        com.efs.sdk.base.core.a.c cVarA = com.efs.sdk.base.core.a.c.a();
        cVarA.d = bVar.f1559a.d;
        cVarA.e = bVar.f1559a.e;
        cVarA.g = bVar.f1559a.b;
        cVarA.h = bVar.f1559a.f1558a;
        cVarA.m = bVar.a();
        String strA = com.efs.sdk.base.core.config.a.c.a().a(false);
        if (bVar.f1559a.c == 0) {
            com.efs.sdk.base.core.a.a aVarA = com.efs.sdk.base.core.a.a.a();
            byte[] bArr = bVar.c;
            boolean z2 = bVar.b.b;
            String strB = cVarA.b();
            String strA2 = com.efs.sdk.base.core.a.a.a(strA, cVarA);
            if (aVarA.f1525a) {
                Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(strA2)));
            }
            HashMap map = new HashMap(1);
            map.put("wpk-header", strB);
            com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA2).a(map);
            dVarA.f1577a.c = bArr;
            dVarA.f1577a.g = true;
            httpResponse = dVarA.a("type", cVarA.h).a("size", new StringBuilder().append(cVarA.m).toString()).a("flow_limit", Boolean.toString(z2)).a(com.efs.sdk.base.core.a.d.a()).a().b();
        } else if (1 == bVar.f1559a.c) {
            httpResponse = com.efs.sdk.base.core.a.a.a().a(strA, cVarA, bVar.d, bVar.b.b);
        } else {
            httpResponse = new HttpResponse();
        }
        if (httpResponse.succ && z) {
            com.efs.sdk.base.core.util.b.b(bVar.d);
        }
        return httpResponse;
    }
}
