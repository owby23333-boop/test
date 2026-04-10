package com.umeng.message.proguard;

import android.content.Context;
import android.os.Build;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: UPushHeader.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context contextB = r.b();
            jSONObject.put("appkey", PushAgent.getInstance(contextB).getMessageAppkey());
            jSONObject.put("channel", PushAgent.getInstance(contextB).getMessageChannel());
            jSONObject.put("umid", UmengMessageDeviceConfig.getUmid(contextB));
            jSONObject.put("din", UmengMessageDeviceConfig.getImeiAes(contextB));
            jSONObject.put("device_id", UmengMessageDeviceConfig.getDeviceIDAes(contextB));
            jSONObject.put("idmd5", UmengMessageDeviceConfig.getDeviceIdMD5(contextB));
            jSONObject.put("mc", UmengMessageDeviceConfig.getDummyId());
            if (UmengMessageDeviceConfig.getAndroidId(contextB) != null) {
                jSONObject.put("android_id", UmengMessageDeviceConfig.getAndroidId(contextB));
            }
            if (UmengMessageDeviceConfig.getSerial() != null) {
                jSONObject.put(a.f20341i, UmengMessageDeviceConfig.getSerial());
            }
            String strIsNotificationEnabled = UmengMessageDeviceConfig.isNotificationEnabled(contextB);
            if (ITagManager.STATUS_FALSE.equals(strIsNotificationEnabled)) {
                UMLog.aq(t.f20514c, 0, "\\|");
            }
            jSONObject.put("push_switch", strIsNotificationEnabled);
            jSONObject.put("sdk_type", "Android");
            jSONObject.put("sdk_version", "6.5.1");
            String[] networkAccessMode = UmengMessageDeviceConfig.getNetworkAccessMode(contextB);
            jSONObject.put("access", networkAccessMode[0]);
            jSONObject.put("access_subtype", networkAccessMode[1]);
            jSONObject.put("carrier", UmengMessageDeviceConfig.getOperator(contextB));
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("app_version", UmengMessageDeviceConfig.getAppVersionName(contextB));
            jSONObject.put("version_code", UmengMessageDeviceConfig.getAppVersionCode(contextB));
            jSONObject.put("package_name", contextB.getPackageName());
            jSONObject.put("resolution", UmengMessageDeviceConfig.getResolution(contextB));
            jSONObject.put("cpu", UmengMessageDeviceConfig.getCPU());
            jSONObject.put("timezone", UmengMessageDeviceConfig.getTimeZone(contextB));
            String[] localeInfo = UmengMessageDeviceConfig.getLocaleInfo(contextB);
            jSONObject.put("country", localeInfo[0]);
            jSONObject.put("language", localeInfo[1]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
