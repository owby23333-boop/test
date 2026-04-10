package com.bytedance.msdk.dl.dl.g;

import com.bytedance.msdk.dl.dl.g.z;
import com.bytedance.msdk.gz.h;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements z.InterfaceC0089z {
    private com.bytedance.msdk.dl.m.z.g dl;
    private com.bytedance.msdk.dl.m.g.g g;
    private List<z> z = new CopyOnWriteArrayList();

    public gc(List<z> list) {
        if (h.z(list)) {
            return;
        }
        this.z.addAll(list);
    }

    public void z(com.bytedance.msdk.dl.m.z.g gVar, com.bytedance.msdk.dl.m.g.g gVar2) {
        this.dl = gVar;
        this.g = gVar2;
        if (h.z(this.z)) {
            return;
        }
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.dl.dl.g.gc.1
            @Override // java.lang.Runnable
            public void run() {
                ((z) gc.this.z.get(0)).z(gc.this);
            }
        });
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.InterfaceC0089z
    public com.bytedance.msdk.dl.m.g.g z() {
        return this.g;
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.InterfaceC0089z
    public com.bytedance.msdk.dl.m.z.g g() {
        return this.dl;
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.InterfaceC0089z
    public void z(z zVar) {
        int iIndexOf;
        if (h.z(this.z) || zVar == null || (iIndexOf = this.z.indexOf(zVar)) == -1 || iIndexOf >= this.z.size() - 1) {
            return;
        }
        this.z.get(iIndexOf + 1).z(this);
    }
}
