package com.kwad.components.ad.reflux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reflux.KsRefluxContentView;
import com.kwad.components.core.g.d;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes2.dex */
public class KsRefluxView extends FrameLayout implements View.OnClickListener, KsRefluxContentView.a {

    @Nullable
    private KsAdWebView cS;
    private KsRefluxNativeView of;
    private View og;
    private ImageView oh;
    private View oi;
    private a oj;
    private volatile boolean ok;

    public interface a {
        void dP();

        void fl();
    }

    public KsRefluxView(@NonNull Context context) {
        super(context);
        this.ok = false;
        N(context);
    }

    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ok = false;
        N(context);
    }

    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ok = false;
        N(context);
    }

    @RequiresApi(api = 21)
    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.ok = false;
        N(context);
    }

    private void N(@NonNull Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_reflux, this);
        this.og = findViewById(R.id.ksad_reflux_title_bar);
        this.oh = (ImageView) findViewById(R.id.ksad_reflux_back);
        this.cS = (KsAdWebView) findViewById(R.id.ksad_reflux_webview);
        this.of = (KsRefluxNativeView) findViewById(R.id.ksad_reflux_native);
        this.oi = findViewById(R.id.ksad_reflux_close);
        this.oi.setOnClickListener(this);
        this.oh.setOnClickListener(this);
        ((KsRefluxContentView) findViewById(R.id.ksad_reflux_content)).setContentViewListener(this);
    }

    @Nullable
    private Animator a(final View view, final View view2) {
        if (view == null || view2 == null || view.getMeasuredHeight() <= 0) {
            return null;
        }
        Drawable background = view2.getBackground();
        if (!(background instanceof GradientDrawable)) {
            return null;
        }
        final GradientDrawable gradientDrawable = (GradientDrawable) background;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(view.getMeasuredHeight(), 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reflux.KsRefluxView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = iIntValue;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getResources().getDimension(R.dimen.ksad_reflux_title_bar_corner), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reflux.KsRefluxView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.d("KsRefluxView", "actionBar radii value: " + fFloatValue);
                gradientDrawable.setCornerRadii(new float[]{fFloatValue, fFloatValue, fFloatValue, fFloatValue, 0.0f, 0.0f, 0.0f, 0.0f});
                view2.setBackground(gradientDrawable);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        animatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfFloat);
        return animatorSet;
    }

    @MainThread
    private void fj() {
        if (fk() || this.ok) {
            return;
        }
        Animator animatorA = a(this.oh, this.og);
        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reflux.KsRefluxView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                KsRefluxView.this.ok = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                KsRefluxView.this.ok = true;
            }
        });
        animatorA.start();
    }

    private boolean fk() {
        ImageView imageView = this.oh;
        return imageView != null && imageView.getMeasuredHeight() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator m(final View view) {
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight == 0) {
            return null;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(measuredHeight, getContext().getResources().getDimensionPixelOffset(R.dimen.ksad_reflux_back_height));
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reflux.KsRefluxView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = iIntValue;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return valueAnimatorOfInt;
    }

    public final void c(final Animator.AnimatorListener animatorListener) {
        setVisibility(0);
        this.oh.post(new Runnable() { // from class: com.kwad.components.ad.reflux.KsRefluxView.1
            @Override // java.lang.Runnable
            public final void run() {
                KsRefluxView ksRefluxView = KsRefluxView.this;
                Animator animatorM = ksRefluxView.m(ksRefluxView.oh);
                if (animatorM != null) {
                    Animator.AnimatorListener animatorListener2 = animatorListener;
                    if (animatorListener2 != null) {
                        animatorM.addListener(animatorListener2);
                    }
                    animatorM.start();
                }
                if (KsRefluxView.this.oj != null) {
                    KsRefluxView.this.oj.fl();
                }
            }
        });
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxContentView.a
    public final boolean ff() {
        return fk();
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxContentView.a
    public final boolean fg() {
        if (fk()) {
            return false;
        }
        fj();
        return true;
    }

    public KsRefluxNativeView getNativeView() {
        return this.of;
    }

    public KsAdWebView getWebView() {
        return this.cS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.oj == null) {
            return;
        }
        if (view.equals(this.oi)) {
            this.oj.dP();
        } else if (view.equals(this.oh)) {
            fj();
        }
    }

    public void setInnerAdInteractionListener(d dVar) {
        KsRefluxNativeView ksRefluxNativeView = this.of;
        if (ksRefluxNativeView != null) {
            ksRefluxNativeView.setInnerAdInteractionListener(dVar);
        }
    }

    public void setViewListener(a aVar) {
        this.oj = aVar;
    }

    public final void z(boolean z2) {
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(z2 ? 0 : 4);
        }
        this.of.setVisibility(z2 ? 8 : 0);
    }
}
