package com.alibaba.sdk.android.httpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private static Context a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static boolean f2210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f2211j;

    /* JADX INFO: Access modifiers changed from: private */
    public static String f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                String typeName = activeNetworkInfo.getTypeName();
                i.d("[detectCurrentNetwork] - Network name:" + typeName + " subType name: " + activeNetworkInfo.getSubtypeName());
                return typeName == null ? "None_Network" : typeName;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "None_Network";
    }

    public static void setContext(Context context) {
        if (context == null) {
            throw new IllegalStateException("Context can't be null");
        }
        a = context;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.alibaba.sdk.android.httpdns.p.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                try {
                    if (!isInitialStickyBroadcast() && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        com.alibaba.sdk.android.httpdns.b.b.b(context2);
                        String strF = p.f();
                        if (strF != "None_Network" && !strF.equalsIgnoreCase(p.f2211j)) {
                            i.d("[BroadcastReceiver.onReceive] - Network state changed");
                            ArrayList<String> arrayListM15a = d.a().m15a();
                            d.a().clear();
                            d.a().m16a();
                            if (p.f2210i && HttpDns.instance != null) {
                                i.d("[BroadcastReceiver.onReceive] - refresh host");
                                HttpDns.instance.setPreResolveHosts(arrayListM15a);
                            }
                        }
                        String unused = p.f2211j = strF;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            a.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
