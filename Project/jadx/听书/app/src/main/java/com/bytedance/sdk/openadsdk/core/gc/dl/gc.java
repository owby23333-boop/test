package com.bytedance.sdk.openadsdk.core.gc.dl;

import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.hh.e;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements z {
    private final int z;

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list) {
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

    public gc(int i) {
        this.z = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final na naVar) {
        if (naVar.bp() <= 0) {
            naVar.gc((System.currentTimeMillis() + 10500000) / 1000);
        }
        e.a(new fo("PreloadStrategyShowDelete-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.gc.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.gc.a.gc.z(gc.this.z).z(gVar, naVar, false);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void g(String str) {
        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).g(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public na z(String str, long j) {
        return com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).z(str, false, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public List<na> z(String str, long j, int i) {
        List<na> listZ = com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).z(str, false, j, i);
        listZ.size();
        return listZ;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(String str, na naVar) {
        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(this.z).z(str, naVar.jt());
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.dl.z
    public void z(final na naVar) {
        final int iFo = eo.fo(naVar);
        e.z(new fo("PreloadStrategyShowDelete-onShow") { // from class: com.bytedance.sdk.openadsdk.core.gc.dl.gc.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.gc.a.gc.z(gc.this.z).z(new StringBuilder().append(iFo).toString(), naVar.jt());
            }
        });
    }
}
