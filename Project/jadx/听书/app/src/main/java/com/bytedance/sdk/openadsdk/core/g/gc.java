package com.bytedance.sdk.openadsdk.core.g;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class gc extends z {
    protected abstract void g(View view, uy uyVar);

    public gc(Context context, na naVar, String str, int i) {
        super(context, naVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
    public void z(View view, uy uyVar) {
        if (na.gc(this.z)) {
            return;
        }
        super.z(view, uyVar);
        com.bytedance.sdk.openadsdk.core.g.z.g gVar = (com.bytedance.sdk.openadsdk.core.g.z.g) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.g.class);
        if (gVar == null || !gVar.g(view)) {
            return;
        }
        g(view, uyVar);
    }
}
