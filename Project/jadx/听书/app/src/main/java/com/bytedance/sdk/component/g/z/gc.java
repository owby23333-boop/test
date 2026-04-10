package com.bytedance.sdk.component.g.z;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class gc extends pf {
    List<String> g;
    List<String> z;

    gc(List<String> list, List<String> list2) {
        this.z = list;
        this.g = list2;
    }

    public static final class z {
        private final List<String> z = new ArrayList();
        private final List<String> g = new ArrayList();

        public z z(String str, String str2) {
            this.z.add(str);
            this.g.add(str2);
            return this;
        }

        public gc z() {
            return new gc(this.z, this.g);
        }
    }
}
