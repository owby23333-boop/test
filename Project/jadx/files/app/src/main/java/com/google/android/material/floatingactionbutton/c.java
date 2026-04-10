package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;

/* JADX INFO: compiled from: BorderDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class c extends Drawable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Dimension
    float f15373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColorInt
    private int f15374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColorInt
    private int f15375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @ColorInt
    private int f15376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @ColorInt
    private int f15377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @ColorInt
    private int f15378m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private l f15380o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private ColorStateList f15381p;
    private final m a = m.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f15368c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f15369d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f15370e = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f15371f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f15372g = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15379n = true;

    @NonNull
    private final Paint b = new Paint(1);

    /* JADX INFO: compiled from: BorderDrawable.java */
    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return c.this;
        }
    }

    c(l lVar) {
        this.f15380o = lVar;
        this.b.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader b() {
        copyBounds(this.f15369d);
        float fHeight = this.f15373h / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{ColorUtils.compositeColors(this.f15374i, this.f15378m), ColorUtils.compositeColors(this.f15375j, this.f15378m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f15375j, 0), this.f15378m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f15377l, 0), this.f15378m), ColorUtils.compositeColors(this.f15377l, this.f15378m), ColorUtils.compositeColors(this.f15376k, this.f15378m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    public void a(@Dimension float f2) {
        if (this.f15373h != f2) {
            this.f15373h = f2;
            this.b.setStrokeWidth(f2 * 1.3333f);
            this.f15379n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f15379n) {
            this.b.setShader(b());
            this.f15379n = false;
        }
        float strokeWidth = this.b.getStrokeWidth() / 2.0f;
        copyBounds(this.f15369d);
        this.f15370e.set(this.f15369d);
        float fMin = Math.min(this.f15380o.j().a(a()), this.f15370e.width() / 2.0f);
        if (this.f15380o.a(a())) {
            this.f15370e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f15370e, fMin, fMin, this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f15372g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f15373h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f15380o.a(a())) {
            outline.setRoundRect(getBounds(), this.f15380o.j().a(a()));
            return;
        }
        copyBounds(this.f15369d);
        this.f15370e.set(this.f15369d);
        this.a.a(this.f15380o, 1.0f, this.f15370e, this.f15368c);
        if (this.f15368c.isConvex()) {
            outline.setConvexPath(this.f15368c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (!this.f15380o.a(a())) {
            return true;
        }
        int iRound = Math.round(this.f15373h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f15381p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f15379n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f15381p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f15378m)) != this.f15378m) {
            this.f15379n = true;
            this.f15378m = colorForState;
        }
        if (this.f15379n) {
            invalidateSelf();
        }
        return this.f15379n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.b.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    void a(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f15378m = colorStateList.getColorForState(getState(), this.f15378m);
        }
        this.f15381p = colorStateList;
        this.f15379n = true;
        invalidateSelf();
    }

    void a(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        this.f15374i = i2;
        this.f15375j = i3;
        this.f15376k = i4;
        this.f15377l = i5;
    }

    @NonNull
    protected RectF a() {
        this.f15371f.set(getBounds());
        return this.f15371f;
    }

    public void a(l lVar) {
        this.f15380o = lVar;
        invalidateSelf();
    }
}
