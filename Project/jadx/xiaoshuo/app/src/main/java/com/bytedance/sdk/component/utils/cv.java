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
import com.xiaomi.onetrack.api.at;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class cv {
    private static final Object e = new Object();
    private static final Map<e, Object> bf = new ConcurrentHashMap();
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static volatile int tg = -1;
    private static volatile long ga = 0;
    private static volatile int vn = 60000;
    private static s p = null;
    private static final AtomicBoolean v = new AtomicBoolean(false);

    public static class bf extends BroadcastReceiver {
        private bf() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (cv.bf != null && cv.bf.size() > 0) {
                z = true;
            }
            cv.bf(context, intent, z, booleanExtra);
        }
    }

    public interface e {
        void e(Context context, Intent intent, boolean z, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bf(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            tg = 0;
        } else if (v.compareAndSet(false, true)) {
            com.bytedance.sdk.component.zk.ga.bf(new com.bytedance.sdk.component.zk.p("getNetworkType") { // from class: com.bytedance.sdk.component.utils.cv.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = cv.tg = z2 ? 0 : cv.bf(context);
                    cv.v.set(false);
                    if (z) {
                        cv.bf(context, intent, cv.tg, z2);
                    }
                }
            });
        }
    }

    private static int d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(at.d);
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
                        s sVar = p;
                        return (sVar == null || !sVar.e(context, telephonyManager)) ? 5 : 6;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void bf(Context context, Intent intent, int i, boolean z) {
        Map<e, Object> map = bf;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (e eVar : map.keySet()) {
            if (eVar != null) {
                eVar.e(context, intent, !z, i);
            }
        }
    }

    public static void e(s sVar) {
        p = sVar;
    }

    public static int e(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (ga + j <= jElapsedRealtime) {
            return bf(context);
        }
        if (tg == -1) {
            return bf(context);
        }
        if (jElapsedRealtime - ga >= vn) {
            bf(context, (Intent) null, false, false);
        }
        return tg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int bf(Context context) {
        tg = d(context);
        ga = SystemClock.elapsedRealtime();
        return tg;
    }

    public static void e(e eVar, Context context) {
        if (eVar == null) {
            return;
        }
        if (!d.get()) {
            try {
                context.registerReceiver(new bf(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                d.set(true);
            } catch (Throwable unused) {
            }
        }
        bf.put(eVar, e);
    }

    public static void e(e eVar) {
        if (eVar == null) {
            return;
        }
        bf.remove(eVar);
    }
}
