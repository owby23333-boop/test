package com.bytedance.sdk.component.m.a;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class m extends z {
    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "disk_cache";
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        byte[] bArrZ;
        String rawCacheKey = dlVar.getRawCacheKey();
        com.bytedance.sdk.component.m.g gVarI = dlVar.i();
        if (dlVar.v() || gVarI.isQueryAll()) {
            bArrZ = z(dlVar, rawCacheKey);
        } else {
            bArrZ = g(dlVar, rawCacheKey);
        }
        if (bArrZ == null) {
            dlVar.z(new kb());
            return;
        }
        dlVar.z(new g(bArrZ, null));
        if (gVarI.isRawMemoryCache()) {
            dlVar.wp().g(gVarI).z(rawCacheKey, bArrZ);
        }
    }

    private byte[] z(com.bytedance.sdk.component.m.dl.dl dlVar, String str) {
        dlVar.wp().dl(dlVar.i());
        Collection<com.bytedance.sdk.component.m.a> collectionDl = dlVar.wp().dl();
        if (collectionDl == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.m.a> it = collectionDl.iterator();
        while (it.hasNext()) {
            byte[] bArrZ = it.next().z(str);
            if (bArrZ != null) {
                return bArrZ;
            }
        }
        return null;
    }

    private byte[] g(com.bytedance.sdk.component.m.dl.dl dlVar, String str) {
        com.bytedance.sdk.component.m.a aVarDl = dlVar.wp().dl(dlVar.i());
        if (aVarDl == null) {
            return null;
        }
        return aVarDl.z(str);
    }
}
