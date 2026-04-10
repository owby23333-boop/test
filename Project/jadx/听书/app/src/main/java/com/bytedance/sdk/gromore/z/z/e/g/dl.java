package com.bytedance.sdk.gromore.z.z.e.g;

import android.content.Context;
import com.bytedance.msdk.dl.a.e;
import com.bytedance.sdk.gromore.z.z.gc;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements gc {
    private com.bytedance.sdk.openadsdk.tb.z.g.z.g dl;
    private com.bytedance.sdk.openadsdk.mediation.g.g.z g;
    private e z;

    public dl(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.g gVar) {
        this.g = zVar;
        if (zVar != null) {
            this.z = new e(context);
            this.dl = gVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc
    public void z() {
        this.z.z(new com.bytedance.msdk.api.z.g(9, this.g.gk()), new com.bytedance.msdk.api.a.z.dl.g() { // from class: com.bytedance.sdk.gromore.z.z.e.g.dl.1
            @Override // com.bytedance.msdk.api.a.z.dl.g
            public void z(List<com.bytedance.msdk.g.dl> list) {
                if (list != null) {
                    if (dl.this.dl != null) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<com.bytedance.msdk.g.dl> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new z(dl.this.z, it.next(), dl.this.z.tb()));
                        }
                        dl.this.dl.z(arrayList);
                        return;
                    }
                    return;
                }
                z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
            }

            @Override // com.bytedance.msdk.api.a.z.dl.g
            public void z(com.bytedance.msdk.api.z zVar) {
                if (zVar == null || dl.this.dl == null) {
                    return;
                }
                dl.this.dl.z(zVar.z, zVar.g);
            }
        });
    }
}
