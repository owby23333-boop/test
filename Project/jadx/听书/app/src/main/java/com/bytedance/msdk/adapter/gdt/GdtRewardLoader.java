package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.jbB1g.jbB1g.jbB1g.jbB1g.l;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.q;

/* JADX INFO: loaded from: classes2.dex */
public class GdtRewardLoader extends MediationAdLoaderBaseFunction {
    @Override // com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context == null || mediationAdSlotValueSet == null) {
            notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "context is null or adSlotValueSet is null");
        } else {
            g.a(context, mediationAdSlotValueSet, this.mGmAdLoader, new q(), new g.a() { // from class: com.bytedance.msdk.adapter.gdt.GdtRewardLoader.1
                @Override // com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g.a
                public void useOriginLoader() {
                    new l(mediationAdSlotValueSet, GdtRewardLoader.this.getGMBridge(), GdtRewardLoader.this).a(context);
                }
            });
        }
    }
}
