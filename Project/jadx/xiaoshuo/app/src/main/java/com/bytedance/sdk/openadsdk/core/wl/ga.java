package com.bytedance.sdk.openadsdk.core.wl;

import com.bykv.vk.openvk.api.proto.Result;

/* JADX INFO: loaded from: classes10.dex */
public class ga {
    private Result bf;
    private int e;

    public ga(Result result, int i) {
        this.e = i;
        this.bf = result;
    }

    public Result d() {
        return this.bf;
    }

    public int getType() {
        return this.e;
    }

    public void setResult(Result result) {
        this.bf = result;
    }
}
