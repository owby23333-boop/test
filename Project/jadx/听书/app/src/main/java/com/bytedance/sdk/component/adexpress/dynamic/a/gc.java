package com.bytedance.sdk.component.adexpress.dynamic.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.a.g;
import com.bytedance.sdk.component.adexpress.g.i;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f543a;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.gz dl;
    protected g g;
    public com.bytedance.sdk.component.adexpress.dynamic.dl.g z;

    static class z {
        float dl;
        float g;
        float z;

        z() {
        }
    }

    public gc(double d, int i, double d2, String str, i iVar) {
        this.g = new g(d, i, d2, str, iVar);
    }

    public void z(z zVar) {
        this.f543a = zVar;
    }

    public void z() {
        this.g.z();
    }

    public void z(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar, float f, float f2) {
        if (gzVar != null) {
            this.dl = gzVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar2 = this.dl;
        float fGz = gzVar2.gz();
        float fFo = gzVar2.fo();
        float f3 = TextUtils.equals(gzVar2.uy().gc().hh(), "fixed") ? fFo : 65536.0f;
        this.g.z();
        this.g.dl(gzVar2, fGz, f3);
        g.dl dlVarZ = this.g.z(gzVar2);
        com.bytedance.sdk.component.adexpress.dynamic.dl.g gVar = new com.bytedance.sdk.component.adexpress.dynamic.dl.g();
        gVar.z = f;
        gVar.g = f2;
        if (dlVarZ != null) {
            fGz = dlVarZ.z;
        }
        gVar.dl = fGz;
        if (dlVarZ != null) {
            fFo = dlVarZ.g;
        }
        gVar.f552a = fFo;
        gVar.gc = "root";
        gVar.fo = 1280.0f;
        gVar.m = gzVar2;
        gVar.m.dl(gVar.z);
        gVar.m.a(gVar.g);
        gVar.m.gc(gVar.dl);
        gVar.m.m(gVar.f552a);
        com.bytedance.sdk.component.adexpress.dynamic.dl.g gVarZ = z(gVar, 0.0f);
        this.z = gVarZ;
        z(gVarZ);
    }

    public void z(com.bytedance.sdk.component.adexpress.dynamic.dl.g gVar) {
        if (gVar == null) {
            return;
        }
        gVar.m.uy().getType();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.dl.g>> list = gVar.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.dl.g> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.dl.g> it = list2.iterator();
                while (it.hasNext()) {
                    z(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.dl.g z(com.bytedance.sdk.component.adexpress.dynamic.dl.g r37, float r38) {
        /*
            Method dump skipped, instruction units count: 1003
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.a.gc.z(com.bytedance.sdk.component.adexpress.dynamic.dl.g, float):com.bytedance.sdk.component.adexpress.dynamic.dl.g");
    }

    private com.bytedance.sdk.component.adexpress.dynamic.dl.fo z(com.bytedance.sdk.component.adexpress.dynamic.dl.m mVar, g.dl dlVar, g.dl dlVar2) {
        float fSd = mVar.sd();
        float fJa = mVar.ja();
        float fTf = mVar.tf();
        float fWn = mVar.wn();
        boolean zZx = mVar.zx();
        boolean zB = mVar.b();
        boolean zLw = mVar.lw();
        boolean zRv = mVar.rv();
        if (!zZx) {
            if (zB) {
                fSd = ((this.f543a.z != 0.0f ? Math.min(this.f543a.z, dlVar.z) : dlVar.z) - fTf) - dlVar2.z;
            } else {
                fSd = 0.0f;
            }
        }
        if (!zLw) {
            if (zRv) {
                fJa = ((this.f543a.g != 0.0f ? this.f543a.g : dlVar.g) - fWn) - dlVar2.g;
            } else {
                fJa = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.dl.fo(fSd, fJa);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.dl.fo z(com.bytedance.sdk.component.adexpress.dynamic.dl.g gVar, com.bytedance.sdk.component.adexpress.dynamic.dl.m mVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = gVar.z;
        float f6 = gVar.g;
        float fSd = mVar.sd();
        float fJa = mVar.ja();
        float fTf = mVar.tf();
        float fWn = mVar.wn();
        boolean zZx = mVar.zx();
        boolean zB = mVar.b();
        boolean zLw = mVar.lw();
        boolean zRv = mVar.rv();
        String strQd = mVar.qd();
        float f7 = gVar.dl;
        float f8 = gVar.f552a;
        if (TextUtils.equals(strQd, "0")) {
            if (zZx) {
                f5 = gVar.z + fSd;
            } else if (zB) {
                f5 = ((gVar.z + f7) - fTf) - f;
            }
            if (zLw) {
                f4 = gVar.g;
                f6 = f4 + fJa;
            } else if (zRv) {
                f3 = gVar.g;
                f6 = ((f3 + f8) - fWn) - f2;
            }
        } else if (TextUtils.equals(strQd, "1")) {
            f5 = gVar.z + ((f7 - f) / 2.0f);
            if (zLw) {
                f4 = gVar.g;
                f6 = f4 + fJa;
            } else if (zRv) {
                f3 = gVar.g;
                f6 = ((f3 + f8) - fWn) - f2;
            }
        } else if (TextUtils.equals(strQd, "2")) {
            f6 = gVar.g + ((f8 - f2) / 2.0f);
            if (zZx) {
                f5 = gVar.z + fSd;
            } else if (zB) {
                f5 = ((gVar.z + f7) - fTf) - f;
            }
        } else if (TextUtils.equals(strQd, "3")) {
            f5 = gVar.z + ((f7 - f) / 2.0f);
            f6 = gVar.g + ((f8 - f2) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.dl.fo(f5, f6);
    }
}
