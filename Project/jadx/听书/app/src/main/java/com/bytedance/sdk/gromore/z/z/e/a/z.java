package com.bytedance.sdk.gromore.z.z.e.a;

import android.text.TextUtils;
import com.bytedance.msdk.dl.a.fo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.openadsdk.mediation.g.g.g.g {
    private fo z;

    public z(fo foVar) {
        this.z = foVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.g.g.g.g
    public void z(String str, com.bytedance.sdk.openadsdk.tb.z.g.z.dl dlVar) {
        g(str, dlVar);
    }

    public void g(String str, final com.bytedance.sdk.openadsdk.tb.z.g.z.dl dlVar) {
        fo foVar;
        if (!TextUtils.isEmpty(str) && (foVar = this.z) != null && dlVar != null) {
            foVar.z(str, new com.bytedance.msdk.api.a.z.e.a() { // from class: com.bytedance.sdk.gromore.z.z.e.a.z.1
                @Override // com.bytedance.msdk.api.a.z.e.a
                public void z(List<com.bytedance.msdk.g.dl> list) {
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (com.bytedance.msdk.g.dl dlVar2 : list) {
                            if (dlVar2 != null) {
                                arrayList.add(new g(z.this.z, dlVar2, z.this.z.tb()));
                            }
                        }
                        dlVar.z(arrayList);
                        return;
                    }
                    dlVar.z(null);
                }

                @Override // com.bytedance.msdk.api.a.z.e.a
                public void z(com.bytedance.msdk.api.z zVar) {
                    if (zVar != null) {
                        dlVar.z(zVar.z, zVar.g);
                    }
                }
            });
        } else {
            com.bytedance.msdk.z.gc.dl.a("TMe", "adm 参数错误 或者 nativeAdManager is null");
        }
    }
}
