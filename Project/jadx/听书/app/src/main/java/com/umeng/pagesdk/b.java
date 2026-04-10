package com.umeng.pagesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2378a;
    private static Context b;
    private InterfaceC0503b c;
    private BroadcastReceiver d;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f2380a = new b(0);
    }

    /* JADX INFO: renamed from: com.umeng.pagesdk.b$b, reason: collision with other inner class name */
    public interface InterfaceC0503b {
        void a(com.umeng.pagesdk.a aVar);
    }

    private b() {
        this.d = new BroadcastReceiver() { // from class: com.umeng.pagesdk.b.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
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
                        com.umeng.pagesdk.a aVar = new com.umeng.pagesdk.a();
                        aVar.f2377a = intExtra;
                        aVar.b = intExtra2;
                        aVar.d = i2;
                        aVar.c = intExtra3;
                        aVar.e = i;
                        aVar.f = System.currentTimeMillis();
                        if (b.this.c != null) {
                            b.this.c.a(aVar);
                        }
                        b.this.b();
                    }
                } catch (Throwable unused) {
                }
            }
        };
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    public static b a(Context context) {
        if (b == null && context != null) {
            b = context.getApplicationContext();
        }
        return a.f2380a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        try {
            b.unregisterReceiver(this.d);
            f2378a = false;
        } catch (Throwable unused) {
        }
    }

    public final synchronized com.umeng.pagesdk.a a() {
        com.umeng.pagesdk.a aVar;
        int i;
        int intExtra;
        int intExtra2;
        int intExtra3;
        int i2;
        com.umeng.pagesdk.a aVar2 = null;
        try {
            Intent intentRegisterReceiver = b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            i = 0;
            intExtra = intentRegisterReceiver.getIntExtra("level", 0);
            intExtra2 = intentRegisterReceiver.getIntExtra("voltage", 0);
            intExtra3 = intentRegisterReceiver.getIntExtra("temperature", 0);
            int intExtra4 = intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
            i2 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i2 = 1;
                } else if (intExtra4 == 4) {
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
            aVar = new com.umeng.pagesdk.a();
        } catch (Throwable unused) {
        }
        try {
            aVar.f2377a = intExtra;
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

    public final synchronized void a(InterfaceC0503b interfaceC0503b) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            b.registerReceiver(this.d, intentFilter);
            f2378a = true;
            this.c = interfaceC0503b;
        } catch (Throwable unused) {
        }
    }
}
