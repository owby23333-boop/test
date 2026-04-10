package com.kwad.components.ad.fullscreen.b.kwai;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bk;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.a.d.b, bk.a {
    private TextView gF;
    private View gG;
    private bk gH;
    private boolean gI;
    private long gJ;
    private AdInfo mAdInfo;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.gI) {
                return;
            }
            a.this.gH.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            if (j2 > 800) {
                a.this.gJ = j2;
                if (a.this.gJ > 30000) {
                    a.this.gF.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.gG.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(a.this.getContext(), 0.0f);
                    a.this.gG.setLayoutParams(marginLayoutParams);
                }
                a.this.a(30000L, j2);
                a.a(a.this, true);
            }
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            a.this.a(j2, j3);
            a.this.gJ = j3;
        }
    };

    private void A(int i2) {
        this.gF.setText(String.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, long j3) {
        A(Math.max((int) (((j2 - j3) / 1000.0f) + 0.5f), 0));
    }

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.gI = true;
        return true;
    }

    private void cc() {
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        this.gF.setText(String.valueOf(com.kwad.sdk.core.response.a.a.F(this.mAdInfo)));
        this.gF.setVisibility(0);
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.qS.gp() || this.qS.go()) {
                this.gH.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.gJ += 500;
            long j2 = this.gJ;
            if (j2 <= 30000) {
                a(30000L, j2);
                this.gH.sendEmptyMessageDelayed(1, 500L);
            } else {
                this.gF.setVisibility(8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gG.getLayoutParams();
                marginLayoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(getContext(), 0.0f);
                this.gG.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.gH = new bk(this);
        if (com.kwad.components.ad.reward.j.c(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
            return;
        }
        cc();
        if (this.qS.pw.jY()) {
            A(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gF = (TextView) findViewById(R.id.ksad_video_count_down);
        this.gG = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.gI = false;
        this.gH.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (com.kwad.components.core.webview.a.i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
