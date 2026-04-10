package com.yuewen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class ut {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<BroadcastReceiver> f18713a;

    public void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return;
        }
        if (this.f18713a == null) {
            this.f18713a = new HashSet<>();
        }
        if (this.f18713a.contains(broadcastReceiver)) {
            return;
        }
        this.f18713a.add(broadcastReceiver);
        context.registerReceiver(broadcastReceiver, intentFilter, 2);
    }

    public void b(Context context, BroadcastReceiver broadcastReceiver) {
        HashSet<BroadcastReceiver> hashSet;
        if (context == null || (hashSet = this.f18713a) == null || hashSet.isEmpty() || !this.f18713a.remove(broadcastReceiver)) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
        if (this.f18713a.isEmpty()) {
            this.f18713a = null;
        }
    }

    public void c(Context context) {
        HashSet<BroadcastReceiver> hashSet;
        if (context == null || (hashSet = this.f18713a) == null) {
            return;
        }
        Iterator<BroadcastReceiver> it = hashSet.iterator();
        while (it.hasNext()) {
            context.unregisterReceiver(it.next());
        }
        this.f18713a = null;
    }
}
