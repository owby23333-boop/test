package com.bytedance.sdk.openadsdk.core.miniapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class MiniAppBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("pma_data");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                z.z().z(stringExtra);
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }
}
