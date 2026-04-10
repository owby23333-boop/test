package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {

    @Deprecated
    public float a;

    @Deprecated
    public float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f15755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f15756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f15757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f15758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<f> f15759g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f15760h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15761i;

    /* JADX INFO: compiled from: ShapePath.java */
    class a extends g {
        final /* synthetic */ List b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f15762c;

        a(n nVar, List list, Matrix matrix) {
            this.b = list;
            this.f15762c = matrix;
        }

        @Override // com.google.android.material.shape.n.g
        public void a(Matrix matrix, com.google.android.material.k.a aVar, int i2, Canvas canvas) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f15762c, aVar, i2, canvas);
            }
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class b extends g {
        private final d b;

        public b(d dVar) {
            this.b = dVar;
        }

        @Override // com.google.android.material.shape.n.g
        public void a(Matrix matrix, @NonNull com.google.android.material.k.a aVar, int i2, @NonNull Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.b.b(), this.b.f(), this.b.c(), this.b.a()), i2, this.b.d(), this.b.e());
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final RectF f15765h = new RectF();

        @Deprecated
        public float b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f15766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f15767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f15768e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f15769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f15770g;

        public d(float f2, float f3, float f4, float f5) {
            b(f2);
            f(f3);
            c(f4);
            a(f5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float c() {
            return this.f15767d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float d() {
            return this.f15769f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float e() {
            return this.f15770g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float f() {
            return this.f15766c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float b() {
            return this.b;
        }

        private void c(float f2) {
            this.f15767d = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(float f2) {
            this.f15769f = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(float f2) {
            this.f15770g = f2;
        }

        private void f(float f2) {
            this.f15766c = f2;
        }

        @Override // com.google.android.material.shape.n.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f15765h.set(b(), f(), c(), a());
            path.arcTo(f15765h, d(), e(), false);
            path.transform(matrix);
        }

        private void b(float f2) {
            this.b = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float a() {
            return this.f15768e;
        }

        private void a(float f2) {
            this.f15768e = f2;
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class e extends f {
        private float b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f15771c;

        @Override // com.google.android.material.shape.n.f
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.f15771c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class f {
        protected final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static abstract class g {
        static final Matrix a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, com.google.android.material.k.a aVar, int i2, Canvas canvas);

        public final void a(com.google.android.material.k.a aVar, int i2, Canvas canvas) {
            a(a, aVar, i2, canvas);
        }
    }

    public n() {
        b(0.0f, 0.0f);
    }

    private float f() {
        return this.f15757e;
    }

    private float g() {
        return this.f15758f;
    }

    public void a(float f2, float f3, float f4, float f5) {
        f(f2);
        g(f3);
        d(f2);
        e(f3);
        b(f4);
        c((f4 + f5) % 360.0f);
        this.f15759g.clear();
        this.f15760h.clear();
        this.f15761i = false;
    }

    public void b(float f2, float f3) {
        a(f2, f3, 270.0f, 0.0f);
    }

    float c() {
        return this.f15756d;
    }

    float d() {
        return this.a;
    }

    float e() {
        return this.b;
    }

    private void c(float f2) {
        this.f15758f = f2;
    }

    private void d(float f2) {
        this.f15755c = f2;
    }

    private void e(float f2) {
        this.f15756d = f2;
    }

    private void f(float f2) {
        this.a = f2;
    }

    private void g(float f2) {
        this.b = f2;
    }

    float b() {
        return this.f15755c;
    }

    private void b(float f2) {
        this.f15757e = f2;
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class c extends g {
        private final e b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f15763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f15764d;

        public c(e eVar, float f2, float f3) {
            this.b = eVar;
            this.f15763c = f2;
            this.f15764d = f3;
        }

        @Override // com.google.android.material.shape.n.g
        public void a(Matrix matrix, @NonNull com.google.android.material.k.a aVar, int i2, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.b.f15771c - this.f15764d, this.b.b - this.f15763c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f15763c, this.f15764d);
            matrix2.preRotate(a());
            aVar.a(canvas, matrix2, rectF, i2);
        }

        float a() {
            return (float) Math.toDegrees(Math.atan((this.b.f15771c - this.f15764d) / (this.b.b - this.f15763c)));
        }
    }

    public void a(float f2, float f3) {
        e eVar = new e();
        eVar.b = f2;
        eVar.f15771c = f3;
        this.f15759g.add(eVar);
        c cVar = new c(eVar, b(), c());
        a(cVar, cVar.a() + 270.0f, cVar.a() + 270.0f);
        d(f2);
        e(f3);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.d(f6);
        dVar.e(f7);
        this.f15759g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z2 = f7 < 0.0f;
        if (z2) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        a(bVar, f6, z2 ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        d(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        e(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.f15759g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f15759g.get(i2).a(matrix, path);
        }
    }

    @NonNull
    g a(Matrix matrix) {
        a(g());
        return new a(this, new ArrayList(this.f15760h), new Matrix(matrix));
    }

    private void a(g gVar, float f2, float f3) {
        a(f2);
        this.f15760h.add(gVar);
        b(f3);
    }

    boolean a() {
        return this.f15761i;
    }

    private void a(float f2) {
        if (f() == f2) {
            return;
        }
        float f3 = ((f2 - f()) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        d dVar = new d(b(), c(), b(), c());
        dVar.d(f());
        dVar.e(f3);
        this.f15760h.add(new b(dVar));
        b(f2);
    }
}
