package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.service.ServiceProvider;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bn {
    private static boolean aAy = false;
    private static final List<a> aAz = new ArrayList();

    public static class a implements com.kwad.sdk.core.b {
        public String aAA;
        public String aAB;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, "level", this.level);
            s.putValue(jSONObject, "ssid", this.aAA);
            s.putValue(jSONObject, DispatchConstants.BSSID, this.aAB);
            return jSONObject;
        }
    }

    public static boolean ds(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16727g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16728h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16727g) == -1;
    }

    public static List<a> m(Context context, int i2) {
        WifiManager wifiManager;
        if (as.Ea()) {
            return new ArrayList();
        }
        if (aAy || !ServiceProvider.CF().canReadNearbyWifiList() || !aAz.isEmpty() || context == null) {
            return aAz;
        }
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(32L)) {
            return aAz;
        }
        try {
        } catch (Exception e2) {
            aAy = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        if (!ds(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                for (ScanResult scanResult : scanResults) {
                    a aVar = new a();
                    aVar.aAA = scanResult.SSID;
                    aVar.aAB = scanResult.BSSID;
                    aVar.level = scanResult.level;
                    if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                        aAz.add(aVar);
                    } else {
                        aAz.add(0, aVar);
                    }
                    if (aAz.size() >= i2) {
                        return aAz;
                    }
                }
            }
            return aAz;
        }
        return aAz;
    }
}
