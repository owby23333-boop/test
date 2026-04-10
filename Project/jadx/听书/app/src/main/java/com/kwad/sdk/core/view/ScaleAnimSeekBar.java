package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class ScaleAnimSeekBar extends View {
    private Paint aLU;
    private int aLV;
    private int aLW;
    private int aLX;
    private int aLY;
    private int aLZ;
    private boolean aMA;
    private ValueAnimator aMB;
    private ValueAnimator aMC;
    private ValueAnimator aMD;
    private float aME;
    private float aMF;
    private float aMG;
    private float aMH;
    private int aMI;
    private boolean aMJ;
    private int aMa;
    private int aMb;
    private int aMc;
    private boolean aMd;
    private int aMe;
    private int aMf;
    private int aMg;
    private int aMh;
    private int aMi;
    private int aMj;
    private int aMk;
    private GradientDrawable aMl;
    private GradientDrawable aMm;
    private GradientDrawable aMn;
    private Rect aMo;
    private Rect aMp;
    private Rect aMq;
    private Rect aMr;
    private Drawable aMs;
    private boolean aMt;
    private boolean aMu;
    private boolean aMv;
    private boolean aMw;
    private boolean aMx;
    private WeakReference<a> aMy;
    private boolean aMz;

    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void wd();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMa = 100;
        this.aMd = false;
        this.aMs = null;
        this.aMt = false;
        this.aMu = false;
        this.aMv = false;
        this.aMw = true;
        this.aMz = true;
        this.aMA = false;
        this.aME = 1.0f;
        this.aMF = 1.34f;
        this.aMG = 1.0f;
        this.aMH = 2.0f;
        init(context, attributeSet);
    }

    private void bS(Context context) {
        this.aMz = true;
        this.aMI = com.kwad.sdk.c.a.a.a(context, 10.0f);
        this.aLY = com.kwad.sdk.c.a.a.a(context, 3.0f);
        this.aMf = com.kwad.sdk.c.a.a.a(context, 20.0f);
        this.aMs = null;
        this.aMA = false;
        this.aMc = com.kwad.sdk.c.a.a.a(context, 0.5f);
        this.aMb = com.kwad.sdk.c.a.a.a(context, 1.0f);
        this.aLV = 654311423;
        this.aLW = -1;
        this.aLX = 1090519039;
        this.aLZ = 0;
        this.aMa = 100;
        this.aMd = false;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bS(context);
        }
        Paint paint = new Paint();
        this.aLU = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aLU.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aMl = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aMl.setColor(this.aLV);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aMm = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aMm.setColor(this.aLW);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aMn = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aMn.setColor(this.aLX);
        this.aMo = new Rect();
        this.aMp = new Rect();
        this.aMr = new Rect();
        this.aMq = new Rect();
        this.aMg = this.aLZ;
    }

    private void y(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.aMz) {
            this.aMe = (int) (i - ((this.aMI * 2) * (this.aMF - this.aME)));
        } else {
            this.aMe = i - (this.aMI * 2);
        }
        this.aMo.top = -this.aMc;
        Rect rect = this.aMo;
        rect.bottom = -rect.top;
        this.aMo.left = (this.aMd ? -i : -this.aMe) / 2;
        this.aMo.right = this.aMd ? i / 2 : this.aMe / 2;
        this.aMp.top = -this.aMc;
        Rect rect2 = this.aMp;
        rect2.bottom = -rect2.top;
        this.aMp.left = (this.aMd ? -i : -this.aMe) / 2;
        this.aMp.right = (-this.aMe) / 2;
        this.aMq.top = -this.aMc;
        this.aMq.bottom = -this.aMp.top;
        Rect rect3 = this.aMq;
        if (!this.aMd) {
            i = this.aMe;
        }
        rect3.left = (-i) / 2;
        this.aMq.right = (-this.aMe) / 2;
        this.aMr.top = -this.aLY;
        this.aMr.bottom = this.aLY;
        this.aMr.left = ((-this.aMe) / 2) - this.aLY;
        this.aMr.right = ((-this.aMe) / 2) + this.aLY;
        setThumbDrawable(this.aMs);
        setProgress(this.aMg);
        setSecondaryProgress(this.aMi);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.aMk = size;
        } else {
            this.aMk = getWidth();
        }
        if (mode2 == 1073741824) {
            this.aMj = size2;
        } else {
            this.aMj = getHeight();
        }
        y(this.aMk, this.aMj);
        setMeasuredDimension(this.aMk, this.aMj);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aMk / 2, this.aMj / 2);
        a(canvas, this.aMo, this.aMl);
        a(canvas, this.aMq, this.aMn);
        a(canvas, this.aMp, this.aMm);
        if (this.aMJ) {
            c(canvas);
        }
        canvas.restore();
    }

    public final void bv(boolean z) {
        this.aMJ = z;
        bw(z);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        rect2.top = (int) (rect.top * this.aMG);
        rect2.bottom = (int) (rect.bottom * this.aMG);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aMb * this.aMG);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aMs;
        if (drawable != null) {
            drawable.setBounds(this.aMr);
            this.aMs.draw(canvas);
        } else {
            this.aLU.setColor(this.aLW);
            canvas.drawCircle(this.aMr.centerX(), this.aMr.centerY(), (this.aMr.width() * this.aME) / 2.0f, this.aLU);
        }
        canvas.restore();
    }

    private boolean c(float f, float f2) {
        return this.aMr.left < this.aMr.right && this.aMr.top < this.aMr.bottom && f >= (((float) this.aMr.left) * this.aME) - ((float) this.aMf) && f <= (((float) this.aMr.right) * this.aME) + ((float) this.aMf) && f2 >= (((float) this.aMr.top) * this.aME) - ((float) this.aMf) && f2 <= (((float) this.aMr.bottom) * this.aME) + ((float) this.aMf);
    }

    private boolean d(float f, float f2) {
        return this.aMo.left < this.aMo.right && this.aMo.top < this.aMo.bottom && f >= (((float) this.aMo.left) * this.aMG) - ((float) this.aMf) && f <= (((float) this.aMo.right) * this.aMG) + ((float) this.aMf) && f2 >= (((float) this.aMo.top) * this.aMG) - ((float) this.aMf) && f2 <= (((float) this.aMo.bottom) * this.aMG) + ((float) this.aMf);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.aMk / 2);
        float y = motionEvent.getY() - (this.aMj / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.aMt || this.aMu)) {
                    a(dR((int) x), false, true);
                }
            } else {
                this.aMx = false;
                if (this.aMu || this.aMt) {
                    this.aMu = false;
                    this.aMt = false;
                    a(dR((int) x), this.aMA, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            if (!this.aMw) {
                return super.onTouchEvent(motionEvent);
            }
            if (c(x, y)) {
                bw(true);
                this.aMt = true;
                this.aMx = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.wd();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (d(x, y)) {
                bw(true);
                this.aMu = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.wd();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aMy;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void a(int i, boolean z, boolean z2) {
        int i2 = this.aLZ;
        if (i <= i2 || i >= (i2 = this.aMa)) {
            i = i2;
        }
        i(z, i);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aMh != this.aMg) {
            this.aMv = z2;
            onSeekBarChangedListener.a(this, z2);
            this.aMv = false;
        }
        this.aMh = this.aMg;
    }

    private void i(boolean z, int i) {
        if (z) {
            float fJ = j(dQ(this.aMg));
            float fJ2 = j(dQ(i));
            ValueAnimator valueAnimator = this.aMD;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.aMD = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.aMD.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float f2 = f - 1.0f;
                        return (f2 * f2 * f2) + 1.0f;
                    }
                });
                this.aMD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        float fFloatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                        scaleAnimSeekBar.aMg = scaleAnimSeekBar.dR((int) fFloatValue);
                        ScaleAnimSeekBar.this.i(fFloatValue);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.aMD.setFloatValues(fJ, fJ2);
            this.aMD.start();
            return;
        }
        this.aMg = i;
        i(j(dQ(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f) {
        this.aMr.left = (int) (f - this.aLY);
        this.aMr.right = (int) (this.aLY + f);
        this.aMp.right = (int) f;
        invalidate();
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.aLZ;
        if (i <= i2 || i >= (i2 = this.aMa)) {
            i = i2;
        }
        this.aMi = i;
        this.aMq.right = (int) j(dQ(i));
        invalidate();
    }

    public int getSecondaryProgress() {
        return this.aMi;
    }

    private void bw(boolean z) {
        if (this.aMz) {
            if (z) {
                bx(true);
                by(true);
            } else {
                bx(false);
                by(false);
            }
        }
    }

    private void bx(boolean z) {
        float f = this.aME;
        float f2 = z ? this.aMF : 1.0f;
        ValueAnimator valueAnimator = this.aMB;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aMB = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aMB.setInterpolator(new LinearInterpolator());
            this.aMB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aME = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aMB.setFloatValues(f, f2);
        this.aMB.start();
    }

    private void by(boolean z) {
        float f = this.aMG;
        float f2 = z ? this.aMH : 1.0f;
        ValueAnimator valueAnimator = this.aMC;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aMC = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aMC.setInterpolator(new LinearInterpolator());
            this.aMC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aMG = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aMC.setFloatValues(f, f2);
        this.aMC.start();
    }

    private float j(float f) {
        float f2 = this.aMe / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        return f < f3 ? f3 : f;
    }

    public int getProgress() {
        return this.aMg;
    }

    public void setProgress(int i) {
        a(i, false, false);
    }

    public void setMinProgress(int i) {
        this.aLZ = i;
        if (this.aMg < i) {
            this.aMg = i;
        }
    }

    public void setMaxProgress(int i) {
        this.aMa = i;
    }

    public int getMaxProgress() {
        return this.aMa;
    }

    public void setProgressBackgroundColor(int i) {
        this.aLV = i;
        this.aMl.setColor(i);
    }

    public void setProgressColor(int i) {
        this.aLW = i;
        this.aMm.setColor(i);
    }

    public void setSecondaryProgressColor(int i) {
        this.aLX = i;
        this.aMn.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aMs = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.aMw = z;
    }

    public void setThumbTouchOffset(int i) {
        this.aMf = i;
        invalidate();
    }

    private float dQ(int i) {
        int i2 = this.aMe;
        int i3 = this.aLZ;
        return ((i2 * (i - i3)) / (this.aMa - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dR(int i) {
        int i2 = this.aMe;
        if (i > i2 / 2) {
            return this.aMa;
        }
        if (i < (-i2) / 2) {
            return this.aLZ;
        }
        return Math.round(((i + (i2 / 2.0f)) * (this.aMa - this.aLZ)) / i2) + this.aLZ;
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aMy = new WeakReference<>(aVar);
    }

    public int getProgressX() {
        return (int) (getX() + (this.aLY * this.aMF));
    }

    public int getProgressLength() {
        return this.aMe;
    }

    public void setThumbScale(float f) {
        this.aME = f;
    }
}
