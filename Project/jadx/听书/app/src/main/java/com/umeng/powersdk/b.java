package com.umeng.powersdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2389a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f2390a = new b(0);
    }

    private b() {
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a(Context context) {
        if (f2389a == null && context != null) {
            f2389a = context.getApplicationContext();
        }
        return a.f2390a;
    }

    public final synchronized com.umeng.powersdk.a a() {
        com.umeng.powersdk.a aVar;
        int i;
        int intExtra;
        int intExtra2;
        int intExtra3;
        int i2;
        com.umeng.powersdk.a aVar2 = null;
        try {
            Intent intentRegisterReceiver = f2389a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            i = 0;
            intExtra = intentRegisterReceiver.getIntExtra("level", 0);
            intExtra2 = intentRegisterReceiver.getIntExtra("voltage", 0);
            intExtra3 = intentRegisterReceiver.getIntExtra("temperature", 0);
            int intExtra4 = intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
            i2 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i2 = 1;
                } else if (intExtra4 == 3 || intExtra4 == 4) {
                    i2 = 0;
                } else if (intExtra4 == 5) {
                    i2 = 2;
                }
            }
            int intExtra5 = intentRegisterReceiver.getIntExtra("plugged", 0);
            if (intExtra5 == 1) {
                i = 1;
            } else if (intExtra5 == 2) {
                i = 2;
            }
            aVar = new com.umeng.powersdk.a();
        } catch (Throwable unused) {
        }
        try {
            aVar.f2388a = intExtra;
            aVar.b = intExtra2;
            aVar.d = i2;
            aVar.c = intExtra3;
            aVar.e = i;
            aVar.f = System.currentTimeMillis();
        } catch (Throwable unused2) {
            aVar2 = aVar;
            aVar = aVar2;
        }
        return aVar;
    }
}
