package com.bytedance.sdk.openadsdk.core.kb.dl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.g.a;

/* JADX INFO: loaded from: classes3.dex */
public class z extends g implements com.bytedance.sdk.openadsdk.core.kb.g.a {
    private a.z sy;

    public z(Context context, na naVar, String str, boolean z) {
        super(context, naVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.a
    public void z(a.z zVar) {
        this.sy = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc, com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void g() {
        super.g();
        this.sy = null;
    }
}
