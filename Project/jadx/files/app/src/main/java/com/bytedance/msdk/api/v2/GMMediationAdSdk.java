package com.bytedance.msdk.api.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class GMMediationAdSdk {
    private static final int TEST_NUM = 32;

    public static boolean configLoadSuccess() {
        if (TextUtils.isEmpty(b.J().b())) {
            return false;
        }
        return a.f().y();
    }

    public static String getAppId() {
        return b.J().b();
    }

    public static String getAppName() {
        return b.J().i();
    }

    @Deprecated
    private static GMCustomAdapterConfiguration getCustomAdapterConfiguration(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(str);
    }

    public static Map<String, Object> getGMSDKExtraInfo() {
        return b.J().g();
    }

    public static String getPangleData() {
        return b.J().k();
    }

    public static Map<String, String> getPangleExtraData() {
        return b.J().d();
    }

    public static boolean getPanglePaid() {
        return b.J().D();
    }

    public static String getSdkVersion() {
        return "3.9.0.2";
    }

    public static String getValueFromPPeInfo(String str) {
        return a.d() == null ? "" : e0.a("tt_mediation_ppe_info", a.d()).a(str, "");
    }

    public static String getZbh(Context context) {
        return a0.a();
    }

    @Deprecated
    public static void initUnityForBanner(Activity activity) {
    }

    public static void initialize(@NonNull Context context, @NonNull GMAdConfig gMAdConfig) {
        if (context == null || gMAdConfig == null) {
            return;
        }
        b.J().a(gMAdConfig.getAppId());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().n();
        if (gMAdConfig.isDebug()) {
            Logger.openDebugMode();
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a.d();
        }
        m.a(context);
        d.a(gMAdConfig, context.getApplicationContext());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().j();
    }

    public static boolean isAdapterVersionFit(String str, String str2) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.b.b(str, str2);
    }

    public static boolean isAdnVersionFit(String str, String str2) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.b.c(str, str2);
    }

    @Deprecated
    private static boolean isCustom(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(b.J().b())) {
            return false;
        }
        return a.f().g(str);
    }

    public static boolean isTestDemo() {
        return b.J().H();
    }

    public static void preload(final Activity activity, final List<GMPreloadRequestInfo> list, final int i2, final int i3) {
        registerConfigCallback(new GMSettingConfigCallback() { // from class: com.bytedance.msdk.api.v2.GMMediationAdSdk.1
            @Override // com.bytedance.msdk.api.v2.GMSettingConfigCallback
            public void configLoad() {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(activity, list, i2, i3);
            }
        });
    }

    public static void register(Object obj, Object obj2) {
        b.J().a(obj, obj2);
    }

    public static void registerConfigCallback(GMSettingConfigCallback gMSettingConfigCallback) {
        a.f().a(gMSettingConfigCallback);
    }

    public static void requestPermissionIfNecessary(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("type", 3);
        if (context != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d.a(context, intent, null);
        }
    }

    public static void requestPermissionIfNecessary(Context context, int[] iArr) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("type", 1);
        intent.putExtra(TTDelegateActivity.INTENT_PERMISSIONS, iArr);
        if (context != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d.a(context, intent, null);
        }
    }

    @Deprecated
    private static void resetIfTest() {
        a.f().a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.S().b("if_test"));
    }

    @Deprecated
    private static void setIfTest(int i2) {
        a.f().a(i2);
    }

    public static void setPangleData(String str) {
        b.J().d(str);
    }

    public static void setPulisherDid(String str) {
        Logger.d("TTMediationSDK", "app运行中setPulisherDid: " + str);
        b.J().f(str);
    }

    public static void setThemeStatus(int i2) {
        HashMap map = new HashMap();
        map.put(TTBaseAdapterConfiguration.TT_MSDK_THEME_STATUS, Integer.valueOf(i2));
        Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
        if (mapE == null || mapE.size() == 0) {
            return;
        }
        for (ITTAdapterConfiguration iTTAdapterConfiguration : mapE.values()) {
            if (iTTAdapterConfiguration != null) {
                iTTAdapterConfiguration.setThemeStatus(map);
            }
        }
    }

    public static void setUserInfoForSegment(GMConfigUserInfoForSegment gMConfigUserInfoForSegment) {
        b.J().a(gMConfigUserInfoForSegment, false);
    }

    public static int showOpenOrInstallAppDialog(GMAppDialogClickListener gMAppDialogClickListener) {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
        if (mapE == null || mapE.size() == 0 || (iTTAdapterConfiguration = mapE.get(DefaultAdapterClasses.getClassNameByAdnName("gdt"))) == null) {
            return 0;
        }
        return iTTAdapterConfiguration.showOpenOrInstallAppDialog(gMAppDialogClickListener);
    }

    public static void unregisterConfigCallback(GMSettingConfigCallback gMSettingConfigCallback) {
        a.f().b(gMSettingConfigCallback);
    }

    public static void updatePangleConfig(GMAdConfig gMAdConfig) {
        if (gMAdConfig == null) {
            return;
        }
        if (!TextUtils.isEmpty(gMAdConfig.getGMPangleOption().getData())) {
            b.J().d(gMAdConfig.getGMPangleOption().getData());
        }
        if (!TextUtils.isEmpty(gMAdConfig.getGMPangleOption().getKeywords())) {
            b.J().e(gMAdConfig.getGMPangleOption().getKeywords());
        }
        b.J().e(gMAdConfig.getGMPangleOption().getExtraData());
    }

    public static void updatePanglePaid(boolean z2) {
        b.J().f(z2);
    }

    public static void updatePrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
        d.a(gMPrivacyConfig);
    }
}
