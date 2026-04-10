package com.anythink.expressad.atsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.a;
import com.anythink.expressad.atsignalcommon.windvane.l;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MraidJSBridge extends l {
    protected static final String a = "MraidJSBridge";
    private IMraidJSBridge b;

    public void close(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).a, c.cf);
        }
        try {
            o.d(a, "MRAID close");
            if (this.b != null) {
                this.b.close();
            }
        } catch (Throwable th) {
            o.b(a, "MRAID close", th);
        }
    }

    public void expand(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).a, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            String strOptString2 = jSONObject.optString("shouldUseCustomClose");
            o.d(a, "MRAID expand " + strOptString + " " + strOptString2);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || this.b == null) {
                return;
            }
            this.b.expand(strOptString, strOptString2.toLowerCase().equals(ITagManager.STATUS_TRUE));
        } catch (Throwable th) {
            o.b(a, "MRAID expand", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof IMraidJSBridge) {
                this.b = (IMraidJSBridge) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IMraidJSBridge)) {
                this.b = (IMraidJSBridge) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof IMraidJSBridge)) {
                return;
            }
            this.b = (IMraidJSBridge) windVaneWebView.getMraidObject();
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof a) {
            windVaneWebView = ((a) obj).a;
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(windVaneWebView, ConnType.PK_OPEN);
        } else {
            windVaneWebView = null;
        }
        try {
            String strOptString = new JSONObject(str).optString("url");
            o.d(a, "MRAID Open ".concat(String.valueOf(strOptString)));
            if (this.b == null || TextUtils.isEmpty(strOptString)) {
                return;
            }
            if (windVaneWebView != null && System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.anythink.expressad.a.b.a.f8029c) {
                c mraidCampaign = this.b.getMraidCampaign();
                windVaneWebView.getUrl();
                if (com.anythink.expressad.a.b.a.a(mraidCampaign)) {
                    return;
                }
            }
            this.b.open(strOptString);
        } catch (Throwable th) {
            o.b(a, "MRAID Open", th);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).a, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("allowOrientationChange");
            String strOptString2 = jSONObject.optString("forceOrientation");
            o.d(a, "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || this.b == null) {
                return;
            }
            strOptString.toLowerCase().equals(ITagManager.STATUS_TRUE);
            String lowerCase = strOptString2.toLowerCase();
            int iHashCode = lowerCase.hashCode();
            if (iHashCode == 729267099) {
                if (lowerCase.equals("portrait")) {
                }
            } else {
                if (iHashCode != 1430647483) {
                    return;
                }
                lowerCase.equals("landscape");
            }
        } catch (Throwable th) {
            o.b(a, "MRAID setOrientationProperties", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).a, "unload");
        }
        try {
            o.d(a, "MRAID unload");
            if (this.b != null) {
                this.b.unload();
            }
        } catch (Throwable th) {
            o.b(a, "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof a) {
            CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((a) obj).a, "useCustomClose");
        }
        try {
            String strOptString = new JSONObject(str).optString("shouldUseCustomClose");
            o.d(a, "MRAID useCustomClose ".concat(String.valueOf(strOptString)));
            if (TextUtils.isEmpty(strOptString) || this.b == null) {
                return;
            }
            this.b.useCustomClose(strOptString.toLowerCase().equals(ITagManager.STATUS_TRUE));
        } catch (Throwable th) {
            o.b(a, "MRAID useCustomClose", th);
        }
    }
}
