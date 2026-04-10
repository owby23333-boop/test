package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.core.tb.a {
    private final WeakReference<com.bytedance.sdk.openadsdk.core.js.a> z;

    public a(com.bytedance.sdk.openadsdk.core.js.a aVar) {
        this.z = new WeakReference<>(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.v.z
    public void z() {
        if (this.z.get() != null) {
            this.z.get().z(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.v.z
    public void z(int i, String str) {
        WeakReference<com.bytedance.sdk.openadsdk.core.js.a> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get();
    }
}
