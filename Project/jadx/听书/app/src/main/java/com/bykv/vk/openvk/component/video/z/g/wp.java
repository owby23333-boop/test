package com.bykv.vk.openvk.component.video.z.g;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f117a;
    private final ArrayList<z> dl;
    private final int e;
    private int gc = -1;
    private int m;
    private static final Set<String> z = new HashSet();
    private static final Set<String> g = new HashSet();

    wp(List<String> list) {
        int iIntValue;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.f117a = size;
        this.dl = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            z zVar = new z(str);
            if (z.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(zVar);
            } else if (g.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(zVar);
            } else {
                this.dl.add(zVar);
            }
        }
        if (arrayList != null) {
            this.dl.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.dl.addAll(arrayList2);
        }
        Integer num = gc.fo;
        if (num == null || num.intValue() <= 0) {
            iIntValue = this.f117a >= 2 ? 1 : 2;
        } else {
            iIntValue = num.intValue();
        }
        this.e = iIntValue;
    }

    wp(String str) {
        ArrayList<z> arrayList = new ArrayList<>(1);
        this.dl = arrayList;
        arrayList.add(new z(str));
        this.f117a = 1;
        this.e = 1;
    }

    boolean z() {
        return this.m < this.e;
    }

    z g() {
        if (!z()) {
            throw new NoSuchElementException();
        }
        int i = this.gc + 1;
        if (i >= this.f117a - 1) {
            this.gc = -1;
            this.m++;
        } else {
            this.gc = i;
        }
        z zVar = this.dl.get(i);
        zVar.g = (this.m * this.f117a) + this.gc;
        return zVar;
    }

    public class z {
        int g;
        final String z;

        z(String str) {
            this.z = str;
        }

        void z() {
            wp.z.add(this.z);
        }

        void g() {
            wp.g.add(this.z);
        }

        public String toString() {
            return this.z;
        }
    }
}
