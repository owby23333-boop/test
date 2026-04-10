package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.media3.common.C;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class RewardGuideSlideUp extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimatorSet f945a;
    private ImageView dl;
    private final AnimatorSet e;
    private ImageView g;
    private final AnimatorSet gc;
    private final AnimatorSet m;
    private ImageView z;

    public RewardGuideSlideUp(Context context) {
        super(context);
        this.gc = new AnimatorSet();
        this.m = new AnimatorSet();
        this.e = new AnimatorSet();
        z(context);
    }

    private void z(Context context) {
        if (context == null) {
            context = zw.getContext();
        }
        addView(com.bytedance.sdk.openadsdk.res.gc.kb(context));
        this.z = (ImageView) findViewById(2114387644);
        this.g = (ImageView) findViewById(2114387939);
        this.dl = (ImageView) findViewById(2114387639);
    }

    public void z() {
        this.f945a = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.z, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.z, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.z, "translationY", 0.0f, oq.dl(getContext(), -110.0f));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, oq.dl(getContext(), 110.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RewardGuideSlideUp.this.g.getLayoutParams();
                layoutParams.height = num.intValue();
                RewardGuideSlideUp.this.g.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.g, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.dl, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.dl, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.dl, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.dl, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.dl, "translationY", 0.0f, oq.dl(getContext(), -110.0f));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.gc.setDuration(50L);
        this.e.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.m.setDuration(50L);
        this.gc.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.m.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.e.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.f945a.playSequentially(this.m, this.e, this.gc);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.f945a;
    }

    public void g() {
        try {
            AnimatorSet animatorSet = this.f945a;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.m;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.gc;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.e;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable th) {
            wp.dl(th.getMessage());
        }
    }
}
