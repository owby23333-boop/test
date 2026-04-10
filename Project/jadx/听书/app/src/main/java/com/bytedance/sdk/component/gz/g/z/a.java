package com.bytedance.sdk.component.gz.g.z;

import android.content.Context;
import com.bytedance.sdk.component.gz.g.z.z.g.e;
import com.bytedance.sdk.component.gz.g.z.z.g.gz;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f746a;
    private com.bytedance.sdk.component.gz.g.z.z.g.gc dl;
    private com.bytedance.sdk.component.gz.g.a.g.z e;
    private com.bytedance.sdk.component.gz.g.a.g.z fo;
    private com.bytedance.sdk.component.gz.g.z.z.g.m g;
    private com.bytedance.sdk.component.gz.g.z.z.g.z gc;
    private com.bytedance.sdk.component.gz.g.a.g.z gz;
    private com.bytedance.sdk.component.gz.z.gc i;
    private com.bytedance.sdk.component.gz.g.a.g.z kb;
    private gz m;
    private com.bytedance.sdk.component.gz.g.a.g.z uy;
    private List<com.bytedance.sdk.component.gz.g.z.z.g.g> v = new ArrayList();
    private com.bytedance.sdk.component.gz.g.a.g.z wp;
    private com.bytedance.sdk.component.gz.g.z.z.g.a z;

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public List<com.bytedance.sdk.component.gz.z.g> z(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, String str) {
        return null;
    }

    public a(com.bytedance.sdk.component.gz.z.gc gcVar) {
        this.i = gcVar;
        Context context = gcVar.getContext();
        if (com.bytedance.sdk.component.gz.g.g.z.z(gcVar)) {
            this.e = this.i.e();
            com.bytedance.sdk.component.gz.g.z.z.g.a aVar = new com.bytedance.sdk.component.gz.g.z.z.g.a(context, this.e, this.i);
            this.z = aVar;
            this.v.add(aVar);
        }
        if (com.bytedance.sdk.component.gz.g.g.z.gc(gcVar)) {
            if (this.i.z() != null) {
                this.fo = this.i.z();
            } else {
                this.fo = this.i.gz();
            }
            com.bytedance.sdk.component.gz.g.z.z.g.gc gcVar2 = new com.bytedance.sdk.component.gz.g.z.z.g.gc(context, this.fo, this.i);
            this.dl = gcVar2;
            this.v.add(gcVar2);
        }
        if (com.bytedance.sdk.component.gz.g.g.z.g(gcVar)) {
            this.gz = this.i.gz();
            com.bytedance.sdk.component.gz.g.z.z.g.m mVar = new com.bytedance.sdk.component.gz.g.z.z.g.m(context, this.gz, this.i);
            this.g = mVar;
            this.v.add(mVar);
        }
        if (com.bytedance.sdk.component.gz.g.g.z.dl(gcVar)) {
            this.uy = this.i.gz();
            e eVar = new e(context, this.uy, this.i);
            this.f746a = eVar;
            this.v.add(eVar);
        }
        if (com.bytedance.sdk.component.gz.g.g.z.a(gcVar)) {
            this.kb = this.i.fo();
            com.bytedance.sdk.component.gz.g.z.z.g.z zVar = new com.bytedance.sdk.component.gz.g.z.z.g.z(context, this.kb, this.i);
            this.gc = zVar;
            this.v.add(zVar);
        }
        if (com.bytedance.sdk.component.gz.g.g.z.m(gcVar)) {
            this.wp = this.i.m();
            gz gzVar = new gz(context, this.wp, this.i);
            this.m = gzVar;
            this.v.add(gzVar);
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public void z(com.bytedance.sdk.component.gz.z.g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            gVar.g(System.currentTimeMillis());
            Iterator<com.bytedance.sdk.component.gz.g.z.z.g.g> it = this.v.iterator();
            while (it.hasNext()) {
                it.next().g(gVar);
            }
        } catch (Throwable th) {
            wp.z(th);
            com.bytedance.sdk.component.gz.g.dl.g.z(com.bytedance.sdk.component.gz.g.g.g.z.z(), 1, this.i);
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public g z(int i, List<com.bytedance.sdk.component.gz.z.g> list, int i2) {
        Iterator<com.bytedance.sdk.component.gz.g.z.z.g.g> it = this.v.iterator();
        g gVarZ = null;
        while (it.hasNext()) {
            gVarZ = it.next().z(i, list);
            if (gVarZ.z()) {
                break;
            }
        }
        return gVarZ;
    }

    public List<com.bytedance.sdk.component.gz.z.g> z(com.bytedance.sdk.component.gz.z.g gVar, int i, int i2, boolean z) {
        Iterator<com.bytedance.sdk.component.gz.g.z.z.g.g> it = this.v.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.gz.z.g> listZ = it.next().z(i2, i, gVar, z);
            if (listZ != null && listZ.size() != 0) {
                return listZ;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public List<com.bytedance.sdk.component.gz.z.g> z(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.gz.g.z.z.g.g> it = this.v.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.gz.z.g> listZ = it.next().z(i, gVar, z, list, "db");
            if (listZ != null && listZ.size() != 0) {
                return listZ;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public boolean z(int i, String str, com.bytedance.sdk.component.gz.z.g gVar) {
        Iterator<com.bytedance.sdk.component.gz.g.z.z.g.g> it = this.v.iterator();
        while (it.hasNext()) {
            if (it.next().z(i, str, gVar)) {
                return true;
            }
        }
        return false;
    }
}
