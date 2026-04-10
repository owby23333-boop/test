package com.bytedance.sdk.openadsdk.core.q;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class wp implements com.bytedance.sdk.component.gz.z.z.m {
    com.bytedance.sdk.component.fo.g.gc z;

    wp(com.bytedance.sdk.component.fo.g.gc gcVar) {
        this.z = gcVar;
    }

    @Override // com.bytedance.sdk.component.gz.z.z.m
    public void z(String str) {
        com.bytedance.sdk.component.fo.g.gc gcVar = this.z;
        if (gcVar != null) {
            gcVar.z(str);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.z.m
    public void z(String str, byte[] bArr) {
        com.bytedance.sdk.component.fo.g.gc gcVar = this.z;
        if (gcVar != null) {
            gcVar.z(str, bArr);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.z.m
    public void z(String str, String str2) {
        com.bytedance.sdk.component.fo.g.gc gcVar = this.z;
        if (gcVar != null) {
            gcVar.g(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.z.m
    public void g(String str) {
        com.bytedance.sdk.component.fo.g.gc gcVar = this.z;
        if (gcVar != null) {
            gcVar.dl(str);
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.z.m
    public com.bytedance.sdk.component.gz.z.z.gc z() {
        if (this.z == null) {
            return null;
        }
        return new kb(this.z.z());
    }

    @Override // com.bytedance.sdk.component.gz.z.z.m
    public void z(final com.bytedance.sdk.component.gz.z.z.dl dlVar) {
        com.bytedance.sdk.component.fo.g.gc gcVar = this.z;
        if (gcVar != null) {
            gcVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.wp.1
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    if (dlVar != null) {
                        dlVar.z(new m(aVar), new e(gVar));
                    }
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    if (dlVar != null) {
                        dlVar.z(new m(aVar), iOException);
                    }
                }
            });
        }
    }
}
