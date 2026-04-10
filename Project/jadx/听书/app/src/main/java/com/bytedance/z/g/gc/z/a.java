package com.bytedance.z.g.gc.z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes2.dex */
class a {
    private int z;

    a(Context context) {
        try {
            z(context);
        } catch (Throwable unused) {
        }
    }

    private void z(Context context) {
        context.registerReceiver(new z(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int z() {
        return this.z;
    }

    private class z extends BroadcastReceiver {
        private z() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    a.this.z = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
