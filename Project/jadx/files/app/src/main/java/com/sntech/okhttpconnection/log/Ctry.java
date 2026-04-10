package com.sntech.okhttpconnection.log;

import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.kuaishou.weapon.p0.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.try, reason: invalid class name */
/* JADX INFO: compiled from: LocationUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ctry {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String f124do;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m142do(final Context context) {
        int i2 = Cthis.f123do;
        if (!(context.checkCallingOrSelfPermission(g.f16728h) == 0)) {
            if (!(context.checkCallingOrSelfPermission(g.f16727g) == 0)) {
                return;
            }
        }
        final AMapLocationClient aMapLocationClient = null;
        try {
            aMapLocationClient = new AMapLocationClient(context.getApplicationContext());
        } catch (Exception unused) {
        }
        if (aMapLocationClient == null) {
            return;
        }
        aMapLocationClient.setLocationOption(m141do());
        aMapLocationClient.setLocationListener(new AMapLocationListener() { // from class: com.sntech.okhttpconnection.log.b
        });
        aMapLocationClient.startLocation();
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static /* synthetic */ void m143do(Context context, AMapLocationClient aMapLocationClient, AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("longitude", aMapLocation.getLongitude());
                jSONObject.put("latitude", aMapLocation.getLatitude());
                jSONObject.put("country", aMapLocation.getCountry());
                jSONObject.put("province", aMapLocation.getProvince());
                jSONObject.put("city", aMapLocation.getCity());
                jSONObject.put("district", aMapLocation.getDistrict());
                f124do = jSONObject.toString();
                if (Cdo.m119do()) {
                    String str = "last_location: " + f124do;
                }
                context.getSharedPreferences("sn_prefs_logs", 0).edit().putString("last_known_location", f124do).apply();
            } catch (JSONException e2) {
                if (Cdo.m119do()) {
                    e2.printStackTrace();
                }
            }
        }
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            aMapLocationClient.onDestroy();
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static AMapLocationClientOption m141do() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(false);
        aMapLocationClientOption.setHttpTimeOut(30000L);
        aMapLocationClientOption.setInterval(com.anythink.expressad.exoplayer.i.a.f9492f);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setOnceLocationLatest(false);
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);
        aMapLocationClientOption.setSensorEnable(false);
        aMapLocationClientOption.setWifiScan(true);
        aMapLocationClientOption.setLocationCacheEnable(true);
        aMapLocationClientOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.DEFAULT);
        return aMapLocationClientOption;
    }
}
