package com.bytedance.sdk.gromore.z.z.e.a;

import com.bytedance.msdk.dl.a.fo;
import com.bytedance.msdk.gz.p;
import com.bytedance.sdk.gromore.z.z.a.pf;
import com.bytedance.sdk.gromore.z.z.a.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements v {
    private fo dl;
    private com.bytedance.msdk.api.z.g g;
    private com.bytedance.msdk.g.dl z;

    public dl(fo foVar, com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar) {
        this.z = dlVar;
        this.g = gVar;
        this.dl = foVar;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public boolean z() {
        if (this.g == null || this.z == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.z);
        com.bytedance.msdk.gc.m.z(arrayList, (List<com.bytedance.msdk.g.dl>) null, (List<com.bytedance.msdk.g.dl>) null, this.g, 0);
        return this.z.un(this.g.zw());
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.a> g() {
        List<com.bytedance.msdk.api.g> listUy;
        ArrayList arrayList = new ArrayList();
        fo foVar = this.dl;
        if (foVar != null && (listUy = foVar.uy()) != null) {
            for (com.bytedance.msdk.api.g gVar : listUy) {
                if (gVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.z.z.a.z(gVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.g> dl() {
        List<com.bytedance.msdk.api.dl> listKb;
        ArrayList arrayList = new ArrayList();
        fo foVar = this.dl;
        if (foVar != null && (listKb = foVar.kb()) != null) {
            for (com.bytedance.msdk.api.dl dlVar : listKb) {
                if (dlVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.z.z.a.m(dlVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public com.bytedance.sdk.gromore.z.z.g a() {
        com.bytedance.msdk.api.z.g gVar;
        if (this.z != null && (gVar = this.g) != null) {
            if (!gVar.f() && !com.bytedance.msdk.core.g.g().io()) {
                return new com.bytedance.sdk.gromore.z.z.a.gc();
            }
            return new com.bytedance.sdk.gromore.z.z.a.m(com.bytedance.msdk.gz.v.z(this.g, this.z, false));
        }
        return new com.bytedance.sdk.gromore.z.z.a.gc();
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.g> gc() {
        List<com.bytedance.msdk.api.dl> listWp;
        ArrayList arrayList = new ArrayList();
        fo foVar = this.dl;
        if (foVar != null && (listWp = foVar.wp()) != null) {
            for (com.bytedance.msdk.api.dl dlVar : listWp) {
                if (dlVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.z.z.a.m(dlVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public com.bytedance.sdk.gromore.z.z.g m() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar == null || !dlVar.sv() || p.z()) {
            return new com.bytedance.sdk.gromore.z.z.a.gc();
        }
        return new com.bytedance.sdk.gromore.z.z.a.m(com.bytedance.msdk.gz.v.z(this.g, this.z, true));
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public boolean e() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.tb();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void z(boolean z) {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.a(z);
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void z(final pf pfVar) {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(new com.bytedance.msdk.api.a.z.a() { // from class: com.bytedance.sdk.gromore.z.z.e.a.dl.1
                @Override // com.bytedance.msdk.api.a.z.a
                public void z() {
                    pf pfVar2 = pfVar;
                    if (pfVar2 != null) {
                        pfVar2.z();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public boolean gz() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.tc();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void fo() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.p();
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void uy() {
        com.bytedance.msdk.g.dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.ls();
        }
    }
}
