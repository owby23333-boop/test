package com.bytedance.embedapplog;

import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
public class hn {
    public static String z(TelephonyManager telephonyManager) {
        if (cb.g) {
            cb.z("SensitiveUtils gDI c", null);
        }
        return telephonyManager.getDeviceId();
    }
}
