package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.model.layer.gz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends dl {
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> e;
    private final RectF fo;
    private final List<dl> gz;
    private final Paint kb;
    private final RectF uy;
    private boolean wp;

    public a(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2, List<gz> list, com.bytedance.adsdk.lottie.m mVar, Context context) {
        int i;
        dl dlVar;
        gz.g gVarWp;
        int i2;
        super(gzVar, gzVar2);
        this.gz = new ArrayList();
        this.fo = new RectF();
        this.uy = new RectF();
        this.kb = new Paint();
        this.wp = true;
        com.bytedance.adsdk.lottie.model.z.g gVarQ = gzVar2.q();
        if (gVarQ != null) {
            com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ = gVarQ.z();
            this.e = zVarZ;
            z(zVarZ);
            this.e.z(this);
        } else {
            this.e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(mVar.v().size());
        int size = list.size() - 1;
        dl dlVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            gz gzVar3 = list.get(size);
            dl dlVarZ = dl.z(this, gzVar3, gzVar, mVar, context);
            if (dlVarZ != null) {
                longSparseArray.put(dlVarZ.a().gc(), dlVarZ);
                if (dlVar2 != null) {
                    dlVar2.z(dlVarZ);
                    dlVar2 = null;
                } else {
                    this.gz.add(0, dlVarZ);
                    if (gzVar3 != null && (gVarWp = gzVar3.wp()) != null && ((i2 = AnonymousClass1.z[gVarWp.ordinal()]) == 1 || i2 == 2)) {
                        dlVar2 = dlVarZ;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            dl dlVar3 = (dl) longSparseArray.get(longSparseArray.keyAt(i));
            if (dlVar3 != null && (dlVar = (dl) longSparseArray.get(dlVar3.a().i())) != null) {
                dlVar3.g(dlVar);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[gz.g.values().length];
            z = iArr;
            try {
                iArr[gz.g.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[gz.g.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void g(boolean z) {
        this.wp = z;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public void z(boolean z) {
        super.z(z);
        Iterator<dl> it = this.gz.iterator();
        while (it.hasNext()) {
            it.next().z(z);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        super.g(canvas, matrix, i);
        com.bytedance.adsdk.lottie.gc.z("CompositionLayer#draw");
        this.uy.set(0.0f, 0.0f, this.dl.gz(), this.dl.fo());
        matrix.mapRect(this.uy);
        boolean z = this.g.uy() && this.gz.size() > 1 && i != 255;
        if (z) {
            this.kb.setAlpha(i);
            com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.uy, this.kb);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.gz.size() - 1; size >= 0; size--) {
            if (((!this.wp && "__container".equals(this.dl.m())) || this.uy.isEmpty()) ? true : canvas.clipRect(this.uy)) {
                this.gz.get(size).z(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.lottie.gc.g("CompositionLayer#draw");
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl, com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        super.z(rectF, matrix, z);
        for (int size = this.gz.size() - 1; size >= 0; size--) {
            this.fo.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.gz.get(size).z(this.fo, this.z, true);
            rectF.union(this.fo);
        }
    }

    public List<dl> v() {
        return this.gz;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.dl
    public void z(float f) {
        super.z(f);
        if (this.e != null) {
            f = ((this.e.e().floatValue() * this.dl.z().i()) - this.dl.z().m()) / (this.g.hh().fv() + 0.01f);
        }
        if (this.e == null) {
            f -= this.dl.dl();
        }
        if (this.dl.g() != 0.0f && !"__container".equals(this.dl.m())) {
            f /= this.dl.g();
        }
        for (int size = this.gz.size() - 1; size >= 0; size--) {
            this.gz.get(size).z(f);
        }
    }
}
