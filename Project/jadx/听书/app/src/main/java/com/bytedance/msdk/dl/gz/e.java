package com.bytedance.msdk.dl.gz;

import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gz.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean dl(int i) {
        return i == -100;
    }

    public static boolean g(int i) {
        return i == 0;
    }

    public static boolean z(int i) {
        return i >= -299 && i < -100;
    }

    public static boolean z(int i, List<Integer> list) {
        if (h.z(list) || i >= list.size() || list.get(i).intValue() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2).intValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static int z(com.bytedance.msdk.core.uy.g gVar, uy uyVar) {
        if (gVar == null || uyVar == null) {
            return -999;
        }
        if (gVar.wp() && uyVar.ti()) {
            return uyVar.uf();
        }
        return uyVar.io();
    }

    public static int z(com.bytedance.msdk.core.uy.g gVar, com.bytedance.msdk.g.dl dlVar) {
        if (gVar == null || dlVar == null) {
            return -999;
        }
        if (gVar.wp() && dlVar.cb()) {
            return dlVar.dt();
        }
        return dlVar.xo();
    }

    public static Map<Integer, List<uy>> z(List<uy> list, boolean z) {
        int iIo;
        HashMap map = new HashMap();
        if (h.z(list)) {
            return map;
        }
        for (int i = 0; i < list.size(); i++) {
            uy uyVar = list.get(i);
            if (uyVar != null) {
                if (z && uyVar.ti()) {
                    iIo = uyVar.uf();
                } else {
                    iIo = uyVar.io();
                }
                List arrayList = (List) map.get(Integer.valueOf(iIo));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(uyVar);
                map.put(Integer.valueOf(iIo), arrayList);
            }
        }
        return map;
    }

    public static List<uy> z(List<uy> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (uy uyVar : list) {
            if (uyVar != null && uyVar.js() == 100) {
                arrayList.add(uyVar);
            }
        }
        return arrayList;
    }

    public static List<uy> g(List<uy> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (uy uyVar : list) {
            if (uyVar != null && uyVar.js() == 0) {
                arrayList.add(uyVar);
            }
        }
        return arrayList;
    }

    public static List<uy> dl(List<uy> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (uy uyVar : list) {
            if (uyVar != null && (uyVar.js() == 1 || uyVar.js() == 3)) {
                arrayList.add(uyVar);
            }
        }
        return arrayList;
    }
}
