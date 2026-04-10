package com.bytedance.pangle.util.g.g;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private List<dl> z = new ArrayList();

    public List<dl> z() {
        return this.z;
    }

    public void z(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (dl dlVar : this.z) {
            if (!set.contains(dlVar.wp())) {
                arrayList.add(dlVar);
            }
        }
        this.z = arrayList;
    }

    public void z(List<dl> list) {
        this.z = list;
    }
}
