package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class t {
    @Nullable
    public static Animator a(AdTemplate adTemplate, View view, DetailVideoView detailVideoView) {
        ValueAnimator valueAnimatorA;
        if (detailVideoView == null || (valueAnimatorA = detailVideoView.a(adTemplate, (int) (detailVideoView.getHeight() - detailVideoView.getContext().getResources().getDimension(R.dimen.ksad_play_again_end_height)), (ValueAnimator.AnimatorUpdateListener) null)) == null) {
            return null;
        }
        Animator animatorS = s(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(valueAnimatorA.getDuration());
        animatorSet.setInterpolator(valueAnimatorA.getInterpolator());
        animatorSet.playTogether(valueAnimatorA, animatorS);
        return animatorSet;
    }

    @Nullable
    public static Animator a(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView, View view) {
        int width;
        if (view == null || view.getLayoutParams() == null || (width = view.getWidth()) == 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", -width).setDuration(300L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        if (com.kwad.sdk.core.response.a.a.aP(com.kwad.sdk.core.response.a.d.cb(adTemplate)) || detailVideoView == null) {
            return duration;
        }
        ValueAnimator valueAnimatorAI = detailVideoView.aI(width);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, valueAnimatorAI);
        return animatorSet;
    }

    @Nullable
    private static Animator s(View view) {
        if (view == null || view.getHeight() == 0) {
            return null;
        }
        return ObjectAnimator.ofFloat(view, "translationY", view.getContext().getResources().getDimension(R.dimen.ksad_play_again_end_animate_margin));
    }
}
