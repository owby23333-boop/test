package com.bytedance.msdk.dl.dl.g;

import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.dl.dl.g.z;
import com.bytedance.msdk.dl.gz.gc;

/* JADX INFO: loaded from: classes2.dex */
public class e implements z {
    @Override // com.bytedance.msdk.dl.dl.g.z
    public void z(z.InterfaceC0089z interfaceC0089z) {
        gc.z zVarZ;
        com.bytedance.msdk.dl.m.z.g gVarG = interfaceC0089z.g();
        com.bytedance.msdk.dl.m.g.g gVarZ = interfaceC0089z.z();
        if (gVarG != null && gVarZ != null) {
            com.bytedance.msdk.api.z.g gVarJs = gVarG.js();
            uy uyVarGz = gVarZ.gz();
            if (gVarJs != null && uyVarGz != null && (zVarZ = com.bytedance.msdk.dl.gz.gc.z(gVarJs, uyVarGz)) != null) {
                com.bytedance.msdk.api.z zVar = new com.bytedance.msdk.api.z(81018, "命中跳过:" + zVarZ.z);
                com.bytedance.msdk.gc.m.z(uyVarGz, gVarJs, com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), gVarZ.gc(), 2, gVarZ.dl(), gVarZ.e(), gVarZ.m(), zVar, -1L, false, false);
                com.bytedance.msdk.gc.m.z(zVar, gVarJs, uyVarGz, gVarZ.dl(), gVarZ.e(), gVarZ.m(), com.bytedance.msdk.core.gc.z.z.z().z(uyVarGz.fv()), 0L, (String) null, (String) null, (String) null, 0L);
                gVarZ.z(zVar, uyVarGz);
                return;
            }
        }
        interfaceC0089z.z(this);
    }
}
