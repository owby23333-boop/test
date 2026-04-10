package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static Map<Integer, List<j>> a(List<j> list) {
        List arrayList;
        int iY;
        if (list == null || list.size() == 0) {
            return null;
        }
        k0.a(list);
        HashMap map = new HashMap();
        int i2 = -1000;
        for (int i3 = 0; i3 < list.size(); i3++) {
            j jVar = list.get(i3);
            if (jVar != null) {
                if (jVar.f() == 100 || jVar.f() == 0) {
                    arrayList = new ArrayList();
                    iY = jVar.y();
                } else if (jVar.p() != i2) {
                    arrayList = new ArrayList();
                    iY = jVar.p();
                } else {
                    iY = i2;
                    arrayList = (List) map.get(Integer.valueOf(i2));
                }
                if (arrayList != null) {
                    arrayList.add(jVar);
                    map.put(Integer.valueOf(iY), arrayList);
                }
                i2 = iY;
            }
        }
        return map;
    }

    public static Map<Integer, List<j>> b(List<j> list) {
        List arrayList;
        if (list == null || list.size() == 0) {
            return null;
        }
        k0.a(list);
        HashMap map = new HashMap();
        int iP = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            j jVar = list.get(i2);
            if (jVar != null) {
                if (jVar.p() != iP) {
                    arrayList = new ArrayList();
                    iP = jVar.p();
                } else {
                    arrayList = (List) map.get(Integer.valueOf(iP));
                }
                if (arrayList != null) {
                    arrayList.add(jVar);
                    map.put(Integer.valueOf(iP), arrayList);
                }
            }
        }
        return map;
    }
}
