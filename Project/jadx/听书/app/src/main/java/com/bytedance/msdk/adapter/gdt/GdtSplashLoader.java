package com.bytedance.msdk.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.jbB1g.jbB1g.jbB1g.jbB1g.m;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.s;

/* JADX INFO: loaded from: classes2.dex */
public class GdtSplashLoader extends MediationAdLoaderBaseFunction {
    @Override // com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        int i;
        String str;
        if (context instanceof Activity) {
            MediationApiLog.i("TTMediationSDK", "GdtSplashLoader realLoader adnId:" + getAdnId());
            if (context != null && mediationAdSlotValueSet != null) {
                final int loadTimeOut = getLoadTimeOut();
                final boolean zIsSplashPreLoad = isSplashPreLoad();
                g.a(context, mediationAdSlotValueSet, this.mGmAdLoader, new s(), new g.a() { // from class: com.bytedance.msdk.adapter.gdt.GdtSplashLoader.1
                    @Override // com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g.a
                    public void useOriginLoader() {
                        new m(mediationAdSlotValueSet, GdtSplashLoader.this.getGMBridge(), context, GdtSplashLoader.this).a(context, loadTimeOut, zIsSplashPreLoad);
                    }
                });
                return;
            }
            i = MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL;
            str = "context is null or adSlotValueSet is null";
        } else {
            i = MediationConstant.ErrorCode.ADN_AD_CONTEXT;
            str = "context type error, context need activity";
        }
        notifyAdFailed(i, str);
    }
}
