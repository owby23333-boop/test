package com.bytedance.sdk.component.m.dl.z.g;

import com.bytedance.sdk.component.m.l;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements l {
    private com.bytedance.sdk.component.m.dl.z.dl<String, byte[]> dl;
    private int g;
    private int z;

    public dl(int i, int i2) {
        this.g = i;
        this.z = i2;
        this.dl = new com.bytedance.sdk.component.m.dl.z.dl<String, byte[]>(i) { // from class: com.bytedance.sdk.component.m.dl.z.g.dl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.m.dl.z.dl
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int g(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.m.z
    public boolean z(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.dl.z(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.m.z
    public byte[] z(String str) {
        return this.dl.z(str);
    }

    @Override // com.bytedance.sdk.component.m.z
    public boolean g(String str) {
        return this.dl.z(str) != null;
    }

    @Override // com.bytedance.sdk.component.m.z
    public void z(double d) {
        this.dl.z((int) (((double) this.g) * d));
    }
}
