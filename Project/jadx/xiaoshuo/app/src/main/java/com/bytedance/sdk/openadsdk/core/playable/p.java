package com.bytedance.sdk.openadsdk.core.playable;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class p extends com.bytedance.sdk.openadsdk.core.v.bf {
    public p(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.v.bf, com.bytedance.sdk.openadsdk.core.v.e
    public void e(List<File> list) {
        int size = list.size();
        if (e(0L, size)) {
            return;
        }
        for (File file : list) {
            com.bytedance.sdk.component.utils.vn.d(file);
            size--;
            if (e(file, 0L, size)) {
                return;
            }
        }
    }
}
