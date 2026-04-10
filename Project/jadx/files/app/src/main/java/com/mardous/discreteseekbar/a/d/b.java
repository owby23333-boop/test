package com.mardous.discreteseekbar.a.d;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;

/* JADX INFO: compiled from: MarkerDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends c implements Animatable {
    private boolean A;
    private int B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private Path H;
    private RectF I;
    private Matrix J;
    private InterfaceC0500b K;
    private final Runnable L;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f17632w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Interpolator f17633x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f17634y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f17635z;

    /* JADX INFO: compiled from: MarkerDrawable.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j2 = jUptimeMillis - b.this.f17634y;
            if (j2 < b.this.B) {
                float interpolation = b.this.f17633x.getInterpolation(j2 / b.this.B);
                b bVar = b.this;
                bVar.scheduleSelf(bVar.L, jUptimeMillis + 16);
                b.this.a(interpolation);
                return;
            }
            b bVar2 = b.this;
            bVar2.unscheduleSelf(bVar2.L);
            b.this.A = false;
            b.this.a(1.0f);
            b.this.c();
        }
    }

    /* JADX INFO: renamed from: com.mardous.discreteseekbar.a.d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MarkerDrawable.java */
    public interface InterfaceC0500b {
        void a();

        void b();
    }

    public b(@NonNull ColorStateList colorStateList, int i2) {
        super(colorStateList);
        this.f17632w = 0.0f;
        this.f17635z = false;
        this.A = false;
        this.B = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.H = new Path();
        this.I = new RectF();
        this.J = new Matrix();
        this.L = new a();
        this.f17633x = new AccelerateDecelerateInterpolator();
        this.C = i2;
        this.F = colorStateList.getColorForState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, colorStateList.getDefaultColor());
        this.G = colorStateList.getDefaultColor();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.A;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        unscheduleSelf(this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        InterfaceC0500b interfaceC0500b = this.K;
        if (interfaceC0500b != null) {
            if (this.f17635z) {
                interfaceC0500b.a();
            } else {
                interfaceC0500b.b();
            }
        }
    }

    public void b(int i2) {
        this.E = i2;
    }

    public void b() {
        unscheduleSelf(this.L);
        this.f17635z = false;
        float f2 = this.f17632w;
        if (f2 < 1.0f) {
            this.A = true;
            this.D = f2;
            this.B = (int) ((1.0f - f2) * 250.0f);
            this.f17634y = SystemClock.uptimeMillis();
            scheduleSelf(this.L, this.f17634y + 16);
            return;
        }
        c();
    }

    @Override // com.mardous.discreteseekbar.a.d.c
    void a(Canvas canvas, Paint paint) {
        if (this.H.isEmpty()) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(a(this.F, this.G, this.f17632w));
        canvas.drawPath(this.H, paint);
    }

    private void a(Rect rect) {
        float f2 = this.f17632w;
        Path path = this.H;
        RectF rectF = this.I;
        Matrix matrix = this.J;
        path.reset();
        int iMin = Math.min(rect.width(), rect.height());
        float f3 = this.C;
        float f4 = f3 + ((iMin - f3) * f2);
        float f5 = f4 / 2.0f;
        float f6 = 1.0f - f2;
        float f7 = f5 * f6;
        float[] fArr = {f5, f5, f5, f5, f5, f5, f7, f7};
        int i2 = rect.left;
        int i3 = rect.top;
        rectF.set(i2, i3, i2 + f4, i3 + f4);
        path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        matrix.reset();
        matrix.postRotate(-45.0f, rect.left + f5, rect.top + f5);
        matrix.postTranslate((rect.width() - f4) / 2.0f, 0.0f);
        matrix.postTranslate(0.0f, ((rect.bottom - f4) - this.E) * f6);
        path.transform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        float f3 = this.D;
        this.f17632w = f3 + (((this.f17635z ? 0.0f : 1.0f) - f3) * f2);
        a(getBounds());
        invalidateSelf();
    }

    public void a() {
        this.f17635z = true;
        unscheduleSelf(this.L);
        float f2 = this.f17632w;
        if (f2 > 0.0f) {
            this.A = true;
            this.D = f2;
            this.B = 250 - ((int) ((1.0f - f2) * 250.0f));
            this.f17634y = SystemClock.uptimeMillis();
            scheduleSelf(this.L, this.f17634y + 16);
            return;
        }
        c();
    }

    public void a(InterfaceC0500b interfaceC0500b) {
        this.K = interfaceC0500b;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f2) + (Color.alpha(i3) * f3)), (int) ((Color.red(i2) * f2) + (Color.red(i3) * f3)), (int) ((Color.green(i2) * f2) + (Color.green(i3) * f3)), (int) ((Color.blue(i2) * f2) + (Color.blue(i3) * f3)));
    }
}
