package com.xiaomi.push;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: loaded from: classes8.dex */
class bg extends ConnectivityManager.NetworkCallback {
    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        super.onAvailable(network);
        bf.b();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        super.onLost(network);
        bf.b();
    }
}
