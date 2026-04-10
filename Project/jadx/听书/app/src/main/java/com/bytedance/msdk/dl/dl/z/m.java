package com.bytedance.msdk.dl.dl.z;

import android.util.Pair;
import com.bytedance.msdk.dl.dl.z.z;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m implements z {
    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        String strZw = gVarZ.js().zw();
        com.bytedance.msdk.core.uy.g gVarWp = gVarZ.wp();
        if (gVarWp != null && gVarWp.kb()) {
            if (!com.bytedance.msdk.core.gz.i.z().gz(String.valueOf(strZw))) {
                com.bytedance.msdk.z.gc.dl.g("TMe", "广告位 请求触发次数拦截............");
                Pair<String, String> pairM = com.bytedance.msdk.core.gz.i.z().m(strZw);
                com.bytedance.msdk.api.g.g gVar = new com.bytedance.msdk.api.g.g(840041, com.bytedance.msdk.api.z.z(840041), pairM != null ? (String) pairM.second : "", pairM != null ? (String) pairM.first : "");
                z(gVarZ, gVar.z);
                gVarZ.z(gVar);
                return;
            }
            if (!com.bytedance.msdk.core.gz.i.z().dl(String.valueOf(strZw)) && !gVarZ.zw()) {
                com.bytedance.msdk.z.gc.dl.g("TMe", "广告位 请求触发时间间隔拦截............");
                com.bytedance.msdk.core.gz.fo foVarGc = com.bytedance.msdk.core.gz.i.z().gc(String.valueOf(strZw));
                com.bytedance.msdk.api.g.dl dlVar = new com.bytedance.msdk.api.g.dl(840042, com.bytedance.msdk.api.z.z(840042), new StringBuilder().append(com.bytedance.msdk.core.gz.i.z().z(strZw)).toString(), foVarGc != null ? foVarGc.uy() : "");
                z(gVarZ, dlVar.z);
                gVarZ.z(dlVar);
                return;
            }
        }
        interfaceC0102z.z(interfaceC0102z.z());
    }

    private void z(com.bytedance.msdk.dl.m.z.g gVar, int i) {
        com.bytedance.msdk.gc.m.z(gVar.js(), (String) null, !gVar.zw(), gVar.un().z, i, (Map<String, Object>) null);
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        interfaceC0102z.z((String) null);
    }
}
