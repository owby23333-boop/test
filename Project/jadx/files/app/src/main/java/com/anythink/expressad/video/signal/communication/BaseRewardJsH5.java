package com.anythink.expressad.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.signal.factory.IJSFactory;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BaseRewardJsH5 implements IRewardBridge {
    protected static final String a = "JS-Reward-Brigde";
    protected IJSFactory b;

    private static String a(int i2) {
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

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void cai(Object obj, String str) {
        o.a(a, "cai:".concat(String.valueOf(str)));
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
            } catch (JSONException e3) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e3.getLocalizedMessage());
                o.b(a, "cai", e3);
            }
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
            o.b(a, "cai", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void getEndScreenInfo(Object obj, String str) {
        String strEncodeToString;
        try {
            if (this.b != null) {
                String strA = this.b.getIJSRewardVideoV1().a();
                if (TextUtils.isEmpty(strA)) {
                    strEncodeToString = "";
                    o.a(a, "getEndScreenInfo failed");
                } else {
                    strEncodeToString = Base64.encodeToString(strA.getBytes(), 2);
                    o.a(a, "getEndScreenInfo success");
                }
                j.a().a(obj, strEncodeToString);
            }
        } catch (Throwable th) {
            o.b(a, "getEndScreenInfo", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void gial(Object obj, String str) {
        o.a(a, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packageNameList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e2.getMessage());
            o.a(a, e2.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString("msg");
            o.a(a, "handlerPlayableException,msg:".concat(String.valueOf(str)));
            this.b.getIJSRewardVideoV1().handlerPlayableException(strOptString);
        } catch (Throwable th) {
            o.b(a, "setOrientation", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        if (context instanceof IJSFactory) {
            this.b = (IJSFactory) context;
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void install(Object obj, String str) {
        com.anythink.expressad.video.signal.a.j jVar;
        Context context;
        try {
            if (this.b != null) {
                o.a(a, "install:".concat(String.valueOf(str)));
                if (obj != null) {
                    a aVar = (a) obj;
                    if ((aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) && (jVar = (com.anythink.expressad.video.signal.a.j) aVar.a.getObject()) != null && (context = aVar.a.getContext()) != null && context != context.getApplicationContext()) {
                        jVar.a(context);
                    }
                }
                if (this.b.getJSContainerModule().endCardShowing()) {
                    this.b.getJSCommon().click(3, str);
                } else {
                    this.b.getJSCommon().click(1, str);
                }
            }
        } catch (Throwable th) {
            o.b(a, "install", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(CallMraidJS.b);
            o.a(a, "notifyCloseBtn,state:".concat(String.valueOf(str)));
            this.b.getIJSRewardVideoV1().notifyCloseBtn(iOptInt);
        } catch (Throwable th) {
            o.b(a, "notifyCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        o.d(a, "openURL:".concat(String.valueOf(str)));
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

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void setOrientation(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString(CallMraidJS.b);
            o.a(a, "setOrientation,state:".concat(String.valueOf(str)));
            this.b.getIJSRewardVideoV1().b(strOptString);
        } catch (Throwable th) {
            o.b(a, "setOrientation", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(CallMraidJS.b);
            o.a(a, "toggleCloseBtn,state:".concat(String.valueOf(str)));
            this.b.getIJSRewardVideoV1().toggleCloseBtn(iOptInt);
        } catch (Throwable th) {
            o.b(a, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.b == null || TextUtils.isEmpty(str)) {
                return;
            }
            j.a().a(obj, a(0));
            this.b.getIJSRewardVideoV1().a(new JSONObject(str).optString(CallMraidJS.b));
            o.a(a, "triggerCloseBtn,state:".concat(String.valueOf(str)));
        } catch (Throwable th) {
            o.b(a, "triggerCloseBtn", th);
            j.a().a(obj, a(-1));
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        if (obj instanceof IJSFactory) {
            this.b = (IJSFactory) obj;
        }
    }
}
