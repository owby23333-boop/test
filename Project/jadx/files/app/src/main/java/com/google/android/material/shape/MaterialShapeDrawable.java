package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;
import com.google.android.material.shape.n;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, o {
    private static final String O = MaterialShapeDrawable.class.getSimpleName();
    private static final Paint P = new Paint(1);
    private final RectF A;
    private final RectF B;
    private final Region C;
    private final Region D;
    private l E;
    private final Paint F;
    private final Paint G;
    private final com.google.android.material.k.a H;

    @NonNull
    private final m.b I;
    private final m J;

    @Nullable
    private PorterDuffColorFilter K;

    @Nullable
    private PorterDuffColorFilter L;

    @NonNull
    private final RectF M;
    private boolean N;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private c f15693s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final n.g[] f15694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final n.g[] f15695u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final BitSet f15696v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f15697w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Matrix f15698x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Path f15699y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Path f15700z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    class a implements m.b {
        a() {
        }

        @Override // com.google.android.material.shape.m.b
        public void a(@NonNull n nVar, Matrix matrix, int i2) {
            MaterialShapeDrawable.this.f15696v.set(i2, nVar.a());
            MaterialShapeDrawable.this.f15694t[i2] = nVar.a(matrix);
        }

        @Override // com.google.android.material.shape.m.b
        public void b(@NonNull n nVar, Matrix matrix, int i2) {
            MaterialShapeDrawable.this.f15696v.set(i2 + 4, nVar.a());
            MaterialShapeDrawable.this.f15695u[i2] = nVar.a(matrix);
        }
    }

    class b implements l.c {
        final /* synthetic */ float a;

        b(MaterialShapeDrawable materialShapeDrawable, float f2) {
            this.a = f2;
        }

        @Override // com.google.android.material.shape.l.c
        @NonNull
        public com.google.android.material.shape.c a(@NonNull com.google.android.material.shape.c cVar) {
            return cVar instanceof j ? cVar : new com.google.android.material.shape.b(this.a, cVar);
        }
    }

    /* synthetic */ MaterialShapeDrawable(c cVar, a aVar) {
        this(cVar);
    }

    private boolean A() {
        Paint.Style style = this.f15693s.f15720v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean B() {
        Paint.Style style = this.f15693s.f15720v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.G.getStrokeWidth() > 0.0f;
    }

    private void C() {
        super.invalidateSelf();
    }

    private boolean D() {
        PorterDuffColorFilter porterDuffColorFilter = this.K;
        PorterDuffColorFilter porterDuffColorFilter2 = this.L;
        c cVar = this.f15693s;
        this.K = a(cVar.f15705g, cVar.f15706h, this.F, true);
        c cVar2 = this.f15693s;
        this.L = a(cVar2.f15704f, cVar2.f15706h, this.G, false);
        c cVar3 = this.f15693s;
        if (cVar3.f15719u) {
            this.H.a(cVar3.f15705g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.K) && ObjectsCompat.equals(porterDuffColorFilter2, this.L)) ? false : true;
    }

    private void E() {
        float fS = s();
        this.f15693s.f15716r = (int) Math.ceil(0.75f * fS);
        this.f15693s.f15717s = (int) Math.ceil(fS * 0.25f);
        D();
        C();
    }

    private static int a(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private void w() {
        this.E = l().a(new b(this, -y()));
        this.J.a(this.E, this.f15693s.f15709k, x(), this.f15700z);
    }

    @NonNull
    private RectF x() {
        this.B.set(d());
        float fY = y();
        this.B.inset(fY, fY);
        return this.B;
    }

    private float y() {
        if (B()) {
            return this.G.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean z() {
        c cVar = this.f15693s;
        int i2 = cVar.f15715q;
        return i2 != 1 && cVar.f15716r > 0 && (i2 == 2 || v());
    }

    @NonNull
    protected RectF d() {
        this.A.set(getBounds());
        return this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.F.setColorFilter(this.K);
        int alpha = this.F.getAlpha();
        this.F.setAlpha(a(alpha, this.f15693s.f15711m));
        this.G.setColorFilter(this.L);
        this.G.setStrokeWidth(this.f15693s.f15710l);
        int alpha2 = this.G.getAlpha();
        this.G.setAlpha(a(alpha2, this.f15693s.f15711m));
        if (this.f15697w) {
            w();
            b(d(), this.f15699y);
            this.f15697w = false;
        }
        d(canvas);
        if (A()) {
            b(canvas);
        }
        if (B()) {
            c(canvas);
        }
        this.F.setAlpha(alpha);
        this.G.setAlpha(alpha2);
    }

    public void e(float f2) {
        this.f15693s.f15710l = f2;
        invalidateSelf();
    }

    @Nullable
    public ColorStateList f() {
        return this.f15693s.f15702d;
    }

    public float g() {
        return this.f15693s.f15709k;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f15693s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f15693s.f15715q == 2) {
            return;
        }
        if (u()) {
            outline.setRoundRect(getBounds(), p() * this.f15693s.f15709k);
            return;
        }
        b(d(), this.f15699y);
        if (this.f15699y.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f15699y);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f15693s.f15707i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.C.set(getBounds());
        b(d(), this.f15699y);
        this.D.setPath(this.f15699y, this.C);
        this.C.op(this.D, Region.Op.DIFFERENCE);
        return this.C;
    }

    public float h() {
        return this.f15693s.f15712n;
    }

    public int i() {
        double d2 = this.f15693s.f15717s;
        double dSin = Math.sin(Math.toRadians(r0.f15718t));
        Double.isNaN(d2);
        return (int) (d2 * dSin);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f15697w = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f15693s.f15705g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f15693s.f15704f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f15693s.f15703e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f15693s.f15702d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        double d2 = this.f15693s.f15717s;
        double dCos = Math.cos(Math.toRadians(r0.f15718t));
        Double.isNaN(d2);
        return (int) (d2 * dCos);
    }

    public int k() {
        return this.f15693s.f15716r;
    }

    @NonNull
    public l l() {
        return this.f15693s.a;
    }

    @Nullable
    public ColorStateList m() {
        return this.f15693s.f15703e;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.f15693s = new c(this.f15693s);
        return this;
    }

    public float n() {
        return this.f15693s.f15710l;
    }

    @Nullable
    public ColorStateList o() {
        return this.f15693s.f15705g;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f15697w = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.i.b
    protected boolean onStateChange(int[] iArr) {
        boolean z2 = a(iArr) || D();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public float p() {
        return this.f15693s.a.j().a(d());
    }

    public float q() {
        return this.f15693s.a.l().a(d());
    }

    public float r() {
        return this.f15693s.f15714p;
    }

    public float s() {
        return e() + r();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        c cVar = this.f15693s;
        if (cVar.f15711m != i2) {
            cVar.f15711m = i2;
            C();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f15693s.f15701c = colorFilter;
        C();
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull l lVar) {
        this.f15693s.a = lVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f15693s.f15705g = colorStateList;
        D();
        C();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        c cVar = this.f15693s;
        if (cVar.f15706h != mode) {
            cVar.f15706h = mode;
            D();
            C();
        }
    }

    public boolean t() {
        com.google.android.material.f.a aVar = this.f15693s.b;
        return aVar != null && aVar.a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean u() {
        return this.f15693s.a.a(d());
    }

    public boolean v() {
        return Build.VERSION.SDK_INT < 21 || !(u() || this.f15699y.isConvex() || Build.VERSION.SDK_INT >= 29);
    }

    public MaterialShapeDrawable() {
        this(new l());
    }

    public void b(@Nullable ColorStateList colorStateList) {
        c cVar = this.f15693s;
        if (cVar.f15703e != colorStateList) {
            cVar.f15703e = colorStateList;
            onStateChange(getState());
        }
    }

    public void c(float f2) {
        c cVar = this.f15693s;
        if (cVar.f15709k != f2) {
            cVar.f15709k = f2;
            this.f15697w = true;
            invalidateSelf();
        }
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this(l.a(context, attributeSet, i2, i3).a());
    }

    @NonNull
    public static MaterialShapeDrawable a(Context context, float f2) {
        int iA = com.google.android.material.c.a.a(context, R$attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.a(context);
        materialShapeDrawable.a(ColorStateList.valueOf(iA));
        materialShapeDrawable.b(f2);
        return materialShapeDrawable;
    }

    public void d(int i2) {
        c cVar = this.f15693s;
        if (cVar.f15715q != i2) {
            cVar.f15715q = i2;
            C();
        }
    }

    public float e() {
        return this.f15693s.f15713o;
    }

    public MaterialShapeDrawable(@NonNull l lVar) {
        this(new c(lVar, null));
    }

    private void e(@NonNull Canvas canvas) {
        int i2 = i();
        int iJ = j();
        if (Build.VERSION.SDK_INT < 21 && this.N) {
            Rect clipBounds = canvas.getClipBounds();
            int i3 = this.f15693s.f15716r;
            clipBounds.inset(-i3, -i3);
            clipBounds.offset(i2, iJ);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(i2, iJ);
    }

    private MaterialShapeDrawable(@NonNull c cVar) {
        this.f15694t = new n.g[4];
        this.f15695u = new n.g[4];
        this.f15696v = new BitSet(8);
        this.f15698x = new Matrix();
        this.f15699y = new Path();
        this.f15700z = new Path();
        this.A = new RectF();
        this.B = new RectF();
        this.C = new Region();
        this.D = new Region();
        this.F = new Paint(1);
        this.G = new Paint(1);
        this.H = new com.google.android.material.k.a();
        this.J = Looper.getMainLooper().getThread() == Thread.currentThread() ? m.a() : new m();
        this.M = new RectF();
        this.N = true;
        this.f15693s = cVar;
        this.G.setStyle(Paint.Style.STROKE);
        this.F.setStyle(Paint.Style.FILL);
        P.setColor(-1);
        P.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        D();
        a(getState());
        this.I = new a();
    }

    public void b(float f2) {
        c cVar = this.f15693s;
        if (cVar.f15713o != f2) {
            cVar.f15713o = f2;
            E();
        }
    }

    public void c(int i2) {
        c cVar = this.f15693s;
        if (cVar.f15718t != i2) {
            cVar.f15718t = i2;
            C();
        }
    }

    public void d(float f2) {
        c cVar = this.f15693s;
        if (cVar.f15712n != f2) {
            cVar.f15712n = f2;
            E();
        }
    }

    public void b(int i2) {
        this.H.a(i2);
        this.f15693s.f15719u = false;
        C();
    }

    private void c(@NonNull Canvas canvas) {
        a(canvas, this.G, this.f15700z, this.E, x());
    }

    private void d(@NonNull Canvas canvas) {
        if (z()) {
            canvas.save();
            e(canvas);
            if (!this.N) {
                a(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.M.width() - getBounds().width());
            int iHeight = (int) (this.M.height() - getBounds().height());
            if (iWidth >= 0 && iHeight >= 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.M.width()) + (this.f15693s.f15716r * 2) + iWidth, ((int) this.M.height()) + (this.f15693s.f15716r * 2) + iHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                float f2 = (getBounds().left - this.f15693s.f15716r) - iWidth;
                float f3 = (getBounds().top - this.f15693s.f15716r) - iHeight;
                canvas2.translate(-f2, -f3);
                a(canvas2);
                canvas.drawBitmap(bitmapCreateBitmap, f2, f3, (Paint) null);
                bitmapCreateBitmap.recycle();
                canvas.restore();
                return;
            }
            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
        }
    }

    public void a(@Nullable ColorStateList colorStateList) {
        c cVar = this.f15693s;
        if (cVar.f15702d != colorStateList) {
            cVar.f15702d = colorStateList;
            onStateChange(getState());
        }
    }

    private void b(@NonNull Canvas canvas) {
        a(canvas, this.F, this.f15699y, this.f15693s.a, d());
    }

    private void b(@NonNull RectF rectF, @NonNull Path path) {
        a(rectF, path);
        if (this.f15693s.f15708j != 1.0f) {
            this.f15698x.reset();
            Matrix matrix = this.f15698x;
            float f2 = this.f15693s.f15708j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f15698x);
        }
        path.computeBounds(this.M, true);
    }

    public float c() {
        return this.f15693s.a.e().a(d());
    }

    public void a(float f2, @ColorInt int i2) {
        e(f2);
        b(ColorStateList.valueOf(i2));
    }

    public void a(float f2, @Nullable ColorStateList colorStateList) {
        e(f2);
        b(colorStateList);
    }

    public void a(float f2) {
        setShapeAppearanceModel(this.f15693s.a.a(f2));
    }

    public void a(@NonNull com.google.android.material.shape.c cVar) {
        setShapeAppearanceModel(this.f15693s.a.a(cVar));
    }

    public void a(int i2, int i3, int i4, int i5) {
        c cVar = this.f15693s;
        if (cVar.f15707i == null) {
            cVar.f15707i = new Rect();
        }
        this.f15693s.f15707i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    public float b() {
        return this.f15693s.a.c().a(d());
    }

    static final class c extends Drawable.ConstantState {

        @NonNull
        public l a;

        @Nullable
        public com.google.android.material.f.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public ColorFilter f15701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public ColorStateList f15702d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public ColorStateList f15703e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public ColorStateList f15704f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public ColorStateList f15705g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public PorterDuff.Mode f15706h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public Rect f15707i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f15708j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f15709k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f15710l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f15711m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f15712n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f15713o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f15714p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f15715q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f15716r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f15717s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f15718t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f15719u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Paint.Style f15720v;

        public c(l lVar, com.google.android.material.f.a aVar) {
            this.f15702d = null;
            this.f15703e = null;
            this.f15704f = null;
            this.f15705g = null;
            this.f15706h = PorterDuff.Mode.SRC_IN;
            this.f15707i = null;
            this.f15708j = 1.0f;
            this.f15709k = 1.0f;
            this.f15711m = 255;
            this.f15712n = 0.0f;
            this.f15713o = 0.0f;
            this.f15714p = 0.0f;
            this.f15715q = 0;
            this.f15716r = 0;
            this.f15717s = 0;
            this.f15718t = 0;
            this.f15719u = false;
            this.f15720v = Paint.Style.FILL_AND_STROKE;
            this.a = lVar;
            this.b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this, null);
            materialShapeDrawable.f15697w = true;
            return materialShapeDrawable;
        }

        public c(@NonNull c cVar) {
            this.f15702d = null;
            this.f15703e = null;
            this.f15704f = null;
            this.f15705g = null;
            this.f15706h = PorterDuff.Mode.SRC_IN;
            this.f15707i = null;
            this.f15708j = 1.0f;
            this.f15709k = 1.0f;
            this.f15711m = 255;
            this.f15712n = 0.0f;
            this.f15713o = 0.0f;
            this.f15714p = 0.0f;
            this.f15715q = 0;
            this.f15716r = 0;
            this.f15717s = 0;
            this.f15718t = 0;
            this.f15719u = false;
            this.f15720v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.b = cVar.b;
            this.f15710l = cVar.f15710l;
            this.f15701c = cVar.f15701c;
            this.f15702d = cVar.f15702d;
            this.f15703e = cVar.f15703e;
            this.f15706h = cVar.f15706h;
            this.f15705g = cVar.f15705g;
            this.f15711m = cVar.f15711m;
            this.f15708j = cVar.f15708j;
            this.f15717s = cVar.f15717s;
            this.f15715q = cVar.f15715q;
            this.f15719u = cVar.f15719u;
            this.f15709k = cVar.f15709k;
            this.f15712n = cVar.f15712n;
            this.f15713o = cVar.f15713o;
            this.f15714p = cVar.f15714p;
            this.f15716r = cVar.f15716r;
            this.f15718t = cVar.f15718t;
            this.f15704f = cVar.f15704f;
            this.f15720v = cVar.f15720v;
            Rect rect = cVar.f15707i;
            if (rect != null) {
                this.f15707i = new Rect(rect);
            }
        }
    }

    public void a(Context context) {
        this.f15693s.b = new com.google.android.material.f.a(context);
        E();
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int a(@ColorInt int i2) {
        float fS = s() + h();
        com.google.android.material.f.a aVar = this.f15693s.b;
        return aVar != null ? aVar.b(i2, fS) : i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a(boolean z2) {
        this.N = z2;
    }

    public void a(Paint.Style style) {
        this.f15693s.f15720v = style;
        C();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void a(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        a(canvas, paint, path, this.f15693s.a, rectF);
    }

    private void a(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull l lVar, @NonNull RectF rectF) {
        if (lVar.a(rectF)) {
            float fA = lVar.l().a(rectF) * this.f15693s.f15709k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    private void a(@NonNull Canvas canvas) {
        this.f15696v.cardinality();
        if (this.f15693s.f15717s != 0) {
            canvas.drawPath(this.f15699y, this.H.a());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.f15694t[i2].a(this.H, this.f15693s.f15716r, canvas);
            this.f15695u[i2].a(this.H, this.f15693s.f15716r, canvas);
        }
        if (this.N) {
            int i3 = i();
            int iJ = j();
            canvas.translate(-i3, -iJ);
            canvas.drawPath(this.f15699y, P);
            canvas.translate(i3, iJ);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void a(@NonNull RectF rectF, @NonNull Path path) {
        m mVar = this.J;
        c cVar = this.f15693s;
        mVar.a(cVar.a, cVar.f15709k, rectF, this.I, path);
    }

    @NonNull
    private PorterDuffColorFilter a(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z2) {
        if (colorStateList != null && mode != null) {
            return a(colorStateList, mode, z2);
        }
        return a(paint, z2);
    }

    @Nullable
    private PorterDuffColorFilter a(@NonNull Paint paint, boolean z2) {
        int color;
        int iA;
        if (!z2 || (iA = a((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(iA, PorterDuff.Mode.SRC_IN);
    }

    @NonNull
    private PorterDuffColorFilter a(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = a(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private boolean a(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f15693s.f15702d == null || color2 == (colorForState2 = this.f15693s.f15702d.getColorForState(iArr, (color2 = this.F.getColor())))) {
            z2 = false;
        } else {
            this.F.setColor(colorForState2);
            z2 = true;
        }
        if (this.f15693s.f15703e == null || color == (colorForState = this.f15693s.f15703e.getColorForState(iArr, (color = this.G.getColor())))) {
            return z2;
        }
        this.G.setColor(colorForState);
        return true;
    }
}
