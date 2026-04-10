package com.bytedance.adsdk.lottie.z.g;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.z.z.js;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i extends z<com.bytedance.adsdk.lottie.model.g.v, Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.g.v f196a;
    private final Path gc;
    private List<js> m;

    public i(List<com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.v>> list) {
        super(list);
        this.f196a = new com.bytedance.adsdk.lottie.model.g.v();
        this.gc = new Path();
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Path z(com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.v> zVar, float f) {
        this.f196a.z(zVar.z, zVar.g, f);
        com.bytedance.adsdk.lottie.model.g.v vVarZ = this.f196a;
        List<js> list = this.m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                vVarZ = this.m.get(size).z(vVarZ);
            }
        }
        com.bytedance.adsdk.lottie.gc.gz.z(vVarZ, this.gc);
        return this.gc;
    }

    public void z(List<js> list) {
        this.m = list;
    }
}
