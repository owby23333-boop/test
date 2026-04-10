package com.kwad.components.ad.reward.presenter.platdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.media3.common.C;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bm;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private Animator xC;
    private Animator xD;
    private Animator xE;
    private bm xH;
    private bm xI;
    private View xw;
    private View xx;
    private View xy;
    private View xz;
    private final long xt = 1600;
    private final long xu = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private final long xv = 5000;
    private boolean xA = false;
    private boolean xB = false;
    private Animator xF = null;
    private long xG = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private Interpolator xJ = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
    private m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
        private boolean xK = false;

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.xA = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (j2 < b.this.xG || this.xK) {
                return;
            }
            this.xK = true;
            b.this.je();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.xA = true;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.xA = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.xF == null || b.this.xF.isRunning()) {
                return;
            }
            b.this.xF.start();
            b.a(b.this, (Animator) null);
        }
    };

    static /* synthetic */ Animator a(b bVar, Animator animator) {
        bVar.xF = null;
        return null;
    }

    static /* synthetic */ View b(b bVar, View view) {
        bVar.xx = null;
        return null;
    }

    static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.xB = true;
        return true;
    }

    static /* synthetic */ View c(b bVar, View view) {
        bVar.xy = null;
        return null;
    }

    static /* synthetic */ View d(b bVar, View view) {
        bVar.xz = null;
        return null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        jc();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rE.a(this.jE);
        FrameLayout frameLayoutT = this.tm.rE.kY().T(getContext());
        this.xw = frameLayoutT;
        if (frameLayoutT.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(R.id.ksad_reward_play_layout)).addView(this.xw, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.xH.getHeight();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_root_container);
        View viewJd = jd();
        this.xx = viewJd;
        frameLayout.addView(viewJd, -1, -1);
        View viewA = a(R.drawable.ksad_image_player_sweep1, frameLayout);
        this.xy = viewA;
        frameLayout.addView(viewA, layoutParams);
        View viewA2 = a(R.drawable.ksad_image_player_sweep2, frameLayout);
        this.xz = viewA2;
        frameLayout.addView(viewA2, layoutParams);
    }

    private void jc() {
        this.xH = new bm(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_start), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_start));
        this.xI = new bm(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_end), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_end));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.xA = true;
        Animator animator = this.xD;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.xC;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.xE;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.tm.rE.b(this.jE);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.xw = null;
        com.kwad.components.ad.reward.m.b bVarKY = this.tm.rE.kY();
        if (bVarKY != null) {
            bVarKY.release();
        }
    }

    private View jd() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    private View a(int i, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.ksad_image_player_sweep, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i));
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je() {
        this.xC = b(this.xw, 1600L);
        this.xD = a(this.xy, this.xz);
        this.xE = c(this.xw, 1600L);
        this.xC.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.r(b.this.xx);
                b.b(b.this, (View) null);
                if (b.this.xB) {
                    return;
                }
                b bVar = b.this;
                bVar.a(bVar.xD);
            }
        });
        this.xD.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.b(b.this, true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.xE);
                b.r(b.this.xy);
                b.r(b.this.xz);
                b.c(b.this, (View) null);
                b.d(b.this, null);
            }
        });
        this.xE.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.xE);
            }
        });
        a(this.xC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Animator animator) {
        if (!this.xA) {
            animator.start();
        } else {
            this.xF = animator;
        }
    }

    private Animator a(View view, View view2) {
        Animator animatorQ = q(view);
        Animator animatorQ2 = q(view2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, animatorQ2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorQ, animatorSet);
        return animatorSet2;
    }

    private Animator q(View view) {
        if (this.xH == null || this.xI == null) {
            jc();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", -(com.kwad.sdk.c.a.a.getScreenHeight(getContext()) + ((this.xI.getHeight() + this.xH.getHeight()) / 2)));
        float fRF = this.xI.RF() / this.xH.RF();
        float fRG = this.xI.RG() / this.xH.RG();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, fRF);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, fRG);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat, objectAnimatorOfFloat4);
        animatorSet.setInterpolator(this.xJ);
        return animatorSet;
    }

    private Animator b(View view, long j) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.xx;
        if (view2 != null) {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, ObjectAnimator.ofFloat(view2, "alpha", 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        }
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(this.xJ);
        return animatorSet;
    }

    private Animator c(View view, long j) {
        Animator animatorB = b(view, 1600L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        objectAnimatorOfFloat.setDuration(5000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorB, objectAnimatorOfFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }
}
