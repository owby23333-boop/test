package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkMonitor {
    private static volatile boolean abi = false;
    private final List<a> abj;
    private boolean abk;
    private final BroadcastReceiver abl;

    enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor(0);

        Holder() {
        }

        final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    public interface a {
        void a(NetworkState networkState);
    }

    private NetworkMonitor() {
        this.abj = new CopyOnWriteArrayList();
        this.abk = false;
        this.abl = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                NetworkMonitor networkMonitor;
                NetworkState networkState;
                try {
                    if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                            return;
                        }
                        if (1 == activeNetworkInfo.getType()) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_WIFI;
                        } else if (activeNetworkInfo.getType() == 0) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_MOBILE;
                        } else {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_NONE;
                        }
                        networkMonitor.b(networkState);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    private synchronized void aN(Context context) {
        if (abi) {
            return;
        }
        if (context == null) {
            return;
        }
        context.getApplicationContext().registerReceiver(this.abl, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        abi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        Iterator<a> it = this.abj.iterator();
        while (it.hasNext()) {
            it.next().a(networkState);
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(Context context, @NonNull a aVar) {
        aN(context);
        this.abj.add(aVar);
    }

    public final void a(a aVar) {
        this.abj.remove(aVar);
    }
}
