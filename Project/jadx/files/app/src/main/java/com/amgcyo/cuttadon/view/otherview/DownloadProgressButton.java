package com.amgcyo.cuttadon.view.otherview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.amgcyo.cuttadon.R$styleable;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DownloadProgressButton extends AppCompatTextView {
    private float A;
    private float B;
    private int C;
    private int D;
    private float E;
    private float F;
    private float G;
    private boolean H;
    private RectF I;
    private LinearGradient J;
    private ValueAnimator K;
    private CharSequence L;
    private int M;
    private float[] N;
    private float[] O;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Paint f4954s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile Paint f4955t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4956u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4957v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4958w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4959x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f4960y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f4961z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f4962s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f4963t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private String f4964u;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4962s);
            parcel.writeInt(this.f4963t);
            parcel.writeString(this.f4964u);
        }

        public SavedState(Parcelable parcelable, int i2, int i3, String str) {
            super(parcelable);
            this.f4962s = i2;
            this.f4963t = i3;
            this.f4964u = str;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4962s = parcel.readInt();
            this.f4963t = parcel.readInt();
            this.f4964u = parcel.readString();
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DownloadProgressButton downloadProgressButton = DownloadProgressButton.this;
            downloadProgressButton.A = ((downloadProgressButton.B - DownloadProgressButton.this.A) * fFloatValue) + DownloadProgressButton.this.A;
            DownloadProgressButton.this.invalidate();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f4966s;

        b(int i2) {
            this.f4966s = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DownloadProgressButton.this.N[this.f4966s] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DownloadProgressButton.this.postInvalidate();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f4968s;

        c(int i2) {
            this.f4968s = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DownloadProgressButton.this.O[this.f4968s] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DownloadProgressButton.this.postInvalidate();
        }
    }

    public DownloadProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setBallStyle(int i2) {
        if (i2 == 1) {
            b();
        } else {
            a();
        }
    }

    public float getBorderWidth() {
        return this.f4961z;
    }

    public float getButtonRadius() {
        return this.f4960y;
    }

    public int getMaxProgress() {
        return this.C;
    }

    public int getMinProgress() {
        return this.D;
    }

    public float getProgress() {
        return this.A;
    }

    public int getState() {
        return this.M;
    }

    public int getTextColor() {
        return this.f4958w;
    }

    public int getTextCoverColor() {
        return this.f4959x;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        c(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.M = savedState.f4963t;
        this.A = savedState.f4962s;
        this.L = savedState.f4964u;
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), (int) this.A, this.M, this.L.toString());
    }

    public void setBorderWidth(int i2) {
        this.f4961z = a(i2);
    }

    public void setButtonRadius(float f2) {
        this.f4960y = f2;
    }

    public void setCurrentText(CharSequence charSequence) {
        this.L = charSequence;
        invalidate();
    }

    public void setMaxProgress(int i2) {
        this.C = i2;
    }

    public void setMinProgress(int i2) {
        this.D = i2;
    }

    public void setProgress(float f2) {
        this.A = f2;
    }

    public void setShowBorder(boolean z2) {
        this.H = z2;
    }

    public void setState(int i2) {
        if (this.M != i2) {
            this.M = i2;
            invalidate();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        this.f4958w = i2;
    }

    public void setTextCoverColor(int i2) {
        this.f4959x = i2;
    }

    public DownloadProgressButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = -1.0f;
        this.G = 6.0f;
        this.N = new float[]{1.0f, 1.0f, 1.0f};
        this.O = new float[3];
        if (isInEditMode()) {
            return;
        }
        a(context, attributeSet);
        c();
        d();
    }

    private void b(Canvas canvas) {
        float height = (canvas.getHeight() >> 1) - ((this.f4955t.descent() / 2.0f) + (this.f4955t.ascent() / 2.0f));
        if (this.L == null) {
            this.L = "";
        }
        float fMeasureText = this.f4955t.measureText(this.L.toString());
        this.F = height;
        getMeasuredWidth();
        int i2 = this.M;
        if (i2 == 0) {
            this.f4955t.setShader(null);
            this.f4955t.setColor(this.f4959x);
            canvas.drawText(this.L.toString(), (getMeasuredWidth() - fMeasureText) / 2.0f, height, this.f4955t);
            return;
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.f4955t.setColor(this.f4959x);
            canvas.drawText(this.L.toString(), (getMeasuredWidth() - fMeasureText) / 2.0f, height, this.f4955t);
            return;
        }
        float measuredWidth = getMeasuredWidth() * this.E;
        float f2 = fMeasureText / 2.0f;
        float measuredWidth2 = (getMeasuredWidth() >> 1) - f2;
        float measuredWidth3 = (getMeasuredWidth() >> 1) + f2;
        float measuredWidth4 = ((f2 - (getMeasuredWidth() >> 1)) + measuredWidth) / fMeasureText;
        if (measuredWidth <= measuredWidth2) {
            this.f4955t.setShader(null);
            this.f4955t.setColor(this.f4958w);
        } else if (measuredWidth2 >= measuredWidth || measuredWidth > measuredWidth3) {
            this.f4955t.setShader(null);
            this.f4955t.setColor(this.f4959x);
        } else {
            this.J = new LinearGradient((getMeasuredWidth() - fMeasureText) / 2.0f, 0.0f, (getMeasuredWidth() + fMeasureText) / 2.0f, 0.0f, new int[]{this.f4959x, this.f4958w}, new float[]{measuredWidth4, measuredWidth4 + 0.001f}, Shader.TileMode.CLAMP);
            this.f4955t.setColor(this.f4958w);
            this.f4955t.setShader(this.J);
        }
        canvas.drawText(this.L.toString(), (getMeasuredWidth() - fMeasureText) / 2.0f, height, this.f4955t);
    }

    private void c() {
        this.C = 100;
        this.D = 0;
        this.A = 0.0f;
        this.H = true;
        this.f4954s = new Paint();
        this.f4954s.setAntiAlias(true);
        this.f4954s.setStyle(Paint.Style.FILL);
        this.f4955t = new Paint();
        this.f4955t.setAntiAlias(true);
        this.f4955t.setTextSize(36.0f);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, this.f4955t);
        }
        this.M = 0;
        invalidate();
    }

    private void d() {
        this.K = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(500L);
        this.K.addUpdateListener(new a());
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DownloadProgressButton);
        try {
            this.f4956u = typedArrayObtainStyledAttributes.getColor(0, Color.parseColor("#3385FF"));
            this.f4957v = typedArrayObtainStyledAttributes.getColor(1, Color.parseColor("#E8E8E8"));
            this.f4960y = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
            this.f4958w = typedArrayObtainStyledAttributes.getColor(5, this.f4956u);
            this.f4959x = typedArrayObtainStyledAttributes.getColor(6, -1);
            this.f4961z = typedArrayObtainStyledAttributes.getDimension(3, a(2));
            typedArrayObtainStyledAttributes.getInt(2, 2);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void a(Canvas canvas) {
        this.I = new RectF();
        this.I.left = this.H ? this.f4961z : 0.0f;
        this.I.top = this.H ? this.f4961z : 0.0f;
        this.I.right = getMeasuredWidth() - (this.H ? this.f4961z : 0.0f);
        this.I.bottom = getMeasuredHeight() - (this.H ? this.f4961z : 0.0f);
        if (this.H) {
            this.f4954s.setStyle(Paint.Style.STROKE);
            this.f4954s.setColor(this.f4956u);
            this.f4954s.setStrokeWidth(this.f4961z);
            RectF rectF = this.I;
            float f2 = this.f4960y;
            canvas.drawRoundRect(rectF, f2, f2, this.f4954s);
        }
        this.f4954s.setStyle(Paint.Style.FILL);
        int i2 = this.M;
        if (i2 == 0) {
            this.f4954s.setColor(this.f4956u);
            RectF rectF2 = this.I;
            float f3 = this.f4960y;
            canvas.drawRoundRect(rectF2, f3, f3, this.f4954s);
            return;
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.f4954s.setColor(this.f4956u);
            RectF rectF3 = this.I;
            float f4 = this.f4960y;
            canvas.drawRoundRect(rectF3, f4, f4, this.f4954s);
            return;
        }
        this.E = this.A / (this.C + 0.0f);
        this.f4954s.setColor(this.f4957v);
        canvas.save();
        RectF rectF4 = this.I;
        float f5 = this.f4960y;
        canvas.drawRoundRect(rectF4, f5, f5, this.f4954s);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.f4954s.setColor(this.f4956u);
        this.f4954s.setXfermode(porterDuffXfermode);
        RectF rectF5 = this.I;
        canvas.drawRect(rectF5.left, rectF5.top, rectF5.right * this.E, rectF5.bottom, this.f4954s);
        canvas.restore();
        this.f4954s.setXfermode(null);
    }

    private void c(Canvas canvas) {
        a(canvas);
        b(canvas);
    }

    public ArrayList<ValueAnimator> b() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {120, TbsListener.ErrorCode.TPATCH_VERSION_FAILED, 360};
        for (int i2 = 0; i2 < 3; i2++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            valueAnimatorOfFloat.setDuration(750L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setStartDelay(iArr[i2]);
            valueAnimatorOfFloat.addUpdateListener(new b(i2));
            arrayList.add(valueAnimatorOfFloat);
        }
        return arrayList;
    }

    public ArrayList<ValueAnimator> a() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {70, 140, 210};
        for (int i2 = 0; i2 < 3; i2++) {
            float f2 = this.F;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, f2 - (this.G * 2.0f), f2);
            valueAnimatorOfFloat.setDuration(600L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setStartDelay(iArr[i2]);
            valueAnimatorOfFloat.addUpdateListener(new c(i2));
            arrayList.add(valueAnimatorOfFloat);
        }
        return arrayList;
    }

    private int a(int i2) {
        return (int) (i2 * getContext().getResources().getDisplayMetrics().density);
    }
}
