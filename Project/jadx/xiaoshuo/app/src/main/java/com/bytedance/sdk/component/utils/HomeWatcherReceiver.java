package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.yuewen.h8;

/* JADX INFO: loaded from: classes.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {
    private e e;

    public interface e {
        void bf();

        void e();
    }

    public void e(e eVar) {
        this.e = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        Log.i("HomeReceiver", "onReceive: action: " + action);
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
            String stringExtra = intent.getStringExtra(h8.d);
            Log.i("HomeReceiver", "reason: " + stringExtra);
            if ("homekey".equals(stringExtra)) {
                Log.i("HomeReceiver", "homekey");
                e eVar = this.e;
                if (eVar != null) {
                    eVar.e();
                    return;
                }
                return;
            }
            if (!"recentapps".equals(stringExtra)) {
                if ("assist".equals(stringExtra)) {
                    Log.i("HomeReceiver", "assist");
                }
            } else {
                Log.i("HomeReceiver", "long press home key or activity switch");
                e eVar2 = this.e;
                if (eVar2 != null) {
                    eVar2.bf();
                }
            }
        }
    }
}
