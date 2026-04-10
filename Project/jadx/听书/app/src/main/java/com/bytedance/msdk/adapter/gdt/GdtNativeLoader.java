package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.jbB1g.jbB1g.jbB1g.jbB1g.k;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g;
import com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.o;

/* JADX INFO: loaded from: classes2.dex */
public class GdtNativeLoader extends MediationAdLoaderBaseFunction {
    @Override // com.bytedance.msdk.adapter.gdt.base.MediationAdLoaderBaseFunction
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            g.a(context, mediationAdSlotValueSet, this.mGmAdLoader, new o(), new g.a() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.1
                @Override // com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.g.a
                public void useOriginLoader() {
                    new k(GdtNativeLoader.this).a(context, mediationAdSlotValueSet);
                }
            });
        }
    }
}
