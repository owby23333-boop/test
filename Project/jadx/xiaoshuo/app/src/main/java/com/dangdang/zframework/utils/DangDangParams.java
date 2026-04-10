package com.dangdang.zframework.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.w.a;
import com.dangdang.zframework.FrameWorkBridgeHelper;
import com.dangdang.zframework.log.LogM;
import com.iflytek.aikit.media.param.MscKeys;
import com.market.sdk.utils.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class DangDangParams {
    public static final String CHANNELTYPE = "channelType";
    public static final String CHANNEL_ID = "channelId";
    private static final String DEFAULT_RETURNTYPE = "json";
    public static final String DEVICE_TYPE = "deviceType";
    public static final String FROM_PLATFORM = "fromPlatform";
    public static final String PLATFORM_SOURCE = "platformSource";
    public static final String TOKEN = "token";
    public static final String VENDOR_NAME = "vendorName";
    private static ConfigManager mConfig;
    private static HashMap<String, String> paramsMap = new HashMap<>();
    private static String publicParam;

    public static String getChannelId() {
        ConfigManager configManager = mConfig;
        return configManager == null ? DangdangConfig.CHANNEL_ID : configManager.getChannelId();
    }

    public static String getDeviceSerialNo() {
        ConfigManager configManager = mConfig;
        return configManager == null ? "" : urlEncode(configManager.getId());
    }

    public static String getDeviceType() {
        String str = paramsMap.get("deviceType");
        return str == null ? DangdangConfig.DEVICE_TYPE : str;
    }

    public static synchronized String getPublicParams() {
        String str = publicParam;
        return str != null ? str : "";
    }

    public static synchronized JSONObject getPublicParamsJson() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.putAll(paramsMap);
        return jSONObject;
    }

    public static synchronized Map<String, String> getPublicParamsMap() {
        return paramsMap;
    }

    public static String getVersionName() {
        ConfigManager configManager = mConfig;
        return configManager == null ? "" : configManager.getVersionName();
    }

    public static synchronized void setPublicParams(Context context, HashMap<String, String> map) {
        if (paramsMap.isEmpty()) {
            ConfigManager configManager = new ConfigManager(context);
            mConfig = configManager;
            String strUrlEncode = urlEncode(configManager.getVersionName());
            String strUrlEncode2 = urlEncode(mConfig.getServerVesion());
            String strUrlEncode3 = urlEncode(CommonUtil.getPermanentId(context));
            String strUrlEncode4 = urlEncode(mConfig.getId());
            String strUrlEncode5 = urlEncode(mConfig.getDeviceMacAddress());
            String strUrlEncode6 = urlEncode(DeviceUtil.getInstance(context).getDisplayWidth() + ProxyConfig.MATCH_ALL_SCHEMES + DeviceUtil.getInstance(context).getDisplayHeight());
            String strUrlEncode7 = urlEncode(mConfig.getOSVersion());
            paramsMap.put("returnType", DEFAULT_RETURNTYPE);
            paramsMap.put("deviceType", DangdangConfig.DEVICE_TYPE);
            paramsMap.put(VENDOR_NAME, Build.MANUFACTURER);
            paramsMap.put("channelId", DangdangConfig.CHANNEL_ID);
            paramsMap.put("clientVersionNo", strUrlEncode);
            paramsMap.put("serverVersionNo", strUrlEncode2);
            paramsMap.put("permanentId", strUrlEncode3);
            paramsMap.put("deviceSerialNo", strUrlEncode4);
            paramsMap.put("macAddr", strUrlEncode5);
            paramsMap.put(Constants.JSON_RESOLUTION, strUrlEncode6);
            paramsMap.put("clientOs", strUrlEncode7);
            paramsMap.put(PLATFORM_SOURCE, DangdangConfig.PLATFORM_SOURCE);
            paramsMap.put(CHANNELTYPE, "");
            paramsMap.put("token", "");
            paramsMap.put(FROM_PLATFORM, "103");
            paramsMap.put("deviceId", FrameWorkBridgeHelper.getInstance().hasPermitPrivacy() ? mConfig.getDeviceAndroidId() : mConfig.getId());
        }
        LogM.i("DangDangParams", " old publicParams = " + paramsMap.toString());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    if (map.containsKey("channelId")) {
                        mConfig.setChannelId(map.get("channelId"));
                    }
                    paramsMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : paramsMap.entrySet()) {
            sb.append(a.p);
            sb.append(entry2.getKey());
            sb.append(MscKeys.KEY_VAL_SEP);
            sb.append(entry2.getValue());
        }
        publicParam = sb.toString();
        LogM.i("DangDangParams", "new publicParam = " + paramsMap.toString());
    }

    private static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            LogM.e(DangDangParams.class.getName(), e.toString());
            return "";
        }
    }
}
