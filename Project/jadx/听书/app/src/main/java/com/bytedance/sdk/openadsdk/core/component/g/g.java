package com.bytedance.sdk.openadsdk.core.component.g;

import com.bytedance.sdk.openadsdk.core.component.dl.dl;
import com.bytedance.sdk.openadsdk.core.gc.g;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.dl.g.fo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.openadsdk.core.gc.g<List<fo>> {
    @Override // com.bytedance.sdk.openadsdk.core.gc.g
    protected /* bridge */ /* synthetic */ void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List list, List<fo> list2) {
        z2(gVar, (List<na>) list, list2);
    }

    public g(com.bytedance.sdk.openadsdk.core.gc.gc.g gVar) {
        super(gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, g.z<List<fo>> zVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<na> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new dl(zw.getContext(), it.next(), 9, gVar));
        }
        if (zVar != null) {
            zVar.z(arrayList);
        }
    }

    /* JADX INFO: renamed from: z, reason: avoid collision after fix types in other method */
    protected void z2(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, List<fo> list2) {
        for (int i = 0; i < list2.size(); i++) {
            na naVar = list.get(i);
            fo foVar = list2.get(i);
            if (this.z != null) {
                this.z.z().z(gVar, naVar, foVar, false);
            }
        }
    }
}
