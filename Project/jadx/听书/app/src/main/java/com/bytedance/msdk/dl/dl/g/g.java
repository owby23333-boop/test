package com.bytedance.msdk.dl.dl.g;

import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.dl.dl.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z {
    @Override // com.bytedance.msdk.dl.dl.g.z
    public void z(z.InterfaceC0089z interfaceC0089z) {
        com.bytedance.msdk.dl.m.g.g gVarZ = interfaceC0089z.z();
        com.bytedance.msdk.dl.m.z.g gVarG = interfaceC0089z.g();
        uy uyVarGz = gVarZ.gz();
        if (uyVarGz == null) {
            com.bytedance.msdk.api.z zVar = new com.bytedance.msdk.api.z(840040, com.bytedance.msdk.api.z.z(840040));
            com.bytedance.msdk.gc.m.z(uyVarGz, gVarG.js(), "", gVarZ.gc(), 2, gVarZ.dl(), gVarZ.e(), gVarZ.m(), zVar, -1L, gVarG.un().gc, false);
            com.bytedance.msdk.gc.m.z(zVar, gVarG.js(), uyVarGz, gVarZ.dl(), gVarZ.e(), gVarZ.m(), "", 0L, (String) null, (String) null, (String) null, 0L);
            gVarZ.z(zVar, uyVarGz);
            return;
        }
        interfaceC0089z.z(this);
    }
}
