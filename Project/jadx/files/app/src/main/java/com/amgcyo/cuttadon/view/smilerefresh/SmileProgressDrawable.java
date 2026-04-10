package com.amgcyo.cuttadon.view.smilerefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.fatcatfat.io.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SmileProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator A = new DecelerateInterpolator();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Animation f5554s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f5556u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final d f5558w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f5559x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View f5560y;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5555t = 2332;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ArrayList<Animation> f5557v = new ArrayList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Drawable.Callback f5561z = new c();

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    class a extends Animation {
        a() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SmileProgressDrawable smileProgressDrawable = SmileProgressDrawable.this;
            smileProgressDrawable.a(f2, smileProgressDrawable.f5558w);
            SmileProgressDrawable.this.f5558w.a(f2);
        }
    }

    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            SmileProgressDrawable.this.f5558w.d();
            SmileProgressDrawable smileProgressDrawable = SmileProgressDrawable.this;
            smileProgressDrawable.f5556u = (smileProgressDrawable.f5556u + 1.0f) % 5.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            SmileProgressDrawable.this.f5556u = 0.0f;
        }
    }

    class c implements Drawable.Callback {
        c() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            SmileProgressDrawable.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            SmileProgressDrawable.this.scheduleSelf(runnable, j2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            SmileProgressDrawable.this.unscheduleSelf(runnable);
        }
    }

    private static class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Drawable.Callback f5564c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f5566e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5568g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f5569h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f5570i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f5571j;
        private final RectF a = new RectF();
        private final Paint b = new Paint();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int[] f5565d = {g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5567f = -16777216;

        public d(Context context, Drawable.Callback callback) {
            new Paint(1);
            this.f5564c = callback;
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setAntiAlias(true);
            this.b.setStrokeCap(Paint.Cap.ROUND);
            this.f5570i = a(context, 2);
            this.b.setStrokeWidth(this.f5570i);
        }

        private int a(Context context, int i2) {
            return Math.round(i2 * context.getResources().getDisplayMetrics().density);
        }

        private int e() {
            return (this.f5566e + 1) % this.f5565d.length;
        }

        private void f() {
            this.f5564c.invalidateDrawable(null);
        }

        public int b() {
            return this.f5565d[e()];
        }

        public int c() {
            return this.f5565d[this.f5566e];
        }

        public void d() {
            b(e());
        }

        public void b(int i2) {
            this.f5566e = i2;
            this.f5567f = this.f5565d[this.f5566e];
        }

        public void a(@NonNull int[] iArr) {
            this.f5565d = iArr;
            b(0);
        }

        public void b(float f2) {
            this.f5570i = f2;
            this.b.setStrokeWidth(f2);
        }

        public int a() {
            return this.f5571j;
        }

        public void a(int i2) {
            this.f5567f = i2;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            rectF.set(rect);
            canvas.translate(rectF.width() / 2.0f, rectF.height() / 2.0f);
            this.b.setColor(this.f5567f);
            a(canvas, this.b, rectF);
        }

        private void a(Canvas canvas, Paint paint, RectF rectF) {
            float f2;
            float f3;
            int i2;
            int i3;
            float fMin = (Math.min(rectF.width(), rectF.height()) * 0.4f) / 2.0f;
            float fSqrt = ((float) Math.sqrt(2.0d)) * fMin;
            float f4 = -fSqrt;
            RectF rectF2 = new RectF(f4, f4, fSqrt, fSqrt);
            canvas.save();
            if (this.f5569h >= 135) {
                canvas.rotate(r0 - 135);
            }
            int i4 = this.f5569h;
            float f5 = 140.0f;
            if (i4 < 135) {
                f3 = i4 + 5;
                i2 = (i4 / 3) + 170;
            } else {
                if (i4 < 270) {
                    i3 = (i4 / 3) + 170;
                } else if (i4 < 630) {
                    i3 = 260 - ((i4 - SubsamplingScaleImageView.ORIENTATION_270) / 5);
                } else if (i4 < 720) {
                    f3 = (135 - ((i4 - 630) / 2)) + 5;
                    i2 = 260 - ((i4 - SubsamplingScaleImageView.ORIENTATION_270) / 5);
                } else {
                    f5 = ((135 - ((i4 - 630) / 2)) - ((i4 - 720) / 6)) + 5;
                    f2 = 170.0f;
                    canvas.drawArc(rectF2, f5, f2, false, paint);
                    float f6 = -fMin;
                    canvas.drawPoints(new float[]{f6, f6, fMin, f6}, paint);
                    canvas.restore();
                }
                f2 = i3;
                canvas.drawArc(rectF2, f5, f2, false, paint);
                float f62 = -fMin;
                canvas.drawPoints(new float[]{f62, f62, fMin, f62}, paint);
                canvas.restore();
            }
            f2 = i2;
            f5 = f3;
            canvas.drawArc(rectF2, f5, f2, false, paint);
            float f622 = -fMin;
            canvas.drawPoints(new float[]{f622, f622, fMin, f622}, paint);
            canvas.restore();
        }

        public void a(float f2) {
            this.f5568g = this.f5569h;
            if (f2 <= 1.0f) {
                this.f5569h = (int) (f2 * 855.0f);
            } else {
                this.f5569h = (int) f2;
            }
            if (this.f5568g != this.f5569h) {
                f();
            }
        }
    }

    static {
        new LinearInterpolator();
        new int[1][0] = -16777216;
    }

    public SmileProgressDrawable(Context context, View view) {
        this.f5560y = view;
        this.f5558w = new d(context, this.f5561z);
        a();
    }

    public void b(float f2) {
        this.f5558w.b(f2);
    }

    public void b(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int iSave = canvas.save();
        canvas.rotate(this.f5559x, bounds.exactCenterX(), bounds.exactCenterY());
        this.f5558w.a(canvas, bounds);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5558w.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f5557v;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animation animation = arrayList.get(i2);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f5554s.setDuration(this.f5555t);
        this.f5560y.startAnimation(this.f5554s);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f5560y.clearAnimation();
        this.f5558w.b(0);
        this.f5558w.a(0.0f);
    }

    public void a(int[] iArr) {
        this.f5558w.a(iArr);
        this.f5558w.b(0);
    }

    public void a(int i2) {
        this.f5555t = i2;
    }

    private void a() {
        a aVar = new a();
        aVar.setRepeatCount(-1);
        aVar.setRepeatMode(1);
        aVar.setInterpolator(A);
        aVar.setAnimationListener(new b());
        this.f5554s = aVar;
    }

    public void a(Interpolator interpolator) {
        this.f5554s.setInterpolator(interpolator);
    }

    public void a(float f2) {
        this.f5558w.a(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, d dVar) {
        if (f2 > 0.75f) {
            dVar.a(a((f2 - 0.75f) / 0.25f, dVar.c(), dVar.b()));
        }
    }

    private int a(float f2, int i2, int i3) {
        int iIntValue = Integer.valueOf(i2).intValue();
        int i4 = (iIntValue >> 24) & 255;
        int i5 = (iIntValue >> 16) & 255;
        int i6 = (iIntValue >> 8) & 255;
        int i7 = iIntValue & 255;
        int iIntValue2 = Integer.valueOf(i3).intValue();
        return ((i4 + ((int) ((((iIntValue2 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((iIntValue2 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((iIntValue2 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((iIntValue2 & 255) - i7))));
    }
}
