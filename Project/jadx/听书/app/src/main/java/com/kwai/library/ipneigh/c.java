package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static d es(Context context) {
        return A(context, false);
    }

    private static d A(Context context, boolean z) {
        return b(context, false, false);
    }

    private static d b(Context context, boolean z, boolean z2) {
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String strFl = b.fl(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
            String strHR = !z ? a.hR("timeout 5 ip neigh show " + strFl) : "";
            if (z || TextUtils.isEmpty(strHR)) {
                strHR = KwaiIpNeigh.i(strFl, false);
            }
            String strHT = b.hT(strHR);
            return new d(strHT, !TextUtils.isEmpty(strHT), strHR);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }
}
