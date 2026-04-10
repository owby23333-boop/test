package com.amgcyo.cuttadon.view.otherview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.amgcyo.cuttadon.R$styleable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes.dex */
public class ProgressWheel extends View {
    private long A;
    private int B;
    private int C;
    private Paint D;
    private Paint E;
    private RectF F;
    private float G;
    private long H;
    private boolean I;
    private float J;
    private float K;
    private boolean L;
    private b M;
    private boolean N;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f5038s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5039t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5040u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f5041v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private double f5042w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private double f5043x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f5044y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f5045z;

    static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new a();
        int A;
        boolean B;
        boolean C;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        float f5046s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        float f5047t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f5048u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        float f5049v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        int f5050w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int f5051x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f5052y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f5053z;

        class a implements Parcelable.Creator<WheelSavedState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WheelSavedState[] newArray(int i2) {
                return new WheelSavedState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f5046s);
            parcel.writeFloat(this.f5047t);
            parcel.writeByte(this.f5048u ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.f5049v);
            parcel.writeInt(this.f5050w);
            parcel.writeInt(this.f5051x);
            parcel.writeInt(this.f5052y);
            parcel.writeInt(this.f5053z);
            parcel.writeInt(this.A);
            parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        }

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.f5046s = parcel.readFloat();
            this.f5047t = parcel.readFloat();
            this.f5048u = parcel.readByte() != 0;
            this.f5049v = parcel.readFloat();
            this.f5050w = parcel.readInt();
            this.f5051x = parcel.readInt();
            this.f5052y = parcel.readInt();
            this.f5053z = parcel.readInt();
            this.A = parcel.readInt();
            this.B = parcel.readByte() != 0;
            this.C = parcel.readByte() != 0;
        }
    }

    public interface b {
        void a(float f2);
    }

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5038s = 28;
        this.f5039t = 4;
        this.f5040u = 4;
        this.f5041v = false;
        this.f5042w = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        this.f5043x = 460.0d;
        this.f5044y = 0.0f;
        this.f5045z = true;
        this.A = 0L;
        this.B = -1442840576;
        this.C = ViewCompat.MEASURED_SIZE_MASK;
        this.D = new Paint();
        this.E = new Paint();
        this.F = new RectF();
        this.G = 230.0f;
        this.H = 0L;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = false;
        a(context.obtainStyledAttributes(attributeSet, R$styleable.ProgressWheel));
        c();
    }

    private void a(int i2, int i3) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.f5041v) {
            int i4 = this.f5039t;
            this.F = new RectF(paddingLeft + i4, paddingTop + i4, (i2 - paddingRight) - i4, (i3 - paddingBottom) - i4);
            return;
        }
        int i5 = (i2 - paddingLeft) - paddingRight;
        int iMin = Math.min(Math.min(i5, (i3 - paddingBottom) - paddingTop), (this.f5038s * 2) - (this.f5039t * 2));
        int i6 = ((i5 - iMin) / 2) + paddingLeft;
        int i7 = ((((i3 - paddingTop) - paddingBottom) - iMin) / 2) + paddingTop;
        int i8 = this.f5039t;
        this.F = new RectF(i6 + i8, i7 + i8, (i6 + iMin) - i8, (i7 + iMin) - i8);
    }

    private void b() {
        if (this.M != null) {
            this.M.a(Math.round((this.J * 100.0f) / 360.0f) / 100.0f);
        }
    }

    @TargetApi(17)
    private void c() {
        this.N = (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) : Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f)) != 0.0f;
    }

    private void d() {
        this.D.setColor(this.B);
        this.D.setAntiAlias(true);
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(this.f5039t);
        this.E.setColor(this.C);
        this.E.setAntiAlias(true);
        this.E.setStyle(Paint.Style.STROKE);
        this.E.setStrokeWidth(this.f5040u);
    }

    public int getBarColor() {
        return this.B;
    }

    public int getBarWidth() {
        return this.f5039t;
    }

    public int getCircleRadius() {
        return this.f5038s;
    }

    public float getProgress() {
        if (this.L) {
            return -1.0f;
        }
        return this.J / 360.0f;
    }

    public int getRimColor() {
        return this.C;
    }

    public int getRimWidth() {
        return this.f5040u;
    }

    public float getSpinSpeed() {
        return this.G / 360.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float fPow;
        float fPow2;
        float f2;
        float f3;
        super.onDraw(canvas);
        canvas.drawArc(this.F, 360.0f, 360.0f, false, this.E);
        if (this.N) {
            boolean z2 = true;
            if (this.L) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.H;
                float f4 = (jUptimeMillis * this.G) / 1000.0f;
                a(jUptimeMillis);
                this.J += f4;
                float f5 = this.J;
                if (f5 > 360.0f) {
                    this.J = f5 - 360.0f;
                    a(-1.0f);
                }
                this.H = SystemClock.uptimeMillis();
                float f6 = this.J - 90.0f;
                float f7 = this.f5044y + 16.0f;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f3 = 135.0f;
                } else {
                    f2 = f6;
                    f3 = f7;
                }
                canvas.drawArc(this.F, f2, f3, false, this.D);
            } else {
                float f8 = this.J;
                if (f8 != this.K) {
                    this.J = Math.min(this.J + (((SystemClock.uptimeMillis() - this.H) / 1000.0f) * this.G), this.K);
                    this.H = SystemClock.uptimeMillis();
                } else {
                    z2 = false;
                }
                if (f8 != this.J) {
                    b();
                }
                float f9 = this.J;
                if (this.I) {
                    fPow = f9;
                    fPow2 = 0.0f;
                } else {
                    fPow2 = ((float) (1.0d - Math.pow(1.0f - (f9 / 360.0f), 4.0f))) * 360.0f;
                    fPow = ((float) (1.0d - Math.pow(1.0f - (this.J / 360.0f), 2.0f))) * 360.0f;
                }
                canvas.drawArc(this.F, fPow2 - 90.0f, isInEditMode() ? 360.0f : fPow, false, this.D);
            }
            if (z2) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int paddingLeft = this.f5038s + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f5038s + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.J = wheelSavedState.f5046s;
        this.K = wheelSavedState.f5047t;
        this.L = wheelSavedState.f5048u;
        this.G = wheelSavedState.f5049v;
        this.f5039t = wheelSavedState.f5050w;
        this.B = wheelSavedState.f5051x;
        this.f5040u = wheelSavedState.f5052y;
        this.C = wheelSavedState.f5053z;
        this.f5038s = wheelSavedState.A;
        this.I = wheelSavedState.B;
        this.f5041v = wheelSavedState.C;
        this.H = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f5046s = this.J;
        wheelSavedState.f5047t = this.K;
        wheelSavedState.f5048u = this.L;
        wheelSavedState.f5049v = this.G;
        wheelSavedState.f5050w = this.f5039t;
        wheelSavedState.f5051x = this.B;
        wheelSavedState.f5052y = this.f5040u;
        wheelSavedState.f5053z = this.C;
        wheelSavedState.A = this.f5038s;
        wheelSavedState.B = this.I;
        wheelSavedState.C = this.f5041v;
        return wheelSavedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
        d();
        invalidate();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            this.H = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i2) {
        this.B = i2;
        d();
        if (this.L) {
            return;
        }
        invalidate();
    }

    public void setBarWidth(int i2) {
        this.f5039t = i2;
        if (this.L) {
            return;
        }
        invalidate();
    }

    public void setCallback(b bVar) {
        this.M = bVar;
        if (this.L) {
            return;
        }
        b();
    }

    public void setCircleRadius(int i2) {
        this.f5038s = i2;
        if (this.L) {
            return;
        }
        invalidate();
    }

    public void setInstantProgress(float f2) {
        if (this.L) {
            this.J = 0.0f;
            this.L = false;
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 == this.K) {
            return;
        }
        this.K = Math.min(f2 * 360.0f, 360.0f);
        this.J = this.K;
        this.H = SystemClock.uptimeMillis();
        invalidate();
    }

    public void setLinearProgress(boolean z2) {
        this.I = z2;
        if (this.L) {
            return;
        }
        invalidate();
    }

    public void setProgress(float f2) {
        if (this.L) {
            this.J = 0.0f;
            this.L = false;
            b();
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = this.K;
        if (f2 == f3) {
            return;
        }
        if (this.J == f3) {
            this.H = SystemClock.uptimeMillis();
        }
        this.K = Math.min(f2 * 360.0f, 360.0f);
        invalidate();
    }

    public void setRimColor(int i2) {
        this.C = i2;
        d();
        if (this.L) {
            return;
        }
        invalidate();
    }

    public void setRimWidth(int i2) {
        this.f5040u = i2;
        if (this.L) {
            return;
        }
        invalidate();
    }

    public void setSpinSpeed(float f2) {
        this.G = f2 * 360.0f;
    }

    private void a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f5039t = (int) TypedValue.applyDimension(1, this.f5039t, displayMetrics);
        this.f5040u = (int) TypedValue.applyDimension(1, this.f5040u, displayMetrics);
        this.f5038s = (int) TypedValue.applyDimension(1, this.f5038s, displayMetrics);
        this.f5038s = (int) typedArray.getDimension(3, this.f5038s);
        this.f5041v = typedArray.getBoolean(4, false);
        this.f5039t = (int) typedArray.getDimension(2, this.f5039t);
        this.f5040u = (int) typedArray.getDimension(8, this.f5040u);
        this.G = typedArray.getFloat(9, this.G / 360.0f) * 360.0f;
        this.f5043x = typedArray.getInt(1, (int) this.f5043x);
        this.B = typedArray.getColor(0, this.B);
        this.C = typedArray.getColor(7, this.C);
        this.I = typedArray.getBoolean(5, false);
        if (typedArray.getBoolean(6, false)) {
            a();
        }
        typedArray.recycle();
    }

    public ProgressWheel(Context context) {
        super(context);
        this.f5038s = 28;
        this.f5039t = 4;
        this.f5040u = 4;
        this.f5041v = false;
        this.f5042w = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        this.f5043x = 460.0d;
        this.f5044y = 0.0f;
        this.f5045z = true;
        this.A = 0L;
        this.B = -1442840576;
        this.C = ViewCompat.MEASURED_SIZE_MASK;
        this.D = new Paint();
        this.E = new Paint();
        this.F = new RectF();
        this.G = 230.0f;
        this.H = 0L;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = false;
        c();
    }

    private void a(long j2) {
        long j3 = this.A;
        if (j3 >= 200) {
            double d2 = this.f5042w;
            double d3 = j2;
            Double.isNaN(d3);
            this.f5042w = d2 + d3;
            double d4 = this.f5042w;
            double d5 = this.f5043x;
            if (d4 > d5) {
                this.f5042w = d4 - d5;
                this.A = 0L;
                this.f5045z = !this.f5045z;
            }
            float fCos = (((float) Math.cos(((this.f5042w / this.f5043x) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            float f2 = 254;
            if (this.f5045z) {
                this.f5044y = fCos * f2;
                return;
            }
            float f3 = f2 * (1.0f - fCos);
            this.J += this.f5044y - f3;
            this.f5044y = f3;
            return;
        }
        this.A = j3 + j2;
    }

    public void a() {
        this.H = SystemClock.uptimeMillis();
        this.L = true;
        invalidate();
    }

    private void a(float f2) {
        b bVar = this.M;
        if (bVar != null) {
            bVar.a(f2);
        }
    }
}
