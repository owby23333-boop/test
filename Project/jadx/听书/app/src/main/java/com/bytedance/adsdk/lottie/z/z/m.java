package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.g.js;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m implements z.InterfaceC0041z, i, kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.z.g.z<?, PointF> f211a;
    private final com.bytedance.adsdk.lottie.gz dl;
    private final String g;
    private final com.bytedance.adsdk.lottie.z.g.z<?, PointF> gc;
    private boolean gz;
    private final com.bytedance.adsdk.lottie.model.g.g m;
    private final Path z = new Path();
    private final g e = new g();

    public m(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.g gVar) {
        this.g = gVar.z();
        this.dl = gzVar;
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ = gVar.dl().z();
        this.f211a = zVarZ;
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ2 = gVar.g().z();
        this.gc = zVarZ2;
        this.m = gVar;
        dlVar.z(zVarZ);
        dlVar.z(zVarZ2);
        zVarZ.z(this);
        zVarZ2.z(this);
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        g();
    }

    private void g() {
        this.gz = false;
        this.dl.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
        for (int i = 0; i < list.size(); i++) {
            dl dlVar = list.get(i);
            if (dlVar instanceof q) {
                q qVar = (q) dlVar;
                if (qVar.getType() == js.z.SIMULTANEOUSLY) {
                    this.e.z(qVar);
                    qVar.z(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.z.i
    public Path a() {
        if (this.gz) {
            return this.z;
        }
        this.z.reset();
        if (this.m.gc()) {
            this.gz = true;
            return this.z;
        }
        PointF pointFE = this.f211a.e();
        float f = pointFE.x / 2.0f;
        float f2 = pointFE.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.z.reset();
        if (this.m.a()) {
            float f5 = -f2;
            this.z.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.z.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.z.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.z.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.z.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.z.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.z.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.z.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.z.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.z.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFE2 = this.gc.e();
        this.z.offset(pointFE2.x, pointFE2.y);
        this.z.close();
        this.e.z(this.z);
        this.gz = true;
        return this.z;
    }
}
