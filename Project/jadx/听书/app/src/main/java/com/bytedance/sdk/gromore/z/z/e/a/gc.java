package com.bytedance.sdk.gromore.z.z.e.a;

import android.content.Context;
import com.bytedance.msdk.dl.a.fo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements com.bytedance.sdk.gromore.z.z.gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f878a;
    private fo dl;
    private com.bytedance.sdk.openadsdk.tb.z.g.z.m g;
    private com.bytedance.sdk.openadsdk.mediation.g.g.z z;

    public gc(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.m mVar, boolean z) {
        this.z = zVar;
        this.f878a = z;
        if (zVar != null) {
            this.dl = new fo(context);
            this.g = mVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc
    public void z() {
        com.bytedance.msdk.api.z.g gVar = new com.bytedance.msdk.api.z.g(5, this.z.gk());
        gVar.z(this.f878a);
        this.dl.z(gVar, new com.bytedance.msdk.api.a.z.e.a() { // from class: com.bytedance.sdk.gromore.z.z.e.a.gc.1
            @Override // com.bytedance.msdk.api.a.z.e.a
            public void z(List<com.bytedance.msdk.g.dl> list) {
                com.bytedance.sdk.openadsdk.mediation.g.g.g gVarL;
                if (list != null) {
                    if (gc.this.g != null) {
                        com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.g gVarUy = (gc.this.z == null || (gVarL = gc.this.z.l()) == null) ? null : gVarL.uy();
                        LinkedList linkedList = new LinkedList();
                        Iterator<com.bytedance.msdk.g.dl> it = list.iterator();
                        while (it.hasNext()) {
                            linkedList.add(new a(gc.this.dl, it.next(), gc.this.dl.tb(), gVarUy));
                        }
                        gc.this.g.z(linkedList);
                        return;
                    }
                    return;
                }
                z(new com.bytedance.msdk.api.z(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
            }

            @Override // com.bytedance.msdk.api.a.z.e.a
            public void z(com.bytedance.msdk.api.z zVar) {
                if (zVar == null || gc.this.g == null) {
                    return;
                }
                gc.this.g.z(zVar.z, zVar.g);
            }
        });
    }
}
