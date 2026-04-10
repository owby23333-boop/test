package com.bytedance.sdk.gromore.z.z.e.dl;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m implements com.bytedance.sdk.gromore.z.z.gc.dl {
    private com.bytedance.msdk.dl.a.z z;

    public m(com.bytedance.msdk.dl.a.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public boolean z() {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null) {
            return zVar.hh();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.a> g() {
        List<com.bytedance.msdk.api.g> listUy;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null && (listUy = zVar.uy()) != null) {
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
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null && (listKb = zVar.kb()) != null) {
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
        if (this.z != null) {
            return new com.bytedance.sdk.gromore.z.z.a.m(this.z.ls());
        }
        return new com.bytedance.sdk.gromore.z.z.a.gc();
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.g> gc() {
        List<com.bytedance.msdk.api.dl> listWp;
        ArrayList arrayList = new ArrayList();
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null && (listWp = zVar.wp()) != null) {
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
        if (this.z != null) {
            return new com.bytedance.sdk.gromore.z.z.a.m(this.z.pf());
        }
        return new com.bytedance.sdk.gromore.z.z.a.gc();
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc.dl
    public void e() {
        com.bytedance.msdk.dl.a.z zVar = this.z;
        if (zVar != null) {
            zVar.z();
        }
    }
}
