package com.bytedance.sdk.openadsdk.hh;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.pf;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements pf {
    @Override // com.bytedance.sdk.component.utils.pf
    public boolean z(Context context, TelephonyManager telephonyManager) {
        return g(context, telephonyManager);
    }

    private static boolean g(Context context, TelephonyManager telephonyManager) {
        ServiceState serviceState;
        if (context != null && Build.VERSION.SDK_INT >= 29 && context.checkSelfPermission(com.kuaishou.weapon.p0.g.c) == 0) {
            try {
                int iZ = z();
                if (iZ == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(iZ));
                }
                return z(serviceState);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static int z() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private static boolean z(ServiceState serviceState) {
        try {
            Method method = serviceState.getClass().getMethod("getNrState", new Class[0]);
            if (method != null) {
                method.setAccessible(true);
                int iIntValue = ((Integer) method.invoke(serviceState, new Object[0])).intValue();
                return iIntValue == 3 || iIntValue == 2;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
