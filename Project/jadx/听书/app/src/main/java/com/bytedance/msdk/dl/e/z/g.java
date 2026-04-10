package com.bytedance.msdk.dl.e.z;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.dl.gz.e;
import com.bytedance.msdk.gz.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z {
    @Override // com.bytedance.msdk.dl.e.z.z
    public boolean z(com.bytedance.msdk.dl.m.z.g gVar, com.bytedance.msdk.g.dl dlVar, List<uy> list) {
        if (dlVar == null || gVar == null) {
            return false;
        }
        if (gVar.i().m(e.z(gVar.wp(), dlVar)) == 0) {
            return true;
        }
        return z(dlVar, list);
    }

    protected boolean z(com.bytedance.msdk.g.dl dlVar, List<uy> list) {
        if (dlVar == null || TextUtils.isEmpty(dlVar.yz()) || !dlVar.cb() || h.z(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !h.g(arrayList) && dlVar.yz().equals(((uy) arrayList.get(0)).fv());
    }
}
