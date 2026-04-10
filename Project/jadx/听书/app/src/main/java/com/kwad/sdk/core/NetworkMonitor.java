package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkMonitor {
    private static volatile boolean awD;
    private final List<a> awE;
    private final WeakHashMap<a, AdTemplate> awF;
    private final Map<a, AdTemplate> awG;
    private boolean awH;
    private final BroadcastReceiver awI;

    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    public interface a {
        void a(NetworkState networkState);
    }

    /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    private NetworkMonitor() {
        this.awE = new CopyOnWriteArrayList();
        WeakHashMap<a, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.awF = weakHashMap;
        this.awG = Collections.synchronizedMap(weakHashMap);
        this.awH = false;
        this.awI = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if ((ContextCompat.checkSelfPermission(context, g.b) == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                            return;
                        }
                        if (1 == activeNetworkInfo.getType()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                        } else if (activeNetworkInfo.getType() == 0) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                        } else {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(Context context, a aVar) {
        bp(context);
        if (this.awE.contains(aVar)) {
            return;
        }
        this.awE.add(aVar);
    }

    public final void a(Context context, a aVar, AdTemplate adTemplate) {
        bp(context);
        this.awG.put(aVar, adTemplate);
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.awE.remove(aVar);
    }

    private synchronized void bp(Context context) {
        if (awD || context == null) {
            return;
        }
        try {
            context.getApplicationContext().registerReceiver(this.awI, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            awD = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        Iterator<a> it = this.awE.iterator();
        while (it.hasNext()) {
            it.next().a(networkState);
        }
    }

    enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor(0);

        Holder() {
        }

        final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }
}
