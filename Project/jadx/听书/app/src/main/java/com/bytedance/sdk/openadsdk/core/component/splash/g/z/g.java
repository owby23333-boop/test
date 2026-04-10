package com.bytedance.sdk.openadsdk.core.component.splash.g.z;

import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.m.tb;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.fv;
import com.bytedance.sdk.openadsdk.core.un.p;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.fo;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.openadsdk.core.component.splash.dl.g.z {
    private e z = new e();

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.g.z
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl<gz, e> dlVar) {
        g(gVar, dlVar);
    }

    private void g(final com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar, final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl<gz, e> dlVar) {
        if (gVar == null || dlVar == null) {
            return;
        }
        this.z.g(gVar.v());
        this.z.z(gVar.g());
        if (zw.g().fo(gVar.fo()) == 4) {
            gz gzVar = new gz(gVar.g(), gVar.v());
            gzVar.z(false);
            gzVar.z(gVar.z());
            gzVar.z(gVar.dl());
            dlVar.g(gzVar);
            return;
        }
        com.bytedance.sdk.openadsdk.i.g gVarGc = gVar.gc();
        if (gVarGc == null) {
            this.z.g(2);
            this.z.z("image request fail");
            this.z.z(false);
            dlVar.z(this.z);
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("Splash_FullLink", "加载图片素材 " + gVar.g().aq());
        fv.z(gVarGc, gVar.m(), gVar.e(), new fv.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.g.z.g.1
            @Override // com.bytedance.sdk.openadsdk.core.un.fv.z
            public void z(com.bytedance.sdk.openadsdk.core.io.z.g gVar2, ls lsVar) {
                gz gzVar2 = new gz(gVar2, gVar.g(), gVar.v());
                gzVar2.z(false);
                gzVar2.z(gVar.z());
                gzVar2.gc(gVar.dl());
                if (lsVar != null) {
                    gzVar2.z(lsVar.getHeaders());
                    gzVar2.g(lsVar.isLocal());
                    gzVar2.g(p.z(lsVar.getHeaders()));
                    if (lsVar.getHttpTime() != null) {
                        gzVar2.g(lsVar.getHttpTime().getFirstFrameTime());
                        gzVar2.dl(lsVar.getHttpTime().getStartRequestTime());
                        gzVar2.a(lsVar.getHttpTime().getEndRequestTime());
                    }
                }
                dlVar.g(gzVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.fv.z
            public void z() {
                g.this.z.g(2);
                g.this.z.z("load image fail");
                g.this.z.z(false);
                dlVar.z(g.this.z);
            }
        }, fo.gc(), 4, new tb() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.g.z.g.2
            @Override // com.bytedance.sdk.component.m.tb
            public void onStep(int i, Object obj) {
                if (i == 3 && g.this.z(gVar)) {
                    gz gzVar2 = new gz(gVar.g(), gVar.v());
                    gzVar2.z(false);
                    gzVar2.z(gVar.z());
                    gzVar2.z(gVar.dl());
                    gzVar2.a(true);
                    gzVar2.g(false);
                    dlVar.dl(gzVar2);
                }
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar) {
        na naVarG;
        if (gVar == null || (naVarG = gVar.g()) == null) {
            return false;
        }
        int iYz = naVarG.yz();
        return iYz == 3 || iYz == 4;
    }
}
