package com.bytedance.sdk.openadsdk.core.uf;

import com.bytedance.sdk.openadsdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    Boolean z = null;
    Boolean g = null;
    Boolean dl = null;

    public boolean z() {
        if (this.z == null) {
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
            this.z = Boolean.valueOf(aVarP == null || aVarP.dl());
        }
        return this.z.booleanValue();
    }

    public boolean g() {
        if (this.g == null) {
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
            this.g = Boolean.valueOf(aVarP == null || aVarP.a());
        }
        return this.g.booleanValue();
    }

    public boolean dl() {
        if (this.dl == null) {
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
            this.dl = Boolean.valueOf(aVarP == null || aVarP.z());
        }
        return this.dl.booleanValue();
    }
}
