package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.r.j;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.i.a;
import com.kwad.sdk.utils.bk;

/* JADX INFO: loaded from: classes3.dex */
public class KsAuthorIconView extends FrameLayout implements bk.a {
    private ViewGroup AF;
    private KSCornerImageView AG;
    private KSCornerImageView AH;
    private KSCornerImageView AI;
    private TextView AJ;
    private View AK;
    private View AL;
    private ImageView AM;
    private View AN;
    private View AO;
    private View AP;
    private View AQ;
    private final bk gH;
    private KSCornerImageView zq;

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        this.gH = new bk(this);
        N(context);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gH = new bk(this);
        N(context);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.gH = new bk(this);
        N(context);
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.gH = new bk(this);
        N(context);
    }

    private void N(@NonNull Context context) {
        a.inflate(context, R.layout.ksad_author_icon, this);
        this.AF = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.zq = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.AG = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.AH = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.AI = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.AJ = (TextView) findViewById(R.id.ksad_fans_count);
        this.AL = findViewById(R.id.ksad_fans_hot_icon);
        this.AK = findViewById(R.id.ksad_author_btn_follow);
        this.AM = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.AO = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.AN = findViewById(R.id.ksad_top_layout);
        this.AQ = findViewById(R.id.ksad_author_icon_layout);
        this.AP = findViewById(R.id.ksad_top_flag_layout);
    }

    private Animator a(View view, long j2) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_icon_width));
        valueAnimatorOfFloat.addUpdateListener(f(view, false));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j2);
        animatorSet.setInterpolator(interpolatorCreate);
        animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat);
        return animatorSet;
    }

    private void a(e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), eVar.rS());
        }
    }

    private static Animator e(View view, boolean z2) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f2 = 0.9f * width;
        b.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f2);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(width, f2);
        valueAnimatorOfFloat.addUpdateListener(f(view, false));
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(interpolatorCreate);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f2, width);
        valueAnimatorOfFloat2.addUpdateListener(f(view, false));
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        valueAnimatorOfFloat2.setDuration(500L);
        valueAnimatorOfFloat2.setInterpolator(interpolatorCreate2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        return animatorSet;
    }

    private static ValueAnimator.AnimatorUpdateListener f(final View view, final boolean z2) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i2 = (int) fFloatValue;
                    layoutParams.width = i2;
                    if (!z2) {
                        layoutParams.height = i2;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    private static Animator i(View view, int i2) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(interpolatorCreate);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(interpolatorCreate2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        b.d("KsAuthorIconView", "handleMsg MSG_CHECKING");
        final Animator animatorA = a(this.AH, 900L);
        final Animator animatorA2 = a(this.AI, 1000L);
        final Animator animatorE = e(this.zq, false);
        final Animator animatorI = i(this.AN, 500);
        if (animatorI == null || animatorA == null || animatorA2 == null || animatorE == null) {
            this.gH.sendEmptyMessageDelayed(1, 500L);
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorE, animatorA, animatorA2);
        animatorSet.start();
        animatorE.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animatorA.start();
                animatorA2.start();
                animatorE.start();
                animatorI.start();
            }
        });
    }

    public final void a(e eVar) {
        j.a(eVar, this);
        this.AM.setImageResource(R.drawable.ksad_reward_follow_arrow_down);
        a(eVar, this.AH.getBackground());
        a(eVar, this.AG.getBackground());
        a(eVar, this.AI.getBackground());
        a(eVar, this.AF.getBackground());
    }

    public final void bindView(AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        String strBL = com.kwad.sdk.core.response.a.a.bL(adInfoCb);
        if (!TextUtils.isEmpty(strBL)) {
            KSImageLoader.loadImage(this.zq, strBL, adTemplate);
        }
        int iAY = com.kwad.sdk.core.response.a.a.aY(adInfoCb);
        if (com.kwad.sdk.core.response.a.a.co(d.cb(adTemplate))) {
            this.AJ.setText("直播中");
            this.AL.setVisibility(8);
            this.AK.setVisibility(8);
            if (iAY == 8) {
                this.AP.setVisibility(8);
                this.AM.setVisibility(8);
                this.AO.setVisibility(0);
            } else {
                this.AO.setVisibility(8);
                this.AM.setVisibility(0);
                this.AO.setVisibility(8);
            }
        } else {
            this.AJ.setText(com.kwad.sdk.core.response.a.a.cj(adInfoCb));
        }
        this.gH.sendEmptyMessageAtTime(1, 500L);
    }
}
