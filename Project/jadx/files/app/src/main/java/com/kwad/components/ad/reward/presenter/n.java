package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends a implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private static long sM = 300;
    private ImageView fo;
    private ViewGroup sN;
    private TextView sO;
    private boolean sP;
    private float sQ;
    private WeakReference<View> sR;
    private q sS;
    private boolean sT = false;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.n.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            n.this.hide();
        }
    };

    public n(q qVar) {
        this.sS = qVar;
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        int dimensionPixelSize;
        if (layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.sN.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                dimensionPixelSize = this.sN.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom_without_actionbar);
            } else {
                int dimensionPixelSize2 = this.sN.getResources().getDimensionPixelSize(R.dimen.ksad_reward_playable_pre_tips_margin_bottom);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.sR;
                    View view = weakReference != null ? weakReference.get() : null;
                    int height = marginLayoutParams2.height;
                    if (height <= 0 && view != null) {
                        height = view.getHeight();
                    }
                    marginLayoutParams.bottomMargin = height + marginLayoutParams2.bottomMargin + dimensionPixelSize2;
                    this.sN.setLayoutParams(marginLayoutParams);
                }
                dimensionPixelSize = layoutParams.height + dimensionPixelSize2;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.sN.setLayoutParams(marginLayoutParams);
        }
    }

    private synchronized void hQ() {
        if (this.sT) {
            return;
        }
        com.kwad.sdk.core.report.a.d(this.qS.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.i().bh(192).R(this.qS.pw.getPlayDuration()));
        this.sT = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator hR() {
        ValueAnimator valueAnimatorOfArgb;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.sN, "translationX", getContext().getResources().getDimension(R.dimen.ksad_reward_playable_pre_tips_transx));
        Drawable background = this.fo.getBackground();
        if (background instanceof ColorDrawable) {
            final ColorDrawable colorDrawable = (ColorDrawable) background;
            valueAnimatorOfArgb = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg), getContext().getResources().getColor(R.color.ksad_reward_main_color));
            valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.n.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    colorDrawable.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else {
            valueAnimatorOfArgb = null;
        }
        animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfArgb, ObjectAnimator.ofFloat(this.sO, "alpha", 0.0f, 1.0f));
        animatorSet.setDuration(sM);
        return animatorSet;
    }

    private void initView() {
        ViewGroup viewGroup = this.sN;
        if (viewGroup == null) {
            return;
        }
        this.fo = (ImageView) viewGroup.findViewById(R.id.ksad_playabel_pre_tips_icon);
        this.fo.setBackgroundColor(getContext().getResources().getColor(R.color.ksad_playable_pre_tips_icon_bg));
        this.sO = (TextView) this.sN.findViewById(R.id.ksad_playabel_pre_tips_text);
        this.sN.setOnClickListener(this);
    }

    public final void M(boolean z2) {
        ViewGroup viewGroup = this.sN;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        hQ();
        WeakReference<View> weakReference = this.sR;
        if (weakReference != null && weakReference.get() != null) {
            a(this.sR.get().getLayoutParams());
        }
        this.sN.setVisibility(0);
        if (z2) {
            this.sN.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.hR().start();
                }
            }, com.anythink.expressad.exoplayer.i.a.f9492f);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.sR = new WeakReference<>(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        com.kwad.sdk.core.d.b.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
        a(layoutParams);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.sN == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playable_pre_tips_stub);
            this.sN = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_playable_pre_tips_root));
            initView();
        }
        if (this.qS.gg()) {
            a(new ViewGroup.LayoutParams(-1, this.sN.getResources().getDimensionPixelSize(R.dimen.ksad_reward_js_actionbar_height)));
        } else {
            this.qS.pz.a(this);
        }
        this.qS.b(this.mPlayEndPageListener);
    }

    public final void hide() {
        ViewGroup viewGroup = this.sN;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewGroup viewGroup = this.sN;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.kwad.components.ad.reward.b.fz().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
        com.kwad.sdk.core.report.a.a(this.qS.mAdTemplate, new com.kwad.sdk.core.report.i().bh(192).R(this.qS.pw.getPlayDuration()));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sQ = com.kwad.components.ad.reward.kwai.b.gU();
        this.sP = !com.kwad.components.ad.reward.kwai.b.gW() && com.kwad.components.ad.reward.kwai.b.gV();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.c(this.mPlayEndPageListener);
        this.qS.pz.b(this);
    }
}
