package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.component.adexpress.gc.gc;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.io;
import com.bytedance.sdk.openadsdk.core.un.kb;
import com.bytedance.sdk.openadsdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static void z() {
        com.bytedance.sdk.component.a.z zVarG;
        gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.dl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    wp.z("lqmt", "isReuseService key: ILoaderCenter, value: " + uy.ls().fo("img_service"));
                    if (!uy.ls().fo("img_service")) {
                        com.bytedance.sdk.openadsdk.gz.g.z().clearMemoryCache(0.0d);
                    }
                    dl.unregisterReceiver();
                    gc.z().g();
                } catch (Throwable unused) {
                }
            }
        }, 20000L);
        wp.z("lqmt", "isReuseService key: IArmorService, value: " + uy.ls().fo("armor_service"));
        wp.z("lqmt", "isReuseService key: IDeviceInfo, value: " + uy.ls().fo("device_info"));
        if (uy.ls().fo("device_info") || (zVarG = io.g()) == null) {
            return;
        }
        zVarG.pglArmorCallApiCancelListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterReceiver() {
        kb.gc();
        kb.i();
    }
}
