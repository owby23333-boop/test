package com.bytedance.sdk.gromore.z.z.e.dl;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.ls.dl.g.kb;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends kb {
    private com.bytedance.sdk.openadsdk.zw.z.g.z.z g;
    private com.bytedance.msdk.dl.a.gz z;

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

    public z(com.bytedance.msdk.dl.a.gz gzVar) {
        this.z = gzVar;
        m();
    }

    private void m() {
        com.bytedance.msdk.dl.a.gz gzVar = this.z;
        if (gzVar == null) {
            return;
        }
        gzVar.z(new com.bytedance.msdk.api.a.z.a.z() { // from class: com.bytedance.sdk.gromore.z.z.e.dl.z.1
            @Override // com.bytedance.msdk.api.a.z.a.z
            public void g_() {
                if (z.this.g != null) {
                    z.this.g.z();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void z(com.bytedance.msdk.api.z zVar) {
                if (zVar == null || !(z.this.g instanceof com.bytedance.sdk.openadsdk.mediation.g.g.z.g)) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.mediation.g.g.z.g) z.this.g).z(zVar.z, zVar.g);
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void h_() {
                if (z.this.g != null) {
                    z.this.g.g();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void dl() {
                if (z.this.g != null) {
                    z.this.g.dl();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void a() {
                if (z.this.g != null) {
                    z.this.g.a();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void gc() {
                if (z.this.g instanceof com.bytedance.sdk.openadsdk.mediation.g.g.z.g) {
                    ((com.bytedance.sdk.openadsdk.mediation.g.g.z.g) z.this.g).m();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void m() {
                if (z.this.g != null) {
                    z.this.g.gc();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.a.z
            public void z(com.bytedance.msdk.api.dl.z zVar) {
                if (z.this.g instanceof com.bytedance.sdk.openadsdk.mediation.g.g.z.g) {
                    ((com.bytedance.sdk.openadsdk.mediation.g.g.z.g) z.this.g).z(a.z(zVar));
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
        com.bytedance.msdk.dl.a.gz gzVar = this.z;
        if (gzVar != null) {
            gzVar.z(new com.bytedance.msdk.api.a.z.g() { // from class: com.bytedance.sdk.gromore.z.z.e.dl.z.2
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
        com.bytedance.msdk.dl.a.gz gzVar = this.z;
        if (gzVar != null) {
            return gzVar.p();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(Activity activity) {
        com.bytedance.msdk.dl.a.gz gzVar = this.z;
        if (gzVar != null) {
            gzVar.z(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(Activity activity, Object obj, String str) {
        com.bytedance.msdk.dl.a.gz gzVar = this.z;
        if (gzVar != null) {
            gzVar.g(activity, obj, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public Map<String, Object> g() {
        com.bytedance.msdk.dl.a.gz gzVar = this.z;
        if (gzVar != null) {
            return gzVar.fv();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.a gc() {
        return new gz(new g(this.z));
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        com.bytedance.msdk.dl.a.gz gzVar = this.z;
        if (gzVar != null) {
            gzVar.z(gVar);
        }
    }
}
