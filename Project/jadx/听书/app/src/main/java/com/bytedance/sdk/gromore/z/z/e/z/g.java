package com.bytedance.sdk.gromore.z.z.e.z;

import com.bytedance.msdk.dl.a.kb;
import com.bytedance.sdk.gromore.z.z.a;
import com.bytedance.sdk.gromore.z.z.a.gc;
import com.bytedance.sdk.gromore.z.z.a.m;
import com.bytedance.sdk.gromore.z.z.a.pf;
import com.bytedance.sdk.gromore.z.z.a.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements v {
    private kb z;

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public boolean e() {
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public boolean gz() {
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void z(pf pfVar) {
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void z(boolean z) {
    }

    public g(kb kbVar) {
        this.z = kbVar;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public boolean z() {
        kb kbVar = this.z;
        if (kbVar != null) {
            return kbVar.a();
        }
        return false;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<a> g() {
        List<com.bytedance.msdk.api.g> listGz;
        ArrayList arrayList = new ArrayList();
        kb kbVar = this.z;
        if (kbVar != null && (listGz = kbVar.gz()) != null) {
            for (com.bytedance.msdk.api.g gVar : listGz) {
                if (gVar != null) {
                    arrayList.add(new com.bytedance.sdk.gromore.z.z.a.z(gVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.g> dl() {
        List<com.bytedance.msdk.api.dl> listFo;
        ArrayList arrayList = new ArrayList();
        kb kbVar = this.z;
        if (kbVar != null && (listFo = kbVar.fo()) != null) {
            for (com.bytedance.msdk.api.dl dlVar : listFo) {
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
            return new m(this.z.uy());
        }
        return new gc();
    }

    @Override // com.bytedance.sdk.gromore.z.z.dl
    public List<com.bytedance.sdk.gromore.z.z.g> gc() {
        List<com.bytedance.msdk.api.dl> listKb;
        ArrayList arrayList = new ArrayList();
        kb kbVar = this.z;
        if (kbVar != null && (listKb = kbVar.kb()) != null) {
            for (com.bytedance.msdk.api.dl dlVar : listKb) {
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
            return new m(this.z.wp());
        }
        return new gc();
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void fo() {
        kb kbVar = this.z;
        if (kbVar != null) {
            kbVar.z();
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.a.v
    public void uy() {
        kb kbVar = this.z;
        if (kbVar != null) {
            kbVar.g();
        }
    }
}
