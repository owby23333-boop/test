package com.bytedance.sdk.component.ga.d.e.bf;

import com.bytedance.sdk.component.ga.f;

/* JADX INFO: loaded from: classes.dex */
public class d implements f {
    private int bf;
    private int d;
    private int e;
    private com.bytedance.sdk.component.ga.d.e.d<String, byte[]> tg;

    public d(int i, int i2) {
        this.d = i;
        this.e = i2;
        this.tg = new com.bytedance.sdk.component.ga.d.e.d<String, byte[]>(i) { // from class: com.bytedance.sdk.component.ga.d.e.bf.d.1
            @Override // com.bytedance.sdk.component.ga.d.e.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int bf(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.ga.e
    public boolean e(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.tg.e(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.ga.e
    public byte[] e(String str) {
        return this.tg.e(str);
    }
}
