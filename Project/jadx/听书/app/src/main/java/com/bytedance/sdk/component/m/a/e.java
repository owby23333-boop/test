package com.bytedance.sdk.component.m.a;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e extends z {
    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "check_duplicate";
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        List<com.bytedance.sdk.component.m.dl.dl> linkedList;
        String strLs = dlVar.ls();
        Map<String, List<com.bytedance.sdk.component.m.dl.dl>> mapE = dlVar.wp().e();
        synchronized (mapE) {
            linkedList = mapE.get(strLs);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(dlVar);
            mapE.put(strLs, linkedList);
            if (linkedList.size() <= 1) {
                dlVar.z(new a());
            }
        }
    }
}
