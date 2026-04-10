package com.efs.sdk.base.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static volatile long b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1525a;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        this.f1525a = true;
    }

    /* JADX INFO: renamed from: com.efs.sdk.base.core.a.a$a, reason: collision with other inner class name */
    static class C0232a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1526a = new a(0);
    }

    public static a a() {
        return C0232a.f1526a;
    }

    public static long b() {
        if (b == -1) {
            return System.currentTimeMillis();
        }
        return SystemClock.elapsedRealtime() + b;
    }

    public final HttpResponse a(String str, c cVar, File file, boolean z) {
        String strB = cVar.b();
        String strA = a(str, cVar);
        if (this.f1525a) {
            Log.i("efs.px.api", "Upload file, url is ".concat(String.valueOf(strA)));
        }
        HashMap map = new HashMap(1);
        map.put("wpk-header", strB);
        com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA).a(map);
        dVarA.f1577a.d = file;
        return dVarA.a("type", cVar.h).a("size", new StringBuilder().append(cVar.m).toString()).a("flow_limit", Boolean.toString(z)).a(d.a()).a().b();
    }

    public static String a(String str, c cVar) {
        byte b2 = cVar.g;
        return str + (b2 != 1 ? b2 != 2 ? b2 != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload" : "/perf_upload" : "/apm_logs");
    }

    static void a(HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.data);
            String strOptString = jSONObject.optString("code", "-1");
            httpResponse.setBizCode(strOptString);
            if (!"0".equals(strOptString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j = jSONObject.getLong("stm") * 1000;
            if (Math.abs(j - b()) > 1500000) {
                b = j - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th) {
            Log.e("efs.px.api", "checkPxReturn error", th);
        }
    }
}
