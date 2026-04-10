package com.dangdang.zframework.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.onetrack.api.g;

/* JADX INFO: loaded from: classes10.dex */
public class NetUtil {
    public static final Uri APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    private static Context mContext;

    public static class ApnWrapper {
        public String apn;
        public String name;
        public int port;
        public String proxy;
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
        if (context == null) {
            return -1;
        }
        mContext = context.getApplicationContext();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            mContext = context.getApplicationContext();
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
            if (networkInfo != null) {
                return networkInfo.isConnected();
            }
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }
        mContext = context.getApplicationContext();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        if (context == null) {
            return false;
        }
        mContext = context.getApplicationContext();
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public static boolean isNetworkConnected() {
        Context context = mContext;
        if (context != null) {
            return isNetworkConnected(context);
        }
        return true;
    }
}
