package com.amgcyo.cuttadon.widget.ui;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class SmoothCheckBox extends View implements Checkable {
    private static final int N = Color.parseColor("#FB4846");
    private static final int O = Color.parseColor("#DFDFDF");
    private float A;
    private float B;
    private float C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private h M;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Paint f5690s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Paint f5691t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Paint f5692u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Point[] f5693v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Point f5694w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Path f5695x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f5696y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f5697z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SmoothCheckBox.this.toggle();
            SmoothCheckBox.this.L = false;
            SmoothCheckBox.this.A = 0.0f;
            if (SmoothCheckBox.this.isChecked()) {
                SmoothCheckBox.this.c();
            } else {
                SmoothCheckBox.this.d();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmoothCheckBox.this.postInvalidate();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmoothCheckBox.this.B = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SmoothCheckBox smoothCheckBox = SmoothCheckBox.this;
            smoothCheckBox.I = SmoothCheckBox.b(smoothCheckBox.H, SmoothCheckBox.this.G, 1.0f - SmoothCheckBox.this.B);
            SmoothCheckBox.this.postInvalidate();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmoothCheckBox.this.C = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SmoothCheckBox.this.postInvalidate();
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmoothCheckBox.this.B = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SmoothCheckBox smoothCheckBox = SmoothCheckBox.this;
            smoothCheckBox.I = SmoothCheckBox.b(smoothCheckBox.G, SmoothCheckBox.this.J, SmoothCheckBox.this.B);
            SmoothCheckBox.this.postInvalidate();
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmoothCheckBox.this.C = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SmoothCheckBox.this.postInvalidate();
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmoothCheckBox.this.L = true;
            SmoothCheckBox.this.postInvalidate();
        }
    }

    public interface h {
        void a(SmoothCheckBox smoothCheckBox, boolean z2);
    }

    public SmoothCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.K;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        a(canvas);
        b(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.D = getMeasuredWidth();
        int measuredWidth = this.F;
        if (measuredWidth == 0) {
            measuredWidth = getMeasuredWidth() / 10;
        }
        this.F = measuredWidth;
        this.F = this.F > getMeasuredWidth() / 5 ? getMeasuredWidth() / 5 : this.F;
        int i6 = this.F;
        if (i6 < 3) {
            i6 = 3;
        }
        this.F = i6;
        Point point = this.f5694w;
        point.x = this.D / 2;
        point.y = getMeasuredHeight() / 2;
        this.f5693v[0].x = Math.round((getMeasuredWidth() / 30.0f) * 7.0f);
        this.f5693v[0].y = Math.round((getMeasuredHeight() / 30.0f) * 14.0f);
        this.f5693v[1].x = Math.round((getMeasuredWidth() / 30.0f) * 13.0f);
        this.f5693v[1].y = Math.round((getMeasuredHeight() / 30.0f) * 20.0f);
        this.f5693v[2].x = Math.round((getMeasuredWidth() / 30.0f) * 22.0f);
        this.f5693v[2].y = Math.round((getMeasuredHeight() / 30.0f) * 10.0f);
        Point[] pointArr = this.f5693v;
        double dPow = Math.pow(pointArr[1].x - pointArr[0].x, 2.0d);
        Point[] pointArr2 = this.f5693v;
        this.f5696y = (float) Math.sqrt(dPow + Math.pow(pointArr2[1].y - pointArr2[0].y, 2.0d));
        Point[] pointArr3 = this.f5693v;
        double dPow2 = Math.pow(pointArr3[2].x - pointArr3[1].x, 2.0d);
        Point[] pointArr4 = this.f5693v;
        this.f5697z = (float) Math.sqrt(dPow2 + Math.pow(pointArr4[2].y - pointArr4[1].y, 2.0d));
        this.f5691t.setStrokeWidth(this.F);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(a(i2), a(i3));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        setChecked(bundle.getBoolean("InstanceState"));
        super.onRestoreInstanceState(bundle.getParcelable("InstanceState"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("InstanceState", super.onSaveInstanceState());
        bundle.putBoolean("InstanceState", isChecked());
        return bundle;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        this.K = z2;
        b();
        invalidate();
        h hVar = this.M;
        if (hVar != null) {
            hVar.a(this, this.K);
        }
    }

    public void setOnCheckedChangeListener(h hVar) {
        this.M = hVar;
    }

    public void setmCheckedColor(int i2) {
        this.G = i2;
        postInvalidate();
    }

    public void setmUnCheckedColor(int i2) {
        this.H = i2;
        postInvalidate();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    public SmoothCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void d(Canvas canvas) {
        this.f5695x.reset();
        if (this.A < this.f5696y) {
            int i2 = this.D;
            this.A += ((float) i2) / 20.0f >= 3.0f ? i2 / 20.0f : 3.0f;
            Point[] pointArr = this.f5693v;
            float f2 = pointArr[0].x;
            float f3 = pointArr[1].x - pointArr[0].x;
            float f4 = this.A;
            float f5 = this.f5696y;
            this.f5695x.moveTo(pointArr[0].x, pointArr[0].y);
            this.f5695x.lineTo(f2 + ((f3 * f4) / f5), pointArr[0].y + (((pointArr[1].y - pointArr[0].y) * f4) / f5));
            canvas.drawPath(this.f5695x, this.f5691t);
            float f6 = this.A;
            float f7 = this.f5696y;
            if (f6 > f7) {
                this.A = f7;
            }
        } else {
            Path path = this.f5695x;
            Point[] pointArr2 = this.f5693v;
            path.moveTo(pointArr2[0].x, pointArr2[0].y);
            Path path2 = this.f5695x;
            Point[] pointArr3 = this.f5693v;
            path2.lineTo(pointArr3[1].x, pointArr3[1].y);
            canvas.drawPath(this.f5695x, this.f5691t);
            float f8 = this.A;
            float f9 = this.f5696y;
            float f10 = this.f5697z;
            if (f8 < f9 + f10) {
                Point[] pointArr4 = this.f5693v;
                float f11 = pointArr4[1].x + (((pointArr4[2].x - pointArr4[1].x) * (f8 - f9)) / f10);
                float f12 = pointArr4[1].y - (((pointArr4[1].y - pointArr4[2].y) * (f8 - f9)) / f10);
                this.f5695x.reset();
                Path path3 = this.f5695x;
                Point[] pointArr5 = this.f5693v;
                path3.moveTo(pointArr5[1].x, pointArr5[1].y);
                this.f5695x.lineTo(f11, f12);
                canvas.drawPath(this.f5695x, this.f5691t);
                this.A += this.D / 20 >= 3 ? r11 / 20 : 3.0f;
            } else {
                this.f5695x.reset();
                Path path4 = this.f5695x;
                Point[] pointArr6 = this.f5693v;
                path4.moveTo(pointArr6[1].x, pointArr6[1].y);
                Path path5 = this.f5695x;
                Point[] pointArr7 = this.f5693v;
                path5.lineTo(pointArr7[2].x, pointArr7[2].y);
                canvas.drawPath(this.f5695x, this.f5691t);
            }
        }
        if (this.A < this.f5696y + this.f5697z) {
            postDelayed(new b(), 10L);
        }
    }

    public SmoothCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B = 1.0f;
        this.C = 1.0f;
        a(attributeSet);
    }

    private void b() {
        this.L = true;
        this.C = 1.0f;
        this.B = isChecked() ? 0.0f : 1.0f;
        this.I = isChecked() ? this.G : this.J;
        this.A = isChecked() ? this.f5696y + this.f5697z : 0.0f;
    }

    private void c(Canvas canvas) {
        if (this.L && isChecked()) {
            d(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration((this.E / 3) * 2);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new c());
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        valueAnimatorOfFloat2.setDuration(this.E);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new d());
        valueAnimatorOfFloat2.start();
        a();
    }

    @TargetApi(21)
    public SmoothCheckBox(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.B = 1.0f;
        this.C = 1.0f;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SmoothCheckBox);
        int color = typedArrayObtainStyledAttributes.getColor(1, -1);
        this.E = typedArrayObtainStyledAttributes.getInt(4, 300);
        this.I = typedArrayObtainStyledAttributes.getColor(3, O);
        this.G = typedArrayObtainStyledAttributes.getColor(0, N);
        this.H = typedArrayObtainStyledAttributes.getColor(2, -1);
        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, com.amgcyo.cuttadon.widget.util.a.a(getContext(), 0.0f));
        typedArrayObtainStyledAttributes.recycle();
        this.J = this.I;
        this.f5691t = new Paint(1);
        this.f5691t.setStyle(Paint.Style.STROKE);
        this.f5691t.setStrokeCap(Paint.Cap.ROUND);
        this.f5691t.setColor(color);
        this.f5692u = new Paint(1);
        this.f5692u.setStyle(Paint.Style.FILL);
        this.f5692u.setColor(this.I);
        this.f5690s = new Paint(1);
        this.f5690s.setStyle(Paint.Style.FILL);
        this.f5690s.setColor(this.G);
        this.f5695x = new Path();
        this.f5694w = new Point();
        this.f5693v = new Point[3];
        this.f5693v[0] = new Point();
        this.f5693v[1] = new Point();
        this.f5693v[2] = new Point();
        setOnClickListener(new a());
    }

    private void b(Canvas canvas) {
        this.f5690s.setColor(this.H);
        canvas.drawCircle(this.f5694w.x, r0.y, (r1 - this.F) * this.B, this.f5690s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.E);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new e());
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        valueAnimatorOfFloat2.setDuration(this.E);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new f());
        valueAnimatorOfFloat2.start();
    }

    public void a(boolean z2, boolean z3) {
        if (z3) {
            this.L = false;
            this.K = z2;
            this.A = 0.0f;
            if (z2) {
                c();
            } else {
                d();
            }
            h hVar = this.M;
            if (hVar != null) {
                hVar.a(this, this.K);
                return;
            }
            return;
        }
        setChecked(z2);
    }

    private int a(int i2) {
        int iA = com.amgcyo.cuttadon.widget.util.a.a(getContext(), 25.0f);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return Math.min(iA, size);
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private void a(Canvas canvas) {
        this.f5692u.setColor(this.I);
        int i2 = this.f5694w.x;
        canvas.drawCircle(i2, r0.y, i2 * this.C, this.f5692u);
    }

    private void a() {
        postDelayed(new g(), this.E);
    }
}
