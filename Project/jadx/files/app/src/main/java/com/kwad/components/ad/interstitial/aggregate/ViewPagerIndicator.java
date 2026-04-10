package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPagerIndicator extends View {
    private int iF;
    private int iG;
    private int iH;
    private float iI;
    private float iJ;
    private Paint iK;
    private float iL;
    private float iM;
    private float iN;
    private int iO;
    private Paint iP;
    private float iQ;
    private boolean iR;
    private a iS;
    private ValueAnimator iT;
    private int iz;
    private final Context mContext;

    public interface a {
        void cz();
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
        setWillNotDraw(false);
        init(context, attributeSet, i2);
        cD();
    }

    private void a(Canvas canvas) {
        float f2;
        float f3;
        Paint paint;
        int i2;
        RectF rectF = new RectF();
        for (int i3 = 0; i3 < this.iH; i3++) {
            int i4 = this.iz;
            if (i3 < i4) {
                float f4 = this.iJ;
                f2 = this.iN;
                f3 = i3 * (f4 + f2);
            } else {
                if (i3 == i4) {
                    float f5 = this.iJ;
                    float f6 = this.iN;
                    rectF.left = i3 * (f5 + f6);
                    rectF.right = rectF.left + f6 + ((this.iM - f6) * (1.0f - this.iI));
                    if (this.iR) {
                        this.iK.setColor(this.iF);
                        paint = this.iK;
                        i2 = (int) (((1.0f - this.iI) * 127.0f) + 127.0f);
                        paint.setAlpha(i2);
                    }
                    this.iK.setColor(this.iG);
                } else if (i3 == i4 + 1) {
                    float f7 = this.iJ;
                    float f8 = this.iN;
                    float f9 = this.iM;
                    float f10 = this.iI;
                    rectF.left = ((i3 - 1) * (f7 + f8)) + f8 + ((f9 - f8) * (1.0f - f10)) + f7;
                    rectF.right = rectF.left + (f10 * (f9 - f8)) + f8;
                    if (this.iR) {
                        this.iK.setColor(this.iF);
                        paint = this.iK;
                        i2 = (int) (255.0f - ((1.0f - this.iI) * 127.0f));
                        paint.setAlpha(i2);
                    }
                    this.iK.setColor(this.iG);
                } else {
                    float f11 = this.iJ;
                    f2 = this.iN;
                    f3 = ((i3 - 1) * (f11 + f2)) + f11 + this.iM;
                }
                rectF.top = 0.0f;
                float f12 = rectF.top;
                float f13 = this.iL;
                rectF.bottom = f12 + f13;
                canvas.drawRoundRect(rectF, f13 / 2.0f, f13 / 2.0f, this.iK);
            }
            rectF.left = f3;
            rectF.right = rectF.left + f2;
            this.iK.setColor(this.iG);
            rectF.top = 0.0f;
            float f122 = rectF.top;
            float f132 = this.iL;
            rectF.bottom = f122 + f132;
            canvas.drawRoundRect(rectF, f132 / 2.0f, f132 / 2.0f, this.iK);
        }
    }

    static /* synthetic */ boolean a(ViewPagerIndicator viewPagerIndicator, boolean z2) {
        viewPagerIndicator.iR = true;
        return true;
    }

    private void b(Canvas canvas) {
        if (this.iR || this.iz != 0) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, this.iQ, this.iL);
        float f2 = this.iL;
        canvas.drawRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, this.iP);
    }

    private void cD() {
        this.iK = new Paint(1);
        this.iK.setStyle(Paint.Style.FILL_AND_STROKE);
        this.iK.setStrokeWidth(1.0f);
        this.iK.setColor(this.iG);
        this.iP = new Paint(1);
        this.iP.setStyle(Paint.Style.FILL_AND_STROKE);
        this.iP.setStrokeWidth(1.0f);
        this.iP.setColor(this.iF);
    }

    private void cE() {
        if (this.iO <= 0) {
            setVisibility(8);
            return;
        }
        this.iT = ValueAnimator.ofFloat(this.iN, this.iM);
        this.iT.setDuration(this.iO * 1000);
        this.iT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.iQ = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.iT.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewPagerIndicator.a(ViewPagerIndicator.this, true);
                if (ViewPagerIndicator.this.iS != null) {
                    ViewPagerIndicator.this.iS.cz();
                }
            }
        });
        this.iT.start();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i2, 0);
        this.iJ = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.b.kwai.a.a(this.mContext, 5.0f));
        this.iL = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f));
        this.iM = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.b.kwai.a.a(this.mContext, 50.0f));
        this.iN = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f));
        this.iG = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.iF = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        typedArrayObtainStyledAttributes.recycle();
    }

    @RequiresApi(api = 19)
    public final void cF() {
        ValueAnimator valueAnimator = this.iT;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    public final void cG() {
        ValueAnimator valueAnimator = this.iT;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.iL : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = this.iH > 1 ? (int) (this.iM + ((r6 - 1) * (this.iJ + this.iN))) : (int) this.iM;
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setFirstAdShowTime(int i2) {
        this.iO = i2;
    }

    public void setPlayProgressListener(a aVar) {
        this.iS = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        this.iH = adapter.getCount();
        if (this.iH <= 1) {
            return;
        }
        this.iR = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
                ViewPagerIndicator.this.iz = i2;
                ViewPagerIndicator.this.iI = f2;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                ViewPagerIndicator.this.iz = i2;
                ViewPagerIndicator.this.iI = 0.0f;
                ViewPagerIndicator.this.invalidate();
            }
        });
        cE();
    }
}
