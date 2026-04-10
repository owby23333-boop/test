package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.h;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.a.d.b {
    private ImageView gQ;
    private com.kwad.components.ad.reward.j.a gR;
    private h.a gS = new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.gQ == null || com.kwad.components.ad.reward.kwai.b.gR()) {
                return;
            }
            d.this.gQ.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.gQ.setSelected(false);
                    d.this.qS.pw.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private AdTemplate mAdTemplate;
    private ImageView vr;

    private void cc() {
        boolean zIsVideoSoundEnable;
        j jVar = this.qS;
        this.mAdTemplate = jVar.mAdTemplate;
        this.gR = jVar.pw.ka();
        this.gQ.setVisibility(j.r(this.mAdTemplate) ? 8 : 0);
        this.vr.setVisibility(j.r(this.mAdTemplate) ? 0 : 8);
        KsVideoPlayConfig ksVideoPlayConfig = this.qS.mVideoPlayConfig;
        if (!this.gR.jV() && com.kwad.components.core.r.b.ar(getContext()).pY()) {
            this.vr.setSelected(true);
            this.qS.c(false, false);
            zIsVideoSoundEnable = false;
        } else if (ksVideoPlayConfig != null) {
            zIsVideoSoundEnable = ksVideoPlayConfig.isVideoSoundEnable();
            this.vr.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qS.c(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.vr.setSelected(true);
            this.qS.c(true, true);
            zIsVideoSoundEnable = true;
        }
        this.gQ.setSelected(zIsVideoSoundEnable);
        this.gR.setAudioEnabled(zIsVideoSoundEnable, false);
        this.qS.c(zIsVideoSoundEnable, false);
        this.gR.a(this.gS);
    }

    private void iF() {
        this.gQ.setOnClickListener(this);
        this.vr.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (j.b(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        } else {
            cc();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.gQ) {
            this.qS.pw.setAudioEnabled(!r0.isSelected(), true);
            this.gQ.setSelected(!r3.isSelected());
        } else {
            if (view == this.vr) {
                this.qS.pw.setAudioEnabled(!r0.isSelected(), true);
                this.vr.setSelected(!r3.isSelected());
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gQ = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.vr = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        iF();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        com.kwad.components.ad.reward.j.a aVar = this.gR;
        if (aVar != null) {
            aVar.b(this.gS);
        }
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-video-top-bar", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
