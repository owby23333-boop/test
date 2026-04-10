package com.bytedance.sdk.component.m.a;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "cache_policy";
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        com.bytedance.sdk.component.m.g gVarI = dlVar.i();
        if (gVarI != null) {
            if (gVarI.isMemoryCache()) {
                dlVar.z(new uy());
                return;
            } else if (gVarI.isDiskCache()) {
                dlVar.z(new m());
                return;
            }
        }
        dlVar.z(new kb());
    }
}
