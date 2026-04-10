package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final List<q> z = new ArrayList();

    void z(q qVar) {
        this.z.add(qVar);
    }

    public void z(Path path) {
        for (int size = this.z.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.lottie.gc.fo.z(path, this.z.get(size));
        }
    }
}
