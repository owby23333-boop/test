package com.bytedance.msdk.dl.dl.z;

import com.bytedance.msdk.dl.dl.z.z;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements z {
    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        gVarZ.i().z(0);
        int iDl = gVarZ.js().dl();
        List<com.bytedance.msdk.core.uy.uy> list = gVarZ.wp().sy().get(0);
        JSONObject jSONObject = new JSONObject();
        String strZ = com.bytedance.msdk.core.i.z.z().z(gVarZ.q(), gVarZ.getContext(), gVarZ.js(), list, gVarZ.wp(), iDl, !gVarZ.zw(), jSONObject);
        com.bytedance.msdk.gc.m.z(gVarZ.js(), jSONObject);
        gVarZ.z(strZ);
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        interfaceC0102z.z((String) null);
    }
}
