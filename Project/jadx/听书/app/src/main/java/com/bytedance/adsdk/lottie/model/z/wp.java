package com.bytedance.adsdk.lottie.model.z;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.z.g.ls;

/* JADX INFO: loaded from: classes2.dex */
public class wp implements com.bytedance.adsdk.lottie.model.g.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f189a;
    private final e dl;
    private final g e;
    private final g fo;
    private final i<PointF, PointF> g;
    private final a gc;
    private final g gz;
    private final g m;
    private final gc z;

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return null;
    }

    public wp() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public wp(gc gcVar, i<PointF, PointF> iVar, e eVar, g gVar, a aVar, g gVar2, g gVar3, g gVar4, g gVar5) {
        this.z = gcVar;
        this.g = iVar;
        this.dl = eVar;
        this.f189a = gVar;
        this.gc = aVar;
        this.gz = gVar2;
        this.fo = gVar3;
        this.m = gVar4;
        this.e = gVar5;
    }

    public gc z() {
        return this.z;
    }

    public i<PointF, PointF> g() {
        return this.g;
    }

    public e dl() {
        return this.dl;
    }

    public g a() {
        return this.f189a;
    }

    public a gc() {
        return this.gc;
    }

    public g m() {
        return this.gz;
    }

    public g e() {
        return this.fo;
    }

    public g gz() {
        return this.m;
    }

    public g fo() {
        return this.e;
    }

    public ls uy() {
        return new ls(this);
    }
}
