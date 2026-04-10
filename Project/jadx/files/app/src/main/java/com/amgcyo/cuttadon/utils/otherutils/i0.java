package com.amgcyo.cuttadon.utils.otherutils;

import android.os.Build;
import android.os.PowerManager;
import androidx.annotation.RequiresApi;
import com.amgcyo.cuttadon.app.MkApplication;

/* JADX INFO: compiled from: PermissionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class i0 {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @RequiresApi(api = 23)
    public static boolean b() {
        PowerManager powerManager = (PowerManager) MkApplication.getAppContext().getSystemService("power");
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(MkApplication.getAppContext().getPackageName());
        }
        return false;
    }
}
