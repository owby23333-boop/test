package com.amgcyo.cuttadon.utils.comic.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ComicsNetUtil {
    private static c a = new c();
    private static List<b> b = new ArrayList();

    public enum ConnectStatus {
        NO_NETWORK("无网络"),
        WIFI("WIFI"),
        MOBILE("2G"),
        MOBILE_2G("2G"),
        MOBILE_3G("3G"),
        MOBILE_4G("4G"),
        MOBILE_UNKNOWN("未知网络"),
        OTHER("其它网络"),
        NO_CONNECTED("无连接");


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private String f4376s;

        ConnectStatus(String str) {
            this.f4376s = str;
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            return this.f4376s;
        }
    }

    public interface b {
        void a(ConnectStatus connectStatus);
    }

    private static final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkInfo networkInfoB = ComicsNetUtil.b(context);
            if (networkInfoB == null) {
                ComicsNetUtil.b("onReceive1");
                ComicsNetUtil.b(ConnectStatus.NO_NETWORK);
                return;
            }
            if (!networkInfoB.isConnected()) {
                ComicsNetUtil.b("onReceive8");
                ComicsNetUtil.b(ConnectStatus.NO_CONNECTED);
                return;
            }
            int type = networkInfoB.getType();
            if (1 == type) {
                ComicsNetUtil.b("onReceive2");
                ComicsNetUtil.b(ConnectStatus.WIFI);
                return;
            }
            if (type != 0) {
                ComicsNetUtil.b("onReceive7");
                ComicsNetUtil.b(ConnectStatus.OTHER);
                return;
            }
            ComicsNetUtil.b("onReceive3");
            ComicsNetUtil.b(ConnectStatus.MOBILE);
            int subtype = networkInfoB.getSubtype();
            if (1 == subtype || 16 == subtype || 2 == subtype || 4 == subtype || 7 == subtype || 11 == subtype) {
                ComicsNetUtil.b("onReceive3");
                ComicsNetUtil.b(ConnectStatus.MOBILE_2G);
                return;
            }
            if (3 == subtype || 5 == subtype || 6 == subtype || 8 == subtype || 9 == subtype || 10 == subtype || 12 == subtype || 14 == subtype || 15 == subtype || 17 == subtype) {
                ComicsNetUtil.b("onReceive4");
                ComicsNetUtil.b(ConnectStatus.MOBILE_3G);
            } else if (13 == subtype || 18 == subtype) {
                ComicsNetUtil.b("onReceive5");
                ComicsNetUtil.b(ConnectStatus.MOBILE_4G);
            } else {
                ComicsNetUtil.b("onReceive6");
                ComicsNetUtil.b(ConnectStatus.MOBILE_UNKNOWN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ConnectStatus connectStatus) {
        int size = b.size();
        b("size: " + size);
        if (size == 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            b.get(i2).a(connectStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
    }

    public static boolean c(Context context) {
        a(context, "context == null");
        NetworkInfo networkInfoB = b(context);
        return networkInfoB != null && networkInfoB.isConnected() && networkInfoB.getType() == 1;
    }

    public static void d(Context context) {
        a(context, "context == null");
        IntentFilter intentFilter = new IntentFilter();
        b("注册网络接收者");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(a, intentFilter);
    }

    public static void e(Context context) {
        a(context, "context == null");
        b("取消注册网络接收者");
        context.unregisterReceiver(a);
        b.clear();
    }

    public static void a(b bVar) {
        a(bVar, "listener == null");
        b("addNetConnChangedListener: " + b.add(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NetworkInfo b(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
