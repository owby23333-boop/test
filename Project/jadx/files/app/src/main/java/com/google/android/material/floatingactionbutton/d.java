package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.o;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class d {
    static final TimeInterpolator F = com.google.android.material.a.a.f14914c;
    static final int[] G = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] H = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] I = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] J = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] K = {R.attr.state_enabled};
    static final int[] L = new int[0];

    @Nullable
    private ViewTreeObserver.OnPreDrawListener E;

    @Nullable
    com.google.android.material.shape.l a;

    @Nullable
    MaterialShapeDrawable b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    Drawable f15382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    com.google.android.material.floatingactionbutton.c f15383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    Drawable f15384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f15385f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f15387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f15388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f15389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f15390k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private com.google.android.material.a.h f15392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private com.google.android.material.a.h f15393n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private Animator f15394o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private com.google.android.material.a.h f15395p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private com.google.android.material.a.h f15396q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f15397r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f15399t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f15401v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f15402w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ArrayList<i> f15403x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final FloatingActionButton f15404y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final com.google.android.material.k.b f15405z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f15386g = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f15398s = 1.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f15400u = 0;
    private final Rect A = new Rect();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private final Matrix D = new Matrix();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.internal.h f15391l = new com.google.android.material.internal.h();

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f15406s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ boolean f15407t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ j f15408u;

        a(boolean z2, j jVar) {
            this.f15407t = z2;
            this.f15408u = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f15406s = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f15400u = 0;
            d.this.f15394o = null;
            if (this.f15406s) {
                return;
            }
            d.this.f15404y.a(this.f15407t ? 8 : 4, this.f15407t);
            j jVar = this.f15408u;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f15404y.a(0, this.f15407t);
            d.this.f15400u = 1;
            d.this.f15394o = animator;
            this.f15406s = false;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f15410s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ j f15411t;

        b(boolean z2, j jVar) {
            this.f15410s = z2;
            this.f15411t = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f15400u = 0;
            d.this.f15394o = null;
            j jVar = this.f15411t;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f15404y.a(0, this.f15410s);
            d.this.f15400u = 2;
            d.this.f15394o = animator;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class c extends com.google.android.material.a.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            d.this.f15398s = f2;
            return super.evaluate(f2, matrix, matrix2);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class C0323d implements TypeEvaluator<Float> {
        FloatEvaluator a = new FloatEvaluator();

        C0323d(d dVar) {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f2, Float f3, Float f4) {
            float fFloatValue = this.a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.p();
            return true;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class f extends l {
        f(d dVar) {
            super(dVar, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class g extends l {
        g() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            d dVar = d.this;
            return dVar.f15387h + dVar.f15388i;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class h extends l {
        h() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            d dVar = d.this;
            return dVar.f15387h + dVar.f15389j;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    interface i {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    interface j {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class k extends l {
        k() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            return d.this.f15387h;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f15418s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private float f15419t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private float f15420u;

        private l() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.e((int) this.f15420u);
            this.f15418s = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.f15418s) {
                MaterialShapeDrawable materialShapeDrawable = d.this.b;
                this.f15419t = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.e();
                this.f15420u = a();
                this.f15418s = true;
            }
            d dVar = d.this;
            float f2 = this.f15419t;
            dVar.e((int) (f2 + ((this.f15420u - f2) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ l(d dVar, a aVar) {
            this();
        }
    }

    d(FloatingActionButton floatingActionButton, com.google.android.material.k.b bVar) {
        this.f15404y = floatingActionButton;
        this.f15405z = bVar;
        this.f15391l.a(G, a((l) new h()));
        this.f15391l.a(H, a((l) new g()));
        this.f15391l.a(I, a((l) new g()));
        this.f15391l.a(J, a((l) new g()));
        this.f15391l.a(K, a((l) new k()));
        this.f15391l.a(L, a((l) new f(this)));
        this.f15397r = this.f15404y.getRotation();
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener A() {
        if (this.E == null) {
            this.E = new e();
        }
        return this.E;
    }

    private boolean B() {
        return ViewCompat.isLaidOut(this.f15404y) && !this.f15404y.isInEditMode();
    }

    private com.google.android.material.a.h y() {
        if (this.f15393n == null) {
            this.f15393n = com.google.android.material.a.h.a(this.f15404y.getContext(), R$animator.design_fab_hide_motion_spec);
        }
        return (com.google.android.material.a.h) Preconditions.checkNotNull(this.f15393n);
    }

    private com.google.android.material.a.h z() {
        if (this.f15392m == null) {
            this.f15392m = com.google.android.material.a.h.a(this.f15404y.getContext(), R$animator.design_fab_show_motion_spec);
        }
        return (com.google.android.material.a.h) Preconditions.checkNotNull(this.f15392m);
    }

    void b(int i2) {
        this.f15390k = i2;
    }

    float c() {
        return this.f15387h;
    }

    final void d(float f2) {
        if (this.f15389j != f2) {
            this.f15389j = f2;
            a(this.f15387h, this.f15388i, this.f15389j);
        }
    }

    @Nullable
    final com.google.android.material.a.h e() {
        return this.f15396q;
    }

    float f() {
        return this.f15388i;
    }

    float g() {
        return this.f15389j;
    }

    @Nullable
    final com.google.android.material.shape.l h() {
        return this.a;
    }

    @Nullable
    final com.google.android.material.a.h i() {
        return this.f15395p;
    }

    boolean j() {
        return this.f15404y.getVisibility() == 0 ? this.f15400u == 1 : this.f15400u != 2;
    }

    boolean k() {
        return this.f15404y.getVisibility() != 0 ? this.f15400u == 2 : this.f15400u != 1;
    }

    void l() {
        this.f15391l.a();
    }

    void m() {
        MaterialShapeDrawable materialShapeDrawable = this.b;
        if (materialShapeDrawable != null) {
            com.google.android.material.shape.h.a(this.f15404y, materialShapeDrawable);
        }
        if (s()) {
            this.f15404y.getViewTreeObserver().addOnPreDrawListener(A());
        }
    }

    void n() {
    }

    void o() {
        ViewTreeObserver viewTreeObserver = this.f15404y.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.E;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.E = null;
        }
    }

    void p() {
        float rotation = this.f15404y.getRotation();
        if (this.f15397r != rotation) {
            this.f15397r = rotation;
            v();
        }
    }

    void q() {
        ArrayList<i> arrayList = this.f15403x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    void r() {
        ArrayList<i> arrayList = this.f15403x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    boolean s() {
        return true;
    }

    boolean t() {
        return true;
    }

    final boolean u() {
        return !this.f15385f || this.f15404y.getSizeDimension() >= this.f15390k;
    }

    void v() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f15397r % 90.0f != 0.0f) {
                if (this.f15404y.getLayerType() != 1) {
                    this.f15404y.setLayerType(1, null);
                }
            } else if (this.f15404y.getLayerType() != 0) {
                this.f15404y.setLayerType(0, null);
            }
        }
        MaterialShapeDrawable materialShapeDrawable = this.b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.c((int) this.f15397r);
        }
    }

    final void w() {
        c(this.f15398s);
    }

    final void x() {
        Rect rect = this.A;
        a(rect);
        b(rect);
        this.f15405z.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    void b(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f15382c;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, com.google.android.material.j.b.b(colorStateList));
        }
    }

    final void c(float f2) {
        this.f15398s = f2;
        Matrix matrix = this.D;
        a(f2, matrix);
        this.f15404y.setImageMatrix(matrix);
    }

    void e(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.b(f2);
        }
    }

    void a(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        this.b = a();
        this.b.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.b(-12303292);
        this.b.a(this.f15404y.getContext());
        com.google.android.material.j.a aVar = new com.google.android.material.j.a(this.b.l());
        aVar.setTintList(com.google.android.material.j.b.b(colorStateList2));
        this.f15382c = aVar;
        this.f15384e = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.b), aVar});
    }

    boolean d() {
        return this.f15385f;
    }

    final void b(float f2) {
        if (this.f15388i != f2) {
            this.f15388i = f2;
            a(this.f15387h, this.f15388i, this.f15389j);
        }
    }

    final void b(@Nullable com.google.android.material.a.h hVar) {
        this.f15395p = hVar;
    }

    void b(boolean z2) {
        this.f15386g = z2;
        x();
    }

    void b(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f15401v == null) {
            this.f15401v = new ArrayList<>();
        }
        this.f15401v.add(animatorListener);
    }

    void b(@Nullable j jVar, boolean z2) {
        if (k()) {
            return;
        }
        Animator animator = this.f15394o;
        if (animator != null) {
            animator.cancel();
        }
        if (B()) {
            if (this.f15404y.getVisibility() != 0) {
                this.f15404y.setAlpha(0.0f);
                this.f15404y.setScaleY(0.0f);
                this.f15404y.setScaleX(0.0f);
                c(0.0f);
            }
            com.google.android.material.a.h hVarZ = this.f15395p;
            if (hVarZ == null) {
                hVarZ = z();
            }
            AnimatorSet animatorSetA = a(hVarZ, 1.0f, 1.0f, 1.0f);
            animatorSetA.addListener(new b(z2, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.f15401v;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorSetA.addListener(it.next());
                }
            }
            animatorSetA.start();
            return;
        }
        this.f15404y.a(0, z2);
        this.f15404y.setAlpha(1.0f);
        this.f15404y.setScaleY(1.0f);
        this.f15404y.setScaleX(1.0f);
        c(1.0f);
        if (jVar != null) {
            jVar.a();
        }
    }

    void a(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f15383d;
        if (cVar != null) {
            cVar.a(colorStateList);
        }
    }

    void a(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    final void a(float f2) {
        if (this.f15387h != f2) {
            this.f15387h = f2;
            a(this.f15387h, this.f15388i, this.f15389j);
        }
    }

    final void a(int i2) {
        if (this.f15399t != i2) {
            this.f15399t = i2;
            w();
        }
    }

    private void a(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        if (this.f15404y.getDrawable() == null || this.f15399t == 0) {
            return;
        }
        RectF rectF = this.B;
        RectF rectF2 = this.C;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i2 = this.f15399t;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.f15399t;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    final void a(@NonNull com.google.android.material.shape.l lVar) {
        this.a = lVar;
        MaterialShapeDrawable materialShapeDrawable = this.b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(lVar);
        }
        Object obj = this.f15382c;
        if (obj instanceof o) {
            ((o) obj).setShapeAppearanceModel(lVar);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f15383d;
        if (cVar != null) {
            cVar.a(lVar);
        }
    }

    @Nullable
    final Drawable b() {
        return this.f15384e;
    }

    void b(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.f15384e, "Didn't initialize content background");
        if (t()) {
            this.f15405z.setBackgroundDrawable(new InsetDrawable(this.f15384e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.f15405z.setBackgroundDrawable(this.f15384e);
        }
    }

    final void a(@Nullable com.google.android.material.a.h hVar) {
        this.f15396q = hVar;
    }

    void a(boolean z2) {
        this.f15385f = z2;
    }

    void a(float f2, float f3, float f4) {
        x();
        e(f2);
    }

    void a(int[] iArr) {
        this.f15391l.a(iArr);
    }

    public void a(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f15402w == null) {
            this.f15402w = new ArrayList<>();
        }
        this.f15402w.add(animatorListener);
    }

    void a(@Nullable j jVar, boolean z2) {
        if (j()) {
            return;
        }
        Animator animator = this.f15394o;
        if (animator != null) {
            animator.cancel();
        }
        if (B()) {
            com.google.android.material.a.h hVarY = this.f15396q;
            if (hVarY == null) {
                hVarY = y();
            }
            AnimatorSet animatorSetA = a(hVarY, 0.0f, 0.0f, 0.0f);
            animatorSetA.addListener(new a(z2, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.f15402w;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorSetA.addListener(it.next());
                }
            }
            animatorSetA.start();
            return;
        }
        this.f15404y.a(z2 ? 8 : 4, z2);
        if (jVar != null) {
            jVar.b();
        }
    }

    @NonNull
    private AnimatorSet a(@NonNull com.google.android.material.a.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f15404y, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        hVar.b("opacity").a((Animator) objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f15404y, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        hVar.b("scale").a((Animator) objectAnimatorOfFloat2);
        a(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f15404y, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        hVar.b("scale").a((Animator) objectAnimatorOfFloat3);
        a(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        a(f4, this.D);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f15404y, new com.google.android.material.a.f(), new c(), new Matrix(this.D));
        hVar.b("iconScale").a((Animator) objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void a(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new C0323d(this));
    }

    void a(@NonNull i iVar) {
        if (this.f15403x == null) {
            this.f15403x = new ArrayList<>();
        }
        this.f15403x.add(iVar);
    }

    void a(@NonNull Rect rect) {
        int sizeDimension = this.f15385f ? (this.f15390k - this.f15404y.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.f15386g ? c() + this.f15389j : 0.0f));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    MaterialShapeDrawable a() {
        return new MaterialShapeDrawable((com.google.android.material.shape.l) Preconditions.checkNotNull(this.a));
    }

    @NonNull
    private ValueAnimator a(@NonNull l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }
}
