package com.bytedance.sdk.gromore.z.z.e.dl;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.bytedance.sdk.gromore.z.z.gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gc f881a;
    private com.bytedance.sdk.openadsdk.tb.z.g.z.a dl;
    private com.bytedance.sdk.openadsdk.mediation.g.g.z g;
    private com.bytedance.msdk.dl.a.z z;

    public e(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar) {
        this.g = zVar;
        if (zVar != null) {
            this.z = new com.bytedance.msdk.dl.a.z(context);
            this.dl = aVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc
    public void z() {
        this.z.z(new com.bytedance.msdk.api.z.g(10, this.g.gk()), new com.bytedance.msdk.api.a.z.m.g() { // from class: com.bytedance.sdk.gromore.z.z.e.dl.e.1
            @Override // com.bytedance.msdk.api.a.z.m.g
            public void z(com.bytedance.msdk.api.z zVar) {
                if (zVar == null || e.this.dl == null) {
                    return;
                }
                e.this.dl.z(zVar.z, zVar.g);
            }

            @Override // com.bytedance.msdk.api.a.z.m.g
            public void z() {
                if (e.this.dl != null) {
                    if (e.this.f881a == null) {
                        e.this.f881a = new gc(e.this.z);
                    }
                    e.this.dl.z(e.this.f881a);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.g
            public void g() {
                if (e.this.dl != null) {
                    e.this.dl.z();
                    if (e.this.f881a == null) {
                        e.this.f881a = new gc(e.this.z);
                    }
                    e.this.dl.g(e.this.f881a);
                }
            }
        });
    }
}
