package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {
    private z z;

    public interface z {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            wp.z("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON);
                wp.z("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    wp.z("HomeReceiver", "homekey");
                } else if ("recentapps".equals(stringExtra)) {
                    wp.z("HomeReceiver", "long press home key or activity switch");
                } else if ("assist".equals(stringExtra)) {
                    wp.z("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
            wp.a("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
