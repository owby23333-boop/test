package com.bytedance.sdk.openadsdk.core.wp;

import com.bytedance.sdk.component.adexpress.z.dl.a;
import com.bytedance.sdk.component.adexpress.z.g.e;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.ugeno.dl;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static void z(na naVar, final dl dlVar) {
        final a aVarFo;
        if (naVar == null || vm.gz(naVar) || (aVarFo = vm.fo(naVar)) == null) {
            return;
        }
        e.z(new fo("saveTemplate") { // from class: com.bytedance.sdk.openadsdk.core.wp.z.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.adexpress.z.g.e.z().z(aVarFo, new e.z() { // from class: com.bytedance.sdk.openadsdk.core.wp.z.1.1
                    @Override // com.bytedance.sdk.component.adexpress.z.g.e.z
                    public void z() {
                        if (dlVar != null) {
                            dlVar.z(null);
                        }
                    }

                    @Override // com.bytedance.sdk.component.adexpress.z.g.e.z
                    public void g() {
                        if (dlVar != null) {
                            dlVar.z();
                        }
                    }
                });
            }
        }, 10);
    }
}
