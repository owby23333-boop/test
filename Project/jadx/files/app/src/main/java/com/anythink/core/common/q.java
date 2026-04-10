package com.anythink.core.common;

import android.text.TextUtils;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.appsflyer.AppsFlyerLib;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile q f7851c;
    private final String a = "1";
    private final String b = "2";

    private q() {
    }

    public static q a() {
        if (f7851c == null) {
            synchronized (q.class) {
                if (f7851c == null) {
                    f7851c = new q();
                }
            }
        }
        return f7851c;
    }

    public static void a(com.anythink.core.common.e.e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(eVar.W());
            if (dVarA != null) {
                String strB = dVarA.B();
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strB);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("1");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("token");
                    if (!TextUtils.isEmpty(strOptString)) {
                        String strP = eVar.p();
                        double dW = eVar.w() / 1000.0d;
                        String strL = eVar.l();
                        try {
                            AdjustEvent adjustEvent = new AdjustEvent(strOptString);
                            adjustEvent.setRevenue(dW, strP);
                            adjustEvent.setOrderId(strL);
                            Adjust.trackEvent(adjustEvent);
                        } catch (Throwable unused) {
                        }
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("2");
                if (jSONObjectOptJSONObject2 != null) {
                    int iOptInt = jSONObjectOptJSONObject2.optInt("rtye");
                    HashMap map = new HashMap();
                    map.put("af_order_id", eVar.l());
                    map.put("af_content_id", eVar.W());
                    map.put("af_content_type", eVar.Y());
                    map.put("af_revenue", Double.valueOf(iOptInt == 2 ? eVar.w() : eVar.w() / 1000.0d));
                    map.put("af_currency", "USD");
                    AppsFlyerLib.getInstance().trackEvent(com.anythink.core.common.b.n.a().g(), "af_ad_view", map);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private static void a(String str, double d2, String str2, String str3) {
        try {
            AdjustEvent adjustEvent = new AdjustEvent(str);
            adjustEvent.setRevenue(d2, str2);
            adjustEvent.setOrderId(str3);
            Adjust.trackEvent(adjustEvent);
        } catch (Throwable unused) {
        }
    }
}
