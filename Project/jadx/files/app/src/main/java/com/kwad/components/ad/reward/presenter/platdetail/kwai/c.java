package com.kwad.components.ad.reward.presenter.platdetail.kwai;

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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.a.d.b {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private ImageView vm;
    private TextView vn;
    private boolean vo = false;
    private View oi = null;
    private long vp = -1;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (c.this.vp >= 0) {
                if (j2 > Math.min(c.this.vp, com.kwad.sdk.core.response.a.a.Y(c.this.mAdInfo))) {
                    c.this.iE();
                }
            }
        }
    };
    private final i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            if (c.this.vp >= 0) {
                if (j3 > Math.min(Math.min(c.this.vp, com.kwad.sdk.core.response.a.a.Y(c.this.mAdInfo)), j2)) {
                    c.this.iE();
                }
            }
        }
    };
    private final com.kwad.components.ad.reward.d.e gY = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.3
        @Override // com.kwad.components.ad.reward.d.e
        public final void cg() {
            c.a(c.this, true);
            c.this.iE();
        }
    };

    static /* synthetic */ boolean a(c cVar, boolean z2) {
        cVar.vo = true;
        return true;
    }

    private void cc() {
        this.mAdTemplate = this.qS.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qS.pF.add(this.gY);
        this.vp = com.kwad.sdk.core.response.a.a.X(this.mAdInfo);
        this.oi.setVisibility(this.vp == 0 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE() {
        if (this.oi.getVisibility() == 0) {
            return;
        }
        this.oi.setAlpha(0.0f);
        this.oi.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.oi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        } else {
            cc();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.oi) {
            com.kwad.components.ad.reward.presenter.e.a(this.qS, this.vo);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        ImageView imageView;
        int i2;
        View view;
        super.onCreate();
        this.vm = (ImageView) findViewById(R.id.ksad_detail_close_btn);
        this.vn = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (TextUtils.isEmpty(com.kwad.components.ad.reward.kwai.b.gP())) {
            if (com.kwad.components.ad.reward.kwai.b.gO() == 0) {
                imageView = this.vm;
                i2 = R.drawable.ksad_page_close;
            } else {
                imageView = this.vm;
                i2 = R.drawable.ksad_video_skip_icon;
            }
            imageView.setImageResource(i2);
            view = this.vm;
        } else {
            this.vn.setText(com.kwad.components.ad.reward.kwai.b.gP());
            view = this.vn;
        }
        this.oi = view;
        this.oi.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qS.pF.remove(this.gY);
        this.oi.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (com.kwad.components.core.webview.a.i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
