package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.progressindicator.b;

/* JADX INFO: compiled from: DeterminateDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<S extends b> extends f {
    private static final FloatPropertyCompat<e> M = new a("indicatorLevel");
    private g<S> H;
    private final SpringForce I;
    private final SpringAnimation J;
    private float K;
    private boolean L;

    /* JADX INFO: compiled from: DeterminateDrawable.java */
    static class a extends FloatPropertyCompat<e> {
        a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(e eVar) {
            return eVar.f() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void setValue(e eVar, float f2) {
            eVar.c(f2 / 10000.0f);
        }
    }

    e(@NonNull Context context, @NonNull b bVar, @NonNull g<S> gVar) {
        super(context, bVar);
        this.L = false;
        a(gVar);
        this.I = new SpringForce();
        this.I.setDampingRatio(1.0f);
        this.I.setStiffness(50.0f);
        this.J = new SpringAnimation(this, M);
        this.J.setSpring(this.I);
        a(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float f() {
        return this.K;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.H.b(canvas, a());
            this.H.a(canvas, this.E);
            this.H.a(canvas, this.E, 0.0f, f(), com.google.android.material.c.a.a(this.f15656t.f15632c[0], getAlpha()));
            canvas.restore();
        }
    }

    @NonNull
    g<S> e() {
        return this.H;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.H.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.H.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.J.cancel();
        c(getLevel() / 10000.0f);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        if (this.L) {
            this.J.cancel();
            c(i2 / 10000.0f);
            return true;
        }
        this.J.setStartValue(f() * 10000.0f);
        this.J.animateToFinalPosition(i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2) {
        this.K = f2;
        invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.f
    boolean b(boolean z2, boolean z3, boolean z4) {
        boolean zB = super.b(z2, z3, z4);
        float fA = this.f15657u.a(this.f15655s.getContentResolver());
        if (fA == 0.0f) {
            this.L = true;
        } else {
            this.L = false;
            this.I.setStiffness(50.0f / fA);
        }
        return zB;
    }

    @NonNull
    public static e<LinearProgressIndicatorSpec> a(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new e<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec));
    }

    @NonNull
    public static e<CircularProgressIndicatorSpec> a(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new e<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec));
    }

    void a(@NonNull g<S> gVar) {
        this.H = gVar;
        gVar.a(this);
    }

    void b(float f2) {
        setLevel((int) (f2 * 10000.0f));
    }
}
