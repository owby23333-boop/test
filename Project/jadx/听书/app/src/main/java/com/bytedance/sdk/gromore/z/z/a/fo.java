package com.bytedance.sdk.gromore.z.z.a;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z {
    private final com.bytedance.msdk.g.dl z;

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar) {
    }

    public fo(com.bytedance.msdk.g.dl dlVar) {
        this.z = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public String z() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.lt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public String g() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.kp();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public String dl() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.bw();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public String a() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.gy();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public String gc() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.zd();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public double m() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.fp();
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public List<String> e() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.xf();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public String gz() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.vt();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public int fo() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.nh();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public int uy() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.me();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.a kb() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar == null || !dlVar.bm()) {
            return null;
        }
        com.bytedance.msdk.api.a.z.e.z zVar = new com.bytedance.msdk.api.a.z.e.z();
        zVar.a(this.z.sd());
        zVar.gc(this.z.tf());
        zVar.z(this.z.ja());
        zVar.m(this.z.wn());
        zVar.e(this.z.nb());
        zVar.gz(this.z.zz());
        zVar.z(this.z.vo());
        zVar.g(this.z.lk());
        zVar.dl(this.z.y());
        zVar.z(this.z.t());
        zVar.g(this.z.vm());
        return new com.bytedance.sdk.gromore.z.z.z.dl(zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public boolean wp() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.tb();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.dl z(Activity activity) {
        if (activity == null || this.z == null) {
            return null;
        }
        return new com.bytedance.sdk.gromore.z.z.z.g(z(activity, this.z));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.dl z(Activity activity, Map<String, Object> map) {
        if (activity == null || map == null || this.z == null) {
            return null;
        }
        return new com.bytedance.sdk.gromore.z.z.z.g(z(activity, this.z));
    }

    private com.bytedance.msdk.api.a.g z(Activity activity, com.bytedance.msdk.g.dl dlVar) {
        final com.bytedance.sdk.openadsdk.ls.dl.g.e eVarZ = dlVar.z(activity);
        return new com.bytedance.msdk.api.a.g() { // from class: com.bytedance.sdk.gromore.z.z.a.fo.1
            @Override // com.bytedance.msdk.api.a.g
            public void z() {
                com.bytedance.sdk.openadsdk.ls.dl.g.e eVar = eVarZ;
                if (eVar != null) {
                    eVar.z();
                }
            }

            @Override // com.bytedance.msdk.api.a.g
            public void z(final com.bytedance.msdk.api.a.e eVar) {
                com.bytedance.sdk.openadsdk.ls.dl.g.e eVar2 = eVarZ;
                if (eVar2 != null) {
                    eVar2.z(new com.bytedance.sdk.openadsdk.js.z.g.z.z(null) { // from class: com.bytedance.sdk.gromore.z.z.a.fo.1.1
                        @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                        public void z() {
                            com.bytedance.msdk.api.a.e eVar3 = eVar;
                            if (eVar3 != null) {
                                eVar3.g();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                        public void z(int i, String str, boolean z) {
                            com.bytedance.msdk.api.a.e eVar3 = eVar;
                            if (eVar3 != null) {
                                eVar3.z(i, str);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                        public void g() {
                            com.bytedance.msdk.api.a.e eVar3 = eVar;
                            if (eVar3 != null) {
                                eVar3.z();
                            }
                        }
                    });
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(activity, zVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public void z(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public com.bytedance.sdk.openadsdk.ls.dl.g.e g(Activity activity) {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.z(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public com.bytedance.sdk.openadsdk.ls.dl.g.e g(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.g(dialog, numArr);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
    public com.bytedance.sdk.openadsdk.ls.dl.g.a i() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.he();
        }
        return null;
    }
}
