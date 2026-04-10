package com.bytedance.sdk.gromore.z.z.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class i extends com.bytedance.sdk.openadsdk.ls.dl.g.wp {
    private int dl;
    private int g;
    private String z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
    public double a() {
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
    public boolean gc() {
        return false;
    }

    public i(String str) {
        this.z = str;
    }

    public i(String str, int i, int i2) {
        this.z = str;
        this.g = i;
        this.dl = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
    public int z() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
    public int g() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
    public String dl() {
        return !TextUtils.isEmpty(this.z) ? this.z : "";
    }
}
