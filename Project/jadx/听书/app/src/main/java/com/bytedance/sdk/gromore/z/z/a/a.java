package com.bytedance.sdk.gromore.z.z.a;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.ls.dl.g.gc {
    private com.bytedance.msdk.g.dl z;

    public a(com.bytedance.msdk.g.dl dlVar) {
        this.z = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gc
    public void z() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            if (dlVar.a() == 3) {
                this.z.g();
            } else if (this.z.a() == 2) {
                this.z.z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gc
    public void g() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.dl();
        }
    }
}
