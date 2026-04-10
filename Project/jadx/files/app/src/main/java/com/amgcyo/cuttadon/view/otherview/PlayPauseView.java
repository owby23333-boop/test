package com.amgcyo.cuttadon.view.otherview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class PlayPauseView extends View {
    private float A;
    private Rect B;
    private RectF C;
    private boolean D;
    private boolean E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private float P;
    private int Q;
    private b R;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f5025s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5026t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Paint f5027u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Paint f5028v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Path f5029w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Path f5030x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f5031y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f5032z;

    public enum Direction {
        POSITIVE(1),
        NEGATIVE(2);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f5036s;

        Direction(int i2) {
            this.f5036s = i2;
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayPauseView.this.a()) {
                PlayPauseView.this.b();
                if (PlayPauseView.this.R != null) {
                    PlayPauseView.this.R.pause();
                    return;
                }
                return;
            }
            PlayPauseView.this.c();
            if (PlayPauseView.this.R != null) {
                PlayPauseView.this.R.play();
            }
        }
    }

    public interface b {
        void pause();

        void play();
    }

    public PlayPauseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = -1;
        this.N = -16777216;
        this.O = Direction.POSITIVE.f5036s;
        this.Q = 200;
        a(context, attributeSet);
    }

    private void f() {
        this.L = this.f5025s / 2;
        this.P = getSpacePadding() == 0.0f ? this.L / 3.0f : getSpacePadding();
        double spacePadding = getSpacePadding();
        double d2 = this.L;
        double dSqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        if (spacePadding > d2 / dSqrt || this.P < 0.0f) {
            this.P = this.L / 3.0f;
        }
        double d3 = this.L;
        double dSqrt2 = Math.sqrt(2.0d);
        Double.isNaN(d3);
        double d4 = d3 / dSqrt2;
        double d5 = this.P;
        Double.isNaN(d5);
        float f2 = (float) (d4 - d5);
        int i2 = this.L;
        this.K = (int) (i2 - f2);
        int i3 = (int) (i2 + f2);
        Rect rect = this.B;
        int i4 = this.K;
        rect.top = i4;
        rect.bottom = i3;
        rect.left = i4;
        rect.right = i3;
        RectF rectF = this.C;
        float f3 = f2 * 2.0f;
        rectF.top = i2 - f3;
        rectF.bottom = i2 + f3;
        rectF.left = i2 - f3;
        rectF.right = i2 + f3;
        float f4 = f3 + 2.0f;
        this.I = f4;
        this.J = f4;
        this.f5032z = getGapWidth() != 0.0f ? getGapWidth() : this.I / 3.0f;
        this.A = this.D ? 0.0f : 1.0f;
        this.Q = getAnimDuration() < 0 ? 200 : getAnimDuration();
        this.F = -90.0f;
        this.G = 120.0f;
        this.f5028v.setStrokeWidth(f2 / 2.0f);
    }

    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.A = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void c() {
        if (getPlayPauseAnim() != null) {
            getPlayPauseAnim().cancel();
        }
        setPlaying(true);
        getPlayPauseAnim().start();
    }

    public void d() {
        if (getLoadingAnim() != null) {
            getLoadingAnim().cancel();
            getLoadingAnim().start();
        }
    }

    public void e() {
        if (getLoadingAnim() != null) {
            getLoadingAnim().cancel();
        }
    }

    public int getAnimDuration() {
        return this.Q;
    }

    public int getBgColor() {
        return this.M;
    }

    public int getBtnColor() {
        return this.N;
    }

    public int getDirection() {
        return this.O;
    }

    public float getGapWidth() {
        return this.f5032z;
    }

    public ValueAnimator getLoadingAnim() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setDuration(com.anythink.expressad.exoplayer.i.a.f9492f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amgcyo.cuttadon.view.otherview.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f5106s.a(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public ValueAnimator getPlayPauseAnim() {
        float[] fArr = new float[2];
        fArr[0] = this.D ? 1.0f : 0.0f;
        fArr[1] = this.D ? 0.0f : 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setDuration(this.Q);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amgcyo.cuttadon.view.otherview.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f5107s.b(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public float getSpacePadding() {
        return this.P;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f5029w.rewind();
        this.f5030x.rewind();
        this.f5027u.setColor(this.M);
        canvas.drawCircle(this.f5025s / 2, this.f5026t / 2, this.L, this.f5027u);
        if (this.f5031y > 0.0f) {
            if (this.E) {
                canvas.drawArc(this.C, this.F, this.G, false, this.f5028v);
            } else {
                canvas.drawArc(this.C, -90.0f, this.H, false, this.f5028v);
            }
        }
        float f2 = this.f5032z;
        float f3 = this.A;
        float f4 = f2 * (1.0f - f3);
        float f5 = (this.I / 2.0f) - (f4 / 2.0f);
        float f6 = f5 * f3;
        float f7 = f5 + f4;
        float f8 = (f5 * 2.0f) + f4;
        float f9 = f8 - (f3 * f5);
        this.f5027u.setColor(this.N);
        if (this.O == Direction.NEGATIVE.f5036s) {
            Path path = this.f5029w;
            int i2 = this.K;
            path.moveTo(i2, i2);
            Path path2 = this.f5029w;
            int i3 = this.K;
            path2.lineTo(f6 + i3, this.J + i3);
            Path path3 = this.f5029w;
            int i4 = this.K;
            path3.lineTo(i4 + f5, this.J + i4);
            Path path4 = this.f5029w;
            int i5 = this.K;
            path4.lineTo(f5 + i5, i5);
            this.f5029w.close();
            Path path5 = this.f5030x;
            int i6 = this.K;
            path5.moveTo(i6 + f7, i6);
            Path path6 = this.f5030x;
            int i7 = this.K;
            path6.lineTo(f7 + i7, this.J + i7);
            Path path7 = this.f5030x;
            int i8 = this.K;
            path7.lineTo(f9 + i8, this.J + i8);
            Path path8 = this.f5030x;
            int i9 = this.K;
            path8.lineTo(f8 + i9, i9);
            this.f5030x.close();
        } else {
            Path path9 = this.f5029w;
            int i10 = this.K;
            path9.moveTo(f6 + i10, i10);
            Path path10 = this.f5029w;
            int i11 = this.K;
            path10.lineTo(i11, this.J + i11);
            Path path11 = this.f5029w;
            int i12 = this.K;
            path11.lineTo(i12 + f5, this.J + i12);
            Path path12 = this.f5029w;
            int i13 = this.K;
            path12.lineTo(i13 + f5, i13);
            this.f5029w.close();
            Path path13 = this.f5030x;
            int i14 = this.K;
            path13.moveTo(i14 + f7, i14);
            Path path14 = this.f5030x;
            int i15 = this.K;
            path14.lineTo(i15 + f7, this.J + i15);
            Path path15 = this.f5030x;
            int i16 = this.K;
            path15.lineTo(f7 + i16 + f5, this.J + i16);
            Path path16 = this.f5030x;
            int i17 = this.K;
            path16.lineTo(f9 + i17, i17);
            this.f5030x.close();
        }
        canvas.save();
        canvas.translate((this.J / 8.0f) * this.A, 0.0f);
        float f10 = this.D ? 1.0f - this.A : this.A;
        float f11 = this.O == Direction.NEGATIVE.f5036s ? -90 : 90;
        if (this.D) {
            f10 += 1.0f;
        }
        canvas.rotate(f11 * f10, this.f5025s / 2.0f, this.f5026t / 2.0f);
        canvas.drawPath(this.f5029w, this.f5027u);
        canvas.drawPath(this.f5030x, this.f5027u);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f5025s = View.MeasureSpec.getSize(i2);
        this.f5026t = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            int i4 = (int) (getResources().getDisplayMetrics().density * 50.0f);
            this.f5026t = i4;
            this.f5025s = i4;
            setMeasuredDimension(this.f5025s, this.f5026t);
            return;
        }
        if (mode != 1073741824) {
            return;
        }
        int iMin = Math.min(this.f5025s, this.f5026t);
        this.f5026t = iMin;
        this.f5025s = iMin;
        setMeasuredDimension(this.f5025s, this.f5026t);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5026t = i2;
        this.f5025s = i2;
        f();
    }

    public void setAnimDuration(int i2) {
        this.Q = i2;
    }

    public void setBgColor(int i2) {
        this.M = i2;
    }

    public void setBtnColor(int i2) {
        this.N = i2;
        invalidate();
    }

    public void setDirection(Direction direction) {
        this.O = direction.f5036s;
    }

    public void setGapWidth(int i2) {
        this.f5032z = i2;
    }

    public void setLoading(boolean z2) {
        this.E = z2;
        if (this.E) {
            d();
        } else {
            e();
        }
        invalidate();
    }

    public void setPlayPauseListener(b bVar) {
        this.R = bVar;
        setOnClickListener(new a());
    }

    public void setPlaying(boolean z2) {
        this.D = z2;
    }

    public void setProgress(float f2) {
        this.H = (int) (360.0f * f2);
        if (this.E && f2 > 0.0f) {
            this.E = false;
        }
        String str = "newAngle =" + this.H;
        postInvalidate();
    }

    public void setSpacePadding(float f2) {
        this.P = f2;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PlayPauseView);
        this.M = typedArrayObtainStyledAttributes.getColor(2, -1);
        this.N = typedArrayObtainStyledAttributes.getColor(4, -16777216);
        this.f5032z = typedArrayObtainStyledAttributes.getFloat(5, 0.0f);
        this.f5031y = typedArrayObtainStyledAttributes.getFloat(3, 20.0f);
        this.O = typedArrayObtainStyledAttributes.getInt(0, Direction.POSITIVE.f5036s);
        this.P = typedArrayObtainStyledAttributes.getFloat(6, 0.0f);
        this.Q = typedArrayObtainStyledAttributes.getInt(1, 200);
        typedArrayObtainStyledAttributes.recycle();
        this.f5027u = new Paint();
        this.f5027u.setAntiAlias(true);
        this.f5027u.setStrokeCap(Paint.Cap.ROUND);
        this.f5027u.setStrokeJoin(Paint.Join.ROUND);
        this.f5027u.setStyle(Paint.Style.FILL);
        this.f5028v = new Paint();
        this.f5028v.setAntiAlias(true);
        this.f5028v.setColor(Color.parseColor("#ffffff"));
        this.f5028v.setStrokeWidth(this.f5031y);
        this.f5028v.setStyle(Paint.Style.STROKE);
        this.f5028v.setStrokeCap(Paint.Cap.ROUND);
        this.f5028v.setStrokeJoin(Paint.Join.ROUND);
        this.f5029w = new Path();
        this.f5030x = new Path();
        this.B = new Rect();
        this.C = new RectF();
    }

    public void b() {
        if (getPlayPauseAnim() != null) {
            getPlayPauseAnim().cancel();
        }
        setPlaying(false);
        getPlayPauseAnim().start();
    }

    public PlayPauseView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.M = -1;
        this.N = -16777216;
        this.O = Direction.POSITIVE.f5036s;
        this.Q = 200;
        a(context, attributeSet);
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.G >= 90.0f) {
            this.F += 1.0f;
            if (this.F >= 360.0f) {
                this.F = 0.0f;
            }
        }
        invalidate();
    }

    public boolean a() {
        return this.D;
    }
}
