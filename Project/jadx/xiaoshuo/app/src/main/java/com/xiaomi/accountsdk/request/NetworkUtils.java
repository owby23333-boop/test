package com.xiaomi.accountsdk.request;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.xiaomi.account.privacy_data.master.PrivacyDataMaster;
import com.xiaomi.account.privacy_data.master.PrivacyDataType;
import com.xiaomi.accountsdk.utils.CloudCoder;
import com.yuewen.g72;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkUtils {
    public static String deleteUrlUnsafeChar(String str) {
        if (str != null) {
            return str.replaceAll("[^a-zA-Z0-9-_.]", "");
        }
        return null;
    }

    public static String getActiveConnPoint(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            if (activeNetworkInfo.getType() != 1) {
                return String.format("%s-%s-%s", activeNetworkInfo.getTypeName(), replacePlusToPChar(activeNetworkInfo.getSubtypeName()), activeNetworkInfo.getExtraInfo()).toLowerCase();
            }
            String strForceGet = PrivacyDataMaster.forceGet(context, PrivacyDataType.SSID, new String[0]);
            if (TextUtils.isEmpty(strForceGet)) {
                return g72.g;
            }
            return "wifi-" + CloudCoder.hashDeviceInfo(strForceGet).substring(0, 3).toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getNetworkNameForMiUrlStat(Context context) {
        return deleteUrlUnsafeChar(getActiveConnPoint(context));
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String replacePlusToPChar(String str) {
        if (str != null) {
            return str.replaceAll("\\+", "p");
        }
        return null;
    }
}
