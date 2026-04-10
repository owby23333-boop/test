package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* JADX INFO: compiled from: BatteryUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final String a = "BatteryUtils";
    private static boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f20011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f20012d;

    /* JADX INFO: compiled from: BatteryUtils.java */
    private static class a {
        private static final c a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f20011c == null && context != null) {
            f20011c = context.getApplicationContext();
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f20011c.registerReceiver(this.f20012d, intentFilter);
            b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f20011c, th);
        }
    }

    public synchronized void c() {
        try {
            f20011c.unregisterReceiver(this.f20012d);
            b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f20011c, th);
        }
    }

    private c() {
        this.f20012d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i2 = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra("status", 0);
                        int i3 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i3 = 1;
                            } else if (intExtra4 != 3) {
                                if (intExtra4 == 4) {
                                    i3 = 0;
                                } else if (intExtra4 == 5) {
                                    i3 = 2;
                                }
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i2 = 1;
                        } else if (intExtra5 == 2) {
                            i2 = 2;
                        }
                        b bVar = new b();
                        bVar.a = intExtra;
                        bVar.b = intExtra2;
                        bVar.f20008d = i3;
                        bVar.f20007c = intExtra3;
                        bVar.f20009e = i2;
                        bVar.f20010f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f19976h, com.umeng.commonsdk.internal.b.a(c.f20011c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f20011c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return b;
    }
}
