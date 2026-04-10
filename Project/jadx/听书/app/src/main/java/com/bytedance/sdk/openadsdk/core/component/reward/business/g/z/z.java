package com.bytedance.sdk.openadsdk.core.component.reward.business.g.z;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.uy;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends com.bytedance.sdk.openadsdk.core.component.reward.dl.g {
    protected String z;

    public void z(String str) {
        this.z = str;
    }

    public z(Activity activity, na naVar) {
        super(activity, naVar);
    }

    public z(Activity activity, na naVar, bm bmVar) {
        super(activity, naVar, bmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z z(uy uyVar) {
        a aVar = new a(this.gz, this.e);
        aVar.a(this.kb);
        aVar.dl(this.wp);
        aVar.g(this.pf);
        aVar.z(this.z);
        return aVar.z(uyVar);
    }
}
