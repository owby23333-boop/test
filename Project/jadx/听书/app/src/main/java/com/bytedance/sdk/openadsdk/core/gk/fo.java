package com.bytedance.sdk.openadsdk.core.gk;

import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    private static PluginValueSet dl;
    private static com.bytedance.sdk.openadsdk.core.dl g;
    private static final AtomicInteger z = new AtomicInteger(com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), "sync_switch", 0).getInt(NotificationCompat.CATEGORY_STATUS, 1));

    public static boolean z() {
        return z.get() == 1;
    }

    protected static void z(int i) {
        com.bytedance.sdk.openadsdk.core.dl dlVar;
        if (i == 1 || i == 2) {
            com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), "sync_switch", 0).edit().putInt(NotificationCompat.CATEGORY_STATUS, i).apply();
            AtomicInteger atomicInteger = z;
            int i2 = atomicInteger.get();
            atomicInteger.set(i);
            if (i2 != 2 || i != 1 || (dlVar = g) == null || dlVar.z()) {
                return;
            }
            try {
                g.z(zw.getContext(), dl, new com.bytedance.sdk.openadsdk.core.ti.dl((Function) dl.objectValue(15, Function.class)));
                g = null;
                dl = null;
            } catch (Throwable th) {
                wp.dl("SdkSwitch", "init sdk error", th);
            }
        }
    }
}
