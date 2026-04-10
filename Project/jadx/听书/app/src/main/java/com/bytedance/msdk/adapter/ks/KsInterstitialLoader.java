package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import com.bytedance.msdk.adapter.ks.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.j;

/* JADX INFO: loaded from: classes2.dex */
public class KsInterstitialLoader extends MediationAdLoaderBaseFunction {
    @Override // com.bytedance.msdk.adapter.ks.base.MediationAdLoaderBaseFunction
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            new j(this).a(context, mediationAdSlotValueSet);
        }
    }
}
