package com.mibi.sdk.common;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.duokan.reader.domain.store.DkStoreBookInfo;
import com.mibi.sdk.common.os.SystemProperties;
import com.mibi.sdk.common.utils.IdentifierManager;
import com.mibi.sdk.common.utils.MibiLog;
import com.xiaomi.ad.c;
import com.xiaomi.passport.ui.utils.OsHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Client {
    private static final String DEVICE_TOKEN_PROVIDER_URI = "content://com.miui.analytics.server.AnalyticsProvider";
    private static Boolean IS_MIUI = null;
    private static final String KEY_DEVICE_VALIDATION_TOKEN = "token";
    private static final String METHOD_GET_DEVICE_VALIDATION_TOKEN = "getDeviceValidationToken";
    private static String OAID_MD5 = null;
    private static final String RESULT_DEVICE_VALIDATION_TOKEN_JSON = "device_token_json";
    private static final String TAG = "Client";
    private static AppInfo sAppInfo;
    private static Context sApplicationContext;

    public static class AppInfo {
        private String mVersionName = "";
        private int mVersionCode = -1;
        private String mPackage = "";

        public String getPackage() {
            return this.mPackage;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String getVersionName() {
            return this.mVersionName;
        }
    }

    public static AppInfo getAppInfo() {
        PackageInfo packageInfo;
        AppInfo appInfo = sAppInfo;
        if (appInfo != null) {
            return appInfo;
        }
        AppInfo appInfo2 = new AppInfo();
        sAppInfo = appInfo2;
        appInfo2.mPackage = getContext().getPackageName();
        try {
            packageInfo = getContext().getPackageManager().getPackageInfo(sAppInfo.mPackage, 0);
        } catch (PackageManager.NameNotFoundException e) {
            MibiLog.e(TAG, "exception: " + e + " message: " + e.getMessage());
            packageInfo = null;
        }
        if (packageInfo != null) {
            sAppInfo.mVersionName = packageInfo.versionName;
            sAppInfo.mVersionCode = packageInfo.versionCode;
        }
        return sAppInfo;
    }

    public static String getBuildBrand() {
        return Build.BRAND;
    }

    public static String getBuildModel() {
        return Build.MODEL;
    }

    public static int getBuildSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    private static Context getContext() {
        return sApplicationContext;
    }

    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getOS() {
        return isMiui() ? OsHelper.ROM_MIUI : DkStoreBookInfo.PLATFORM;
    }

    public static String getOaid() {
        return IdentifierManager.isSupported() ? IdentifierManager.getOAID(getContext()) : "";
    }

    public static String getOaidMd5() {
        if (OAID_MD5 == null) {
            String strEncodeMD5 = Coder.encodeMD5(getOaid());
            OAID_MD5 = strEncodeMD5;
            if (strEncodeMD5 == null) {
                OAID_MD5 = "";
            }
        }
        return OAID_MD5;
    }

    public static String getXiaomiDeviceToken() {
        ContentProviderClient contentProviderClientAcquireContentProviderClient = null;
        try {
            try {
                contentProviderClientAcquireContentProviderClient = getContext().getContentResolver().acquireContentProviderClient(Uri.parse(DEVICE_TOKEN_PROVIDER_URI));
                String strInnerGetDeviceToken = innerGetDeviceToken(contentProviderClientAcquireContentProviderClient);
                if (contentProviderClientAcquireContentProviderClient == null) {
                    return strInnerGetDeviceToken;
                }
                contentProviderClientAcquireContentProviderClient.release();
                return strInnerGetDeviceToken;
            } catch (Exception e) {
                MibiLog.e(TAG, "Error when get device token", e);
                if (contentProviderClientAcquireContentProviderClient != null) {
                    contentProviderClientAcquireContentProviderClient.release();
                }
                return "";
            }
        } catch (Throwable th) {
            if (contentProviderClientAcquireContentProviderClient != null) {
                contentProviderClientAcquireContentProviderClient.release();
            }
            throw th;
        }
    }

    public static void init(Context context) {
        sApplicationContext = context.getApplicationContext();
    }

    private static String innerGetDeviceToken(ContentProviderClient contentProviderClient) throws JSONException, RemoteException {
        Bundle bundleCall;
        String string;
        return (contentProviderClient == null || (bundleCall = contentProviderClient.call(METHOD_GET_DEVICE_VALIDATION_TOKEN, "", new Bundle())) == null || (string = bundleCall.getString(RESULT_DEVICE_VALIDATION_TOKEN_JSON)) == null) ? "" : new JSONObject(string).getString("token");
    }

    public static boolean isMiui() {
        if (IS_MIUI == null) {
            IS_MIUI = Boolean.valueOf(!TextUtils.isEmpty(SystemProperties.get(c.f7255a, "")));
        }
        return IS_MIUI.booleanValue();
    }
}
