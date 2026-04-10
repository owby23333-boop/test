package com.mardous.discreteseekbar.a.d;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;

/* JADX INFO: compiled from: AlmostRippleDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends c implements Animatable {
    private boolean A;
    private int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private final Runnable I;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f17627w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Interpolator f17628x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f17629y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f17630z;

    /* JADX INFO: renamed from: com.mardous.discreteseekbar.a.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AlmostRippleDrawable.java */
    class RunnableC0499a implements Runnable {
        RunnableC0499a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j2 = jUptimeMillis - a.this.f17629y;
            if (j2 < a.this.B) {
                float interpolation = a.this.f17628x.getInterpolation(j2 / a.this.B);
                a aVar = a.this;
                aVar.scheduleSelf(aVar.I, jUptimeMillis + 16);
                a.this.a(interpolation);
                return;
            }
            a aVar2 = a.this;
            aVar2.unscheduleSelf(aVar2.I);
            a.this.A = false;
            a.this.a(1.0f);
        }
    }

    public a(@NonNull ColorStateList colorStateList) {
        super(colorStateList);
        this.f17627w = 0.0f;
        this.f17630z = false;
        this.A = false;
        this.B = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.I = new RunnableC0499a();
        this.f17628x = new AccelerateDecelerateInterpolator();
        b(colorStateList);
    }

    private int b(int i2) {
        return (i2 * 100) >> 8;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.A;
    }

    @Override // com.mardous.discreteseekbar.a.d.c, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        boolean z2;
        int[] state = getState();
        int length = state.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z2 = false;
                break;
            }
            if (state[i2] == 16842919) {
                z2 = true;
                break;
            }
            i2++;
        }
        super.setState(iArr);
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = false;
        for (int i3 : iArr) {
            if (i3 == 16842908) {
                z5 = true;
            } else if (i3 == 16842919) {
                z4 = true;
            } else if (i3 == 16842910) {
                z3 = false;
            }
        }
        if (z3) {
            unscheduleSelf(this.I);
            this.G = this.F;
            this.H = 0;
            this.f17627w = 0.5f;
            invalidateSelf();
        } else if (z4) {
            b();
            int i4 = this.D;
            this.H = i4;
            this.G = i4;
        } else if (z2) {
            int i5 = this.D;
            this.H = i5;
            this.G = i5;
            a();
        } else if (z5) {
            this.G = this.E;
            this.H = 0;
            this.f17627w = 1.0f;
            invalidateSelf();
        } else {
            this.G = 0;
            this.H = 0;
            this.f17627w = 0.0f;
            invalidateSelf();
        }
        return true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    public void b(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.E = colorStateList.getColorForState(new int[]{R.attr.state_enabled, R.attr.state_focused}, defaultColor);
        this.D = colorStateList.getColorForState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, defaultColor);
        this.F = colorStateList.getColorForState(new int[]{-16842910}, defaultColor);
        this.E = a(130, this.E);
        this.D = a(130, this.D);
        this.F = a(130, this.F);
    }

    private static int a(int i2, int i3) {
        return Color.argb((Color.alpha(i3) * (i2 + (i2 >> 7))) >> 8, Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    @Override // com.mardous.discreteseekbar.a.d.c
    public void a(Canvas canvas, Paint paint) {
        Rect bounds = getBounds();
        int iMin = Math.min(bounds.width(), bounds.height());
        float f2 = this.f17627w;
        int i2 = this.G;
        int i3 = this.H;
        float f3 = iMin / 2;
        float f4 = f3 * f2;
        if (f2 > 0.0f) {
            if (i3 != 0) {
                paint.setColor(i3);
                paint.setAlpha(b(Color.alpha(i3)));
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), f3, paint);
            }
            if (i2 != 0) {
                paint.setColor(i2);
                paint.setAlpha(a(Color.alpha(i2)));
                canvas.drawCircle(bounds.centerX(), bounds.centerY(), f4, paint);
            }
        }
    }

    public void b() {
        unscheduleSelf(this.I);
        float f2 = this.f17627w;
        if (f2 < 1.0f) {
            this.f17630z = false;
            this.A = true;
            this.C = f2;
            this.B = (int) ((1.0f - ((this.C - 0.0f) / 1.0f)) * 250.0f);
            this.f17629y = SystemClock.uptimeMillis();
            scheduleSelf(this.I, this.f17629y + 16);
        }
    }

    public void a() {
        unscheduleSelf(this.I);
        float f2 = this.f17627w;
        if (f2 > 0.0f) {
            this.f17630z = true;
            this.A = true;
            this.C = f2;
            this.B = (int) ((1.0f - ((this.C - 1.0f) / (-1.0f))) * 250.0f);
            this.f17629y = SystemClock.uptimeMillis();
            scheduleSelf(this.I, this.f17629y + 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        float f3 = this.C;
        this.f17627w = f3 + (((this.f17630z ? 0.0f : 1.0f) - f3) * f2);
        invalidateSelf();
    }
}
