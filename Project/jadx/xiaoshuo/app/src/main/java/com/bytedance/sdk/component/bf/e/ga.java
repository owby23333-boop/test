package com.bytedance.sdk.component.bf.e;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ga extends t {
    List<String> bf;
    List<String> e;

    public ga(List<String> list, List<String> list2) {
        this.e = list;
        this.bf = list2;
    }

    public static final class e {
        private final List<String> e = new ArrayList();
        private final List<String> bf = new ArrayList();

        public e e(String str, String str2) {
            this.e.add(str);
            this.bf.add(str2);
            return this;
        }

        public ga e() {
            return new ga(this.e, this.bf);
        }
    }
}
