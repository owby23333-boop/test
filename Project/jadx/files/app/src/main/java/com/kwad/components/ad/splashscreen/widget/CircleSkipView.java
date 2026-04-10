package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class CircleSkipView extends KSFrameLayout implements a {
    private float ED;
    private float EE;
    private int EF;
    private ValueAnimator EG;
    private boolean EH;
    private SkipView.a EI;
    private long EJ;
    private float EK;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;
    private boolean sP;

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint();
        this.ED = 270.0f;
        this.EE = 360.0f;
        this.radius = 0;
        this.EF = 0;
        this.EH = false;
        this.EJ = 0L;
        this.EK = 0.0f;
        this.padding = 0;
        this.sP = true;
        ac(context);
    }

    static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z2) {
        circleSkipView.EH = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i2) {
        SkipView.a aVar = this.EI;
        if (aVar != null) {
            aVar.ac(i2);
        }
    }

    private void ac(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ad(context);
        addView(ae(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.EI != null) {
                    CircleSkipView.this.EI.le();
                }
            }
        });
    }

    private void ad(Context context) {
        this.EF = com.kwad.sdk.b.kwai.a.a(context, 2.0f);
        int iA = com.kwad.sdk.b.kwai.a.a(context, 32.0f);
        int i2 = this.EF;
        this.radius = iA - i2;
        this.padding = i2 / 2;
        int i3 = this.padding;
        int i4 = this.radius;
        this.mRectF = new RectF(i3, i3, i4 + i3, i4 + i3);
    }

    private static TextView ae(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    private void d(final int i2, final boolean z2) {
        this.EG = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.EG.setDuration(i2);
        this.EG.setInterpolator(new LinearInterpolator());
        this.EG.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.EK != 1.0f || CircleSkipView.this.EI == null) {
                    return;
                }
                CircleSkipView.this.EI.lf();
            }
        });
        this.EG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.EK = fFloatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.ab((int) ((i2 / 1000) * circleSkipView.EK));
                if (z2) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f2 = fFloatValue * 360.0f;
                    CircleSkipView.this.ED = 270.0f - f2;
                    CircleSkipView.this.EE = 360.0f - f2;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    private void lM() {
        this.EH = true;
        ValueAnimator valueAnimator = this.EG;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.EJ);
            this.EG.start();
        }
    }

    private void lN() {
        this.EH = false;
        ValueAnimator valueAnimator = this.EG;
        if (valueAnimator != null) {
            this.EJ = valueAnimator.getCurrentPlayTime();
            this.EG.cancel();
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.EF);
        paint.setColor(-1);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.EF);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sP = com.kwad.sdk.core.response.a.a.cc(adInfo);
        boolean zCd = com.kwad.sdk.core.response.a.a.cd(adInfo);
        if (this.sP) {
            setVisibility(0);
        }
        d(splashSkipViewModel.skipSecond * 1000, zCd);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int af(int i2) {
        getLayoutParams().height = com.kwad.sdk.b.kwai.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bn() {
        lN();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.EF, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.EH) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.ED, -this.EE, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(SkipView.a aVar) {
        this.EI = aVar;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void u(AdInfo adInfo) {
        lN();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void v(AdInfo adInfo) {
        lM();
    }
}
