package com.kwad.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes4.dex */
public final class ao {
    private static int aZT;
    private static boolean aZU;

    public static NetworkInfo de(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo networkInfoDe = de(context);
            if (networkInfoDe != null) {
                if (networkInfoDe.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfoDe = de(context);
            if (networkInfoDe != null && networkInfoDe.isConnected()) {
                return 1 == networkInfoDe.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo networkInfoDe = de(context);
            if (networkInfoDe != null && networkInfoDe.isConnected()) {
                if (networkInfoDe.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo networkInfoDe = de(context);
            if (networkInfoDe == null) {
                return -1;
            }
            return networkInfoDe.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int df(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) && SystemUtil.b(context, com.kuaishou.weapon.p0.g.c)) {
            try {
                NetworkInfo networkInfoDe = de(context);
                if (!(networkInfoDe != null && networkInfoDe.isConnected())) {
                    return 0;
                }
                if (1 == networkInfoDe.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int iN = n(context, telephonyManager.getNetworkType());
                    if (iN == 20) {
                        return 5;
                    }
                    switch (iN) {
                    }
                    return 0;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009d A[Catch: Exception -> 0x00d7, TryCatch #0 {Exception -> 0x00d7, blocks: (B:10:0x001a, B:12:0x0033, B:13:0x0036, B:46:0x009a, B:47:0x009d, B:52:0x00ab, B:54:0x00af, B:56:0x00b5, B:58:0x00bb, B:61:0x00c2, B:63:0x00c8, B:64:0x00cb, B:66:0x00d1, B:67:0x00d4, B:48:0x00a0, B:49:0x00a3, B:50:0x00a6, B:15:0x003b, B:18:0x0045, B:21:0x004f, B:24:0x0059, B:27:0x0063, B:30:0x006e, B:33:0x0076, B:36:0x007e, B:39:0x0086, B:42:0x008e, B:51:0x00a9), top: B:79:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a0 A[Catch: Exception -> 0x00d7, TryCatch #0 {Exception -> 0x00d7, blocks: (B:10:0x001a, B:12:0x0033, B:13:0x0036, B:46:0x009a, B:47:0x009d, B:52:0x00ab, B:54:0x00af, B:56:0x00b5, B:58:0x00bb, B:61:0x00c2, B:63:0x00c8, B:64:0x00cb, B:66:0x00d1, B:67:0x00d4, B:48:0x00a0, B:49:0x00a3, B:50:0x00a6, B:15:0x003b, B:18:0x0045, B:21:0x004f, B:24:0x0059, B:27:0x0063, B:30:0x006e, B:33:0x0076, B:36:0x007e, B:39:0x0086, B:42:0x008e, B:51:0x00a9), top: B:79:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3 A[Catch: Exception -> 0x00d7, TryCatch #0 {Exception -> 0x00d7, blocks: (B:10:0x001a, B:12:0x0033, B:13:0x0036, B:46:0x009a, B:47:0x009d, B:52:0x00ab, B:54:0x00af, B:56:0x00b5, B:58:0x00bb, B:61:0x00c2, B:63:0x00c8, B:64:0x00cb, B:66:0x00d1, B:67:0x00d4, B:48:0x00a0, B:49:0x00a3, B:50:0x00a6, B:15:0x003b, B:18:0x0045, B:21:0x004f, B:24:0x0059, B:27:0x0063, B:30:0x006e, B:33:0x0076, B:36:0x007e, B:39:0x0086, B:42:0x008e, B:51:0x00a9), top: B:79:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a6 A[Catch: Exception -> 0x00d7, TryCatch #0 {Exception -> 0x00d7, blocks: (B:10:0x001a, B:12:0x0033, B:13:0x0036, B:46:0x009a, B:47:0x009d, B:52:0x00ab, B:54:0x00af, B:56:0x00b5, B:58:0x00bb, B:61:0x00c2, B:63:0x00c8, B:64:0x00cb, B:66:0x00d1, B:67:0x00d4, B:48:0x00a0, B:49:0x00a3, B:50:0x00a6, B:15:0x003b, B:18:0x0045, B:21:0x004f, B:24:0x0059, B:27:0x0063, B:30:0x006e, B:33:0x0076, B:36:0x007e, B:39:0x0086, B:42:0x008e, B:51:0x00a9), top: B:79:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.ao.d(android.content.Context, java.lang.String, boolean):int");
    }

    private static int n(Context context, int i) {
        ServiceState serviceState;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.b)) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                serviceState = telephonyManager.getServiceState();
            } else {
                try {
                    serviceState = (ServiceState) z.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            }
            if (serviceState == null) {
                return i;
            }
            if (bb.Rk()) {
                Integer num = (Integer) z.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i;
            }
            if (hb(serviceState.toString())) {
                return 20;
            }
            return i;
        } catch (Exception unused2) {
            return i;
        }
    }

    private static int getSubId() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private static boolean hb(String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    public static boolean hc(String str) {
        return s(str, 3000);
    }

    private static boolean s(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
