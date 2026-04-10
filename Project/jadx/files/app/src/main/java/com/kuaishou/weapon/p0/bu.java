package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes2.dex */
public class bu {
    public static String a(Context context) {
        int intExtra = 0;
        try {
            if (d(context) != null) {
                intExtra = (int) ((r3.getIntExtra("level", -1) / r3.getIntExtra("scale", -1)) * 100.0f);
            }
            return intExtra + "%";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            int intExtra = d(context).getIntExtra("plugged", -1);
            return intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "" : "Wireless charger" : "USB charger" : "AC charger";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int c(Context context) {
        try {
            switch (d(context).getIntExtra("health", -1)) {
            }
            return 6;
        }
    }

    private static Intent d(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
