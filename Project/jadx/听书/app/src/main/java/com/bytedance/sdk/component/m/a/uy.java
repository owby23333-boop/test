package com.bytedance.sdk.component.m.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.hh;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends z {
    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "memory_cache";
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        Bitmap bitmapG;
        int iGc = dlVar.gc();
        if (iGc != 2 && iGc != 1) {
            bitmapG = null;
        } else if (dlVar.v() || dlVar.i().isQueryAll()) {
            bitmapG = g(dlVar);
        } else {
            bitmapG = dl(dlVar);
        }
        if (bitmapG == null) {
            if (dlVar.i().isRawMemoryCache()) {
                dlVar.z(new wp());
                return;
            } else {
                dlVar.z(new m());
                return;
            }
        }
        dlVar.z(new i(bitmapG, null, null, false));
    }

    private Bitmap g(com.bytedance.sdk.component.m.dl.dl dlVar) {
        Collection<hh> collectionZ = dlVar.wp().z();
        Bitmap bitmapZ = null;
        if (collectionZ == null) {
            return null;
        }
        Iterator<hh> it = collectionZ.iterator();
        while (it.hasNext() && (bitmapZ = it.next().z(dlVar.getMemoryCacheKey())) == null) {
        }
        return bitmapZ;
    }

    private Bitmap dl(com.bytedance.sdk.component.m.dl.dl dlVar) {
        return dlVar.wp().z(dlVar.i()).z(dlVar.getMemoryCacheKey());
    }
}
