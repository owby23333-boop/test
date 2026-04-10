package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes2.dex */
public class cm {
    private static volatile cm a;

    private cm() {
    }

    public static cm a() {
        if (a == null) {
            synchronized (cm.class) {
                if (a == null) {
                    a = new cm();
                }
            }
        }
        return a;
    }

    private NetworkCapabilities c(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (Throwable unused) {
            return null;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                return ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z2 = true;
            if (bj.a(context).a() < 29) {
                NetworkInfo networkInfoB = b(context);
                if (networkInfoB == null || !networkInfoB.isConnected() || networkInfoB.getType() != 1) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
            NetworkCapabilities networkCapabilitiesC = c(context);
            if (networkCapabilitiesC == null || !networkCapabilitiesC.hasCapability(12) || !networkCapabilitiesC.hasCapability(16) || !networkCapabilitiesC.hasTransport(1)) {
                z2 = false;
            }
            return Boolean.valueOf(z2);
        } catch (Throwable unused) {
            return false;
        }
    }
}
