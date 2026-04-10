package com.bytedance.msdk.dl.dl.z;

import com.bytedance.msdk.dl.dl.z.z;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements z {
    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        com.bytedance.msdk.api.z.g gVarJs = gVarZ.js();
        com.bytedance.msdk.core.uy.g gVarWp = gVarZ.wp();
        com.bytedance.msdk.core.uy.g gVarZ2 = com.bytedance.msdk.core.dl.dl.z(gVarJs, gVarWp);
        if (gVarZ2 != null) {
            if (gVarJs.dl() == 2 || gVarJs.dl() == 4 || gVarJs.dl() == 5) {
                com.bytedance.msdk.core.gc.g.a.z().z(gVarJs.zw(), gVarJs);
            }
            gVarWp = gVarZ2;
        }
        if (gVarWp.t() == null || gVarWp.t().size() == 0) {
            com.bytedance.msdk.gc.m.z(gVarJs, gVarZ.wp() != null ? gVarZ.wp().vm() : null, !gVarZ.zw(), gVarZ.un().z, 810085, (Map<String, Object>) null);
            gVarZ.z(new com.bytedance.msdk.api.z(810085, com.bytedance.msdk.api.z.z(810085)));
        } else {
            gVarZ.z(gVarWp);
            interfaceC0102z.z(interfaceC0102z.z());
        }
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        interfaceC0102z.z((String) null);
    }
}
