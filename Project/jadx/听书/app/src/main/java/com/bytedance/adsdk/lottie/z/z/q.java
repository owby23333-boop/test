package com.bytedance.adsdk.lottie.z.z;

import com.bytedance.adsdk.lottie.model.g.js;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class q implements z.InterfaceC0041z, dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final js.z f214a;
    private final List<z.InterfaceC0041z> dl = new ArrayList();
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> e;
    private final boolean g;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> gc;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> m;
    private final String z;

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
    }

    public q(com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.js jsVar) {
        this.z = jsVar.z();
        this.g = jsVar.gc();
        this.f214a = jsVar.getType();
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ = jsVar.dl().z();
        this.gc = zVarZ;
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ2 = jsVar.g().z();
        this.m = zVarZ2;
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ3 = jsVar.a().z();
        this.e = zVarZ3;
        dlVar.z(zVarZ);
        dlVar.z(zVarZ2);
        dlVar.z(zVarZ3);
        zVarZ.z(this);
        zVarZ2.z(this);
        zVarZ3.z(this);
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        for (int i = 0; i < this.dl.size(); i++) {
            this.dl.get(i).z();
        }
    }

    void z(z.InterfaceC0041z interfaceC0041z) {
        this.dl.add(interfaceC0041z);
    }

    js.z getType() {
        return this.f214a;
    }

    public com.bytedance.adsdk.lottie.z.g.z<?, Float> g() {
        return this.gc;
    }

    public com.bytedance.adsdk.lottie.z.g.z<?, Float> dl() {
        return this.m;
    }

    public com.bytedance.adsdk.lottie.z.g.z<?, Float> a() {
        return this.e;
    }

    public boolean gc() {
        return this.g;
    }
}
