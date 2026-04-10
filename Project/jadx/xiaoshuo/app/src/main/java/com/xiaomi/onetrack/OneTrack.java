package com.xiaomi.onetrack;

import android.content.Context;
import android.content.Intent;
import com.dangdang.reader.utils.DangdangFileManager;
import com.xiaomi.ad.mediation.DspNameConstant;
import com.xiaomi.ad.v;
import com.xiaomi.onetrack.api.m;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.util.i;
import com.xiaomi.onetrack.util.p;
import com.xiaomi.passport.ui.internal.SNSAuthProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import miuix.android.content.MiuiIntent;

/* JADX INFO: loaded from: classes8.dex */
public class OneTrack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f7470b;
    private static boolean c;
    private static boolean d;
    private m e;

    public interface ICommonPropertyProvider {
        Map<String, Object> getDynamicProperty(String str);
    }

    public interface IEventHook {
        boolean isCustomDauEvent(String str);

        boolean isRecommendEvent(String str);
    }

    public enum Mode {
        APP(v.j),
        PLUGIN(DangdangFileManager.PDF_RESOURCES_PATH),
        SDK("sdk");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7473a;

        Mode(String str) {
            this.f7473a = str;
        }

        public String getType() {
            return this.f7473a;
        }
    }

    public enum NetType {
        NOT_CONNECTED("NONE"),
        MOBILE_2G("2G"),
        MOBILE_3G("3G"),
        MOBILE_4G("4G"),
        MOBILE_5G("5G"),
        WIFI(MiuiIntent.WIFI_NAME),
        ETHERNET("ETHERNET"),
        UNKNOWN("UNKNOWN"),
        CONNECTED("CONNECTED");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7475a;

        NetType(String str) {
            this.f7475a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f7475a;
        }
    }

    public enum UserIdType {
        XIAOMI(DspNameConstant.DSP_XIAOMI),
        PHONE_NUMBER("phone_number"),
        WEIXIN("weixin"),
        WEIBO(SNSAuthProvider.SNS_TYPE_WEIBO),
        QQ("qq"),
        OTHER("other");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7477a;

        UserIdType(String str) {
            this.f7477a = str;
        }

        public String getUserIdType() {
            return this.f7477a;
        }
    }

    private OneTrack(Context context, Configuration configuration) {
        a.a(context.getApplicationContext());
        this.e = new m(context, configuration);
        setEventHook(new DefaultEventHook());
    }

    private static void a(Context context) {
        if (context == null) {
            throw new IllegalStateException("context is null!");
        }
        a.a(context.getApplicationContext());
    }

    public static OneTrack createInstance(Context context, Configuration configuration) {
        return new OneTrack(context, configuration);
    }

    public static int getGlobalBasicModeEnable() {
        return f7470b;
    }

    public static boolean isDisable() {
        return f7469a;
    }

    public static boolean isRestrictGetNetworkInfo() {
        return d;
    }

    public static boolean isUseSystemNetTrafficOnly() {
        return c;
    }

    public static void registerCrashHook(Context context) {
        CrashAnalysis.a(context);
    }

    public static String sdkVersion() {
        return BuildConfig.SDK_VERSION;
    }

    public static void setAccessNetworkEnable(Context context, final boolean z) {
        a(context);
        i.a(new Runnable() { // from class: com.xiaomi.onetrack.OneTrack.1
            @Override // java.lang.Runnable
            public void run() {
                com.xiaomi.onetrack.c.i.a(z);
                com.xiaomi.onetrack.c.i.b(z);
            }
        });
    }

    public static void setDebugMode(boolean z) {
        p.a(z);
    }

    public static void setDisable(boolean z) {
        f7469a = z;
    }

    public static void setGlobalBasicModeEnable(boolean z) {
        if (z) {
            f7470b = 2;
        } else {
            f7470b = 1;
        }
    }

    public static void setRestrictGetNetworkInfo(boolean z) {
        d = z;
    }

    public static void setTestMode(boolean z) {
        p.b(z);
    }

    public static void setUseSystemNetTrafficOnly() {
        c = true;
    }

    public void adTrack(String str, Map<String, Object> map) {
        this.e.a(str, map, (List<String>) null);
    }

    public String appActiveBroadcast(Intent intent) throws OnMainThreadException {
        return this.e.a(intent);
    }

    public void clearCommonProperty() {
        this.e.a();
    }

    public String getAndroidId(Context context) throws OnMainThreadException {
        return this.e.b(context);
    }

    public String getInstanceId() throws OnMainThreadException {
        return this.e.c();
    }

    public String getOAID(Context context) throws OnMainThreadException {
        return this.e.a(context);
    }

    public boolean hasMemoryOaid() {
        return this.e.e();
    }

    public void login(String str, UserIdType userIdType, Map<String, Object> map, boolean z) {
        this.e.a(str, userIdType, map, z);
    }

    public void logout() {
        logout(null, false);
    }

    public void refreshGetOaidTime() {
        this.e.d();
    }

    public void removeCommonProperty(String str) {
        this.e.b(str);
    }

    public void setBasicModeEnable(boolean z) {
        this.e.c(z);
    }

    public void setCloseOaidDependMsaSDK(boolean z) {
        this.e.d(z);
    }

    public void setCommonProperty(Map<String, Object> map) {
        this.e.c(map);
    }

    public void setCustomPrivacyPolicyAccepted(boolean z) {
        this.e.b(z);
    }

    public void setDynamicCommonProperty(ICommonPropertyProvider iCommonPropertyProvider) {
        this.e.a(iCommonPropertyProvider);
    }

    public void setEventHook(IEventHook iEventHook) {
        this.e.a(iEventHook);
    }

    public void setInstanceId(String str) {
        this.e.c(str);
    }

    public void setUserProfile(Map<String, Object> map) {
        this.e.a(map);
    }

    public void track(String str, Map<String, Object> map) {
        this.e.a(str, map);
    }

    public void trackEventFromH5(String str) {
        this.e.a(str);
    }

    public void trackPluginEvent(String str, String str2, Map<String, Object> map) {
        this.e.a(str, str2, map);
    }

    public void trackServiceQualityEvent(ServiceQualityEvent serviceQualityEvent) {
        this.e.a(serviceQualityEvent);
    }

    public void userProfileIncrement(Map<String, ? extends Number> map) {
        this.e.b(map);
    }

    public void adTrack(String str, Map<String, Object> map, List<String> list) {
        this.e.a(str, map, list);
    }

    public void login(String str, UserIdType userIdType, Map<String, Object> map) {
        login(str, userIdType, map, false);
    }

    public void logout(Map<String, Object> map, boolean z) {
        this.e.a(map, z);
    }

    public void setUserProfile(String str, Object obj) {
        this.e.a(str, obj);
    }

    public void track(String str, List<String> list, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("exp_id", String.join(",", list));
        this.e.a(str, (Map<String, Object>) map2);
    }

    public void userProfileIncrement(String str, Number number) {
        this.e.a(str, number);
    }
}
