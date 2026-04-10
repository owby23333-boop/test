package com.dangdang.reader.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.text.TextUtils;
import com.dangdang.reader.config.DownloadConfigManager;
import com.xiaomi.onetrack.api.g;

/* JADX INFO: loaded from: classes10.dex */
public class NetUtils {
    public static final Uri APN_URI = Uri.parse("content://telephony/carriers/preferapn");

    public static class ApnWrapper {
        public String apn;
        public String name;
        public int port;
        public String proxy;
    }

    public static int checkDownloadNetStatus(Context context) {
        DownloadConfigManager downloadConfigManager = new DownloadConfigManager(context);
        if (isNetworkConnected(context)) {
            return (isWifiConnected(context) || !isMobileConnected(context) || downloadConfigManager.getCanDownloadUseMobile() || Constant.PERMIT_MOBILE) ? 2 : 1;
        }
        return 0;
    }

    public static boolean checkNetwork(Context context) {
        return isNetworkConnected(context);
    }

    private static void closeCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public static ApnWrapper getApn(Context context) {
        ApnWrapper apnWrapper = new ApnWrapper();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(APN_URI, new String[]{"name", "apn", "proxy", g.E}, null, null, null);
                String str = "";
                if (cursorQuery != null) {
                    cursorQuery.moveToFirst();
                    if (cursorQuery.isAfterLast()) {
                        apnWrapper.name = "N/A";
                        apnWrapper.apn = "N/A";
                    } else {
                        apnWrapper.name = cursorQuery.getString(0) == null ? "" : cursorQuery.getString(0).trim();
                        apnWrapper.apn = cursorQuery.getString(1) == null ? "" : cursorQuery.getString(1).trim();
                    }
                } else {
                    apnWrapper.name = "N/A";
                    apnWrapper.apn = "N/A";
                }
                String defaultHost = Proxy.getDefaultHost();
                apnWrapper.proxy = defaultHost;
                if (!TextUtils.isEmpty(defaultHost)) {
                    str = apnWrapper.proxy;
                }
                apnWrapper.proxy = str;
                int defaultPort = Proxy.getDefaultPort();
                apnWrapper.port = defaultPort;
                if (defaultPort <= 0) {
                    defaultPort = 80;
                }
                apnWrapper.port = defaultPort;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return apnWrapper;
        } finally {
            closeCursor(null);
        }
    }

    public static int getConnectedType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0)) == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    public static boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) == null) {
            return false;
        }
        return networkInfo.isConnected();
    }
}
