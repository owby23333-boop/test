package com.bytedance.adsdk.ugeno.gc.dl;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends g implements com.bytedance.adsdk.ugeno.gc.z.a {
    private com.bytedance.adsdk.ugeno.gc.z.dl kb;

    public dl(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.dl.g
    public boolean z(Object... objArr) {
        com.bytedance.adsdk.ugeno.gc.z.z zVarWj = this.g.wj();
        if (zVarWj == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.gc.z.dl dlVarZ = zVarWj.z(this.m);
        this.kb = dlVarZ;
        if (dlVarZ != null) {
            dlVarZ.z(this);
            return false;
        }
        zVarWj.z(this.m, new com.bytedance.adsdk.ugeno.gc.z.g());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.gc.z.a
    public void z(String str) {
        this.z.z(this.g, this.m, this.dl.g());
    }
}
