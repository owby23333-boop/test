package com.xiaomi.accountsdk.account;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.alibaba.android.arouter.utils.Consts;
import com.duokan.reader.domain.store.DkStoreBookInfo;
import com.xiaomi.account.passportsdk.account_sso.BuildConfig;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.utils.AccountLogger;
import com.xiaomi.accountsdk.utils.SystemPropertiesReflection;
import com.xiaomi.onetrack.util.z;
import com.yuewen.nw0;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class XMPassportUserAgent {
    private static final String KEY_APP_DEVICE_NAME = "MK/";
    private static final String KEY_APP_PACKAGE_NAME = "APP/";
    private static final String KEY_APP_VERSION = "APPV/";
    private static final String KEY_SDK_VERSION = "SDKV/";
    private static final String TAG = "XMPassportUserAgent";
    private static final String UA_CALLING_PACKAGE_NAME = "CPN/";
    private static final String UA_DEVICE_BRAND = "BRA/";
    private static final String UA_DEVICE_SYSTEM_NAME = "DEVS/";
    private static final String UA_DEVICE_TYPE = "DEVT/";
    private static final String UA_REDUNDANT_SID_REQUEST = "RSR/";
    private static volatile String sUserAgentCache;
    private static volatile String sUserAgentForReplacement;
    private static volatile String sWebViewUserAgentCache;
    private static volatile Set<String> sExtendedUASet = new LinkedHashSet();
    private static ThreadLocal<Set<String>> sCurrentThreadExtendedUA = new ThreadLocal<>();
    private static ThreadLocal<String> sUserAgentCacheLocal = new ThreadLocal<>();
    private static ThreadLocal<String> sWebViewUserAgentCacheLocal = new ThreadLocal<>();

    public static class UserAgentBuilder {
        private final Context context;
        private final Set<String> extendedUASet;
        private final boolean isWebView;
        private final String majorUserAgent;

        private String getAppVersion(Context context) {
            if (context == null) {
                return null;
            }
            try {
                return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                AccountLogger.log(XMPassportUserAgent.TAG, context.getPackageName() + " NameNotFound");
                return null;
            }
        }

        private String getDeviceBrand() {
            String str = "";
            try {
                str = SystemPropertiesReflection.get("ro.product.manufacturer", "");
                return TextUtils.isEmpty(str) ? nw0.x : str;
            } catch (Exception unused) {
                AccountLogger.log(XMPassportUserAgent.TAG, "fail to get marketname or model");
                return str;
            }
        }

        public static String getDeviceName() {
            String str = "";
            try {
                str = SystemPropertiesReflection.get("ro.product.marketname", "");
                if (TextUtils.isEmpty(str)) {
                    str = Build.MODEL;
                }
            } catch (Exception unused) {
                AccountLogger.log(XMPassportUserAgent.TAG, "fail to get marketname or model");
            }
            return (TextUtils.isEmpty(str) || str.length() <= 30) ? str : str.substring(0, 30);
        }

        private String getDeviceTypeByUiMode() {
            if (XMPassportSettings.getDeviceType() == XMPassportSettings.DeviceType.SPEAKER) {
                return "Speaker";
            }
            int currentModeType = ((UiModeManager) this.context.getSystemService("uimode")).getCurrentModeType();
            return currentModeType != 1 ? currentModeType != 4 ? currentModeType != 6 ? nw0.x : "Watch" : "MiTV" : "Phone";
        }

        private String getStrippedPackageName(Context context) {
            String packageName = context == null ? "unknown" : context.getPackageName();
            String[] strArrSplit = packageName.split(z.f7779a);
            if (strArrSplit.length <= 2) {
                return packageName;
            }
            return strArrSplit[strArrSplit.length - 2] + Consts.DOT + strArrSplit[strArrSplit.length - 1];
        }

        public String build() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.majorUserAgent);
            sb.append(" ");
            sb.append(XMPassportUserAgent.KEY_APP_PACKAGE_NAME);
            sb.append(getStrippedPackageName(this.context));
            String appVersion = getAppVersion(this.context);
            if (!TextUtils.isEmpty(appVersion)) {
                sb.append(" ");
                sb.append(XMPassportUserAgent.KEY_APP_VERSION);
                sb.append(appVersion);
            }
            if (this.isWebView) {
                sb.append(" ");
                sb.append("XiaoMi/HybridView/");
            }
            String deviceName = getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                sb.append(" ");
                sb.append(XMPassportUserAgent.KEY_APP_DEVICE_NAME);
                sb.append(Base64.encodeToString(deviceName.getBytes(), 2));
            }
            sb.append(" ");
            sb.append(XMPassportUserAgent.KEY_SDK_VERSION);
            sb.append(BuildConfig.VERSION_NAME);
            for (String str : this.extendedUASet) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(" ");
                    sb.append(str);
                }
            }
            String deviceTypeByUiMode = getDeviceTypeByUiMode();
            if (!TextUtils.isEmpty(deviceTypeByUiMode)) {
                sb.append(" ");
                sb.append(XMPassportUserAgent.UA_DEVICE_TYPE);
                sb.append(Base64.encodeToString(deviceTypeByUiMode.getBytes(), 2));
            }
            String deviceBrand = getDeviceBrand();
            sb.append(" ");
            sb.append(XMPassportUserAgent.UA_DEVICE_BRAND);
            sb.append(Base64.encodeToString(deviceBrand.getBytes(), 2));
            sb.append(" ");
            sb.append(XMPassportUserAgent.UA_DEVICE_SYSTEM_NAME);
            sb.append(Base64.encodeToString(DkStoreBookInfo.PLATFORM.getBytes(), 2));
            return sb.toString();
        }

        private UserAgentBuilder(Context context, String str, Set<String> set, boolean z) {
            this.context = context;
            this.majorUserAgent = str;
            this.extendedUASet = set;
            this.isWebView = z;
        }
    }

    private XMPassportUserAgent() {
    }

    public static String addExtendedCallingPkgNameUserAgent(String str) {
        return addExtendedUserAgentForCurrentThread(UA_CALLING_PACKAGE_NAME + str);
    }

    public static synchronized void addExtendedUserAgent(String str) {
        sExtendedUASet.add(str);
        invalidateUACache();
    }

    private static synchronized String addExtendedUserAgentForCurrentThread(String str) {
        if (sCurrentThreadExtendedUA.get() == null) {
            sCurrentThreadExtendedUA.set(new LinkedHashSet());
        }
        sCurrentThreadExtendedUA.get().add(str);
        invalidateUACache();
        return str;
    }

    public static void addSidRequestRedundancyUserAgent(boolean z) {
        addExtendedUserAgentForCurrentThread(UA_REDUNDANT_SID_REQUEST + z);
    }

    private static void checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalThreadStateException("cannot be called without main thread");
        }
    }

    private static String getDefaultUA() {
        return System.getProperty("http.agent");
    }

    public static synchronized String getUserAgent(Context context) {
        if (TextUtils.isEmpty(sUserAgentCache)) {
            String defaultUA = TextUtils.isEmpty(sUserAgentForReplacement) ? getDefaultUA() : sUserAgentForReplacement;
            if (sCurrentThreadExtendedUA.get() != null) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(sExtendedUASet);
                hashSet.addAll(sCurrentThreadExtendedUA.get());
                sUserAgentCacheLocal.set(new UserAgentBuilder(context, defaultUA, hashSet, false).build());
                return sUserAgentCacheLocal.get();
            }
            sUserAgentCache = new UserAgentBuilder(context, defaultUA, sExtendedUASet, false).build();
        }
        return sUserAgentCache;
    }

    public static synchronized String getWebViewUserAgent(WebView webView, Context context) {
        checkThread();
        if (TextUtils.isEmpty(sWebViewUserAgentCache)) {
            String userAgentString = webView.getSettings().getUserAgentString();
            if (sCurrentThreadExtendedUA.get() != null) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(sExtendedUASet);
                hashSet.addAll(sCurrentThreadExtendedUA.get());
                sWebViewUserAgentCacheLocal.set(new UserAgentBuilder(context, userAgentString, hashSet, true).build());
                return sWebViewUserAgentCacheLocal.get();
            }
            sWebViewUserAgentCache = new UserAgentBuilder(context, userAgentString, sExtendedUASet, true).build();
        }
        return sWebViewUserAgentCache;
    }

    private static synchronized void invalidateUACache() {
        sUserAgentCache = null;
        sWebViewUserAgentCache = null;
        sUserAgentCacheLocal.set(null);
        sWebViewUserAgentCacheLocal.set(null);
    }

    public static synchronized void removeExtendedUserAgentForCurrentThread(String str) {
        if (sCurrentThreadExtendedUA.get() != null && sCurrentThreadExtendedUA.get().contains(str)) {
            sCurrentThreadExtendedUA.get().remove(str);
            invalidateUACache();
        }
    }

    public static synchronized void removeSidRequestRedundancyUserAgent(boolean z) {
        removeExtendedUserAgentForCurrentThread(UA_REDUNDANT_SID_REQUEST + z);
    }

    public static synchronized void setUserAgentForReplacement(String str) {
        sUserAgentForReplacement = str;
        invalidateUACache();
    }
}
