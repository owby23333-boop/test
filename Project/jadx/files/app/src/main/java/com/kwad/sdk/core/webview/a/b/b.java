package com.kwad.sdk.core.webview.a.b;

import android.text.TextUtils;
import com.bytedance.msdk.api.reward.RewardItem;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final Map<String, JSONObject> apw = new HashMap();
    public static boolean apx = true;

    public static class a {
        public String msg;
    }

    public static void N(String str, String str2) {
        s.putValue(cT(str), "c_" + str2, System.currentTimeMillis());
    }

    private static void O(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void P(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void a(com.kwad.sdk.e.kwai.b bVar, int i2) {
        KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.asH).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i2).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.AK())));
    }

    public static void a(com.kwad.sdk.e.kwai.b bVar, int i2, int i3, String str) {
        KSLoggerReporter.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.asH).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i3).setInterval(String.valueOf(System.currentTimeMillis() - bVar.AK())).setFailReason(str));
    }

    private static void a(String str, String str2, int i2, String str3) {
        long jCurrentTimeMillis;
        JSONObject jSONObject = apw.get(str2);
        if (jSONObject == null) {
            jCurrentTimeMillis = -3;
        } else {
            long jOptLong = jSONObject.optLong("c_loadUrl");
            if (jOptLong <= 0) {
                jCurrentTimeMillis = -2;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis() - jOptLong;
                if (jCurrentTimeMillis > 100000 || jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = -1;
                }
            }
        }
        KSLoggerReporter.a(i2 == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new WebViewLoadMsg().setUrl(str).setState(i2).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(jCurrentTimeMillis)).setFailReason(str3));
        cU(str2);
    }

    public static void a(String str, String str2, int i2, String str3, long j2) {
        String str4 = i2 == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG;
        if (j2 > 60000 || j2 < 0) {
            j2 = -1;
        }
        KSLoggerReporter.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i2).setInterval(String.valueOf(j2)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject jSONObjectCT = cT(str2);
        s.putValue(jSONObjectCT, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str4);
                int iOptInt = jSONObject.optInt("status");
                String strOptString = jSONObject.optString(RewardItem.KEY_ERROR_MSG, "");
                String strOptString2 = jSONObject.optString("webViewCostParams", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString2);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectCT.put(next, jSONObject2.opt(next));
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (iOptInt == 1) {
                        O(str, str2);
                    } else {
                        P(str, strOptString);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            } finally {
                cU(str2);
            }
        }
    }

    public static void b(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        s.putValue(cT(str), "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        s.putValue(cT(str), "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    private static JSONObject cT(String str) {
        JSONObject jSONObject = apw.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        apw.put(str, jSONObject2);
        return jSONObject2;
    }

    private static void cU(String str) {
        apw.remove(str);
    }

    public static void cV(String str) {
        JSONObject jSONObjectCT = cT(str);
        long jZm = com.kwad.sdk.core.webview.a.a.zl().zm();
        long jCurrentTimeMillis = jZm <= 0 ? -1L : System.currentTimeMillis() - jZm;
        s.putValue(jSONObjectCT, "c_loadUrl", System.currentTimeMillis());
        s.putValue(jSONObjectCT, "c_init_interval", jCurrentTimeMillis);
        s.putValue(jSONObjectCT, "c_init_state", apx ? 1 : 2);
        apx = false;
    }
}
