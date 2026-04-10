package com.bytedance.sdk.openadsdk.core.component.dl;

import com.bytedance.sdk.openadsdk.ls.dl.g.uy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.openadsdk.core.gc.z<com.bytedance.sdk.openadsdk.tb.z.g.z.dl, List<uy>> {
    private static final z g = new z();

    @Override // com.bytedance.sdk.openadsdk.core.gc.z
    protected int z() {
        return 5;
    }

    private z() {
    }

    public static z g() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.gc.z
    public void z(com.bytedance.sdk.openadsdk.tb.z.g.z.dl dlVar, List<uy> list) {
        if (dlVar != null) {
            dlVar.z(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.gc.z
    public void z(com.bytedance.sdk.openadsdk.tb.z.g.z.dl dlVar, int i, String str) {
        if (dlVar != null) {
            dlVar.z(i, str);
        }
    }
}
