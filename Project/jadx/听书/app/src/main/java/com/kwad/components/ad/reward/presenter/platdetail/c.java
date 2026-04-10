package com.kwad.components.ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements d {
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mApkDownloadHelper = this.tm.mApkDownloadHelper;
        new h(this.mDetailVideoView, this);
        this.mDetailVideoView.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.b.a.aY(e.el(this.mAdTemplate)) ? "#B3000000" : "#4D000000"));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setClickListener(null);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            d(view, false);
        }
    }

    private void d(View view, final boolean z) {
        com.kwad.components.core.e.d.a.a(new a.C0333a(view.getContext()).aB(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.c.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c.this.L(z);
            }
        }).b(this.mApkDownloadHelper).aq(false).A(this.tm.si).aB(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "videoPlayer", new com.kwad.sdk.core.adlog.c.b().dd(z ? 85 : MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT).f(this.tm.mRootContainer.getTouchCoords()), this.tm.mReportExtData);
        this.tm.rD.cW();
    }
}
