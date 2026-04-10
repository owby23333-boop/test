package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.e;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g;

/* JADX INFO: loaded from: classes2.dex */
public class GdtDrawLoader extends MediationAdLoaderBaseFunction {
    @Override // com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            g.a(context, mediationAdSlotValueSet, this.mGmAdLoader, new e(), new g.a() { // from class: com.bytedance.msdk.adapter.gdt.GdtDrawLoader.1
                @Override // com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g.a
                public void useOriginLoader() {
                    new com.jbB1g.jbB1g.jbB1g.jbB1g.g(GdtDrawLoader.this).a(context, mediationAdSlotValueSet);
                }
            });
        }
    }
}
