package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class ViewPagerIndicator extends View {
    private float lA;
    private Paint lB;
    private float lC;
    private float lD;
    private float lE;
    private int lF;
    private Paint lG;
    private float lH;
    private a lI;
    private ValueAnimator lJ;
    private int lr;
    private int lw;
    private int lx;
    private int ly;
    private float lz;
    private final Context mContext;

    public interface a {
        void I(int i);
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i);
        dE();
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i, 0);
        this.lA = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.c.a.a.a(this.mContext, 5.0f));
        this.lC = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.lD = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.c.a.a.a(this.mContext, 50.0f));
        this.lE = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.lx = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.lw = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void dE() {
        Paint paint = new Paint(1);
        this.lB = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.lB.setStrokeWidth(1.0f);
        this.lB.setColor(this.lx);
        Paint paint2 = new Paint(1);
        this.lG = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.lG.setStrokeWidth(1.0f);
        this.lG.setColor(this.lw);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.lC : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                if (this.ly > 1) {
                    size = (int) (this.lD + ((r6 - 1) * (this.lA + this.lE)));
                } else {
                    size = (int) this.lD;
                }
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF();
        for (int i = 0; i < this.ly; i++) {
            int i2 = this.lr;
            if (i < i2 && i != i2 - 1) {
                rectF.left = i * (this.lA + this.lE);
                rectF.right = rectF.left + this.lE;
                this.lB.setColor(this.lx);
            } else if (i == i2 - 1) {
                rectF.left = i * (this.lA + this.lE);
                float f = rectF.left;
                float f2 = this.lE;
                rectF.right = f + f2 + ((this.lD - f2) * (1.0f - this.lz));
                this.lB.setColor(this.lx);
            } else if (i == i2) {
                float f3 = i2 != 0 ? this.lz : 1.0f;
                float f4 = this.lA;
                float f5 = this.lE;
                rectF.left = ((i - 1) * (f4 + f5)) + f5 + ((this.lD - f5) * (1.0f - f3)) + f4;
                float f6 = rectF.left;
                float f7 = this.lD;
                float f8 = this.lE;
                rectF.right = f6 + (f3 * (f7 - f8)) + f8;
                this.lB.setColor(this.lx);
            } else {
                float f9 = this.lA;
                rectF.left = ((i - 1) * (this.lE + f9)) + f9 + this.lD;
                rectF.right = rectF.left + this.lE;
                this.lB.setColor(this.lx);
            }
            rectF.top = 0.0f;
            rectF.bottom = rectF.top + this.lC;
            float f10 = this.lC;
            canvas.drawRoundRect(rectF, f10 / 2.0f, f10 / 2.0f, this.lB);
        }
    }

    private void b(Canvas canvas) {
        if (this.lH > 0.0f) {
            int i = this.lr;
            float f = this.lA;
            float f2 = this.lE;
            RectF rectF = new RectF(i * (f + f2), 0.0f, (i * (f + f2)) + this.lH, this.lC);
            float f3 = this.lC;
            canvas.drawRoundRect(rectF, f3 / 2.0f, f3 / 2.0f, this.lG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(final int i) {
        if (this.lF <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.lE, this.lD);
        this.lJ = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(((long) this.lF) * 1000);
        this.lJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.lH = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.lJ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (ViewPagerIndicator.this.lI != null) {
                    ViewPagerIndicator.this.lI.I(i);
                }
            }
        });
        this.lJ.start();
    }

    public final void dF() {
        ValueAnimator valueAnimator = this.lJ;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public final void dG() {
        ValueAnimator valueAnimator = this.lJ;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.ly = count;
        if (count <= 1) {
            return;
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                ViewPagerIndicator.this.lH = 0.0f;
                ViewPagerIndicator.this.lr = i;
                ViewPagerIndicator.this.lz = f;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                ViewPagerIndicator.this.lr = i;
                ViewPagerIndicator.this.lz = 1.0f;
                ViewPagerIndicator.this.invalidate();
                if (i < ViewPagerIndicator.this.ly - 1) {
                    ViewPagerIndicator.this.K(i);
                }
            }
        });
        K(this.lr);
    }

    public void setAdShowTime(int i) {
        this.lF = i;
    }

    public void setPlayProgressListener(a aVar) {
        this.lI = aVar;
    }
}
