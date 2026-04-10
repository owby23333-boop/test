package com.bytedance.msdk.dl.dl.z;

import android.text.TextUtils;
import com.bytedance.msdk.dl.dl.z.z;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i implements z {
    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        com.bytedance.msdk.api.z.g gVarJs = gVarZ.js();
        String strZ = com.bytedance.msdk.core.pf.z.z(gVarJs.ti());
        if (!TextUtils.isEmpty(strZ)) {
            gVarJs.a(2);
            com.bytedance.msdk.core.uy.g gVarZ2 = com.bytedance.msdk.core.pf.z.z(gVarZ.wp(), strZ);
            if (gVarZ2 != null) {
                gVarZ.z(gVarZ2);
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVarZ2) + "测试工具加载广告........rit_id:" + gVarJs.zw() + " ,slot_id:" + strZ);
            } else {
                com.bytedance.msdk.gc.m.z(gVarZ.js(), (String) null, !gVarZ.zw(), gVarZ.un().z, 81012, (Map<String, Object>) null);
                gVarZ.z(new com.bytedance.msdk.api.g.z(81012, com.bytedance.msdk.api.z.z(81012)));
                return;
            }
        }
        interfaceC0102z.z(interfaceC0102z.z());
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        interfaceC0102z.z((String) null);
    }
}
