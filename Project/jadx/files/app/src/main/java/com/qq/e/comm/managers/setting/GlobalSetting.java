package com.qq.e.comm.managers.setting;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class GlobalSetting {
    public static final String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final String AGREE_READ_AAID = "allow_read_aaid";
    public static final String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final String BD_SDK_WRAPPER = "BD";
    public static final String CCPA = "ccpa";
    public static final String COPPA = "coppa";
    public static final String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final String GDPR = "gdpr";
    public static final String KS_SDK_WRAPPER = "KS";
    public static final String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final String PAG_SDK_WRAPPER = "PAG";
    public static final String TT_SDK_WRAPPER = "TT";
    private static volatile Integer a = null;
    private static volatile boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f17826c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Integer f17827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Boolean f17828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile Boolean f17829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile Boolean f17830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile Map<String, String> f17831h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile Map<String, String> f17832i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<String, String> f17833j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final JSONObject f17834k = new JSONObject();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile String f17835l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile String f17836m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile String f17837n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile String f17838o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile String f17839p = null;

    public static Boolean getAgreeReadAndroidId() {
        return f17830g;
    }

    public static Boolean getAgreeReadDeviceId() {
        return f17829f;
    }

    public static Integer getChannel() {
        return a;
    }

    public static String getCustomADActivityClassName() {
        return f17835l;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f17838o;
    }

    public static String getCustomPortraitActivityClassName() {
        return f17836m;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f17839p;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f17837n;
    }

    public static Map<String, String> getExtraUserData() {
        return Collections.unmodifiableMap(f17831h);
    }

    public static Integer getPersonalizedState() {
        return f17827d;
    }

    public static Map<String, String> getPreloadAdapterMaps() {
        return f17833j;
    }

    public static JSONObject getSettings() {
        return f17834k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f17828e == null || f17828e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (f17830g == null) {
            return true;
        }
        return f17830g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f17829f == null) {
            return true;
        }
        return f17829f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return f17826c;
    }

    public static void setAgreePrivacyStrategy(boolean z2) {
        if (f17828e == null) {
            f17828e = Boolean.valueOf(z2);
        }
    }

    @Deprecated
    public static void setAgreeReadAndroidId(boolean z2) {
        f17830g = Boolean.valueOf(z2);
    }

    @Deprecated
    public static void setAgreeReadDeviceId(boolean z2) {
        f17829f = Boolean.valueOf(z2);
    }

    public static void setAgreeReadPrivacyInfo(Map<String, Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            f17834k.putOpt(AGREE_PRIVACY_KEY, new JSONObject(map));
        } catch (Exception e2) {
            GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e2.toString());
        }
    }

    public static void setChannel(int i2) {
        if (a == null) {
            a = Integer.valueOf(i2);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f17835l = str;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f17838o = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f17836m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f17839p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f17837n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z2) {
        try {
            f17834k.putOpt("ecais", Boolean.valueOf(z2));
        } catch (JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z2) {
        b = z2;
    }

    public static void setEnableVideoDownloadingCache(boolean z2) {
        f17826c = z2;
    }

    public static void setExtraUserData(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                GDTLogger.e("参数key和value不能为空！");
                return;
            }
        }
        f17831h = map;
    }

    public static void setMediaExtData(Map<String, String> map, boolean z2) {
        if (map == null) {
            return;
        }
        if (z2) {
            f17832i = new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                f17832i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            f17834k.putOpt("media_ext", new JSONObject(f17832i));
        } catch (JSONException unused) {
            GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i2) {
        f17827d = Integer.valueOf(i2);
    }

    public static void setPreloadAdapters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        f17833j.putAll(map);
    }
}
