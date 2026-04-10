package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    private final n[] a = new n[4];
    private final Matrix[] b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f15742c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f15743d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f15744e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f15745f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final n f15746g = new n();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f15747h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f15748i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f15749j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f15750k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f15751l = true;

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    private static class a {
        static final m a = new m();
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface b {
        void a(n nVar, Matrix matrix, int i2);

        void b(n nVar, Matrix matrix, int i2);
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    static final class c {

        @NonNull
        public final l a;

        @NonNull
        public final Path b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final RectF f15752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final b f15753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f15754e;

        c(@NonNull l lVar, float f2, RectF rectF, @Nullable b bVar, Path path) {
            this.f15753d = bVar;
            this.a = lVar;
            this.f15754e = f2;
            this.f15752c = rectF;
            this.b = path;
        }
    }

    public m() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.a[i2] = new n();
            this.b[i2] = new Matrix();
            this.f15742c[i2] = new Matrix();
        }
    }

    private float a(int i2) {
        return (i2 + 1) * 90;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static m a() {
        return a.a;
    }

    private void b(int i2) {
        this.f15747h[0] = this.a[i2].b();
        this.f15747h[1] = this.a[i2].c();
        this.b[i2].mapPoints(this.f15747h);
        float fA = a(i2);
        this.f15742c[i2].reset();
        Matrix matrix = this.f15742c[i2];
        float[] fArr = this.f15747h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f15742c[i2].preRotate(fA);
    }

    private void c(@NonNull c cVar, int i2) {
        b(i2, cVar.a).a(this.a[i2], 90.0f, cVar.f15754e, cVar.f15752c, a(i2, cVar.a));
        float fA = a(i2);
        this.b[i2].reset();
        a(i2, cVar.f15752c, this.f15743d);
        Matrix matrix = this.b[i2];
        PointF pointF = this.f15743d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.b[i2].preRotate(fA);
    }

    public void a(l lVar, float f2, RectF rectF, @NonNull Path path) {
        a(lVar, f2, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a(l lVar, float f2, RectF rectF, b bVar, @NonNull Path path) {
        path.rewind();
        this.f15744e.rewind();
        this.f15745f.rewind();
        this.f15745f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(lVar, f2, rectF, bVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            c(cVar, i2);
            b(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            a(cVar, i3);
            b(cVar, i3);
        }
        path.close();
        this.f15744e.close();
        if (Build.VERSION.SDK_INT < 19 || this.f15744e.isEmpty()) {
            return;
        }
        path.op(this.f15744e, Path.Op.UNION);
    }

    private void b(@NonNull c cVar, int i2) {
        int i3 = (i2 + 1) % 4;
        this.f15747h[0] = this.a[i2].b();
        this.f15747h[1] = this.a[i2].c();
        this.b[i2].mapPoints(this.f15747h);
        this.f15748i[0] = this.a[i3].d();
        this.f15748i[1] = this.a[i3].e();
        this.b[i3].mapPoints(this.f15748i);
        float f2 = this.f15747h[0];
        float[] fArr = this.f15748i;
        float fMax = Math.max(((float) Math.hypot(f2 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fA = a(cVar.f15752c, i2);
        this.f15746g.b(0.0f, 0.0f);
        f fVarC = c(i2, cVar.a);
        fVarC.a(fMax, fA, cVar.f15754e, this.f15746g);
        this.f15749j.reset();
        this.f15746g.a(this.f15742c[i2], this.f15749j);
        if (this.f15751l && Build.VERSION.SDK_INT >= 19 && (fVarC.a() || a(this.f15749j, i2) || a(this.f15749j, i3))) {
            Path path = this.f15749j;
            path.op(path, this.f15745f, Path.Op.DIFFERENCE);
            this.f15747h[0] = this.f15746g.d();
            this.f15747h[1] = this.f15746g.e();
            this.f15742c[i2].mapPoints(this.f15747h);
            Path path2 = this.f15744e;
            float[] fArr2 = this.f15747h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f15746g.a(this.f15742c[i2], this.f15744e);
        } else {
            this.f15746g.a(this.f15742c[i2], cVar.b);
        }
        b bVar = cVar.f15753d;
        if (bVar != null) {
            bVar.b(this.f15746g, this.f15742c[i2], i2);
        }
    }

    private f c(int i2, @NonNull l lVar) {
        if (i2 == 1) {
            return lVar.a();
        }
        if (i2 == 2) {
            return lVar.f();
        }
        if (i2 != 3) {
            return lVar.g();
        }
        return lVar.h();
    }

    private void a(@NonNull c cVar, int i2) {
        this.f15747h[0] = this.a[i2].d();
        this.f15747h[1] = this.a[i2].e();
        this.b[i2].mapPoints(this.f15747h);
        if (i2 == 0) {
            Path path = cVar.b;
            float[] fArr = this.f15747h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.b;
            float[] fArr2 = this.f15747h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.a[i2].a(this.b[i2], cVar.b);
        b bVar = cVar.f15753d;
        if (bVar != null) {
            bVar.a(this.a[i2], this.b[i2], i2);
        }
    }

    @RequiresApi(19)
    private boolean a(Path path, int i2) {
        this.f15750k.reset();
        this.a[i2].a(this.b[i2], this.f15750k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f15750k.computeBounds(rectF, true);
        path.op(this.f15750k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private float a(@NonNull RectF rectF, int i2) {
        float[] fArr = this.f15747h;
        n[] nVarArr = this.a;
        fArr[0] = nVarArr[i2].f15755c;
        fArr[1] = nVarArr[i2].f15756d;
        this.b[i2].mapPoints(fArr);
        if (i2 != 1 && i2 != 3) {
            return Math.abs(rectF.centerY() - this.f15747h[1]);
        }
        return Math.abs(rectF.centerX() - this.f15747h[0]);
    }

    private d b(int i2, @NonNull l lVar) {
        if (i2 == 1) {
            return lVar.d();
        }
        if (i2 == 2) {
            return lVar.b();
        }
        if (i2 != 3) {
            return lVar.k();
        }
        return lVar.i();
    }

    private com.google.android.material.shape.c a(int i2, @NonNull l lVar) {
        if (i2 == 1) {
            return lVar.e();
        }
        if (i2 == 2) {
            return lVar.c();
        }
        if (i2 != 3) {
            return lVar.l();
        }
        return lVar.j();
    }

    private void a(int i2, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i2 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i2 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i2 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }
}
