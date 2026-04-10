package com.bytedance.sdk.gromore.z.z.e.m;

import com.bytedance.msdk.dl.a.i;
import com.bytedance.sdk.gromore.z.z.a;
import com.bytedance.sdk.gromore.z.z.a.gc;
import com.bytedance.sdk.gromore.z.z.a.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.gromore.z.z.gc.dl {
    private i z;

    public g(i iVar) {
        this.z = iVar;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public boolean z() {
        i iVar = this.z;
        if (iVar != null) {
            return iVar.q();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<a> g() {
        List<com.bytedance.msdk.api.g> listUy;
        ArrayList arrayList = new ArrayList();
        i iVar = this.z;
        if (iVar != null && (listUy = iVar.uy()) != null) {
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
        i iVar = this.z;
        if (iVar != null && (listKb = iVar.kb()) != null) {
            for (com.bytedance.msdk.api.dl dlVar : listKb) {
                if (dlVar != null) {
                    arrayList.add(new m(dlVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public com.bytedance.sdk.gromore.z.z.g a() {
        if (this.z != null) {
            return new m(this.z.ls());
        }
        return new gc();
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.g> gc() {
        List<com.bytedance.msdk.api.dl> listWp;
        ArrayList arrayList = new ArrayList();
        i iVar = this.z;
        if (iVar != null && (listWp = iVar.wp()) != null) {
            for (com.bytedance.msdk.api.dl dlVar : listWp) {
                if (dlVar != null) {
                    arrayList.add(new m(dlVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public com.bytedance.sdk.gromore.z.z.g m() {
        if (this.z != null) {
            return new m(this.z.pf());
        }
        return new gc();
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc.dl
    public void e() {
        i iVar = this.z;
        if (iVar != null) {
            iVar.z();
        }
    }
}
