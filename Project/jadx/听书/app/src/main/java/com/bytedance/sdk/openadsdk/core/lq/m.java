package com.bytedance.sdk.openadsdk.core.lq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.wp;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static int z(Context context, boolean z) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Throwable th) {
            wp.z(th);
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                if (com.bytedance.sdk.openadsdk.core.uf.gc.z().z(context, "android.permission.CHANGE_NETWORK_STATE") && z) {
                    return z(connectivityManager) ? 3 : 2;
                }
                return 2;
            }
            if (type == 0) {
                return 1;
            }
            return 0;
        }
        return 0;
    }

    private static boolean z(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            wp.a("transmit_TelephonyUtils", "isMobileEnabled error:" + th.getMessage());
            return false;
        }
    }

    public static boolean z(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
