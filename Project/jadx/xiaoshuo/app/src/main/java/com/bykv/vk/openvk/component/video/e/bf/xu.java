package com.bykv.vk.openvk.component.video.e.bf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class xu {
    private final ArrayList<e> d;
    private int ga = -1;
    private final int p;
    private final int tg;
    private int vn;
    private static final Set<String> e = new HashSet();
    private static final Set<String> bf = new HashSet();

    public class e {
        int bf;
        final String e;

        public e(String str) {
            this.e = str;
        }

        public void bf() {
            xu.bf.add(this.e);
        }

        public void e() {
            xu.e.add(this.e);
        }

        public String toString() {
            return this.e;
        }
    }

    public xu(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.tg = size;
        this.d = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            e eVar = new e(str);
            if (e.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(eVar);
            } else if (bf.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(eVar);
            } else {
                this.d.add(eVar);
            }
        }
        if (arrayList != null) {
            this.d.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.d.addAll(arrayList2);
        }
        Integer num = ga.zk;
        this.p = (num == null || num.intValue() <= 0) ? this.tg >= 2 ? 1 : 2 : num.intValue();
    }

    public e bf() {
        if (!e()) {
            throw new NoSuchElementException();
        }
        int i = this.ga + 1;
        if (i >= this.tg - 1) {
            this.ga = -1;
            this.vn++;
        } else {
            this.ga = i;
        }
        e eVar = this.d.get(i);
        eVar.bf = (this.vn * this.tg) + this.ga;
        return eVar;
    }

    public boolean e() {
        return this.vn < this.p;
    }

    public xu(String str) {
        ArrayList<e> arrayList = new ArrayList<>(1);
        this.d = arrayList;
        arrayList.add(new e(str));
        this.tg = 1;
        this.p = 1;
    }
}
