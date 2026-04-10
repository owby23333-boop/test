package com.bytedance.adsdk.lottie.e.e;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private final List<pe> e = new ArrayList();

    public void e(pe peVar) {
        this.e.add(peVar);
    }

    public void e(Path path) {
        for (int size = this.e.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.lottie.vn.v.e(path, this.e.get(size));
        }
    }
}
