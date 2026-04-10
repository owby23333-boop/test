package com.bytedance.adsdk.ugeno.gc.z;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g implements dl {
    private List<a> z = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.gc.z.dl
    public void z(a aVar) {
        this.z.add(aVar);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.z.dl
    public void z(String str) {
        if (this.z.isEmpty()) {
            return;
        }
        Iterator<a> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().z(str);
        }
    }
}
