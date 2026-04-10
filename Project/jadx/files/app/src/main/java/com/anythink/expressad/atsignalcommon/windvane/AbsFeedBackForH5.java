package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.expressad.foundation.h.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsFeedBackForH5 extends l {
    public static final String a = "onFeedbackAlertStatusNotify";
    public static final String b = "status";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8296c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8297d = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f8298i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f8299j = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8300h = "AbsFeedBackForH5";

    public void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f8299j);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.a(this.f8300h, e2.getMessage());
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f8298i);
            jSONObject.put("message", "");
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            com.anythink.expressad.foundation.h.o.a(this.f8300h, e2.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f8298i);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            com.anythink.expressad.foundation.h.o.a(this.f8300h, e2.getMessage());
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("width", -1);
                int iOptInt2 = jSONObject.optInt("height", -1);
                int iOptInt3 = jSONObject.optInt("radius", 20);
                int iOptInt4 = jSONObject.optInt("left", -1);
                int iOptInt5 = jSONObject.optInt("top", -1);
                double dOptDouble = jSONObject.optDouble("opacity", 1.0d);
                String strOptString = jSONObject.optString("fontColor", "");
                String strOptString2 = jSONObject.optString("bgColor", "");
                com.anythink.expressad.foundation.f.a.a aVarA = com.anythink.expressad.foundation.f.b.a().a(jSONObject.optString("key", ""));
                Context contextG = com.anythink.core.common.b.n.a().g();
                aVarA.a(t.b(contextG, iOptInt4), t.b(contextG, iOptInt5), t.b(contextG, iOptInt), t.b(contextG, iOptInt2), t.b(contextG, iOptInt3), (float) dOptDouble, strOptString, strOptString2);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("view_visible", 1);
                String strOptString = jSONObject.optString("key", "");
                com.anythink.expressad.foundation.f.b bVarA = com.anythink.expressad.foundation.f.b.a();
                int i2 = iOptInt == 1 ? 8 : 0;
                WindVaneWebView windVaneWebView = aVar.a;
                com.anythink.expressad.foundation.f.a.a aVarA = bVarA.a(strOptString);
                if (aVarA.c() != null) {
                    aVarA.a(i2);
                    if (i2 == 0) {
                        bVarA.a(strOptString, com.anythink.core.common.b.n.a().g(), windVaneWebView, null, null);
                    }
                }
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("view_visible", 1);
                com.anythink.expressad.foundation.f.a.a aVarA = com.anythink.expressad.foundation.f.b.a().a(jSONObject.optString("key", ""));
                if (iOptInt == 1) {
                    aVarA.b();
                } else {
                    aVarA.a();
                }
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void getCacheKey(Object obj, String str) {
        try {
            com.anythink.expressad.atsignalcommon.c.a.a().a(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void startShake(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.optInt("deviceMotionUpdateInterval", 1);
                com.anythink.expressad.atsignalcommon.c.a.a().a(obj, ((a) obj).a, jSONObject.optString("oldCache", ""), jSONObject.optString("cache", ""));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void stopShake(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.anythink.expressad.atsignalcommon.c.a.a().a(obj, ((a) obj).a, new JSONObject(str).optString("cache", ""));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }
}
