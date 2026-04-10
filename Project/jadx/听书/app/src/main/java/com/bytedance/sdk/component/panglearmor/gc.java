package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static volatile boolean z;

    public static void z(Context context) {
        if (z || context == null) {
            return;
        }
        g(context);
        dl(context);
        a(context);
        gc(context);
        z = true;
    }

    private static void g(Context context) {
        boolean booleanExtra = true;
        double intExtra = -0.1d;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                booleanExtra = intentRegisterReceiver.getBooleanExtra("present", false);
                intExtra = ((double) intentRegisterReceiver.getIntExtra("temperature", -1)) / 10.0d;
            }
        } catch (Throwable unused) {
        }
        m.z(1006, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(intExtra)});
    }

    private static void dl(Context context) {
        int i;
        int i2;
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                i = 0;
                i2 = 0;
                for (String str : cameraManager.getCameraIdList()) {
                    int iIntValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                    if (iIntValue == 0) {
                        i++;
                    } else if (iIntValue == 1) {
                        i2++;
                    }
                }
            } catch (Throwable unused) {
                i = -1;
                i2 = i;
            }
            m.z(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        i = -2;
        i2 = i;
        m.z(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static void a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        boolean z2 = true;
        if (configuration != null && (configuration.touchscreen == 1 || configuration.touchscreen == 0)) {
            z2 = false;
        }
        m.z(1008, new Object[]{Boolean.valueOf(z2)});
    }

    private static void gc(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        m.z(1009, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }
}
