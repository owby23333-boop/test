package com.bytedance.sdk.gromore.z.z.e.gc;

import com.bytedance.msdk.dl.a.wp;
import com.bytedance.sdk.gromore.z.z.a;
import com.bytedance.sdk.gromore.z.z.a.gc;
import com.bytedance.sdk.gromore.z.z.a.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.gromore.z.z.gc.dl {
    private wp z;

    public g(wp wpVar) {
        this.z = wpVar;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public boolean z() {
        wp wpVar = this.z;
        if (wpVar != null) {
            return wpVar.hh();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<a> g() {
        List<com.bytedance.msdk.api.g> listUy;
        ArrayList arrayList = new ArrayList();
        wp wpVar = this.z;
        if (wpVar != null && (listUy = wpVar.uy()) != null) {
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
        wp wpVar = this.z;
        if (wpVar != null && (listKb = wpVar.kb()) != null) {
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
        wp wpVar = this.z;
        if (wpVar != null && (listWp = wpVar.wp()) != null) {
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
        wp wpVar = this.z;
        if (wpVar != null) {
            wpVar.z();
        }
    }
}
