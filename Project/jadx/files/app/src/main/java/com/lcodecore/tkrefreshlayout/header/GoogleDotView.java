package com.lcodecore.tkrefreshlayout.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.lcodecore.tkrefreshlayout.R$color;
import com.lcodecore.tkrefreshlayout.c;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleDotView extends View implements com.lcodecore.tkrefreshlayout.b {
    ValueAnimator A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Paint f17056s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f17057t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f17058u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f17059v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    float f17060w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f17061x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f17062y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    ValueAnimator f17063z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            GoogleDotView.this.f17060w = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            GoogleDotView.this.invalidate();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            GoogleDotView.this.f17061x = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    public GoogleDotView(Context context) {
        this(context, null, 0);
    }

    private void a() {
        this.f17057t = com.lcodecore.tkrefreshlayout.h.a.a(getContext(), 4.0f);
        this.f17056s = new Paint();
        this.f17056s.setAntiAlias(true);
        this.f17056s.setColor(Color.rgb(114, 114, 114));
        this.f17063z = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f, 0.8f);
        this.f17063z.setDuration(800L);
        this.f17063z.setInterpolator(new DecelerateInterpolator());
        this.f17063z.addUpdateListener(new a());
        this.f17063z.setRepeatCount(-1);
        this.f17063z.setRepeatMode(2);
        this.A = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f, 1.2f);
        this.A.setDuration(800L);
        this.A.setInterpolator(new DecelerateInterpolator());
        this.A.addUpdateListener(new b());
        this.A.setRepeatCount(-1);
        this.A.setRepeatMode(2);
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void b(float f2, float f3, float f4) {
        float f5 = (f2 / 2.0f) + 1.0f;
        setScaleX(f5);
        setScaleY(f5);
        this.f17062y = false;
        if (this.f17063z.isRunning()) {
            this.f17063z.cancel();
            invalidate();
        }
        if (this.A.isRunning()) {
            this.A.cancel();
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f17063z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.A;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = (getMeasuredWidth() / this.f17058u) - 10;
        for (int i2 = 0; i2 < this.f17058u; i2++) {
            if (this.f17062y) {
                if (i2 == 0) {
                    this.f17056s.setAlpha(105);
                    this.f17056s.setColor(getResources().getColor(R$color.Yellow));
                    canvas.drawCircle(((getMeasuredWidth() / 2) - (this.f17059v * 2)) - (((measuredWidth * 2) / 3) * 2), getMeasuredHeight() / 2, this.f17057t * this.f17061x, this.f17056s);
                } else if (i2 == 1) {
                    this.f17056s.setAlpha(145);
                    this.f17056s.setColor(getResources().getColor(R$color.Green));
                    canvas.drawCircle(((getMeasuredWidth() / 2) - (this.f17059v * 1)) - ((measuredWidth / 3) * 2), getMeasuredHeight() / 2, this.f17057t * this.f17061x, this.f17056s);
                } else if (i2 == 2) {
                    this.f17056s.setAlpha(255);
                    this.f17056s.setColor(getResources().getColor(R$color.Blue));
                    canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.f17057t * this.f17060w, this.f17056s);
                } else if (i2 == 3) {
                    this.f17056s.setAlpha(145);
                    this.f17056s.setColor(getResources().getColor(R$color.Orange));
                    canvas.drawCircle((getMeasuredWidth() / 2) + (this.f17059v * 1) + ((measuredWidth / 3) * 2), getMeasuredHeight() / 2, this.f17057t * this.f17061x, this.f17056s);
                } else if (i2 == 4) {
                    this.f17056s.setAlpha(105);
                    this.f17056s.setColor(getResources().getColor(R$color.Yellow));
                    canvas.drawCircle((getMeasuredWidth() / 2) + (this.f17059v * 2) + (((measuredWidth * 2) / 3) * 2), getMeasuredHeight() / 2, this.f17057t * this.f17061x, this.f17056s);
                }
            } else if (i2 == 0) {
                this.f17056s.setAlpha(105);
                this.f17056s.setColor(getResources().getColor(R$color.Yellow));
                canvas.drawCircle(((getMeasuredWidth() / 2) - (this.f17059v * 2)) - (((measuredWidth * 2) / 3) * 2), getMeasuredHeight() / 2, this.f17057t, this.f17056s);
            } else if (i2 == 1) {
                this.f17056s.setAlpha(145);
                this.f17056s.setColor(getResources().getColor(R$color.Green));
                canvas.drawCircle(((getMeasuredWidth() / 2) - (this.f17059v * 1)) - ((measuredWidth / 3) * 2), getMeasuredHeight() / 2, this.f17057t, this.f17056s);
            } else if (i2 == 2) {
                this.f17056s.setAlpha(255);
                this.f17056s.setColor(getResources().getColor(R$color.Blue));
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.f17057t, this.f17056s);
            } else if (i2 == 3) {
                this.f17056s.setAlpha(145);
                this.f17056s.setColor(getResources().getColor(R$color.Orange));
                canvas.drawCircle((getMeasuredWidth() / 2) + (this.f17059v * 1) + ((measuredWidth / 3) * 2), getMeasuredHeight() / 2, this.f17057t, this.f17056s);
            } else if (i2 == 4) {
                this.f17056s.setAlpha(105);
                this.f17056s.setColor(getResources().getColor(R$color.Yellow));
                canvas.drawCircle((getMeasuredWidth() / 2) + (this.f17059v * 2) + (((measuredWidth * 2) / 3) * 2), getMeasuredHeight() / 2, this.f17057t, this.f17056s);
            }
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void reset() {
        this.f17062y = false;
        if (this.f17063z.isRunning()) {
            this.f17063z.cancel();
        }
        if (this.A.isRunning()) {
            this.A.cancel();
        }
        invalidate();
    }

    public void setCir_x(int i2) {
        this.f17059v = i2;
    }

    public GoogleDotView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GoogleDotView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17058u = 5;
        this.f17062y = false;
        a();
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void a(float f2, float f3, float f4) {
        float f5 = (f2 / 2.0f) + 1.0f;
        setScaleX(f5);
        setScaleY(f5);
        if (f2 < 1.0f) {
            this.f17062y = false;
            if (this.f17063z.isRunning()) {
                this.f17063z.cancel();
                invalidate();
            }
            if (this.A.isRunning()) {
                this.A.cancel();
            }
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void a(float f2, float f3) {
        this.f17062y = true;
        this.f17063z.start();
        this.A.start();
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void a(c cVar) {
        cVar.a();
    }
}
