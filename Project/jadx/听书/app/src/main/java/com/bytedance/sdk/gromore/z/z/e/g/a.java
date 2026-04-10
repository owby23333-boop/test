package com.bytedance.sdk.gromore.z.z.e.g;

import android.text.TextUtils;
import com.bytedance.msdk.dl.a.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.mediation.g.g.g.z {
    private e z;

    public a(e eVar) {
        this.z = eVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.g.z
    public void z(String str, com.bytedance.sdk.openadsdk.tb.z.g.z.g gVar) {
        g(str, gVar);
    }

    public void g(String str, final com.bytedance.sdk.openadsdk.tb.z.g.z.g gVar) {
        e eVar;
        if (!TextUtils.isEmpty(str) && (eVar = this.z) != null && gVar != null) {
            eVar.z(str, new com.bytedance.msdk.api.a.z.dl.g() { // from class: com.bytedance.sdk.gromore.z.z.e.g.a.1
                @Override // com.bytedance.msdk.api.a.z.dl.g
                public void z(List<com.bytedance.msdk.g.dl> list) {
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (com.bytedance.msdk.g.dl dlVar : list) {
                            if (dlVar != null) {
                                arrayList.add(new z(a.this.z, dlVar, a.this.z.tb()));
                            }
                        }
                        gVar.z(arrayList);
                        return;
                    }
                    gVar.z(null);
                }

                @Override // com.bytedance.msdk.api.a.z.dl.g
                public void z(com.bytedance.msdk.api.z zVar) {
                    if (zVar != null) {
                        gVar.z(zVar.z, zVar.g);
                    }
                }
            });
        } else {
            com.bytedance.msdk.z.gc.dl.a("TMe", "adm 参数错误 或者 drawTokenInfo is null");
        }
    }
}
