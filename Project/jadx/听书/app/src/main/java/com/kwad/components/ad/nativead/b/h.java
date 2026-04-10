package com.kwad.components.ad.nativead.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener, View.OnTouchListener {
    private MotionEvent pJ;
    private ViewGroup pO;
    private TextView pP;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pO = (ViewGroup) findViewById(R.id.ksad_video_complete_h5_container);
        this.pP = (TextView) findViewById(R.id.ksad_h5_open);
        a(this.pO, "NativePlayEndH5Presenter: R.id.ksad_video_complete_h5_container is null");
        a(this.pP, "NativePlayEndH5Presenter: R.id.ksad_h5_open is null");
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.h.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                h.this.fA();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                h.this.fB();
            }
        };
        this.pq.pr.b(this.mVideoPlayStateListener);
        ViewGroup viewGroup = this.pO;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA() {
        try {
            this.pP.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(this.pq.mAdTemplate)));
            this.pO.setOnClickListener(this);
            this.pO.setOnTouchListener(this);
            this.pO.setVisibility(0);
            this.pP.setVisibility(0);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB() {
        try {
            this.pO.setVisibility(8);
            this.pP.setVisibility(8);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.pq.px) {
            fF();
            notifyAdClick();
        }
    }

    private void fF() {
        com.kwad.components.core.e.d.a.a(new a.C0333a(getContext()).aB(this.pq.mAdTemplate).aB(2).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.h.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.pq.mAdTemplate, 2, h.this.pq.pl.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        if (this.pO != null) {
            this.pq.oW.m(this.pO);
        }
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
        if (view == this.pO) {
            fC();
            notifyAdClick();
        }
    }

    private void fC() {
        com.kwad.components.core.e.d.a.a(new a.C0333a(getContext()).aB(this.pq.mAdTemplate).b(this.pq.mApkDownloadHelper).A(this.pq.pr.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.nativead.b.h.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(h.this.pq.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, h.this.pq.pl.getTouchCoords());
            }
        }));
    }
}
