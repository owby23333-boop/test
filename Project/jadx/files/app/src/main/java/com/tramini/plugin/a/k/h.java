package com.tramini.plugin.a.k;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static boolean a(Context context) {
        try {
            return b(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private static boolean b(Context context) {
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
        } catch (Throwable unused) {
        }
        return (TextUtils.isEmpty(property) || port == -1) ? false : true;
    }
}
