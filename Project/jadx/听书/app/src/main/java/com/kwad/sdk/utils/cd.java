package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class cd {
    private static boolean bbN;
    private static final List<a> bbO = new CopyOnWriteArrayList();

    public static List<a> o(Context context, int i) {
        WifiManager wifiManager;
        if (bc.useNetworkStateDisable()) {
            return new ArrayList();
        }
        if (!bbN && ServiceProvider.getSDKConfig().canReadNearbyWifiList()) {
            List<a> list = bbO;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(32L)) {
                    return list;
                }
                try {
                    if (ef(context) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
                        return list;
                    }
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults != null) {
                        for (ScanResult scanResult : scanResults) {
                            a aVar = new a();
                            aVar.bbP = scanResult.SSID;
                            aVar.bbQ = scanResult.BSSID;
                            aVar.level = scanResult.level;
                            if (connectionInfo.getBSSID() != null && scanResult.BSSID != null && TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) && connectionInfo.getSSID() != null && scanResult.SSID != null && TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                                bbO.add(0, aVar);
                            } else {
                                bbO.add(aVar);
                            }
                            List<a> list2 = bbO;
                            if (list2.size() >= i) {
                                return list2;
                            }
                        }
                    }
                } catch (Exception e) {
                    bbN = true;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
                return bbO;
            }
        }
        return bbO;
    }

    public static boolean ef(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1;
    }

    public static class a implements com.kwad.sdk.core.b {
        public String bbP;
        public String bbQ;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "level", this.level);
            aa.putValue(jSONObject, "ssid", this.bbP);
            aa.putValue(jSONObject, "bssid", this.bbQ);
            return jSONObject;
        }
    }
}
