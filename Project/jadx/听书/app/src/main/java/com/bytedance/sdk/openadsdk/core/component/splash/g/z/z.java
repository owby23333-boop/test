package com.bytedance.sdk.openadsdk.core.component.splash.g.z;

import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m;
import com.bytedance.sdk.openadsdk.core.component.splash.z.gc;
import com.bytedance.sdk.openadsdk.core.component.splash.z.z;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g dl;
    private gc e;
    private String g;
    private boolean gc;
    private com.bytedance.sdk.openadsdk.core.component.splash.z.z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f1009a = new e();
    private com.bytedance.sdk.openadsdk.core.gc.g.z m = new com.bytedance.sdk.openadsdk.core.gc.g.z(4);

    public z(com.bytedance.sdk.openadsdk.core.component.splash.z.z zVar) {
        this.z = zVar;
        zVar.g();
        this.gc = zw.g().b();
    }

    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gc gcVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g<m, e> gVar) {
        if (gcVar == null || gVar == null) {
            return;
        }
        this.f1009a.g(true);
        this.dl = gcVar.a();
        this.g = gcVar.m();
        this.e = gcVar.e();
        if (com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.gc.z(this.dl, gcVar.gc())) {
            this.f1009a.g(1);
            this.f1009a.z("no cache");
            gVar.z(this.f1009a);
            return;
        }
        z(this.g, gVar);
    }

    private void z(final String str, final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g<m, e> gVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.z.z(this.f1009a, str, new z.InterfaceC0167z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.g.z.z.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z.InterfaceC0167z
            public void z(final m mVar) {
                com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "缓存读取总耗时： " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (gVar == null) {
                    return;
                }
                if (mVar == null || mVar.g() == null) {
                    if (mVar == null) {
                        z.this.f1009a.g(1);
                        z.this.f1009a.z("no ad model cache");
                        gVar.z(z.this.f1009a);
                        return;
                    } else if (mVar.g() == null) {
                        z.this.f1009a.g(1);
                        z.this.f1009a.z("no splash material");
                        gVar.z(z.this.f1009a);
                        return;
                    }
                }
                na naVarG = mVar.g();
                z.this.m.z(jCurrentTimeMillis);
                z.this.m.g(System.currentTimeMillis());
                ArrayList arrayList = new ArrayList();
                arrayList.add(naVarG);
                z.this.m.z(arrayList, new com.bytedance.sdk.openadsdk.core.gc.g.gc() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.g.z.z.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.gc.g.gc
                    public void z(List<na> list) {
                        if (z.this.gc) {
                            z.this.z(mVar, (com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g<m, e>) gVar);
                        } else {
                            gVar.g(mVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.gc.g.gc
                    public void g(List<na> list) {
                        if (list == null || list.isEmpty()) {
                            z.this.f1009a.g(22);
                            z.this.f1009a.z("check server cache unavailable");
                            gVar.z(z.this.f1009a);
                            return;
                        }
                        gVar.g(mVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.gc.g.gc
                    public void dl(List<na> list) {
                        Iterator<na> it = list.iterator();
                        while (it.hasNext()) {
                            z.this.z.z(str, it.next());
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z.InterfaceC0167z
            public void z() {
                com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "缓存读取失败");
                com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g gVar2 = gVar;
                if (gVar2 == null) {
                    return;
                }
                gVar2.z(z.this.f1009a);
            }
        }, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final m mVar, final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g<m, e> gVar) {
        if (gVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        na naVarG = mVar.g();
        zw.z().z(naVarG.mj(), naVarG.vk(), new sy.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.g.z.z.2
            @Override // com.bytedance.sdk.openadsdk.core.sy.z
            public void z(boolean z, long j, long j2) {
                v.z(z.this.dl, j, j2, System.currentTimeMillis() - jCurrentTimeMillis, 4, 1, z ? 1 : 0);
                if (!z) {
                    z.this.f1009a.g(22);
                    z.this.f1009a.z("check server cache unavailable");
                    z.this.f1009a.z(j);
                    gVar.z(z.this.f1009a);
                    return;
                }
                gVar.g(mVar);
            }
        });
    }
}
