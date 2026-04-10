package com.amgcyo.cuttadon.view.shimmer;

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
/* JADX INFO: loaded from: classes.dex */
public final class b extends Drawable {
    private final ValueAnimator.AnimatorUpdateListener a = new ValueAnimator.AnimatorUpdateListener() { // from class: com.amgcyo.cuttadon.view.shimmer.a
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f5430s.a(valueAnimator);
        }
    };
    private final Paint b = new Paint();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f5431c = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Matrix f5432d = new Matrix();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private ValueAnimator f5433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Shimmer f5434f;

    public b() {
        this.b.setAntiAlias(true);
    }

    private float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    private void e() {
        Shimmer shimmer;
        Shader radialGradient;
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (iWidth == 0 || iHeight == 0 || (shimmer = this.f5434f) == null) {
            return;
        }
        int iB = shimmer.b(iWidth);
        int iA = this.f5434f.a(iHeight);
        Shimmer shimmer2 = this.f5434f;
        boolean z2 = true;
        if (shimmer2.f5411f != 1) {
            int i2 = shimmer2.f5408c;
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
            Shimmer shimmer3 = this.f5434f;
            radialGradient = new LinearGradient(0.0f, 0.0f, iB, f2, shimmer3.b, shimmer3.a, Shader.TileMode.CLAMP);
        } else {
            float f3 = iA / 2.0f;
            double dMax = Math.max(iB, iA);
            double dSqrt = Math.sqrt(2.0d);
            Double.isNaN(dMax);
            float f4 = (float) (dMax / dSqrt);
            Shimmer shimmer4 = this.f5434f;
            radialGradient = new RadialGradient(iB / 2.0f, f3, f4, shimmer4.b, shimmer4.a, Shader.TileMode.CLAMP);
        }
        this.b.setShader(radialGradient);
    }

    private void f() {
        boolean zIsStarted;
        if (this.f5434f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f5433e;
        if (valueAnimator != null) {
            zIsStarted = valueAnimator.isStarted();
            this.f5433e.cancel();
            this.f5433e.removeAllUpdateListeners();
        } else {
            zIsStarted = false;
        }
        Shimmer shimmer = this.f5434f;
        this.f5433e = ValueAnimator.ofFloat(0.0f, (shimmer.f5425t / shimmer.f5424s) + 1.0f);
        this.f5433e.setRepeatMode(this.f5434f.f5423r);
        this.f5433e.setStartDelay(this.f5434f.f5426u);
        this.f5433e.setRepeatCount(this.f5434f.f5422q);
        ValueAnimator valueAnimator2 = this.f5433e;
        Shimmer shimmer2 = this.f5434f;
        valueAnimator2.setDuration(shimmer2.f5424s + shimmer2.f5425t);
        this.f5433e.addUpdateListener(this.a);
        if (zIsStarted) {
            this.f5433e.start();
        }
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        invalidateSelf();
    }

    public boolean b() {
        ValueAnimator valueAnimator = this.f5433e;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    void c() {
        Shimmer shimmer;
        ValueAnimator valueAnimator = this.f5433e;
        if (valueAnimator == null || valueAnimator.isStarted() || (shimmer = this.f5434f) == null || !shimmer.f5420o || getCallback() == null) {
            return;
        }
        this.f5433e.start();
    }

    public void d() {
        if (this.f5433e == null || !b()) {
            return;
        }
        this.f5433e.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float fA;
        float fA2;
        if (this.f5434f == null || this.b.getShader() == null) {
            return;
        }
        float fTan = (float) Math.tan(Math.toRadians(this.f5434f.f5418m));
        float fHeight = this.f5431c.height() + (this.f5431c.width() * fTan);
        float fWidth = this.f5431c.width() + (fTan * this.f5431c.height());
        ValueAnimator valueAnimator = this.f5433e;
        float f2 = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i2 = this.f5434f.f5408c;
        if (i2 != 1) {
            if (i2 == 2) {
                fA2 = a(fWidth, -fWidth, animatedFraction);
            } else if (i2 != 3) {
                fA2 = a(-fWidth, fWidth, animatedFraction);
            } else {
                fA = a(fHeight, -fHeight, animatedFraction);
            }
            this.f5432d.reset();
            this.f5432d.setRotate(this.f5434f.f5418m, this.f5431c.width() / 2.0f, this.f5431c.height() / 2.0f);
            this.f5432d.postTranslate(fA2, f2);
            this.b.getShader().setLocalMatrix(this.f5432d);
            canvas.drawRect(this.f5431c, this.b);
        }
        fA = a(-fHeight, fHeight, animatedFraction);
        f2 = fA;
        fA2 = 0.0f;
        this.f5432d.reset();
        this.f5432d.setRotate(this.f5434f.f5418m, this.f5431c.width() / 2.0f, this.f5431c.height() / 2.0f);
        this.f5432d.postTranslate(fA2, f2);
        this.b.getShader().setLocalMatrix(this.f5432d);
        canvas.drawRect(this.f5431c, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Shimmer shimmer = this.f5434f;
        return (shimmer == null || !(shimmer.f5419n || shimmer.f5421p)) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f5431c.set(0, 0, rect.width(), rect.height());
        e();
        c();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void a(@Nullable Shimmer shimmer) {
        this.f5434f = shimmer;
        Shimmer shimmer2 = this.f5434f;
        if (shimmer2 != null) {
            this.b.setXfermode(new PorterDuffXfermode(shimmer2.f5421p ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        e();
        f();
        invalidateSelf();
    }

    @Nullable
    public Shimmer a() {
        return this.f5434f;
    }
}
