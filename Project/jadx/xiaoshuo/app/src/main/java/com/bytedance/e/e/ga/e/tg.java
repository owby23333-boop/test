package com.bytedance.e.e.ga.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.onetrack.b.a;

/* JADX INFO: loaded from: classes.dex */
class tg {
    private int e;

    public class e extends BroadcastReceiver {
        private e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    tg.this.e = (int) ((intent.getIntExtra(a.d, 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public tg(Context context) {
        try {
            e(context);
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        context.registerReceiver(new e(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int e() {
        return this.e;
    }
}
