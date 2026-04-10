package com.bytedance.sdk.openadsdk.core.playable;

import com.bytedance.sdk.component.utils.m;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.core.uy.g {
    public a(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.uy.g, com.bytedance.sdk.openadsdk.core.uy.z
    protected void z(List<File> list) {
        int size = list.size();
        if (z(0L, size)) {
            return;
        }
        for (File file : list) {
            m.dl(file);
            size--;
            if (z(file, 0L, size)) {
                return;
            }
        }
    }
}
