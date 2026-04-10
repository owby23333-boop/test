package com.mardous.discreteseekbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.mardous.discreteseekbar.a.d.b;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class DiscreteSeekBar extends View {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final boolean f17599a0;
    private int A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private Formatter H;
    private String I;
    private f J;
    private StringBuilder K;
    private g L;
    private boolean M;
    private int N;
    private Rect O;
    private Rect P;
    private com.mardous.discreteseekbar.a.b Q;
    private ValueAnimator R;
    private float S;
    private int T;
    private float U;
    private float V;
    private Runnable W;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.mardous.discreteseekbar.a.d.d f17600s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.mardous.discreteseekbar.a.d.e f17601t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.mardous.discreteseekbar.a.d.e f17602u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f17603v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f17604w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f17605x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f17606y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f17607z;

    static class CustomState extends View.BaseSavedState {
        public static final Parcelable.Creator<CustomState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f17608s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f17609t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f17610u;

        class a implements Parcelable.Creator<CustomState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomState createFromParcel(Parcel parcel) {
                return new CustomState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomState[] newArray(int i2) {
                return new CustomState[i2];
            }
        }

        CustomState(Parcel parcel) {
            super(parcel);
            this.f17608s = parcel.readInt();
            this.f17609t = parcel.readInt();
            this.f17610u = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f17608s);
            parcel.writeInt(this.f17609t);
            parcel.writeInt(this.f17610u);
        }

        CustomState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    class a implements b.InterfaceC0500b {
        a() {
        }

        @Override // com.mardous.discreteseekbar.a.d.b.InterfaceC0500b
        public void a() {
            DiscreteSeekBar.this.f17600s.a();
        }

        @Override // com.mardous.discreteseekbar.a.d.b.InterfaceC0500b
        public void b() {
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DiscreteSeekBar.this.setAnimationPosition(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DiscreteSeekBar.this.i();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f17614s;

        d(boolean z2) {
            this.f17614s = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            DiscreteSeekBar.super.setEnabled(this.f17614s);
        }
    }

    private static class e extends f {
        private e() {
        }

        @Override // com.mardous.discreteseekbar.DiscreteSeekBar.f
        public int a(int i2) {
            return i2;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static abstract class f {
        public abstract int a(int i2);

        public boolean a() {
            return false;
        }

        public String b(int i2) {
            return String.valueOf(i2);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface g {
        void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i2, boolean z2);

        void onStartTrackingTouch(DiscreteSeekBar discreteSeekBar);

        void onStopTrackingTouch(DiscreteSeekBar discreteSeekBar);
    }

    static {
        f17599a0 = Build.VERSION.SDK_INT >= 21;
    }

    public DiscreteSeekBar(Context context) {
        this(context, null);
    }

    private String c(int i2) {
        String str = this.I;
        if (str == null) {
            str = "%d";
        }
        Formatter formatter = this.H;
        if (formatter == null || !formatter.locale().equals(Locale.getDefault())) {
            int length = str.length() + String.valueOf(this.f17607z).length();
            StringBuilder sb = this.K;
            if (sb == null) {
                this.K = new StringBuilder(length);
            } else {
                sb.ensureCapacity(length);
            }
            this.H = new Formatter(this.K, Locale.getDefault());
        } else {
            this.K.setLength(0);
        }
        return this.H.format(str, Integer.valueOf(i2)).toString();
    }

    private void d(int i2) {
        if (isInEditMode()) {
            return;
        }
        if (this.J.a()) {
            this.Q.a((CharSequence) this.J.b(i2));
            return;
        }
        com.mardous.discreteseekbar.a.b bVar = this.Q;
        this.J.a(i2);
        bVar.a((CharSequence) c(i2));
    }

    private void e(int i2) {
        int paddingLeft;
        int i3;
        int intrinsicWidth = this.f17600s.getIntrinsicWidth();
        int i4 = intrinsicWidth / 2;
        if (a()) {
            paddingLeft = (getWidth() - getPaddingRight()) - this.f17606y;
            i3 = (paddingLeft - i2) - intrinsicWidth;
        } else {
            paddingLeft = getPaddingLeft() + this.f17606y;
            i3 = i2 + paddingLeft;
        }
        this.f17600s.copyBounds(this.O);
        com.mardous.discreteseekbar.a.d.d dVar = this.f17600s;
        Rect rect = this.O;
        dVar.setBounds(i3, rect.top, intrinsicWidth + i3, rect.bottom);
        if (a()) {
            this.f17602u.getBounds().right = paddingLeft - i4;
            this.f17602u.getBounds().left = i3 + i4;
        } else {
            this.f17602u.getBounds().left = paddingLeft + i4;
            this.f17602u.getBounds().right = i3 + i4;
        }
        Rect rect2 = this.P;
        this.f17600s.copyBounds(rect2);
        if (!isInEditMode()) {
            this.Q.a(rect2.centerX());
        }
        Rect rect3 = this.O;
        int i5 = this.f17606y;
        rect3.inset(-i5, -i5);
        int i6 = this.f17606y;
        rect2.inset(-i6, -i6);
        this.O.union(rect2);
        com.mardous.discreteseekbar.a.c.a.a(this.f17603v, rect2.left, rect2.top, rect2.right, rect2.bottom);
        invalidate(this.O);
    }

    private boolean f() {
        ValueAnimator valueAnimator = this.R;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    private boolean g() {
        return this.M;
    }

    private int getAnimatedProgress() {
        return f() ? getAnimationTarget() : this.B;
    }

    private float getAnimationPosition() {
        return this.S;
    }

    private int getAnimationTarget() {
        return this.T;
    }

    private boolean h() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (isInEditMode()) {
            return;
        }
        this.f17600s.b();
        this.Q.a(this, this.f17600s.getBounds());
        a(true);
    }

    private void j() {
        g gVar = this.L;
        if (gVar != null) {
            gVar.onStopTrackingTouch(this);
        }
        this.M = false;
        setPressed(false);
    }

    private void k() {
        int[] drawableState = getDrawableState();
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 : drawableState) {
            if (i2 == 16842908) {
                z2 = true;
            } else if (i2 == 16842919) {
                z3 = true;
            }
        }
        if (isEnabled() && ((z2 || z3) && this.F)) {
            removeCallbacks(this.W);
            postDelayed(this.W, 150L);
        } else {
            e();
        }
        this.f17600s.setState(drawableState);
        this.f17601t.setState(drawableState);
        this.f17602u.setState(drawableState);
        this.f17603v.setState(drawableState);
    }

    private void l() {
        if (isInEditMode()) {
            return;
        }
        if (this.J.a()) {
            this.Q.a(this.J.b(this.f17607z));
            return;
        }
        com.mardous.discreteseekbar.a.b bVar = this.Q;
        f fVar = this.J;
        int i2 = this.f17607z;
        fVar.a(i2);
        bVar.a(c(i2));
    }

    private void m() {
        int i2 = this.f17607z - this.A;
        int i3 = this.C;
        if (i3 == 0 || i2 / i3 > 20) {
            this.C = Math.max(1, Math.round(i2 / 20.0f));
        }
    }

    private void n() {
        int intrinsicWidth = this.f17600s.getIntrinsicWidth();
        int i2 = this.f17606y;
        int i3 = intrinsicWidth / 2;
        int i4 = this.B;
        int i5 = this.A;
        e((int) ((((i4 - i5) / (this.f17607z - i5)) * ((getWidth() - ((getPaddingRight() + i3) + i2)) - ((getPaddingLeft() + i3) + i2))) + 0.5f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationPosition(float f2) {
        this.S = f2;
        a((f2 - this.A) / (this.f17607z - r0));
    }

    protected void a(int i2) {
    }

    protected void b() {
    }

    protected void c() {
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        k();
    }

    public int getMax() {
        return this.f17607z;
    }

    public int getMin() {
        return this.A;
    }

    public f getNumericTransformer() {
        return this.J;
    }

    public int getProgress() {
        return this.B;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.W);
        if (isInEditMode()) {
            return;
        }
        this.Q.b();
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        if (!f17599a0) {
            this.f17603v.draw(canvas);
        }
        super.onDraw(canvas);
        this.f17601t.draw(canvas);
        this.f17602u.draw(canvas);
        this.f17600s.draw(canvas);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z2;
        if (isEnabled()) {
            int animatedProgress = getAnimatedProgress();
            if (i2 != 21) {
                if (i2 == 22) {
                    if (animatedProgress < this.f17607z) {
                        b(animatedProgress + this.C);
                    }
                }
                z2 = false;
            } else if (animatedProgress > this.A) {
                b(animatedProgress - this.C);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        return z2 || super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            removeCallbacks(this.W);
            if (!isInEditMode()) {
                this.Q.b();
            }
            k();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.MeasureSpec.getSize(i2), this.f17600s.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom() + (this.f17606y * 2));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(CustomState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        CustomState customState = (CustomState) parcelable;
        setMin(customState.f17610u);
        setMax(customState.f17609t);
        b(customState.f17608s, false);
        super.onRestoreInstanceState(customState.getSuperState());
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        CustomState customState = new CustomState(super.onSaveInstanceState());
        customState.f17608s = getProgress();
        customState.f17609t = this.f17607z;
        customState.f17610u = this.A;
        return customState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int intrinsicWidth = this.f17600s.getIntrinsicWidth();
        int intrinsicHeight = this.f17600s.getIntrinsicHeight();
        int i6 = this.f17606y;
        int i7 = intrinsicWidth / 2;
        int paddingLeft = getPaddingLeft() + i6;
        int paddingRight = getPaddingRight();
        int height = (getHeight() - getPaddingBottom()) - i6;
        this.f17600s.setBounds(paddingLeft, height - intrinsicHeight, intrinsicWidth + paddingLeft, height);
        int iMax = Math.max(this.f17604w / 2, 1);
        int i8 = paddingLeft + i7;
        int i9 = height - i7;
        this.f17601t.setBounds(i8, i9 - iMax, ((getWidth() - i7) - paddingRight) - i6, iMax + i9);
        int iMax2 = Math.max(this.f17605x / 2, 2);
        this.f17602u.setBounds(i8, i9 - iMax2, i8, i9 + iMax2);
        n();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.U = motionEvent.getX();
            a(motionEvent, h());
        } else if (actionMasked == 1) {
            if (!g() && this.E) {
                a(motionEvent, false);
                a(motionEvent);
            }
            j();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                j();
            }
        } else if (g()) {
            a(motionEvent);
        } else if (Math.abs(motionEvent.getX() - this.U) > this.V) {
            a(motionEvent, false);
        }
        return true;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        super.scheduleDrawable(drawable, runnable, j2);
    }

    public void setAnimateEnabledState(boolean z2) {
        this.G = z2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        if (this.G) {
            animate().alpha(z2 ? 1.0f : 0.5f).setDuration(500L).withEndAction(new d(z2)).start();
        } else {
            super.setEnabled(z2);
        }
    }

    public void setIndicatorFormatter(@Nullable String str) {
        this.I = str;
        d(this.B);
    }

    public void setIndicatorPopupEnabled(boolean z2) {
        this.F = z2;
    }

    public void setMax(int i2) {
        this.f17607z = i2;
        int i3 = this.f17607z;
        if (i3 < this.A) {
            setMin(i3 - 1);
        }
        m();
        int i4 = this.B;
        if (i4 < this.A || i4 > this.f17607z) {
            setProgress(this.A);
        }
        l();
    }

    public void setMin(int i2) {
        this.A = i2;
        int i3 = this.A;
        if (i3 > this.f17607z) {
            setMax(i3 + 1);
        }
        m();
        int i4 = this.B;
        if (i4 < this.A || i4 > this.f17607z) {
            setProgress(this.A);
        }
    }

    public void setNumericTransformer(@Nullable f fVar) {
        if (fVar == null) {
            fVar = new e(null);
        }
        this.J = fVar;
        l();
        d(this.B);
    }

    public void setOnProgressChangeListener(@Nullable g gVar) {
        this.L = gVar;
    }

    public void setProgress(int i2) {
        b(i2, false);
    }

    public void setRippleColor(int i2) {
        setRippleColor(new ColorStateList(new int[][]{new int[0]}, new int[]{i2}));
    }

    public void setScrubberColor(int i2) {
        this.f17602u.a(ColorStateList.valueOf(i2));
    }

    public void setTrackColor(int i2) {
        this.f17601t.a(ColorStateList.valueOf(i2));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f17600s || drawable == this.f17601t || drawable == this.f17602u || drawable == this.f17603v || super.verifyDrawable(drawable);
    }

    public DiscreteSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.discreteSeekBarStyle);
    }

    private void b(int i2, boolean z2) {
        int iMax = Math.max(this.A, Math.min(this.f17607z, i2));
        if (f()) {
            this.R.cancel();
        }
        if (this.B != iMax) {
            this.B = iMax;
            a(iMax, z2);
            d(iMax);
            n();
        }
    }

    public void setRippleColor(@NonNull ColorStateList colorStateList) {
        com.mardous.discreteseekbar.a.c.a.a(this.f17603v, colorStateList);
    }

    public void setScrubberColor(@NonNull ColorStateList colorStateList) {
        this.f17602u.a(colorStateList);
    }

    public void setTrackColor(@NonNull ColorStateList colorStateList) {
        this.f17601t.a(colorStateList);
    }

    public DiscreteSeekBar(Context context, AttributeSet attributeSet, int i2) {
        int integer;
        int integer2;
        super(context, attributeSet, i2);
        this.C = 1;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.O = new Rect();
        this.P = new Rect();
        this.W = new c();
        setFocusable(true);
        setWillNotDraw(false);
        this.V = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = context.getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DiscreteSeekBar, i2, R$style.Widget_DiscreteSeekBar);
        this.G = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DiscreteSeekBar_dsb_animateEnabledState, this.G);
        this.D = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DiscreteSeekBar_dsb_mirrorForRtl, this.D);
        this.E = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DiscreteSeekBar_dsb_allowTrackClickToDrag, this.E);
        this.F = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DiscreteSeekBar_dsb_indicatorPopupEnabled, this.F);
        this.f17604w = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DiscreteSeekBar_dsb_trackHeight, (int) (1.0f * f2));
        this.f17605x = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DiscreteSeekBar_dsb_scrubberHeight, (int) (4.0f * f2));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DiscreteSeekBar_dsb_thumbSize, (int) (12.0f * f2));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DiscreteSeekBar_dsb_indicatorSeparation, (int) (5.0f * f2));
        this.f17606y = Math.max(0, (((int) (f2 * 32.0f)) - dimensionPixelSize) / 2);
        int i3 = R$styleable.DiscreteSeekBar_dsb_max;
        int i4 = R$styleable.DiscreteSeekBar_dsb_min;
        int i5 = R$styleable.DiscreteSeekBar_dsb_value;
        TypedValue typedValue = new TypedValue();
        int integer3 = 100;
        if (typedArrayObtainStyledAttributes.getValue(i3, typedValue)) {
            if (typedValue.type == 5) {
                integer3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, 100);
            } else {
                integer3 = typedArrayObtainStyledAttributes.getInteger(i3, 100);
            }
        }
        if (!typedArrayObtainStyledAttributes.getValue(i4, typedValue)) {
            integer = 0;
        } else if (typedValue.type == 5) {
            integer = typedArrayObtainStyledAttributes.getDimensionPixelSize(i4, 0);
        } else {
            integer = typedArrayObtainStyledAttributes.getInteger(i4, 0);
        }
        if (!typedArrayObtainStyledAttributes.getValue(i5, typedValue)) {
            integer2 = 0;
        } else if (typedValue.type == 5) {
            integer2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(i5, 0);
        } else {
            integer2 = typedArrayObtainStyledAttributes.getInteger(i5, 0);
        }
        this.A = integer;
        this.f17607z = Math.max(integer + 1, integer3);
        this.B = Math.max(integer, Math.min(integer3, integer2));
        m();
        this.I = typedArrayObtainStyledAttributes.getString(R$styleable.DiscreteSeekBar_dsb_indicatorFormatter);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.DiscreteSeekBar_dsb_trackColor);
        ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.DiscreteSeekBar_dsb_progressColor);
        ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.DiscreteSeekBar_dsb_rippleColor);
        boolean zIsInEditMode = isInEditMode();
        colorStateList3 = (zIsInEditMode || colorStateList3 == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-12303292}) : colorStateList3;
        colorStateList = (zIsInEditMode || colorStateList == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-7829368}) : colorStateList;
        colorStateList2 = (zIsInEditMode || colorStateList2 == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-16738680}) : colorStateList2;
        this.f17603v = com.mardous.discreteseekbar.a.c.a.a(colorStateList3);
        if (f17599a0) {
            setBackground(this.f17603v);
        } else {
            this.f17603v.setCallback(this);
        }
        this.f17601t = new com.mardous.discreteseekbar.a.d.e(colorStateList);
        this.f17601t.setCallback(this);
        this.f17602u = new com.mardous.discreteseekbar.a.d.e(colorStateList2);
        this.f17602u.setCallback(this);
        this.f17600s = new com.mardous.discreteseekbar.a.d.d(colorStateList2, dimensionPixelSize);
        this.f17600s.setCallback(this);
        com.mardous.discreteseekbar.a.d.d dVar = this.f17600s;
        dVar.setBounds(0, 0, dVar.getIntrinsicWidth(), this.f17600s.getIntrinsicHeight());
        if (!zIsInEditMode) {
            this.Q = new com.mardous.discreteseekbar.a.b(context, attributeSet, i2, c(this.f17607z), dimensionPixelSize, this.f17606y + dimensionPixelSize + dimensionPixelSize2);
            this.Q.a(new a());
        }
        typedArrayObtainStyledAttributes.recycle();
        setNumericTransformer(new e(null));
    }

    private void a(int i2, boolean z2) {
        g gVar = this.L;
        if (gVar != null) {
            gVar.onProgressChanged(this, i2, z2);
        }
        a(i2);
    }

    private void d() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void a(boolean z2) {
        if (z2) {
            c();
        } else {
            b();
        }
    }

    private boolean a(MotionEvent motionEvent, boolean z2) {
        Rect rect = this.P;
        this.f17600s.copyBounds(rect);
        int i2 = this.f17606y;
        rect.inset(-i2, -i2);
        this.M = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (!this.M && this.E && !z2) {
            this.M = true;
            this.N = (rect.width() / 2) - this.f17606y;
            a(motionEvent);
            this.f17600s.copyBounds(rect);
            int i3 = this.f17606y;
            rect.inset(-i3, -i3);
        }
        if (this.M) {
            setPressed(true);
            d();
            a(motionEvent.getX(), motionEvent.getY());
            this.N = (int) ((motionEvent.getX() - rect.left) - this.f17606y);
            g gVar = this.L;
            if (gVar != null) {
                gVar.onStartTrackingTouch(this);
            }
        }
        return this.M;
    }

    private void b(int i2) {
        float animationPosition = f() ? getAnimationPosition() : getProgress();
        int i3 = this.A;
        if (i2 >= i3 && i2 <= (i3 = this.f17607z)) {
            i3 = i2;
        }
        ValueAnimator valueAnimator = this.R;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.T = i3;
        this.R = ValueAnimator.ofFloat(animationPosition, i3);
        this.R.setDuration(250L);
        this.R.addUpdateListener(new b());
        this.R.start();
    }

    private void e() {
        removeCallbacks(this.W);
        if (isInEditMode()) {
            return;
        }
        this.Q.a();
        a(false);
    }

    private void a(MotionEvent motionEvent) {
        a(motionEvent.getX(), motionEvent.getY());
        int x2 = (int) motionEvent.getX();
        int iWidth = this.f17600s.getBounds().width() / 2;
        int i2 = this.f17606y;
        int i3 = (x2 - this.N) + iWidth;
        int paddingLeft = getPaddingLeft() + iWidth + i2;
        int width = getWidth() - ((getPaddingRight() + iWidth) + i2);
        if (i3 < paddingLeft) {
            i3 = paddingLeft;
        } else if (i3 > width) {
            i3 = width;
        }
        float f2 = (i3 - paddingLeft) / (width - paddingLeft);
        if (a()) {
            f2 = 1.0f - f2;
        }
        int i4 = this.f17607z;
        b(Math.round((f2 * (i4 - r1)) + this.A), true);
    }

    private void a(float f2) {
        int iWidth = this.f17600s.getBounds().width() / 2;
        int i2 = this.f17606y;
        int width = (getWidth() - ((getPaddingRight() + iWidth) + i2)) - ((getPaddingLeft() + iWidth) + i2);
        int i3 = this.f17607z;
        int iRound = Math.round(((i3 - r1) * f2) + this.A);
        if (iRound != getProgress()) {
            this.B = iRound;
            a(this.B, true);
            d(iRound);
        }
        e((int) ((f2 * width) + 0.5f));
    }

    private void a(float f2, float f3) {
        DrawableCompat.setHotspot(this.f17603v, f2, f3);
    }

    public boolean a() {
        return ViewCompat.getLayoutDirection(this) == 1 && this.D;
    }
}
