package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<z> z;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<z> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().b_(intExtra);
    }

    public void z(z zVar) {
        this.z = new WeakReference<>(zVar);
    }
}
