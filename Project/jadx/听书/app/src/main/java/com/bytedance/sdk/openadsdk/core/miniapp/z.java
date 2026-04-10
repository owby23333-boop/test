package com.bytedance.sdk.openadsdk.core.miniapp;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.eo;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;
    private String g = "";

    private z() {
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public void registerReceiver(Context context) {
        MiniAppBroadcastReceiver miniAppBroadcastReceiver = new MiniAppBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.byted.pma.PMA_DATA");
        intentFilter.addDataScheme("package");
        intentFilter.addDataAuthority(context.getPackageName(), null);
        try {
            context.registerReceiver(miniAppBroadcastReceiver, intentFilter, eo.sy(), null);
        } catch (Throwable th) {
            wp.a("MiniAppManager", "register BroadcastReceiver : " + th.getMessage());
        }
    }

    public String g() {
        return this.g;
    }

    public void z(String str) {
        this.g = str;
    }
}
