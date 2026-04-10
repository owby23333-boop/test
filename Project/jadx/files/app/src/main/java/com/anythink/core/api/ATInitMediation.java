package com.anythink.core.api;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ATInitMediation {
    public static final String KEY_LOCAL = "anythink_local";

    public static boolean getBooleanFromMap(Map<String, Object> map, String str) {
        return getBooleanFromMap(map, str, false);
    }

    public static double getDoubleFromMap(Map<String, Object> map, String str) {
        return getDoubleFromMap(map, str, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
    }

    public static int getIntFromMap(Map<String, Object> map, String str) {
        return getIntFromMap(map, str, 0);
    }

    public static long getLongFromMap(Map<String, Object> map, String str) {
        return getLongFromMap(map, str, 0L);
    }

    public static String getStringFromMap(Map<String, Object> map, String str) {
        return getStringFromMap(map, str, "");
    }

    private static <T> T getValueFromMap(Map<String, Object> map, String str, T t2) {
        Object obj;
        try {
            if (TextUtils.isEmpty(str) || map == null || map.size() <= 0 || (obj = map.get(str)) == null) {
                return t2;
            }
            String str2 = (T) obj.toString();
            Object obj2 = t2 instanceof String ? str2 : t2 instanceof Integer ? (T) Integer.valueOf(Integer.parseInt(str2)) : t2 instanceof Long ? (T) Long.valueOf(Long.parseLong(str2)) : t2 instanceof Double ? (T) Double.valueOf(Double.parseDouble(str2)) : t2 instanceof Float ? (T) Float.valueOf(Float.parseFloat(str2)) : t2 instanceof Boolean ? (T) Boolean.valueOf(Boolean.parseBoolean(str2)) : t2;
            if (ATSDK.isNetworkLogDebug()) {
                String str3 = "key = " + str + "getValueFromMap() >>> result = " + obj2 + " defaultValue = " + t2;
            }
            return (T) obj2;
        } catch (Exception e2) {
            if (ATSDK.isNetworkLogDebug()) {
                String str4 = "getValueFromMap() >>> errorMsg = " + e2.getMessage();
            }
            return t2;
        }
    }

    protected final void checkToSaveInitData(String str, Map<String, Object> map, String... strArr) {
        n.a().a(str, map, strArr);
    }

    public List getActivityStatus() {
        return null;
    }

    public List getMetaValutStatus() {
        return null;
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkSDKClass() {
        return "";
    }

    public String getNetworkVersion() {
        return "";
    }

    public List getPermissionStatus() {
        return null;
    }

    public Map<String, Boolean> getPluginClassStatus() {
        return null;
    }

    public List getProviderStatus() {
        return null;
    }

    public List getResourceStatus() {
        return null;
    }

    public List getServiceStatus() {
        return null;
    }

    public abstract void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback);

    protected final void runOnMainThread(Runnable runnable) {
        n.a().a(runnable);
    }

    protected final void runOnThreadPool(Runnable runnable) {
        n.a();
        n.b(runnable);
    }

    public boolean setUserDataConsent(Context context, boolean z2, boolean z3) {
        return false;
    }

    public static boolean getBooleanFromMap(Map<String, Object> map, String str, boolean z2) {
        return ((Boolean) getValueFromMap(map, str, Boolean.valueOf(z2))).booleanValue();
    }

    public static double getDoubleFromMap(Map<String, Object> map, String str, double d2) {
        return ((Double) getValueFromMap(map, str, Double.valueOf(d2))).doubleValue();
    }

    public static int getIntFromMap(Map<String, Object> map, String str, int i2) {
        return ((Integer) getValueFromMap(map, str, Integer.valueOf(i2))).intValue();
    }

    public static long getLongFromMap(Map<String, Object> map, String str, long j2) {
        return ((Long) getValueFromMap(map, str, Long.valueOf(j2))).longValue();
    }

    public static String getStringFromMap(Map<String, Object> map, String str, String str2) {
        return (String) getValueFromMap(map, str, str2);
    }
}
