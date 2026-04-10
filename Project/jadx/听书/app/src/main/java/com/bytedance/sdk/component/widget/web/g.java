package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.i.dl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends z {
    private final WebViewImpl g;
    private final com.bytedance.sdk.component.i.z z;

    public g(Object obj, String str, com.bytedance.sdk.component.i.z zVar, WebViewImpl webViewImpl) {
        super(obj, str);
        this.z = zVar;
        this.g = webViewImpl;
    }

    private boolean z(JSONObject jSONObject) {
        JSONObject jSONObjectG = g(jSONObject, "addWebviewListener");
        if (jSONObjectG == null) {
            return false;
        }
        String strOptString = jSONObjectG.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.z.z(this.g, strOptString);
        return true;
    }

    private boolean g(JSONObject jSONObject) {
        JSONObject jSONObjectG = g(jSONObject, "removeWebviewListener");
        if (jSONObjectG == null) {
            return false;
        }
        String strOptString = jSONObjectG.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null || strOptString.length() <= 0) {
            return true;
        }
        this.z.g(this.g, strOptString);
        return true;
    }

    private boolean dl(JSONObject jSONObject) {
        JSONObject jSONObjectG = g(jSONObject, "sendWebviewEvent");
        if (jSONObjectG == null) {
            return false;
        }
        String strOptString = jSONObjectG.optString(NotificationCompat.CATEGORY_EVENT);
        if (strOptString == null) {
            return true;
        }
        this.z.z(this.g, g(), strOptString, jSONObjectG.opt("param"));
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.web.z
    @JavascriptInterface
    public Object invokeMethod(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("popWebview")) {
            if (gc(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("pushWebview")) {
            if (a(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("addWebviewListener")) {
            if (z(new JSONObject(str))) {
                return null;
            }
        } else if (str.contains("removeWebviewListener")) {
            if (g(new JSONObject(str))) {
                return null;
            }
        } else {
            if (str.contains("sendWebviewEvent")) {
                if (dl(new JSONObject(str))) {
                    return null;
                }
            }
            return super.invokeMethod(str);
        }
        return super.invokeMethod(str);
    }

    private boolean a(JSONObject jSONObject) {
        JSONObject jSONObjectG = g(jSONObject, "pushWebview");
        if (jSONObjectG == null) {
            return false;
        }
        int iZ = this.z.z(jSONObjectG.optString("url"));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(iZ));
            jSONObject2.putOpt("result", Boolean.valueOf(iZ == 0));
        } catch (Exception unused) {
        }
        this.g.z(g(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean gc(JSONObject jSONObject) {
        if (!z(jSONObject, "popWebview")) {
            return false;
        }
        dl dlVarZ = this.z.z();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("error_code", Integer.valueOf(dlVarZ == null ? 1 : 0));
            jSONObject2.putOpt("result", Boolean.valueOf(dlVarZ != null));
        } catch (Exception unused) {
        }
        this.g.z(g(), jSONObject.optString("__callback_id"), jSONObject2);
        return true;
    }

    private boolean z(JSONObject jSONObject, String str) {
        return jSONObject.optString("func").equals(str);
    }

    private JSONObject g(JSONObject jSONObject, String str) {
        if (z(jSONObject, str)) {
            return jSONObject.optJSONObject("params");
        }
        return null;
    }
}
