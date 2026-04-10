package com.kwad.components.ad.fullscreen.c.a;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.media3.session.MediaController;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ca;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements ca.a {
    private ca bQ;
    private m jE = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.jX) {
                return;
            }
            a.this.bQ.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            if (!a.this.tm.rE.kW()) {
                a.this.a(j, j2);
                a.this.jY = j2;
            } else if (j2 > 800) {
                a.this.jY = j2;
                if (a.this.jY > j) {
                    a.this.jV.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.jW.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 0.0f);
                    a.this.jW.setLayoutParams(marginLayoutParams);
                }
                a.this.a(j, j2);
                a.a(a.this, true);
            }
        }
    };
    private TextView jV;
    private View jW;
    private boolean jX;
    private long jY;
    private AdInfo mAdInfo;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.jX = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jV = (TextView) findViewById(R.id.ksad_video_count_down);
        this.jW = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.bQ = new ca(this);
        dm();
        if (this.tm.rE.kW()) {
            G(30);
        }
    }

    private void dm() {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        this.mAdInfo = adInfoEl;
        this.jV.setText(String.valueOf(com.kwad.sdk.core.response.b.a.L(adInfoEl)));
        this.jV.setVisibility(0);
        this.tm.rE.a(this.jE);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        this.jX = false;
        this.bQ.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        int i = (int) (((j - j2) / 1000.0f) + 0.5f);
        if (i <= 0) {
            i = 1;
        }
        G(i);
    }

    private void G(int i) {
        this.jV.setText(String.valueOf(i));
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.tm.gV() || this.tm.gU()) {
                this.bQ.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            long j = this.jY + 500;
            this.jY = j;
            if (j > MediaController.RELEASE_UNBIND_TIMEOUT_MS) {
                this.jV.setVisibility(8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jW.getLayoutParams();
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(getContext(), 0.0f);
                this.jW.setLayoutParams(marginLayoutParams);
                return;
            }
            a(MediaController.RELEASE_UNBIND_TIMEOUT_MS, j);
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
