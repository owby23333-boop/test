package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.splashscreen.presenter.e {
    private AnimatorSet If;
    private TextView Ig;
    private ViewGroup Ih;
    private ViewGroup Ii;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        mE();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.If;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    private void mE() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.Ii, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.Ig, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.Ih, "scaleX", 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.Ih, "scaleY", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.If = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        this.If.setDuration(300L);
        this.If.start();
    }

    private void initView() {
        this.Ig = (TextView) findViewById(R.id.ksad_ad_developer_text);
        this.Ih = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_view);
        this.Ii = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
    }
}
