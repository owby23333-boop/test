package com.bytedance.sdk.gromore.z.z.e.g;

import com.bytedance.msdk.dl.a.e;
import com.bytedance.msdk.gc.m;
import com.bytedance.msdk.gz.p;
import com.bytedance.sdk.gromore.z.z.a.gc;
import com.bytedance.sdk.gromore.z.z.a.pf;
import com.bytedance.sdk.gromore.z.z.a.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements v {
    private e dl;
    private com.bytedance.msdk.api.z.g g;
    private com.bytedance.msdk.g.dl z;

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void z(pf pfVar) {
    }

    public g(e eVar, com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar) {
        this.z = dlVar;
        this.g = gVar;
        this.dl = eVar;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public boolean z() {
        if (this.z == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.z);
        m.z(arrayList, (List<com.bytedance.msdk.g.dl>) null, (List<com.bytedance.msdk.g.dl>) null, this.g, 0);
        com.bytedance.msdk.api.z.g gVar = this.g;
        if (gVar != null) {
            return this.z.un(gVar.zw());
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.a> g() {
        List<com.bytedance.msdk.api.g> listUy;
        ArrayList arrayList = new ArrayList();
        e eVar = this.dl;
        if (eVar != null && (listUy = eVar.uy()) != null) {
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
        e eVar = this.dl;
        if (eVar != null && (listKb = eVar.kb()) != null) {
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
        if (this.z == null || !com.bytedance.msdk.core.g.g().io()) {
            return new gc();
        }
        return new com.bytedance.sdk.gromore.z.z.a.m(com.bytedance.msdk.gz.v.z(this.g, this.z, false));
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.g> gc() {
        List<com.bytedance.msdk.api.dl> listWp;
        ArrayList arrayList = new ArrayList();
        e eVar = this.dl;
        if (eVar != null && (listWp = eVar.wp()) != null) {
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
            return new gc();
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
