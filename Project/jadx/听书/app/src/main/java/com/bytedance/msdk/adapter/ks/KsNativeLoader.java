package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.k;

/* JADX INFO: loaded from: classes3.dex */
public class KsNativeLoader extends KsBaseLoader {
    @Override // com.bytedance.msdk.adapter.ks.base.MediationAdLoaderBaseFunction
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            new k().a(context, mediationAdSlotValueSet, this);
        }
    }
}
