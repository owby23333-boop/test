package com.anythink.expressad.splash.js;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.foundation.h.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SplashJs extends AbsFeedBackForH5 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f11366h = "SplashJs";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SplashJSBridgeImpl f11367i;

    public void cai(Object obj, String str) {
        o.d(f11366h, "cai".concat(String.valueOf(str)));
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11367i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.cai(obj, str);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SplashJsUtils.getFileInfo(obj, new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void gial(Object obj, String str) {
        o.d(f11366h, "gial".concat(String.valueOf(str)));
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11367i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.gial(obj, str);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        if (obj != null) {
            try {
                a aVar = (a) obj;
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().onReceivedError(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
                    }
                }
            } catch (Throwable th) {
                o.b(f11366h, "handlerH5Exception", th);
            }
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            SplashJsUtils.increaseOfferFrequence(obj, new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void init(Object obj, String str) {
        o.d(f11366h, "initialize".concat(String.valueOf(str)));
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11367i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.init(obj, str);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof SplashJSBridgeImpl)) {
                return;
            }
            this.f11367i = (SplashJSBridgeImpl) windVaneWebView.getObject();
        } catch (Throwable th) {
            o.b(f11366h, "initialize", th);
        }
    }

    public void install(Object obj, String str) {
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11367i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.install(obj, str);
        }
    }

    public void onJSBridgeConnect(Object obj, String str) {
        try {
            o.d(f11366h, "onJSBridgeConnect");
            if (this.f11367i != null) {
                this.f11367i.onJSBridgeConnect(obj, str);
            }
        } catch (Throwable th) {
            o.b(f11366h, "onJSBridgeConnect", th);
        }
    }

    public void openURL(Object obj, String str) {
        o.d(f11366h, "openURL".concat(String.valueOf(str)));
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11367i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.openURL(obj, str);
        }
    }

    public void pauseCountDown(Object obj, String str) {
        try {
            o.d(f11366h, "pauseCountDown");
            if (this.f11367i != null) {
                this.f11367i.pauseCountDown(obj, str);
            }
        } catch (Throwable th) {
            o.b(f11366h, "pauseCountDown", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                a aVar = (a) obj;
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().readyState(windVaneWebView, iOptInt);
                    }
                }
            } catch (Throwable th) {
                o.b(f11366h, "readyStatus", th);
            }
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            o.d(f11366h, "reportUrls");
            if (this.f11367i != null) {
                this.f11367i.reportUrls(obj, str);
            }
        } catch (Throwable th) {
            o.b(f11366h, "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        o.d(f11366h, "resetCountdown".concat(String.valueOf(str)));
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11367i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.resetCountdown(obj, str);
        }
    }

    public void resumeCountDown(Object obj, String str) {
        try {
            o.d(f11366h, "resumeCountDown");
            if (this.f11367i != null) {
                this.f11367i.resumeCountDown(obj, str);
            }
        } catch (Throwable th) {
            o.b(f11366h, "resumeCountDown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            o.d(f11366h, "sendImpressions");
            if (this.f11367i != null) {
                this.f11367i.sendImpressions(obj, str);
            }
        } catch (Throwable th) {
            o.b(f11366h, "sendImpressions", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        o.d(f11366h, "toggleCloseBtn".concat(String.valueOf(str)));
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11367i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.toggleCloseBtn(obj, str);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        o.d(f11366h, "triggerCloseBtn".concat(String.valueOf(str)));
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11367i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.triggerCloseBtn(obj, str);
        }
    }
}
