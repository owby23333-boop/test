package com.bytedance.sdk.gromore.z.z.e.z;

import android.content.Context;
import android.view.View;
import com.bytedance.msdk.api.a.z.z.a;
import com.bytedance.msdk.dl.a.kb;
import com.bytedance.sdk.gromore.z.z.gc;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f888a;
    private kb dl;
    private final com.bytedance.sdk.gromore.z.z.z.z g;
    private final com.bytedance.sdk.openadsdk.mediation.g.g.z z;

    public dl(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.gromore.z.z.z.z zVar2, boolean z) {
        this.z = zVar;
        this.g = zVar2;
        this.f888a = z;
        if (zVar != null) {
            this.dl = new kb(context);
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc
    public void z() {
        final com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.g gVarUy;
        com.bytedance.msdk.api.z.g gVar = new com.bytedance.msdk.api.z.g(1, this.z.gk());
        gVar.z(this.f888a);
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVarL = this.z.l();
        if (gVarL != null && (gVarUy = gVarL.uy()) != null) {
            this.dl.z(new a() { // from class: com.bytedance.sdk.gromore.z.z.e.z.dl.1
                @Override // com.bytedance.msdk.api.a.z.z.a
                public View z(com.bytedance.msdk.api.a.z.z.dl dlVar) {
                    if (dlVar != null) {
                        return gVarUy.z(new com.bytedance.sdk.gromore.z.z.z.a(dlVar));
                    }
                    return null;
                }
            });
        }
        this.dl.z(gVar, new com.bytedance.msdk.api.a.z.z.g() { // from class: com.bytedance.sdk.gromore.z.z.e.z.dl.2
            @Override // com.bytedance.msdk.api.a.z.z.g
            public void z(com.bytedance.msdk.api.z zVar) {
                if (dl.this.g != null) {
                    dl.this.g.z(zVar.z, zVar.g);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.z.g
            public void z() {
                if (dl.this.g != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new z(dl.this.dl));
                    dl.this.g.z(arrayList);
                }
            }
        });
    }
}
