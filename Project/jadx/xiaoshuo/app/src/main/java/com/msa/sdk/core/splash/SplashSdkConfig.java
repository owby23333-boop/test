package com.msa.sdk.core.splash;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SplashSdkConfig {
    public static final int SOURCE_NORMAL = 0;
    public static final int SOURCE_PASSIVE = 1;
    public static final int START_COLDBOOT = 1;
    public static final int START_HOTSTART = 2;
    public static final int START_NOCONFIG = 0;
    private static final String TAG = "SplashSdkConfig";
    private static final String sdkVersion = "1.0.2";
    public boolean isShowDefaultImage = true;
    public boolean supportMaterialRender = false;
    public int startType = 0;
    public String extConfig = "";
    public int source = 0;
    public boolean showCountdown = true;
    public boolean needWaitShow = false;
    public RpkPackageInfo rpkPackageInfo = null;

    public static class RpkPackageInfo {
        public String rpkPackageName = "";
        public String rpkLabel = "";
        public String rpkIcon = "";

        public JSONObject serialize() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rpkPackageName", this.rpkPackageName);
                jSONObject.put("rpkLabel", this.rpkLabel);
                jSONObject.put("rpkIcon", this.rpkIcon);
                return jSONObject;
            } catch (JSONException e) {
                Log.e(SplashSdkConfig.TAG, "Fail to convert to json", e);
                return new JSONObject();
            }
        }
    }

    public static String getSdkVersion() {
        return sdkVersion;
    }

    public String serialize() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isShowDefaultImage", this.isShowDefaultImage);
            jSONObject.put("supportMaterialRender", this.supportMaterialRender);
            jSONObject.put("startType", this.startType);
            jSONObject.put("extConfig", this.extConfig);
            jSONObject.put("sdkVersion", sdkVersion);
            jSONObject.put("source", this.source);
            jSONObject.put("showCountdown", this.showCountdown);
            jSONObject.put("needWaitShow", this.needWaitShow);
            RpkPackageInfo rpkPackageInfo = this.rpkPackageInfo;
            if (rpkPackageInfo != null) {
                jSONObject.put("rpkPackageInfo", rpkPackageInfo.serialize());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.e(TAG, "Fail to convert to json", e);
            return "";
        }
    }
}
