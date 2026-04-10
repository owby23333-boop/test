package com.bytedance.sdk.gromore.z.z.e.dl;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements com.bytedance.sdk.gromore.z.z.gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f880a;
    private com.bytedance.sdk.openadsdk.tb.z.g.z.a dl;
    private com.bytedance.sdk.openadsdk.mediation.g.g.z g;
    private com.bytedance.msdk.dl.a.gz z;

    public dl(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar) {
        this.g = zVar;
        if (zVar != null) {
            this.z = new com.bytedance.msdk.dl.a.gz(context);
            this.dl = aVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc
    public void z() {
        this.z.z(new com.bytedance.msdk.api.z.g(8, this.g.gk()), new com.bytedance.msdk.api.a.z.a.g() { // from class: com.bytedance.sdk.gromore.z.z.e.dl.dl.1
            @Override // com.bytedance.msdk.api.a.z.a.g
            public void z(com.bytedance.msdk.api.z zVar) {
                if (zVar == null || dl.this.dl == null) {
                    return;
                }
                dl.this.dl.z(zVar.z, zVar.g);
            }

            @Override // com.bytedance.msdk.api.a.z.a.g
            public void z() {
                if (dl.this.dl != null) {
                    if (dl.this.f880a == null) {
                        dl.this.f880a = new z(dl.this.z);
                    }
                    dl.this.dl.z(dl.this.f880a);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.g
            public void g() {
                if (dl.this.dl != null) {
                    dl.this.dl.z();
                    if (dl.this.f880a == null) {
                        dl.this.f880a = new z(dl.this.z);
                    }
                    dl.this.dl.g(dl.this.f880a);
                }
            }
        });
    }
}
