package com.bytedance.sdk.openadsdk.core.multipro.aidl.g;

import android.os.Bundle;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a extends p.z {
    private final com.bytedance.sdk.openadsdk.sy.z.g.z.g z;

    public a(com.bytedance.sdk.openadsdk.sy.z.g.z.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p
    public Bundle z(int i) {
        com.bytedance.sdk.openadsdk.sy.z.g.z.g gVar = this.z;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (gVar != null) {
            gVar.z(i, new com.bytedance.sdk.openadsdk.p.z.z.g.z.z() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.g.a.1
                @Override // com.bytedance.sdk.openadsdk.p.z.z.g.z.z
                public void z(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            wp.z(e);
        }
        return bundle;
    }
}
