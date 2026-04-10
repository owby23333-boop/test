package com.efs.sdk.base.core.f;

import android.text.TextUtils;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.efs.sdk.base.core.c.c {
    private static void a(HttpResponse httpResponse) {
        if (httpResponse == null || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        for (String str : httpResponse.data.split("`")) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length >= 2) {
                if (strArrSplit[0].equalsIgnoreCase("retcode")) {
                    httpResponse.setBizCode(strArrSplit[1]);
                } else {
                    ((Map) httpResponse.extra).put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.c.c
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z) {
        HttpResponse httpResponse;
        try {
            c cVar = f.a.f1570a.f1569a;
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String strA = com.efs.sdk.base.core.util.b.b.a(cVar.b + cVar.c + strValueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = cVar.f1568a;
            if (str.startsWith("http")) {
                sb.append(str).append("?chk=");
            } else {
                sb.append(str).append("?chk=");
            }
            sb.append(strA.substring(strA.length() - 8)).append("&vno=").append(strValueOf).append("&uuid=").append(cVar.c).append("&app=").append(cVar.b).append("&zip=gzip");
            String string = sb.toString();
            int length = 0;
            byte[] bArrA = new byte[0];
            if (bVar.f1559a.c == 0) {
                bArrA = bVar.c;
                length = bArrA.length;
            } else if (1 == bVar.f1559a.c) {
                bArrA = com.efs.sdk.base.core.util.b.a(bVar.d.getPath());
                length = bArrA.length;
            }
            HashMap map = new HashMap();
            map.put(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            map.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(length));
            com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(string).a(map);
            dVarA.f1577a.c = bArrA;
            httpResponse = dVarA.a().b();
            a(httpResponse);
        } catch (Throwable th) {
            httpResponse = 0 == 0 ? new HttpResponse() : null;
            Log.e("efs.wa.send", "get file size error", th);
        }
        if (httpResponse.succ) {
            Log.i("efs.base", "wa upload succ, " + httpResponse.toString());
            com.efs.sdk.base.core.util.b.b(bVar.d);
            return httpResponse;
        }
        Log.i("efs.base", "wa upload fail, resp is " + httpResponse.toString());
        return httpResponse;
    }
}
