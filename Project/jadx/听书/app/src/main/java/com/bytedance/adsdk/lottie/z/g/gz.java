package com.bytedance.adsdk.lottie.z.g;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private final List<com.bytedance.adsdk.lottie.model.g.gz> dl;
    private final List<z<Integer, Integer>> g;
    private final List<z<com.bytedance.adsdk.lottie.model.g.v, Path>> z;

    public gz(List<com.bytedance.adsdk.lottie.model.g.gz> list) {
        this.dl = list;
        this.z = new ArrayList(list.size());
        this.g = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.z.add(list.get(i).g().z());
            this.g.add(list.get(i).dl().z());
        }
    }

    public List<com.bytedance.adsdk.lottie.model.g.gz> z() {
        return this.dl;
    }

    public List<z<com.bytedance.adsdk.lottie.model.g.v, Path>> g() {
        return this.z;
    }

    public List<z<Integer, Integer>> dl() {
        return this.g;
    }
}
