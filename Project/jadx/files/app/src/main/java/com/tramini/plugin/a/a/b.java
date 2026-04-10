package com.tramini.plugin.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static volatile b b;
    Context a;

    private b(Context context) {
        this.a = context;
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused) {
        }
        try {
            LocalBroadcastManager.getInstance(this.a).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused2) {
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver) {
        try {
            LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
        }
        try {
            LocalBroadcastManager.getInstance(this.a).unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused2) {
        }
    }
}
