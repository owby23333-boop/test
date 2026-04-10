package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static JSONObject a(Context context) {
        int port;
        String property;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
                }
                port = Integer.parseInt(property2);
            } else {
                String host = Proxy.getHost(context);
                port = Proxy.getPort(context);
                property = host;
            }
            if (TextUtils.isEmpty(property) || port == -1) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("h", property);
            jSONObject.put("p", port);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
