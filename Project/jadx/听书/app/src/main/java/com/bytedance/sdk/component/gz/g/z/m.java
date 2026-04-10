package com.bytedance.sdk.component.gz.g.z;

import com.bytedance.sdk.component.gz.g.z.g.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class m implements gc {
    private List<com.bytedance.sdk.component.gz.g.z.g.z> z = new ArrayList();

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public List<com.bytedance.sdk.component.gz.z.g> z(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, String str) {
        return null;
    }

    public m(Queue<String> queue, com.bytedance.sdk.component.gz.z.gc gcVar) {
        com.bytedance.sdk.component.gz.g.a.g.z zVarGz;
        if (com.bytedance.sdk.component.gz.g.g.z.z(gcVar)) {
            this.z.add(new com.bytedance.sdk.component.gz.g.z.g.dl(gcVar.e(), queue, gcVar));
        }
        if (com.bytedance.sdk.component.gz.g.g.z.gc(gcVar)) {
            if (gcVar.z() != null) {
                zVarGz = gcVar.z();
            } else {
                zVarGz = gcVar.gz();
            }
            this.z.add(new com.bytedance.sdk.component.gz.g.z.g.a(zVarGz, queue, gcVar));
        }
        if (com.bytedance.sdk.component.gz.g.g.z.g(gcVar)) {
            this.z.add(new com.bytedance.sdk.component.gz.g.z.g.gc(gcVar.gz(), queue, gcVar));
        }
        if (com.bytedance.sdk.component.gz.g.g.z.dl(gcVar)) {
            this.z.add(new com.bytedance.sdk.component.gz.g.z.g.m(gcVar.gz(), queue, gcVar));
        }
        if (com.bytedance.sdk.component.gz.g.g.z.a(gcVar)) {
            this.z.add(new com.bytedance.sdk.component.gz.g.z.g.g(gcVar.fo(), queue, gcVar));
        }
        if (com.bytedance.sdk.component.gz.g.g.z.m(gcVar)) {
            this.z.add(new e(gcVar.m(), queue, gcVar));
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public void z(com.bytedance.sdk.component.gz.z.g gVar) {
        Iterator<com.bytedance.sdk.component.gz.g.z.g.z> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().g(gVar);
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public g z(int i, List<com.bytedance.sdk.component.gz.z.g> list, int i2) {
        Iterator<com.bytedance.sdk.component.gz.g.z.g.z> it = this.z.iterator();
        g gVarZ = null;
        while (it.hasNext()) {
            gVarZ = it.next().z(i, list, i2);
            if (gVarZ.z()) {
                break;
            }
        }
        return gVarZ;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public List<com.bytedance.sdk.component.gz.z.g> z(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.gz.g.z.g.z> it = this.z.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.gz.z.g> listZ = it.next().z(i, gVar, z, list, "get");
            if (listZ != null && listZ.size() != 0) {
                return listZ;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public boolean z(int i, String str, com.bytedance.sdk.component.gz.z.g gVar) {
        Iterator<com.bytedance.sdk.component.gz.g.z.g.z> it = this.z.iterator();
        while (it.hasNext()) {
            if (it.next().z(i, str, gVar)) {
                return true;
            }
        }
        return false;
    }
}
