package com.bytedance.embedapplog;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class wj extends mc {
    private static final long[] g = {60000};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f308a;
    private long dl;

    @Override // com.bytedance.embedapplog.mc
    String a() {
        return "s";
    }

    public void z(boolean z) {
        this.f308a = z;
    }

    wj(ti tiVar) {
        super(tiVar);
        this.f308a = true;
    }

    @Override // com.bytedance.embedapplog.mc
    long z() {
        long jUf = this.z.a().uf();
        if (jUf > 60000 || jUf <= 0) {
            jUf = 60000;
        }
        g[0] = jUf;
        return this.dl + jUf;
    }

    @Override // com.bytedance.embedapplog.mc
    long[] g() {
        return g;
    }

    @Override // com.bytedance.embedapplog.mc
    public boolean dl() {
        Bundle bundleZ;
        long jCurrentTimeMillis = System.currentTimeMillis();
        na naVarE = this.z.e();
        if (naVarE != null && (bundleZ = naVarE.z(jCurrentTimeMillis, 50000L)) != null) {
            z.z("play_session", bundleZ, 1);
            z.g();
        }
        tf tfVarDl = this.z.dl();
        gb gbVarGc = this.z.gc();
        if (gbVarGc.wp() != 0) {
            JSONObject jSONObjectDl = o.dl(gbVarGc.z());
            if (jSONObjectDl != null) {
                z(tfVarDl.z(jSONObjectDl));
                this.dl = System.currentTimeMillis();
                return true;
            }
            cb.g((Throwable) null);
        }
        return false;
    }

    private void z(ArrayList<vo> arrayList) {
        tf tfVarDl = this.z.dl();
        ArrayList<vo> arrayList2 = new ArrayList<>();
        ArrayList<vo> arrayList3 = new ArrayList<>();
        bv bvVarA = this.z.a();
        ArrayList arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<vo> arrayListZ = tfVarDl.z();
        if (!arrayListZ.isEmpty()) {
            arrayList4.addAll(arrayListZ);
        }
        if (arrayList4.size() > 0) {
            Iterator it = arrayList4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                vo voVar = (vo) it.next();
                if (voVar.wp == null || voVar.wp.length <= 0) {
                    arrayList2.add(voVar);
                } else {
                    int iZ = this.f308a ? r.z(yz.z(this.z, this.z.g(), this.z.gc().z()), voVar.wp, bvVarA) : 200;
                    if (r.z(iZ)) {
                        if (arrayList.contains(voVar)) {
                            voVar.v = iZ;
                            arrayList3.add(voVar);
                        }
                    } else if (iZ == 200) {
                        arrayList2.add(voVar);
                    } else {
                        voVar.v = iZ;
                        arrayList3.add(voVar);
                    }
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                tfVarDl.z(arrayList2, arrayList3, arrayList);
            }
            cb.a(a() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }
}
