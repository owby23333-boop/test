package com.bytedance.sdk.openadsdk.s;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.s;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes10.dex */
public class ga implements s {
    private static boolean bf(Context context, TelephonyManager telephonyManager) {
        ServiceState serviceState;
        if (context != null && Build.VERSION.SDK_INT >= 29 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                int iE = e();
                if (iE == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(iE));
                }
                return e(serviceState);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.utils.s
    public boolean e(Context context, TelephonyManager telephonyManager) {
        return bf(context, telephonyManager);
    }

    private static int e() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private static boolean e(ServiceState serviceState) {
        try {
            Method method = serviceState.getClass().getMethod("getNrState", new Class[0]);
            if (method == null) {
                return false;
            }
            method.setAccessible(true);
            int iIntValue = ((Integer) method.invoke(serviceState, new Object[0])).intValue();
            return iIntValue == 3 || iIntValue == 2;
        } catch (Exception unused) {
            return false;
        }
    }
}
