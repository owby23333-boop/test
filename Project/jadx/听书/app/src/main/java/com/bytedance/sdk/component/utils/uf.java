package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class uf {
    private static final Object z = new Object();
    private static final Map<z, Object> g = new ConcurrentHashMap();
    private static AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f795a = -1;
    private static volatile long gc = 0;
    private static volatile int m = 60000;
    private static pf e = null;
    private static final AtomicBoolean gz = new AtomicBoolean(false);

    public interface z {
        void z(Context context, Intent intent, boolean z, int i);
    }

    public static void z(pf pfVar) {
        e = pfVar;
    }

    public static int z(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (gc + j <= jElapsedRealtime) {
            return g(context);
        }
        if (f795a == -1) {
            return g(context);
        }
        if (jElapsedRealtime - gc >= m) {
            g(context, (Intent) null, false, false);
        }
        return f795a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final Context context, final Intent intent, final boolean z2, final boolean z3) {
        if (!z2 && z3) {
            f795a = 0;
        } else if (gz.compareAndSet(false, true)) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("getNetworkType") { // from class: com.bytedance.sdk.component.utils.uf.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = uf.f795a = z3 ? 0 : uf.g(context);
                    if (z2) {
                        uf.g(context, intent, uf.f795a, z3);
                    }
                    uf.gz.set(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, Intent intent, int i, boolean z2) {
        Map<z, Object> map = g;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (z zVar : map.keySet()) {
            if (zVar != null) {
                zVar.z(context, intent, !z2, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(Context context) {
        f795a = dl(context);
        gc = SystemClock.elapsedRealtime();
        return f795a;
    }

    private static int dl(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        pf pfVar = e;
                        return (pfVar == null || !pfVar.z(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void z(z zVar, Context context) {
        if (zVar == null) {
            return;
        }
        if (!dl.get()) {
            try {
                context.registerReceiver(new g(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                dl.set(true);
            } catch (Throwable unused) {
            }
        }
        g.put(zVar, z);
    }

    public static void z(z zVar) {
        if (zVar == null) {
            return;
        }
        g.remove(zVar);
    }

    private static class g extends BroadcastReceiver {
        private g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (uf.g != null && uf.g.size() > 0) {
                z = true;
            }
            uf.g(context, intent, z, booleanExtra);
        }
    }
}
