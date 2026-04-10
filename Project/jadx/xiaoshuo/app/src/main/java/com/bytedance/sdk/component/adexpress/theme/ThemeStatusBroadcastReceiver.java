package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.component.utils.wu;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<e> e;

    public void e(e eVar) {
        this.e = new WeakReference<>(eVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        wu.bf("ThemeStatusBroadcastReceiver", "====主题状态更新====");
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<e> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().b_(intExtra);
    }
}
