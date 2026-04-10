package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    protected EventListener e;

    public void e(int i, Result result) {
        if (e()) {
            return;
        }
        this.e.onEvent(i, result);
    }

    public void e(int i) {
        e(i, null);
    }

    public boolean e() {
        return this.e == null;
    }
}
