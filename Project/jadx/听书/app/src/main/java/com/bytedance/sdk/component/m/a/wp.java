package com.bytedance.sdk.component.m.a;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends z {
    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "raw_cache";
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        byte[] bArrZ = dlVar.wp().g(dlVar.i()).z(dlVar.getRawCacheKey());
        if (bArrZ == null) {
            dlVar.z(new m());
        } else {
            dlVar.z(new g(bArrZ, null));
        }
    }
}
