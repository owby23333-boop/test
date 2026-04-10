package com.bytedance.msdk.dl.dl.g.z.g;

import android.content.Context;
import com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.lq;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends com.bytedance.msdk.dl.dl.g.z.g {
    public g(com.bytedance.msdk.dl.z.g gVar) {
        super(gVar);
    }

    public lq z(Context context) {
        lq csjLoader = DispatchAdSdkInitializerHolder.getCsjLoader(context);
        if (csjLoader == null) {
            z(new com.bytedance.msdk.api.z("ClassCastException：load ad fail loader is null"));
        }
        return csjLoader;
    }

    @Override // com.bytedance.msdk.dl.z.z
    public String z(String str) {
        try {
            return com.bytedance.sdk.gromore.init.z.dl();
        } catch (Exception unused) {
            return "0.0";
        }
    }
}
