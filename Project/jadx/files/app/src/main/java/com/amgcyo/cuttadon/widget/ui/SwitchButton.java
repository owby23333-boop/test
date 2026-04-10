package com.amgcyo.cuttadon.widget.ui;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class SwitchButton extends View implements Checkable {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final int f5705r0 = b(48.0f);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final int f5706s0 = b(48.0f);
    private float A;
    private float B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private float K;
    private int L;
    private int M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private float S;
    private Paint T;
    private Paint U;
    private e V;
    private e W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private e f5707a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private RectF f5708b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f5709c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private ValueAnimator f5710d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final ArgbEvaluator f5711e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f5712f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private boolean f5713g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f5714h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f5715i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f5716j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f5717k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f5718l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private d f5719m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private long f5720n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private Runnable f5721o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f5722p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private Animator.AnimatorListener f5723q0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f5724s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5725t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5726u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f5727v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f5728w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f5729x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f5730y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f5731z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwitchButton.this.c()) {
                return;
            }
            SwitchButton.this.f();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = SwitchButton.this.f5709c0;
            if (i2 == 1 || i2 == 3 || i2 == 4) {
                SwitchButton.this.V.f5735c = ((Integer) SwitchButton.this.f5711e0.evaluate(fFloatValue, Integer.valueOf(SwitchButton.this.W.f5735c), Integer.valueOf(SwitchButton.this.f5707a0.f5735c))).intValue();
                SwitchButton.this.V.f5736d = SwitchButton.this.W.f5736d + ((SwitchButton.this.f5707a0.f5736d - SwitchButton.this.W.f5736d) * fFloatValue);
                if (SwitchButton.this.f5709c0 != 1) {
                    SwitchButton.this.V.a = SwitchButton.this.W.a + ((SwitchButton.this.f5707a0.a - SwitchButton.this.W.a) * fFloatValue);
                }
                SwitchButton.this.V.b = ((Integer) SwitchButton.this.f5711e0.evaluate(fFloatValue, Integer.valueOf(SwitchButton.this.W.b), Integer.valueOf(SwitchButton.this.f5707a0.b))).intValue();
            } else if (i2 == 5) {
                SwitchButton.this.V.a = SwitchButton.this.W.a + ((SwitchButton.this.f5707a0.a - SwitchButton.this.W.a) * fFloatValue);
                float f2 = (SwitchButton.this.V.a - SwitchButton.this.R) / (SwitchButton.this.S - SwitchButton.this.R);
                SwitchButton.this.V.b = ((Integer) SwitchButton.this.f5711e0.evaluate(f2, Integer.valueOf(SwitchButton.this.F), Integer.valueOf(SwitchButton.this.G))).intValue();
                SwitchButton.this.V.f5736d = SwitchButton.this.f5727v * f2;
                SwitchButton.this.V.f5735c = ((Integer) SwitchButton.this.f5711e0.evaluate(f2, 0, Integer.valueOf(SwitchButton.this.I))).intValue();
            }
            SwitchButton.this.postInvalidate();
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i2 = SwitchButton.this.f5709c0;
            if (i2 == 1) {
                SwitchButton.this.f5709c0 = 2;
                SwitchButton.this.V.f5735c = 0;
                SwitchButton.this.V.f5736d = SwitchButton.this.f5727v;
                SwitchButton.this.postInvalidate();
                return;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    SwitchButton.this.f5709c0 = 0;
                    SwitchButton.this.postInvalidate();
                    return;
                }
                if (i2 == 4) {
                    SwitchButton.this.f5709c0 = 0;
                    SwitchButton.this.postInvalidate();
                    SwitchButton.this.a();
                } else {
                    if (i2 != 5) {
                        return;
                    }
                    SwitchButton.this.f5712f0 = !r4.f5712f0;
                    SwitchButton.this.f5709c0 = 0;
                    SwitchButton.this.postInvalidate();
                    SwitchButton.this.a();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface d {
        void a(SwitchButton switchButton, boolean z2);
    }

    private static class e {
        float a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f5736d;

        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(e eVar) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.f5735c = eVar.f5735c;
            this.f5736d = eVar.f5736d;
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5708b0 = new RectF();
        this.f5709c0 = 0;
        this.f5711e0 = new ArgbEvaluator();
        this.f5716j0 = false;
        this.f5717k0 = false;
        this.f5718l0 = false;
        this.f5721o0 = new a();
        this.f5722p0 = new b();
        this.f5723q0 = new c();
        a(context, attributeSet);
    }

    private void setCheckedViewState(e eVar) {
        eVar.f5736d = this.f5727v;
        eVar.b = this.G;
        eVar.f5735c = this.I;
        eVar.a = this.S;
    }

    private void setUncheckViewState(e eVar) {
        eVar.f5736d = 0.0f;
        eVar.b = this.F;
        eVar.f5735c = 0;
        eVar.a = this.R;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f5712f0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.U.setStrokeWidth(this.H);
        this.U.setStyle(Paint.Style.FILL);
        this.U.setColor(this.E);
        a(canvas, this.f5731z, this.A, this.B, this.C, this.f5727v, this.U);
        this.U.setStyle(Paint.Style.STROKE);
        this.U.setColor(this.F);
        a(canvas, this.f5731z, this.A, this.B, this.C, this.f5727v, this.U);
        if (this.f5715i0) {
            b(canvas);
        }
        float f2 = this.V.f5736d * 0.5f;
        this.U.setStyle(Paint.Style.STROKE);
        this.U.setColor(this.V.b);
        this.U.setStrokeWidth(this.H + (f2 * 2.0f));
        a(canvas, this.f5731z + f2, this.A + f2, this.B - f2, this.C - f2, this.f5727v, this.U);
        this.U.setStyle(Paint.Style.FILL);
        this.U.setStrokeWidth(1.0f);
        float f3 = this.f5731z;
        float f4 = this.A;
        float f5 = this.f5727v;
        a(canvas, f3, f4, f3 + (f5 * 2.0f), f4 + (f5 * 2.0f), 90.0f, 180.0f, this.U);
        float f6 = this.f5731z;
        float f7 = this.f5727v;
        float f8 = this.A;
        canvas.drawRect(f6 + f7, f8, this.V.a, f8 + (f7 * 2.0f), this.U);
        if (this.f5715i0) {
            a(canvas);
        }
        a(canvas, this.V.a, this.D);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(f5705r0, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(f5706s0, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int iB = b(20.0f);
        int iB2 = b(36.0f);
        this.f5729x = (iB - 0.0f) - 0.0f;
        this.f5730y = (iB2 - 0.0f) - 0.0f;
        this.f5727v = this.f5729x * 0.5f;
        this.f5728w = this.f5727v - this.H;
        this.f5731z = (getMeasuredWidth() - iB2) / 2.0f;
        this.A = (getMeasuredHeight() - iB) / 2.0f;
        float f2 = this.f5731z;
        this.B = this.f5730y + f2;
        float f3 = this.A;
        this.C = this.f5729x + f3;
        this.D = (f3 + this.C) * 0.5f;
        float f4 = this.f5727v;
        this.R = f2 + f4;
        this.S = this.B - f4;
        if (isChecked()) {
            setCheckedViewState(this.V);
        } else {
            setUncheckViewState(this.V);
        }
        this.f5717k0 = true;
        postInvalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f5716j0 = true;
            this.f5720n0 = System.currentTimeMillis();
            removeCallbacks(this.f5721o0);
            postDelayed(this.f5721o0, 100L);
        } else if (actionMasked == 1) {
            this.f5716j0 = false;
            removeCallbacks(this.f5721o0);
            if (System.currentTimeMillis() - this.f5720n0 <= 300) {
                toggle();
            } else if (b()) {
                boolean z2 = Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f;
                if (z2 == isChecked()) {
                    e();
                } else {
                    this.f5712f0 = z2;
                    g();
                }
            } else if (d()) {
                e();
            }
        } else if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            if (d()) {
                float fMax = Math.max(0.0f, Math.min(1.0f, x2 / getWidth()));
                e eVar = this.V;
                float f2 = this.R;
                eVar.a = f2 + ((this.S - f2) * fMax);
            } else if (b()) {
                float fMax2 = Math.max(0.0f, Math.min(1.0f, x2 / getWidth()));
                e eVar2 = this.V;
                float f3 = this.R;
                eVar2.a = f3 + ((this.S - f3) * fMax2);
                eVar2.b = ((Integer) this.f5711e0.evaluate(fMax2, Integer.valueOf(this.F), Integer.valueOf(this.G))).intValue();
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.f5716j0 = false;
            removeCallbacks(this.f5721o0);
            if (d() || b()) {
                e();
            }
        }
        return true;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (z2 == isChecked()) {
            postInvalidate();
        } else {
            a(this.f5713g0, false);
        }
    }

    public void setCheckedColor(int i2) {
        this.G = i2;
        postInvalidate();
    }

    public void setEnableEffect(boolean z2) {
        this.f5713g0 = z2;
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f5719m0 = dVar;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // android.view.View
    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
    }

    @Override // android.view.View
    public final void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(0, 0, 0, 0);
    }

    public void setShadowEffect(boolean z2) {
        if (this.f5714h0 == z2) {
            return;
        }
        this.f5714h0 = z2;
        if (this.f5714h0) {
            this.T.setShadowLayer(this.f5724s, 0.0f, this.f5725t, this.f5726u);
        } else {
            this.T.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        a(true);
    }

    private void b(Canvas canvas) {
        a(canvas, this.L, this.M, this.B - this.N, this.D, this.O, this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f5709c0 != 0;
    }

    private boolean d() {
        int i2 = this.f5709c0;
        return i2 == 1 || i2 == 3;
    }

    private void e() {
        if (b() || d()) {
            if (this.f5710d0.isRunning()) {
                this.f5710d0.cancel();
            }
            this.f5709c0 = 3;
            this.W.a(this.V);
            if (isChecked()) {
                setCheckedViewState(this.f5707a0);
            } else {
                setUncheckViewState(this.f5707a0);
            }
            this.f5710d0.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!c() && this.f5716j0) {
            if (this.f5710d0.isRunning()) {
                this.f5710d0.cancel();
            }
            this.f5709c0 = 1;
            this.W.a(this.V);
            this.f5707a0.a(this.V);
            if (isChecked()) {
                e eVar = this.f5707a0;
                int i2 = this.G;
                eVar.b = i2;
                eVar.a = this.S;
                eVar.f5735c = i2;
            } else {
                e eVar2 = this.f5707a0;
                eVar2.b = this.F;
                eVar2.a = this.R;
                eVar2.f5736d = this.f5727v;
            }
            this.f5710d0.start();
        }
    }

    private void g() {
        if (this.f5710d0.isRunning()) {
            this.f5710d0.cancel();
        }
        this.f5709c0 = 4;
        this.W.a(this.V);
        if (isChecked()) {
            setCheckedViewState(this.f5707a0);
        } else {
            setUncheckViewState(this.f5707a0);
        }
        this.f5710d0.start();
    }

    private boolean b() {
        return this.f5709c0 == 2;
    }

    private static int c(TypedArray typedArray, int i2, int i3) {
        return typedArray == null ? i3 : typedArray.getDimensionPixelOffset(i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R$styleable.SwitchButton) : null;
        this.f5714h0 = a(typedArrayObtainStyledAttributes, 10, true);
        this.L = a(typedArrayObtainStyledAttributes, 15, -5592406);
        this.M = c(typedArrayObtainStyledAttributes, 17, b(1.5f));
        this.N = a(10.0f);
        this.O = a(typedArrayObtainStyledAttributes, 16, a(4.0f));
        this.P = a(4.0f);
        this.Q = a(4.0f);
        this.f5724s = c(typedArrayObtainStyledAttributes, 12, b(2.5f));
        this.f5725t = c(typedArrayObtainStyledAttributes, 11, b(1.5f));
        this.f5726u = a(typedArrayObtainStyledAttributes, 9, 855638016);
        this.F = a(typedArrayObtainStyledAttributes, 14, 14540253);
        this.G = a(typedArrayObtainStyledAttributes, 4, -11414681);
        this.H = c(typedArrayObtainStyledAttributes, 1, b(1.0f));
        this.I = a(typedArrayObtainStyledAttributes, 5, -1);
        this.J = c(typedArrayObtainStyledAttributes, 6, b(1.0f));
        this.K = a(6.0f);
        int iA = a(typedArrayObtainStyledAttributes, 2, -1);
        int iB = b(typedArrayObtainStyledAttributes, 7, 300);
        this.f5712f0 = a(typedArrayObtainStyledAttributes, 3, false);
        this.f5715i0 = a(typedArrayObtainStyledAttributes, 13, true);
        this.E = a(typedArrayObtainStyledAttributes, 0, -1);
        this.f5713g0 = a(typedArrayObtainStyledAttributes, 8, true);
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        this.U = new Paint(1);
        this.T = new Paint(1);
        this.T.setColor(iA);
        if (this.f5714h0) {
            this.T.setShadowLayer(this.f5724s, 0.0f, this.f5725t, this.f5726u);
        }
        this.V = new e();
        this.W = new e();
        this.f5707a0 = new e();
        this.f5710d0 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f5710d0.setDuration(iB);
        this.f5710d0.setRepeatCount(0);
        this.f5710d0.addUpdateListener(this.f5722p0);
        this.f5710d0.addListener(this.f5723q0);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    private static int b(float f2) {
        return (int) a(f2);
    }

    private static int b(TypedArray typedArray, int i2, int i3) {
        return typedArray == null ? i3 : typedArray.getInt(i2, i3);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5708b0 = new RectF();
        this.f5709c0 = 0;
        this.f5711e0 = new ArgbEvaluator();
        this.f5716j0 = false;
        this.f5717k0 = false;
        this.f5718l0 = false;
        this.f5721o0 = new a();
        this.f5722p0 = new b();
        this.f5723q0 = new c();
        a(context, attributeSet);
    }

    protected void a(Canvas canvas) {
        int i2 = this.V.f5735c;
        float f2 = this.J;
        float f3 = this.f5731z;
        float f4 = this.f5727v;
        float f5 = (f3 + f4) - this.P;
        float f6 = this.D;
        float f7 = this.K;
        a(canvas, i2, f2, f5, f6 - f7, (f3 + f4) - this.Q, f6 + f7, this.U);
    }

    protected void a(Canvas canvas, int i2, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i2);
        paint.setStrokeWidth(f2);
        canvas.drawLine(f3, f4, f5, f6, paint);
    }

    protected void a(Canvas canvas, int i2, float f2, float f3, float f4, float f5, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i2);
        paint.setStrokeWidth(f2);
        canvas.drawCircle(f3, f4, f5, paint);
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float f5, float f6, float f7, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawArc(f2, f3, f4, f5, f6, f7, true, paint);
        } else {
            this.f5708b0.set(f2, f3, f4, f5);
            canvas.drawArc(this.f5708b0, f6, f7, true, paint);
        }
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f2, f3, f4, f5, f6, f6, paint);
        } else {
            this.f5708b0.set(f2, f3, f4, f5);
            canvas.drawRoundRect(this.f5708b0, f6, f6, paint);
        }
    }

    private void a(Canvas canvas, float f2, float f3) {
        canvas.drawCircle(f2, f3, this.f5728w, this.T);
        this.U.setStyle(Paint.Style.STROKE);
        this.U.setStrokeWidth(1.0f);
        this.U.setColor(-2236963);
        canvas.drawCircle(f2, f3, this.f5728w, this.U);
    }

    public void a(boolean z2) {
        a(z2, true);
    }

    private void a(boolean z2, boolean z3) {
        if (isEnabled()) {
            if (!this.f5718l0) {
                if (!this.f5717k0) {
                    this.f5712f0 = !this.f5712f0;
                    if (z3) {
                        a();
                        return;
                    }
                    return;
                }
                if (this.f5710d0.isRunning()) {
                    this.f5710d0.cancel();
                }
                if (this.f5713g0 && z2) {
                    this.f5709c0 = 5;
                    this.W.a(this.V);
                    if (isChecked()) {
                        setUncheckViewState(this.f5707a0);
                    } else {
                        setCheckedViewState(this.f5707a0);
                    }
                    this.f5710d0.start();
                    return;
                }
                this.f5712f0 = !this.f5712f0;
                if (isChecked()) {
                    setCheckedViewState(this.V);
                } else {
                    setUncheckViewState(this.V);
                }
                postInvalidate();
                if (z3) {
                    a();
                    return;
                }
                return;
            }
            throw new RuntimeException("should not switch the state in method: [onCheckedChanged]!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        d dVar = this.f5719m0;
        if (dVar != null) {
            this.f5718l0 = true;
            dVar.a(this, isChecked());
        }
        this.f5718l0 = false;
    }

    private static float a(float f2) {
        return TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    private static float a(TypedArray typedArray, int i2, float f2) {
        return typedArray == null ? f2 : typedArray.getDimension(i2, f2);
    }

    private static int a(TypedArray typedArray, int i2, int i3) {
        return typedArray == null ? i3 : typedArray.getColor(i2, i3);
    }

    private static boolean a(TypedArray typedArray, int i2, boolean z2) {
        return typedArray == null ? z2 : typedArray.getBoolean(i2, z2);
    }
}
