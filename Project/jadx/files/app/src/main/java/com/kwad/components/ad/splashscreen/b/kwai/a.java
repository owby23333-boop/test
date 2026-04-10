package com.kwad.components.ad.splashscreen.b.kwai;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.splashscreen.b.e {
    private AnimatorSet DM;
    private TextView DN;
    private ViewGroup DO;
    private ViewGroup DP;

    private void initView() {
        this.DN = (TextView) findViewById(R.id.ksad_ad_developer_text);
        this.DO = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_view);
        this.DP = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
    }

    private void lF() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.DP, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.DN, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.DO, "scaleX", 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.DO, "scaleY", 0.8f, 1.0f);
        this.DM = new AnimatorSet();
        this.DM.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        this.DM.setDuration(300L);
        this.DM.start();
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        lF();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.DM;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
