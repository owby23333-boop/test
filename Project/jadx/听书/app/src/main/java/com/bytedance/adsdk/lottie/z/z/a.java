package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements z.InterfaceC0041z, gc, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f205a;
    private final Matrix dl;
    private final boolean e;
    private final com.bytedance.adsdk.lottie.gz fo;
    private final RectF g;
    private final RectF gc;
    private final List<dl> gz;
    private com.bytedance.adsdk.lottie.z.g.ls kb;
    private final String m;
    private List<i> uy;
    private final Paint z;

    private static List<dl> z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, List<com.bytedance.adsdk.lottie.model.g.dl> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            dl dlVarZ = list.get(i).z(gzVar, mVar, dlVar);
            if (dlVarZ != null) {
                arrayList.add(dlVarZ);
            }
        }
        return arrayList;
    }

    static com.bytedance.adsdk.lottie.model.z.wp z(List<com.bytedance.adsdk.lottie.model.g.dl> list) {
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.adsdk.lottie.model.g.dl dlVar = list.get(i);
            if (dlVar instanceof com.bytedance.adsdk.lottie.model.z.wp) {
                return (com.bytedance.adsdk.lottie.model.z.wp) dlVar;
            }
        }
        return null;
    }

    public a(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.ls lsVar, com.bytedance.adsdk.lottie.m mVar) {
        this(gzVar, dlVar, lsVar.z(), lsVar.dl(), z(gzVar, mVar, dlVar, lsVar.g()), z(lsVar.g()));
    }

    a(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, String str, boolean z, List<dl> list, com.bytedance.adsdk.lottie.model.z.wp wpVar) {
        this.z = new com.bytedance.adsdk.lottie.z.z();
        this.g = new RectF();
        this.dl = new Matrix();
        this.f205a = new Path();
        this.gc = new RectF();
        this.m = str;
        this.fo = gzVar;
        this.e = z;
        this.gz = list;
        if (wpVar != null) {
            com.bytedance.adsdk.lottie.z.g.ls lsVarUy = wpVar.uy();
            this.kb = lsVarUy;
            lsVarUy.z(dlVar);
            this.kb.z(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            dl dlVar2 = list.get(size);
            if (dlVar2 instanceof uy) {
                arrayList.add((uy) dlVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((uy) arrayList.get(size2)).z(list.listIterator(list.size()));
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        this.fo.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.gz.size());
        arrayList.addAll(list);
        for (int size = this.gz.size() - 1; size >= 0; size--) {
            dl dlVar = this.gz.get(size);
            dlVar.z(arrayList, this.gz.subList(0, size));
            arrayList.add(dlVar);
        }
    }

    List<i> g() {
        if (this.uy == null) {
            this.uy = new ArrayList();
            for (int i = 0; i < this.gz.size(); i++) {
                dl dlVar = this.gz.get(i);
                if (dlVar instanceof i) {
                    this.uy.add((i) dlVar);
                }
            }
        }
        return this.uy;
    }

    Matrix dl() {
        com.bytedance.adsdk.lottie.z.g.ls lsVar = this.kb;
        if (lsVar != null) {
            return lsVar.a();
        }
        this.dl.reset();
        return this.dl;
    }

    @Override // com.bytedance.adsdk.lottie.z.z.i
    public Path a() {
        this.dl.reset();
        com.bytedance.adsdk.lottie.z.g.ls lsVar = this.kb;
        if (lsVar != null) {
            this.dl.set(lsVar.a());
        }
        this.f205a.reset();
        if (this.e) {
            return this.f205a;
        }
        for (int size = this.gz.size() - 1; size >= 0; size--) {
            dl dlVar = this.gz.get(size);
            if (dlVar instanceof i) {
                this.f205a.addPath(((i) dlVar).a(), this.dl);
            }
        }
        return this.f205a;
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        this.dl.set(matrix);
        com.bytedance.adsdk.lottie.z.g.ls lsVar = this.kb;
        if (lsVar != null) {
            this.dl.preConcat(lsVar.a());
            i = (int) (((((this.kb.z() == null ? 100 : this.kb.z().e().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.fo.uy() && gc() && i != 255;
        if (z) {
            this.g.set(0.0f, 0.0f, 0.0f, 0.0f);
            z(this.g, this.dl, true);
            this.z.setAlpha(i);
            com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.g, this.z);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.gz.size() - 1; size >= 0; size--) {
            dl dlVar = this.gz.get(size);
            if (dlVar instanceof gc) {
                ((gc) dlVar).z(canvas, this.dl, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean gc() {
        int i = 0;
        for (int i2 = 0; i2 < this.gz.size(); i2++) {
            if ((this.gz.get(i2) instanceof gc) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        this.dl.set(matrix);
        com.bytedance.adsdk.lottie.z.g.ls lsVar = this.kb;
        if (lsVar != null) {
            this.dl.preConcat(lsVar.a());
        }
        this.gc.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.gz.size() - 1; size >= 0; size--) {
            dl dlVar = this.gz.get(size);
            if (dlVar instanceof gc) {
                ((gc) dlVar).z(this.gc, this.dl, z);
                rectF.union(this.gc);
            }
        }
    }
}
