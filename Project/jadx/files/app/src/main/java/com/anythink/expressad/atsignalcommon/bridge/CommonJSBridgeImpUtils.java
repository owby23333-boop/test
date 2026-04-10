package com.anythink.expressad.atsignalcommon.bridge;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CommonJSBridgeImpUtils {
    public static final String a = "CommonJSBridgeImpUtils";
    public static int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f8274c = 1;

    static /* synthetic */ void a(String str, c cVar) {
        if (f.f10448n == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, "banner");
    }

    private static void b(String str, c cVar) {
        if (f.f10448n == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, "banner");
    }

    public static String buildClickJsonObject(float f2, float f3) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(a.cc, t.a(n.a().g(), f2));
            jSONObject2.put(a.cd, t.a(n.a().g(), f3));
            jSONObject2.put(a.cf, 0);
            jSONObject2.put(a.cg, n.a().g().getResources().getConfiguration().orientation);
            jSONObject2.put(a.ch, t.c(n.a().g()));
            jSONObject.put(a.ce, jSONObject2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f8274c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(a, e2.getMessage());
        }
    }

    public static void callbackSuccess(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            o.a(a, e2.getMessage());
        }
    }

    public static String codeToJsonString(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            o.d(a, "code to string is error");
            return "";
        }
    }

    public static void increaseOfferFrequence(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                callbackExcep(obj, "data is empty");
                return;
            }
            c cVarB = c.b(jSONObjectOptJSONObject);
            if (cVarB == null) {
                callbackExcep(obj, "data camapign is empty");
            } else {
                updateFrequence(cVarB);
                callbackSuccess(obj, "");
            }
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
        }
    }

    public static void updateFrequence(final c cVar) {
        new Thread(new Runnable() { // from class: com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CommonJSBridgeImpUtils.a(cVar.K(), cVar);
                } catch (Throwable th) {
                    o.b(CommonJSBridgeImpUtils.a, th.getMessage(), th);
                }
            }
        }).start();
    }
}
