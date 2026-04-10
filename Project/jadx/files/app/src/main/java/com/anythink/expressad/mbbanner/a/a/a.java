package com.anythink.expressad.mbbanner.a.a;

import android.util.Base64;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String a = "BannerCallJS";

    public static void a(WebView webView) {
        o.d(a, "fireOnJSBridgeConnected");
        j.a();
        j.b(webView);
    }

    public static void a(WebView webView, float f2, float f3) {
        o.d(a, "fireOnBannerWebViewShow");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startX", f2);
            jSONObject.put("startY", f3);
            jSONObject.put("scale", t.c(n.a().g()));
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            j.a();
            j.a(webView, "webviewshow", strEncodeToString);
        } catch (Throwable th) {
            o.b(a, "fireOnBannerWebViewShow", th);
        }
    }

    private static void a(WebView webView, int i2, int i3) {
        o.d(a, "fireOnBannerViewSizeChange");
        try {
            CallMraidJS.getInstance().fireSizeChangeEvent(webView, i2, i3);
        } catch (Throwable th) {
            o.b(a, "fireOnBannerViewSizeChange", th);
        }
    }

    public static void a(WindVaneWebView windVaneWebView, boolean z2) {
        try {
            CallMraidJS.getInstance().fireSetIsViewable(windVaneWebView, z2 ? ITagManager.STATUS_TRUE : ITagManager.STATUS_FALSE);
        } catch (Throwable th) {
            o.b(a, "fireMraidIsViewable", th);
        }
    }

    public static void a(WebView webView, int i2, int i3, int i4, int i5) {
        o.d(a, "transInfoForMraid");
        try {
            int i6 = n.a().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i6 == 2 ? "landscape" : i6 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", ITagManager.STATUS_TRUE);
            float fE = k.e(n.a().g());
            float f2 = k.f(n.a().g());
            HashMap mapG = k.g(n.a().g());
            int iIntValue = ((Integer) mapG.get("width")).intValue();
            int iIntValue2 = ((Integer) mapG.get("height")).intValue();
            HashMap map = new HashMap();
            map.put(CallMraidJS.a, CallMraidJS.f8288k);
            map.put(CallMraidJS.b, "default");
            map.put(CallMraidJS.f8280c, ITagManager.STATUS_TRUE);
            map.put(CallMraidJS.f8281d, jSONObject);
            float f3 = i2;
            float f4 = i3;
            float f5 = i4;
            float f6 = i5;
            CallMraidJS.getInstance().fireSetDefaultPosition(webView, f3, f4, f5, f6);
            CallMraidJS.getInstance().fireSetCurrentPosition(webView, f3, f4, f5, f6);
            CallMraidJS.getInstance().fireSetScreenSize(webView, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(webView, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(webView, map);
            CallMraidJS.getInstance().fireReadyEvent(webView);
        } catch (Throwable th) {
            o.b(a, "transInfoForMraid", th);
        }
    }
}
