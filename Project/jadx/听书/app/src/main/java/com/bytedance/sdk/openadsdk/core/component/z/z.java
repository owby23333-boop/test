package com.bytedance.sdk.openadsdk.core.component.z;

import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.tb.z.g.z.gc;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.openadsdk.core.gc.z<gc, List<i>> {
    private static final z g = new z();

    @Override // com.bytedance.sdk.openadsdk.core.gc.z
    protected int z() {
        return 1;
    }

    private z() {
    }

    public static z g() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.gc.z
    public void z(gc gcVar, List<i> list) {
        if (gcVar != null) {
            gcVar.z(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.gc.z
    public void z(gc gcVar, int i, String str) {
        if (gcVar != null) {
            gcVar.z(i, str);
        }
    }
}
