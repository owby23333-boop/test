package com.bytedance.adsdk.ugeno.gc.g;

import com.bytedance.adsdk.ugeno.gc.m;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private List<com.bytedance.adsdk.ugeno.gc.z.a> fo;

    public g(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
        super(dlVar, str, zVar);
        this.fo = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.gc.g.z
    public void z() {
        com.bytedance.adsdk.ugeno.gc.z.dl dlVarZ;
        if (this.m == null || this.m.size() <= 0) {
            return;
        }
        String str = this.m.get("name");
        com.bytedance.adsdk.ugeno.gc.z.z zVarWj = this.dl.wj();
        if (zVarWj == null || (dlVarZ = zVarWj.z(str)) == null) {
            return;
        }
        dlVarZ.z(str);
    }
}
