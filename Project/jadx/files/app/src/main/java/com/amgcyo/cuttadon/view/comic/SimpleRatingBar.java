package com.amgcyo.cuttadon.view.comic;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import com.amgcyo.cuttadon.R$styleable;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class SimpleRatingBar extends View {
    private int A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private boolean G;
    private Gravity H;
    private float I;
    private float J;
    private boolean K;
    private float L;
    private float M;
    private Paint N;
    private Paint O;
    private Paint P;
    private Paint Q;
    private CornerPathEffect R;
    private Path S;
    private ValueAnimator T;
    private b U;
    private View.OnClickListener V;
    private boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private float[] f4494a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private RectF f4495b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private RectF f4496c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Canvas f4497d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private Bitmap f4498e0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @ColorInt
    private int f4499s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @ColorInt
    private int f4500t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @ColorInt
    private int f4501u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @ColorInt
    private int f4502v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @ColorInt
    private int f4503w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @ColorInt
    private int f4504x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @ColorInt
    private int f4505y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @ColorInt
    private int f4506z;

    public enum Gravity {
        Left(0),
        Right(1);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f4510s;

        Gravity(int i2) {
            this.f4510s = i2;
        }

        static Gravity b(int i2) {
            for (Gravity gravity : values()) {
                if (gravity.f4510s == i2) {
                    return gravity;
                }
            }
            String.format("Gravity chosen is neither 'left' nor 'right', I will set it to Left", new Object[0]);
            return Left;
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private float f4511s;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        protected SavedState(Parcel parcel) {
            super(parcel);
            this.f4511s = 0.0f;
            this.f4511s = parcel.readFloat();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f4511s);
        }

        protected SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f4511s = 0.0f;
        }
    }

    public class a {
        /* synthetic */ a(SimpleRatingBar simpleRatingBar, SimpleRatingBar simpleRatingBar2, l lVar) {
            this(simpleRatingBar, simpleRatingBar2);
        }

        private a(SimpleRatingBar simpleRatingBar, SimpleRatingBar simpleRatingBar2) {
            new BounceInterpolator();
            simpleRatingBar2.getNumberOfStars();
        }
    }

    public interface b {
        void a(SimpleRatingBar simpleRatingBar, float f2, boolean z2);
    }

    public SimpleRatingBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.S = new Path();
        this.R = new CornerPathEffect(this.J);
        this.N = new Paint(5);
        this.N.setStyle(Paint.Style.FILL_AND_STROKE);
        this.N.setAntiAlias(true);
        this.N.setDither(true);
        this.N.setStrokeJoin(Paint.Join.ROUND);
        this.N.setStrokeCap(Paint.Cap.ROUND);
        this.N.setColor(-16777216);
        this.N.setPathEffect(this.R);
        this.O = new Paint(5);
        this.O.setStyle(Paint.Style.STROKE);
        this.O.setStrokeJoin(Paint.Join.ROUND);
        this.O.setStrokeCap(Paint.Cap.ROUND);
        this.O.setStrokeWidth(this.I);
        this.O.setPathEffect(this.R);
        this.Q = new Paint(5);
        this.Q.setStyle(Paint.Style.FILL_AND_STROKE);
        this.Q.setAntiAlias(true);
        this.Q.setDither(true);
        this.Q.setStrokeJoin(Paint.Join.ROUND);
        this.Q.setStrokeCap(Paint.Cap.ROUND);
        this.P = new Paint(5);
        this.P.setStyle(Paint.Style.FILL_AND_STROKE);
        this.P.setAntiAlias(true);
        this.P.setDither(true);
        this.P.setStrokeJoin(Paint.Join.ROUND);
        this.P.setStrokeCap(Paint.Cap.ROUND);
        this.M = TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics());
    }

    private int b(float f2, int i2, float f3, boolean z2) {
        return Math.round((f2 * i2) + (f3 * (i2 - 1))) + (z2 ? getPaddingLeft() + getPaddingRight() : 0);
    }

    private void c() {
        int i2 = this.A;
        if (i2 <= 0) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for numberOfStars. Found %d, but should be greater than 0", Integer.valueOf(i2)));
        }
        float f2 = this.C;
        if (f2 != 2.1474836E9f) {
            float f3 = this.D;
            if (f3 != 2.1474836E9f && f2 > f3) {
                String.format("Initialized with conflicting values: starSize is greater than maxStarSize (%f > %f). I will ignore maxStarSize", Float.valueOf(f2), Float.valueOf(this.D));
            }
        }
        float f4 = this.E;
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for stepSize. Found %f, but should be greater than 0", Float.valueOf(f4)));
        }
        float f5 = this.I;
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starBorderWidth. Found %f, but should be greater than 0", Float.valueOf(f5)));
        }
        if (this.J < 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starCornerRadius. Found %f, but should be greater or equal than 0", Float.valueOf(f5)));
        }
    }

    public a getAnimationBuilder() {
        return new a(this, this, null);
    }

    @ColorInt
    public int getBorderColor() {
        return this.f4499s;
    }

    @ColorInt
    public int getFillColor() {
        return this.f4500t;
    }

    public Gravity getGravity() {
        return this.H;
    }

    public float getMaxStarSize() {
        return this.D;
    }

    public int getNumberOfStars() {
        return this.A;
    }

    @ColorInt
    public int getPressedBorderColor() {
        return this.f4503w;
    }

    @ColorInt
    public int getPressedFillColor() {
        return this.f4504x;
    }

    @ColorInt
    public int getPressedStarBackgroundColor() {
        return this.f4506z;
    }

    public float getRating() {
        return this.F;
    }

    @ColorInt
    public int getStarBackgroundColor() {
        return this.f4502v;
    }

    public float getStarBorderWidth() {
        return this.I;
    }

    public float getStarCornerRadius() {
        return this.J;
    }

    public float getStarSize() {
        return this.L;
    }

    public float getStarsSeparation() {
        return this.B;
    }

    public float getStepSize() {
        return this.E;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        if (getWidth() == 0 || height == 0) {
            return;
        }
        this.f4497d0.drawColor(0, PorterDuff.Mode.CLEAR);
        b();
        if (this.H == Gravity.Left) {
            a(this.f4497d0);
        } else {
            b(this.f4497d0);
        }
        if (this.W) {
            canvas.drawColor(this.f4505y);
        } else {
            canvas.drawColor(this.f4501u);
        }
        canvas.drawBitmap(this.f4498e0, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int width = getWidth();
        int height = getHeight();
        float f2 = this.C;
        if (f2 == 2.1474836E9f) {
            this.L = a(width, height);
        } else {
            this.L = f2;
        }
        c(width, height);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                float f2 = this.C;
                if (f2 != 2.1474836E9f) {
                    size = Math.min(b(f2, this.A, this.B, true), size);
                } else {
                    float f3 = this.D;
                    size = f3 != 2.1474836E9f ? Math.min(b(f3, this.A, this.B, true), size) : Math.min(b(this.M, this.A, this.B, true), size);
                }
            } else {
                float f4 = this.C;
                if (f4 != 2.1474836E9f) {
                    size = b(f4, this.A, this.B, true);
                } else {
                    float f5 = this.D;
                    size = f5 != 2.1474836E9f ? b(f5, this.A, this.B, true) : b(this.M, this.A, this.B, true);
                }
            }
        }
        float paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        float f6 = this.B;
        int i4 = this.A;
        float f7 = (paddingLeft - ((i4 - 1) * f6)) / i4;
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                float f8 = this.C;
                if (f8 != 2.1474836E9f) {
                    size2 = Math.min(a(f8, i4, f6, true), size2);
                } else {
                    float f9 = this.D;
                    size2 = f9 != 2.1474836E9f ? Math.min(a(f9, i4, f6, true), size2) : Math.min(a(f7, i4, f6, true), size2);
                }
            } else {
                float f10 = this.C;
                if (f10 != 2.1474836E9f) {
                    size2 = a(f10, i4, f6, true);
                } else {
                    float f11 = this.D;
                    size2 = f11 != 2.1474836E9f ? a(f11, i4, f6, true) : a(f7, i4, f6, true);
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRating(savedState.f4511s);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4511s = getRating();
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        b(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ValueAnimator valueAnimator;
        b bVar;
        if (!this.G && ((valueAnimator = this.T) == null || !valueAnimator.isRunning())) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                        }
                    }
                    invalidate();
                    return true;
                }
                a(motionEvent.getX(), motionEvent.getY());
                View.OnClickListener onClickListener = this.V;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                b bVar2 = this.U;
                if (bVar2 != null) {
                    bVar2.a(this, this.F, true);
                }
                this.W = false;
                invalidate();
                return true;
            }
            if (this.f4496c0.contains(motionEvent.getX(), motionEvent.getY())) {
                this.W = true;
                a(motionEvent.getX(), motionEvent.getY());
                invalidate();
                return true;
            }
            if (this.W && (bVar = this.U) != null) {
                bVar.a(this, this.F, true);
            }
            this.W = false;
        }
        return false;
    }

    public void setBorderColor(@ColorInt int i2) {
        this.f4499s = i2;
        invalidate();
    }

    public void setDrawBorderEnabled(boolean z2) {
        this.K = z2;
        invalidate();
    }

    public void setFillColor(@ColorInt int i2) {
        this.f4500t = i2;
        invalidate();
    }

    public void setGravity(Gravity gravity) {
        this.H = gravity;
        invalidate();
    }

    public void setIndicator(boolean z2) {
        this.G = z2;
        this.W = false;
    }

    public void setMaxStarSize(float f2) {
        this.D = f2;
        if (this.L > f2) {
            requestLayout();
            b(getWidth(), getHeight());
            invalidate();
        }
    }

    public void setNumberOfStars(int i2) {
        this.A = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for numberOfStars. Found %d, but should be greater than 0", Integer.valueOf(i2)));
        }
        this.F = 0.0f;
        requestLayout();
        b(getWidth(), getHeight());
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.V = onClickListener;
    }

    public void setOnRatingBarChangeListener(b bVar) {
        this.U = bVar;
    }

    public void setPressedBorderColor(@ColorInt int i2) {
        this.f4503w = i2;
        invalidate();
    }

    public void setPressedFillColor(@ColorInt int i2) {
        this.f4504x = i2;
        invalidate();
    }

    public void setPressedStarBackgroundColor(@ColorInt int i2) {
        this.f4506z = i2;
        invalidate();
    }

    public void setRating(float f2) {
        this.F = a(f2);
        invalidate();
        if (this.U != null) {
            ValueAnimator valueAnimator = this.T;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                this.U.a(this, f2, false);
            }
        }
    }

    public void setStarBackgroundColor(@ColorInt int i2) {
        this.f4502v = i2;
        invalidate();
    }

    public void setStarBorderWidth(float f2) {
        this.I = f2;
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starBorderWidth. Found %f, but should be greater than 0", Float.valueOf(f2)));
        }
        this.O.setStrokeWidth(f2);
        invalidate();
    }

    public void setStarCornerRadius(float f2) {
        this.J = f2;
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for starCornerRadius. Found %f, but should be greater or equal than 0", Float.valueOf(f2)));
        }
        this.R = new CornerPathEffect(f2);
        this.O.setPathEffect(this.R);
        this.N.setPathEffect(this.R);
        invalidate();
    }

    public void setStarSize(float f2) {
        this.C = f2;
        if (f2 != 2.1474836E9f) {
            float f3 = this.D;
            if (f3 != 2.1474836E9f && f2 > f3) {
                String.format("Initialized with conflicting values: starSize is greater than maxStarSize (%f > %f). I will ignore maxStarSize", Float.valueOf(f2), Float.valueOf(this.D));
            }
        }
        requestLayout();
        b(getWidth(), getHeight());
        invalidate();
    }

    public void setStarsSeparation(float f2) {
        this.B = f2;
        requestLayout();
        b(getWidth(), getHeight());
        invalidate();
    }

    public void setStepSize(float f2) {
        this.E = f2;
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException(String.format("SimpleRatingBar initialized with invalid value for stepSize. Found %f, but should be greater than 0", Float.valueOf(f2)));
        }
        invalidate();
    }

    public SimpleRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
        a();
    }

    private void b(int i2, int i3) {
        Bitmap bitmap = this.f4498e0;
        if (bitmap != null) {
            bitmap.recycle();
        }
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f4498e0 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        this.f4498e0.eraseColor(0);
        this.f4497d0 = new Canvas(this.f4498e0);
    }

    public SimpleRatingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
        a();
    }

    private void b() {
        if (this.W) {
            this.O.setColor(this.f4503w);
            this.P.setColor(this.f4504x);
            if (this.f4504x != 0) {
                this.P.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                this.P.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            this.Q.setColor(this.f4506z);
            if (this.f4506z != 0) {
                this.Q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
                return;
            } else {
                this.Q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                return;
            }
        }
        this.O.setColor(this.f4499s);
        this.P.setColor(this.f4500t);
        if (this.f4500t != 0) {
            this.P.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        } else {
            this.P.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        this.Q.setColor(this.f4502v);
        if (this.f4502v != 0) {
            this.Q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        } else {
            this.Q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
    }

    private void c(int i2, int i3) {
        float fB = b(this.L, this.A, this.B, false);
        float fA = a(this.L, this.A, this.B, false);
        float paddingLeft = ((((i2 - getPaddingLeft()) - getPaddingRight()) / 2) - (fB / 2.0f)) + getPaddingLeft();
        float paddingTop = ((((i3 - getPaddingTop()) - getPaddingBottom()) / 2) - (fA / 2.0f)) + getPaddingTop();
        this.f4495b0 = new RectF(paddingLeft, paddingTop, fB + paddingLeft, fA + paddingTop);
        float fWidth = this.f4495b0.width() * 0.05f;
        RectF rectF = this.f4495b0;
        this.f4496c0 = new RectF(rectF.left - fWidth, rectF.top, rectF.right + fWidth, rectF.bottom);
        float f2 = this.L;
        float f3 = 0.2f * f2;
        float f4 = 0.35f * f2;
        float f5 = 0.5f * f2;
        float f6 = 0.05f * f2;
        float f7 = 0.03f * f2;
        float f8 = 0.38f * f2;
        float f9 = 0.32f * f2;
        float f10 = 0.6f * f2;
        this.f4494a0 = new float[]{f7, f8, f7 + f4, f8, f5, f6, (f2 - f7) - f4, f8, f2 - f7, f8, f2 - f9, f10, f2 - f3, f2 - f6, f5, f2 - (0.27f * f2), f3, f2 - f6, f9, f10};
    }

    private void b(Canvas canvas) {
        float f2 = this.F;
        RectF rectF = this.f4495b0;
        float f3 = rectF.right - this.L;
        float f4 = rectF.top;
        float f5 = f3;
        float f6 = f2;
        for (int i2 = 0; i2 < this.A; i2++) {
            if (f6 >= 1.0f) {
                a(canvas, f5, f4, 1.0f, Gravity.Right);
                f6 -= 1.0f;
            } else {
                a(canvas, f5, f4, f6, Gravity.Right);
                f6 = 0.0f;
            }
            f5 -= this.B + this.L;
        }
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SimpleRatingBar);
        this.f4499s = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(R.color.color_EC5C07));
        this.f4500t = typedArrayObtainStyledAttributes.getColor(3, this.f4499s);
        this.f4502v = typedArrayObtainStyledAttributes.getColor(13, 0);
        this.f4501u = typedArrayObtainStyledAttributes.getColor(0, 0);
        this.f4503w = typedArrayObtainStyledAttributes.getColor(9, this.f4499s);
        this.f4504x = typedArrayObtainStyledAttributes.getColor(10, this.f4500t);
        this.f4506z = typedArrayObtainStyledAttributes.getColor(11, this.f4502v);
        this.f4505y = typedArrayObtainStyledAttributes.getColor(8, this.f4501u);
        this.A = typedArrayObtainStyledAttributes.getInteger(7, 5);
        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, (int) a(4.0f, 0));
        this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, Integer.MAX_VALUE);
        this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, Integer.MAX_VALUE);
        this.E = typedArrayObtainStyledAttributes.getFloat(18, 0.1f);
        this.I = typedArrayObtainStyledAttributes.getFloat(14, 4.0f);
        this.J = typedArrayObtainStyledAttributes.getFloat(15, 6.0f);
        this.F = a(typedArrayObtainStyledAttributes.getFloat(12, 0.0f));
        this.G = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.K = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.H = Gravity.b(typedArrayObtainStyledAttributes.getInt(4, Gravity.Left.f4510s));
        typedArrayObtainStyledAttributes.recycle();
        c();
    }

    private float a(int i2, int i3) {
        float f2 = this.D;
        if (f2 != 2.1474836E9f) {
            float fB = b(f2, this.A, this.B, true);
            float fA = a(this.D, this.A, this.B, true);
            if (fB < i2 && fA < i3) {
                return this.D;
            }
            float paddingLeft = (i2 - getPaddingLeft()) - getPaddingRight();
            float f3 = this.B;
            return Math.min((paddingLeft - (f3 * (r1 - 1))) / this.A, (i3 - getPaddingTop()) - getPaddingBottom());
        }
        float paddingLeft2 = (i2 - getPaddingLeft()) - getPaddingRight();
        float f4 = this.B;
        return Math.min((paddingLeft2 - (f4 * (r1 - 1))) / this.A, (i3 - getPaddingTop()) - getPaddingBottom());
    }

    private int a(float f2, int i2, float f3, boolean z2) {
        return Math.round(f2) + (z2 ? getPaddingTop() + getPaddingBottom() : 0);
    }

    private void a(Canvas canvas) {
        float f2 = this.F;
        RectF rectF = this.f4495b0;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float f5 = f3;
        float f6 = f2;
        for (int i2 = 0; i2 < this.A; i2++) {
            if (f6 >= 1.0f) {
                a(canvas, f5, f4, 1.0f, Gravity.Left);
                f6 -= 1.0f;
            } else {
                a(canvas, f5, f4, f6, Gravity.Left);
                f6 = 0.0f;
            }
            f5 += this.B + this.L;
        }
    }

    private void a(Canvas canvas, float f2, float f3, float f4, Gravity gravity) {
        float f5 = this.L * f4;
        this.S.reset();
        Path path = this.S;
        float[] fArr = this.f4494a0;
        path.moveTo(fArr[0] + f2, fArr[1] + f3);
        int i2 = 2;
        while (true) {
            float[] fArr2 = this.f4494a0;
            if (i2 >= fArr2.length) {
                break;
            }
            this.S.lineTo(fArr2[i2] + f2, fArr2[i2 + 1] + f3);
            i2 += 2;
        }
        this.S.close();
        canvas.drawPath(this.S, this.N);
        if (gravity == Gravity.Left) {
            float f6 = f2 + f5;
            float f7 = this.L;
            canvas.drawRect(f2, f3, f6 + (0.02f * f7), f3 + f7, this.P);
            float f8 = this.L;
            canvas.drawRect(f6, f3, f2 + f8, f3 + f8, this.Q);
        } else {
            float f9 = this.L;
            canvas.drawRect((f2 + f9) - ((0.02f * f9) + f5), f3, f2 + f9, f3 + f9, this.P);
            float f10 = this.L;
            canvas.drawRect(f2, f3, (f2 + f10) - f5, f3 + f10, this.Q);
        }
        if (this.K) {
            canvas.drawPath(this.S, this.O);
        }
    }

    private void a(float f2, float f3) {
        if (this.H != Gravity.Left) {
            f2 = getWidth() - f2;
        }
        RectF rectF = this.f4495b0;
        float f4 = rectF.left;
        if (f2 < f4) {
            this.F = 0.0f;
            return;
        }
        if (f2 > rectF.right) {
            this.F = this.A;
            return;
        }
        this.F = (this.A / rectF.width()) * (f2 - f4);
        float f5 = this.F;
        float f6 = this.E;
        float f7 = f5 % f6;
        if (f7 < f6 / 4.0f) {
            this.F = f5 - f7;
            this.F = Math.max(0.0f, this.F);
        } else {
            this.F = (f5 - f7) + f6;
            this.F = Math.min(this.A, this.F);
        }
    }

    private float a(float f2, @Dimension int i2) {
        if (i2 != 0) {
            return i2 != 2 ? f2 : TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
        }
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private float a(float f2) {
        if (f2 < 0.0f) {
            String.format("Assigned rating is less than 0 (%f < 0), I will set it to exactly 0", Float.valueOf(f2));
            return 0.0f;
        }
        if (f2 <= this.A) {
            return f2;
        }
        String.format("Assigned rating is greater than numberOfStars (%f > %d), I will set it to exactly numberOfStars", Float.valueOf(f2), Integer.valueOf(this.A));
        return this.A;
    }
}
