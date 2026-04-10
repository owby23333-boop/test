package com.anythink.expressad.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BaseRewardJs extends AbsFeedBackForH5 implements IRewardBridge {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final String f11965h = "JS-Reward-Brigde";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected IRewardBridge f11966i;

    private static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -1);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            o.d(f11965h, "code to string is error");
            return "";
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void cai(Object obj, String str) {
        o.a(f11965h, "cai:".concat(String.valueOf(str)));
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
                    o.a(f11965h, e2.getMessage());
                }
            } catch (Throwable th) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
                o.b(f11965h, "cai", th);
            }
        } catch (JSONException e3) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e3.getLocalizedMessage());
            o.b(f11965h, "cai", e3);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void getEndScreenInfo(Object obj, String str) {
        try {
            if (this.f11966i != null) {
                this.f11966i.getEndScreenInfo(obj, str);
                o.d(f11965h, "getEndScreenInfo factory is true");
                return;
            }
            o.d(f11965h, "getEndScreenInfo factory is null");
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a instanceof WindVaneWebView) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.anythink.expressad.atsignalcommon.a.a) windVaneWebView.getWebViewListener()).a(obj);
                    }
                }
            }
        } catch (Throwable th) {
            o.b(f11965h, "getEndScreenInfo", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void gial(Object obj, String str) {
        o.a(f11965h, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packageNameList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e2.getMessage());
            o.a(f11965h, e2.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(f11965h, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f11966i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11966i.handlerPlayableException(obj, str);
        } catch (Throwable th) {
            o.b(f11965h, "handlerPlayableException", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        boolean zIsInstance;
        super.initialize(context, windVaneWebView);
        try {
            zIsInstance = Class.forName("com.anythink.expressad.video.signal.factory.IJSFactory").isInstance(context);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            zIsInstance = false;
        }
        try {
            if (zIsInstance) {
                Class<?> cls = Class.forName("com.anythink.expressad.video.signal.communication.BaseRewardJsH5");
                this.f11966i = (IRewardBridge) cls.newInstance();
                cls.getMethod("initialize", Context.class, WindVaneWebView.class).invoke(this.f11966i, context, windVaneWebView);
            } else {
                if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof IRewardBridge)) {
                    return;
                }
                this.f11966i = (IRewardBridge) windVaneWebView.getObject();
            }
        } catch (Exception e3) {
            if (com.anythink.expressad.a.a) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void install(Object obj, String str) {
        try {
            if (this.f11966i != null) {
                this.f11966i.install(obj, str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                    com.anythink.expressad.video.signal.a.j jVar = (com.anythink.expressad.video.signal.a.j) aVar.a.getObject();
                    Context context = aVar.a.getContext();
                    if (context != null && context != context.getApplicationContext()) {
                        jVar.a(context);
                    }
                    jVar.click(1, str);
                    o.d(f11965h, "JSCommon install jump success");
                }
            }
            o.d(f11965h, "JSCommon install failed");
        } catch (Throwable th) {
            o.b(f11965h, "install", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f11966i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11966i.notifyCloseBtn(obj, str);
        } catch (Throwable th) {
            o.b(f11965h, "notifyCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void openURL(Object obj, String str) {
        o.d(f11965h, "openURL:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                l.a(this.f8328e, strOptString);
            } else if (iOptInt == 2) {
                l.b(this.f8328e, strOptString);
            }
        } catch (JSONException e2) {
            o.d(f11965h, e2.getMessage());
        } catch (Throwable th) {
            o.d(f11965h, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f11966i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11966i.setOrientation(obj, str);
        } catch (Throwable th) {
            o.b(f11965h, "setOrientation", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f11966i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11966i.toggleCloseBtn(obj, str);
        } catch (Throwable th) {
            o.b(f11965h, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IRewardBridge
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f11966i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11966i.triggerCloseBtn(obj, str);
        } catch (Throwable th) {
            o.b(f11965h, "triggerCloseBtn", th);
            j.a().a(obj, a());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        boolean zIsInstance;
        super.initialize(obj, windVaneWebView);
        try {
            zIsInstance = Class.forName("com.anythink.expressad.video.signal.factory.IJSFactory").isInstance(obj);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            zIsInstance = false;
        }
        try {
            if (zIsInstance) {
                Class<?> cls = Class.forName("com.anythink.expressad.video.signal.communication.BaseRewardJsH5");
                this.f11966i = (IRewardBridge) cls.newInstance();
                cls.getMethod("initialize", Object.class, WindVaneWebView.class).invoke(this.f11966i, obj, windVaneWebView);
            } else {
                if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof IRewardBridge)) {
                    return;
                }
                this.f11966i = (IRewardBridge) windVaneWebView.getObject();
            }
        } catch (Exception e3) {
            if (com.anythink.expressad.a.a) {
                e3.printStackTrace();
            }
        }
    }
}
