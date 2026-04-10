package com.kwad.components.ad.fullscreen.b.kwai;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.a.d.b {
    private ImageView gQ;
    private com.kwad.components.ad.reward.j.a gR;
    private h.a gS = new h.a() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.gQ == null || com.kwad.components.ad.reward.kwai.b.gR()) {
                return;
            }
            c.this.gQ.post(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.c.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.gQ.setSelected(false);
                    c.this.qS.pw.setAudioEnabled(false, false);
                }
            });
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };

    private void cc() {
        ImageView imageView;
        this.gR = this.qS.pw.ka();
        boolean z2 = false;
        this.gQ.setVisibility(0);
        KsVideoPlayConfig ksVideoPlayConfig = this.qS.mVideoPlayConfig;
        if (!this.gR.jV() && com.kwad.components.core.r.b.ar(getContext()).pY()) {
            imageView = this.gQ;
        } else {
            if (ksVideoPlayConfig != null) {
                this.gQ.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
                this.qS.c(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
                this.gR.a(this.gS);
            }
            imageView = this.gQ;
            z2 = true;
        }
        imageView.setSelected(z2);
        this.qS.c(z2, z2);
        this.gR.a(this.gS);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (j.c(this.qS)) {
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
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gQ = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.gQ.setOnClickListener(this);
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
