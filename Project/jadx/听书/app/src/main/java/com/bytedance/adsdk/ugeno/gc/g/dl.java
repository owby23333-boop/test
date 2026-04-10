package com.bytedance.adsdk.ugeno.gc.g;

import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.gc.m;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    private fv fo;

    public dl(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
        super(dlVar, str, zVar);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.g.z
    public void z() {
        fv fvVarIq = this.dl.iq();
        this.fo = fvVarIq;
        if (fvVarIq != null) {
            fvVarIq.z(this.dl, this.e, this.g);
        }
    }
}
