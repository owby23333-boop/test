package com.bytedance.sdk.openadsdk.api.plugin;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Exception {
    private final int mb;

    public b(int i2, String str) {
        super(str);
        this.mb = i2;
    }

    public int mb() {
        return this.mb;
    }
}
