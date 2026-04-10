package com.bytedance.sdk.openadsdk.core.component.splash.dl.dl;

import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz;
import com.bytedance.sdk.openadsdk.core.iq.vm;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private dl<gz, e> dl;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g g;
    private com.bytedance.sdk.openadsdk.core.component.splash.dl.g.z z;

    public m(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar, dl<gz, e> dlVar) {
        if (gVar == null || dlVar == null) {
            return;
        }
        this.g = gVar;
        this.dl = dlVar;
        if (gVar.kb() == 1) {
            this.z = new com.bytedance.sdk.openadsdk.core.component.splash.g.z.g();
        } else {
            this.z = new com.bytedance.sdk.openadsdk.core.component.splash.g.z.a();
        }
    }

    public boolean z() {
        return this.z instanceof com.bytedance.sdk.openadsdk.core.component.splash.g.z.a;
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.g gVar = this.g;
        if (gVar == null || this.dl == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.dl.g.z zVar = this.z;
        if (zVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.g.z.g) {
            zVar.z(gVar, new dl<gz, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.m.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public void dl(gz gzVar) {
                    if (gzVar != null) {
                        gzVar.gc(false);
                    }
                    m.this.dl.dl(gzVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
                public void g(gz gzVar) {
                    if (gzVar != null) {
                        gzVar.gc(true);
                    }
                    m.this.dl.g(gzVar);
                    com.bytedance.sdk.openadsdk.core.component.splash.e.z(m.this.g.wp());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
                public void z(e eVar) {
                    m.this.dl.z(eVar);
                }
            });
        } else {
            zVar.z(gVar, new dl<gz, e>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.m.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public void dl(gz gzVar) {
                    if (gzVar != null) {
                        gzVar.gc(false);
                    }
                    m.this.dl.dl(gzVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
                public void g(gz gzVar) {
                    if (gzVar != null) {
                        gzVar.gc(true);
                    }
                    m.this.dl.g(gzVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.dl
                public void z(e eVar) {
                    if (m.this.g.i() && m.this.g.g() != null) {
                        vm.z(m.this.g.g(), 1);
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.g.z.g().z(m.this.g, m.this.dl);
                }
            });
        }
    }
}
