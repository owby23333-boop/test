package com.bytedance.sdk.gromore.z.z.e.m;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.fo.a;
import com.bytedance.msdk.dl.a.i;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.e;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.openadsdk.ls.dl.g.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.tb.z.g.z.z f887a;
    private com.bytedance.sdk.openadsdk.a.z.g.z.g dl;
    private com.bytedance.sdk.openadsdk.a.z.g.z.z g;
    private a gc = new a() { // from class: com.bytedance.sdk.gromore.z.z.e.m.z.2
        @Override // com.bytedance.msdk.api.a.z.fo.a
        public Activity getActivity() {
            return null;
        }

        @Override // com.bytedance.msdk.api.a.z.fo.a
        public void z() {
            if (z.this.dl != null) {
                z.this.dl.z(z.this);
            }
        }

        @Override // com.bytedance.msdk.api.a.z.fo.a
        public void g() {
            if (z.this.dl != null) {
                z.this.dl.g();
            }
        }

        @Override // com.bytedance.msdk.api.a.z.fo.a
        public void dl() {
            if (z.this.dl != null) {
                z.this.dl.z();
            }
        }
    };
    private i z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public PluginValueSet z() {
        return com.bykv.z.z.z.z.z.z(super.z()).z(1, com.bytedance.sdk.gromore.init.z.z()).g();
    }

    public z(i iVar, com.bytedance.sdk.openadsdk.tb.z.g.z.z zVar) {
        this.z = iVar;
        this.f887a = zVar;
        gz();
    }

    private void gz() {
        this.z.z(new com.bytedance.msdk.api.a.z.fo.g() { // from class: com.bytedance.sdk.gromore.z.z.e.m.z.1
            @Override // com.bytedance.msdk.api.a.z.fo.g
            public void a() {
                if (z.this.g != null) {
                    z.this.g.g(z.this);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.fo.g
            public void gc() {
                if (z.this.g != null) {
                    z.this.g.z(z.this);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.fo.g
            public void z(com.bytedance.msdk.api.z zVar) {
                if (z.this.f887a == null || zVar == null) {
                    return;
                }
                z.this.f887a.z(z.this, new com.bytedance.sdk.gromore.z.z.z(zVar.z, zVar.g));
            }

            @Override // com.bytedance.msdk.api.a.z.fo.g
            public void z(int i) {
                if (z.this.g != null) {
                    z.this.g.z(z.this, i);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.fo.g
            public void g(int i) {
                if (z.this.g != null) {
                    z.this.g.z(z.this, i);
                }
            }
        });
        this.z.z(this.gc);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public View g() {
        i iVar = this.z;
        if (iVar != null) {
            return iVar.iq();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public View dl() {
        i iVar = this.z;
        if (iVar != null) {
            return iVar.m();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public int a() {
        i iVar = this.z;
        if (iVar != null) {
            return iVar.p();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public Map<String, Object> gc() {
        i iVar = this.z;
        if (iVar != null) {
            return iVar.fv();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void m() {
        i iVar = this.z;
        if (iVar != null) {
            iVar.io();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        i iVar = this.z;
        if (iVar != null) {
            iVar.z(new com.bytedance.msdk.api.a.z.g() { // from class: com.bytedance.sdk.gromore.z.z.e.m.z.3
                @Override // com.bytedance.msdk.api.a.z.g
                public void g() {
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z() {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z();
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, long j2, int i, int i2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, long j2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.g(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void g(long j, long j2, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.dl(j, j2, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(long j, String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(j, str, str2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(String str, String str2) {
                    com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(com.bytedance.sdk.openadsdk.a.z.g.z.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(com.bytedance.sdk.openadsdk.a.z.g.z.g gVar) {
        this.dl = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(ViewGroup viewGroup) {
        i iVar = this.z;
        if (iVar == null || viewGroup == null) {
            return;
        }
        iVar.z(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(ViewGroup viewGroup, Activity activity) {
        i iVar = this.z;
        if (iVar == null || viewGroup == null || activity == null) {
            return;
        }
        iVar.z(viewGroup, activity);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public e e() {
        return new com.bytedance.sdk.gromore.z.z.m.z(new g(this.z));
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        i iVar = this.z;
        if (iVar != null) {
            iVar.z(gVar);
        }
    }
}
