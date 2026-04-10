package com.bytedance.sdk.openadsdk.core.component.reward.z;

import com.bytedance.sdk.openadsdk.core.gc.g;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.x;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class z extends m<com.bytedance.sdk.openadsdk.core.component.reward.g> {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.z.m
    protected boolean z() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.z.m
    protected /* synthetic */ void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List list, com.bytedance.sdk.openadsdk.core.component.reward.g gVar2) {
        z(gVar, (List<na>) list, gVar2);
    }

    public z(com.bytedance.sdk.openadsdk.core.gc.gc.g gVar) {
        super(gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, g.z<com.bytedance.sdk.openadsdk.core.component.reward.g> zVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.g gVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.g(zw.getContext(), list.get(0), gVar);
        if (zVar != null) {
            zVar.z(gVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.z.m
    protected boolean z(com.bytedance.sdk.openadsdk.core.iq.z zVar) {
        List<na> listG;
        if (zVar != null && (listG = zVar.g()) != null) {
            na naVar = listG.get(0);
            if (hh.z(naVar)) {
                return naVar.dp().dl() != 1;
            }
            if (x.g(z(), naVar, false) && x.a(naVar) != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.z.m
    public void z(com.bytedance.sdk.openadsdk.core.component.reward.g gVar) {
        gVar.z(1);
    }

    protected void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, com.bytedance.sdk.openadsdk.core.component.reward.g gVar2) {
        na naVar = list.get(0);
        if (naVar.bp() <= 0) {
            gVar2.z(System.currentTimeMillis() + 10500000);
        } else {
            gVar2.z(naVar.bp() * 1000);
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar) || iq.dl(naVar) || y.z(naVar) || !naVar.xt()) {
            return;
        }
        gVar2.m();
    }
}
