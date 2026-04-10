package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ClockHandView extends View {
    private final float A;
    private final Paint B;
    private final RectF C;

    @Px
    private final int D;
    private float E;
    private boolean F;
    private c G;
    private double H;
    private int I;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ValueAnimator f16035s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f16036t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f16037u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f16038v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f16039w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f16040x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List<d> f16041y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f16042z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b(ClockHandView clockHandView) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 360.0d) float f2, boolean z2);
    }

    public interface d {
        void a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 360.0d) float f2, boolean z2);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    private Pair<Float, Float> b(float f2) {
        float fB = b();
        if (Math.abs(fB - f2) > 180.0f) {
            if (fB > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (fB < 180.0f && f2 > 180.0f) {
                fB += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(fB), Float.valueOf(f2));
    }

    public int c() {
        return this.f16042z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        a(b());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x2 - this.f16037u);
                int i3 = (int) (y2 - this.f16038v);
                this.f16039w = (i2 * i2) + (i3 * i3) > this.f16040x;
                boolean z5 = this.F;
                z2 = actionMasked == 1;
                z3 = z5;
            } else {
                z2 = false;
                z3 = false;
            }
            z4 = false;
        } else {
            this.f16037u = x2;
            this.f16038v = y2;
            this.f16039w = true;
            this.F = false;
            z2 = false;
            z3 = false;
            z4 = true;
        }
        this.F = a(x2, y2, z3, z4, z2) | this.F;
        if (this.F && z2 && (cVar = this.G) != null) {
            cVar.a(a(x2, y2), this.f16039w);
        }
        return true;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public void a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 360.0d) float f2) {
        a(f2, false);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16041y = new ArrayList();
        this.B = new Paint();
        this.C = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i2, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.f16042z = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        this.D = getResources().getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.A = r5.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        this.B.setAntiAlias(true);
        this.B.setColor(color);
        a(0.0f);
        this.f16040x = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 360.0d) float f2, boolean z2) {
        ValueAnimator valueAnimator = this.f16035s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            b(f2, false);
            return;
        }
        Pair<Float, Float> pairB = b(f2);
        this.f16035s = ValueAnimator.ofFloat(((Float) pairB.first).floatValue(), ((Float) pairB.second).floatValue());
        this.f16035s.setDuration(200L);
        this.f16035s.addUpdateListener(new a());
        this.f16035s.addListener(new b(this));
        this.f16035s.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 360.0d) float f2, boolean z2) {
        float f3 = f2 % 360.0f;
        this.E = f3;
        this.H = Math.toRadians(this.E - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.I * ((float) Math.cos(this.H)));
        float fSin = height + (this.I * ((float) Math.sin(this.H)));
        RectF rectF = this.C;
        int i2 = this.f16042z;
        rectF.set(width - i2, fSin - i2, width + i2, fSin + i2);
        Iterator<d> it = this.f16041y.iterator();
        while (it.hasNext()) {
            it.next().a(f3, z2);
        }
        invalidate();
    }

    public void a(d dVar) {
        this.f16041y.add(dVar);
    }

    private void a(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float fCos = (this.I * ((float) Math.cos(this.H))) + width;
        float f2 = height;
        float fSin = (this.I * ((float) Math.sin(this.H))) + f2;
        this.B.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f16042z, this.B);
        double dSin = Math.sin(this.H);
        double dCos = Math.cos(this.H);
        Double.isNaN(d);
        Double.isNaN(d);
        this.B.setStrokeWidth(this.D);
        canvas.drawLine(width, f2, r1 + ((int) (dCos * d)), height + ((int) (d * dSin)), this.B);
        canvas.drawCircle(width, f2, this.A, this.B);
    }

    @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 360.0d)
    public float b() {
        return this.E;
    }

    public RectF a() {
        return this.C;
    }

    public void a(@Dimension int i2) {
        this.I = i2;
        invalidate();
    }

    private boolean a(float f2, float f3, boolean z2, boolean z3, boolean z4) {
        float fA = a(f2, f3);
        boolean z5 = false;
        boolean z6 = b() != fA;
        if (z3 && z6) {
            return true;
        }
        if (!z6 && !z2) {
            return false;
        }
        if (z4 && this.f16036t) {
            z5 = true;
        }
        a(fA, z5);
        return true;
    }

    private int a(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f3 - (getHeight() / 2), f2 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }
}
