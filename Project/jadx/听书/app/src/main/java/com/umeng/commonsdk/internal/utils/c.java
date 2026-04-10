package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* JADX INFO: compiled from: BatteryUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2309a = "BatteryUtils";
    private static boolean b;
    private static Context c;
    private BroadcastReceiver d;

    private c() {
        this.d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
                        int i2 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i2 = 1;
                            } else if (intExtra4 == 4) {
                                i2 = 0;
                            } else if (intExtra4 == 5) {
                                i2 = 2;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i = 1;
                        } else if (intExtra5 == 2) {
                            i = 2;
                        }
                        b bVar = new b();
                        bVar.f2308a = intExtra;
                        bVar.b = intExtra2;
                        bVar.d = i2;
                        bVar.c = intExtra3;
                        bVar.e = i;
                        bVar.f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.h, com.umeng.commonsdk.internal.b.a(c.c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.c, th);
                }
            }
        };
    }

    /* JADX INFO: compiled from: BatteryUtils.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f2311a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (c == null && context != null) {
            c = context.getApplicationContext();
        }
        return a.f2311a;
    }

    public synchronized boolean a() {
        return b;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            c.registerReceiver(this.d, intentFilter);
            b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(c, th);
        }
    }

    public synchronized void c() {
        try {
            c.unregisterReceiver(this.d);
            b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(c, th);
        }
    }
}
