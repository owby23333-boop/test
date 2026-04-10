package com.bytedance.sdk.gromore.z.z.e.a;

import android.content.Context;
import com.bytedance.msdk.dl.a.fo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m implements com.bytedance.sdk.gromore.z.z.gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f879a;
    private com.bytedance.sdk.openadsdk.tb.z.g.z.dl dl;
    private com.bytedance.sdk.openadsdk.mediation.g.g.z g;
    private fo z;

    public m(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.dl dlVar, boolean z) {
        this.g = zVar;
        this.f879a = z;
        if (zVar != null) {
            this.z = new fo(context);
            this.dl = dlVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc
    public void z() {
        com.bytedance.msdk.api.z.g gVar = new com.bytedance.msdk.api.z.g(5, this.g.gk());
        gVar.z(this.f879a);
        this.z.z(gVar, new com.bytedance.msdk.api.a.z.e.a() { // from class: com.bytedance.sdk.gromore.z.z.e.a.m.1
            @Override // com.bytedance.msdk.api.a.z.e.a
            public void z(List<com.bytedance.msdk.g.dl> list) {
                if (list != null) {
                    if (m.this.dl != null) {
                        LinkedList linkedList = new LinkedList();
                        Iterator<com.bytedance.msdk.g.dl> it = list.iterator();
                        while (it.hasNext()) {
                            linkedList.add(new g(m.this.z, it.next(), m.this.z.tb()));
                        }
                        m.this.dl.z(linkedList);
                        return;
                    }
                    return;
                }
                z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
            }

            @Override // com.bytedance.msdk.api.a.z.e.a
            public void z(com.bytedance.msdk.api.z zVar) {
                if (zVar == null || m.this.dl == null) {
                    return;
                }
                m.this.dl.z(zVar.z, zVar.g);
            }
        });
    }
}
