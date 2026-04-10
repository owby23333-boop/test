package com.bytedance.sdk.component.m.a;

/* JADX INFO: loaded from: classes2.dex */
public class g implements fo {
    private com.bytedance.sdk.component.m.e g;
    private byte[] z;

    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "image_type";
    }

    public g(byte[] bArr, com.bytedance.sdk.component.m.e eVar) {
        this.z = bArr;
        this.g = eVar;
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        fo gzVar;
        int iGc = dlVar.gc();
        dlVar.z(this.z.length);
        if (iGc != 2) {
            if (iGc == 3) {
                byte[] bArr = this.z;
                gzVar = new i(bArr, bArr, this.g, com.bytedance.sdk.component.m.dl.dl.z.g(bArr));
            } else {
                boolean zG = com.bytedance.sdk.component.m.dl.dl.z.g(this.z);
                if (zG) {
                    byte[] bArr2 = this.z;
                    gzVar = new i(bArr2, bArr2, this.g, zG);
                } else if (com.bytedance.sdk.component.m.dl.dl.z.z(this.z)) {
                    gzVar = new gc(this.z, this.g);
                } else {
                    byte[] bArr3 = this.z;
                    gzVar = new i(bArr3, bArr3, this.g, zG);
                }
            }
        } else if (com.bytedance.sdk.component.m.dl.dl.z.z(this.z)) {
            gzVar = new gc(this.z, this.g);
        } else if (this.g == null) {
            gzVar = new kb();
        } else {
            gzVar = new gz(1001, "not image format", null);
        }
        dlVar.z(gzVar);
    }
}
