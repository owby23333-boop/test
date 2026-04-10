package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends w implements View.OnClickListener {
    private TextView hb;
    private com.kwad.components.ad.reward.j qS;

    public interface a {
        void hO();
    }

    public g(com.kwad.components.ad.reward.j jVar) {
        this.qS = jVar;
    }

    private static Animator p(View view) {
        if (view == null) {
            return null;
        }
        int dimensionPixelSize = view.getContext().getResources().getDimensionPixelSize(R.dimen.ksad_live_card_tips_animation_y);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", -dimensionPixelSize).setDuration(500L);
        duration.setInterpolator(interpolatorCreate);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(2500L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f).setDuration(500L);
        duration3.setInterpolator(interpolatorCreate);
        animatorSet.playSequentially(duration, duration2, duration3);
        return animatorSet;
    }

    public final void a(final a aVar, long j2) {
        final Animator animatorP = p(this.sN);
        if (animatorP == null) {
            aVar.hO();
        } else {
            animatorP.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.g.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.hO();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.hO();
                    }
                }
            });
            this.sN.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    animatorP.start();
                }
            }, 500L);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void a(v vVar) {
        String str;
        TextView textView;
        super.a(vVar);
        AdTemplate adTemplate = vVar.getAdTemplate();
        if (adTemplate == null || (str = com.kwad.sdk.core.response.a.b.bJ(adTemplate).title) == null || (textView = this.hb) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void e(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.ksad_card_tips_view, R.id.ksad_card_tips_root);
        if (this.hb == null) {
            this.hb = (TextView) this.sN.findViewById(R.id.ksad_card_tips_title);
        }
        this.sN.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.k.w, com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.sN;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.sN)) {
            com.kwad.components.ad.reward.j jVar = this.qS;
            jVar.a(1, jVar.mContext, 1, 1);
        }
    }
}
