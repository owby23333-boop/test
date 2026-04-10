package com.bytedance.sdk.gromore.z.z.e.dl;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.ls.dl.g.kb;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends kb {
    private com.bytedance.sdk.openadsdk.zw.z.g.z.z g;
    private com.bytedance.msdk.dl.a.z z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public long a() {
        return Long.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public int dl() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
    }

    public gc(com.bytedance.msdk.dl.a.z zVar) {
        this.z = zVar;
        m();
    }

    private void m() {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar == null) {
            return;
        }
        zVar.z(new com.bytedance.msdk.api.a.z.m.z() { // from class: com.bytedance.sdk.gromore.z.z.e.dl.gc.1
            @Override // com.bytedance.msdk.api.a.z.m.z
            public void z() {
                if (gc.this.g != null) {
                    gc.this.g.z();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void z(com.bytedance.msdk.api.z zVar2) {
                if (zVar2 == null || !(gc.this.g instanceof com.bytedance.sdk.openadsdk.mediation.g.g.z.g)) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.mediation.g.g.z.g) gc.this.g).z(zVar2.z, zVar2.g);
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void g() {
                if (gc.this.g != null) {
                    gc.this.g.g();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void dl() {
                if (gc.this.g != null) {
                    gc.this.g.dl();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void a() {
                if (gc.this.g != null) {
                    gc.this.g.a();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void gc() {
                if (gc.this.g instanceof com.bytedance.sdk.openadsdk.mediation.g.g.z.g) {
                    ((com.bytedance.sdk.openadsdk.mediation.g.g.z.g) gc.this.g).m();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void m() {
                if (gc.this.g != null) {
                    gc.this.g.gc();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void e() {
                if (gc.this.g instanceof com.bytedance.sdk.openadsdk.mediation.g.g.z.g) {
                    ((com.bytedance.sdk.openadsdk.mediation.g.g.z.g) gc.this.g).e();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void gz() {
                if (gc.this.g instanceof com.bytedance.sdk.openadsdk.mediation.g.g.z.g) {
                    ((com.bytedance.sdk.openadsdk.mediation.g.g.z.g) gc.this.g).gz();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.m.z
            public void z(com.bytedance.msdk.api.dl.z zVar2) {
                if (gc.this.g instanceof com.bytedance.sdk.openadsdk.mediation.g.g.z.g) {
                    ((com.bytedance.sdk.openadsdk.mediation.g.g.z.g) gc.this.g).z(a.z(zVar2));
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null) {
            zVar.z(new com.bytedance.msdk.api.a.z.g() { // from class: com.bytedance.sdk.gromore.z.z.e.dl.gc.2
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

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public int z() {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null) {
            return zVar.p();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(Activity activity) {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null) {
            zVar.z(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(Activity activity, Object obj, String str) {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null) {
            zVar.z(activity, obj, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public Map<String, Object> g() {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null) {
            return zVar.fv();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.a gc() {
        return new gz(new m(this.z));
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null) {
            zVar.z(gVar);
        }
    }
}
