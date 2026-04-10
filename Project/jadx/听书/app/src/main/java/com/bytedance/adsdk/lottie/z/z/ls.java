package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class ls implements z.InterfaceC0041z, gc, i, kb, uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.layer.dl f210a;
    private final com.bytedance.adsdk.lottie.gz dl;
    private final com.bytedance.adsdk.lottie.z.g.z<Float, Float> e;
    private final com.bytedance.adsdk.lottie.z.g.ls fo;
    private final String gc;
    private final com.bytedance.adsdk.lottie.z.g.z<Float, Float> gz;
    private final boolean m;
    private a uy;
    private final Matrix z = new Matrix();
    private final Path g = new Path();

    public ls(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.wp wpVar) {
        this.dl = gzVar;
        this.f210a = dlVar;
        this.gc = wpVar.z();
        this.m = wpVar.gc();
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ = wpVar.g().z();
        this.e = zVarZ;
        dlVar.z(zVarZ);
        zVarZ.z(this);
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ2 = wpVar.dl().z();
        this.gz = zVarZ2;
        dlVar.z(zVarZ2);
        zVarZ2.z(this);
        com.bytedance.adsdk.lottie.z.g.ls lsVarUy = wpVar.a().uy();
        this.fo = lsVarUy;
        lsVarUy.z(dlVar);
        lsVarUy.z(this);
    }

    @Override // com.bytedance.adsdk.lottie.z.z.uy
    public void z(ListIterator<dl> listIterator) {
        if (this.uy != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.uy = new a(this.dl, this.f210a, "Repeater", this.m, arrayList, null);
    }

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
        this.uy.z(list, list2);
    }

    @Override // com.bytedance.adsdk.lottie.z.z.i
    public Path a() {
        Path pathA = this.uy.a();
        this.g.reset();
        float fFloatValue = this.e.e().floatValue();
        float fFloatValue2 = this.gz.e().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.z.set(this.fo.g(i + fFloatValue2));
            this.g.addPath(pathA, this.z);
        }
        return this.g;
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.e.e().floatValue();
        float fFloatValue2 = this.gz.e().floatValue();
        float fFloatValue3 = this.fo.g().e().floatValue() / 100.0f;
        float fFloatValue4 = this.fo.dl().e().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.z.set(matrix);
            float f = i2;
            this.z.preConcat(this.fo.g(f + fFloatValue2));
            this.uy.z(canvas, this.z, (int) (i * com.bytedance.adsdk.lottie.gc.gz.z(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        this.uy.z(rectF, matrix, z);
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        this.dl.invalidateSelf();
    }
}
