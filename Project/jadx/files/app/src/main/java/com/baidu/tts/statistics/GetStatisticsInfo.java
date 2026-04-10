package com.baidu.tts.statistics;

import android.content.Context;
import android.os.Build;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.GetCUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetStatisticsInfo {
    public static String getAPPInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Cuid", GetCUID.getCUID(context));
            jSONObject.put("AppPackageName", context.getPackageName());
            jSONObject.put("SDKVersion", PersistentPool.getInstance().getVersion());
            jSONObject.put("soInfo", EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getDeviceInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("System", Build.VERSION.RELEASE);
            jSONObject.put("SystemVersion", Build.VERSION.SDK + "");
            jSONObject.put("PhoneModel", Build.MODEL);
            jSONObject.put("CPU", Build.CPU_ABI);
            jSONObject.put("NetworkType", CommonUtility.getNetworkInfo(context));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
