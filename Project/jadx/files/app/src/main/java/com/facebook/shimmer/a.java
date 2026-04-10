package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ShimmerDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends Drawable {
    private final ValueAnimator.AnimatorUpdateListener a = new C0312a();
    private final Paint b = new Paint();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f14829c = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Matrix f14830d = new Matrix();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private ValueAnimator f14831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Shimmer f14832f;

    /* JADX INFO: renamed from: com.facebook.shimmer.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShimmerDrawable.java */
    class C0312a implements ValueAnimator.AnimatorUpdateListener {
        C0312a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.invalidateSelf();
        }
    }

    public a() {
        this.b.setAntiAlias(true);
    }

    private float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    private void d() {
        Shimmer shimmer;
        Shader radialGradient;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (iWidth == 0 || iHeight == 0 || (shimmer = this.f14832f) == null) {
            return;
        }
        int iB = shimmer.b(iWidth);
        int iA = this.f14832f.a(iHeight);
        Shimmer shimmer2 = this.f14832f;
        boolean z2 = true;
        if (shimmer2.f14811f != 1) {
            int i2 = shimmer2.f14808c;
            if (i2 != 1 && i2 != 3) {
                z2 = false;
            }
            if (z2) {
                iB = 0;
            }
            if (!z2) {
                iA = 0;
            }
            float f2 = iA;
            Shimmer shimmer3 = this.f14832f;
            radialGradient = new LinearGradient(0.0f, 0.0f, iB, f2, shimmer3.b, shimmer3.a, Shader.TileMode.CLAMP);
        } else {
            float f3 = iA / 2.0f;
            double dMax = Math.max(iB, iA);
            double dSqrt = Math.sqrt(2.0d);
            Double.isNaN(dMax);
            float f4 = (float) (dMax / dSqrt);
            Shimmer shimmer4 = this.f14832f;
            radialGradient = new RadialGradient(iB / 2.0f, f3, f4, shimmer4.b, shimmer4.a, Shader.TileMode.CLAMP);
        }
        this.b.setShader(radialGradient);
    }

    private void e() {
        boolean zIsStarted;
        if (this.f14832f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f14831e;
        if (valueAnimator != null) {
            zIsStarted = valueAnimator.isStarted();
            this.f14831e.cancel();
            this.f14831e.removeAllUpdateListeners();
        } else {
            zIsStarted = false;
        }
        Shimmer shimmer = this.f14832f;
        this.f14831e = ValueAnimator.ofFloat(0.0f, (shimmer.f14825t / shimmer.f14824s) + 1.0f);
        this.f14831e.setRepeatMode(this.f14832f.f14823r);
        this.f14831e.setRepeatCount(this.f14832f.f14822q);
        ValueAnimator valueAnimator2 = this.f14831e;
        Shimmer shimmer2 = this.f14832f;
        valueAnimator2.setDuration(shimmer2.f14824s + shimmer2.f14825t);
        this.f14831e.addUpdateListener(this.a);
        if (zIsStarted) {
            this.f14831e.start();
        }
    }

    public void a(@Nullable Shimmer shimmer) {
        this.f14832f = shimmer;
        Shimmer shimmer2 = this.f14832f;
        if (shimmer2 != null) {
            this.b.setXfermode(new PorterDuffXfermode(shimmer2.f14821p ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        d();
        e();
        invalidateSelf();
    }

    void b() {
        Shimmer shimmer;
        ValueAnimator valueAnimator = this.f14831e;
        if (valueAnimator == null || valueAnimator.isStarted() || (shimmer = this.f14832f) == null || !shimmer.f14820o || getCallback() == null) {
            return;
        }
        this.f14831e.start();
    }

    public void c() {
        if (this.f14831e == null || !a()) {
            return;
        }
        this.f14831e.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float fA;
        float fA2;
        if (this.f14832f == null || this.b.getShader() == null) {
            return;
        }
        float fTan = (float) Math.tan(Math.toRadians(this.f14832f.f14818m));
        float fHeight = this.f14829c.height() + (this.f14829c.width() * fTan);
        float fWidth = this.f14829c.width() + (fTan * this.f14829c.height());
        ValueAnimator valueAnimator = this.f14831e;
        float f2 = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i2 = this.f14832f.f14808c;
        if (i2 != 1) {
            if (i2 == 2) {
                fA2 = a(fWidth, -fWidth, animatedFraction);
            } else if (i2 != 3) {
                fA2 = a(-fWidth, fWidth, animatedFraction);
            } else {
                fA = a(fHeight, -fHeight, animatedFraction);
            }
            this.f14830d.reset();
            this.f14830d.setRotate(this.f14832f.f14818m, this.f14829c.width() / 2.0f, this.f14829c.height() / 2.0f);
            this.f14830d.postTranslate(fA2, f2);
            this.b.getShader().setLocalMatrix(this.f14830d);
            canvas.drawRect(this.f14829c, this.b);
        }
        fA = a(-fHeight, fHeight, animatedFraction);
        f2 = fA;
        fA2 = 0.0f;
        this.f14830d.reset();
        this.f14830d.setRotate(this.f14832f.f14818m, this.f14829c.width() / 2.0f, this.f14829c.height() / 2.0f);
        this.f14830d.postTranslate(fA2, f2);
        this.b.getShader().setLocalMatrix(this.f14830d);
        canvas.drawRect(this.f14829c, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Shimmer shimmer = this.f14832f;
        return (shimmer == null || !(shimmer.f14819n || shimmer.f14821p)) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f14829c.set(0, 0, rect.width(), rect.height());
        d();
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public boolean a() {
        ValueAnimator valueAnimator = this.f14831e;
        return valueAnimator != null && valueAnimator.isStarted();
    }
}
