package com.bytedance.adsdk.lottie.model.g;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> f178a;
    private final com.bytedance.adsdk.lottie.model.z.g dl;
    private final com.bytedance.adsdk.lottie.model.z.g e;
    private final com.bytedance.adsdk.lottie.model.z.g fo;
    private final z g;
    private final com.bytedance.adsdk.lottie.model.z.g gc;
    private final com.bytedance.adsdk.lottie.model.z.g gz;
    private final boolean kb;
    private final com.bytedance.adsdk.lottie.model.z.g m;
    private final boolean uy;
    private final String z;

    public enum z {
        STAR(1),
        POLYGON(2);

        private final int dl;

        z(int i) {
            this.dl = i;
        }

        public static z z(int i) {
            for (z zVar : values()) {
                if (zVar.dl == i) {
                    return zVar;
                }
            }
            return null;
        }
    }

    public uy(String str, z zVar, com.bytedance.adsdk.lottie.model.z.g gVar, com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVar, com.bytedance.adsdk.lottie.model.z.g gVar2, com.bytedance.adsdk.lottie.model.z.g gVar3, com.bytedance.adsdk.lottie.model.z.g gVar4, com.bytedance.adsdk.lottie.model.z.g gVar5, com.bytedance.adsdk.lottie.model.z.g gVar6, boolean z2, boolean z3) {
        this.z = str;
        this.g = zVar;
        this.dl = gVar;
        this.f178a = iVar;
        this.gc = gVar2;
        this.m = gVar3;
        this.e = gVar4;
        this.gz = gVar5;
        this.fo = gVar6;
        this.uy = z2;
        this.kb = z3;
    }

    public String z() {
        return this.z;
    }

    public z getType() {
        return this.g;
    }

    public com.bytedance.adsdk.lottie.model.z.g g() {
        return this.dl;
    }

    public com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> dl() {
        return this.f178a;
    }

    public com.bytedance.adsdk.lottie.model.z.g a() {
        return this.gc;
    }

    public com.bytedance.adsdk.lottie.model.z.g gc() {
        return this.m;
    }

    public com.bytedance.adsdk.lottie.model.z.g m() {
        return this.e;
    }

    public com.bytedance.adsdk.lottie.model.z.g e() {
        return this.gz;
    }

    public com.bytedance.adsdk.lottie.model.z.g gz() {
        return this.fo;
    }

    public boolean fo() {
        return this.uy;
    }

    public boolean uy() {
        return this.kb;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.v(gzVar, dlVar, this);
    }
}
