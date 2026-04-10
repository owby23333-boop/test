package com.bytedance.sdk.openadsdk.core.gc.dl;

import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.hh.e;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z {
    private int z;

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(na naVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar, Object obj, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public boolean z(String str) {
        return true;
    }

    public g(int i) {
        this.z = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final na naVar) {
        if (naVar.bp() <= 0) {
            naVar.gc((System.currentTimeMillis() + 10500000) / 1000);
        }
        e.a(new fo("PreloadStrategyLoadDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.gc.a.gc.z(g.this.z).z(gVar, naVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void g(String str) {
        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).g(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public na z(String str, long j) {
        na naVarZ = com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).z(str, false, j);
        if (naVarZ != null) {
            com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).z(str, naVarZ.jt());
        }
        return naVarZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public List<na> z(String str, long j, int i) {
        List<na> listZ = com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).z(str, false, j, i);
        Iterator<na> it = listZ.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).z(str, it.next().jt());
        }
        listZ.size();
        return listZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(String str, na naVar) {
        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).z(str, naVar.jt());
    }
}
