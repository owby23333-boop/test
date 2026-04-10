package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.pangle.gc.gc;

/* JADX INFO: loaded from: classes2.dex */
public class BroadcastReceiverProxy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (g.z().z(hashCode())) {
            g.z().z(context, intent);
        } else {
            gc.dl(new Runnable() { // from class: com.bytedance.pangle.receiver.BroadcastReceiverProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    g.z().z(context, intent);
                }
            });
        }
    }
}
