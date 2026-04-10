package com.bytedance.sdk.openadsdk.core.q;

/* JADX INFO: loaded from: classes2.dex */
class uy implements com.bytedance.sdk.component.gz.z.z.g {
    com.bytedance.sdk.component.fo.g.dl z;

    uy(com.bytedance.sdk.component.fo.g.dl dlVar) {
        this.z = dlVar;
    }

    @Override // com.bytedance.sdk.component.gz.z.z.g
    public void z(String str) {
        com.bytedance.sdk.component.fo.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(str);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.z.g
    public void z(String str, String str2) {
        com.bytedance.sdk.component.fo.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.g(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.z.g
    public com.bytedance.sdk.component.gz.z.z.gc z() {
        if (this.z == null) {
            return null;
        }
        return new kb(this.z.z());
    }
}
