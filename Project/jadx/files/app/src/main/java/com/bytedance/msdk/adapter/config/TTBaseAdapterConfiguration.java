package com.bytedance.msdk.adapter.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.adapter.pangle.BuildConfig;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.v2.GMAppDialogClickListener;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.bytedance.msdk.api.v2.IGMLiveTokenInjectionAuth;
import com.umeng.message.proguard.ad;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTBaseAdapterConfiguration implements ITTAdapterConfiguration {
    public static final String APP_ID_EXTRA_KEY = "app_id";
    public static final String APP_KEY_EXTRA_KEY = "app_key";
    public static final String APP_NAME_EXTRA_KEY = "app_name";
    public static final String BAIDU_HTTPS = "baidu_https";
    public static final String BAIDU_WX_APP_ID = "baidu_wx_app_id";
    public static final String PANGLE_APP_NAME = "pangle_app_name";
    public static final String PANGLE_DIRECT_DOWNLOAD_NETWORKTYPE = "pangle_direct_download_networktype";
    public static final String PANGLE_IS_PANGLE_ALLOW_SHOW_NOTIFY = "pangle_is_pangle_allow_show_notify";
    public static final String PANGLE_IS_PANGLE_ALLOW_SHOW_PAGE_WHEN_SCREEN_LOCK = "pangle_is_pangle_allow_show_page_when_screen_lock";
    public static final String PANGLE_IS_PANGLE_PAID = "pangle_is_pangle_paid";
    public static final String PANGLE_IS_PANGLE_USE_TEXTURE_VIEW = "pangle_is_pangle_use_texture_view";
    public static final String PANGLE_KEYWORDS = "pangle_keywords";
    public static final String PANGLE_NEED_CLEAR_TASK_RESET = "pangle_need_clear_task_reset";
    public static final String PANGLE_PLUGIN_UPDATE_CONFIG = "pangle_plugin_update_config";
    public static final String PANGLE_TITLE_BAR_THEME = "pangle_title_bar_theme";
    public static String TT_MSDK_ADSLOT_INFO = "tt_msdk_adslot_info";
    public static String TT_MSDK_CLIENT_REQ_ID = "tt_msdk_client_req_id";
    public static String TT_MSDK_THEME_STATUS = "tt_msdk_theme_status";
    public static String TT_MSDK_WATER_FALL_AB_TEST = "tt_msdk_water_fall_ab_test";
    public static String TT_MSDK_WATER_ORIGIN_TYPE = "tt_msdk_water_orgin_type";
    public static String TT_MSDK_WATER_SUB_AD_TYPE = "tt_msdk_water_sub_ad_type";
    private volatile boolean a = false;

    private static int a(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    str = str.substring(1);
                }
                if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    str2 = str2.substring(1);
                }
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                int i2 = 0;
                while (true) {
                    if (i2 < iMin) {
                        if (strArrSplit[i2].length() == strArrSplit2[i2].length()) {
                            int iCompareTo = strArrSplit[i2].compareTo(strArrSplit2[i2]);
                            if (iCompareTo != 0) {
                                return iCompareTo;
                            }
                            i2++;
                        } else if (strArrSplit[i2].length() <= strArrSplit2[i2].length()) {
                            return -1;
                        }
                    } else if (strArrSplit.length != strArrSplit2.length) {
                        if (strArrSplit.length <= strArrSplit2.length) {
                            return -1;
                        }
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void checkVersion() {
        try {
            String groMoreSdkVersion = getGroMoreSdkVersion();
            if (a(groMoreSdkVersion, BuildConfig.VERSION_NAME) != 0) {
                Logger.e("TTMediationSDK_InitChecker", getAdNetworkName() + "版本号：" + getNetworkSdkVersion() + ad.f20407t + getAdNetworkName() + "Adapter版本号：" + getAdapterVersion() + " , GroMore版本不符合，要求等于" + groMoreSdkVersion + ".x ，当前是3.9.0.2");
            } else {
                Logger.d("TTMediationSDK_InitChecker", getAdNetworkName() + "版本号：" + getNetworkSdkVersion() + ad.f20407t + getAdNetworkName() + "Adapter版本号：" + getAdapterVersion() + " , GroMore版本正常 ，要求等于" + groMoreSdkVersion + ".x ，当前是3.9.0.2");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public Map<String, Object> getBiddingTokenMap(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public Map<String, String> getMsdkRequestOptions() {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getNetworkSdkPluginVersion() {
        return "";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void initializeNetwork(@NonNull Context context, @Nullable Map<String, Object> map, @NonNull TTOnNetworkInitializationFinishedListener tTOnNetworkInitializationFinishedListener) {
    }

    public boolean isInitedSuccess() {
        return this.a;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public boolean isNewInitFunction() {
        return false;
    }

    public void setInitedSuccess(boolean z2) {
        this.a = z2;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setInjectionAuth(IGMLiveTokenInjectionAuth iGMLiveTokenInjectionAuth) {
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setMsdkRequestOptions(Map<String, String> map) {
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setThemeStatus(Map<String, Object> map) {
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public int showOpenOrInstallAppDialog(GMAppDialogClickListener gMAppDialogClickListener) {
        return 0;
    }
}
