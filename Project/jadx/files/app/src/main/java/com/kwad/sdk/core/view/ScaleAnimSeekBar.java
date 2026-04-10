package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class ScaleAnimSeekBar extends View {
    private Paint anU;
    private int anV;
    private int anW;
    private int anX;
    private int anY;
    private int anZ;
    private boolean aoA;
    private ValueAnimator aoB;
    private ValueAnimator aoC;
    private ValueAnimator aoD;
    private float aoE;
    private float aoF;
    private float aoG;
    private float aoH;
    private int aoI;
    private boolean aoJ;
    private int aoa;
    private int aob;
    private int aoc;
    private boolean aod;
    private int aoe;
    private int aof;
    private int aog;
    private int aoh;
    private int aoi;
    private int aoj;
    private int aok;
    private GradientDrawable aol;
    private GradientDrawable aom;
    private GradientDrawable aon;
    private Rect aoo;
    private Rect aop;
    private Rect aoq;
    private Rect aor;
    private Drawable aos;
    private boolean aot;
    private boolean aou;
    private boolean aov;
    private boolean aow;
    private boolean aox;
    private WeakReference<a> aoy;
    private boolean aoz;

    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z2);

        void rQ();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aoa = 100;
        this.aod = false;
        this.aos = null;
        this.aot = false;
        this.aou = false;
        this.aov = false;
        this.aow = true;
        this.aoz = true;
        this.aoA = false;
        this.aoE = 1.0f;
        this.aoF = 1.34f;
        this.aoG = 1.0f;
        this.aoH = 2.0f;
        init(context, attributeSet);
    }

    private void a(int i2, boolean z2, boolean z3) {
        int i3 = this.anZ;
        if (i2 > i3 && i2 < (i3 = this.aoa)) {
            i3 = i2;
        }
        h(z2, i3);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aoh != this.aog) {
            this.aov = z3;
            onSeekBarChangedListener.a(this, this.aov);
            this.aov = false;
        }
        this.aoh = this.aog;
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f2 = rect.top;
        float f3 = this.aoG;
        rect2.top = (int) (f2 * f3);
        rect2.bottom = (int) (rect.bottom * f3);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aob * this.aoG);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void aV(boolean z2) {
        if (this.aoz) {
            boolean z3 = z2;
            aW(z3);
            aX(z3);
        }
    }

    private void aW(boolean z2) {
        float f2 = this.aoE;
        float f3 = z2 ? this.aoF : 1.0f;
        ValueAnimator valueAnimator = this.aoB;
        if (valueAnimator == null) {
            this.aoB = new ValueAnimator();
            this.aoB.setDuration(250L);
            this.aoB.setInterpolator(new LinearInterpolator());
            this.aoB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ScaleAnimSeekBar.this.aoE = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aoB.setFloatValues(f2, f3);
        this.aoB.start();
    }

    private void aX(boolean z2) {
        float f2 = this.aoG;
        float f3 = z2 ? this.aoH : 1.0f;
        ValueAnimator valueAnimator = this.aoC;
        if (valueAnimator == null) {
            this.aoC = new ValueAnimator();
            this.aoC.setDuration(250L);
            this.aoC.setInterpolator(new LinearInterpolator());
            this.aoC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ScaleAnimSeekBar.this.aoG = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aoC.setFloatValues(f2, f3);
        this.aoC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bA(int i2) {
        int i3 = this.aoe;
        return i2 > i3 / 2 ? this.aoa : i2 < (-i3) / 2 ? this.anZ : Math.round(((i2 + (i3 / 2.0f)) * (this.aoa - this.anZ)) / i3) + this.anZ;
    }

    private void bo(Context context) {
        this.aoz = true;
        this.aoI = com.kwad.sdk.b.kwai.a.a(context, 10.0f);
        this.anY = com.kwad.sdk.b.kwai.a.a(context, 3.0f);
        this.aof = com.kwad.sdk.b.kwai.a.a(context, 20.0f);
        this.aos = null;
        this.aoA = false;
        this.aoc = com.kwad.sdk.b.kwai.a.a(context, 0.3f);
        this.aob = com.kwad.sdk.b.kwai.a.a(context, 1.0f);
        this.anV = 654311423;
        this.anW = -1;
        this.anX = 1090519039;
        this.anZ = 0;
        this.aoa = 100;
        this.aod = false;
    }

    private float bz(int i2) {
        int i3 = this.aoe;
        int i4 = this.anZ;
        return ((i3 * (i2 - i4)) / (this.aoa - i4)) - (i3 / 2.0f);
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aos;
        if (drawable != null) {
            drawable.setBounds(this.aor);
            this.aos.draw(canvas);
        } else {
            this.anU.setColor(this.anW);
            canvas.drawCircle(this.aor.centerX(), this.aor.centerY(), (this.aor.width() * this.aoE) / 2.0f, this.anU);
        }
        canvas.restore();
    }

    private boolean d(float f2, float f3) {
        int i2;
        int i3;
        Rect rect = this.aor;
        int i4 = rect.left;
        int i5 = rect.right;
        if (i4 >= i5 || (i2 = rect.top) >= (i3 = rect.bottom)) {
            return false;
        }
        float f4 = this.aoE;
        int i6 = this.aof;
        return f2 >= (((float) i4) * f4) - ((float) i6) && f2 <= (((float) i5) * f4) + ((float) i6) && f3 >= (((float) i2) * f4) - ((float) i6) && f3 <= (((float) i3) * f4) + ((float) i6);
    }

    private boolean e(float f2, float f3) {
        int i2;
        int i3;
        Rect rect = this.aoo;
        int i4 = rect.left;
        int i5 = rect.right;
        if (i4 >= i5 || (i2 = rect.top) >= (i3 = rect.bottom)) {
            return false;
        }
        float f4 = this.aoG;
        int i6 = this.aof;
        return f2 >= (((float) i4) * f4) - ((float) i6) && f2 <= (((float) i5) * f4) + ((float) i6) && f3 >= (((float) i2) * f4) - ((float) i6) && f3 <= (((float) i3) * f4) + ((float) i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(float f2) {
        Rect rect = this.aor;
        int i2 = this.anY;
        rect.left = (int) (f2 - i2);
        rect.right = (int) (i2 + f2);
        this.aop.right = (int) f2;
        invalidate();
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aoy;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private float h(float f2) {
        float f3 = this.aoe / 2;
        if (f2 > f3) {
            return f3;
        }
        float f4 = -f3;
        return f2 < f4 ? f4 : f2;
    }

    private void h(boolean z2, int i2) {
        if (!z2) {
            this.aog = i2;
            g(h(bz(i2)));
            return;
        }
        float fH = h(bz(this.aog));
        float fH2 = h(bz(i2));
        ValueAnimator valueAnimator = this.aoD;
        if (valueAnimator == null) {
            this.aoD = new ValueAnimator();
            this.aoD.setDuration(300L);
            this.aoD.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f2) {
                    float f3 = f2 - 1.0f;
                    return (f3 * f3 * f3) + 1.0f;
                }
            });
            this.aoD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                    scaleAnimSeekBar.aog = scaleAnimSeekBar.bA((int) fFloatValue);
                    ScaleAnimSeekBar.this.g(fFloatValue);
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aoD.setFloatValues(fH, fH2);
        this.aoD.start();
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bo(context);
        }
        this.anU = new Paint();
        this.anU.setStyle(Paint.Style.FILL);
        this.anU.setAntiAlias(true);
        this.aol = new GradientDrawable();
        this.aol.setShape(0);
        this.aol.setColor(this.anV);
        this.aom = new GradientDrawable();
        this.aom.setShape(0);
        this.aom.setColor(this.anW);
        this.aon = new GradientDrawable();
        this.aon.setShape(0);
        this.aon.setColor(this.anX);
        this.aoo = new Rect();
        this.aop = new Rect();
        this.aor = new Rect();
        this.aoq = new Rect();
        this.aog = this.anZ;
    }

    private void r(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.aoe = this.aoz ? (int) (i2 - ((this.aoI * 2) * (this.aoF - this.aoE))) : i2 - (this.aoI * 2);
        Rect rect = this.aoo;
        rect.top = -this.aoc;
        rect.bottom = -rect.top;
        rect.left = (this.aod ? -i2 : -this.aoe) / 2;
        this.aoo.right = this.aod ? i2 / 2 : this.aoe / 2;
        Rect rect2 = this.aop;
        rect2.top = -this.aoc;
        rect2.bottom = -rect2.top;
        rect2.left = (this.aod ? -i2 : -this.aoe) / 2;
        Rect rect3 = this.aop;
        int i4 = this.aoe;
        rect3.right = (-i4) / 2;
        Rect rect4 = this.aoq;
        rect4.top = -this.aoc;
        rect4.bottom = -rect3.top;
        rect4.left = (this.aod ? -i2 : -i4) / 2;
        Rect rect5 = this.aoq;
        int i5 = this.aoe;
        rect5.right = (-i5) / 2;
        Rect rect6 = this.aor;
        int i6 = this.anY;
        rect6.top = -i6;
        rect6.bottom = i6;
        rect6.left = ((-i5) / 2) - i6;
        rect6.right = ((-i5) / 2) + i6;
        setThumbDrawable(this.aos);
        setProgress(this.aog);
        setSecondaryProgress(this.aoi);
    }

    public final void aU(boolean z2) {
        this.aoJ = z2;
        aV(z2);
    }

    public int getMaxProgress() {
        return this.aoa;
    }

    public int getProgress() {
        return this.aog;
    }

    public int getProgressLength() {
        return this.aoe;
    }

    public int getProgressX() {
        return (int) (getX() + (this.anY * this.aoF));
    }

    public int getSecondaryProgress() {
        return this.aoi;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aok / 2, this.aoj / 2);
        a(canvas, this.aoo, this.aol);
        a(canvas, this.aoq, this.aon);
        a(canvas, this.aop, this.aom);
        if (this.aoJ) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            size = getWidth();
        }
        this.aok = size;
        if (mode2 == 1073741824) {
            this.aoj = size2;
        } else {
            this.aoj = getHeight();
        }
        r(this.aok, this.aoj);
        setMeasuredDimension(this.aok, this.aoj);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            float r0 = r8.getX()
            int r1 = r7.aok
            r2 = 2
            int r1 = r1 / r2
            float r1 = (float) r1
            float r0 = r0 - r1
            float r1 = r8.getY()
            int r3 = r7.aoj
            int r3 = r3 / r2
            float r3 = (float) r3
            float r1 = r1 - r3
            android.view.ViewParent r3 = r7.getParent()
            com.kwad.sdk.core.view.ScaleAnimSeekBar$a r4 = r7.getOnSeekBarChangedListener()
            int r5 = r8.getAction()
            r6 = 1
            if (r5 == 0) goto L5d
            r8 = 0
            if (r5 == r6) goto L3a
            if (r5 == r2) goto L29
            goto L91
        L29:
            boolean r1 = r7.aot
            if (r1 != 0) goto L31
            boolean r1 = r7.aou
            if (r1 == 0) goto L91
        L31:
            int r0 = (int) r0
            int r0 = r7.bA(r0)
            r7.a(r0, r8, r6)
            goto L91
        L3a:
            r7.aox = r8
            boolean r1 = r7.aou
            if (r1 != 0) goto L44
            boolean r1 = r7.aot
            if (r1 == 0) goto L57
        L44:
            r7.aou = r8
            r7.aot = r8
            int r0 = (int) r0
            int r0 = r7.bA(r0)
            boolean r1 = r7.aoA
            r7.a(r0, r1, r6)
            if (r4 == 0) goto L57
            r4.a(r7)
        L57:
            if (r3 == 0) goto L91
            r3.requestDisallowInterceptTouchEvent(r8)
            goto L91
        L5d:
            boolean r2 = r7.aow
            if (r2 != 0) goto L66
            boolean r8 = super.onTouchEvent(r8)
            return r8
        L66:
            boolean r8 = r7.d(r0, r1)
            if (r8 == 0) goto L7e
            r7.aV(r6)
            r7.aot = r6
            r7.aox = r6
            if (r4 == 0) goto L78
            r4.rQ()
        L78:
            if (r3 == 0) goto L91
        L7a:
            r3.requestDisallowInterceptTouchEvent(r6)
            goto L91
        L7e:
            boolean r8 = r7.e(r0, r1)
            if (r8 == 0) goto L91
            r7.aV(r6)
            r7.aou = r6
            if (r4 == 0) goto L8e
            r4.rQ()
        L8e:
            if (r3 == 0) goto L91
            goto L7a
        L91:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.view.ScaleAnimSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setMaxProgress(int i2) {
        this.aoa = i2;
    }

    public void setMinProgress(int i2) {
        this.anZ = i2;
        int i3 = this.aog;
        int i4 = this.anZ;
        if (i3 < i4) {
            this.aog = i4;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aoy = new WeakReference<>(aVar);
    }

    public void setProgress(int i2) {
        a(i2, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i2) {
        this.anV = i2;
        this.aol.setColor(this.anV);
    }

    public void setProgressColor(@ColorInt int i2) {
        this.anW = i2;
        this.aom.setColor(this.anW);
    }

    public void setSecondaryProgress(int i2) {
        int i3 = this.anZ;
        if (i2 > i3 && i2 < (i3 = this.aoa)) {
            i3 = i2;
        }
        this.aoi = i3;
        this.aoq.right = (int) h(bz(i3));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i2) {
        this.anX = i2;
        this.aon.setColor(this.anX);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aos = drawable;
    }

    public void setThumbEnable(boolean z2) {
        this.aow = z2;
    }

    public void setThumbScale(float f2) {
        this.aoE = f2;
    }

    public void setThumbTouchOffset(int i2) {
        this.aof = i2;
        invalidate();
    }
}
