package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.passport.sim.SIMInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static f a(Context context) {
        if (context == null) {
            return null;
        }
        String strA = com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        if (com.alipay.sdk.m.d0.a.a(strA)) {
            strA = com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key");
        }
        if (com.alipay.sdk.m.d0.a.a(strA)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strA);
            f fVar = new f();
            fVar.a(jSONObject.getString("imei"));
            fVar.b(jSONObject.getString(SIMInfo.SIM_INFO_TYPE_IMSI));
            fVar.c(jSONObject.getString(MscKeys.MAC_ADDR));
            fVar.d(jSONObject.getString("bluetoothmac"));
            fVar.e(jSONObject.getString("gsi"));
            return fVar;
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }

    public static void a(Context context, f fVar) {
        if (fVar == null || context == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", fVar.a());
            jSONObject.put(SIMInfo.SIM_INFO_TYPE_IMSI, fVar.b());
            jSONObject.put(MscKeys.MAC_ADDR, fVar.c());
            jSONObject.put("bluetoothmac", fVar.d());
            jSONObject.put("gsi", fVar.e());
            String string = jSONObject.toString();
            com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", string);
            com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", string);
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
    }
}
