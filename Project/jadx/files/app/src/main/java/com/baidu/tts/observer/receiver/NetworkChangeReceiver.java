package com.baidu.tts.observer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tts.flyweight.persistent.PersistentPool;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return;
        }
        activeNetworkInfo.getType();
    }

    public void registerNetworkChangeReceiver() {
        PersistentPool.getInstance().getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void unregisterNetworkChangeReceiver() {
        PersistentPool.getInstance().getContext().unregisterReceiver(this);
    }
}
