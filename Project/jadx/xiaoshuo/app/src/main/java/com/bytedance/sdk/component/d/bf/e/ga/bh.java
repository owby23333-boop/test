package com.bytedance.sdk.component.d.bf.e.ga;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface bh {
    public static final bh e = new bh() { // from class: com.bytedance.sdk.component.d.bf.e.ga.bh.1
        @Override // com.bytedance.sdk.component.d.bf.e.ga.bh
        public void e(int i, bf bfVar) {
        }

        @Override // com.bytedance.sdk.component.d.bf.e.ga.bh
        public boolean e(int i, List<d> list) {
            return true;
        }

        @Override // com.bytedance.sdk.component.d.bf.e.ga.bh
        public boolean e(int i, List<d> list, boolean z) {
            return true;
        }

        @Override // com.bytedance.sdk.component.d.bf.e.ga.bh
        public boolean e(int i, com.bytedance.sdk.component.d.e.ga gaVar, int i2, boolean z) throws IOException {
            gaVar.v(i2);
            return true;
        }
    };

    void e(int i, bf bfVar);

    boolean e(int i, com.bytedance.sdk.component.d.e.ga gaVar, int i2, boolean z) throws IOException;

    boolean e(int i, List<d> list);

    boolean e(int i, List<d> list, boolean z);
}
