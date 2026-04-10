package com.kwad.components.ad.fullscreen.c.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.i;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView ke;
    private i.a kf = new i.a() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (c.this.ke == null || com.kwad.components.ad.reward.a.b.hC()) {
                return;
            }
            c.this.ke.post(new bg() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.this.ke.setSelected(false);
                    c.this.tm.rE.setAudioEnabled(false, false);
                }
            });
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.ke = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        dm();
    }

    private void dm() {
        this.ke.setVisibility(0);
        KsVideoPlayConfig ksVideoPlayConfig = this.tm.mVideoPlayConfig;
        if (!this.tm.rC && com.kwad.components.core.t.a.aC(getContext()).sW()) {
            this.ke.setSelected(false);
            this.tm.d(false, false);
        } else if (ksVideoPlayConfig != null) {
            this.ke.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.tm.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.ke.setSelected(true);
            this.tm.d(true, true);
        }
        this.tm.rE.a(this.kf);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.kf);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ke) {
            this.tm.rE.setAudioEnabled(!this.ke.isSelected(), true);
            this.ke.setSelected(!r3.isSelected());
        }
    }
}
