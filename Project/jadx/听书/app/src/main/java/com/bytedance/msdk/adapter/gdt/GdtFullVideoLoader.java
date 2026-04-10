package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.jbB1g.jbB1g.jbB1g.jbB1g.h;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.j;

/* JADX INFO: loaded from: classes2.dex */
public class GdtFullVideoLoader extends MediationAdLoaderBaseFunction {
    @Override // com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        int i;
        String str;
        if (context instanceof Activity) {
            MediationApiLog.i("TTMediationSDK", "GdtFullVideoLoader realLoader adnId:" + getAdnId());
            if (mediationAdSlotValueSet != null) {
                g.a(context, mediationAdSlotValueSet, this.mGmAdLoader, new j(), new g.a() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoLoader.1
                    @Override // com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g.a
                    public void useOriginLoader() {
                        new h(mediationAdSlotValueSet, GdtFullVideoLoader.this.getGMBridge(), GdtFullVideoLoader.this).a(context);
                    }
                });
                return;
            } else {
                i = MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL;
                str = "context is null or adSlotValueSet is null";
            }
        } else {
            i = MediationConstant.ErrorCode.ADN_AD_CONTEXT;
            str = "context type error, context need activity";
        }
        notifyAdFailed(i, str);
    }
}
