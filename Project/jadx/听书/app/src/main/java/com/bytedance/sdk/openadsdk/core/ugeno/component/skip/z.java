package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import com.bytedance.adsdk.ugeno.g.dl;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<CycleSkipView> {
    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public CycleSkipView z() {
        return new CycleSkipView(this.g);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
    }

    public void g(int i, int i2) {
        if (this.gc != 0) {
            ((CycleSkipView) this.gc).z(i, i2);
        }
    }
}
