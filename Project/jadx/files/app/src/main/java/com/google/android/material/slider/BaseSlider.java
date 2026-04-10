package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.l;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final String f15772u0 = BaseSlider.class.getSimpleName();

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    static final int f15773v0 = R$style.Widget_MaterialComponents_Slider;
    private BaseSlider<S, L, T>.d A;

    @NonNull
    private final f B;

    @NonNull
    private final List<com.google.android.material.l.a> C;

    @NonNull
    private final List<L> D;

    @NonNull
    private final List<T> E;
    private boolean F;
    private ValueAnimator G;
    private ValueAnimator H;
    private final int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private float T;
    private MotionEvent U;
    private com.google.android.material.slider.c V;
    private boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float f15774a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f15775b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private ArrayList<Float> f15776c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f15777d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f15778e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f15779f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private float[] f15780g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f15781h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f15782i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f15783j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f15784k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f15785l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    @NonNull
    private ColorStateList f15786m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @NonNull
    private ColorStateList f15787n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @NonNull
    private ColorStateList f15788o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    @NonNull
    private ColorStateList f15789p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    @NonNull
    private ColorStateList f15790q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f15791r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final Paint f15792s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private float f15793s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final Paint f15794t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f15795t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    private final Paint f15796u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    private final Paint f15797v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    private final Paint f15798w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    private final Paint f15799x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    private final e f15800y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final AccessibilityManager f15801z;

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        float f15802s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        float f15803t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        ArrayList<Float> f15804u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        float f15805v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f15806w;

        static class a implements Parcelable.Creator<SliderState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState[] newArray(int i2) {
                return new SliderState[i2];
            }
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f15802s);
            parcel.writeFloat(this.f15803t);
            parcel.writeList(this.f15804u);
            parcel.writeFloat(this.f15805v);
            parcel.writeBooleanArray(new boolean[]{this.f15806w});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.f15802s = parcel.readFloat();
            this.f15803t = parcel.readFloat();
            this.f15804u = new ArrayList<>();
            parcel.readList(this.f15804u, Float.class.getClassLoader());
            this.f15805v = parcel.readFloat();
            this.f15806w = parcel.createBooleanArray()[0];
        }
    }

    class a implements f {
        final /* synthetic */ AttributeSet a;
        final /* synthetic */ int b;

        a(AttributeSet attributeSet, int i2) {
            this.a = attributeSet;
            this.b = i2;
        }

        @Override // com.google.android.material.slider.BaseSlider.f
        public com.google.android.material.l.a a() {
            TypedArray typedArrayC = l.c(BaseSlider.this.getContext(), this.a, R$styleable.Slider, this.b, BaseSlider.f15773v0, new int[0]);
            com.google.android.material.l.a aVarB = BaseSlider.b(BaseSlider.this.getContext(), typedArrayC);
            typedArrayC.recycle();
            return aVarB;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.C.iterator();
            while (it.hasNext()) {
                ((com.google.android.material.l.a) it.next()).f(fFloatValue);
            }
            ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator it = BaseSlider.this.C.iterator();
            while (it.hasNext()) {
                s.b(BaseSlider.this).remove((com.google.android.material.l.a) it.next());
            }
        }
    }

    private static class e extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> a;
        Rect b;

        e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.b = new Rect();
            this.a = baseSlider;
        }

        @NonNull
        private String a(int i2) {
            return i2 == this.a.getValues().size() + (-1) ? this.a.getContext().getString(R$string.material_slider_range_end) : i2 == 0 ? this.a.getContext().getString(R$string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f2, float f3) {
            for (int i2 = 0; i2 < this.a.getValues().size(); i2++) {
                this.a.a(i2, this.b);
                if (this.b.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int i2 = 0; i2 < this.a.getValues().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (!this.a.isEnabled()) {
                return false;
            }
            if (i3 != 4096 && i3 != 8192) {
                if (i3 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.a.b(i2, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.a.r();
                        this.a.postInvalidate();
                        invalidateVirtualView(i2);
                        return true;
                    }
                }
                return false;
            }
            float fB = this.a.b(20);
            if (i3 == 8192) {
                fB = -fB;
            }
            if (this.a.b()) {
                fB = -fB;
            }
            if (!this.a.b(i2, MathUtils.clamp(this.a.getValues().get(i2).floatValue() + fB, this.a.getValueFrom(), this.a.getValueTo()))) {
                return false;
            }
            this.a.r();
            this.a.postInvalidate();
            invalidateVirtualView(i2);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.a.getValues();
            float fFloatValue = values.get(i2).floatValue();
            float valueFrom = this.a.getValueFrom();
            float valueTo = this.a.getValueTo();
            if (this.a.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (fFloatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, fFloatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.a.getContentDescription() != null) {
                sb.append(this.a.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(a(i2));
                sb.append(this.a.b(fFloatValue));
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.a.a(i2, this.b);
            accessibilityNodeInfoCompat.setBoundsInParent(this.b);
        }
    }

    private interface f {
        com.google.android.material.l.a a();
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    private void d(@NonNull Canvas canvas, int i2, int i3) {
        if (p()) {
            int iC = (int) (this.O + (c(this.f15776c0.get(this.f15778e0).floatValue()) * i2));
            if (Build.VERSION.SDK_INT < 28) {
                int i4 = this.R;
                canvas.clipRect(iC - i4, i3 - i4, iC + i4, i4 + i3, Region.Op.UNION);
            }
            canvas.drawCircle(iC, i3, this.R, this.f15797v);
        }
    }

    private int e() {
        return this.P + (this.M == 1 ? this.C.get(0).getIntrinsicHeight() : 0);
    }

    private boolean f(float f2) {
        double dDoubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.f15774a0))).divide(new BigDecimal(Float.toString(this.f15779f0)), MathContext.DECIMAL64).doubleValue();
        double dRound = Math.round(dDoubleValue);
        Double.isNaN(dRound);
        return Math.abs(dRound - dDoubleValue) < 1.0E-4d;
    }

    private float g(float f2) {
        return (c(f2) * this.f15782i0) + this.O;
    }

    private float[] getActiveRange() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.f15776c0.size() == 1) {
            fFloatValue2 = this.f15774a0;
        }
        float fC = c(fFloatValue2);
        float fC2 = c(fFloatValue);
        return b() ? new float[]{fC2, fC} : new float[]{fC, fC2};
    }

    private float getValueOfTouchPosition() {
        double dE = e(this.f15793s0);
        if (b()) {
            dE = 1.0d - dE;
        }
        float f2 = this.f15775b0;
        float f3 = this.f15774a0;
        double d2 = f2 - f3;
        Double.isNaN(d2);
        double d3 = f3;
        Double.isNaN(d3);
        return (float) ((dE * d2) + d3);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.f15793s0;
        if (b()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.f15775b0;
        float f4 = this.f15774a0;
        return (f2 * (f3 - f4)) + f4;
    }

    private void h(int i2) {
        this.f15782i0 = Math.max(i2 - (this.O * 2), 0);
        l();
    }

    private void i() {
        if (this.F) {
            this.F = false;
            this.H = a(false);
            this.G = null;
            this.H.addListener(new c());
            this.H.start();
        }
    }

    private void j() {
        this.f15792s.setStrokeWidth(this.N);
        this.f15794t.setStrokeWidth(this.N);
        this.f15798w.setStrokeWidth(this.N / 2.0f);
        this.f15799x.setStrokeWidth(this.N / 2.0f);
    }

    private boolean k() {
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private void l() {
        if (this.f15779f0 <= 0.0f) {
            return;
        }
        s();
        int iMin = Math.min((int) (((this.f15775b0 - this.f15774a0) / this.f15779f0) + 1.0f), (this.f15782i0 / (this.N * 2)) + 1);
        float[] fArr = this.f15780g0;
        if (fArr == null || fArr.length != iMin * 2) {
            this.f15780g0 = new float[iMin * 2];
        }
        float f2 = this.f15782i0 / (iMin - 1);
        for (int i2 = 0; i2 < iMin * 2; i2 += 2) {
            float[] fArr2 = this.f15780g0;
            fArr2[i2] = this.O + ((i2 / 2) * f2);
            fArr2[i2 + 1] = e();
        }
    }

    private void m() {
        this.O = this.J + Math.max(this.Q - this.K, 0);
        if (ViewCompat.isLaidOut(this)) {
            h(getWidth());
        }
    }

    private void n() {
        Iterator<T> it = this.E.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void o() {
        Iterator<T> it = this.E.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    private boolean p() {
        return this.f15783j0 || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    private boolean q() {
        return d(getValueOfTouchPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (p() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iC = (int) ((c(this.f15776c0.get(this.f15778e0).floatValue()) * this.f15782i0) + this.O);
            int iE = e();
            int i2 = this.R;
            DrawableCompat.setHotspotBounds(background, iC - i2, iE - i2, iC + i2, iE + i2);
        }
    }

    private void s() {
        if (this.f15785l0) {
            u();
            v();
            t();
            w();
            x();
            this.f15785l0 = false;
        }
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.f15776c0.size() == arrayList.size() && this.f15776c0.equals(arrayList)) {
            return;
        }
        this.f15776c0 = arrayList;
        this.f15785l0 = true;
        this.f15778e0 = 0;
        r();
        f();
        g();
        postInvalidate();
    }

    private void t() {
        if (this.f15779f0 > 0.0f && !f(this.f15775b0)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(this.f15779f0), Float.toString(this.f15774a0), Float.toString(this.f15775b0)));
        }
    }

    private void u() {
        float f2 = this.f15774a0;
        if (f2 >= this.f15775b0) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.toString(f2), Float.toString(this.f15775b0)));
        }
    }

    private void v() {
        float f2 = this.f15775b0;
        if (f2 <= this.f15774a0) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.toString(f2), Float.toString(this.f15774a0)));
        }
    }

    private void w() {
        for (Float f2 : this.f15776c0) {
            if (f2.floatValue() < this.f15774a0 || f2.floatValue() > this.f15775b0) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", Float.toString(f2.floatValue()), Float.toString(this.f15774a0), Float.toString(this.f15775b0)));
            }
            if (this.f15779f0 > 0.0f && !f(f2.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", Float.toString(f2.floatValue()), Float.toString(this.f15774a0), Float.toString(this.f15779f0), Float.toString(this.f15779f0)));
            }
        }
    }

    private void x() {
        float f2 = this.f15779f0;
        if (f2 == 0.0f) {
            return;
        }
        if (((int) f2) != f2) {
            String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "stepSize", Float.valueOf(f2));
        }
        float f3 = this.f15774a0;
        if (((int) f3) != f3) {
            String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueFrom", Float.valueOf(f3));
        }
        float f4 = this.f15775b0;
        if (((int) f4) != f4) {
            String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", "valueTo", Float.valueOf(f4));
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.f15800y.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f15792s.setColor(a(this.f15790q0));
        this.f15794t.setColor(a(this.f15789p0));
        this.f15798w.setColor(a(this.f15788o0));
        this.f15799x.setColor(a(this.f15787n0));
        for (com.google.android.material.l.a aVar : this.C) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.f15791r0.isStateful()) {
            this.f15791r0.setState(getDrawableState());
        }
        this.f15797v.setColor(a(this.f15786m0));
        this.f15797v.setAlpha(63);
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    final int getAccessibilityFocusedVirtualViewId() {
        return this.f15800y.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.f15777d0;
    }

    public int getFocusedThumbIndex() {
        return this.f15778e0;
    }

    @Dimension
    public int getHaloRadius() {
        return this.R;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.f15786m0;
    }

    public int getLabelBehavior() {
        return this.M;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.f15779f0;
    }

    public float getThumbElevation() {
        return this.f15791r0.e();
    }

    @Dimension
    public int getThumbRadius() {
        return this.Q;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f15791r0.m();
    }

    public float getThumbStrokeWidth() {
        return this.f15791r0.n();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.f15791r0.f();
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.f15787n0;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.f15788o0;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.f15788o0.equals(this.f15787n0)) {
            return this.f15787n0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.f15789p0;
    }

    @Dimension
    public int getTrackHeight() {
        return this.N;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.f15790q0;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.O;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.f15790q0.equals(this.f15789p0)) {
            return this.f15789p0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.f15782i0;
    }

    public float getValueFrom() {
        return this.f15774a0;
    }

    public float getValueTo() {
        return this.f15775b0;
    }

    @NonNull
    List<Float> getValues() {
        return new ArrayList(this.f15776c0);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<com.google.android.material.l.a> it = this.C.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d dVar = this.A;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.F = false;
        Iterator<com.google.android.material.l.a> it = this.C.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        if (this.f15785l0) {
            s();
            l();
        }
        super.onDraw(canvas);
        int iE = e();
        b(canvas, this.f15782i0, iE);
        if (((Float) Collections.max(getValues())).floatValue() > this.f15774a0) {
            a(canvas, this.f15782i0, iE);
        }
        a(canvas);
        if ((this.W || isFocused()) && isEnabled()) {
            d(canvas, this.f15782i0, iE);
            if (this.f15777d0 != -1) {
                h();
            }
        }
        c(canvas, this.f15782i0, iE);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z2, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (z2) {
            d(i2);
            this.f15800y.requestKeyboardFocusForVirtualView(this.f15778e0);
        } else {
            this.f15777d0 = -1;
            i();
            this.f15800y.clearKeyboardFocusForVirtualView(this.f15778e0);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.f15776c0.size() == 1) {
            this.f15777d0 = 0;
        }
        if (this.f15777d0 == -1) {
            Boolean boolA = a(i2, keyEvent);
            return boolA != null ? boolA.booleanValue() : super.onKeyDown(i2, keyEvent);
        }
        this.f15784k0 |= keyEvent.isLongPress();
        Float fA = a(i2);
        if (fA != null) {
            if (d(this.f15776c0.get(this.f15777d0).floatValue() + fA.floatValue())) {
                r();
                postInvalidate();
            }
            return true;
        }
        if (i2 != 23) {
            if (i2 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return e(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return e(-1);
                }
                return false;
            }
            if (i2 != 66) {
                return super.onKeyDown(i2, keyEvent);
            }
        }
        this.f15777d0 = -1;
        i();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        this.f15784k0 = false;
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.L + (this.M == 1 ? this.C.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.f15774a0 = sliderState.f15802s;
        this.f15775b0 = sliderState.f15803t;
        setValuesInternal(sliderState.f15804u);
        this.f15779f0 = sliderState.f15805v;
        if (sliderState.f15806w) {
            requestFocus();
        }
        g();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f15802s = this.f15774a0;
        sliderState.f15803t = this.f15775b0;
        sliderState.f15804u = new ArrayList<>(this.f15776c0);
        sliderState.f15805v = this.f15779f0;
        sliderState.f15806w = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        h(i2);
        r();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x2 = motionEvent.getX();
        this.f15793s0 = (x2 - this.O) / this.f15782i0;
        this.f15793s0 = Math.max(0.0f, this.f15793s0);
        this.f15793s0 = Math.min(1.0f, this.f15793s0);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.T = x2;
            if (!k()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (c()) {
                    requestFocus();
                    this.W = true;
                    q();
                    r();
                    invalidate();
                    n();
                }
            }
        } else if (actionMasked == 1) {
            this.W = false;
            MotionEvent motionEvent2 = this.U;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.U.getX() - motionEvent.getX()) <= this.I && Math.abs(this.U.getY() - motionEvent.getY()) <= this.I && c()) {
                n();
            }
            if (this.f15777d0 != -1) {
                q();
                this.f15777d0 = -1;
                o();
            }
            i();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.W) {
                if (k() && Math.abs(x2 - this.T) < this.I) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                n();
            }
            if (c()) {
                this.W = true;
                q();
                r();
                invalidate();
            }
        }
        setPressed(this.W);
        this.U = MotionEvent.obtain(motionEvent);
        return true;
    }

    protected void setActiveThumbIndex(int i2) {
        this.f15777d0 = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setLayerType(z2 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.f15776c0.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.f15778e0 = i2;
        this.f15800y.requestKeyboardFocusForVirtualView(this.f15778e0);
        postInvalidate();
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.R) {
            return;
        }
        this.R = i2;
        Drawable background = getBackground();
        if (p() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            com.google.android.material.e.a.a((RippleDrawable) background, this.R);
        }
    }

    public void setHaloRadiusResource(@DimenRes int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f15786m0)) {
            return;
        }
        this.f15786m0 = colorStateList;
        Drawable background = getBackground();
        if (!p() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f15797v.setColor(a(colorStateList));
        this.f15797v.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i2) {
        if (this.M != i2) {
            this.M = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable com.google.android.material.slider.c cVar) {
        this.V = cVar;
    }

    protected void setSeparationUnit(int i2) {
        this.f15795t0 = i2;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.toString(f2), Float.toString(this.f15774a0), Float.toString(this.f15775b0)));
        }
        if (this.f15779f0 != f2) {
            this.f15779f0 = f2;
            this.f15785l0 = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        this.f15791r0.b(f2);
    }

    public void setThumbElevationResource(@DimenRes int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i2) {
        if (i2 == this.Q) {
            return;
        }
        this.Q = i2;
        m();
        MaterialShapeDrawable materialShapeDrawable = this.f15791r0;
        l.b bVarN = com.google.android.material.shape.l.n();
        bVarN.a(0, this.Q);
        materialShapeDrawable.setShapeAppearanceModel(bVarN.a());
        MaterialShapeDrawable materialShapeDrawable2 = this.f15791r0;
        int i3 = this.Q;
        materialShapeDrawable2.setBounds(0, 0, i3 * 2, i3 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@DimenRes int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f15791r0.b(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i2) {
        if (i2 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        this.f15791r0.e(f2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i2) {
        if (i2 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i2));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f15791r0.f())) {
            return;
        }
        this.f15791r0.a(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f15787n0)) {
            return;
        }
        this.f15787n0 = colorStateList;
        this.f15799x.setColor(a(this.f15787n0));
        invalidate();
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f15788o0)) {
            return;
        }
        this.f15788o0 = colorStateList;
        this.f15798w.setColor(a(this.f15788o0));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z2) {
        if (this.f15781h0 != z2) {
            this.f15781h0 = z2;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f15789p0)) {
            return;
        }
        this.f15789p0 = colorStateList;
        this.f15794t.setColor(a(this.f15789p0));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i2) {
        if (this.N != i2) {
            this.N = i2;
            j();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.f15790q0)) {
            return;
        }
        this.f15790q0 = colorStateList;
        this.f15792s.setColor(a(this.f15790q0));
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.f15774a0 = f2;
        this.f15785l0 = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.f15775b0 = f2;
        this.f15785l0 = true;
        postInvalidate();
    }

    void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f15810s;

        private d() {
            this.f15810s = -1;
        }

        void a(int i2) {
            this.f15810s = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f15800y.sendEventForVirtualView(this.f15810s, 4);
        }

        /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, f15773v0), attributeSet, i2);
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = false;
        this.W = false;
        this.f15776c0 = new ArrayList<>();
        this.f15777d0 = -1;
        this.f15778e0 = -1;
        this.f15779f0 = 0.0f;
        this.f15781h0 = true;
        this.f15784k0 = false;
        this.f15791r0 = new MaterialShapeDrawable();
        this.f15795t0 = 0;
        Context context2 = getContext();
        this.f15792s = new Paint();
        this.f15792s.setStyle(Paint.Style.STROKE);
        this.f15792s.setStrokeCap(Paint.Cap.ROUND);
        this.f15794t = new Paint();
        this.f15794t.setStyle(Paint.Style.STROKE);
        this.f15794t.setStrokeCap(Paint.Cap.ROUND);
        this.f15796u = new Paint(1);
        this.f15796u.setStyle(Paint.Style.FILL);
        this.f15796u.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f15797v = new Paint(1);
        this.f15797v.setStyle(Paint.Style.FILL);
        this.f15798w = new Paint();
        this.f15798w.setStyle(Paint.Style.STROKE);
        this.f15798w.setStrokeCap(Paint.Cap.ROUND);
        this.f15799x = new Paint();
        this.f15799x.setStyle(Paint.Style.STROKE);
        this.f15799x.setStrokeCap(Paint.Cap.ROUND);
        a(context2.getResources());
        this.B = new a(attributeSet, i2);
        a(context2, attributeSet, i2);
        setFocusable(true);
        setClickable(true);
        this.f15791r0.d(2);
        this.I = ViewConfiguration.get(context2).getScaledTouchSlop();
        this.f15800y = new e(this);
        ViewCompat.setAccessibilityDelegate(this, this.f15800y);
        this.f15801z = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.google.android.material.l.a b(@NonNull Context context, @NonNull TypedArray typedArray) {
        return com.google.android.material.l.a.a(context, (AttributeSet) null, 0, typedArray.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip));
    }

    private float c(float f2) {
        float f3 = this.f15774a0;
        float f4 = (f2 - f3) / (this.f15775b0 - f3);
        return b() ? 1.0f - f4 : f4;
    }

    private void g() {
        for (L l2 : this.D) {
            Iterator<Float> it = this.f15776c0.iterator();
            while (it.hasNext()) {
                l2.a(this, it.next().floatValue(), false);
            }
        }
    }

    private double e(float f2) {
        float f3 = this.f15779f0;
        if (f3 <= 0.0f) {
            return f2;
        }
        int i2 = (int) ((this.f15775b0 - this.f15774a0) / f3);
        double dRound = Math.round(f2 * i2);
        double d2 = i2;
        Double.isNaN(dRound);
        Double.isNaN(d2);
        return dRound / d2;
    }

    private void h() {
        if (this.M == 2) {
            return;
        }
        if (!this.F) {
            this.F = true;
            this.G = a(true);
            this.H = null;
            this.G.start();
        }
        Iterator<com.google.android.material.l.a> it = this.C.iterator();
        for (int i2 = 0; i2 < this.f15776c0.size() && it.hasNext(); i2++) {
            if (i2 != this.f15778e0) {
                a(it.next(), this.f15776c0.get(i2).floatValue());
            }
        }
        if (it.hasNext()) {
            a(it.next(), this.f15776c0.get(this.f15778e0).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.C.size()), Integer.valueOf(this.f15776c0.size())));
    }

    private void c(@NonNull Canvas canvas, int i2, int i3) {
        if (!isEnabled()) {
            Iterator<Float> it = this.f15776c0.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.O + (c(it.next().floatValue()) * i2), i3, this.Q, this.f15796u);
            }
        }
        for (Float f2 : this.f15776c0) {
            canvas.save();
            int iC = this.O + ((int) (c(f2.floatValue()) * i2));
            int i4 = this.Q;
            canvas.translate(iC - i4, i3 - i4);
            this.f15791r0.draw(canvas);
            canvas.restore();
        }
    }

    void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    private void b(com.google.android.material.l.a aVar) {
        r rVarB = s.b(this);
        if (rVarB != null) {
            rVarB.remove(aVar);
            aVar.a(s.a(this));
        }
    }

    private void g(int i2) {
        BaseSlider<S, L, T>.d dVar = this.A;
        if (dVar == null) {
            this.A = new d(this, null);
        } else {
            removeCallbacks(dVar);
        }
        this.A.a(i2);
        postDelayed(this.A, 200L);
    }

    private void a(@NonNull Resources resources) {
        this.L = resources.getDimensionPixelSize(R$dimen.mtrl_slider_widget_height);
        this.J = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_side_padding);
        this.O = this.J;
        this.K = resources.getDimensionPixelSize(R$dimen.mtrl_slider_thumb_radius);
        this.P = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_top);
        this.S = resources.getDimensionPixelSize(R$dimen.mtrl_slider_label_padding);
    }

    private boolean d(float f2) {
        return b(this.f15777d0, f2);
    }

    private boolean e(int i2) {
        int i3 = this.f15778e0;
        this.f15778e0 = (int) MathUtils.clamp(((long) i3) + ((long) i2), 0L, this.f15776c0.size() - 1);
        int i4 = this.f15778e0;
        if (i4 == i3) {
            return false;
        }
        if (this.f15777d0 != -1) {
            this.f15777d0 = i4;
        }
        r();
        postInvalidate();
        return true;
    }

    private float d() {
        float f2 = this.f15779f0;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    private void f() {
        if (this.C.size() > this.f15776c0.size()) {
            List<com.google.android.material.l.a> listSubList = this.C.subList(this.f15776c0.size(), this.C.size());
            for (com.google.android.material.l.a aVar : listSubList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    b(aVar);
                }
            }
            listSubList.clear();
        }
        while (this.C.size() < this.f15776c0.size()) {
            com.google.android.material.l.a aVarA = this.B.a();
            this.C.add(aVarA);
            if (ViewCompat.isAttachedToWindow(this)) {
                a(aVarA);
            }
        }
        int i2 = this.C.size() == 1 ? 0 : 1;
        Iterator<com.google.android.material.l.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().e(i2);
        }
    }

    private void b(@NonNull Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        float f2 = i2;
        float f3 = this.O + (activeRange[1] * f2);
        if (f3 < r1 + i2) {
            float f4 = i3;
            canvas.drawLine(f3, f4, r1 + i2, f4, this.f15792s);
        }
        int i4 = this.O;
        float f5 = i4 + (activeRange[0] * f2);
        if (f5 > i4) {
            float f6 = i3;
            canvas.drawLine(i4, f6, f5, f6, this.f15792s);
        }
    }

    private void d(int i2) {
        if (i2 == 1) {
            e(Integer.MAX_VALUE);
            return;
        }
        if (i2 == 2) {
            e(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            f(Integer.MAX_VALUE);
        } else {
            if (i2 != 66) {
                return;
            }
            f(Integer.MIN_VALUE);
        }
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context, attributeSet, R$styleable.Slider, i2, f15773v0, new int[0]);
        this.f15774a0 = typedArrayC.getFloat(R$styleable.Slider_android_valueFrom, 0.0f);
        this.f15775b0 = typedArrayC.getFloat(R$styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.f15774a0));
        this.f15779f0 = typedArrayC.getFloat(R$styleable.Slider_android_stepSize, 0.0f);
        boolean zHasValue = typedArrayC.hasValue(R$styleable.Slider_trackColor);
        int i3 = zHasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorInactive;
        int i4 = zHasValue ? R$styleable.Slider_trackColor : R$styleable.Slider_trackColorActive;
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context, typedArrayC, i3);
        if (colorStateListA == null) {
            colorStateListA = AppCompatResources.getColorStateList(context, R$color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateListA);
        ColorStateList colorStateListA2 = com.google.android.material.i.c.a(context, typedArrayC, i4);
        if (colorStateListA2 == null) {
            colorStateListA2 = AppCompatResources.getColorStateList(context, R$color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateListA2);
        this.f15791r0.a(com.google.android.material.i.c.a(context, typedArrayC, R$styleable.Slider_thumbColor));
        if (typedArrayC.hasValue(R$styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(com.google.android.material.i.c.a(context, typedArrayC, R$styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(typedArrayC.getDimension(R$styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListA3 = com.google.android.material.i.c.a(context, typedArrayC, R$styleable.Slider_haloColor);
        if (colorStateListA3 == null) {
            colorStateListA3 = AppCompatResources.getColorStateList(context, R$color.material_slider_halo_color);
        }
        setHaloTintList(colorStateListA3);
        this.f15781h0 = typedArrayC.getBoolean(R$styleable.Slider_tickVisible, true);
        boolean zHasValue2 = typedArrayC.hasValue(R$styleable.Slider_tickColor);
        int i5 = zHasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorInactive;
        int i6 = zHasValue2 ? R$styleable.Slider_tickColor : R$styleable.Slider_tickColorActive;
        ColorStateList colorStateListA4 = com.google.android.material.i.c.a(context, typedArrayC, i5);
        if (colorStateListA4 == null) {
            colorStateListA4 = AppCompatResources.getColorStateList(context, R$color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateListA4);
        ColorStateList colorStateListA5 = com.google.android.material.i.c.a(context, typedArrayC, i6);
        if (colorStateListA5 == null) {
            colorStateListA5 = AppCompatResources.getColorStateList(context, R$color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateListA5);
        setThumbRadius(typedArrayC.getDimensionPixelSize(R$styleable.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayC.getDimensionPixelSize(R$styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayC.getDimension(R$styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayC.getDimensionPixelSize(R$styleable.Slider_trackHeight, 0));
        this.M = typedArrayC.getInt(R$styleable.Slider_labelBehavior, 0);
        if (!typedArrayC.getBoolean(R$styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayC.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i2, float f2) {
        if (Math.abs(f2 - this.f15776c0.get(i2).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.f15776c0.set(i2, Float.valueOf(a(i2, f2)));
        this.f15778e0 = i2;
        c(i2);
        return true;
    }

    protected boolean c() {
        if (this.f15777d0 != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float fG = g(valueOfTouchPositionAbsolute);
        this.f15777d0 = 0;
        float fAbs = Math.abs(this.f15776c0.get(this.f15777d0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i2 = 1; i2 < this.f15776c0.size(); i2++) {
            float fAbs2 = Math.abs(this.f15776c0.get(i2).floatValue() - valueOfTouchPositionAbsolute);
            float fG2 = g(this.f15776c0.get(i2).floatValue());
            if (Float.compare(fAbs2, fAbs) > 1) {
                break;
            }
            boolean z2 = !b() ? fG2 - fG >= 0.0f : fG2 - fG <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.f15777d0 = i2;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fG2 - fG) < this.I) {
                        this.f15777d0 = -1;
                        return false;
                    }
                    if (z2) {
                        this.f15777d0 = i2;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.f15777d0 != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(float f2) {
        if (a()) {
            return this.V.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    private boolean f(int i2) {
        if (b()) {
            i2 = i2 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i2;
        }
        return e(i2);
    }

    final boolean b() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float b(int i2) {
        float fD = d();
        return (this.f15775b0 - this.f15774a0) / fD <= i2 ? fD : Math.round(r1 / r4) * fD;
    }

    private void c(int i2) {
        Iterator<L> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f15776c0.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f15801z;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        g(i2);
    }

    public boolean a() {
        return this.V != null;
    }

    private void a(com.google.android.material.l.a aVar) {
        aVar.b(s.a(this));
    }

    private void a(@NonNull Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        int i4 = this.O;
        float f2 = i2;
        float f3 = i3;
        canvas.drawLine(i4 + (activeRange[0] * f2), f3, i4 + (activeRange[1] * f2), f3, this.f15794t);
    }

    private void a(@NonNull Canvas canvas) {
        if (!this.f15781h0 || this.f15779f0 <= 0.0f) {
            return;
        }
        float[] activeRange = getActiveRange();
        int iA = a(this.f15780g0, activeRange[0]);
        int iA2 = a(this.f15780g0, activeRange[1]);
        int i2 = iA * 2;
        canvas.drawPoints(this.f15780g0, 0, i2, this.f15798w);
        int i3 = iA2 * 2;
        canvas.drawPoints(this.f15780g0, i2, i3 - i2, this.f15799x);
        float[] fArr = this.f15780g0;
        canvas.drawPoints(fArr, i3, fArr.length - i3, this.f15798w);
    }

    private static int a(float[] fArr, float f2) {
        return Math.round(f2 * ((fArr.length / 2) - 1));
    }

    private float a(int i2, float f2) {
        float minSeparation = this.f15779f0 == 0.0f ? getMinSeparation() : 0.0f;
        if (this.f15795t0 == 0) {
            minSeparation = a(minSeparation);
        }
        if (b()) {
            minSeparation = -minSeparation;
        }
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        return MathUtils.clamp(f2, i4 < 0 ? this.f15774a0 : this.f15776c0.get(i4).floatValue() + minSeparation, i3 >= this.f15776c0.size() ? this.f15775b0 : this.f15776c0.get(i3).floatValue() - minSeparation);
    }

    private float a(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = (f2 - this.O) / this.f15782i0;
        float f4 = this.f15774a0;
        return (f3 * (f4 - this.f15775b0)) + f4;
    }

    private static float a(ValueAnimator valueAnimator, float f2) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f2;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    private ValueAnimator a(boolean z2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(a(z2 ? this.H : this.G, z2 ? 0.0f : 1.0f), z2 ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z2 ? 83L : 117L);
        valueAnimatorOfFloat.setInterpolator(z2 ? com.google.android.material.a.a.f14916e : com.google.android.material.a.a.f14914c);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    private void a(com.google.android.material.l.a aVar, float f2) {
        aVar.a(b(f2));
        int iC = (this.O + ((int) (c(f2) * this.f15782i0))) - (aVar.getIntrinsicWidth() / 2);
        int iE = e() - (this.S + this.Q);
        aVar.setBounds(iC, iE - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + iC, iE);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.c.b(s.a(this), this, rect);
        aVar.setBounds(rect);
        s.b(this).add(aVar);
    }

    @ColorInt
    private int a(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private Boolean a(int i2, @NonNull KeyEvent keyEvent) {
        if (i2 != 61) {
            if (i2 != 66) {
                if (i2 != 81) {
                    if (i2 == 69) {
                        e(-1);
                        return true;
                    }
                    if (i2 != 70) {
                        switch (i2) {
                            case 21:
                                f(-1);
                                break;
                            case 22:
                                f(1);
                                break;
                        }
                        return true;
                    }
                }
                e(1);
                return true;
            }
            this.f15777d0 = this.f15778e0;
            postInvalidate();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(e(1));
        }
        if (keyEvent.isShiftPressed()) {
            return Boolean.valueOf(e(-1));
        }
        return false;
    }

    private Float a(int i2) {
        float fB = this.f15784k0 ? b(20) : d();
        if (i2 == 21) {
            if (!b()) {
                fB = -fB;
            }
            return Float.valueOf(fB);
        }
        if (i2 == 22) {
            if (b()) {
                fB = -fB;
            }
            return Float.valueOf(fB);
        }
        if (i2 == 69) {
            return Float.valueOf(-fB);
        }
        if (i2 == 70 || i2 == 81) {
            return Float.valueOf(fB);
        }
        return null;
    }

    void a(int i2, Rect rect) {
        int iC = this.O + ((int) (c(getValues().get(i2).floatValue()) * this.f15782i0));
        int iE = e();
        int i3 = this.Q;
        rect.set(iC - i3, iE - i3, iC + i3, iE + i3);
    }
}
