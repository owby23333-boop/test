package com.anythink.expressad.atsignalcommon.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CommonBannerJSBridgeImp implements IBannerJSBridge {
    public static final String a = "CommonBannerJSBridgeImp";

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void cai(Object obj, String str) {
        o.a(a, "cai:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String strOptString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(strOptString)) {
                    CommonJSBridgeImpUtils.callbackExcep(obj, "packageName is empty");
                }
                int i2 = t.a(n.a().g(), strOptString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", CommonJSBridgeImpUtils.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i2);
                    jSONObject.put("data", jSONObject2);
                    j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    CommonJSBridgeImpUtils.callbackExcep(obj, e2.getMessage());
                    o.a(a, e2.getMessage());
                }
            } catch (Throwable th) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
                o.b(a, "cai", th);
            }
        } catch (JSONException e3) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e3.getLocalizedMessage());
            o.b(a, "cai", e3);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void click(Object obj, String str) {
        o.a(a, "click: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void getFileInfo(Object obj, String str) {
        o.a(a, "getFileInfo:".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void getNetstat(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        o.d(a, "getNetstat:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        Context contextG = n.a().g();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextG == null) {
            try {
                if ((obj instanceof a) && (windVaneWebView = ((a) obj).a) != null) {
                    contextG = windVaneWebView.getContext();
                }
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
        }
        if (contextG == null) {
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(1));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NativeAdvancedJsUtils.f8243m, k.a());
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                string = Base64.encodeToString(string.getBytes(), 2);
            }
            j.a().a(obj, string);
        } catch (Throwable th) {
            o.d(a, th.getMessage());
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(1));
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void gial(Object obj, String str) {
        o.a(a, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e2.getMessage());
            o.a(a, e2.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void handlerH5Exception(Object obj, String str) {
        o.a(a, "handlerH5Exception: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void increaseOfferFrequence(Object obj, String str) {
        o.a(a, "increaseOfferFrequence:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                CommonJSBridgeImpUtils.increaseOfferFrequence(obj, new JSONObject(str));
            } catch (Throwable th) {
                o.b(a, "increaseOfferFrequence", th);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void init(Object obj, String str) {
        o.a(a, "init: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void install(Object obj, String str) {
        o.a(a, "install: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void onJSBridgeConnect(Object obj, String str) {
        try {
            if (obj instanceof a) {
                j.a();
                j.b(((a) obj).a);
            }
        } catch (Throwable th) {
            o.b(a, "onJSBridgeConnect", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        o.d(a, "openURL:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        Context contextG = n.a().g();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextG == null) {
            try {
                if ((obj instanceof a) && (windVaneWebView = ((a) obj).a) != null) {
                    contextG = windVaneWebView.getContext();
                }
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
        }
        if (contextG == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                l.a(contextG, strOptString);
            } else if (iOptInt == 2) {
                l.b(contextG, strOptString);
            }
        } catch (JSONException e3) {
            o.d(a, e3.getMessage());
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void readyStatus(Object obj, String str) {
        o.a(a, "readyStatus: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void reportUrls(Object obj, String str) {
        o.a(a, "reportUrls:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int iOptInt = jSONObject.optInt("type");
                String strOptString = jSONObject.optString("url");
                int iOptInt2 = jSONObject.optInt(AgooConstants.MESSAGE_REPORT);
                boolean z2 = true;
                if (iOptInt2 == 0) {
                    Context contextG = n.a().g();
                    if (iOptInt == 0) {
                        z2 = false;
                    }
                    com.anythink.expressad.a.a.a(contextG, (c) null, "", strOptString, z2);
                } else {
                    com.anythink.expressad.a.a.a(n.a().g(), null, "", strOptString, false, iOptInt != 0, iOptInt2);
                }
            }
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(0));
        } catch (Throwable th) {
            o.b(a, "reportUrls", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void resetCountdown(Object obj, String str) {
        o.a(a, "resetCountdown: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void sendImpressions(Object obj, String str) {
        o.a(a, "sendImpressions: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void toggleCloseBtn(Object obj, String str) {
        o.a(a, "toggleCloseBtn: ".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void triggerCloseBtn(Object obj, String str) {
        o.a(a, "triggerCloseBtn: ".concat(String.valueOf(str)));
    }
}
