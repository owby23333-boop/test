package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z;

import android.content.Context;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static boolean z(Context context) {
        return a(context) && gc(context);
    }

    public static void g(Context context) {
        Vibrator vibratorDl = dl(context);
        if (vibratorDl != null) {
            vibratorDl.cancel();
        }
    }

    private static boolean a(Context context) {
        return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0;
    }

    private static boolean gc(Context context) {
        Vibrator vibratorDl = dl(context);
        return vibratorDl != null && vibratorDl.hasVibrator();
    }

    public static Vibrator dl(Context context) {
        try {
            return (Vibrator) context.getSystemService("vibrator");
        } catch (Exception unused) {
            return null;
        }
    }
}
