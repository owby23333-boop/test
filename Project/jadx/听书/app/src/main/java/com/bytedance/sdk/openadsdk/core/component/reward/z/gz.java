package com.bytedance.sdk.openadsdk.core.component.reward.z;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends dl {
    private static final gz g = new gz(zw.getContext());

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.z.dl
    protected int g() {
        return 7;
    }

    private gz(Context context) {
        super(context);
    }

    public static gz z() {
        return g;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, int i, a aVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.business.g.dl dlVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.g.dl();
        dlVar.z(str);
        dlVar.z(i + 1);
        z(gVar, aVar, dlVar);
    }
}
