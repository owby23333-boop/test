package com.bytedance.sdk.component.panglarmor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.xiaomi.onetrack.api.at;
import com.xiaomi.passport.ui.page.UserAvatarUpdateActivity;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private static volatile boolean e = false;

    private static void bf(Context context) {
        boolean booleanExtra;
        int intExtra;
        double intExtra2 = -0.1d;
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                booleanExtra = intentRegisterReceiver.getBooleanExtra("present", false);
                try {
                    intExtra2 = ((double) intentRegisterReceiver.getIntExtra("temperature", -1)) / 10.0d;
                    intExtra = intentRegisterReceiver.getIntExtra("health", 1);
                } catch (Throwable unused) {
                    intExtra = 1;
                }
            } else {
                intExtra = 1;
                booleanExtra = true;
            }
        } catch (Throwable unused2) {
            booleanExtra = true;
        }
        SoftDecTool.a(1006, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(intExtra2), Integer.valueOf(intExtra)});
    }

    private static void d(Context context) {
        int i;
        int i2;
        CameraManager cameraManager = (CameraManager) context.getSystemService(UserAvatarUpdateActivity.CAMERA);
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
            SoftDecTool.a(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
        }
        i = -2;
        i2 = i;
        SoftDecTool.a(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void e(Context context) {
        if (e || context == null) {
            return;
        }
        bf(context);
        d(context);
        tg(context);
        ga(context);
        e = true;
    }

    private static void ga(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(at.d);
        SoftDecTool.a(1009, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }

    private static void tg(Context context) {
        int i;
        Configuration configuration = context.getResources().getConfiguration();
        SoftDecTool.a(1008, new Object[]{Boolean.valueOf(configuration == null || !((i = configuration.touchscreen) == 1 || i == 0))});
    }
}
