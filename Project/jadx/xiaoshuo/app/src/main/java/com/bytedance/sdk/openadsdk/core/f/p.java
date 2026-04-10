package com.bytedance.sdk.openadsdk.core.f;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes10.dex */
public class p implements EventListener {
    private com.bytedance.sdk.openadsdk.bh.e e;

    public p(com.bytedance.sdk.openadsdk.bh.e eVar) {
        this.e = eVar;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        com.bytedance.sdk.openadsdk.bh.e eVar;
        com.bytedance.sdk.openadsdk.bh.e eVar2;
        if (i != 1) {
            if (i == 2 && result != null && (eVar2 = this.e) != null) {
                eVar2.e(result.isSuccess(), result.message());
            }
        } else if (result != null && (eVar = this.e) != null) {
            eVar.e(result.isSuccess(), result.code());
        }
        return null;
    }
}
