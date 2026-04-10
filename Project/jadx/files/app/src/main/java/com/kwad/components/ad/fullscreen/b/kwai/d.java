package com.kwad.components.ad.fullscreen.b.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.a.d.b {
    private ImageView gV;
    private TextView gW;
    private AdTemplate mAdTemplate;
    private View gX = null;
    private com.kwad.components.ad.reward.d.e gY = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void cg() {
            d.this.cf();
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            d.this.f(j2);
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.3
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            d.this.f(j3);
        }
    };

    private void cc() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        this.mAdTemplate = jVar.mAdTemplate;
        jVar.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qS.pF.add(this.gY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf() {
        if (this.gX.getVisibility() == 0) {
            return;
        }
        this.gX.setAlpha(0.0f);
        this.gX.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.gX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
        this.gX.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.c(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        } else {
            cc();
        }
    }

    public final void f(long j2) {
        if (j2 >= com.kwad.sdk.core.response.a.a.ad(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            cf();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.gX) {
            com.kwad.components.ad.reward.presenter.e.a(this.qS, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        ImageView imageView;
        int i2;
        View view;
        super.onCreate();
        this.gV = (ImageView) findViewById(R.id.ksad_skip_icon);
        this.gW = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.components.ad.fullscreen.kwai.b.bP())) {
            if (com.kwad.components.ad.fullscreen.kwai.b.bO() == 0) {
                imageView = this.gV;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.gV;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            this.gW.setVisibility(8);
            view = this.gV;
        } else {
            this.gW.setText(com.kwad.components.ad.fullscreen.kwai.b.bP());
            this.gV.setVisibility(8);
            view = this.gW;
        }
        this.gX = view;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.qS.pF.remove(this.gY);
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (com.kwad.components.core.webview.a.i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
