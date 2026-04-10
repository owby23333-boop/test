package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private DetailVideoView mDetailVideoView;
    private MotionEvent pJ;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.i.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
            }
        };
        this.pq.pr.b(this.mVideoPlayStateListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setOnClickListener(this);
            this.mDetailVideoView.setOnTouchListener(this);
        }
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setOnClickListener(null);
            this.mDetailVideoView.setOnTouchListener(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.pq.px && view == this.mDetailVideoView) {
            fF();
            notifyAdClick();
        }
    }

    private void fF() {
        com.kwad.components.core.e.d.a.a(new a.C0333a(getContext()).aB(this.pq.mAdTemplate).b(this.pq.mApkDownloadHelper).A(this.pq.pr.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.i.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.pq.mAdTemplate, 2, i.this.pq.pl.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.pq.oW.m(this.mDetailVideoView);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.pJ = MotionEvent.obtain(motionEvent);
        } else if (action == 1 || action == 3) {
            if (com.kwad.sdk.utils.b.a(this.pJ, motionEvent)) {
                if (this.pq.pw && (motionEvent2 = this.pJ) != null && com.kwad.sdk.utils.b.a(motionEvent2, motionEvent, this.pq.mAdTemplate)) {
                    n(view);
                }
                z = true;
            }
            this.pJ = null;
        }
        return z;
    }

    private void n(View view) {
        if (view == this.mDetailVideoView) {
            fC();
            notifyAdClick();
        }
    }

    private void fC() {
        com.kwad.components.core.e.d.a.a(new a.C0333a(getContext()).aB(this.pq.mAdTemplate).b(this.pq.mApkDownloadHelper).A(this.pq.pr.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.i.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.pq.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, i.this.pq.pl.getTouchCoords());
            }
        }));
    }
}
