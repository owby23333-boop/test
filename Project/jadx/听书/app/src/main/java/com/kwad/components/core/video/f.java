package com.kwad.components.core.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends com.kwad.components.core.video.a implements ca.a {
    private boolean HY;
    private boolean aaI;
    private boolean aaJ;
    private View bP;
    private final ca bQ;
    private final AtomicBoolean bR;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a extends a.c {
        void onVideoPlayError(int i, int i2);
    }

    public f(Context context, AdTemplate adTemplate, com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.bQ = new ca(this);
        this.bR = new AtomicBoolean(true);
        this.HY = false;
        this.aaI = false;
        this.aaJ = false;
        this.bP = this;
    }

    public final void setShowLandingPage(boolean z) {
        this.aaJ = z;
    }

    @Override // com.kwad.components.core.video.a
    protected final void tq() {
        super.tq();
        if (this.pz != null) {
            this.pz.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        if (this.pA != null) {
            this.pA.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // com.kwad.components.core.video.a
    protected final void fA() {
        if (this.aaI) {
            super.fA();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        tV();
        aa();
    }

    private void tV() {
        this.HY = false;
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        aa();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        ab();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        ab();
    }

    private void aa() {
        if (this.bR.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewAttached");
            this.bQ.sendEmptyMessage(1);
        }
    }

    private void ab() {
        if (this.bR.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewDetached");
        this.bQ.removeCallbacksAndMessages(null);
        release();
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.HY = true;
    }

    @Override // com.kwad.components.core.video.a
    public final void ac() {
        super.ac();
    }

    @Override // com.kwad.components.core.video.a
    public final void tw() {
        super.tw();
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (!this.HY && message.what == 1) {
            if (this.aaJ) {
                this.bQ.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (bz.o(this.bP, 70)) {
                ac();
            } else {
                tw();
            }
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
