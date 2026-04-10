package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes3.dex */
public final class af {
    private static int ayT;
    private static boolean ayU;

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo co(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int cp(Context context) {
        if (context != null && SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && SystemUtil.b(context, "android.permission.READ_PHONE_STATE")) {
            try {
                NetworkInfo networkInfoCo = co(context);
                if (!(networkInfoCo != null && networkInfoCo.isConnected())) {
                    return 0;
                }
                if (1 == networkInfoCo.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int iL = l(context, telephonyManager.getNetworkType());
                    if (iL == 20) {
                        return 5;
                    }
                    switch (iL) {
                    }
                    return 0;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3 A[Catch: Exception -> 0x00da, TryCatch #0 {Exception -> 0x00da, blocks: (B:10:0x001a, B:12:0x002c, B:14:0x003a, B:15:0x003d, B:48:0x00a0, B:50:0x00a6, B:51:0x00a9, B:52:0x00ac, B:17:0x0041, B:20:0x004b, B:23:0x0055, B:26:0x005f, B:29:0x0069, B:32:0x0074, B:35:0x007c, B:38:0x0084, B:41:0x008c, B:44:0x0094, B:53:0x00ae, B:55:0x00b2, B:57:0x00b8, B:59:0x00be, B:62:0x00c5, B:64:0x00cb, B:65:0x00ce, B:67:0x00d4, B:68:0x00d7, B:49:0x00a3), top: B:80:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a6 A[Catch: Exception -> 0x00da, TryCatch #0 {Exception -> 0x00da, blocks: (B:10:0x001a, B:12:0x002c, B:14:0x003a, B:15:0x003d, B:48:0x00a0, B:50:0x00a6, B:51:0x00a9, B:52:0x00ac, B:17:0x0041, B:20:0x004b, B:23:0x0055, B:26:0x005f, B:29:0x0069, B:32:0x0074, B:35:0x007c, B:38:0x0084, B:41:0x008c, B:44:0x0094, B:53:0x00ae, B:55:0x00b2, B:57:0x00b8, B:59:0x00be, B:62:0x00c5, B:64:0x00cb, B:65:0x00ce, B:67:0x00d4, B:68:0x00d7, B:49:0x00a3), top: B:80:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9 A[Catch: Exception -> 0x00da, TryCatch #0 {Exception -> 0x00da, blocks: (B:10:0x001a, B:12:0x002c, B:14:0x003a, B:15:0x003d, B:48:0x00a0, B:50:0x00a6, B:51:0x00a9, B:52:0x00ac, B:17:0x0041, B:20:0x004b, B:23:0x0055, B:26:0x005f, B:29:0x0069, B:32:0x0074, B:35:0x007c, B:38:0x0084, B:41:0x008c, B:44:0x0094, B:53:0x00ae, B:55:0x00b2, B:57:0x00b8, B:59:0x00be, B:62:0x00c5, B:64:0x00cb, B:65:0x00ce, B:67:0x00d4, B:68:0x00d7, B:49:0x00a3), top: B:80:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ac A[Catch: Exception -> 0x00da, TryCatch #0 {Exception -> 0x00da, blocks: (B:10:0x001a, B:12:0x002c, B:14:0x003a, B:15:0x003d, B:48:0x00a0, B:50:0x00a6, B:51:0x00a9, B:52:0x00ac, B:17:0x0041, B:20:0x004b, B:23:0x0055, B:26:0x005f, B:29:0x0069, B:32:0x0074, B:35:0x007c, B:38:0x0084, B:41:0x008c, B:44:0x0094, B:53:0x00ae, B:55:0x00b2, B:57:0x00b8, B:59:0x00be, B:62:0x00c5, B:64:0x00cb, B:65:0x00ce, B:67:0x00d4, B:68:0x00d7, B:49:0x00a3), top: B:80:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.af.d(android.content.Context, java.lang.String, boolean):int");
    }

    private static boolean ep(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean eq(String str) {
        return n(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo networkInfoCo = co(context);
            if (networkInfoCo == null) {
                return -1;
            }
            return networkInfoCo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo networkInfoCo = co(context);
            if (networkInfoCo != null && networkInfoCo.isConnected()) {
                if (networkInfoCo.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo networkInfoCo = co(context);
            if (networkInfoCo != null) {
                if (networkInfoCo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfoCo = co(context);
            if (networkInfoCo != null && networkInfoCo.isConnected()) {
                return 1 == networkInfoCo.getType();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private static int l(Context context, int i2) {
        ServiceState serviceState;
        if (Build.VERSION.SDK_INT < 26 || !SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return i2;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i2;
            }
            int subId = getSubId();
            if (subId != -1 && (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29)) {
                try {
                    serviceState = (ServiceState) r.a((Object) telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            } else {
                serviceState = telephonyManager.getServiceState();
            }
            if (serviceState == null) {
                return i2;
            }
            if (ar.DM()) {
                Integer num = (Integer) r.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i2;
            }
            if (ep(serviceState.toString())) {
                return 20;
            }
            return i2;
        } catch (Exception unused2) {
            return i2;
        }
    }

    @WorkerThread
    private static boolean n(String str, int i2) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
