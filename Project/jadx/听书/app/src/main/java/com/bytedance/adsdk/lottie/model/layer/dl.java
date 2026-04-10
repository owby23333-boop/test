package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.model.g.gz;
import com.bytedance.adsdk.lottie.model.layer.gz;
import com.bytedance.adsdk.lottie.z.g.ls;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl implements z.InterfaceC0041z, com.bytedance.adsdk.lottie.z.z.gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ls f182a;
    final gz dl;
    private final RectF fv;
    final com.bytedance.adsdk.lottie.gz g;
    float gc;
    private boolean gk;
    private boolean gz;
    private boolean h;
    private List<dl> hh;
    private com.bytedance.adsdk.lottie.z.g.a io;
    private final String iq;
    private final RectF js;
    private final List<com.bytedance.adsdk.lottie.z.g.z<?, ?>> l;
    private final Matrix lq;
    private final Paint ls;
    BlurMaskFilter m;
    private float mc;
    private final RectF p;
    private final Paint pf;
    private final RectF q;
    private dl sy;
    private final RectF tb;
    private dl uf;
    private Paint x;
    final Matrix z;
    private com.bytedance.adsdk.lottie.z.g.gz zw;
    private final Handler e = new Handler(Looper.getMainLooper());
    private final Path fo = new Path();
    private final Matrix uy = new Matrix();
    private final Matrix kb = new Matrix();
    private final Paint wp = new com.bytedance.adsdk.lottie.z.z(1);
    private final Paint i = new com.bytedance.adsdk.lottie.z.z(1, PorterDuff.Mode.DST_IN);
    private final Paint v = new com.bytedance.adsdk.lottie.z.z(1, PorterDuff.Mode.DST_OUT);

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<com.bytedance.adsdk.lottie.z.z.dl> list, List<com.bytedance.adsdk.lottie.z.z.dl> list2) {
    }

    public boolean g() {
        return this.gz;
    }

    public void dl() {
        this.gz = true;
    }

    public void z(Runnable runnable) {
        this.e.post(runnable);
    }

    static dl z(a aVar, gz gzVar, com.bytedance.adsdk.lottie.gz gzVar2, com.bytedance.adsdk.lottie.m mVar, Context context) {
        switch (AnonymousClass2.z[gzVar.kb().ordinal()]) {
            case 1:
                return new uy(gzVar2, gzVar, aVar, mVar);
            case 2:
                return new a(gzVar2, gzVar, mVar.g(gzVar.e()), mVar, context);
            case 3:
                return new kb(gzVar2, gzVar);
            case 4:
                if (z(gzVar2, gzVar, "text:")) {
                    return new m(gzVar2, gzVar, context);
                }
                if (z(gzVar2, gzVar, "videoview:")) {
                    fo.z zVarZ = z(gzVar2, gzVar);
                    if (zVarZ != null) {
                        if (zVarZ.z != null && zVarZ.z.z > 0.0f) {
                            return new gc(gzVar2, gzVar, context, zVarZ.z);
                        }
                        if (zVarZ.g) {
                            return new g(gzVar2, gzVar, context);
                        }
                        return new v(gzVar2, gzVar, context);
                    }
                    return new v(gzVar2, gzVar, context);
                }
                if (z(gzVar2, gzVar, "animview:")) {
                    return new z(gzVar2, gzVar, context);
                }
                if (z(gzVar2, gzVar, "view:")) {
                    return new i(gzVar2, gzVar, context);
                }
                return new e(gzVar2, gzVar);
            case 5:
                return new fo(gzVar2, gzVar);
            case 6:
                return new wp(gzVar2, gzVar);
            default:
                com.bytedance.adsdk.lottie.gc.gc.g("Unknown layer type " + gzVar.kb());
                return null;
        }
    }

    private static fo.z z(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2) {
        com.bytedance.adsdk.lottie.fo foVarM;
        if (gzVar == null || gzVar2 == null || (foVarM = gzVar.m(gzVar2.e())) == null) {
            return null;
        }
        return foVarM.uy();
    }

    private static boolean z(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2, String str) {
        com.bytedance.adsdk.lottie.fo foVarM;
        if (gzVar == null || gzVar2 == null || str == null || (foVarM = gzVar.m(gzVar2.e())) == null) {
            return false;
        }
        return str.equals(foVarM.i());
    }

    dl(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2) {
        com.bytedance.adsdk.lottie.z.z zVar = new com.bytedance.adsdk.lottie.z.z(1);
        this.pf = zVar;
        this.ls = new com.bytedance.adsdk.lottie.z.z(PorterDuff.Mode.CLEAR);
        this.p = new RectF();
        this.fv = new RectF();
        this.js = new RectF();
        this.tb = new RectF();
        this.q = new RectF();
        this.z = new Matrix();
        this.l = new ArrayList();
        this.h = true;
        this.gc = 0.0f;
        this.lq = new Matrix();
        this.mc = 1.0f;
        this.g = gzVar;
        this.dl = gzVar2;
        this.iq = gzVar2.m() + "#draw";
        if (gzVar2.wp() == gz.g.INVERT) {
            zVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            zVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        ls lsVarUy = gzVar2.pf().uy();
        this.f182a = lsVarUy;
        lsVarUy.z((z.InterfaceC0041z) this);
        if (gzVar2.uy() != null && !gzVar2.uy().isEmpty()) {
            com.bytedance.adsdk.lottie.z.g.gz gzVar3 = new com.bytedance.adsdk.lottie.z.g.gz(gzVar2.uy());
            this.zw = gzVar3;
            Iterator<com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.v, Path>> it = gzVar3.g().iterator();
            while (it.hasNext()) {
                it.next().z(this);
            }
            for (com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar2 : this.zw.dl()) {
                z(zVar2);
                zVar2.z(this);
            }
        }
        v();
    }

    void z(boolean z) {
        if (z && this.x == null) {
            this.x = new com.bytedance.adsdk.lottie.z.z();
        }
        this.gk = z;
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        pf();
    }

    gz a() {
        return this.dl;
    }

    void z(dl dlVar) {
        this.uf = dlVar;
    }

    boolean gc() {
        return this.uf != null;
    }

    void g(dl dlVar) {
        this.sy = dlVar;
    }

    private void v() {
        if (!this.dl.a().isEmpty()) {
            com.bytedance.adsdk.lottie.z.g.a aVar = new com.bytedance.adsdk.lottie.z.g.a(this.dl.a());
            this.io = aVar;
            aVar.z();
            this.io.z(new z.InterfaceC0041z() { // from class: com.bytedance.adsdk.lottie.model.layer.dl.1
                @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
                public void z() {
                    dl dlVar = dl.this;
                    dlVar.g(dlVar.io.fo() == 1.0f);
                }
            });
            g(this.io.e().floatValue() == 1.0f);
            z(this.io);
            return;
        }
        g(true);
    }

    private void pf() {
        this.g.invalidateSelf();
    }

    public void z(com.bytedance.adsdk.lottie.z.g.z<?, ?> zVar) {
        if (zVar == null) {
            return;
        }
        this.l.add(zVar);
    }

    public Matrix m() {
        return this.lq;
    }

    public String e() {
        gz gzVar = this.dl;
        if (gzVar != null) {
            return gzVar.e();
        }
        return null;
    }

    public void z(RectF rectF, Matrix matrix, boolean z) {
        this.p.set(0.0f, 0.0f, 0.0f, 0.0f);
        p();
        this.z.set(matrix);
        if (z) {
            List<dl> list = this.hh;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.z.preConcat(this.hh.get(size).f182a.a());
                }
            } else {
                dl dlVar = this.sy;
                if (dlVar != null) {
                    this.z.preConcat(dlVar.f182a.a());
                }
            }
        }
        this.z.preConcat(this.f182a.a());
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numE;
        com.bytedance.adsdk.lottie.gc.z(this.iq);
        if (!this.h || this.dl.iq()) {
            com.bytedance.adsdk.lottie.gc.g(this.iq);
            return;
        }
        p();
        com.bytedance.adsdk.lottie.gc.z("Layer#parentMatrix");
        this.lq.set(matrix);
        this.uy.reset();
        this.uy.set(matrix);
        for (int size = this.hh.size() - 1; size >= 0; size--) {
            this.uy.preConcat(this.hh.get(size).f182a.a());
        }
        com.bytedance.adsdk.lottie.gc.g("Layer#parentMatrix");
        com.bytedance.adsdk.lottie.z.g.z<?, Integer> zVarZ = this.f182a.z();
        int iIntValue = (int) ((((i / 255.0f) * ((zVarZ == null || (numE = zVarZ.e()) == null) ? 100 : numE.intValue())) / 100.0f) * 255.0f);
        if (!gc() && !fo()) {
            this.uy.preConcat(this.f182a.a());
            com.bytedance.adsdk.lottie.gc.z("Layer#drawLayer");
            g(canvas, this.uy, iIntValue);
            com.bytedance.adsdk.lottie.gc.g("Layer#drawLayer");
            dl(com.bytedance.adsdk.lottie.gc.g(this.iq));
            return;
        }
        com.bytedance.adsdk.lottie.gc.z("Layer#computeBounds");
        z(this.p, this.uy, false);
        g(this.p, matrix);
        this.uy.preConcat(this.f182a.a());
        z(this.p, this.uy);
        this.fv.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.kb);
        if (!this.kb.isIdentity()) {
            Matrix matrix2 = this.kb;
            matrix2.invert(matrix2);
            this.kb.mapRect(this.fv);
        }
        if (!this.p.intersect(this.fv)) {
            this.p.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.bytedance.adsdk.lottie.gc.g("Layer#computeBounds");
        if (this.p.width() >= 1.0f && this.p.height() >= 1.0f) {
            com.bytedance.adsdk.lottie.gc.z("Layer#saveLayer");
            this.wp.setAlpha(255);
            com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.p, this.wp);
            com.bytedance.adsdk.lottie.gc.g("Layer#saveLayer");
            z(canvas);
            com.bytedance.adsdk.lottie.gc.z("Layer#drawLayer");
            g(canvas, this.uy, iIntValue);
            com.bytedance.adsdk.lottie.gc.g("Layer#drawLayer");
            if (fo()) {
                z(canvas, this.uy);
            }
            if (gc()) {
                com.bytedance.adsdk.lottie.gc.z("Layer#drawMatte");
                com.bytedance.adsdk.lottie.gc.z("Layer#saveLayer");
                com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.p, this.pf, 19);
                com.bytedance.adsdk.lottie.gc.g("Layer#saveLayer");
                z(canvas);
                this.uf.z(canvas, matrix, iIntValue);
                com.bytedance.adsdk.lottie.gc.z("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.lottie.gc.g("Layer#restoreLayer");
                com.bytedance.adsdk.lottie.gc.g("Layer#drawMatte");
            }
            com.bytedance.adsdk.lottie.gc.z("Layer#restoreLayer");
            canvas.restore();
            com.bytedance.adsdk.lottie.gc.g("Layer#restoreLayer");
        }
        if (this.gk && (paint = this.x) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.x.setColor(-251901);
            this.x.setStrokeWidth(4.0f);
            canvas.drawRect(this.p, this.x);
            this.x.setStyle(Paint.Style.FILL);
            this.x.setColor(1357638635);
            canvas.drawRect(this.p, this.x);
        }
        dl(com.bytedance.adsdk.lottie.gc.g(this.iq));
    }

    private void dl(float f) {
        this.g.hh().dl().z(this.dl.m(), f);
    }

    private void z(Canvas canvas) {
        com.bytedance.adsdk.lottie.gc.z("Layer#clearLayer");
        canvas.drawRect(this.p.left - 1.0f, this.p.top - 1.0f, this.p.right + 1.0f, this.p.bottom + 1.0f, this.ls);
        com.bytedance.adsdk.lottie.gc.g("Layer#clearLayer");
    }

    private void z(RectF rectF, Matrix matrix) {
        this.js.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (fo()) {
            int size = this.zw.z().size();
            for (int i = 0; i < size; i++) {
                com.bytedance.adsdk.lottie.model.g.gz gzVar = this.zw.z().get(i);
                Path pathE = this.zw.g().get(i).e();
                if (pathE != null) {
                    this.fo.set(pathE);
                    this.fo.transform(matrix);
                    int i2 = AnonymousClass2.g[gzVar.z().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && gzVar.a()) {
                        return;
                    }
                    this.fo.computeBounds(this.q, false);
                    if (i == 0) {
                        this.js.set(this.q);
                    } else {
                        RectF rectF2 = this.js;
                        rectF2.set(Math.min(rectF2.left, this.q.left), Math.min(this.js.top, this.q.top), Math.max(this.js.right, this.q.right), Math.max(this.js.bottom, this.q.bottom));
                    }
                }
            }
            if (rectF.intersect(this.js)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.dl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] g;
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[gz.z.values().length];
            g = iArr;
            try {
                iArr[gz.z.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                g[gz.z.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                g[gz.z.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                g[gz.z.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[gz.z.values().length];
            z = iArr2;
            try {
                iArr2[gz.z.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                z[gz.z.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                z[gz.z.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                z[gz.z.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                z[gz.z.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                z[gz.z.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                z[gz.z.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private void g(RectF rectF, Matrix matrix) {
        if (gc() && this.dl.wp() != gz.g.INVERT) {
            this.tb.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.uf.z(this.tb, matrix, true);
            if (rectF.intersect(this.tb)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public float gz() {
        return this.mc;
    }

    protected void z(int i) {
        this.mc = ((this.f182a.z() != null ? this.f182a.z().e().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    public void g(Canvas canvas, Matrix matrix, int i) {
        z(i);
    }

    private void z(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.lottie.gc.z("Layer#saveLayer");
        com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.p, this.i, 19);
        if (Build.VERSION.SDK_INT < 28) {
            z(canvas);
        }
        com.bytedance.adsdk.lottie.gc.g("Layer#saveLayer");
        for (int i = 0; i < this.zw.z().size(); i++) {
            com.bytedance.adsdk.lottie.model.g.gz gzVar = this.zw.z().get(i);
            com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.v, Path> zVar = this.zw.g().get(i);
            com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar2 = this.zw.dl().get(i);
            int i2 = AnonymousClass2.g[gzVar.z().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.wp.setColor(-16777216);
                        this.wp.setAlpha(255);
                        canvas.drawRect(this.p, this.wp);
                    }
                    if (gzVar.a()) {
                        dl(canvas, matrix, zVar, zVar2);
                    } else {
                        z(canvas, matrix, zVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (gzVar.a()) {
                            g(canvas, matrix, zVar, zVar2);
                        } else {
                            z(canvas, matrix, zVar, zVar2);
                        }
                    }
                } else if (gzVar.a()) {
                    gc(canvas, matrix, zVar, zVar2);
                } else {
                    a(canvas, matrix, zVar, zVar2);
                }
            } else if (ls()) {
                this.wp.setAlpha(255);
                canvas.drawRect(this.p, this.wp);
            }
        }
        com.bytedance.adsdk.lottie.gc.z("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.lottie.gc.g("Layer#restoreLayer");
    }

    private boolean ls() {
        if (this.zw.g().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.zw.z().size(); i++) {
            if (this.zw.z().get(i).z() != gz.z.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void z(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.v, Path> zVar, com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar2) {
        this.fo.set(zVar.e());
        this.fo.transform(matrix);
        this.wp.setAlpha((int) (zVar2.e().intValue() * 2.55f));
        canvas.drawPath(this.fo, this.wp);
    }

    private void g(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.v, Path> zVar, com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar2) {
        com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.p, this.wp);
        canvas.drawRect(this.p, this.wp);
        this.fo.set(zVar.e());
        this.fo.transform(matrix);
        this.wp.setAlpha((int) (zVar2.e().intValue() * 2.55f));
        canvas.drawPath(this.fo, this.v);
        canvas.restore();
    }

    private void z(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.v, Path> zVar) {
        this.fo.set(zVar.e());
        this.fo.transform(matrix);
        canvas.drawPath(this.fo, this.v);
    }

    private void dl(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.v, Path> zVar, com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar2) {
        com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.p, this.v);
        canvas.drawRect(this.p, this.wp);
        this.v.setAlpha((int) (zVar2.e().intValue() * 2.55f));
        this.fo.set(zVar.e());
        this.fo.transform(matrix);
        canvas.drawPath(this.fo, this.v);
        canvas.restore();
    }

    private void a(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.v, Path> zVar, com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar2) {
        com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.p, this.i);
        this.fo.set(zVar.e());
        this.fo.transform(matrix);
        this.wp.setAlpha((int) (zVar2.e().intValue() * 2.55f));
        canvas.drawPath(this.fo, this.wp);
        canvas.restore();
    }

    private void gc(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.v, Path> zVar, com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVar2) {
        com.bytedance.adsdk.lottie.gc.fo.z(canvas, this.p, this.i);
        canvas.drawRect(this.p, this.wp);
        this.v.setAlpha((int) (zVar2.e().intValue() * 2.55f));
        this.fo.set(zVar.e());
        this.fo.transform(matrix);
        canvas.drawPath(this.fo, this.v);
        canvas.restore();
    }

    boolean fo() {
        com.bytedance.adsdk.lottie.z.g.gz gzVar = this.zw;
        return (gzVar == null || gzVar.g().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        if (z != this.h) {
            this.h = z;
            pf();
        }
    }

    public boolean uy() {
        return this.h;
    }

    void z(float f) {
        this.f182a.z(f);
        if (this.zw != null) {
            for (int i = 0; i < this.zw.g().size(); i++) {
                this.zw.g().get(i).z(f);
            }
        }
        com.bytedance.adsdk.lottie.z.g.a aVar = this.io;
        if (aVar != null) {
            aVar.z(f);
        }
        dl dlVar = this.uf;
        if (dlVar != null) {
            dlVar.z(f);
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            this.l.get(i2).z(f);
        }
    }

    private void p() {
        if (this.hh != null) {
            return;
        }
        if (this.sy == null) {
            this.hh = Collections.emptyList();
            return;
        }
        this.hh = new ArrayList();
        for (dl dlVar = this.sy; dlVar != null; dlVar = dlVar.sy) {
            this.hh.add(dlVar);
        }
    }

    public String kb() {
        return this.dl.m();
    }

    public com.bytedance.adsdk.lottie.model.g.z wp() {
        return this.dl.zw();
    }

    public BlurMaskFilter g(float f) {
        if (this.gc == f) {
            return this.m;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.m = blurMaskFilter;
        this.gc = f;
        return blurMaskFilter;
    }

    public com.bytedance.adsdk.lottie.a.uy i() {
        return this.dl.io();
    }
}
